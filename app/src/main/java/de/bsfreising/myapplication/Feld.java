package de.bsfreising.myapplication;

public class Feld {

    public final int feldbesitzer;       // 0 == allen | 1 == Spieler 1 | 2 == Spieler 2 | ...

    private double id;
    private int x = 10;
    private int y = 10;


    private double figur_id = 0;



    public Feld(int feldbesitzer) {

        this.feldbesitzer = feldbesitzer;
    }
    public int getFeldbesitzer() {
        return this.feldbesitzer;
    }
    public void setId(double i) {
        id = i;
    }
    public double getId() {
        return id;
    }

    public void setX(int i) {
        x = i;
    }
    public int getX() {
        return this.x;
    }

    public void setY(int i) {
        y = i;
    }
    public int getY() {
        return this.y;
    }

    public void setFigur_id(double i) {
        figur_id = i;
    }
    public double getFigur_id() {
        return figur_id;
    }



}
