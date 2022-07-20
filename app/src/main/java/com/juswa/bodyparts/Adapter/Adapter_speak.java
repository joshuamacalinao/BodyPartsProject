package com.juswa.bodyparts.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.github.hariprasanths.bounceview.BounceView;
import com.google.android.material.card.MaterialCardView;
import com.juswa.bodyparts.GetterSetter.speech_model;
import com.juswa.bodyparts.Methods;
import com.juswa.bodyparts.R;

import java.util.List;

public class Adapter_speak extends RecyclerView.Adapter<Adapter_speak.ViewHolder> {
    Context mContext;
    List<speech_model> newsList;
    Methods methods;




    public Adapter_speak(List<speech_model> list, Context context,Methods methods) {
        super();
        this.newsList = list;
        this.mContext = context;
        this.methods = methods;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.speech_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final speech_model getData = newsList.get(position);
        BounceView.addAnimTo(holder.cardView);
        holder.text.setText(getData.getSpeech());
        holder.cardView.setOnClickListener(v -> {
            methods.Speech(getData.getSpeech());
        });

    }


    @Override
    public int getItemCount() {
        return newsList.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public MaterialCardView cardView;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card);
            text = itemView.findViewById(R.id.text);


        }
    }
}
