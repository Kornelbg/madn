package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CreatUser extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonCreatUserBack :

                break;
        }
    }
}
