package de.bsfreising.myapplication;

import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Spielfeld extends Spiel{

    // es wird noch ene Mehode für das umsetzen und überprüfen benötigt

    private Feld[] spielfelder = new Feld[76];

    private Display display;
    private Point size;

    ImageView spielfeld;

    private int spielfeldMitteBreite = 0;
    private int spielfeldMitteHoehe = 0;

    private int spielfeldHoeheBreite;



   // private FrameLayout spielbereich;

    private FrameLayout.LayoutParams parmscharakter;

    public Spielfeld(int bildschirmBreiteMitte, int bildschirmHoeheMitte, int spielfeldMitteHoehe) {

        this.spielfeldMitteBreite = bildschirmBreiteMitte;
        this.spielfeldMitteHoehe = bildschirmHoeheMitte;

        this.spielfeldHoeheBreite = (int)(spielfeldMitteHoehe * 0.95);

        setSpielfeld();
        //setFelder();      --> Fekder-Arry muss noch behandelt werden



    }


    public int getBildschirmBreiteMitte() {
        return this.spielfeldMitteBreite;
    }

    public int getBildschirmHoeheMitte() {
        return this.spielfeldMitteHoehe;
    }


    // Raster ist 12*12  | 11*11 punkte

    // hohe/12 ist der abstand der einzelnen punkte  mitte ist b



    // die einzelnen Felder lassen sich durch die beiden werte SPIELER und FELDNUMMER identifizieren

    private void setSpielfeld() {

        //spielbereich = findViewById(R.id.test);         // für den das Layout des Spielbereiches muss noch ein richtiger namen gefunden werden!  --> (!= test)

        parmscharakter = new FrameLayout.LayoutParams(spielfeldHoeheBreite , spielfeldHoeheBreite );
        parmscharakter.leftMargin = (spielfeldMitteBreite -((spielfeldHoeheBreite) /2));
        parmscharakter.bottomMargin = (spielfeldMitteHoehe -((spielfeldHoeheBreite) /2)) ;
        parmscharakter.gravity = Gravity.BOTTOM + Gravity.LEFT;

        // spielbereich.addView(spielbereich, parmscharakter);          // erst nach den Fertigstellen puschen
    }

    private void setFelder() {

        int zaehlerASF = 0; // zahl die Allgemeinen und sicheren Felder
        int spieler = 0;

        for(int sf = 0; sf < 4; sf++ ){         // sf == Spielerfelder

            spieler++; // erster Spieler beginnt mit 1

            int felderSpieler = 0; // Felder Spieler beginnt mit 1

            for(int bf = 0; bf < 4; bf++) {     // bf == Basisfelder
                felderSpieler++;
            }
            for(int ef = 0; ef < 4; ef++) {     // ef == Endfelder
                felderSpieler++;
            }

        }
        for(int af1 = 0; af1 < 4; af1++) {       // af == AllgemeineFelder --> erste Schleife

                zaehlerASF++; // erstes Feld beginnt mit 1

            int besitzer = af1 + 1;
            int sicheresfeldZaehler = af1 * 10 + 1;

            spielfelder[sicheresfeldZaehler] = new Sicheresfeld(besitzer);
            // pos usw muss noch gesetzt werden

            // Sicherfelder ersellen

            // Variable muss um eins hochgezählt werden --> sichere Felder

            for(int af2 = 0; af2 < 10; af2++ ) {

                zaehlerASF++;

                // hier werden die einzelenen Felder erstellt
            }
        }






        /*

        spielfeld[0] = new Feld();
        spielfeld[0].setId(0.11);
        spielfeld[0].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 25);
        spielfeld[0].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 25 );

        spielfeld[1] = new Feld();
        spielfeld[1].setId(0.12);
        spielfeld[1].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 75);
        spielfeld[1].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 25 );

        spielfeld[2] = new Feld();
        spielfeld[2].setId(0.13);
        spielfeld[2].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 25);
        spielfeld[2].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 75 );

        spielfeld[3] = new Feld();
        spielfeld[3].setId(0.14);
        spielfeld[3].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 75);
        spielfeld[3].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 75);

        spielfeld[4] = new Feld();
        spielfeld[4].setId(0.21);
        spielfeld[4].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 25);
        spielfeld[4].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 125);

        spielfeld[5] = new Feld();
        spielfeld[5].setId(0.22);
        spielfeld[5].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 75);
        spielfeld[5].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 125);

        spielfeld[6] = new Feld();
        spielfeld[6].setId(0.23);
        spielfeld[6].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 25);
        spielfeld[6].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 75);

        spielfeld[7] = new Feld();
        spielfeld[7].setId(0.24);
        spielfeld[7].setX(bildschirmBreite -(((int) (bildschirmHoehe * 0.95)) /2) + 75);
        spielfeld[7].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 75);

        spielfeld[8] = new Feld();
        spielfeld[8].setId(0.31);
        spielfeld[8].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 125);
        spielfeld[8].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 125);

        spielfeld[9] = new Feld();
        spielfeld[9].setId(0.32);
        spielfeld[9].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 125);
        spielfeld[9].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 75);

        spielfeld[10] = new Feld();
        spielfeld[10].setId(0.33);
        spielfeld[10].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 75);
        spielfeld[10].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 75);

        spielfeld[11] = new Feld();
        spielfeld[11].setId(0.34);
        spielfeld[11].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 75);
        spielfeld[11].setY(brettMitteHoehe +(((int) (bildschirmHoehe * 0.95)) /2) - 125);

        spielfeld[12] = new Feld();
        spielfeld[12].setId(0.41);
        spielfeld[12].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 125);
        spielfeld[12].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 25);

        spielfeld[13] = new Feld();
        spielfeld[13].setId(0.42);
        spielfeld[13].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 125);
        spielfeld[13].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 75);

        spielfeld[14] = new Feld();
        spielfeld[14].setId(0.43);
        spielfeld[14].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 75);
        spielfeld[14].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 25);

        spielfeld[15] = new Feld();
        spielfeld[15].setId(0.44);
        spielfeld[15].setX(bildschirmBreite +(((int) (bildschirmHoehe * 0.95)) /2) - 75);
        spielfeld[15].setY(brettMitteHoehe -(((int) (bildschirmHoehe * 0.95)) /2) + 75);

        spielfeld[16] = new Feld();
        spielfeld[16].setId(1.0);
        spielfeld[16].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[16].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

        spielfeld[17] = new Feld();
        spielfeld[17].setId(1.1);
        spielfeld[17].setX(bildschirmBreite - 25);
        spielfeld[17].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 4) - 25 );

        spielfeld[18] = new Feld();
        spielfeld[18].setId(2.0);
        spielfeld[18].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[18].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 3) - 25 );

        spielfeld[19] = new Feld();
        spielfeld[19].setId(2.1);
        spielfeld[19].setX(bildschirmBreite - 25);
        spielfeld[19].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 3) - 25 );

        spielfeld[20] = new Feld();
        spielfeld[20].setId(3.0);
        spielfeld[20].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[20].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 2) - 25 );

        spielfeld[21] = new Feld();
        spielfeld[21].setId(3.1);
        spielfeld[21].setX(bildschirmBreite - 25);
        spielfeld[21].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 2) - 25 );

        spielfeld[22] = new Feld();
        spielfeld[22].setId(4.0);
        spielfeld[22].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[22].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[23] = new Feld();
        spielfeld[23].setId(4.1);
        spielfeld[23].setX(bildschirmBreite - 25);
        spielfeld[23].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 1) - 25 );

        spielfeld[24] = new Feld();
        spielfeld[24].setId(5.0);
        spielfeld[24].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 2)- 25);
        spielfeld[24].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[25] = new Feld();
        spielfeld[25].setId(6.0);
        spielfeld[25].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 3)- 25);
        spielfeld[25].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[26] = new Feld();
        spielfeld[26].setId(7.0);
        spielfeld[26].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[26].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[27] = new Feld();
        spielfeld[27].setId(8.0);
        spielfeld[27].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[27].setY(brettMitteHoehe - 25 );

        spielfeld[28] = new Feld();
        spielfeld[28].setId(9.0);
        spielfeld[28].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[28].setY(brettMitteHoehe +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[29] = new Feld();
        spielfeld[29].setId(9.2);
        spielfeld[29].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 4)- 25);
        spielfeld[29].setY(brettMitteHoehe - 25 );

        spielfeld[30] = new Feld();
        spielfeld[30].setId(10.0);
        spielfeld[30].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 3)- 25);
        spielfeld[30].setY(brettMitteHoehe +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[31] = new Feld();
        spielfeld[31].setId(10.2);
        spielfeld[31].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 3)- 25);
        spielfeld[31].setY(brettMitteHoehe - 25 );

        spielfeld[32] = new Feld();
        spielfeld[32].setId(11.0);
        spielfeld[32].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 2)- 25);
        spielfeld[32].setY(brettMitteHoehe +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[33] = new Feld();
        spielfeld[33].setId(11.2);
        spielfeld[33].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 2)- 25);
        spielfeld[33].setY(brettMitteHoehe - 25 );

        spielfeld[34] = new Feld();
        spielfeld[34].setId(12.0);
        spielfeld[34].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[34].setY(brettMitteHoehe +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[35] = new Feld();
        spielfeld[35].setId(12.2);
        spielfeld[35].setX(bildschirmBreiteMitte -((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 1)- 25);
        spielfeld[35].setY(bildschirmHoeheMitte - 25 );

        spielfeld[36] = new Feld();
        spielfeld[36].setId(13.0);
        spielfeld[36].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[36].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 2) - 25 );

        spielfeld[37] = new Feld();
        spielfeld[37].setId(14.0);
        spielfeld[37].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[37].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 3) - 25 );

        spielfeld[38] = new Feld();
        spielfeld[38].setId(15.0);
        spielfeld[38].setX(bildschirmBreite -((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[38].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

        spielfeld[39] = new Feld();
        spielfeld[39].setId(16.0);
        spielfeld[39].setX(bildschirmBreite - 25);
        spielfeld[39].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

        spielfeld[40] = new Feld();
        spielfeld[40].setId(17.0);
        spielfeld[40].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[40].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

        spielfeld[41] = new Feld();
        spielfeld[41].setId(17.3);
        spielfeld[41].setX(bildschirmBreite - 25);
        spielfeld[41].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 4) - 25 );

        spielfeld[42] = new Feld();
        spielfeld[42].setId(18.0);
        spielfeld[42].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[42].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 3) - 25 );

        spielfeld[43] = new Feld();
        spielfeld[43].setId(18.3);
        spielfeld[43].setX(bildschirmBreite - 25);
        spielfeld[43].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 3) - 25 );

        spielfeld[44] = new Feld();
        spielfeld[44].setId(19.0);
        spielfeld[44].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[44].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 2) - 25 );

        spielfeld[45] = new Feld();
        spielfeld[45].setId(19.3);
        spielfeld[45].setX(bildschirmBreite - 25);
        spielfeld[45].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 2) - 25 );

        spielfeld[46] = new Feld();
        spielfeld[46].setId(20.0);
        spielfeld[46].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[46].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[47] = new Feld();
        spielfeld[47].setId(20.3);
        spielfeld[47].setX(bildschirmBreite - 25);
        spielfeld[47].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 6 * 1) - 25 );

        spielfeld[48] = new Feld();
        spielfeld[48].setId(21.0);
        spielfeld[48].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 2)- 25);
        spielfeld[48].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[49] = new Feld();
        spielfeld[49].setId(22.0);
        spielfeld[49].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 3)- 25);
        spielfeld[49].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[50] = new Feld();
        spielfeld[50].setId(23.0);
        spielfeld[50].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[50].setY(bildschirmHoeheMitte +((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[51] = new Feld();
        spielfeld[51].setId(24.0);
        spielfeld[51].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[51].setY(bildschirmHoeheMitte - 25 );

        spielfeld[52] = new Feld();
        spielfeld[52].setId(25.0);
        spielfeld[52].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 4)- 25);
        spielfeld[52].setY(bildschirmHoeheMitte -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[53] = new Feld();
        spielfeld[53].setId(25.4);
        spielfeld[53].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 4)- 25);
        spielfeld[53].setY(bildschirmHoeheMitte - 25 );

        spielfeld[54] = new Feld();
        spielfeld[54].setId(26.0);
        spielfeld[54].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 3)- 25);
        spielfeld[54].setY(bildschirmHoeheMitte -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[55] = new Feld();
        spielfeld[55].setId(26.4);
        spielfeld[55].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 3)- 25);
        spielfeld[55].setY(bildschirmHoeheMitte  - 25 );

        spielfeld[56] = new Feld();
        spielfeld[56].setId(27.0);
        spielfeld[56].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 2)- 25);
        spielfeld[56].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[57] = new Feld();
        spielfeld[57].setId(27.4);
        spielfeld[57].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 2)- 25);
        spielfeld[57].setY(brettMitteHoehe - 25 );

        spielfeld[58] = new Feld();
        spielfeld[58].setId(28.0);
        spielfeld[58].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[58].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 1) - 25 );

        spielfeld[59] = new Feld();
        spielfeld[59].setId(28.4);
        spielfeld[59].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 6 * 1)- 25);
        spielfeld[59].setY(brettMitteHoehe - 25 );

        spielfeld[60] = new Feld();
        spielfeld[60].setId(29.0);
        spielfeld[60].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[60].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 2) - 25 );

        spielfeld[61] = new Feld();
        spielfeld[61].setId(30.0);
        spielfeld[61].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[61].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 3) - 25 );

        spielfeld[62] = new Feld();
        spielfeld[62].setId(31.0);
        spielfeld[62].setX(bildschirmBreite +((((int) (bildschirmHoehe * 0.95)) /2)  / 5 * 1)- 25);
        spielfeld[62].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

        spielfeld[63] = new Feld();
        spielfeld[63].setId(32.0);
        spielfeld[63].setX(bildschirmBreite- 25);
        spielfeld[63].setY(brettMitteHoehe -((((int) (bildschirmHoehe * 0.95)) /2) / 5 * 4) - 25 );

     // muss auf 76 erweitert und angepasst werden

         */

    }
}
