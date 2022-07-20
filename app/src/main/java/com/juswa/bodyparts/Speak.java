package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.button.MaterialButton;
import com.juswa.bodyparts.Adapter.Adapter_speak;
import com.juswa.bodyparts.GetterSetter.speech_model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Speak extends AppCompatActivity {


    Methods methods;
    @BindView(R.id.back)
    MaterialButton back;

    private List<speech_model> list = new ArrayList<>();
    @BindView(R.id.data)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_speak);
        ButterKnife.bind(this);
        methods = new Methods(this);
        back.setOnClickListener(v -> {
            methods.btnclickEffect();
            methods.intent(HomePage.class,this);
        });

        resources();

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(999999999);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new Adapter_speak(list,getApplicationContext(),methods);
        recyclerView.setAdapter(adapter);

    }

    protected void resources(){
        list.add(new speech_model("Tongue"));
        list.add(new speech_model("Nose"));
        list.add(new speech_model("Eyes"));
        list.add(new speech_model("Ears"));
        list.add(new speech_model("Liver"));
        list.add(new speech_model("Intestines"));
        list.add(new speech_model("Kidney"));
        list.add(new speech_model("Heart"));
        list.add(new speech_model("Lungs"));
        list.add(new speech_model("Legs"));
        list.add(new speech_model("Brain"));
        list.add(new speech_model("Alveoli"));
        list.add(new speech_model("face"));
        list.add(new speech_model("scalp"));
        list.add(new speech_model("forehead"));
        list.add(new speech_model("neck"));
        list.add(new speech_model("eyelid"));
        list.add(new speech_model("eyelash"));
        list.add(new speech_model("ear"));
        list.add(new speech_model("Jaw"));
        list.add(new speech_model("teeth"));
        list.add(new speech_model("arm"));
        list.add(new speech_model("upper arm"));
        list.add(new speech_model("shoulder"));
        list.add(new speech_model("elbow"));
        list.add(new speech_model("wrist"));
        list.add(new speech_model("knuckle"));
        list.add(new speech_model("palm"));
        list.add(new speech_model("finger"));
        list.add(new speech_model("thumb"));
        list.add(new speech_model("shin"));
        list.add(new speech_model("ankle"));
        list.add(new speech_model("foot"));
        list.add(new speech_model("toe"));
        list.add(new speech_model("heel"));
        list.add(new speech_model("chest"));
        list.add(new speech_model("torso"));
        list.add(new speech_model("hips"));



    }


}