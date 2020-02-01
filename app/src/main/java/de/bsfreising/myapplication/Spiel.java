package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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

    private Button wuerfel;
    private int zahlWuerfel = 0;

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

    private String[][] spieler = new String[4][2];
    private Spieler[] neueSpieler = new Spieler[4];

    private ImageView feld;

    private  CreateSpiel main;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiel);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent spiel = getIntent();
       /* String[][] spieler = { {spiel.getStringExtra("spieler_1T")},{spiel.getStringExtra("spieler_1N")},
                {spiel.getStringExtra("spieler_2T")},{spiel.getStringExtra("spieler_2N")},
                {spiel.getStringExtra("spieler_3T")},{spiel.getStringExtra("spieler_3N")},
                {spiel.getStringExtra("spieler_4T")},{spiel.getStringExtra("spieler_4N")},};
        this.spieler = spieler;*/

        this.spieler[0][0] = spiel.getStringExtra("spieler_1T");
        this.spieler[0][1] = spiel.getStringExtra("spieler_1N");

        this.spieler[1][0] = spiel.getStringExtra("spieler_2T");
        this.spieler[1][1] = spiel.getStringExtra("spieler_2N");

        this.spieler[2][0] = spiel.getStringExtra("spieler_3T");
        this.spieler[2][1] = spiel.getStringExtra("spieler_3N");

        this.spieler[3][0] = spiel.getStringExtra("spieler_4T");
        this.spieler[3][1] = spiel.getStringExtra("spieler_4N");

        wuerfel = findViewById(R.id.wuerfel);
        wuerfel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wuerfeln();
            }
        });


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
    private void wuerfeln() {
        if(true){// Spieler darf würfeln
            zahlWuerfel = (int)(Math.random() * 6 + 1);
            System.out.println("es wurde volgendes gewürfelt --> " + zahlWuerfel );
        }

    }

    private void createSpielfeld() {
        setSpielfeld();
        createSpiel();
        addSpieler();
        setFigur();

    }
    private void addSpieler() {

        //textViewUser.setText(this.spieler[0][1] + this.spieler[0][1] + this.spieler[1][0] + this.spieler[1][1]);

        for(int i = 0; i < 4; i++) {
           String name =  spieler[i][1];

            switch (spieler[i][0]) {
                case "LEER": neueSpieler[i] = new SpielerLeer(name, 0, i);
                    break;
                case "USER": neueSpieler[i] = new SpielerUser(name, 0, i);
                    break;
                case "BOOT": neueSpieler[i] = new SpielerBoot(name, 0, i);
                    break;
                case "SERVER": neueSpieler[i] = new SpielerServer(name, 0, i);
                    break;
            }

            // muss noch mit shadespreference gefüllt werden falls nötig!!!!
            for(int a = 0; a < 4; a++ ) {
                if(false) {
                    int peter = neueSpieler[i].setFigur(a, 40, 0);
                   textViewUser.setText(peter + "hallo");
                }
            }



        }
    }
    private void setFigur() {

        for(int i = 0; i < 4; i++) {
            for(int a = 0; a < 4; a++) {
                feld = new ImageView(this);
                switch (i) {
                    case 0 :
                        switch (a) {
                            case 0 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(0, 0);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  0|0 " );
                            }});
                                break;
                            case 1 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(0, 1);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  0|1 " );
                            }});
                                break;
                            case 2 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(0, 2);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  0|2 " );
                            }});
                                break;
                            case 3: feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(0, 3);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  0|3 " );
                            }});
                                break;
                        }
                        break;
                    case 1 :
                        switch (a) {
                            case 0 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(1, 0);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  1|0 " );
                            }});
                                break;
                            case 1 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(1, 1);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  1|1 " );
                            }});
                                break;
                            case 2 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(1, 2);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  1|2 " );
                            }});
                                break;
                            case 3: feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(1, 3);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  1|3 " );
                            }});
                                break;
                        }
                        break;
                    case 2 :
                        switch (a) {
                            case 0 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(2, 0);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  2|0 " );
                            }});
                                break;
                            case 1 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(2, 1);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  2|1 " );
                            }});
                                break;
                            case 2 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(2, 2);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  2|2 " );
                            }});
                                break;
                            case 3: feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(2, 3);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  2|3 " );
                            }});
                                break;
                        }
                        break;
                    case 3 :
                        switch (a) {
                            case 0 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(3, 0);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  3|0 " );
                            }});
                                break;
                            case 1 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(3, 1);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  3|1 " );
                            }});
                                break;
                            case 2 : feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(3, 2);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  3|2 " );
                            }});
                                break;
                            case 3: feld.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v){
                                FigurZiehen(3, 3);
                                System.out.println("hallo ich habe einen Onclicklisener und bin -->  3|3 " );
                            }});
                                break;
                        }
                        break;

                }


                switch (neueSpieler[i].getFarbe()) {
                    case 0: feld.setImageResource(R.drawable.orange);
                        break;
                    case 1: feld.setImageResource(R.drawable.gruen);
                        break;
                    case 2: feld.setImageResource(R.drawable.blau);
                        break;
                    case 3: feld.setImageResource(R.drawable.gelb);
                        break;
                }
                int pos = neueSpieler[i].getPosFigur(a);
                int x = main.getFelder(pos).getX();
                int y = main.getFelder(pos).getY();


                FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams((int)( (SpielfeldHoeheBreite / 16.5) / 4 * 3), (int) ((SpielfeldHoeheBreite / 16.5) / 4 * 3));

                feldParams.leftMargin = (x +5);
                feldParams.bottomMargin = (y +5);
                feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;
                spielbereich.addView(feld, feldParams);
            }
        }
    }
    private void FigurZiehen(int spieler, int figur) {
        // test wird mit einer public variable hochgezählt muss noch angepasst werden !!!!!
        int test = 0;
        if(spieler == test) {
            if(true){ // es wurde gewürfelt

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

       main = new CreateSpiel(spieler, bildschirmBreiteMitte, bildschirmHoeheMitte, rSPielfeldHoeheBreite);

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
