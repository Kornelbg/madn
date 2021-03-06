package de.bsfreising.myapplication;

import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Spielfeld {

    // es wird noch ene Mehode für das umsetzen und überprüfen benötigt

    private Feld[] spielfelder = new Feld[72];

    private Display display;
    private Point size;

    private ImageView spielfeld;

    private int spielfeldMitteBreite;
    private int spielfeldMitteHoehe;

    private int spielfeldHoeheBreite;



   // private FrameLayout spielbereich;
    private FrameLayout.LayoutParams parmscharakter;

    public Spielfeld(int spielfeldMitteBreite, int bildschirmMitteHoehe, int spielfeldHoeheBreite) {

        this.spielfeldMitteBreite = spielfeldMitteBreite;
        this.spielfeldMitteHoehe = bildschirmMitteHoehe;

        this.spielfeldHoeheBreite = spielfeldHoeheBreite;

       // setSpielfeld();
        setFelder();
        setXundY();



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
    public double getFigur(int feld) {
        return spielfelder[feld].getFigur_id();
    }
    public void setFigur(int feld, double figurid) {
        spielfelder[feld].setFigur_id(figurid);
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
        int arrayZaehler = 0;
        int besitzer;
        int sicheresfeldZaehler;


        int zaehlerASF = 0; // zahl die Allgemeinen und sicheren Felder
        int spieler = 0;



        for(int af1 = 0; af1 < 4; af1++) {       // af == AllgemeineFelder --> erste Schleife

            sicheresfeldZaehler = af1 * 10 + 1;

            spielfelder[arrayZaehler] = new Sicheresfeld(af1 + 1);
            spielfelder[arrayZaehler].setId(arrayZaehler);
            arrayZaehler++;
            besitzer = af1 + 1;
            sicheresfeldZaehler = af1 * 10 + 1;

            // Variable muss um eins hochgezählt werden --> sichere Felder

            for(int af2 = 0; af2 < 9; af2++ ) {

                spielfelder[arrayZaehler] = new AllgemeinesFeld(0);
                spielfelder[arrayZaehler].setId(arrayZaehler);
                arrayZaehler++;

                }
}
        for(int sf = 0; sf < 4; sf++ ){         // sf == Spielerfelder

            // erster Spieler beginnt mit 1
            int felderSpieler = 0; // Felder Spieler beginnt mit 1

            for(int bf = 0; bf < 4; bf++) {     // bf == Basisfelder
                spielfelder[arrayZaehler] = new Basisfeld (sf+1);
                spielfelder[arrayZaehler].setId(arrayZaehler);
                arrayZaehler++;
                felderSpieler++;
            }
            for(int ef = 0; ef < 4; ef++) {     // ef == Endfelder
                spielfelder[arrayZaehler] = new Endfeld(sf+1);
                spielfelder[arrayZaehler].setId(arrayZaehler);
                arrayZaehler++;
                felderSpieler++;
            }



        }


    }

    public void setXundY() {
        int arrayZaehler = 0;

        int pointSFX = (int)(-(spielfeldHoeheBreite / 6 * 5 + spielfeldHoeheBreite / 16.5));
        int pointSFY = (int)(+(spielfeldHoeheBreite / 6 * 1 - spielfeldHoeheBreite / 16.5));

        //for(int ia = 0; ia < 4; ia++ ) {
            for(int i = 0; i < 4; i++) {

                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += (spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++ ) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFY += (spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 2; i++) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += (spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++) {

                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFY += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++ ) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += +(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 2; i++) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFY += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++) {

                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++ ) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFY += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 2; i++) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++) {

                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFY += +(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
            for(int i = 0; i < 4; i++ ) {
                spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
                spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
                pointSFX += -(spielfeldHoeheBreite / 6 * 1);
                arrayZaehler++;
            }
        for(int i = 0; i < 2; i++) {
            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + pointSFX);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + pointSFY);
            pointSFY += +(spielfeldHoeheBreite / 6 * 1);
            arrayZaehler++;
        }


        int x = 0;
        int y = 0;
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                x = (int) (-(spielfeldHoeheBreite / 6 * 5 + spielfeldHoeheBreite / 16.5));
                y = (int) (+(spielfeldHoeheBreite / 6 * 5 - spielfeldHoeheBreite / 16.5));
            }

            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);
            switch (i) {
                case 0: x += (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 1: y -= (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 2: x -= (spielfeldHoeheBreite / 6 * 1);
                    break;
            }
            arrayZaehler++;
        }
        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (-(spielfeldHoeheBreite / 6 * 4 + spielfeldHoeheBreite / 16.5));
                y = (int) (-(spielfeldHoeheBreite / 16.5));
            }
            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);

            x += (spielfeldHoeheBreite / 6 * 1);
            arrayZaehler++;
        }


        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (+(spielfeldHoeheBreite / 6 * 5 - spielfeldHoeheBreite / 16.5));
                y = (int) (+(spielfeldHoeheBreite / 6 * 5 - spielfeldHoeheBreite / 16.5));
            }

            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);
            switch (i) {
                case 0: x -= (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 1: y -= (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 2: x += (spielfeldHoeheBreite / 6 * 1);
                    break;
            }
            arrayZaehler++;
        }
        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (-(spielfeldHoeheBreite / 16.5));
                y = (int) (+(spielfeldHoeheBreite / 6 * 4 - spielfeldHoeheBreite / 16.5));
            }
            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);

            y -= (spielfeldHoeheBreite / 6 * 1);
            arrayZaehler++;
        }


        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (+(spielfeldHoeheBreite / 6 * 5 - spielfeldHoeheBreite / 16.5));
                y = (int) (-(spielfeldHoeheBreite / 6 * 5 + spielfeldHoeheBreite / 16.5));
            }

            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);
            switch (i) {
                case 0: x -= (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 1: y += (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 2: x += (spielfeldHoeheBreite / 6 * 1);
                    break;
            }
            arrayZaehler++;
        }
        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (+(spielfeldHoeheBreite / 6 * 4 - spielfeldHoeheBreite / 16.5));
                y = (int) (-(spielfeldHoeheBreite / 16.5));
            }
            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);

            x -= (spielfeldHoeheBreite / 6 * 1);
            arrayZaehler++;
        }


        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (-(spielfeldHoeheBreite / 6 * 5 + spielfeldHoeheBreite / 16.5));
                y = (int) (-(spielfeldHoeheBreite / 6 * 5 + spielfeldHoeheBreite / 16.5));
            }

            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);
            switch (i) {
                case 0: x += (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 1: y += (spielfeldHoeheBreite / 6 * 1);
                    break;
                case 2: x -= (spielfeldHoeheBreite / 6 * 1);
                    break;
            }
            arrayZaehler++;
        }
        for(int i = 0; i < 4; i++) {
            if(i== 0) {
                x = (int) (-(spielfeldHoeheBreite / 16.5));
                y = (int) (-(spielfeldHoeheBreite / 6 * 4 + spielfeldHoeheBreite / 16.5));
            }
            spielfelder[arrayZaehler].setX(spielfeldMitteBreite + x);
            spielfelder[arrayZaehler].setY(spielfeldMitteHoehe + y);

            y += (spielfeldHoeheBreite / 6 * 1);
            arrayZaehler++;
        }
    }
}
