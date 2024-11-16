package com.example.selfquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton startNew = findViewById(R.id.startNewQuiz);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswers = findViewById(R.id.incorrectAnswers);

        //get information from Quizactivity
        final int getCorrectAnswers = getIntent().getIntExtra("Correct", 0);
        final int getIncorrectAnswers = getIntent().getIntExtra("Incorrect", 0);

        correctAnswers.setText("Correct " + String.valueOf(getCorrectAnswers));
        incorrectAnswers.setText("Incorrect " + String.valueOf(getIncorrectAnswers));

        Intent intent = new Intent(QuizResult.this, Scores.class);

        //get topic title for scoreboard
        String topic = getIntent().getStringExtra("selectedTopic");
        intent.putExtra("score", getCorrectAnswers);
        intent.putExtra("topic",topic);


        final String selectedTopicName = getIntent().getStringExtra("selectedTopic");
        intent.putExtra("selectedTopic", selectedTopicName);

        startNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });
    }
}