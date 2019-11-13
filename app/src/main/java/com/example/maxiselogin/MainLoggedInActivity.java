package com.example.maxiselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLoggedInActivity extends AppCompatActivity {

    Button logOut, help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_main_menu);

        logOut = findViewById(R.id.btnLogout);
        help = findViewById(R.id.btnHelp);

        help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInActivity.this, MainLoggedInHelp.class);
                startActivity(i);
            }
        });
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInActivity.this, LoginScreenActivity.class);
                startActivity(i);
            }
        });
    }

    public void StartButtonOnClick(View view) {
        Intent i = new Intent(MainLoggedInActivity.this, MainLoggedInStart.class);
        startActivity(i);
    }

    public void HighScoreButtonOnClick(View view) {
        Intent i = new Intent(MainLoggedInActivity.this, MainLoggedInHighScore.class);
        startActivity(i);
    }
}
