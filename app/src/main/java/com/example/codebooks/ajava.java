package com.example.codebooks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ajava extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajava);

        linearLayout = findViewById(R.id.linearLayout);
        if (linearLayout != null) {
            loadQuestions();
        } else {
            Log.e("UIError", "LinearLayout not found in com.example.codebooks.acn.xml");
        }
    }

    private void loadQuestions() {
        try {
            String json = loadJSONFromAsset("ajava.json");
            if (json == null) {
                Log.e("JSONError", "Failed to load JSON file");
                return;
            }

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String question = obj.getString("question");
                String answer = obj.getString("answer");

                // Create a TextView for the question
                TextView questionView = new TextView(this);
                questionView.setText("Q: " + question);
                questionView.setTextSize(18);
                questionView.setPadding(16, 16, 16, 8);
                questionView.setTypeface(null, android.graphics.Typeface.BOLD); // Make it bold

                // Create a TextView for the answer (initially hidden)
                TextView answerView = new TextView(this);
                answerView.setText("A: " + answer);
                answerView.setTextSize(16);
                answerView.setPadding(16, 0, 16, 16);
                answerView.setVisibility(View.GONE); // Hide initially

                // Toggle visibility when clicking on the question
                questionView.setOnClickListener(v -> {
                    if (answerView.getVisibility() == View.VISIBLE) {
                        answerView.setVisibility(View.GONE);
                    } else {
                        answerView.setVisibility(View.VISIBLE);
                    }
                });

                // Add question and answer to the layout
                linearLayout.addView(questionView);
                linearLayout.addView(answerView);
            }
        } catch (Exception e) {
            Log.e("JSONError", "Error parsing JSON", e);
        }
    }

    private String loadJSONFromAsset(String filename) {
        try (InputStream is = getAssets().open(filename)) {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception e) {
            Log.e("JSONError", "Error loading JSON from asset", e);
            return null;
        }
    }
}
