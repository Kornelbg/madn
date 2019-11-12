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

            private String isCheckBoxRememberMe = "false";


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

        loginInputUserName = findViewById(R.id.loginInputUserName);

        mReadSharedPreferences();

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
            //System.out.println("hallo");
        }else{
            //in XML Hacken deaktivieren und user name auf null setzen damit der Default Wert geschrieben wird
        }


        mSaveSharedPreferences(); // Speichert den Username wen Rememberme true ist

    }

    public boolean logginDatei( String user, String passwd ) {

        // gibt an ob user und eingangsdaten kombination in datei vorhanden ist wenn nicht abfrage
        boolean u_p_in_datei = false;

        return u_p_in_datei;
    }


    public void mSaveSharedPreferences(){
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerFichNicht", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySPR.edit();

        if(checkBoxRememberMe.isChecked()){
            isCheckBoxRememberMe = "true";
            editor.putString("Key_2", loginInputUserName.getText().toString());
        }
        else{
            isCheckBoxRememberMe = "false";
            editor.putString("Key_2", "");
        }
        editor.putString("Key_1", isCheckBoxRememberMe);
        editor.commit();
      //  String dad = loginInputUserName.getText().toString();

    }
    public void mReadSharedPreferences() {
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerFichNicht", Context.MODE_PRIVATE);
        if (mySPR.getString("Key_1", "false").toString().equals("ture")){
            loginInputUserName.setText(mySPR.getString("Key_2", "false"));
        }else{
          //  loginInputUserName.setText(mySPR.getString("Key_2", "false"));
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        mSaveSharedPreferences();

    }


}
