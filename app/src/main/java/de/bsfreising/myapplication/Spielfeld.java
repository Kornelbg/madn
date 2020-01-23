package de.bsfreising.myapplication;

import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Spielfeld {

    // es wird noch ene Mehode für das umsetzen und überprüfen benötigt

    private Feld[] spielfelder = new Feld[76];

    private Display display;
    private Point size;

    private ImageView spielfeld;

    private int spielfeldMitteBreite = 0;
    private int spielfeldMitteHoehe = 0;

    private int spielfeldHoeheBreite;



   // private FrameLayout spielbereich;
    private FrameLayout.LayoutParams parmscharakter;

    public Spielfeld(int bildschirmBreiteMitte, int bildschirmHoeheMitte, int spielfeldMitteHoehe) {

        this.spielfeldMitteBreite = bildschirmBreiteMitte;
        this.spielfeldMitteHoehe = bildschirmHoeheMitte;

        this.spielfeldHoeheBreite = spielfeldMitteHoehe;

       // setSpielfeld();
        //setFelder();      --> Fekder-Arry muss noch behandelt werden



    }


    public int getBildschirmBreiteMitte() {
        return this.spielfeldMitteBreite;
    }

    public int getBildschirmHoeheMitte() {
        return this.spielfeldMitteHoehe;
    }

    public Feld getFelder(int i) {

        return spielfelder[i];
    }

    public int getFeldbesitzer(int i) {

        return spielfelder[i].getFeldbesitzer();
    }

    // Raster ist 12*12  | 11*11 punkte

    // hohe/12 ist der abstand der einzelnen punkte  mitte ist b



    // die einzelnen Felder lassen sich durch die beiden werte SPIELER und FELDNUMMER identifizieren



    // das Array spielfelder soll von 0 auf mit dem Allgemeinen Feldern und den Sicheren Feldern aufgefüllt werden.
    // --> es wird mit dem ersten Sicheren Feld gestartet
    // die anderen Felder folgen danach

    private void setFelder() {
        int besitzer;
        int sicheresfeldZaehler;


        int zaehlerASF = 0; // zahl die Allgemeinen und sicheren Felder
        int spieler = 0;

        for(int af1 = 0; af1 < 4; af1++) {       // af == AllgemeineFelder --> erste Schleife

            sicheresfeldZaehler = af1 * 10 + 1;
            zaehlerASF++; // erstes Feld beginnt mit 1

            // beispiel muss noch mit Variablen gefüllt werden
            spielfelder[zaehlerASF] = new AllgemeinesFeld(0);
            spielfelder[zaehlerASF].setId(af1);
            spielfelder[zaehlerASF].setX(spielfeldMitteBreite -(spielfeldHoeheBreite / 6 * 5));
            spielfelder[zaehlerASF].setY(spielfeldMitteHoehe +(spielfeldHoeheBreite / 6 * 1));

            besitzer = af1 + 1;
            sicheresfeldZaehler = af1 * 10 + 1;

            spielfelder[sicheresfeldZaehler] = new Sicheresfeld(besitzer);
            // pos usw muss noch gesetzt werden

            // Sicherfelder ersellen

            // Variable muss um eins hochgezählt werden --> sichere Felder

            for(int af2 = 0; af2 < 10; af2++ ) {
                spielfelder[zaehlerASF] = new AllgemeinesFeld(0);
                spielfelder[zaehlerASF].setId(af1);
                spielfelder[zaehlerASF].setX(spielfeldMitteBreite -(spielfeldHoeheBreite / 6 * 5));
                spielfelder[zaehlerASF].setY(spielfeldMitteHoehe +(spielfeldHoeheBreite / 6 * 1));
                zaehlerASF++;

                // hier werden die einzelenen Felder erstellt
            }

        for(int sf = 0; sf < 4; sf++ ){         // sf == Spielerfelder

            spielfelder[zaehlerASF] = new AllgemeinesFeld(0);
            spielfelder[zaehlerASF].setId(af1);
            spielfelder[zaehlerASF].setX(spielfeldMitteBreite -(spielfeldHoeheBreite / 6 * 5));
            spielfelder[zaehlerASF].setY(spielfeldMitteHoehe +(spielfeldHoeheBreite / 6 * 1));

            spieler++; // erster Spieler beginnt mit 1



            int felderSpieler = 0; // Felder Spieler beginnt mit 1

            for(int bf = 0; bf < 4; bf++) {     // bf == Basisfelder
                spielfelder[zaehlerASF] = new AllgemeinesFeld(0);
                spielfelder[zaehlerASF].setId(af1);
                spielfelder[zaehlerASF].setX(spielfeldMitteBreite -(spielfeldHoeheBreite / 6 * 5));
                spielfelder[zaehlerASF].setY(spielfeldMitteHoehe +(spielfeldHoeheBreite / 6 * 1));

                felderSpieler++;
            }
            for(int ef = 0; ef < 4; ef++) {     // ef == Endfelder
                spielfelder[zaehlerASF] = new AllgemeinesFeld(0);
                spielfelder[zaehlerASF].setId(af1);
                spielfelder[zaehlerASF].setX(spielfeldMitteBreite -(spielfeldHoeheBreite / 6 * 5));
                spielfelder[zaehlerASF].setY(spielfeldMitteHoehe +(spielfeldHoeheBreite / 6 * 1));

                felderSpieler++;
            }

            }
        }
    }
}
