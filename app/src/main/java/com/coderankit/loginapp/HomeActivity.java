package com.coderankit.loginapp;

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

public class HomeActivity extends AppCompatActivity {

    MaterialButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);

                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isFirstTime", true);
                editor.apply();


                Toast.makeText(HomeActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}