package com.example.selfquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton start;
        final Button scores, settings, createQuiz;
        Spinner categorySpinner;

        categorySpinner = findViewById(R.id.categorySpinner);
        scores = findViewById(R.id.score);
        settings = findViewById(R.id.settings);
        start = findViewById(R.id.start);
        createQuiz = findViewById(R.id.createQuiz);

        //sets spinner from data in createQuiz
        String[] myList = CreateQuiz.getStringArray().toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        categorySpinner.setAdapter(adapter);

        //buttons to open different activities
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Scores.class));
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });

        createQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateQuiz.class));
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = categorySpinner.getSelectedItem().toString();
                openCategory(item);
            }
        });

    }

    private void openCategory (String activity){

        //switch statement for each activity
        switch (activity) {
            case "Java":
                Intent javaIntent = new Intent(MainActivity.this, QuizActivity.class);
                selectedTopicName = "Java";
                javaIntent.putExtra("selectedTopic", selectedTopicName);
                startActivity(javaIntent);
                finish();
                break;
            case "Biology":
                Intent biologyIntent = new Intent(MainActivity.this, QuizActivity.class);
                selectedTopicName = "Biology";
                biologyIntent.putExtra("selectedTopic", selectedTopicName);
                startActivity(biologyIntent);
                finish();
                break;
            case "Chemistry":
                Intent chemistryIntent = new Intent(MainActivity.this, QuizActivity.class);
                selectedTopicName = "Chemistry";
                chemistryIntent.putExtra("selectedTopic", selectedTopicName);
                startActivity(chemistryIntent);
                finish();
                break;
            case "Cardiology":
                Intent cardiologyIntent = new Intent(MainActivity.this, QuizActivity.class);
                selectedTopicName = "Cardiology";
                cardiologyIntent.putExtra("selectedTopic", selectedTopicName);
                startActivity(cardiologyIntent);
                finish();
                break;
            default:
                break;
        }
    }

    //alert message for exiting app
    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are you sure you want to exit this app?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }

    //disclaimer and about us section
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        int id = item.getItemId();
        if (id == R.id.about){
            Dialog about = new Dialog(MainActivity.this);
            about.requestWindowFeature(Window.FEATURE_NO_TITLE);
            about.setContentView(R.layout.about);
            about.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            about.show();
        } else if (id == R.id.disclaimer){
            Dialog disclaimer = new Dialog(MainActivity.this);
            disclaimer.requestWindowFeature(Window.FEATURE_NO_TITLE);
            disclaimer.setContentView(R.layout.disclaimer);
            disclaimer.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            disclaimer.show();
        }
        return super.onOptionsItemSelected(item);

    }
}