package com.example.hp.couple.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.hp.couple.R;

/**
 * Created by HP on 1/4/2016.
 */
public class October extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.october);
        ImageButton i10=(ImageButton)findViewById(R.id.n10);
        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a10 = new Intent(getApplicationContext(),November.class);
                startActivity(a10);
            }
        });
        ImageButton b10=(ImageButton)findViewById(R.id.p10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t10 = new Intent(getApplicationContext(), September.class);
                startActivity(t10);
            }
        });
    }
}
