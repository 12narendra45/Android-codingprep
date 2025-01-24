package com.example.codebooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profile extends AppCompatActivity {

    TextView tvNameValue, tvEmailValue, tvPasswordValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        // Adjust insets for immersive UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        tvNameValue = findViewById(R.id.tvNameValue);
        tvEmailValue = findViewById(R.id.tvEmailValue);
        tvPasswordValue = findViewById(R.id.tvPasswordValue);


        // Retrieve user details from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "N/A"); // Default is "N/A" if no value found
        String email = sharedPreferences.getString("email", "N/A");
        String password = sharedPreferences.getString("password", "******"); // Default masked password

        // Display retrieved values in TextViews
        tvNameValue.setText(name);
        tvEmailValue.setText(email);
        tvPasswordValue.setText(password);
    }
}
