package com.juswa.bodyparts.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.card.MaterialCardView;
import com.juswa.bodyparts.Bodyparts;
import com.juswa.bodyparts.GetterSetter.menu_model;
import com.juswa.bodyparts.Identify;
import com.juswa.bodyparts.Methods;
import com.juswa.bodyparts.Quiz;
import com.juswa.bodyparts.R;
import com.juswa.bodyparts.Speak;
import com.juswa.bodyparts.TapAnswer;

import java.util.List;

public class Adapter_menu extends RecyclerView.Adapter<Adapter_menu.ViewHolder> {
    Context mContext;
    List<menu_model> newsList;
    private List<menu_model> list;




    public Adapter_menu(List<menu_model> list, Context context) {
        super();
        this.newsList = list;
        this.mContext = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final menu_model getData = newsList.get(position);
        BounceView.addAnimTo(holder.cardView);
        holder.title.setText(getData.getTitle());
        holder.img.setImageResource(getData.getImg());
        holder.cardView.setOnClickListener(v -> {
           MediaPlayer player = MediaPlayer.create(v.getContext(), R.raw.click);
            player.setVolume(100,100);
            player.start();

            if(getData.getId() == 1){
                Methods.getInstance(v.getContext()).intent(Bodyparts.class,v.getContext());
                Bodyparts.str_title = getData.getTitle();
            }
            else if(getData.getId() == 2){
                Methods.getInstance(v.getContext()).intent(Quiz.class,v.getContext());
                Bodyparts.str_title = getData.getTitle();
            }
            else if(getData.getId() == 3){
                Methods.getInstance(v.getContext()).intent(Identify.class,v.getContext());
                Bodyparts.str_title = getData.getTitle();
            }
            else if(getData.getId() == 4){
                Methods.getInstance(v.getContext()).intent(TapAnswer.class,v.getContext());
                Bodyparts.str_title = getData.getTitle();
            }
            else if(getData.getId() == 5){
                Methods.getInstance(v.getContext()).intent(Speak.class,v.getContext());
                Bodyparts.str_title = getData.getTitle();
            }
        });


    }


    @Override
    public int getItemCount() {
        return newsList.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public MaterialCardView cardView;
        public ImageView img;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            img = itemView.findViewById(R.id.imgIcon);
            title = itemView.findViewById(R.id.title);


        }
    }
}
