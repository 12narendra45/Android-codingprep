package com.example.codebooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class interview extends AppCompatActivity {

    private final int[] textViewIds = {
            R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
            R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9
    };

    private final String[] sections = {
            "os", "cn", "cod", "mysql", "java", "python", "cpp", "dsa"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_interview);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        setupClickListeners();
    }

    private void setupClickListeners() {
        for (int i = 0; i < textViewIds.length; i++) {
            TextView textView = findViewById(textViewIds[i]);
            String section = sections[i];
            textView.setOnClickListener(v -> openNewLayout(section));
        }
    }

    private void openNewLayout(String section) {
        Intent intent = new Intent(this, newlayoutinterview.class);
        intent.putExtra("section", section);
        startActivity(intent);
    }
}
