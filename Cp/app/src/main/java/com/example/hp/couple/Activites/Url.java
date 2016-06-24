package com.example.hp.couple.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.couple.R;

/**
 * Created by HP on 1/6/2016.
 */
public class Url extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url);
        Button ll=(Button)findViewById(R.id.qr);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent li = new Intent(getApplicationContext(), Hscreen.class);
                startActivity(li);
            }
        });
        Button vv=(Button)findViewById(R.id.viber);
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vi=getPackageManager().getLaunchIntentForPackage("com.viber.voip");
                startActivity(vi);
            }
        });
        Button ff=(Button)findViewById(R.id.facebook);
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fi =getPackageManager().getLaunchIntentForPackage("com.facebook.orca");
                startActivity(fi);
            }
        });

    }
}
