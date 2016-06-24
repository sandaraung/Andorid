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
public class July extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.july);
        ImageButton i7=(ImageButton)findViewById(R.id.n7);
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a7 = new Intent(getApplicationContext(), August.class);
                startActivity(a7);
            }
        });
        ImageButton b7=(ImageButton)findViewById(R.id.p7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t7 = new Intent(getApplicationContext(),June.class);
                startActivity(t7);
            }
        });
    }
}
