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
public class September extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.september);
        ImageButton i9=(ImageButton)findViewById(R.id.n9);
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a9 = new Intent(getApplicationContext(), October.class);
                startActivity(a9);
            }
        });
        ImageButton b9=(ImageButton)findViewById(R.id.p9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t9 = new Intent(getApplicationContext(), August.class);
                startActivity(t9);
            }
        });
    }
}
