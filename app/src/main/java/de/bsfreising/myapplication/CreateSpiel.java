package de.bsfreising.myapplication;

import android.widget.TextView;

import com.google.api.SystemParameterOrBuilder;

public class CreateSpiel extends  Spiel{

    public CreateSpiel(String[] spieler) {
          createSpieler(spieler);
        //  createSpielfeld();
          //serFieguren();
    }

    public void createSpieler(String[] spieler) {

        Spieler[] test1 = new Spieler[4];


        Spieler user_1 = new Spieler();
        user_1.setSpielerTyp(1);
    /*
        test1[0].setSpielerTyp(1);

        Spieler user_2 = new Spieler();
        Spieler user_3 = new Spieler();
        Spieler user_4 = new Spieler();

        */

      /*  for (int i = 0; i < 4; i++) {

            if(spieler[i].equals("USER")){
                test1[i].setSpielerTyp(1);
                //Spieler
            }
            else if(spieler[i].equals("BOOT")){
                test1[i].setSpielerTyp(2);
                //Boot
            }else if(spieler[i].equals("SERVER")) {
                test1[i].setSpielerTyp(3);
                // Server lifert daten
            }else {
                test1[i].setSpielerTyp(4);
                // nicht aktive
            }

        } */


      String a = "";

     /* for ( int i = 0; i < 4; i++ ){
        a += spieler[i];
      }
      */
        System.out.println("12345" + a);
     //   return null; // muss noch duch das richtige Array ersetzt werden!
    }

    public Felder[] createSpielfeld() {

        // Positionen ausrechnen und fertiges Felder Array zurückgeben

        return null; // <-- gehört noch angepasst!
    }
    public void serFieguren() {
        // Spielstand überprüfen --> ...
    }
}
