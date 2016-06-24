package com.example.hp.couple.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.hp.couple.Home;
import com.example.hp.couple.R;

/**
 * Created by HP on 1/5/2016.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread logoTimer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();


                }finally {
                    startActivity(new Intent(Splash.this,Hscreen.class));
                }
                finish();
            }
        };
        logoTimer.start();
    }
}
