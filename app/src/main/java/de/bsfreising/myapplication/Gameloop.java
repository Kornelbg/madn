package de.bsfreising.myapplication;

public class Gameloop {

    private int spieler = 0;
    private int zahlWuerfel;
    private boolean spielerHatGewuerfelt = false;
    private int nochwurfeln = 0;

// muss noch angepasst werden !!!!!!

    public void wuerfeln() {
        if(!spielerHatGewuerfelt){
            if(nochwurfeln == 0 &&
                    Spiel.neueSpieler[spieler].getZaehlerDF(0) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(1) == 0 &&
                    Spiel.neueSpieler[spieler].getZaehlerDF(2) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(3) == 0) {
                    nochwurfeln = 3;
            }else if(nochwurfeln == 0 &&!(Spiel.neueSpieler[spieler].getZaehlerDF(0) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(1) == 0 &&
                    Spiel.neueSpieler[spieler].getZaehlerDF(2) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(3) == 0)){
                nochwurfeln = 1;
            }

            if(nochwurfeln != 0) {
                spielerHatGewuerfelt = true;
                nochwurfeln--;
                //zahlWuerfel = 6;
                zahlWuerfel = (int)(Math.random() * 6 + 1);
                Spiel.augenwuerfel.setText(""+zahlWuerfel);
                System.out.println("ich gehe nochmalw " + nochwurfeln);

                if(zahlWuerfel == 6 ) {
                    nochwurfeln = 1;
                }else if((Spiel.neueSpieler[spieler].getZaehlerDF(0) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(1) == 0 &&
                        Spiel.neueSpieler[spieler].getZaehlerDF(2) == 0 && Spiel.neueSpieler[spieler].getZaehlerDF(3) == 0)) {
                    spielerHatGewuerfelt = false;
                }

            }



        }
    }
    public void figurZiehen(int spieler_, int figur) {

        if(spielerHatGewuerfelt) {
            if(spieler_ == this.spieler) {
                int posF = Spiel.neueSpieler[spieler_].getPosFigur(figur);
                int zaehlerDF = Spiel.neueSpieler[spieler_].getZaehlerDF(figur);

                System.out.println("ich gehe " + zahlWuerfel +" vor");
                    Spiel.neueSpieler[spieler_].setFigur(figur, zahlWuerfel, 0);
                    /* muss noch im Spiel gesetzt werden um auf die views zugreifen zu können
                      private ImageView gruen[] = new ImageView[4];
    private FrameLayout.LayoutParams gruenP[] = new FrameLayout.LayoutParams[4];
    private ImageView gelb[] = new ImageView[4];
    private FrameLayout.LayoutParams gelbP[] = new FrameLayout.LayoutParams[4];
    private ImageView blau[] = new ImageView[4];
    private FrameLayout.LayoutParams blauP[] = new FrameLayout.LayoutParams[4];
    private ImageView orange[] = new ImageView[4];
    private FrameLayout.LayoutParams orangeP[] = new FrameLayout.LayoutParams[4];
                     */
                spielerHatGewuerfelt = false;

                if(nochwurfeln == 0) {
                    if(spieler < 5) {
                        spieler++;
                        System.out.println(spieler + " gehe testetettetetet");
                    }else {
                        spieler = 0;
                    }

                }
            }

        }


    }

}
