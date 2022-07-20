package com.juswa.bodyparts;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class Methods {

    public static final String TAG = "Body";
    private static Methods application;
    private static Context cont;
    public boolean soundOn = true;
    public MaterialButton Modaldone;
    public AlertDialog alert;

    public  TextToSpeech tts;

    public MediaPlayer player;
    public Methods(Context context){
        cont = context;
    }


    public static synchronized Methods getInstance(Context context){
        if(application == null){
            application = new Methods(context);
        }
        return application;
    }


    public void btnclickEffect(){
        MediaPlayer player = MediaPlayer.create(cont, R.raw.click);
        player.setVolume(100,100);
        player.start();
    }

    public void correct(){
        MediaPlayer player = MediaPlayer.create(cont, R.raw.correct);
        player.setVolume(100,100);
        player.start();
    }

    public void wrong(){
        MediaPlayer player = MediaPlayer.create(cont, R.raw.wrong);
        player.setVolume(100,100);
        player.start();
    }

    public void playMusic(){
        player = MediaPlayer.create(cont, R.raw.bgmusic);
        player.setLooping(true); // Set looping
        player.setVolume(50,50);
        player.start();


    }

    public void muteMusic(){
//        player.setVolume(0,0);
        player.stop();
    }


    public void intent(Class<?> activity, Context context){
        Intent i = new Intent(context,activity);
        context.startActivity(i);
    }


    public void pulse_btn(MaterialButton btn){
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                btn,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(310);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();
    }

    public void pulse_img(ImageView btn){
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                btn,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown.setDuration(310);
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown.start();
    }


    public void toast(int raw,String anss,int postion,int x ,int y){
        Toast toast = new Toast(cont);
        View vs = LayoutInflater.from(cont).inflate(R.layout.custom_toast, null);
         ImageView icon = vs.findViewById(R.id.img);
         TextView ans = vs.findViewById(R.id.ans);
         ans.setText(anss);

        icon.setImageResource(raw);
        toast.setGravity(postion, x, y);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(vs);
        toast.show();
    }

    public void GameOver(String score_){
        AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(cont);
        View vs = LayoutInflater.from(cont).inflate(R.layout.game_modal, null);

        Modaldone = vs.findViewById(R.id.taposna);
        TextView score = vs.findViewById(R.id.score);
        score.setText(score_);


        dialog.setView(vs);
        alert = dialog.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.setCanceledOnTouchOutside(false);
        alert.setCancelable(false);
        alert.show();
        BounceView.addAnimTo(alert);
    }


    public void Speech(String s){
        tts = new TextToSpeech(cont, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.US);
                    tts.getDefaultEngine();
                    tts.getDefaultVoice();
                    tts.setPitch(1.1f);
                    tts.setSpeechRate(0.3f);
                    tts.speak(s , TextToSpeech.QUEUE_ADD, null);
                }
                else if(status == TextToSpeech.ERROR){
                    Toast.makeText(cont, "Sorry your device not support text to speech", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
