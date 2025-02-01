package com.example.codebooks;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class acod extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acod);
        linearLayout=findViewById(R.id.linearLayout);
        if(linearLayout!=null){
            loadQuestions();
        }
        else{
            Log.e("UIError", "LinearLayout not found");
        }
    }

    private void loadQuestions() {
        String json = loadJSONFromAsset("codquestions.json");
        try {
            if (json == null) {
                Log.e("JSONError", "Failed to load JSON file");
                return;
            }
            JSONArray jsonArray = new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj= jsonArray.getJSONObject(i);
                String Question=obj.getString("question");
                String answer=obj.getString("answer");

                TextView questionText=new TextView(this);
                questionText.setText("Q: " + Question);
                questionText.setTextSize(18);
                questionText.setPadding(16, 16, 16, 8);
                questionText.setTypeface(null, Typeface.BOLD);

                TextView answerText=new TextView(this);
                answerText.setText("Q: " + answer);
                answerText.setTextSize(18);
                answerText.setPadding(16, 16, 16, 8);
                answerText.setTypeface(null, Typeface.BOLD);
                answerText.setVisibility(View.GONE);

                questionText.setOnClickListener(v -> {
                    if (answerText.getVisibility() == View.VISIBLE) {
                        answerText.setVisibility(View.GONE);
                    } else {
                        answerText.setVisibility(View.VISIBLE);
                    }
                });

                // Add question and answer to the layout
                linearLayout.addView(questionText);
                linearLayout.addView(answerText);
            }
            }
        catch (Exception e) {
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