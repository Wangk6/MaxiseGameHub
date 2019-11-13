package com.example.maxiselogin;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class HighScore extends AppCompatActivity {
    int highScore;
    String highScoreUser;
    public static final String HIGH_SCORE = "highScore";
    public static final String HIGH_SCORE_USER = "highScoreUser";

    public HighScore(SharedPreferences sharedPreferences){
        highScore = sharedPreferences.getInt(HIGH_SCORE, 0);
        highScoreUser = sharedPreferences.getString(HIGH_SCORE_USER, "");
    }

    public void setHighScore(SharedPreferences sharedPreferences, int score, String name){
        highScore = score;
        highScoreUser = name;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HIGH_SCORE, score);
        editor.putString(HIGH_SCORE_USER, name);
        editor.commit();
    }

    public int getHighScore(SharedPreferences sharedPreferences){
        highScore = sharedPreferences.getInt(HIGH_SCORE, 0);
        return highScore;
    }

    public String getHighScoreUser(SharedPreferences sharedPreferences){
        highScoreUser = sharedPreferences.getString(HIGH_SCORE_USER, "");
        return highScoreUser;
    }
}
