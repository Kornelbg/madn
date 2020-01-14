package de.bsfreising.myapplication;

public class Spieler {

    private String farbe = null;
    private String name = null;
    private int punkte = 0;
    private int position = 0;
    private int spielerTyp = 0;  // User, Boot, Server, Nicht aktiv
    private int fieguren = 0;

    public Spieler() {

    }

    public Spieler(String farbe, String name, int punke, int position, int spielerTyp, int fieguren) {
        this.farbe = farbe;
        this.name = name;
        this.punkte = punke;
        this.position = position;
        this.spielerTyp = spielerTyp;
        this.fieguren = fieguren;
    }

    public String getFarbe() { return this.farbe;}
    public void setFarbe(String farbe) {this.farbe = farbe;}

    public String getName() { return this.name;}
    public void setName(String name) {this.name = name;}

    public int getPunkte() { return this.punkte;}
    public void setPunkte(int punkte) {this.punkte = punkte;}

    public int getPosition() { return this.position;}
    public void setPosition(int position) {this.position = position;}

    public int getSpielerTyp() { return this.spielerTyp;}
    public void setSpielerTyp(int spielerTyp) {this.spielerTyp = spielerTyp;}

    public int getFieguren() { return this.fieguren;}
    public  void setFieguren(int fieguren) {this.fieguren = fieguren;}



}
