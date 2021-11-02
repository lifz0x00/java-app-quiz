package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstQuestion;
    RadioGroup secondQuestion, thirdQuestion, fifthQuestion, sixthQuestion;
    CheckBox fourthQuestion1, fourthQuestion2, fourthQuestion4;
    RadioButton radioButtonSecondQuestion, radioButtonThirdQuestion,
            radioButtonFifthQuestion,
            radioButtonSixthQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Submit = findViewById(R.id.button_id);

        firstQuestion = findViewById(R.id.Name_Edit_Text);
        secondQuestion = findViewById(R.id.radio_group_second_question);
        thirdQuestion = findViewById(R.id.radio_group_third_question);
        fifthQuestion = findViewById(R.id.radio_group_fifth_question);
        sixthQuestion = findViewById(R.id.radio_group_sixth_question);

        fourthQuestion1 = findViewById(R.id.checkBox1);
        fourthQuestion2 = findViewById(R.id.checkBox2);
        fourthQuestion4 = findViewById(R.id.checkBox4);


        radioButtonSecondQuestion = findViewById(R.id.radioButtonSecondQuestion);
        radioButtonThirdQuestion = findViewById(R.id.radioButtonThirdQuestion);
        radioButtonFifthQuestion = findViewById(R.id.radioButtonFifthQuestion);
        radioButtonSixthQuestion = findViewById(R.id.radioButtonSixthQuestion);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (allQuestionsAreFilledIn()) {
                    checkScores();
                } else {
                    Toast.makeText(MainActivity.this, R.string.answer_to_all_please, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    // checks if all questions have some answer...

    private boolean allQuestionsAreFilledIn() {

        if (firstQuestion.getText().toString().isEmpty() || secondQuestion.getCheckedRadioButtonId() == -1
                || thirdQuestion.getCheckedRadioButtonId() == -1
                || fifthQuestion.getCheckedRadioButtonId() == -1
                || sixthQuestion.getCheckedRadioButtonId() == -1
                || (!fourthQuestion1.isChecked() && !fourthQuestion2.isChecked() &&
                !fourthQuestion4.isChecked())) {
            return false;
        }
        return true;
    }

    // checks the right answers and calculates scores

    private void checkScores() {
        int scoreQuiz = 0;
        if (radioButtonSecondQuestion.isChecked()) {
            scoreQuiz++;
        }
        if (radioButtonThirdQuestion.isChecked()) {
            scoreQuiz++;
        }
        if (fourthQuestion1.isChecked() && fourthQuestion2.isChecked() && fourthQuestion4.isChecked()) {
            scoreQuiz++;
        }
        if (radioButtonFifthQuestion.isChecked()) {
            scoreQuiz++;
        }
        if (radioButtonSixthQuestion.isChecked()) {
            scoreQuiz++;
        }

        displayResult(scoreQuiz);

    }

    // display the result of the quiz

    private void displayResult(int score) {

        Toast.makeText(this, "Hi " + firstQuestion.getText().toString()
                + " Hasil Kuis Anda " + score + "/5", Toast.LENGTH_SHORT).show();
    }
}


