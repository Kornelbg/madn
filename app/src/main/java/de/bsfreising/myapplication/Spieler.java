package de.bsfreising.myapplication;

public class Spieler {

    private String name = null;
    private int punkte = 0;
    //private final int spielerTyp;  // User, Boot, Server, Nicht aktiv
    private int spielerId = 0;         // 0 == default | 1 == Spieler1 | ..// .
    private int farbe;

    private Figur[] figuren = new Figur[4];

    public Spieler(String name, int punke, int spielerId) {

        this.name = name;
        this.punkte = punke;
        this.spielerId = spielerId;
        this.farbe = spielerId;
        System.out.println(spielerId + "  test hallo");

        addFieguren();
    }
    public int setFigur(int figurID,int posFigur, int zaehlerDF) {
        figuren[figurID].setFigur(posFigur, zaehlerDF);
        return figuren[figurID].getPosFigur();
    }
    public int getPosFigur(int figurID) {return figuren[figurID].getPosFigur(); }
    public int getZaehlerDF(int figurID) { return figuren[figurID].getZaehlerDF(); }


    public String getName() { return this.name;}
    public void setName(String name) {this.name = name;}

    public int getPunkte() { return this.punkte;}
    public void setPunkte(int punkte) {this.punkte = punkte;}

    public int getFieguren() { return this.spielerId;}
    public  void setFieguren(int spielerId) {this.spielerId = spielerId;}

    public int getFarbe() { return this.farbe; }
    //private void setFarbe(int farbe) { this.farbe = farbe; }

    private void addFieguren(){
        for(int i = 0; i < 4; i++) {
            int feld = 8 * this.spielerId + i + 40 ;
            System.out.println("hallo ich bin eine id 1....." + spielerId);
            System.out.println("hallo ich bin eine id ....." + feld);
            figuren[i] = new Figur(feld);
        }
    }
    private void addFieguren(int posFigur[], int figurDF[]) {
        for(int i = 0; i < 4; i++) {
            figuren[i] = new Figur( posFigur[i], figurDF[i]);
        }
    }





}
