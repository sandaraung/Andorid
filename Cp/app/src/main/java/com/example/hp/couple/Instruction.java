package com.example.hp.couple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.couple.Activites.Url;

/**
 * Created by HP on 1/6/2016.
 */
public class Instruction extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction);
        Button in=(Button)findViewById(R.id.ins);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),Url.class);
                startActivity(in);
            }
        });
    }
}
