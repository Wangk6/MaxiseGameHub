//package com.example.maxiselogin.QuizFragment;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.example.maxiselogin.ParentView.HighScore;
//import com.example.maxiselogin.ParentView.MainLoggedInActivity;
//import com.example.maxiselogin.MainLoggedInStart;
//import com.example.maxiselogin.R;
//
//public class QuestionResultsFragment extends Fragment {
//    Button submitQuiz;
//    ImageView q1, q2, q3, q4, q5;
//    TextView totalScore, highScoreHead;
//    EditText name;
//    int userScore;
//    boolean newHighScore = false;
//    public static final String SHARED_PREFS = "sharedPrefs";
//
//    public static final String SCORE = "score";
//    SharedPreferences sharedPreferences;
//    MainLoggedInStart ls;
//    HighScore hs;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_quiz_result, container, false);
//        q1 = view.findViewById(R.id.imgQuestionOneResult);
//        q2 = view.findViewById(R.id.imgQuestionTwoResult);
//        q3 = view.findViewById(R.id.imgQuestionThreeResult);
//        q4 = view.findViewById(R.id.imgQuestionFourResult);
//        q5 = view.findViewById(R.id.imgQuestionFiveResult);
//        submitQuiz = view.findViewById(R.id.btnSubmitQuiz);
//        highScoreHead = view.findViewById(R.id.txtDisplayNewHighScore);
//        totalScore = view.findViewById(R.id.txtTotalScore);
//        name = view.findViewById(R.id.editTextName);
//
//        sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
//        ls = new MainLoggedInStart();
//        hs = new HighScore(sharedPreferences);
//
//        userScore = ls.getScoreData(sharedPreferences,"SCORE");
//        if(userScore>100){ userScore = 100;} //Cap at 100
//
//        totalScore.setText(String.valueOf(userScore) + "%");
//        if(ls.getScoreData(sharedPreferences,"QONE") == 1){ //If correct
//            q1.setImageResource(R.drawable.ic_check_circle_black_24dp);
//        }
//        if(ls.getScoreData(sharedPreferences,"QTWO") == 1){ //If correct
//            q2.setImageResource(R.drawable.ic_check_circle_black_24dp);
//        }
//        if(ls.getScoreData(sharedPreferences,"QTHREE") == 1){ //If correct
//            q3.setImageResource(R.drawable.ic_check_circle_black_24dp);
//        }
//
//        int qFourScore = ls.getScoreData(sharedPreferences,"QFOUR");
//        if(qFourScore > 20){ //If correct
//            q4.setImageResource(R.drawable.ic_check_circle_black_24dp);
//        }
//        else if(qFourScore >= 7){
//            q4.setImageResource(R.drawable.ic_part_wrong_24dp);
//        }
//
//        int qFiveScore = ls.getScoreData(sharedPreferences,"QFIVE");
//
//        if(qFiveScore > 20){ //If correct
//            q5.setImageResource(R.drawable.ic_check_circle_black_24dp);
//        }
//        else if(qFiveScore >= 7){
//            q5.setImageResource(R.drawable.ic_part_wrong_24dp);
//        }
//
//        if(userScore > hs.getHighScore(sharedPreferences)){
//            highScoreHead.setVisibility(View.VISIBLE);
//            name.setVisibility(View.VISIBLE);
//            newHighScore = true;
//        }
//
//        submitQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(newHighScore == true) {
//                    String userName = name.getText().toString().trim();
//                    if (!userName.equals("")) {
//                        hs.setHighScore(sharedPreferences, userScore, userName);
//                        Intent i = new Intent(getActivity(), MainLoggedInActivity.class);
//                        startActivity(i);
//                    }
//                    else {
//                        Toast.makeText(getContext(), "Please enter your name", Toast.LENGTH_SHORT );
//                    }
//                }
//                else{
//                    Intent i = new Intent(getActivity(), MainLoggedInActivity.class);
//                    startActivity(i);
//                }
//            }
//        });
//
//        return view;
//    }
//
//}
