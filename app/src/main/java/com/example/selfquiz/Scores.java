package com.example.selfquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Scores extends AppCompatActivity {

    private ListView scoresListView;
    Button main, settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);


        scoresListView = this.findViewById(R.id.scoreStats);

        main = findViewById(R.id.menuButton);
        settings = findViewById(R.id.optionsButton);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scores.this, MainActivity.class));
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scores.this, Settings.class));
                finish();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        //receives information from quizResult activity
        ArrayList<String> tempStringArrayHighScore = new ArrayList<>();
        String topic = getIntent().getStringExtra("selectedTopic");
        int score = getIntent().getIntExtra("score", 0);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        int highscore = sharedPreferences.getInt("highscore",0);
        if (highscore >=score)
            tempStringArrayHighScore.add(topic +" "+ highscore);
        else{
            tempStringArrayHighScore.add("New highscore: "+ score);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }

        ArrayAdapter<String> scoresAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tempStringArrayHighScore);
        scoresListView.setAdapter(scoresAdapter);
    }

}
