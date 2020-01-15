package de.bsfreising.myapplication;

import android.widget.TextView;

import com.google.api.SystemParameterOrBuilder;

public class CreateSpiel {

    private int  bildschirmBreiteMitte;
    private int bildschirmHoeheMitte;
    private int bildschirmHoehe;

    public CreateSpiel(String[] spieler, int bildschirmBreiteMitte, int bildschirmHoeheMitte, int bildschirmHoehe) {
        this.bildschirmBreiteMitte = bildschirmBreiteMitte;
        this.bildschirmHoeheMitte = bildschirmHoeheMitte;
        this.bildschirmHoehe = bildschirmHoehe;

        createSpieler(spieler);
        setSpielfeld();
    }

    private void createSpieler(String[] spieler) {

    }

    private void setSpielfeld() {
        Spielfeld test = new Spielfeld(bildschirmBreiteMitte, bildschirmHoeheMitte, bildschirmHoehe);
    }

    private void serFieguren() {
        // Spielstand überprüfen --> ...
    }
}
