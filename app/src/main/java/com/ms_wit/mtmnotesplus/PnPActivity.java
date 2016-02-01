package com.ms_wit.mtmnotesplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PnPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnp);

        ImageView iv = (ImageView) findViewById(R.id.picture1);
        TextView tv = (TextView) findViewById(R.id.text1);

//        Resources res = getResources();
//        String[] arts = res.getStringArray(R.array.);
//        tv.setText(arts[0]);

        // get reference to linear layout
        // loop through the array
        // inflate a view for every item in the array
        // attach the views to the linear layout
    }
}
