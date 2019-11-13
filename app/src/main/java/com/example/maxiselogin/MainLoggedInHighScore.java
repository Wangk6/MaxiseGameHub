package com.example.maxiselogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainLoggedInHighScore extends AppCompatActivity {
    TextView txtHighScore, txtHighScoreName;
    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String HIGH_SCORE = "highScore";
    public static final String HIGH_SCORE_USER = "highScoreUser";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_high_score);
        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        HighScore hs = new HighScore(sharedPreferences);
        String userName = hs.getHighScoreUser(sharedPreferences);
        int highScore = hs.getHighScore(sharedPreferences);
        txtHighScoreName = findViewById(R.id.txtHighScoreUser);
        txtHighScoreName.setText(userName);
        txtHighScore = findViewById(R.id.txtHighScore);
        txtHighScore.setText((highScore)+"%");
    }

    public void PreviousPage(View view) {
        Intent i = new Intent(this, MainLoggedInActivity.class);
        startActivity(i);
    }
}
