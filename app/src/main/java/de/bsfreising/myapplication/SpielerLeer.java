package de.bsfreising.myapplication;

public class SpielerLeer extends Spieler {
    private boolean  isMainspieler = false;         // isMainspieler == true if Spieler == ersteller --> diese Variable soll aussagen wer bei einem
    // Konfliktfall die entscheidet oder es soll ganz durch ihn entschieden werden


    public SpielerLeer(String name, int punke, int spielerid) {
        super(name, punke, spielerid, 0);    // spielertyp == 1 --> Spieler User
    }


    public void setisMainspieler(boolean isMainspieler) {
        this.isMainspieler = isMainspieler;
    }
    public boolean getisMainspieler() {
        return this.isMainspieler;
    }
}
