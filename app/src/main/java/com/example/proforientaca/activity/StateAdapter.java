package com.example.proforientaca.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proforientaca.R;
import com.example.proforientaca.models.Polytech;

import java.util.List;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Polytech> states;

    public StateAdapter(Context context, List<Polytech> states, OnStateClickListener onClickListener) {
        this.states = states;
        this.onClickListener = onClickListener;
        this.inflater = LayoutInflater.from(context);
    }

    interface OnStateClickListener{
        void onStateClick(Polytech state, int position);
    }

    private final OnStateClickListener onClickListener;

    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_polytech, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        Polytech state = states.get(position);
        holder.flagView.setImageResource(state.getLogo());
        holder.nameView.setText(state.getName());
        holder.locationView.setText(state.getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickListener.onStateClick(state, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, locationView;
        ViewHolder(View view){
            super(view);
            flagView = view.findViewById(R.id.logo);
            nameView = view.findViewById(R.id.name);
            locationView = view.findViewById(R.id.location);
        }
    }
}
