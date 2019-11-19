package com.example.maxiselogin.ParentView;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class HighScore extends AppCompatActivity {
    int highScore;
    String highScoreUser;
    public static final String CHILD_HIGH_SCORE_NAME= "childHighScoreName";
    public static final String CHILD_HIGH_SCORE = "childHighScore";

    public HighScore(SharedPreferences sharedPreferences){
        highScore = sharedPreferences.getInt(CHILD_HIGH_SCORE, 0);
        highScoreUser = sharedPreferences.getString(CHILD_HIGH_SCORE_NAME, "");
    }

    public void setHighScore(SharedPreferences sharedPreferences, int score){
        highScore = score;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CHILD_HIGH_SCORE, score);
        editor.commit();
    }

    public int getHighScore(SharedPreferences sharedPreferences){
        highScore = sharedPreferences.getInt(CHILD_HIGH_SCORE, 0);
        return highScore;
    }

    public String getHighScoreUser(SharedPreferences sharedPreferences){
        highScoreUser = sharedPreferences.getString(CHILD_HIGH_SCORE_NAME, "");
        return highScoreUser;
    }
}
