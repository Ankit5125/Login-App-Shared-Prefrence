package com.coderankit.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    MaterialButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);

                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isFirstTime", false);
                editor.apply();

                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext() , HomeActivity.class);
                startActivity(i);

                finish();
            }
        });

    }
}