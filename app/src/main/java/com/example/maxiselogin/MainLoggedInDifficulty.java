package com.example.maxiselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainLoggedInDifficulty extends AppCompatActivity {

    Button lvlOne, lvlTwo, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_main_menu_difficulty);

        lvlOne = findViewById(R.id.btnLevelOne);
        lvlTwo = findViewById(R.id.btnLevelTwo);
        back = findViewById(R.id.btnBack);

        lvlOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInDifficulty.this, MainLoggedInHelp.class);
                startActivity(i);
            }
        });

        lvlTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInDifficulty.this, MainLoggedInHelp.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInDifficulty.this, MainLoggedInActivity.class);
                startActivity(i);
            }
        });
    }
}
