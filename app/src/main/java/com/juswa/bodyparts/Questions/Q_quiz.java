package com.juswa.bodyparts.Questions;

public class Q_quiz {

    private String Questions[] ={
            "What are the five human senses?",
            "Which of these sense organs helps with vision?",
            "Which organ in the human body pumps blood?",
            "Which of these organs is used for breathing?",
            "Which of these organs can grow back again if some of it is removed?",
            "Which of these organs is vital for thinking?",
            "Which of these sense organs is vital for your sense of smell?",
            "Which of these sense organs helps us to hear?",
            "Which of these sense organs helps us to swallow food?",
            "Which of these sense organs covers our skeletal system?",
            "Which of these organs helps to purify blood?",

    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"A. Hearing","B. sight","C. smell","D. Hearing, sight, smell, touch and taste"},
            {"Tongue","Nose","Eyes","Ears"},
            {"Liver","Intestines","Kidney","Heart"},
            {"Lungs","Legs","Liver"," Nose"},
            {"Brain","Kidney","Liver","Heart"},
            {"Brain","Lungs","Heart","Legs"},
            {"Tongue","Eyes","Nose","Ears"},
            {"Eyes","Mouth","Nose","Ears"},
            {"Tongue","Ears","Nose","Eyes"},
            {"Skin","Heart","Nose","Mouth"},
            {"Alveoli","Heart","Kidneys","Lungs"},







    };

    // array of correct answers - in the same order as array of questions
    private String mCorrectAnswers[] = {
            "D. Hearing, sight, smell, touch and taste",
            "Eyes",
            "Heart",
            "Lungs",
            "Liver",
            "Brain",
            "Nose",
            "Ears",
            "Tongue",
            "Skin",
            "Kidneys"

    };

    private String subanswer[]= {
            "D. Hearing, sight, smell, touch and taste",
            "Eyes",
            "Heart",
            "Lungs",
            "Liver",
            "Brain",
            "Nose",
            "Ears",
            "Tongue",
            "Skin",
            "Kidneys"

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
