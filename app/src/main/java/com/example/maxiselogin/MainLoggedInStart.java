//package com.example.maxiselogin;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentTransaction;
//
//import com.example.maxiselogin.QuizFragment.QuestionOneFragment;
//
//public class MainLoggedInStart extends AppCompatActivity {
//
//    public static final String SHARED_PREFS = "sharedPrefs";
//    public static final String QUESTION_ONE = "questionOne";
//    public static final String QUESTION_TWO = "questionTwo";
//    public static final String QUESTION_THREE = "questionThree";
//    public static final String QUESTION_FOUR = "questionFour";
//    public static final String QUESTION_FIVE = "questionFive";
//    public static final String SCORE = "score";
//
//    //Save the results from quizzes into sharedpref
//    public int saveData(SharedPreferences sharedPreferences, int quizNum, String ans){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        int score = getScoreData(sharedPreferences,"SCORE");
//        switch(quizNum){
//            case 1:
//                if(ans.equals("50")){ //user chose correct answer
//                    editor.putInt(SCORE, score+20);
//                    editor.putBoolean(QUESTION_ONE, true);
//                }else{
//                    editor.putBoolean(QUESTION_ONE, false);
//                }
//                break;
//            case 2:
//                if(ans.equals("8")){ //user chose correct answer
//                    editor.putInt(SCORE, score+20);
//                    editor.putBoolean(QUESTION_TWO, true);
//                }else{
//                    editor.putBoolean(QUESTION_TWO, false);
//                }
//                break;
//            case 3:
//                if(ans.equals("32")){ //user chose correct answer
//                    editor.putInt(SCORE, score+20);
//                    editor.putBoolean(QUESTION_THREE, true);
//                }else{
//                    editor.putBoolean(QUESTION_THREE, false);
//                }
//                break;
//            case 4:
//                if(ans.equals("Tomato") || ans.equals("Cucumber") || ans.equals("Apple")) { //user chose correct answer
//                    editor.putInt(SCORE, score+7);
//                    editor.putInt(QUESTION_FOUR, getScoreData(sharedPreferences,"QFOUR")+7); //Calculate at the end, if total is 21, all 3 were selected, if total is 14, 2 were selected
//                }
//                else{
//                    editor.putInt(QUESTION_FOUR, getScoreData(sharedPreferences,"QFOUR")-7);
//                }
//                break;
//            case 5:
//                if(ans.equals("Mars") || ans.equals("Uranus") || ans.equals("Jupiter")) { //user chose correct answer
//                    editor.putInt(SCORE, score+7);
//                    editor.putInt(QUESTION_FIVE, getScoreData(sharedPreferences,"QFIVE")+7); //Calculate at the end, if total is 21, all 3 were selected, if total is 14, 2 were selected
//                }
//                else{
//                    editor.putInt(QUESTION_FIVE, getScoreData(sharedPreferences,"QFIVE")-7);
//                }
//                break;
//            case 6: //Check for highscore
//                //If no highscore is set,
//                HighScore hs = new HighScore(sharedPreferences);
//                int currentHighScore = hs.getHighScore(sharedPreferences);
//                if(currentHighScore < getScoreData(sharedPreferences,"SCORE")){ //Return 1 and call HighScore class, setHighScore
//                    return 1;
//                }
//                break;
//        }
//        editor.commit();
//        return 0;
//    }
//
//    public int getScoreData(SharedPreferences sharedPreferences, String key){
//        int num = 0;
//        boolean ans;
//        if(key.equals("SCORE")) {
//            num = sharedPreferences.getInt(SCORE, 0);
//        }
//        else if(key.equals("QONE")) {
//            ans = sharedPreferences.getBoolean(QUESTION_ONE, false);
//            if (ans == true) {
//                num = 1;
//            }
//        }
//        else if(key.equals("QTWO")) {
//            ans = sharedPreferences.getBoolean(QUESTION_TWO, false);
//            if(ans == true){
//                num = 1;
//            }
//        }
//        else if(key.equals("QTHREE")){
//            ans = sharedPreferences.getBoolean(QUESTION_THREE, false);
//            if(ans == true){
//                num = 1;
//            }
//        }
//        else if(key.equals("QFOUR")){
//            num = sharedPreferences.getInt(QUESTION_FOUR, 0);
//            if(num >= 21){
//                num = 21;
//            }
//            else if(num == 14)
//            {
//                num = 14;
//            }
//            else if(num == 7)
//            {
//                num = 7;
//            }
//            else num = 0;
//        }
//        else if(key.equals("QFIVE")){
//            num = sharedPreferences.getInt(QUESTION_FIVE, 0);
//            if(num >= 21){
//                num = 21;
//            }
//            else if(num == 14)
//            {
//                num = 14;
//            }
//            else if(num == 7)
//            {
//                num = 7;
//            }
//            else num = 0;
//        }
//
//        return num;
//    }
//
//    public void resetScoreData(SharedPreferences sharedPreferences){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(SCORE, 0);
//        editor.putBoolean(QUESTION_ONE, false);
//        editor.putBoolean(QUESTION_TWO, false);
//        editor.putBoolean(QUESTION_THREE, false);
//        editor.putInt(QUESTION_FOUR, 0);
//        editor.putInt(QUESTION_FIVE, 0);
//        editor.commit();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_li_start);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.quiz_fragment, new QuestionOneFragment());
//        fragmentTransaction.commit();
//    }
//
//    public void PreviousPageStart(View view) {
//        Intent i = new Intent(MainLoggedInStart.this, MainLoggedInActivity.class);
//        startActivity(i);
//    }
//
//}
