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
public class April extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.april);
        ImageButton i4=(ImageButton)findViewById(R.id.n4);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a4 = new Intent(getApplicationContext(), May.class);
                startActivity(a4);
            }
        });
        ImageButton b4=(ImageButton)findViewById(R.id.p4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t4 = new Intent(getApplicationContext(), March.class);
                startActivity(t4);
            }
        });
    }
}
