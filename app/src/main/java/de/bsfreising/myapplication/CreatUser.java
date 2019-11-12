package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreatUser extends Activity implements View.OnClickListener {

    private Button buttonCreatUserBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser);

        buttonCreatUserBack = findViewById(R.id.buttonCreatUserBack);
        buttonCreatUserBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonCreatUserBack :
                mButtonCreateUserBack();
                break;
        }
    }

    public void mButtonCreateUserBack() {

        finish();

    }
}
