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

    private int bildschirmBreite = 0;
    private int bildschirmHoehe = 0;

    private int SpielfeldHoeheBreite = 0;
    private int rSPielfeldHoeheBreite = 0;

    private int bildschirmBreiteMitte = 0;
    private int bildschirmHoeheMitte = 0;

    private String[][] spieler;
    private Spieler[] neueSpieler;

    private ImageView feld;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent spiel = getIntent();
        String[][] spieler = { {spiel.getStringExtra("spieler_1T")},{spiel.getStringExtra("spieler_1N")},
                {spiel.getStringExtra("spieler_2T")},{spiel.getStringExtra("spieler_2N")},
                {spiel.getStringExtra("spieler_3T")},{spiel.getStringExtra("spieler_3N")},
                {spiel.getStringExtra("spieler_4T")},{spiel.getStringExtra("spieler_4N")},};
        this.spieler = spieler;

/*
        Spieler        FirebaseUser user = firebaseAuth.getCurrentUser();


        if (firebaseAuth.getCurrentUser() == null)
        {
            startActivity(new Intent(this, MainActivity.class) );
            finish();

        }

 */

        textViewUser = (TextView) findViewById(R.id.textViewUser);
        createSpielfeld();
    }

    private void createSpielfeld() {
        setSpielfeld();
        createSpiel();
    }
    private void addSpieler() {
        for(int i = 0; i < 4; i++) {
           String name =  spieler[i][1];

            switch (spieler[i][0]) {
                case "LEER": neueSpieler[i] = new Spieler(name, 0, i);
                    break;
                case "USER": neueSpieler[i] = new Spieler(name, 0, i);
                    break;
                case "BOOT": neueSpieler[i] = new Spieler(name, 0, i);
                    break;
                case "SERVER": neueSpieler[i] = new Spieler(name, 0, i);
                    break;
            }

        }
    }

    private void setSpielfeld() {

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
    }
    private void createSpiel() {

        CreateSpiel main = new CreateSpiel(spieler, bildschirmBreiteMitte, bildschirmHoeheMitte, rSPielfeldHoeheBreite);

        for(int i = 0; i < 72; i++) {
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
            FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams((int) (SpielfeldHoeheBreite / 16.5), (int) (SpielfeldHoeheBreite/16.5));

            feldParams.leftMargin = (x);
            feldParams.bottomMargin = (y) ;
            feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;

            spielbereich.addView(feld, feldParams);
        }
    }
    private void gameloop() {

        // muss noch mit boolean variable gefüllt werden
        while (true) {

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
