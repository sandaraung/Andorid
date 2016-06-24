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
public class May extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.may);
        ImageButton i5=(ImageButton)findViewById(R.id.n5);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a5 = new Intent(getApplicationContext(), June.class);
                startActivity(a5);
            }
        });
        ImageButton b5=(ImageButton)findViewById(R.id.p5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t5 = new Intent(getApplicationContext(), April.class);
                startActivity(t5);
            }
        });
    }
}
