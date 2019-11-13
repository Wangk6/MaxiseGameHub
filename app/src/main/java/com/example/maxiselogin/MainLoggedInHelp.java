package com.example.maxiselogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainLoggedInHelp extends AppCompatActivity {
    TextView ruleOne, ruleTwo, ruleThree, ruleFour;
    String ruleOneText = "1. Multiple choice answers require the user to pick the correct answer to proceed";
    String ruleTwoText = "2. Some questions may have multiple answers and the user must pick the correct answers to proceed";
    String ruleThreeText = "3. Questions may have timers which require the user to pick a choice before it runs to 0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_help);

        ruleOne = findViewById(R.id.txtHelpOne);
        ruleOne.setText(ruleOneText);
        ruleTwo = findViewById(R.id.txtHelpTwo);
        ruleTwo.setText(ruleTwoText);
        ruleThree = findViewById(R.id.txtHelpThree);
        ruleThree.setText(ruleThreeText);
    }

    public void PreviousPage(View view) {
        Intent i = new Intent(this, MainLoggedInActivity.class);
        startActivity(i);
    }
}
