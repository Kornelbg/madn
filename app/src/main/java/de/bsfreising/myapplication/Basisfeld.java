package de.bsfreising.myapplication;

public class Basisfeld extends Feld {

    private final int feldart = 1;          // 1 == Basisfeld

    public Basisfeld(int feldbesitzer) {
        super(feldbesitzer);
    }

    public int getFeldart() {
        return this.feldart;
    }
}
