package com.example.maxiselogin.ParentView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maxiselogin.BeforeLogin.LoginScreenActivity;
import com.example.maxiselogin.MainLoggedInHelp;
import com.example.maxiselogin.R;

public class MainLoggedInActivity extends AppCompatActivity {

    Button start, highScore, logOut, help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_li_main_menu);
        start = findViewById(R.id.btnStart);
        highScore = findViewById(R.id.btnHighScore);
        logOut = findViewById(R.id.btnLogout);
        help = findViewById(R.id.btnHelp);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInActivity.this, MainLoggedInDifficulty.class);
                startActivity(i);
            }
        });
        highScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLoggedInActivity.this, MainLoggedInHighScore.class);
                startActivity(i);
            }
        });
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
}
