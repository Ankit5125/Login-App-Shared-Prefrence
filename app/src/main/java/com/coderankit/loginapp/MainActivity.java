package com.coderankit.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences( "login", MODE_PRIVATE);

                Boolean isFirstTime = pref.getBoolean("isFirstTime", true);

                Intent i ;

                if (isFirstTime){
                    i = new Intent(MainActivity.this, LoginActivity.class);
                }
                else {
                    i = new Intent(MainActivity.this, HomeActivity.class);
                }

                startActivity(i);
                finish();
            }
        }, 4000);
    }
}