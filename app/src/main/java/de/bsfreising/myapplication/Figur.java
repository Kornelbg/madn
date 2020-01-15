package de.bsfreising.myapplication;

public class Figur {

    private int farbe = 0;       // 0 == default |die weiteren Zahlen stehen für einzelne Farben

    private int zaehlerDF = 0;   // zahlt wie viel felder die figur schon gegangen ist

    private int idSpieler = 0;  // o == default | --> anderen Zahlen 1-4 stehen jeweils für einen Spieler

    private int posFigur = 0;   // hier gehört enweder die Array id oder die direkte position des Feldes


    public Figur(int farbe, int idSpieler) {

        this.farbe = farbe;
        this.idSpieler = idSpieler;

        zaehlerDF = 0;
    }

    public int getFarbe() {
        return this.farbe;
    }

    public void setZaehlerDF() {
        this.zaehlerDF = zaehlerDF;
    }
    public int getZaehlerDF() {
        return this.zaehlerDF;
    }

    public int getIdSpieler() {
        return this.idSpieler;
    }

    public void setPosFigur(int posFigur) {
        this.posFigur = posFigur;
    }
}
