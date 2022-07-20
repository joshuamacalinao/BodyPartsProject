package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class Identify extends AppCompatActivity {


    Methods methods;
    @BindView(R.id.back)
    MaterialButton back;

    @BindView(R.id.bgsound)
    ImageView sound;
    private boolean soundOn = true;
    MediaPlayer player;
    @BindView(R.id.setting)
    ImageView pause;
    private  boolean ifpause = true;
    private int score = 0;
    @BindView(R.id.score)
    TextView myscore;

    @BindViews({R.id.id1, R.id.id2, R.id.id3, R.id.id4, R.id.id5,R.id.id6, R.id.id7, R.id.id8, R.id.id9, R.id.id10}) EditText[] answers;
    private String subanswer[]= {
        "HEAD","EYE","NOSE","MOUTH","HAND","EAR","HAIR","NECK","LEG","FOOT"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_identify);
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
        answers[0].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[1].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[2].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[3].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[4].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[5].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[6].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[7].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[8].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        answers[9].setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);

    }


    public void submit(View view) {
        String get1 = answers[0].getText().toString();
        String get2 = answers[1].getText().toString();
        String get3 = answers[2].getText().toString();
        String get4 = answers[3].getText().toString();
        String get5 = answers[4].getText().toString();
        String get6 = answers[5].getText().toString();
        String get7 = answers[6].getText().toString();
        String get8 = answers[7].getText().toString();
        String get9 = answers[8].getText().toString();
        String get10 = answers[9].getText().toString();

        methods.btnclickEffect();
        if( !get1.isEmpty() && !get2.isEmpty() && !get3.isEmpty() && !get4.isEmpty() && !get5.isEmpty() && !get6.isEmpty() && !get7.isEmpty() && !get8.isEmpty() && !get9.isEmpty() && !get10.isEmpty() ){

            if(get1.equals(subanswer[0].toLowerCase())){
                validator(answers[0],subanswer[0]);
            }
            else if(get2.equals(subanswer[1].toLowerCase())){
                validator(answers[1],subanswer[1]);
            }
            else if(get3.equals(subanswer[2].toLowerCase())){
                validator(answers[2],subanswer[2]);
            }
            else if(get4.equals(subanswer[3].toLowerCase())){
                validator(answers[3],subanswer[3]);
            }
            else if(get5.equals(subanswer[4].toLowerCase())){
                validator(answers[4],subanswer[4]);
            }
            else if(get6.equals(subanswer[5].toLowerCase())){
                validator(answers[5],subanswer[5]);
            }
            else if(get7.equals(subanswer[6].toLowerCase())){
                validator(answers[6],subanswer[6]);
            }
            else if(get8.equals(subanswer[7].toLowerCase())){
                validator(answers[7],subanswer[7]);
            }
            else if(get9.equals(subanswer[8].toLowerCase())){
                validator(answers[8],subanswer[8]);
            }
            else if(get10.equals(subanswer[9].toLowerCase())){
                validator(answers[9],subanswer[9]);
            }
            else{
                new Handler().postDelayed(() -> {
                    int newScore = score+10;
                    methods.GameOver("Score : "+newScore);
                    methods.Modaldone.setOnClickListener(v -> {
                        methods.alert.dismiss();
                        methods.intent(HomePage.class,v.getContext());
                        finish();
                    });
                }, 3000);
            }



        }
        else if(get1.isEmpty() && get2.isEmpty() && get3.isEmpty() && get4.isEmpty() && get5.isEmpty() && get6.isEmpty() && get7.isEmpty() && get8.isEmpty() && get9.isEmpty() && get10.isEmpty() ){

            methods.toast(R.drawable.ic_icons8_sad,"Please Answer me", Gravity.CENTER_VERTICAL,0 ,0);

        }
        else{
            validator(answers[0],subanswer[0]);
            validator(answers[1],subanswer[1]);
            validator(answers[2],subanswer[2]);
            validator(answers[3],subanswer[3]);
            validator(answers[4],subanswer[4]);
            validator(answers[5],subanswer[5]);
            validator(answers[6],subanswer[6]);
            validator(answers[7],subanswer[7]);
            validator(answers[8],subanswer[8]);
            validator(answers[9],subanswer[9]);
        }





    }





    protected void validator(EditText editText,String answ){
            String editTextAns = editText.getText().toString().toLowerCase();
        if (editTextAns.equals(answ.toLowerCase())) {
            editText.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55efc4")));
//            methods.toast(R.drawable.ic_icons8_happy,"Correct!", Gravity.CENTER_VERTICAL,0 ,0);
//            methods.correct();
            score = score + 10;
            myscore.setText("Score: "+ score);


        } else {
//            methods.toast(R.drawable.ic_icons8_sad,"Wrong!", Gravity.CENTER_VERTICAL,0 ,0);
//            methods.wrong();
            editText.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#fab1a0")));
        }

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