package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    //buttons
    private Button buttonUser;
    private Button buttonGuest;
    private Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //buttons id zuweisung
        buttonUser = findViewById(R.id.buttonUser);
        buttonGuest = findViewById(R.id.buttonGuest);
        buttonLogin = findViewById(R.id.buttonLogin);

        //Butons onclicklistener gesetzt
        buttonUser.setOnClickListener(this);
        buttonGuest.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);



    }




    @Override
    public void onClick(View v) {

        //switch Abfrage auf id der Buttons
        switch (v.getId()) {
            case  R.id.buttonUser:
                break;
            case R.id.buttonGuest:
                break;
            case  R.id.buttonLogin:
                break;
        }


    }

    public void createUser() {
        //User erstellen --> in Datei und auf Server anlegen, wenn user auf server schonn vorhandes dieses mitteilen
    }

    public void login() {
        // Aufruf der Methode "logginDatei" wenn user hier vorhanden und Daten richtig sind login zulassen
    }

    public boolean logginDatei( String user, String passwd ) {

        // gibt an ob user und eingangsdaten kombination in datei vorhanden ist wenn nicht abfrage
        boolean u_p_in_datei = false;

        return u_p_in_datei;
    }

}
