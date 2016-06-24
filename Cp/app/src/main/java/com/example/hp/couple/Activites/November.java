package com.example.hp.couple.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.hp.couple.R;

/**
 * Created by HP on 1/4/2016.
 */
public class November extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.november);
        ImageButton i11=(ImageButton)findViewById(R.id.n11);
        i11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a11 = new Intent(getApplicationContext(), December.class);
                startActivity(a11);
            }
        });
        ImageButton b11=(ImageButton)findViewById(R.id.p11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t11 = new Intent(getApplicationContext(), October.class);
                startActivity(t11);
            }
        });
    }
}
