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
public class June extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.june);
        ImageButton i6=(ImageButton)findViewById(R.id.n6);
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a6 = new Intent(getApplicationContext(), July.class);
                startActivity(a6);
            }
        });
        ImageButton b6=(ImageButton)findViewById(R.id.p6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t6 = new Intent(getApplicationContext(),May.class);
                startActivity(t6);
            }
        });
    }
}
