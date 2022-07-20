package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.button.MaterialButton;
import com.juswa.bodyparts.Questions.Q_quiz;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class Quiz extends AppCompatActivity {


    Methods methods;
    @BindView(R.id.back)
    MaterialButton back;

    @BindView(R.id.bgsound)
    ImageView sound;
    private boolean soundOn = true;
    MediaPlayer player;
    @BindView(R.id.hart) ImageView heart;
    @BindView(R.id.setting)
    ImageView pause;
    private  boolean ifpause = true;



    @BindViews({R.id.a,R.id.b,R.id.c,R.id.d})
    MaterialButton[] choices;
    private Q_quiz questtion = new Q_quiz();
    private String answer; //correct answer
    private String subans;
    private int int_score = 0; //current score
    private int int_stage = 0;
    private  int life = 5;

    private int intQuestion = (int)(3 * Math.random()) + 1;
    @BindView(R.id.question) TextView question;
    @BindView(R.id.score) TextView score;
    @BindView(R.id.buhay) TextView buhay;
    private static int timer = 2000; // 2sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        methods = new Methods(this);
        BounceView.addAnimTo(back);
        playsound();
        back.setOnClickListener(v -> {
            methods.btnclickEffect();
            methods.intent(HomePage.class,this);
            stop();
        });

        BounceView.addAnimTo(sound);
        methods.pulse_img(heart);
        sound.setOnClickListener(v -> {
            methods.btnclickEffect();
            if(soundOn){
                soundOn = false;
                stop();
                sound.setImageResource(R.drawable.ic_no_sound);
            }
            else{
                soundOn = true;
                playsound();
                sound.setImageResource(R.drawable.ic_sound);
            }
        });

        BounceView.addAnimTo(pause);
        pause.setOnClickListener(v -> {
            methods.btnclickEffect();
            if(ifpause){
                ifpause = false;
                option();
                pause.setImageResource(R.drawable.ic_play);
            }
            else{
                ifpause = true;
                pause.setImageResource(R.drawable.ic_pause);
            }
        });
        updatequestion();
        updateScore(int_score);
        mylife();
    }

    protected void mylife(){
        String getlife = String.valueOf(life);
        buhay.setText(getlife);
        if(life == 0) {
            methods.GameOver("Score : "+int_score);
            methods.Modaldone.setOnClickListener(v -> {
                methods.alert.dismiss();
                methods.intent(HomePage.class,v.getContext());
                finish();
            });
        }
    }


    private void updatequestion(){
        if (intQuestion < questtion.getLength())
        {
            new Handler().postDelayed(() -> {

                BounceView.addAnimTo(question);
                BounceView.addAnimTo( choices[0]);
                BounceView.addAnimTo( choices[1]);
                BounceView.addAnimTo(choices[2]);
                BounceView.addAnimTo(choices[3]);
                question.setText(questtion.getQuestion(intQuestion));
                choices[0].setText(questtion.getChoice(intQuestion,1));
                choices[1].setText(questtion.getChoice(intQuestion,2));
                choices[2].setText(questtion.getChoice(intQuestion,3));
                choices[3].setText(questtion.getChoice(intQuestion,4));
                answer = questtion.getCorrectAnswer(intQuestion);
                subans = questtion.getsubanswer(intQuestion);
                intQuestion++;
            }, timer);
        }
        else{
            new Handler().postDelayed(() -> {
                methods.GameOver("Score : " + int_score);
                methods.Modaldone.setOnClickListener(v -> {
                    methods.alert.dismiss();
                    methods.intent(HomePage.class,v.getContext());
                    finish();
                });
            }, timer);
        }

    }

    private void updateScore(int point){
        score.setText("Score:" + int_score);
    }
    public void onClick(View view){
        Button btn_answer = (Button) view;
        String getanswer = subans;
        if (btn_answer.getText() == answer){
            methods.toast(R.drawable.ic_icons8_happy,"Correct!", Gravity.CENTER_VERTICAL,0 ,0);
            methods.correct();
            int_score = int_score + 20;
            int_stage = int_stage + 1;

        }
        else{
            methods.toast(R.drawable.ic_icons8_sad,getanswer, Gravity.CENTER_VERTICAL,0 ,0);
            methods.wrong();
            life = life - 1;
            int_stage = int_stage + 1;
        }
        mylife();
        updateScore(int_score);
        updatequestion();
    }




    protected void playsound(){
        player = MediaPlayer.create(this, R.raw.quiz);
        player.setLooping(true); // Set looping
        player.setVolume(50,50);
        player.start();
    }
    protected void stop(){
        player.stop();
    }


    public void option(){
        AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        View vs = LayoutInflater.from(this).inflate(R.layout.pause_modal, null);

        MaterialButton restart = vs.findViewById(R.id.restart);
        MaterialButton resume = vs.findViewById(R.id.resume);
        MaterialButton quit = vs.findViewById(R.id.quit);

        BounceView.addAnimTo(restart);
        BounceView.addAnimTo(resume);
        BounceView.addAnimTo(quit);



        dialog.setView(vs);
        AlertDialog alert = dialog.create();

        restart.setOnClickListener(v -> {
            methods.btnclickEffect();
            finish();
            startActivity(getIntent());
        });

        resume.setOnClickListener(v -> {
            methods.btnclickEffect();
            alert.dismiss();
            ifpause = true;
            pause.setImageResource(R.drawable.ic_pause);

        });

        quit.setOnClickListener(v -> {
            methods.btnclickEffect();
            methods.intent(HomePage.class,v.getContext());
            finish();
        });
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.setCanceledOnTouchOutside(false);
        alert.setCancelable(false);
        alert.show();
        BounceView.addAnimTo(alert);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }


}