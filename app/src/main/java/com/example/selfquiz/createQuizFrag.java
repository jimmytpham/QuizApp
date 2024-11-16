package com.example.selfquiz;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link createQuizFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class createQuizFrag extends Fragment {

    EditText enterQuestion, enterOption1, enterOption2, enterOption3, enterOption4;
    CheckBox option1Correct,option2Correct,option3Correct,option4Correct;
    Button exitButton, nextCreateButton, saveQuizButton;
    private ArrayList<createQuestionsList> questionsList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public createQuizFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment createQuizFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static createQuizFrag newInstance(String param1, String param2) {
        createQuizFrag fragment = new createQuizFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_quiz, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        enterQuestion = getView().findViewById(R.id.enterQuestion);
        enterOption1 = getView().findViewById(R.id.enterOption1);
        enterOption2 = getView().findViewById(R.id.enterOption2);
        enterOption3 = getView().findViewById(R.id.enterOption3);
        enterOption4 = getView().findViewById(R.id.enterOption4);

        option1Correct = getView().findViewById(R.id.option1Correct);
        option2Correct = getView().findViewById(R.id.option2Correct);
        option3Correct = getView().findViewById(R.id.option3Correct);
        option4Correct = getView().findViewById(R.id.option4Correct);

        nextCreateButton = getView().findViewById(R.id.nextCreateQuestion);
        nextCreateButton.setOnClickListener(view1 -> nextCreateButton());

        saveQuizButton = getView().findViewById(R.id.saveCreateQuiz);
        saveQuizButton.setOnClickListener(view1 -> saveQuizButton());

        exitButton = getView().findViewById(R.id.exitCreateQuiz);
        exitButton.setOnClickListener(view1 -> exitButton());

    }

    public void nextCreateButton(){

        if ((enterQuestion.getText().toString().isEmpty()) || enterOption1.getText().toString().isEmpty()
                || enterOption2.getText().toString().isEmpty() || enterOption3.getText().toString().isEmpty()
                || enterOption4.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "You must fill in each slot!", Toast.LENGTH_SHORT).show();


        } else{
            optionCorrect();
            createQuestionsList input = new createQuestionsList (enterQuestion.getText().toString(), enterOption1.getText().toString(), enterOption2.getText().toString(),
                  enterOption3.getText().toString(), enterOption4.getText().toString(), optionCorrect(), "");
            questionsList.add(input);
            enterQuestion.setText("");
            enterOption1.setText("");
            enterOption2.setText("");
            enterOption3.setText("");
            enterOption4.setText("");
        }
    }

    public String optionCorrect(){

        String optionCorrect = "";
        if (option1Correct.isChecked()&&option2Correct.isChecked() || option1Correct.isChecked()&&option3Correct.isChecked() || option1Correct.isChecked()&&option4Correct.isChecked()
                ||option2Correct.isChecked()&&option3Correct.isChecked()|| option2Correct.isChecked()&&option4Correct.isChecked()||option3Correct.isChecked()&&option4Correct.isChecked())
            Toast.makeText(getActivity(),"Only 1 option can be correct!", Toast.LENGTH_SHORT).show();
        else{
           if (option1Correct.isChecked()){
               optionCorrect = enterOption1.getText().toString();
           } if (option2Correct.isChecked()){
                optionCorrect = enterOption2.getText().toString();
            } if (option3Correct.isChecked()){
                optionCorrect = enterOption3.getText().toString();
            } if (option4Correct.isChecked()){
                optionCorrect = enterOption4.getText().toString();
            }
        }
        return optionCorrect;
    }

    @SuppressLint("SuspiciousIndentation")
    public void saveQuizButton(){
        if ((enterQuestion.getText().toString().isEmpty()) || enterOption1.getText().toString().isEmpty()
                || enterOption2.getText().toString().isEmpty() || enterOption3.getText().toString().isEmpty()
                || enterOption4.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "You must fill in each slot!", Toast.LENGTH_SHORT).show();
        } else {
            optionCorrect();
            createQuestionsList input = new createQuestionsList(enterQuestion.getText().toString(), enterOption1.getText().toString(), enterOption2.getText().toString(),
                    enterOption3.getText().toString(), enterOption4.getText().toString(), optionCorrect(), "");
            questionsList.add(input);
        }

        //pass on questionslist to quizActivity
        Intent intent = new Intent(getActivity(), createQuizActivity.class);
        intent.putExtra("questionsList", questionsList);

        //pass on topic title to quizActivity
        Bundle extras = getActivity().getIntent().getExtras();

        if (extras != null) {
            String myString = getArguments().getString("topic");
            intent.putExtra("topic", myString);
            startActivity(intent);
        }else
        startActivity(intent);
    }


    public void exitButton(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle(R.string.create);
        materialAlertDialogBuilder.setMessage("Are you sure you want to exit without saving?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}
class MyClass implements Serializable{

    private ArrayList<QuestionsList> mDataList;

    public MyClass(ArrayList<QuestionsList> dataList){
        mDataList = dataList;
    }

    public ArrayList<QuestionsList> getDataList(){
        return mDataList;
    }

    public void setDataList(ArrayList<QuestionsList> dataList) {
        this.mDataList = dataList;
    }
}