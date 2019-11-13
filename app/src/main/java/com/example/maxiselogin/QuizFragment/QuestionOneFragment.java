package com.example.maxiselogin.QuizFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maxiselogin.MainLoggedInStart;
import com.example.maxiselogin.R;

public class QuestionOneFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button submitBtn;

    public static final String SHARED_PREFS = "sharedPrefs";

    SharedPreferences sharedPreferences;
    MainLoggedInStart ls = new MainLoggedInStart();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_quiz_question_one, container, false);

        sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        submitBtn = view.findViewById(R.id.btnSubmitQuizOne);
        radioGroup = view.findViewById(R.id.radioGroupQ1);
        ls.resetScoreData(sharedPreferences);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //i is the RadioButton selected
                switch(i){
                    case(R.id.btnQuizOneC1):
                        radioButton = view.findViewById(R.id.btnQuizOneC1);
                        break;
                    case(R.id.btnQuizOneC2):
                        radioButton = view.findViewById(R.id.btnQuizOneC2);
                        break;
                    case(R.id.btnQuizOneC3):
                        radioButton = view.findViewById(R.id.btnQuizOneC3);
                        break;
                    case(R.id.btnQuizOneC4):
                        radioButton = view.findViewById(R.id.btnQuizOneC4);
                        break;
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton != null) {
                    new AlertDialog.Builder(getContext())
                            .setTitle("Confirm")
                            .setMessage("Selected: " + (radioButton.getText()))
                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                    //Save results
                                    String ans = radioButton.getText().toString().trim();
                                    ls.saveData(sharedPreferences,1, ans);

                                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    ft.replace(R.id.quiz_fragment, new QuestionTwoFragment());
                                    ft.commit();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{
                    Toast.makeText(getContext(), "Select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
