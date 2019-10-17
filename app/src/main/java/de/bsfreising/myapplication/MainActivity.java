package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends Activity implements View.OnClickListener {

    //buttons
    private Button buttonUser;
    private Button buttonGuest;
    private Button buttonLogin;

    private Button buttonUserlogin;
    private Button buttonUserBack;

    private TextInputEditText inputUserName;
    private TextInputEditText userInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //buttons id zuweisung
        buttonUser = findViewById(R.id.buttonUser);
        buttonGuest = findViewById(R.id.buttonGuest);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonUserlogin = findViewById(R.id.buttonUserlogin);
        buttonUserBack = findViewById(R.id.buttonUserBack);

        inputUserName = findViewById(R.id.inputUserName);
        userInputPassword = findViewById(R.id.userInputPassword);

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
                setContentView(R.layout.createuser);
                break;
            case R.id.buttonGuest:
                setContentView(R.layout.playasguest);
                break;
            case  R.id.buttonLogin:
                setContentView(R.layout.login);
                break;
            case R.id.buttonUserlogin:
                login();
                break;
            case R.id.buttonUserBack:
                setContentView(R.layout.activity_main);
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
