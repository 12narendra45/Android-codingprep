package com.example.codebooks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class booksuggestion extends AppCompatActivity {

    // UI Elements
    private EditText searchEditText;
    private Button searchButton;
    private GridLayout gridLayout;

    // Sample data for books
    private List<String> courseNames = new ArrayList<>();
    private List<String> bookNames = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<String> publishers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booksuggestion);

        // Initialize UI elements
        searchEditText = findViewById(R.id.searchBo);
        searchButton = findViewById(R.id.searchButton);
        gridLayout = findViewById(R.id.gridLayout);

        // Add sample data (you can replace this with dynamic data)
        courseNames.add("Operating System");
        bookNames.add("OS Concepts");
        authors.add("Abraham Silberschatz");
        publishers.add("McGraw-Hill");


        courseNames.add("Computer Networks");
        bookNames.add("Data and Computer Communications");
        authors.add("William Stallings");
        publishers.add("Pearson");
        
        courseNames.add("Computer Networks");
        bookNames.add("Data and Computer Communications");
        authors.add("William Stallings");
        publishers.add("Pearson");


        courseNames.add("Java Programming");
        bookNames.add("Effective Java");
        authors.add("Joshua Bloch");
        publishers.add("Addison-Wesley");

        // Set up search button click listener
        searchButton.setOnClickListener(v -> {
            String query = searchEditText.getText().toString().toLowerCase();

            // Clear previous results
            gridLayout.removeAllViews();

            // Filter and display books based on course name
            boolean found = false;
            for (int i = 0; i < courseNames.size(); i++) {
                if (courseNames.get(i).toLowerCase().contains(query)) {
                    // Add matching results to the GridLayout
                    addBookToGrid(courseNames.get(i), bookNames.get(i), authors.get(i), publishers.get(i));
                    found = true;
                }
            }

            // If no results were found
            if (!found) {
                Toast.makeText(booksuggestion.this, "No books found for the course", Toast.LENGTH_SHORT).show();
            }
        });

        // Adjust system window padding (Edge to Edge layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to add book information to the GridLayout
    private void addBookToGrid(String courseName, String bookName, String author, String publisher) {
        // Create TextViews to display each piece of information
        TextView courseTextView = new TextView(this);
        courseTextView.setText("Course Name: " + courseName);
        courseTextView.setTextSize(16);
        courseTextView.setPadding(0, 8, 0, 4);

        TextView bookTextView = new TextView(this);
        bookTextView.setText("Book Name: " + bookName);
        bookTextView.setTextSize(16);
        bookTextView.setPadding(0, 4, 0, 4);

        TextView authorTextView = new TextView(this);
        authorTextView.setText("Author: " + author);
        authorTextView.setTextSize(16);
        authorTextView.setPadding(0, 4, 0, 4);

        TextView publisherTextView = new TextView(this);
        publisherTextView.setText("Publisher: " + publisher);
        publisherTextView.setTextSize(16);
        publisherTextView.setPadding(0, 4, 0, 8);

        // Add them to GridLayout
        gridLayout.addView(courseTextView);
        gridLayout.addView(bookTextView);
        gridLayout.addView(authorTextView);
        gridLayout.addView(publisherTextView);

        // Add a divider line between the entries
        View divider = new View(this);
        divider.setLayoutParams(new GridLayout.LayoutParams());
        divider.setBackgroundColor(getResources().getColor(android.R.color.black));
        divider.setMinimumHeight(2);
        gridLayout.addView(divider);
    }
}
