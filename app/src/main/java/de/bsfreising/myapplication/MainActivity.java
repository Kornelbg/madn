package de.bsfreising.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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



        //TextInputEditTExt
            private TextInputEditText inputUserName;
            private TextInputEditText userInputPassword;

            private boolean isCheckBoxRememberMe = false;


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

        startActivity(new Intent(this, CreatUser.class));

    }
    public void alsGastSpielen() {
        //setzen des aktiven Layouts
        setContentView(R.layout.playasguest);
    }
    public void setInfo() {

        startActivity(new Intent(this, Info_1.class));

    }



    public void login() {
        // Aufruf der Methode "logginDatei" wenn user hier vorhanden und Daten richtig sind login zulassen

        if(checkBoxRememberMe.isChecked()) {
            System.out.println("hallo");
        }else{
            //in XML Hacken deaktivieren und user name auf null setzen damit der Default Wert geschrieben wird
        }

    }

    public boolean logginDatei( String user, String passwd ) {

        // gibt an ob user und eingangsdaten kombination in datei vorhanden ist wenn nicht abfrage
        boolean u_p_in_datei = false;

        return u_p_in_datei;
    }


    public void dada(){

        if(checkBoxRememberMe.isChecked()){
            isCheckBoxRememberMe = true;
        }
        else{
            isCheckBoxRememberMe = false;
        }
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerFichNicht", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySPR.edit();

       // editor.putString("Key_1", )

    }


}
