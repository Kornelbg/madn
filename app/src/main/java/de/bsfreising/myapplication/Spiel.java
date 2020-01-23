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
        bildschirmBreiteMitte = bildschirmBreite / 2;

        SpielfeldHoeheBreite = (int)(bildschirmHoehe * 0.95);
        rSPielfeldHoeheBreite = (int)(bildschirmHoehe * 0.95 / 2);




        spielfeld = new ImageView(this);
        spielfeld.setImageResource(R.drawable.spielfeld1);
        spielbereich = findViewById(R.id.test);

        FrameLayout.LayoutParams parmscharakter = new FrameLayout.LayoutParams(SpielfeldHoeheBreite,  SpielfeldHoeheBreite);
        parmscharakter.leftMargin = (bildschirmBreiteMitte - rSPielfeldHoeheBreite);
        parmscharakter.bottomMargin = (bildschirmHoeheMitte - rSPielfeldHoeheBreite) ;
        parmscharakter.gravity = Gravity.BOTTOM + Gravity.LEFT;
        spielbereich.addView(spielfeld, parmscharakter);


        CreateSpiel main = new CreateSpiel(spieler, bildschirmBreiteMitte, bildschirmHoeheMitte, SpielfeldHoeheBreite);




        // muss noch errechnet werden

        for(int i = 0; i < 72; i++) {

            //Feld aa = new Feld(1);
            // aa = main.getFelder(i);
            //int x = aa.getFeldbesitzer();

          int x = main.getFelder(i).getX();
          int y = main.getFelder(i).getY();

            feld = new ImageView(this);

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

            //feld.setImageResource(R.drawable.gruen);
            FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams((int) (SpielfeldHoeheBreite / 16.5), (int) (SpielfeldHoeheBreite/16.5));

            feldParams.leftMargin = (x);
            feldParams.bottomMargin = (y) ;
            feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;

            System.out.println(x + "  " + y + "Test12335" + "   "+ main.getFeldbesitzer(i) + " ");

            spielbereich.addView(feld, feldParams);
/*
            feld = null;
            feldParams = null;

            */


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
