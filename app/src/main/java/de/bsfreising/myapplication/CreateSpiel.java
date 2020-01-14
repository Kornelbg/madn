package de.bsfreising.myapplication;

import android.widget.TextView;

public class CreateSpiel extends  Spiel{

    public CreateSpiel(String[] spieler) {
          createSpieler(spieler);
          createSpielfeld();
          serFieguren();
    }

    public Spieler[] createSpieler(String[] spieler) {

        Spieler[] test = new Spieler[4];

        for (int i = 0; i < 4; i++) {

            if(spieler[i].equals("USER")){
                test[i].setSpielerTyp(1);
                //Spieler
            }
            else if(spieler[i].equals("BOOT")){
                test[i].setSpielerTyp(2);
                //Boot
            }else if(spieler[i].equals("SERVER")) {
                test[i].setSpielerTyp(3);
                // Server lifert daten
            }else {
                test[i].setSpielerTyp(4);
                // nicht aktive
            }
        }
        return test; // muss noch duch das richtige Array ersetzt werden!
    }

    public Felder[] createSpielfeld() {

        // Positionen ausrechnen und fertiges Felder Array zurückgeben

        return null; // <-- gehört noch angepasst!
    }
    public void serFieguren() {
        // Spielstand überprüfen --> ...
    }
}
