package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.lang.reflect.Array;

public class Spiel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        Intent spiel = getIntent();

        String spieltyp = spiel.getStringExtra("Spieltyp");

        String[] spieler = {
                spiel.getStringExtra("spieler_1"),
                spiel.getStringExtra("spieler_2"),
                spiel.getStringExtra("spieler_3"),
                spiel.getStringExtra("spieler_4")};

        createSpieler(spieler);


    }

    public void createSpielfeld() {

    }
    public void createSpieler(String[] spieler) {




        for (int i = 0; i < 4; i++) {

            if(spieler[i].equals("USER")){
                //Spieler
            }
            else if(spieler[i].equals("BOOT")){
                //Boot
            }else if(spieler[i].equals("SERVER")) {
                // Server lifert daten
            }else {
                // nicht aktive
            }

        }




    }

    public void gameloop() {

    }


    private void   mSaveSharedPreferencesSpielSPeichern() {

        // zwischenspeichern falls das Spiel vor beändigung verlassen wird
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerFichNicht", Context.MODE_PRIVATE);

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
