package com.example.codebooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class interview extends AppCompatActivity {
    private TextView t1, t2, t3, t4, t5, t6, t7, t8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_interview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        t3 = findViewById(R.id.textView4);
        t4 = findViewById(R.id.textView5);
        t5 = findViewById(R.id.textView6);
        t6 = findViewById(R.id.textView7);
        t7 = findViewById(R.id.textView8);
        t8 = findViewById(R.id.textView9);
        t1.setOnClickListener(v -> openNewLayout("os"));
        t2.setOnClickListener(v -> openNewLayout("cn"));
        t3.setOnClickListener(v -> openNewLayout("cod"));
        t4.setOnClickListener(v -> openNewLayout("mysql"));
        t5.setOnClickListener(v -> openNewLayout("java"));
        t6.setOnClickListener(v -> openNewLayout("python"));
        t7.setOnClickListener(v -> openNewLayout("cpp"));
        t8.setOnClickListener(v -> openNewLayout("dsa"));


    }
    private void openNewLayout(String section) {
        Intent intent = new Intent(interview.this, newlayoutinterview.class);
        intent.putExtra("section", section);  // Pass the selected section name
        startActivity(intent);
    }
}
