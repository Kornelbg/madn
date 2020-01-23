package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Array;

public class Spiel extends AppCompatActivity {


    FirebaseAuth firebaseA1uth;
    private TextView textViewUser;

    private ImageView spielfeld;
    public FrameLayout spielbereich;

    private Display display;
    private Point size;

    public int bildschirmBreite = 0;
    public int bildschirmHoehe = 0;

    public int SpielfeldHoeheBreite = 0;
    public int rSPielfeldHoeheBreite = 0;

    public int bildschirmBreiteMitte = 0;
    public int bildschirmHoeheMitte = 0;

    private ImageView feld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        textViewUser = (TextView) findViewById(R.id.textViewUser);
/*
        Spieler        FirebaseUser user = firebaseAuth.getCurrentUser();


        if (firebaseAuth.getCurrentUser() == null)
        {
            startActivity(new Intent(this, MainActivity.class) );
            finish();

        }

 */

        //textViewUser.setText("Willkommen "+ user.getEmail());
        Intent spiel = getIntent();

        String spieltyp = spiel.getStringExtra("Spieltyp");




       // spielbereich = findViewById(R.id.test);

        String[] spieler = {
                spiel.getStringExtra("spieler_1"),
                spiel.getStringExtra("spieler_2"),
                spiel.getStringExtra("spieler_3"),
                spiel.getStringExtra("spieler_4")};

        createSpiel(spieler);
    }

    public void createSpiel(String[] spieler) {

        display = getWindowManager().getDefaultDisplay();
       size = new Point();
        display.getSize(size);
        bildschirmHoehe = size.y;
        bildschirmBreite = size.x;

        bildschirmHoeheMitte = bildschirmHoehe / 2;

        SpielfeldHoeheBreite = (int)(bildschirmHoehe * 0.95);
        rSPielfeldHoeheBreite = (int)(bildschirmHoehe * 0.95 / 2);




        spielfeld = new ImageView(this);
        spielfeld.setImageResource(R.drawable.spielfeld1);
        spielbereich = findViewById(R.id.test);

        FrameLayout.LayoutParams parmscharakter = new FrameLayout.LayoutParams(SpielfeldHoeheBreite,  SpielfeldHoeheBreite);
        parmscharakter.leftMargin = (bildschirmBreiteMitte + rSPielfeldHoeheBreite);
        parmscharakter.bottomMargin = (bildschirmHoeheMitte - rSPielfeldHoeheBreite) ;
        parmscharakter.gravity = Gravity.BOTTOM + Gravity.LEFT;
        spielbereich.addView(spielfeld, parmscharakter);


        CreateSpiel main = new CreateSpiel(spieler, bildschirmBreiteMitte, bildschirmHoeheMitte, SpielfeldHoeheBreite);

        feld = new ImageView(this);

        // muss noch errechnet werden
        FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams(25, 25);

        for(int i = 0; i < 76; i++) {

            int x = main.getFelder(i).getX();
            int y = main.getFelder(i).getY();

            switch (main.getFeldbesitzer(i)) {
                case 0 : feld.setImageResource(R.drawable.feld);
                    break;
                case 1: feld.setImageResource(R.drawable.blau);
                    break;
                case 2: feld.setImageResource(R.drawable.gelb);
                    break;
                case 3: feld.setImageResource(R.drawable.gruen);
                    break;
                case 4: feld.setImageResource(R.drawable.orange);
                    break;
            }

            feldParams.leftMargin = (x);
            feldParams.bottomMargin = (y) ;
            feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;
            spielbereich.addView(feld, feldParams);

            feld = null;
            feldParams = null;
        }
    }


    private void   mSaveSharedPreferencesSpielSPeichern() {

        // zwischenspeichern falls das Spiel vor beändigung verlassen wird
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerDichNicht", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySPR.edit();

        editor.putString("SINGLE_PLAYER_GUEST", "");

        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mSaveSharedPreferencesSpielSPeichern();
    }


}
