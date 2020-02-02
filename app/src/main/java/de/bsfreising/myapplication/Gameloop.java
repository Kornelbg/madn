package de.bsfreising.myapplication;

import android.view.Gravity;
import android.widget.FrameLayout;

public class Gameloop {

    private int spieler = 0;
    private int zahlWuerfel;
    private boolean spielerHatGewuerfelt = false;
    private int nochwurfeln = 3;

// muss noch angepasst werden !!!!!!

    public void bootwuerfeln() {
        if(Spiel.neueSpieler[spieler].getSpielerTyp() == 2) {
            int zahlBott = (int)(Math.random() * 6 + 1);
            int figurziehen = (int) (Math.random() * 4 + 1);

            while(true) {

            }
        }
    }

    // bei jedem wechsel
    private void ueberpruefeWuerfeln() {
        if(spieler < 3) {
            spieler++;
        }else {
            spieler = 0;
        }
        if(Spiel.neueSpieler[spieler].getZaehlerDF(0) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(1) == 0 &&
                Spiel.neueSpieler[spieler].getZaehlerDF(2) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(3) == 0) {
            nochwurfeln = 3;
        }else {
            nochwurfeln = 1;
        }

    }

    public boolean kannziehen() {

        int i = 0;
        boolean a = true;

        while (a && Spiel.neueSpieler[spieler].getZaehlerDF(0) > 41 && Spiel.neueSpieler[spieler].getZaehlerDF(1) > 41 &&
                Spiel.neueSpieler[spieler].getZaehlerDF(2) > 41 && Spiel.neueSpieler[spieler].getZaehlerDF(3) > 41) {
            spieler++;
            i++;
            if(i > 3) {
                a = false;
            }

        }


        if(zahlWuerfel != 6&&Spiel.neueSpieler[spieler].getZaehlerDF(0) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(1) == 0 &&
                Spiel.neueSpieler[spieler].getZaehlerDF(2) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(3) == 0){
            return false;
        }else {
            return true;
        }


    }

    public void wuerfeln() {

        if(!spielerHatGewuerfelt){

            if(nochwurfeln == 0) { ueberpruefeWuerfeln(); }

            zahlWuerfel = (int)(Math.random() * 6 + 1);

            if(kannziehen()){ spielerHatGewuerfelt = true; }

            if(zahlWuerfel != 6) {
                nochwurfeln--;
            }else {
                nochwurfeln = 1;
            }
            int real = spieler + 1;
            Spiel.augenwuerfel.setText("Spieler " + real + "\nAugen Würfel " + zahlWuerfel + "\nDarf noch Würfeln " + nochwurfeln);

        }
    }
    public void figurZiehen(int spieler_, int figur) {

        if(spielerHatGewuerfelt) {

            if(!(zahlWuerfel != 6 && Spiel.neueSpieler[spieler_].getZaehlerDF(figur) == 0) ){

            //spielerHatGewuerfelt = false;
            Spiel.augenwuerfel.setText("hallo");

            if(spieler_ == this.spieler) {
                int posF = Spiel.neueSpieler[spieler_].getPosFigur(figur);
                int zaehlerDF = Spiel.neueSpieler[spieler_].getZaehlerDF(figur);

               int netxFeld = figurPLUSzahl(posF, zaehlerDF, spieler_, figur );

               double figurid = Spiel.main.getFigurid(netxFeld);
                int i = (int) (figurid - (figurid % 10));
                int a = (int) figurid % 10 * 10;

                if(figurid != 0 &&i != spieler_) {

                    int feld = 8 * i + a + 40 ;
                    Spiel.neueSpieler[i].setFigur(a, feld, 0);

                    FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams((int) ((Spiel.SpielfeldHoeheBreite / 16.5) / 4 * 3), (int) ((Spiel.SpielfeldHoeheBreite / 16.5) / 4 * 3));
                    feldParams.leftMargin = ((Spiel.main.getFelder(Spiel.neueSpieler[i].getPosFigur(a)).getX()) + 5);
                    feldParams.bottomMargin = ((Spiel.main.getFelder(Spiel.neueSpieler[i].getPosFigur(a)).getY()) + 5);
                    feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;
                    Spiel.figurenSpieler[i * 4 + a].setLayoutParams(feldParams);

                }
                int neuerDF;
                    if(Spiel.neueSpieler[spieler_].getZaehlerDF(figur) == 0) {
                        neuerDF = 1;
                    }else {
                        neuerDF = Spiel.neueSpieler[spieler_].getZaehlerDF(figur) + zahlWuerfel;
                    }

                    Spiel.augenwuerfel.setText(spieler_ * 10  + "   " + neuerDF);
                    Spiel.neueSpieler[spieler_].setFigur(figur, netxFeld, neuerDF);

                    FrameLayout.LayoutParams feldParams = new FrameLayout.LayoutParams((int) ((Spiel.SpielfeldHoeheBreite / 16.5) / 4 * 3), (int) ((Spiel.SpielfeldHoeheBreite / 16.5) / 4 * 3));
                    feldParams.leftMargin = ((Spiel.main.getFelder(Spiel.neueSpieler[spieler_].getPosFigur(figur)).getX()) + 5);
                    feldParams.bottomMargin = ((Spiel.main.getFelder(Spiel.neueSpieler[spieler_].getPosFigur(figur)).getY()) + 5);
                    feldParams.gravity = Gravity.BOTTOM + Gravity.LEFT;
                    Spiel.figurenSpieler[spieler_ * 4 + figur].setLayoutParams(feldParams);


                    spielerHatGewuerfelt = false;


                    if(nochwurfeln == 0) {
                        ueberpruefeWuerfeln();
                    }

            }
            }

        }




    }

    private int figurPLUSzahl( int posF, int zaehlerDF, int spieler_, int figur) {


        if(zaehlerDF == 0) {

            return spieler_ * 10 ;


        }else if((zaehlerDF + zahlWuerfel) < 41){
            if(posF + zahlWuerfel < 41) {
                return posF + zahlWuerfel;
            }else {
                return  posF + zahlWuerfel - 40;
            }
        }else {
                return spieler_ * 10 + figur;
        }
    }

}
