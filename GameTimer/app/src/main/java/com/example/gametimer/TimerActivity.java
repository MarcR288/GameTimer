package com.example.gametimer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private TextView upperTimerTextView, lowerTimerTextView;
    private CountDownTimer upperTimer, lowerTimer;
    private long upperTimeRemaining;
    private long lowerTimeRemaining;
    private boolean isUpperTimerRunning = false;
    private boolean isLowerTimerRunning = false;
    private long upperTimeIncrement;
    private long lowerTimeIncrement;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        // Retrieve the time limits passed from MainActivity (Strings match what is put in the intent)
        upperTimeRemaining = getIntent().getLongExtra("UPPER_TIME_LIMIT", 5 * 60 * 1000); // Default to 5 minutes
        upperTimeIncrement = getIntent().getLongExtra("UPPER_TIME_INCREMENT", 0);
        lowerTimeRemaining = getIntent().getLongExtra("LOWER_TIME_LIMIT", 5 * 60 * 1000); // Default to 5 minutes
        lowerTimeIncrement = getIntent().getLongExtra("LOWER_TIME_INCREMENT", 0);


        upperTimerTextView = findViewById(R.id.upperTimer);
        lowerTimerTextView = findViewById(R.id.lowerTimer);

        updateTimerDisplay(upperTimerTextView, upperTimeRemaining);
        updateTimerDisplay(lowerTimerTextView, lowerTimeRemaining);

        upperTimer = new CountDownTimer(upperTimeRemaining, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                upperTimeRemaining = millisUntilFinished;
                updateTimerDisplay(upperTimerTextView, upperTimeRemaining);

            }

            @Override
            public void onFinish() {
                upperTimerTextView.setText("Timeout");
                lowerTimerTextView.setText("You win");
            }
        };

        // Initialize Lower Timer
        lowerTimer = new CountDownTimer(lowerTimeRemaining, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                lowerTimeRemaining = millisUntilFinished;
                updateTimerDisplay(lowerTimerTextView, lowerTimeRemaining);
            }

            @Override
            public void onFinish() {
                upperTimerTextView.setText("You win");
                lowerTimerTextView.setText("Timeout");
            }
        };

        //Upper touch area click listener
        findViewById(R.id.upperTouchArea).setOnClickListener(v -> {
            if (isUpperTimerRunning) {
                //increase by time increment
                upperTimeRemaining += upperTimeIncrement * 1000;
                updateTimerDisplay(upperTimerTextView, upperTimeRemaining);

                // Pause the upper timer
                upperTimer.cancel();
                isUpperTimerRunning = false;
                // Start the lower timer from the saved remaining time
                lowerTimer = new CountDownTimer(lowerTimeRemaining, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        lowerTimeRemaining = millisUntilFinished;
                        updateTimerDisplay(lowerTimerTextView, lowerTimeRemaining);
                    }

                    @Override
                    public void onFinish() {
                        lowerTimerTextView.setText("00:00:000");
                    }
                };
                lowerTimer.start();
                isLowerTimerRunning = true;
            } else if (!isUpperTimerRunning && !isLowerTimerRunning) {
                // If both timers are not running, start the lower timer from the beginning
                lowerTimer.start();
                isLowerTimerRunning = true;
                isUpperTimerRunning = false;
            }
        });

        // Lower touch area click listener
        findViewById(R.id.lowerTouchArea).setOnClickListener(v -> {
            if (isLowerTimerRunning) {
                //increase by time increment
                lowerTimeRemaining += lowerTimeIncrement * 1000;
                updateTimerDisplay(lowerTimerTextView, lowerTimeRemaining);

                // Pause the lower timer
                lowerTimer.cancel();
                isLowerTimerRunning = false;
                // Start the upper timer from the saved remaining time
                upperTimer = new CountDownTimer(upperTimeRemaining, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        upperTimeRemaining = millisUntilFinished;
                        updateTimerDisplay(upperTimerTextView, upperTimeRemaining);
                    }

                    @Override
                    public void onFinish() {
                        upperTimerTextView.setText("00:00:000");
                    }
                };
                upperTimer.start();
                isUpperTimerRunning = true;
            } else if (!isLowerTimerRunning && !isUpperTimerRunning) {
                // If both timers are not running, start the upper timer from the beginning
                upperTimer.start();
                isLowerTimerRunning = false;
                isUpperTimerRunning = true;
            }
        });
    }

    // Helper function to update the timer TextView
    void updateTimerDisplay(TextView timerTextView, long millis) {
        int minutes = (int) (millis / 1000) / 60;
        int seconds = (int) (millis / 1000) % 60;
        int milliseconds = (int) (millis % 1000);
        @SuppressLint("DefaultLocale") String time = String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);
        timerTextView.setText(time);
    }
}
