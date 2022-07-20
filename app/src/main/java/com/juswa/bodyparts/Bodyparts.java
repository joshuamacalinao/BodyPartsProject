package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.button.MaterialButton;
import com.juswa.bodyparts.shared.SharedPref;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class Bodyparts extends AppCompatActivity {

    private Methods methods;
    private SharedPref sharedPref;
    @BindView(R.id.bgsound)
    ImageView music;
    @BindView(R.id.back)
    MaterialButton back;
    @BindView(R.id.title)
    TextView title;
    public static String str_title;

    @BindViews({R.id.id1, R.id.id2, R.id.id3, R.id.id4, R.id.id5,R.id.id6, R.id.id7, R.id.id8, R.id.id9, R.id.id10}) MaterialButton[] btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bodyparts);
        ButterKnife.bind(this);
        methods = new Methods(this);
        sharedPref = new SharedPref(this);

        title.setText(str_title);

        BounceView.addAnimTo(music);
        BounceView.addAnimTo(back);
        bodyFunction();

    }

    public void back(View view) {
        MediaPlayer player = MediaPlayer.create(view.getContext(), R.raw.click);
        player.setVolume(100,100);
        player.start();
        methods.intent(HomePage.class,view.getContext());
        finish();
    }

    protected  void bodyFunction(){
        btn[0].setOnClickListener(v -> {
            modal("Head"," It is an external body part consisting of hair, forehead, eyes, ears, nose and mouth. ",R.drawable.head);
        });

        btn[1].setOnClickListener(v -> {
            modal("Eye","1. below the forehead, above the nose \n 2. sense of sight \n 3. Eyes are used to see things around us. ",R.drawable.ic_eye);
        });
        btn[2].setOnClickListener(v -> {
            modal("Nose","middle of the face, breathing; sense of smell; keeping out foreign particles (with nose hairs)",R.drawable.ic_nose);
        });
        btn[3].setOnClickListener(v -> {
            modal("mouth","below the nose, eating; talking; breathing; sense of taste",R.drawable.mouth);
        });
        btn[4].setOnClickListener(v -> {
            modal("Hand","end of the arm, connected to the wrist, fine motor skills (writing, pinching, gripping) ",R.drawable.ic_hand);
        });
        btn[5].setOnClickListener(v -> {
            modal("Ear","on either side of the head, ense of hearing; maintaining balance",R.drawable.ic_ear);
        });
        btn[6].setOnClickListener(v -> {
            modal("Hair","on top of the scalp, regulating body temperature; protecting the scalp",R.drawable.ic_man_hair);
        });
        btn[7].setOnClickListener(v -> {
            modal("Neck","below the head, above the shoulders, supporting the head’s weight; allowing the head to turn; sending messages from the brain to the rest of the body",R.drawable.ic_neck);
        });

        btn[8].setOnClickListener(v -> {
            modal("Leg","below torso, above foot, keeping the body stable; walking; running; bending the body",R.drawable.ic_legs);
        });
        btn[9].setOnClickListener(v -> {
            modal("Foot","bottom of the leg, walking; supporting body weight; propelling the body forward",R.drawable.ic_foot);
        });

    }

    protected void modal(String _title,String _detials,int _img){
        MediaPlayer player = MediaPlayer.create(this, R.raw.click);
        player.setVolume(100,100);
        player.start();
        AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
        View vs = LayoutInflater.from(this).inflate(R.layout.body_modal, null);

        ImageView close = vs.findViewById(R.id.close);
        BounceView.addAnimTo(close);


        ImageView img = vs.findViewById(R.id.img);
        TextView title = vs.findViewById(R.id.title);
        TextView details = vs.findViewById(R.id.details);

        title.setText(_title);
        details.setText(_detials);
        img.setImageResource(_img);

        dialog.setView(vs);
        AlertDialog alert = dialog.create();
        close.setOnClickListener(v -> {
            alert.dismiss();
        });
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.setCanceledOnTouchOutside(false);
        alert.setCancelable(true);
        alert.show();
        BounceView.addAnimTo(alert);
    }
}