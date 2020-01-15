package de.bsfreising.myapplication;

public class Endfeld extends Feld {

    private final int feldart = 1;          // 2 == Endfeld

    public Endfeld(int feldbesitzer) {
        super(feldbesitzer);
    }

    public int getFeldart() {
       return this.feldart;
   }
}
