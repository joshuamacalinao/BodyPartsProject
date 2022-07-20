package com.juswa.bodyparts.Questions;

import com.juswa.bodyparts.R;

public class Q_tap {

    private String Questions[] ={
            "What is this?",
            "What is this?",
            "What is this?",
            "What is this?",
            "What is this?",
            "Choose the correct option.",
            "Touch your _______ !",
            "Touch your _____ !",
            "Can you name these parts? \uD83D\uDE48"



    };

    private int Images[] = {
            R.drawable.q1,
            R.drawable.q2,
            R.drawable.q3,
            R.drawable.q4,
            R.drawable.q5,
            R.drawable.q6,
            R.drawable.q7,
            R.drawable.q8,
            R.drawable.q10
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"head","toes","hair","hand"},
            {"arm","leg","hand","elbow"},
            {"arm","hair","head","hand"},
            {"mouth","ear","eye","nose"},
            {"eyes","ears","nose","mouth"},
            {"head","hair","hand","nose"},
            {"shoulders","arms","legs","knees"},
            {"face","shoulders","head","knee"},
            {"nose","eye","hand","leg"},








    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {
            "hand","leg","head","mouth","ears","hair","knees","shoulders","eye"



    };

    private String subanswer[]= {
            "hand","leg","head","mouth","ears","hair","knees","shoulders","eye"
    };

    //     method returns number of questions
    public int getLength(){
        return Questions.length;
    }


    // method returns question from array textQuestions[] based on array index
    public String getQuestion(int a) {
        String question = Questions[a];
        return question;
    }

    public int getQuestionImg(int a) {
        int question = Images[a];
        return question;
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    //  method returns correct answer for the question based on array index
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public String getsubanswer(int a)
    {
        String getsubanswer = subanswer[a];
        return getsubanswer;
    }

}
