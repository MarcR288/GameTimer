package com.example.gametimer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CustomTimerSetUp extends AppCompatActivity {
    private long playerOneTime;
    private long playerTwoTime;
    private long playerOneIncrement;
    private long playerTwoIncrement;
    private String PlayerOneIncrementStr;
    private String PlayerTwoIncrementStr;
    private String playerOneTimeStr;
    private String playerTwoTimeStr;
    private long upperTimeRemaining;
    private long upperTimeIncrement;
    private long lowerTimeRemaining;
    private long lowerTimeIncrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_timer); // Set your layout here

        //Edit Fields
        EditText playerOneEnter = findViewById(R.id.player1Time);
        EditText playerTwoEnter = findViewById(R.id.player2Time);

        EditText playerOneIncrementInput = findViewById(R.id.p1Increment);
        EditText playerTwoIncrementInput = findViewById(R.id.p2Increment);

        findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomTimerSetUp.this, TimerActivity.class);
                playerOneTimeStr = playerOneEnter.getText().toString();
                playerOneTime = Integer.parseInt(playerOneTimeStr);
                playerTwoTimeStr = playerTwoEnter.getText().toString();
                playerTwoTime = Integer.parseInt(playerTwoTimeStr);

                PlayerOneIncrementStr = playerOneIncrementInput.getText().toString();
                playerOneIncrement = Integer.parseInt(PlayerOneIncrementStr);

                PlayerTwoIncrementStr = playerTwoIncrementInput.getText().toString();
                playerTwoIncrement = Integer.parseInt(PlayerTwoIncrementStr);





                long upperTimeRemaining = playerTwoTime * 60 * 1000;
                long lowerTimeRemaining = playerOneTime * 60 * 1000;

                //
                intent.putExtra("LOWER_TIME_LIMIT", lowerTimeRemaining);
                intent.putExtra("LOWER_TIME_INCREMENT", playerOneIncrement);
                intent.putExtra("UPPER_TIME_LIMIT", upperTimeRemaining);
                intent.putExtra("UPPER_TIME_INCREMENT", playerTwoIncrement);

                // Log the intent data before starting the activity
                Log.d("IntentData", "LOWER_TIME_LIMIT: " + (lowerTimeRemaining /60000) + " minutes");
                Log.d("IntentData", "LOWER_TIME_INCREMENT: " + playerOneIncrement + " seconds");
                Log.d("IntentData", "UPPER_TIME_LIMIT: " + (upperTimeRemaining  /60000) + " minutes");
                Log.d("IntentData", "UPPER_TIME_INCREMENT: " + playerTwoIncrement + " seconds");

                startActivity(intent);
            }
        });
    }
}
