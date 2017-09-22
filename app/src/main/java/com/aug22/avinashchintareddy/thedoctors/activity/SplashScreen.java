package com.aug22.avinashchintareddy.thedoctors.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aug22.avinashchintareddy.thedoctors.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Log.i("Test","entered thread");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                callActivity();
            }
        }).start();
    }

    private void callActivity() {
        Log.i("Test","entered call");
        Intent intent= new Intent(SplashScreen.this,LoginActivity.class);
        startActivity(intent);
    }
}
