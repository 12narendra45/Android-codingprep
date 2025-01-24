package com.example.codebooks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class newlayoutinterview extends AppCompatActivity {

    private TextView sectionContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the section name passed from the previous activity
        String section = getIntent().getStringExtra("section");

        if (section != null) {
            // Dynamically load the correct layout based on the section
            if (section.equals("os")) {
                setContentView(R.layout.aos);  // Load Operating System layout
            } else if (section.equals("cn")) {
                setContentView(R.layout.acn);  // Load Computer Networks layout
            } else if (section.equals("cod")) {
                setContentView(R.layout.acod);  // Load Computer Organisation layout
            } else if (section.equals("mysql")) {
                setContentView(R.layout.amysql);  // Load MySQL layout
            } else if (section.equals("java")) {
                setContentView(R.layout.ajava);  // Load Java layout
            } else if (section.equals("python")) {
                setContentView(R.layout.apython);  // Load Python layout
            } else if (section.equals("cpp")) {
                setContentView(R.layout.acpp);  // Load CPP layout
            } else if (section.equals("dsa")) {
                setContentView(R.layout.adsa);  // Load DSA layout
            }

            // Find the TextView in the newly loaded layout
            sectionContent = findViewById(R.id.sectionContent);
            sectionContent.setText("This is the " + section + " section.");
        }
    }
}
