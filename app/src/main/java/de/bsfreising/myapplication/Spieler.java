package de.bsfreising.myapplication;

public class Spieler {

    private String name = null;
    private int punkte = 0;
    //private final int spielerTyp;  // User, Boot, Server, Nicht aktiv
    private int spielerId = 0;         // 0 == default | 1 == Spieler1 | ...






    public Spieler(String name, int punke, int spielerId) {

        this.name = name;
        this.punkte = punke;
        this.spielerId = spielerId;
       // this.spielerTyp = spielerTyp;
    }

    public String getName() { return this.name;}
    public void setName(String name) {this.name = name;}

    public int getPunkte() { return this.punkte;}
    public void setPunkte(int punkte) {this.punkte = punkte;}

    public int getFieguren() { return this.spielerId;}
    public  void setFieguren(int spielerId) {this.spielerId = spielerId;}



}
