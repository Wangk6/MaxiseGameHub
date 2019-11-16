package com.example.maxiselogin.LevelOne;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maxiselogin.MainLoggedInDifficulty;
import com.example.maxiselogin.R;

public class LevelOneEpisodeOne extends AppCompatActivity{
    //Character movements
    Button left, up, down, right, execute;
    //Character
    ImageView player, firstStep, secondStep, thirdStep;
    //Number of moves
    TextView numMoves;
    int [] userSequence;
    int [] correctSequence;
    int numOfMoves;
    int playerSetMove;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelone1);
        back = findViewById(R.id.prevPage);

        player = findViewById(R.id.imageViewPlayer);

        //Movement buttons
        left = findViewById(R.id.btnleft);
        down = findViewById(R.id.btnDown);
        right = findViewById(R.id.btnRight);
        up = findViewById(R.id.btnUp);

        //Sequence box
        firstStep = findViewById(R.id.firstStepImage);
        secondStep = findViewById(R.id.secondStepImage);
        thirdStep = findViewById(R.id.thirdStepImage);

        //Execute Button
        execute = findViewById(R.id.btnExecute);

        numMoves = findViewById(R.id.textViewNumbOfMoves);
        playerSetMove = 0;

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.firstStep).setOnDragListener(dragListener);
        findViewById(R.id.secondStep).setOnDragListener(dragListener);
        findViewById(R.id.thirdStep).setOnDragListener(dragListener);

        //add or remove any view that you don't want to be dragged
        left.setOnLongClickListener(longClickListener);
        up.setOnLongClickListener(longClickListener);
        right.setOnLongClickListener(longClickListener);
        down.setOnLongClickListener(longClickListener);


        Reset();
        correctSequence = new int[]{0, 1, 4};
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelOneEpisodeOne.this, MainLoggedInDifficulty.class);
                startActivity(i);
            }
        });

        //Left = 0; Up = 1; Down = 2; Right = 3
//        left.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                if(numOfMoves != 0) {
//                    SetUserSequence(0);
//                    UpdateNumberOfMovesLeft();
//                    PlayAnimation();
//                }
//            }
//        });
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                view.startDragAndDrop(data, dragShadowBuilder, view, 0);
            }else {
                view.startDrag(data, dragShadowBuilder, view, 0);
            }
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                 case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View v = (View) event.getLocalState();
                    if(v.getId() == R.id.btnleft){ //Dragged left button
                        SetUserSequence(0);
                        UpdateNumberOfMovesLeft();
                    }
                    else if(v.getId() == R.id.btnUp){
                        SetUserSequence(1);
                        UpdateNumberOfMovesLeft();
                    }
                    else if(v.getId() == R.id.btnDown){
                        SetUserSequence(2);
                        UpdateNumberOfMovesLeft();
                    }
                    else if(v.getId() == R.id.btnRight){
                        SetUserSequence(3);
                        UpdateNumberOfMovesLeft();
                    }

                    LinearLayout container = (LinearLayout) view;

                    LinearLayout lay = container;
                    View ve = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) v.getParent();
                    owner.removeView(v);//remove the dragged view
                    lay.addView(ve);
                    break;
            }

            return true;
        }
    };

    private void Reset(){
        numOfMoves = 3;
        userSequence = new int[3];
        numMoves.setText(String.valueOf(numOfMoves));
    }

    //Decrease number of moves by 1
    private void UpdateNumberOfMovesLeft(){
        numOfMoves--;
        numMoves.setText(String.valueOf(numOfMoves));
    }

    private void SetUserSequence(int move){
        switch(numOfMoves){
            case 3:
                userSequence[0] = move;
                if(move == 0) {
                    firstStep.setImageResource(R.drawable.arrowleft);
                }else if(move == 1){
                    firstStep.setImageResource(R.drawable.arrowup);
                }else if(move == 2){
                    firstStep.setImageResource(R.drawable.arrowdown);
                }else if(move == 3){
                    firstStep.setImageResource(R.drawable.arrowright);
                }
                break;
            case 2:
                userSequence[1] = move;
                if(move == 0) {
                    secondStep.setImageResource(R.drawable.arrowleft);
                }else if(move == 1){
                    secondStep.setImageResource(R.drawable.arrowup);
                }else if(move == 2){
                    secondStep.setImageResource(R.drawable.arrowdown);
                }else if(move == 3){
                    secondStep.setImageResource(R.drawable.arrowright);
                }
                break;
            case 1:
                userSequence[2] = move;
                if(move == 0) {
                    thirdStep.setImageResource(R.drawable.arrowleft);
                }else if(move == 1){
                    thirdStep.setImageResource(R.drawable.arrowup);
                }else if(move == 2){
                    thirdStep.setImageResource(R.drawable.arrowdown);
                }else if(move == 3){
                    thirdStep.setImageResource(R.drawable.arrowright);
                }
                break;
             default:
                 break;
        }

    }

    private void PlayAnimation(){
        ObjectAnimator rotateLeft = ObjectAnimator.ofFloat(player, "rotation", 90f);
        rotateLeft.setDuration(100);
        ObjectAnimator moveLeft = ObjectAnimator.ofFloat(player, "translationX", -470f);
        moveLeft.setDuration(1000);
        ObjectAnimator rotateUp = ObjectAnimator.ofFloat(player, "rotation", 180f);
        rotateUp.setDuration(100);
        ObjectAnimator moveUp = ObjectAnimator.ofFloat(player, "translationY", -970f);
        moveUp.setDuration(1000);
        ObjectAnimator rotateRight = ObjectAnimator.ofFloat(player, "rotation", 270f);
        rotateUp.setDuration(100);
        ObjectAnimator moveRight = ObjectAnimator.ofFloat(player, "translationX", -200);
        moveRight.setDuration(1000);

        AnimatorSet set  = new AnimatorSet();
        set.playSequentially(rotateLeft, moveLeft, rotateUp, moveUp, rotateRight, moveRight);
        set.start();
    }



}
