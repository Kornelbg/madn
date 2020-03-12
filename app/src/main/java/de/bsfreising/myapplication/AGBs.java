package de.bsfreising.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AGBs extends Activity implements View.OnClickListener {
// test
    //test2
    private Button buttonAGBsClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agbs);

        buttonAGBsClose = findViewById(R.id.buttonAGBsClose);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonAGBsClose :
                finish();
                break;
        }

    }
}
