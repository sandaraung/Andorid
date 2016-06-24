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
public class March extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.march);
        ImageButton i3=(ImageButton)findViewById(R.id.n3);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a3 = new Intent(getApplicationContext(), April.class);
                startActivity(a3);
            }
        });
        ImageButton b3=(ImageButton)findViewById(R.id.p3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t3 = new Intent(getApplicationContext(), Febuary.class);
                startActivity(t3);
            }
        });
    }
}
