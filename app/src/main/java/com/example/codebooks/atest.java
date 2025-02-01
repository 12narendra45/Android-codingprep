package com.example.codebooks;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class atest extends AppCompatActivity {
EditText name,email,college;
LinearLayout linearLayout;
TextView countdownText;
Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name=findViewById(R.id.etName);
        email=findViewById(R.id.etEmail);
        college=findViewById(R.id.colleg);
        start=findViewById(R.id.btnStartTest);
        linearLayout=findViewById(R.id.linearlayout);
        countdownText = findViewById(R.id.tvCountdown);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String c=college.getText().toString();
                if(n.isEmpty()||e.isEmpty()||c.isEmpty()){
                    Toast.makeText(atest.this, "Enter all Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    linearLayout.setVisibility(View.GONE);
                    countdownText.setVisibility(View.VISIBLE);
                     startCountdown();
                }
            }
        });
    }
    private void startCountdown() {
        // Start a 10-second countdown
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update countdown text
                countdownText.setText("Starting in : " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                // After countdown finishes, open the new activity
                Toast.makeText(atest.this, "Test Starting...", Toast.LENGTH_SHORT).show();
                openNewActivity();
            }
        }.start();
    }

    // Method to open a new page (activity)
    private void openNewActivity() {
        // Create an intent to open the new activity (replace NewActivity.class with your target activity)
        Intent intent = new Intent(atest.this, testpage.class);
        startActivity(intent);
    }

}