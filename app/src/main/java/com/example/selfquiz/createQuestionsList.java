package com.example.selfquiz;

import android.os.Parcel;
import android.os.Parcelable;

public class createQuestionsList implements Parcelable {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String selectedAnswer;

    public createQuestionsList (String question, String option1, String option2, String option3, String option4, String correctAnswer, String selectedAnswer){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.selectedAnswer = selectedAnswer;
    }

    protected createQuestionsList(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
        correctAnswer = in.readString();
        selectedAnswer = in.readString();
    }

    public static final Creator<createQuestionsList> CREATOR = new Creator<createQuestionsList>() {
        @Override
        public createQuestionsList createFromParcel(Parcel in) {
            return new createQuestionsList(in);
        }

        @Override
        public createQuestionsList[] newArray(int size) {
            return new createQuestionsList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(option1);
        parcel.writeString(option2);
        parcel.writeString(option3);
        parcel.writeString(option4);
        parcel.writeString(correctAnswer);
        parcel.writeString(selectedAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer(){
        return correctAnswer;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
