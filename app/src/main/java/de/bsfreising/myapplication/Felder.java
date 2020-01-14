package de.bsfreising.myapplication;

public class Felder {
    private double id;
    private int x;
    private int y;

    private String figur = null;
    private double figur_id = 0;

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
        return x;
    }

    public void setY(int i) {
        y = i;
    }
    public int getY() {
        return y;
    }

    public void setFigur(String i) {
        figur = i;
    }
    public String getFigur() {
        return figur;
    }
    public void setFigur_id(double i) {
        figur_id = i;
    }
    public double getFigur_id() {
        return figur_id;
    }
}
