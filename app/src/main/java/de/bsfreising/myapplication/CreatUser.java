package de.bsfreising.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreatUser extends Activity implements View.OnClickListener {

    private Button buttonCreatUserBack;
    private Button buttonUserInput;

    private CheckBox checkBoxCreateuserAGBs;
    private TextView textViewCreateuserAGBs;
    private FirebaseAuth firebaseAuth;

    private EditText inputNickname;
    private EditText inputUserName;
    private EditText userInputPassword;
    private EditText userInputPasswordWiederholen;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonCreatUserBack = findViewById(R.id.buttonCreatUserBack);
        buttonUserInput = findViewById(R.id.buttonUserInput);

        checkBoxCreateuserAGBs = findViewById(R.id.checkBoxCreateuserAGBs);
        textViewCreateuserAGBs = findViewById(R.id.textViewCreateuserAGBs);

        inputNickname = findViewById(R.id.inputNickname);
        inputUserName = findViewById(R.id.inputUserName);
        userInputPassword = findViewById(R.id.userInputPassword);
        userInputPasswordWiederholen = findViewById(R.id.userInputPasswordWiederholen);

        buttonCreatUserBack.setOnClickListener(this);
        buttonUserInput.setOnClickListener(this);

       // buttonUserInput.setClickable(false);

        textViewCreateuserAGBs.setOnClickListener(this);

 /*       checkBoxCreateuserAGBs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(checkBoxCreateuserAGBs.isChecked()) {
                   // buttonUserInput.setClickable(true);
                }
                else  {

                  //  buttonUserInput.setClickable(false);
                }
            }
        });
  */

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonCreatUserBack :
                mButtonCreateUserBack();
                break;

                case R.id.buttonUserInput :
                    mBenutzerErstellen();
                break;

            case R.id.textViewCreateuserAGBs :
                mAGBsAnzeigen();
                break;

        }
    }

    public void mAGBsAnzeigen() {

        startActivity(new Intent(this, Info_1.class));

    }

    public void mBenutzerErstellen() {

        String email = inputNickname.getText().toString().trim();
        String username = inputUserName.getText().toString().trim();
        String password = userInputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Bitte die E-Mail Adresse eingeben", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty((password))) {
            Toast.makeText(this, "Bitte Password eingeben", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Benutzer wird registriert...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(CreatUser.this, "Erforlgreich registriert", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CreatUser.this, "Registrierung fehlgeschlagen", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        progressDialog.dismiss();

        if (inputNickname.getText().toString().length() > 2  &&
                inputUserName.getText().toString().length() > 2 &&
                userInputPassword.getText().toString().length() > 4 &&
                userInputPassword.getText().toString().equals(userInputPasswordWiederholen.getText().toString())) {


        }
        else {

            if (inputNickname.getText().toString().length() > 2) {

                // Text muss gefüllt werden und < 2 sein
            }
            if ( inputUserName.getText().toString().length() > 2) {

                //muss gefüllt werden und < 2 sein
            }
            if ( userInputPassword.getText().toString().length() > 4) {

                // muss gefüllt werden und < 4 sein
            }
            if (userInputPassword.getText().toString().equals(userInputPasswordWiederholen.getText().toString())) {

                // Kontrolleingabe des Passwortes und Password müssen gelich sein
            }

        }

    }

    public void mButtonCreateUserBack() {

        finish();

    }
}
