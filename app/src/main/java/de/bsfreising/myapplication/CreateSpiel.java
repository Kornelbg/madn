package de.bsfreising.myapplication;



public class CreateSpiel {

    private int  bildschirmBreiteMitte;
    private int bildschirmHoeheMitte;
    private int bildschirmHoehe;
    private Spielfeld spielfeld_1;
    private String[][] spieler;

    public CreateSpiel(String[][] spieler, int bildschirmBreiteMitte, int bildschirmHoeheMitte, int bildschirmHoehe) {
        this.bildschirmBreiteMitte = bildschirmBreiteMitte;
        this.bildschirmHoeheMitte = bildschirmHoeheMitte;
        this.bildschirmHoehe = bildschirmHoehe;
        this.spieler = spieler;

        createSpieler();
        setSpielfeld();
    }

    private void createSpieler() {


    }


    private void setSpielfeld() {
        spielfeld_1 = new Spielfeld(bildschirmBreiteMitte, bildschirmHoeheMitte, bildschirmHoehe);
    }

    public Feld getFelder(int i) {

       return spielfeld_1.getFelder(i);
    }

    public int getFeldbesitzer(int i) {
        return spielfeld_1.getFeldbesitzer(i);
    }


        private void serFieguren() {
        // Spielstand überprüfen --> ...
    }


}
