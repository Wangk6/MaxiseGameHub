package com.example.maxiselogin.LevelTwo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maxiselogin.MainLoggedInActivity;
import com.example.maxiselogin.MainLoggedInDifficulty;
import com.example.maxiselogin.R;

import java.util.Arrays;

public class LevelTwoEpisodeThree extends AppCompatActivity{
    //Character movements
    ImageView leftStep, upStep, downStep, rightStep, execute;
    //Character
    ImageView player, firstStep, secondStep, thirdStep, fourthStep;
    //Reset Button
    Button reset;
    //Number of moves
    int [] userSequence;
    //Left - 0; Up - 1; Down - 2; Right - 3
    //Down - Left - Up - Left
    int [] correctSequence = new int[]{2, 0, 1, 0};


    ImageView back;

    //Animation
    AnimatorSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leveltwo3);

        back = findViewById(R.id.prevPage);
        player = findViewById(R.id.imageViewPlayer);

        //Movement buttons
        leftStep = findViewById(R.id.btnleft);
        downStep = findViewById(R.id.btnDown);
        rightStep = findViewById(R.id.btnRight);
        upStep = findViewById(R.id.btnUp);

        //Sequence box
        firstStep = findViewById(R.id.firstStepImage);
        secondStep = findViewById(R.id.secondStepImage);
        thirdStep = findViewById(R.id.thirdStepImage);
        fourthStep = findViewById(R.id.fourthStepImage);

        //Execute Button
        execute = findViewById(R.id.btnExecute);

        //Reset Button
        reset = findViewById(R.id.btnReset);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.firstStepImage).setOnDragListener(dragListener);
        findViewById(R.id.secondStepImage).setOnDragListener(dragListener);
        findViewById(R.id.thirdStepImage).setOnDragListener(dragListener);
        findViewById(R.id.fourthStepImage).setOnDragListener(dragListener);

        //add or remove any view that you don't want to be dragged
        leftStep.setOnLongClickListener(longClickListener);
        upStep.setOnLongClickListener(longClickListener);
        rightStep.setOnLongClickListener(longClickListener);
        downStep.setOnLongClickListener(longClickListener);

        Reset();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelTwoEpisodeThree.this, MainLoggedInDifficulty.class);
                startActivity(i);
            }
        });

        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = CheckForSequence();
                //If user sequence is == correct sequence, proceed
                if(check == true){
                    //Correct
                    PlayAnimation();
                    set.addListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    switch (which){
                                                        case DialogInterface.BUTTON_POSITIVE:
                                                            //Yes button clicked
                                                            Intent i = new Intent(LevelTwoEpisodeThree.this, MainLoggedInActivity.class);
                                                            startActivity(i);
                                                            break;

                                                        case DialogInterface.BUTTON_NEGATIVE:
                                                            //No button clicked
                                                            break;
                                                    }
                                                }
                                            };

                                            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                                            builder.setMessage("Correct Sequence! Return to main menu?").setPositiveButton("Yes", dialogClickListener)
                                                    .setNegativeButton("No", dialogClickListener).show();
                                        }
                                    });

                }else {
                    //Incorrect
                    // setup the alert builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Try Again");
                    builder.setMessage("Sequence was incorrect!");

                    // add a button
                    builder.setPositiveButton("OK", null);

                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
            }
        });
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
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DROP:
                    // Invalidates the view to force a redraw
                    v.invalidate();
                    View view = (View) event.getLocalState();
                    ((ImageView) v).setImageDrawable( ((ImageView)view).getBackground());
                    view.setVisibility(View.VISIBLE);
                    break;
            }

            return true;
        }
    };

    //Reset image boxes and sequence
    private void Reset(){
        userSequence = null;
        firstStep.setImageDrawable(null);
        secondStep.setImageDrawable(null);
        thirdStep.setImageDrawable(null);
    }

    //Used to see if the users sequence is correct
    private boolean CheckForSequence(){
        userSequence = new int[4];

        Drawable step;
        Drawable left = leftStep.getBackground();
        Drawable up = upStep.getBackground();
        Drawable down = downStep.getBackground();
        Drawable right = rightStep.getBackground();

        for(int i = 0; i < correctSequence.length; i++) {
            //Get user sequence
            if(i == 0){
                step = firstStep.getDrawable();
            }
            else if(i == 1){
                step = secondStep.getDrawable();
            }
            else if(i == 2){
                step = thirdStep.getDrawable();
            }
            else{
                step = null;
            }

            //Set user sequence
            if(step == left) {
                userSequence[i] = 0;
            }
            else if(step == up){
                userSequence[i] = 1;
            }
            else if(step == down){
                userSequence[i] = 2;
            }
            else if(step == right){
                userSequence[i] = 3;
            }
        }

        return Arrays.equals(userSequence, correctSequence) ? true : false;
    }

    //Play the character movement animation
    private void PlayAnimation(){
        //Down
        ObjectAnimator moveDown = ObjectAnimator.ofFloat(player, "translationY", 540f);
        moveDown.setDuration(1500);
        //Left
        ObjectAnimator rotateLeft = ObjectAnimator.ofFloat(player, "rotation", 90f);
        rotateLeft.setDuration(100);
        ObjectAnimator moveLeft = ObjectAnimator.ofFloat(player, "translationX", -1030f);
        moveLeft.setDuration(4000);
        //Up
        ObjectAnimator rotateDown = ObjectAnimator.ofFloat(player, "rotation", 180f);
        rotateDown.setDuration(100);
        ObjectAnimator moveDownTwo = ObjectAnimator.ofFloat(player, "translationY", 350f);
        moveDownTwo.setDuration(1500);
        //Left
        ObjectAnimator rotateLeftTwo = ObjectAnimator.ofFloat(player, "rotation", 90f);
        rotateLeftTwo.setDuration(100);
        ObjectAnimator moveLeftTwo = ObjectAnimator.ofFloat(player, "translationX", -1180f);
        moveLeftTwo.setDuration(1500);

        set = new AnimatorSet();
        set.playSequentially(moveDown, rotateLeft, moveLeft, rotateDown, moveDownTwo, rotateLeftTwo, moveLeftTwo);
        set.start();
    }
}
