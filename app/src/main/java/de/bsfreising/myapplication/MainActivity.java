package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    //buttons buttons id zuweisung
    private Button buttonUser = findViewById(R.id.buttonUser);
    private Button buttonGuest = findViewById(R.id.buttonGuest);
  //  private Button buttonGuest = findViewById(R.id.buttonGuest);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        //Butons onclicklistener gesetzt
        buttonUser.setOnClickListener(this);
        buttonGuest.setOnClickListener(this);
       // buttonGuest.setOnClickListener(this);



    }

    public boolean logginDatei( String user, String passwd ) {

        // gibt an ob user und eingangsdaten kombination in datei vorhanden ist
        boolean u_p_in_datei = false;



        return u_p_in_datei;
    }


    @Override
    public void onClick(View v) {

        //switch Abfrage auf id der Buttons


    }
}
