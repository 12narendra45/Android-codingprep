package com.example.codebooks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Homepage extends AppCompatActivity {

    CardView c1, c2, c3, c4, c5, c6;
    ImageView i1, i2, i3, i4, i5;
    private PopupMenu pm;
    private boolean isMenuOpen = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        i1 = findViewById(R.id.topNavIcon);
        i2 = findViewById(R.id.icon1);
        i3 = findViewById(R.id.icon2);
        i4 = findViewById(R.id.icon3);
        i5 = findViewById(R.id.icon4);
        // Handle top navigation icon click
        i1.setOnClickListener(v -> {
            if (isMenuOpen) {
                pm.dismiss();
                isMenuOpen = false;
            } else {
                showPopupMenu(i1);
            }
        });
        // Set click listeners for CardView items
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,python.class));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,c1.class));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,java1.class));
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,html.class));
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,dsa.class));
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,dsaq.class));
            }
        });



        // Bottom navigation bar item clicks
        i2.setOnClickListener(v -> openActivity(Homepage.class));
        i3.setOnClickListener(v -> openActivity(taketest.class));
        i4.setOnClickListener(v -> openActivity(result.class));
        i5.setOnClickListener(v -> openActivity(learnings.class));
    }



    private void showPopupMenu(View anchor) {
        pm = new PopupMenu(this, anchor);
        pm.getMenuInflater().inflate(R.menu.drawer_menu, pm.getMenu());

        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.op1) {
                 openActivity(booksuggestion.class);
                    return true;
                } else if (itemId == R.id.op2) {
                    Toast.makeText(Homepage.this, "About clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.op3) {
                    Toast.makeText(Homepage.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (itemId == R.id.op4) {
                    Toast.makeText(Homepage.this, "About clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (itemId == R.id.op5) {
                    openActivity(practise.class);
                    return true;
                }

                else if (itemId == R.id.op7) {
                    openActivity(interview.class);
                    return true;
                }
                else if (itemId == R.id.op8) {
                  openActivity(profile.class);
                    return true;
                }
                else if (itemId == R.id.op9) {
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                    // Navigate to MainActivity (login page)
                    Intent intent = new Intent(Homepage.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    return true;
                }else {
                    return false;
                }
            }
        });

        pm.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                isMenuOpen = false;
            }
        });

        pm.show();
        isMenuOpen = true;
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(Homepage.this, activityClass);
        startActivity(intent);
    }
}
