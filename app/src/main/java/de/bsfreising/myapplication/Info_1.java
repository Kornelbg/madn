package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info_1 extends Activity implements View.OnClickListener {

    private Button buttonInfoClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allgemeine_info);

         buttonInfoClose = findViewById(R.id.buttonInfoClose);
         buttonInfoClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //
        switch (v.getId()) {
            case R.id.buttonInfoClose:
                mButtonInfoClose();
                break;


        }

    }

    public void mButtonInfoClose() {
        finish();
    }


}
