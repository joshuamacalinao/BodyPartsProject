package com.juswa.bodyparts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.juswa.bodyparts.GetterSetter.splash_screen_model;
import com.juswa.bodyparts.R;

import java.util.List;

public class SplashScreenPagerAdapter extends PagerAdapter {

   Context mContext ;
   List<splash_screen_model> mListScreen;

    public SplashScreenPagerAdapter(Context mContext, List<splash_screen_model> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_splash_screen,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.img);
        TextView title = layoutScreen.findViewById(R.id.title);
        TextView description = layoutScreen.findViewById(R.id.details);
        RelativeLayout bgcolor = layoutScreen.findViewById(R.id.bg);

        title.setText(mListScreen.get(position).getTitle());
        description.setText(mListScreen.get(position).getDesc());
        imgSlide.setImageResource(mListScreen.get(position).getImg());
//        bgcolor.setBackgroundColor(Color.parseColor(mListScreen.get(position).getColor()));

        container.addView(layoutScreen);

        return layoutScreen;





    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }
}
