package com.example.maxiselogin.ChildView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maxiselogin.R;

public class MainLoggedInHelp extends AppCompatActivity {
    TextView ruleOne, ruleTwo, ruleThree, ruleFour;
    String ruleOneText = "1. Drag and drop the correct path order to proceed";
    String ruleTwoText = "2. Click 'Go' to test your answer";
    String ruleThreeText = "3. Level One (10pts) - Level Two (20pts)";

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
