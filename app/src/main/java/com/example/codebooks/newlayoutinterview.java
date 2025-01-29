package com.example.codebooks;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class newlayoutinterview extends AppCompatActivity {

    // Mapping sections to their corresponding activities
    private static final Map<String, Class<?>> sectionActivityMap = new HashMap<>();

    static {
        sectionActivityMap.put("os", aos.class);
        sectionActivityMap.put("cn", acn.class);
        sectionActivityMap.put("cod", acod.class);
        sectionActivityMap.put("mysql", amysql.class);
        sectionActivityMap.put("java", ajava.class);
        sectionActivityMap.put("python", apython.class);
        sectionActivityMap.put("cpp", acpp.class);
        sectionActivityMap.put("dsa", adsa.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the section name passed from the previous activity
        String section = getIntent().getStringExtra("section");

        if (section != null && sectionActivityMap.containsKey(section)) {
            // Start the corresponding activity
            Intent intent = new Intent(this, sectionActivityMap.get(section));
            startActivity(intent);
            finish(); // Finish this activity to prevent stacking
        } else {
            // Handle the case where the section is invalid
            finish(); // Close the activity if no valid section is found
        }
    }
}
