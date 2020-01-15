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

    FirebaseAuth firebaseAuth;
    private TextView textViewUser;

    private ImageView spielfeld;
    public FrameLayout spielbereich;

    private Display display;
    private Point size;

    private int bildschirmBreite;
    private int bildschirmHoehe;

    private int bildschirmBreiteMitte = 0;
    private int bildschirmHoeheMitte = 0;

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

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        bildschirmHoehe = size.y;
        bildschirmBreite = size.x;

        bildschirmHoeheMitte = bildschirmHoehe / 2;
        bildschirmBreiteMitte = bildschirmBreite / 2;


        spielbereich = findViewById(R.id.test);

        String[] spieler = {
                spiel.getStringExtra("spieler_1"),
                spiel.getStringExtra("spieler_2"),
                spiel.getStringExtra("spieler_3"),
                spiel.getStringExtra("spieler_4")};

        createSpiel(spieler);


/*
        Spielfeld main = new Spielfeld(bildschirmBreiteMitte, bildschirmHoeheMitte, bildschirmHoehe);



        textViewUser.setText(main.getBildschirmBreiteMitte()+ "Mitte-Breite " + main.getBildschirmHoeheMitte() + "Höhe-Breite");

        spielfeld = new ImageView(this);
        spielfeld.setImageResource(R.drawable.spielfeld1);


        spielbereich = findViewById(R.id.test);

        FrameLayout.LayoutParams parmscharakter = new FrameLayout.LayoutParams((int) (bildschirmHoehe * 0.95),  (int)(bildschirmHoehe * 0.95) );
        parmscharakter.leftMargin = (bildschirmBreiteMitte -(((int) (bildschirmHoehe * 0.95)) /2));
        parmscharakter.bottomMargin = (bildschirmHoeheMitte -(((int) (bildschirmHoehe * 0.95)) /2)) ;
        parmscharakter.gravity = Gravity.BOTTOM + Gravity.LEFT;
        spielbereich.addView(spielfeld, parmscharakter);

        */

    }

    public void createSpiel(String[] spieler) {

          CreateSpiel main = new CreateSpiel(spieler, bildschirmBreiteMitte, bildschirmHoeheMitte, bildschirmHoehe);

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
