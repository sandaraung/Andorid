package com.example.hp.couple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by HP on 1/6/2016.
 */
public class Update extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        Button uu=(Button)findViewById(R.id.up);
        uu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uu=new Intent(getApplicationContext(),Talk.class);
                startActivity(uu);
            }
        });
    }
}
