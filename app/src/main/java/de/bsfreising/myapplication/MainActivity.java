package de.bsfreising.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
            private ProgressDialog progressDialog;
            FirebaseAuth firebaseAuth;




            private TextInputEditText loginInputUserName;
            private TextInputEditText loginUserInputPassword;


            private int welcheView = 0;

            //
            private String isCheckBoxRememberMe = "false";

            //
            private Button buttonMainActivity;
            private Button buttoPAGnInfo;

            private Button buttonGuest_Spielen;


            private Spinner spinnerGuestSpielerstellen_1;
            private Spinner spinnerGuestSpielerstellen_2;
            private Spinner spinnerGuestSpielerstellen_3;
            private Spinner spinnerGuestSpielerstellen_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        buttonRegister = (Button) findViewById(R.id.buttonUserInput);
        userEmail = (TextInputEditText) findViewById(R.id.inputUserName);
        textViewCreateUser = (TextView) findViewById(R.id.textViewCreateUser);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        
        if (firebaseAuth.getCurrentUser() != null) {
            finish();                                                         
            startActivity(new Intent(getApplicationContext(), Spiel.class));
        }

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
                Info();
                break;

            // Abfrage Buttons Create User
            case R.id.buttonCreatUserBack :
                startbildschirm();
                break;

            //playasguest Buttons
            case R.id.buttonPAGMainActivity:
                welcheView = 0;
                startbildschirm();
                break;
            case R.id.buttoPAGnInfo:
                Info();
                break;
            case R.id.buttonGuest_Spielen:
                intentSpiel();
                break;
        }
    }


    public void startbildschirm() {
        //setzen des aktiven Layouts
        if(welcheView == 0) {
            setContentView(R.layout.activity_main);
        }else if( welcheView == 1) {
            setContentView(R.layout.playasguest);
        }else {

        }





        loginInputUserName = findViewById(R.id.loginInputUserName);
        loginUserInputPassword = findViewById(R.id.loginUserInputPassword);

        buttonUser = findViewById(R.id.textViewButtonUser);
        buttonGuest = findViewById(R.id.buttonGuest);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonInfo = findViewById(R.id.buttonInfo);

        checkBoxRememberMe = findViewById(R.id.checkBoxRememberMe);

        buttonUser.setOnClickListener(this);
        buttonGuest.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        buttonInfo.setOnClickListener(this);



        mReadSharedPreferences();
    }

    public void benutzererErstellen() {

        startActivity(new Intent(this, CreatUser.class));

    }
    public void alsGastSpielen() {
        //setzen des aktiven Layouts
        setContentView(R.layout.playasguest);
        welcheView = 1;
        

        buttonMainActivity = findViewById(R.id.buttonPAGMainActivity);
        buttoPAGnInfo = findViewById(R.id.buttoPAGnInfo);
        buttonGuest_Spielen = findViewById(R.id.buttonGuest_Spielen);

        spinnerGuestSpielerstellen_1 = findViewById(R.id.spinnerGuestSpielerstellen_1);
        spinnerGuestSpielerstellen_2 = findViewById(R.id.spinnerGuestSpielerstellen_2);
        spinnerGuestSpielerstellen_3 = findViewById(R.id.spinnerGuestSpielerstellen_3);
        spinnerGuestSpielerstellen_4 = findViewById(R.id.spinnerGuestSpielerstellen_4);



        buttonMainActivity.setOnClickListener(this);
        buttoPAGnInfo.setOnClickListener(this);
        buttonGuest_Spielen.setOnClickListener(this);

    }

    public void intentSpiel() {


        // muss angepasst werden!


        Intent spiel = new Intent(MainActivity.this, Spiel.class);

        spiel.putExtra("Spieltyp" , "ad");
        spiel.putExtra("spieler_1" , "USER");
        spiel.putExtra("spieler_2" , "BOOT");
        spiel.putExtra("spieler_3" , "SERVER");
        spiel.putExtra("spieler_4" , "LEER");


        startActivity(spiel);



    }

    public void Info() {

        startActivity(new Intent(this, Info_1.class));           // muss angepasst wernden --> "info_1"

    }

    private void login() {


        mSaveSharedPreferences(); // Speichert den Username wen Rememberme true ist
        //verbinfung zu Fierbase aufbauen und dateneingabe üermitteln
        String email = userEmail.getText().toString().trim();
        String password = loginUserInputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Bitte die E-Mail Adresse eingeben", Toast.LENGTH_SHORT).show();

            return;
        }
  
        if (TextUtils.isEmpty((password))) {
            Toast.makeText(this, "Bitte Password eingeben", Toast.LENGTH_SHORT).show();
            return;
        }
        
        progressDialog.setMessage("Anmeldung läuft");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();   
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), Spiel.class));
                        }
                
                
                    }
                }
        );

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
