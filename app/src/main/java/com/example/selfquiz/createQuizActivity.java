package com.example.selfquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import java.util.ArrayList;
import java.util.Locale;

public class createQuizActivity extends AppCompatActivity {

    //for quiz results
    private String HIGHSCORE = "High Score";
    private SharedPreferences sharedPreferencesHighScore;
    private SharedPreferences.Editor editor;

    Button back;
    TextView selectedTopic, timeLeft;
    private TextView questionNumber, question;
    private AppCompatButton option1, option2, option3, option4, nextButton;

    //countdown timer
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private int currentQuestionPosition = 0;
    private String selectedOption = "";

    ArrayList<createQuestionsList> questionsList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);



        back = findViewById(R.id.backButton);
        timeLeft = findViewById(R.id.timeLeft);
        selectedTopic = findViewById(R.id.selectedTopic);

        questionNumber = findViewById(R.id.questionNumber);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextButton = findViewById(R.id.nextButton);

        final String topicName = getIntent().getStringExtra("topic");
        selectedTopic.setText(topicName);

        //gets the questions from parcelable createQuiz fragment
        ArrayList<createQuestionsList> questionsList = getIntent().getParcelableArrayListExtra("questionsList");


        questionNumber.setText((currentQuestionPosition+1)+"/"+questionsList.size());
        question.setText(questionsList.get(0).getQuestion());
        option1.setText(questionsList.get(0).getOption1());
        option2.setText(questionsList.get(0).getOption2());
        option3.setText(questionsList.get(0).getOption3());
        option4.setText(questionsList.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option1.getText().toString();

                    //sets background to red if incorrect
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer(questionsList);

                    questionsList.get(currentQuestionPosition).setSelectedAnswer(selectedOption);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option2.getText().toString();

                    //sets background to red if incorrect
                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer(questionsList);

                    questionsList.get(currentQuestionPosition).setSelectedAnswer(selectedOption);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option3.getText().toString();

                    //sets background to red if incorrect
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer(questionsList);

                    questionsList.get(currentQuestionPosition).setSelectedAnswer(selectedOption);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.isEmpty()){
                    selectedOption = option4.getText().toString();

                    //sets background to red if incorrect
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer(questionsList);

                    questionsList.get(currentQuestionPosition).setSelectedAnswer(selectedOption);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedOption.isEmpty()){
                    Toast.makeText(createQuizActivity.this, "Please select an option.", Toast.LENGTH_SHORT).show();
                } else {
                    nextQuestion();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(createQuizActivity.this, MainActivity.class));
                finish();
            }
        });
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startTimer();
    }


    private int getCorrectAnswer(){

        int correctAnswers = 0 ;

        for (int i=0; i<questionsList.size(); i++){

            final String getSelectedAnswers = questionsList.get(i).getSelectedAnswer();
            final String getAnswers = questionsList.get(i).getAnswer();

            if (getSelectedAnswers.equals(getAnswers)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswer(){
        int incorrectAnswers = 0;

        for (int i=0; i<questionsList.size(); i++){

            final String getSelectedAnswers = questionsList.get(i).getSelectedAnswer();
            final String getAnswers = questionsList.get(i).getAnswer();

            if (!getSelectedAnswers.equals(getAnswers)){
                incorrectAnswers++;
            }
        }

        return incorrectAnswers;
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent (createQuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer(ArrayList<createQuestionsList> questionsList){

        final String getAnswer = questionsList.get(currentQuestionPosition).getAnswer();

        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green);
            option1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
            option2.setTextColor(Color.WHITE);
        } else if (option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green);
            option3.setTextColor(Color.WHITE);
        } else if (option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green);
            option4.setTextColor(Color.WHITE);
        }
    }
    private void nextQuestion(){

        currentQuestionPosition++;

        if ((currentQuestionPosition+1)== questionsList.size()){
            nextButton.setText("Submit Quiz");
        }
        if (currentQuestionPosition<questionsList.size()){

            selectedOption = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questionNumber.setText((currentQuestionPosition+1)+"/"+questionsList.size());
            questionNumber.setText((currentQuestionPosition+1)+"/"+questionsList.size());
            question.setText(questionsList.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsList.get(currentQuestionPosition).getOption1());
            option2.setText(questionsList.get(currentQuestionPosition).getOption2());
            option3.setText(questionsList.get(currentQuestionPosition).getOption3());
            option4.setText(questionsList.get(currentQuestionPosition).getOption4());

            timeLeftInMillis=COUNTDOWN_IN_MILLIS;
            updateCountDownText();
        } else {
            countDownTimer.cancel();
            Intent intent = new Intent(createQuizActivity.this, QuizResult.class);
            intent.putExtra("Correct", getCorrectAnswer());
            intent.putExtra("Incorrect", getIncorrectAnswer());

            final String selectedTopicName = getIntent().getStringExtra("selectedTopic");
            intent.putExtra("selectedTopic", selectedTopicName);

            startActivity(intent);
            finish();
        }

    }
    private void startTimer(){
        SharedPreferences sharedPreferences = getSharedPreferences("Timer", MODE_PRIVATE);
        boolean timerState = sharedPreferences.getBoolean("timerState", false);
        if (timerState) {
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    timeLeftInMillis = 0;
                    updateCountDownText();
                    if ((currentQuestionPosition + 1) == questionsList.size()) {
                        Intent intent = new Intent(createQuizActivity.this, QuizResult.class);
                        intent.putExtra("Correct", getCorrectAnswer());
                        intent.putExtra("Incorrect", getIncorrectAnswer());

                        final String selectedTopicName = getIntent().getStringExtra("selectedTopic");
                        intent.putExtra("selectedTopic", selectedTopicName);

                        startActivity(intent);
                        finish();
                    } else {
                        getIncorrectAnswer();
                        nextQuestion();
                        countDownTimer.cancel();
                        startTimer();
                    }
                }
            }.start();
        }
    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis/1000)/60;
        int seconds = (int) (timeLeftInMillis/1000)%60;

        String timeFormatted  = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        timeLeft.setText(timeFormatted);

        if (timeLeftInMillis<10000)
            timeLeft.setTextColor(Color.RED);
        else
            timeLeft.setTextColor(Color.BLACK);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}

