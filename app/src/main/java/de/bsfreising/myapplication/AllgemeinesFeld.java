package de.bsfreising.myapplication;

public class AllgemeinesFeld extends Feld{

    private final int feldart = 1;          // 4 == AllgemeinesFeld

    public AllgemeinesFeld(int feldbesitzer) {
        super(feldbesitzer);
    }

    public int getFeldart() {
        return this.feldart;
    }
}
