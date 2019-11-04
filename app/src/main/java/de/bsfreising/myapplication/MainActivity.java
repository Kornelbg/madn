package de.bsfreising.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends Activity implements View.OnClickListener {

    // Layoutes activity-main
        //Buttons
            private Button buttonGuest;
            private TextView buttonUser;
            private Button buttonLogin;
            private Button buttonInfo;
            private CheckBox checkBoxRememberMe;



            private TextInputEditText loginInputUserName;
            private TextInputEditText loginUserInputPassword;


    //Layouts Createuser
        //Buttons
            private Button buttonCreatUserBack;
            private Button buttonUserInput;

        //TextInputEditTExt
            private TextInputEditText inputUserName;
            private TextInputEditText userInputPassword;

    //Layouts playasguest
        //Buttons
            private Button buttonPlayAsGuestBack;

    //Layouts loggin
        //Buttons
            private Button buttonLoginUserBack;


    //Layouts Info
        //Buttons
          private Button buttonInfoClose;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        startbildschirm();


    }






    @Override
    public void onClick(View v) {

      //Abfrage Buttons activity_main
        switch (v.getId()) {
            case R.id.textViewButtonUser :
                benutzererErstellen();
                break;
            case R.id.buttonGuest :
                    // Spiel starten mit Guest Parameter
                alsGastSpielen();
                break;
            case R.id.buttonLogin :
                login();
                break;
            case R.id.buttonInfo :
                setInfo();
                break;

            // Abfrage Buttons Create User
            case R.id.buttonCreatUserBack :
                startbildschirm();
                break;

                //ada
            //Abfrage Buttons playasGuest
            case R.id.buttonPlayAsGuestBack :
                startbildschirm();
                break;
                //ada
            //Abfrage Buttons allegemeine_info
            case R.id.buttonInfoClose :
                startbildschirm();
                break;
        }
    }

    public void startbildschirm() {
        //setzen des aktiven Layouts
        setContentView(R.layout.activity_main);


        buttonUser = findViewById(R.id.textViewButtonUser);
        buttonGuest = findViewById(R.id.buttonGuest);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonInfo = findViewById(R.id.buttonInfo);
        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);

        buttonUser.setOnClickListener(this);
        buttonGuest.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        buttonInfo.setOnClickListener(this);

        //checkBoxRememberMe
    }

    public void benutzererErstellen() {
        //setzen des aktiven Layouts
        //setContentView(R.layout.createuser);
        //TextInputEditText --> Usereingaben
        //Button Speichern
        //Button zurück
        //buttonCreatUserBack = findViewById(R.id.buttonCreatUserBack);
        //buttonCreatUserBack.setOnClickListener(this);

        startActivity(new Intent(this, CreatUser.class));

    }
    public void alsGastSpielen() {
        //setzen des aktiven Layouts
        setContentView(R.layout.playasguest);

        //Button buttonGuestback
        buttonPlayAsGuestBack = findViewById(R.id.buttonPlayAsGuestBack);
        buttonPlayAsGuestBack.setOnClickListener(this);
    }

    public void createUser() {
        //User erstellen --> in Datei und auf Server anlegen, wenn user auf server schonn vorhandes dieses mitteilen
    }

    public void login() {
        // Aufruf der Methode "logginDatei" wenn user hier vorhanden und Daten richtig sind login zulassen

        if(checkBoxRememberMe.isChecked()) {
            // in XML Hacken aktivieren und username mit dem letzen parameter füllen
        }else{
            //in XML Hacken deaktivieren und user name auf null setzen damit der Default Wert geschrieben wird
        }

    }

    public boolean logginDatei( String user, String passwd ) {

        // gibt an ob user und eingangsdaten kombination in datei vorhanden ist wenn nicht abfrage
        boolean u_p_in_datei = false;

        return u_p_in_datei;
    }

    public void setInfo() {

        //Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        //dialog.setContentView(R.layout.allgemeine_info);
        //dialog.show();

        setContentView(R.layout.allgemeine_info);
        buttonInfoClose = findViewById(R.id.buttonInfoClose);
        buttonInfoClose.setOnClickListener(this);
      // einfügen!!!  startActivity(new Intent(this, GameActivity.class));

    }

}
