package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.github.hariprasanths.bounceview.BounceView;
import com.juswa.bodyparts.Adapter.Adapter_menu;
import com.juswa.bodyparts.GetterSetter.menu_model;
import com.juswa.bodyparts.shared.SharedPref;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class HomePage extends AppCompatActivity {


    private Methods methods;
    private SharedPref sharedPref;
    private List<menu_model> list = new ArrayList<>();

    @BindViews({R.id.bgsound,R.id.info})
    ImageView[] options;
    @BindView(R.id.menu)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onDestroy();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        methods.playMusic();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        methods.muteMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        methods.muteMusic();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        methods = new Methods(this);
        sharedPref = new SharedPref(this);


        resources();


        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(999999999);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new Adapter_menu(list,getApplicationContext());
        recyclerView.setAdapter(adapter);


        BounceView.addAnimTo(options[0]);
        BounceView.addAnimTo(options[1]);
        //music
        options[0].setOnClickListener(v -> {
            if(methods.soundOn){
                methods.soundOn = false;
                methods.muteMusic();
                options[0].setImageResource(R.drawable.ic_no_sound);

            }
            else{
                methods.soundOn = true;
                methods.playMusic();
                options[0].setImageResource(R.drawable.ic_sound);


            }

        });
        //info
        options[1].setOnClickListener(v -> {
            
        });
    }


    protected void resources(){
        list.add(new menu_model("BODY PARTS",R.drawable.body,1));
        list.add(new menu_model("QUIZ",R.drawable.quiz,2));
        list.add(new menu_model("IDENTIFY",R.drawable.ic_science,3));
        list.add(new menu_model("TAP THE ANSWER",R.drawable.ic_choose,4));
        list.add(new menu_model("SPEAK UP",R.drawable.speak,5));

    }
}