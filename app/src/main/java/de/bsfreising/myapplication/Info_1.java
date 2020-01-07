package de.bsfreising.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info_1 extends Activity implements View.OnClickListener {

    private Button buttonInfoClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allgemeine_info);

         buttonInfoClose = findViewById(R.id.buttonAGBsClose);
         buttonInfoClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //
        switch (v.getId()) {
            case R.id.buttonAGBsClose:
                mButtonInfoClose();
                break;


        }

    }

    public void mButtonInfoClose() {
        finish();
    }


}
