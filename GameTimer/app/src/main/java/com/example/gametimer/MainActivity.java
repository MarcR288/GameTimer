package com.example.gametimer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //5 Minute Timer Activity
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                // 5 minute timer (300000 ms)
                long upperTimeRemaining = 5 * 60 * 1000;
                long lowerTimeRemaining = 5 * 60 * 1000;
                //To pass values to variables in activity strings must be unique and match what is in the activity
                intent.putExtra("UPPER_TIME_LIMIT", upperTimeRemaining);
                intent.putExtra("LOWER_TIME_LIMIT", lowerTimeRemaining);
                startActivity(intent);
            }
        });
        //10 Minute Timer Activity
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                //pass in some variable changes
                long upperTimeRemaining = 10 * 60 * 1000;
                long lowerTimeRemaining = 10 * 60 * 1000;
                //To pass values to variables in activity strings must be unique and match what is in the activity
                intent.putExtra("UPPER_TIME_LIMIT", upperTimeRemaining);
                intent.putExtra("LOWER_TIME_LIMIT", lowerTimeRemaining);
                startActivity(intent);
            }
        });

        //Custom Timer Set Up
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomTimerSetUp.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle the menu item selected
        int id = item.getItemId();

        if (id == R.id.button){
            return true;
        } else if (id == R.id.button2) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}