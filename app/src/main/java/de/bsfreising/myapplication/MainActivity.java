package de.bsfreising.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    // Layoutes activity-main
        //Buttons
            private Button buttonGuest;
            private TextView buttonUser;
            private Button buttonLogin;
            private Button buttonInfo;
            private Button buttonRegister;
            private TextInputEditText userEmail;
            private TextInputEditText userNickname;
            private TextView textViewCreateUser;
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
        buttonRegister = (Button) findViewById(R.id.buttonUserInput);
        userEmail = (TextInputEditText) findViewById(R.id.inputUserName);
        textViewCreateUser = (TextView) findViewById(R.id.textViewCreateUser);

        buttonRegister.setOnClickListener(this);
        textViewCreateUser.setOnClickListener(this);

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

        mSaveSharedPreferences(); // Speichert den Username wen Rememberme true ist

        //verbinfung zu Fierbase aufbauen und dateneingabe üermitteln

    }
    public User Test(String username, String password) {

        User akivUser = new User();


        return akivUser;
    }



    public void mSaveSharedPreferences(){
        SharedPreferences mySPR = this.getSharedPreferences("MenschaergerFichNicht", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mySPR.edit();

        if(checkBoxRememberMe.isChecked()&& !(loginInputUserName.getText().toString().equals(""))){
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

        if (mySPR.getString("Key_1", "false").toString().equals("true")){

            loginInputUserName.setText(mySPR.getString("Key_2", "false"));
            checkBoxRememberMe.setChecked(true);
        }else{
            loginInputUserName.setText("");
            checkBoxRememberMe.setChecked(false);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        mSaveSharedPreferences();

    }


}
