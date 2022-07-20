package com.juswa.bodyparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.juswa.bodyparts.Adapter.SplashScreenPagerAdapter;
import com.juswa.bodyparts.GetterSetter.splash_screen_model;
import com.juswa.bodyparts.shared.SharedPref;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    Methods methods;
    SharedPref sharedPref;
    private int position = 0;
    private SplashScreenPagerAdapter splashScreenPagerAdapter;
    @BindViews({R.id.next,R.id.skip,R.id.getStarted})
    MaterialButton[] btn;

    @BindView(R.id.tab_indicator)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager pager;
    final List<splash_screen_model> list = new ArrayList<>();
    private ValueAnimator valueAnimator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        methods = new Methods(this);
        sharedPref  = new SharedPref(this);

        if(sharedPref.finishSplash()){
            Log.d("Bodyparts","started");
            methods.intent(HomePage.class,this);
        }
        else{
            Log.d("Bodyparts","not yet started");
            Items_tabsSetup();
        }
    }


    protected void Items_tabsSetup(){

        list.add(new splash_screen_model("Body Parts","The human body is a single structure but it is made up of billions " +
                "of smaller structures of four major kinds: cells, tissues, organs, " +
                "and systems. An organ is an organization of several different kinds of" +
                " tissues so arranged that together they can perform a special function.",R.drawable.body,"#f1f2f6"));
        list.add(new splash_screen_model("Quiz","Test your knowledge of the human body with this fun quiz. Make no bones about it, this quiz will test your brain power!",R.drawable.quiz,"#6a89cc"));
        list.add(new splash_screen_model("Pronunciation","the way in which a word is pronounced.",R.drawable.speak,"#82ccdd"));

        splashScreenPagerAdapter = new SplashScreenPagerAdapter(this,list);
        valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), Color.MAGENTA,Color.YELLOW,Color.BLUE);
        pager.setAdapter(splashScreenPagerAdapter);

        valueAnimator.setDuration((3 - 1) * 10000000000l);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                valueAnimator.setCurrentPlayTime((long) ((positionOffset + position) * 1000000000));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                pager.setBackgroundColor((Integer)animation.getAnimatedValue());
            }
        });
        tabLayout.setupWithViewPager(pager);

        btn[0].setOnClickListener(v -> {
            position = pager.getCurrentItem();
            if(position < list.size()){
                position++;
                pager.setCurrentItem(position);
            }
            if (position == list.size()-1) {
                BtnFunction();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == list.size() -1){
                    BtnFunction();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn[1].setOnClickListener(v -> {
            pager.setCurrentItem(list.size());
        });

        methods.pulse_btn(btn[0]);

    }


    protected void BtnFunction(){
        btn[0].setVisibility(View.GONE);
        btn[1].setVisibility(View.GONE);
        tabLayout.setVisibility(View.GONE);
        btn[2].setVisibility(View.VISIBLE);
        BounceView.addAnimTo(btn[2]);

       methods.pulse_btn(btn[2]);


        btn[2].setOnClickListener(v -> {
            sharedPref.setFinishSplash(true);
            methods.intent(HomePage.class,v.getContext());
            finish();
        });


    }
}