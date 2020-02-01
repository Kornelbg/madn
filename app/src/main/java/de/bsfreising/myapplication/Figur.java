package de.bsfreising.myapplication;

public class Figur {

    private int zaehlerDF = 0;   // zahlt wie viel felder die figur schon gegangen ist
    private int posFigur = 0;   // hier gehört enweder die Array id oder die direkte position des Feldes

    public Figur(int posFigur) {
        this.posFigur = posFigur;
        this.zaehlerDF = 0;
    }

    public Figur( int posFigur, int zaehlerDF) {
        this.posFigur = posFigur;
        this.zaehlerDF = zaehlerDF;
    }

    public int setFigur(int zaehlerDF, int posFigur) {
        this.zaehlerDF = zaehlerDF;
        this.posFigur = posFigur;
        return this.posFigur;
    }

    public int getZaehlerDF() { return this.zaehlerDF; }
    public int getPosFigur() {return this.posFigur;}
}
