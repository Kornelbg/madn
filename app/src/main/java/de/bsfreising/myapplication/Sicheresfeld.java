package de.bsfreising.myapplication;

public class Sicheresfeld extends Feld {

    private int feldart = 1;          // 3 == Sicheres Feld

    public Sicheresfeld(int feldbesitzer) {
        super(feldbesitzer);
    }


    public int getFeldart() {
        return this.feldart;
    }
}
