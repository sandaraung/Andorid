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
public class August extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.august);
        ImageButton i8=(ImageButton)findViewById(R.id.n8);
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a8 = new Intent(getApplicationContext(), September.class);
                startActivity(a8);
            }
        });
        ImageButton b8=(ImageButton)findViewById(R.id.p8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t8 = new Intent(getApplicationContext(), July.class);
                startActivity(t8);
            }
        });
    }
}
