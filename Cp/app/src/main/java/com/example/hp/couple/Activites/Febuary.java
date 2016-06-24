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
public class Febuary extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.febuary);
        ImageButton i2=(ImageButton)findViewById(R.id.n2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2 = new Intent(getApplicationContext(),March.class);
                startActivity(a2);
            }
        });
        ImageButton b2=(ImageButton)findViewById(R.id.p2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t2=new Intent(getApplicationContext(), January.class);
                startActivity(t2);
            }
        });
    }
}
