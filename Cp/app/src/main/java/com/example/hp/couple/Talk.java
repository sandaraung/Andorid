package com.example.hp.couple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by HP on 1/6/2016.
 */
public class Talk extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talk);
        Button ta=(Button)findViewById(R.id.talk);
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tt=new Intent(getApplicationContext(),Instruction.class);
                startActivity(tt);
            }
        });
    }
}
