package com.example.selfquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class CreateQuiz extends AppCompatActivity {

    EditText quizTitle;
    AppCompatButton back, next;

    public static ArrayList<String> categoryList = new ArrayList<String>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquiz);

        quizTitle = findViewById(R.id.enterTitle);
        back = findViewById(R.id.backQuiz);
        next = findViewById(R.id.saveQuizTitle);

        //set back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //set next button
        next.setOnClickListener(view -> {
            //if empty, toast message
            if (quizTitle.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter a Topic Title!", Toast.LENGTH_SHORT).show();
            }else
                //start the createquizfrag to enter question data
               getSupportFragmentManager().beginTransaction().replace(R.id.container, new createQuizFrag()).commit();
        });

        //pass on topic for title header
        String myString = quizTitle.getText().toString();
        //pass on the users entered topic to the next fragment
        Bundle bundle = new Bundle();
        bundle.putString("topic", myString);
        createQuizFrag fragment = new createQuizFrag();
        fragment.setArguments(bundle);

        //pass on the category list to main activity for spinner
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("myList",  categoryList);
    }


    @SuppressLint("SuspiciousIndentation")
    public static ArrayList<String> getStringArray () {
        categoryList.add("Java");
        categoryList.add("Biology");
        categoryList.add("Cardiology");
        categoryList.add("Chemistry");

        return categoryList;
    }
}