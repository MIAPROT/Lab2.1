package com.example.lab21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private List<State> states;

    @NonNull
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View employeeView = inflater.inflate(R.layout.list_item, parent, false);
        return new StateAdapter.ViewHolder(employeeView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView capitalView;
        public TextView nameView;
        public ImageView flagView;

        public ViewHolder(View itemView) {
            super(itemView);
            flagView = (ImageView) itemView.findViewById(R.id.imageView_flag);
            nameView = (TextView) itemView.findViewById(R.id.textView_countryName);
            capitalView = (TextView) itemView.findViewById(R.id.textView_capital);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        State state = states.get(position);
        TextView textView = holder.nameView;
        textView.setText(state.getName());
        textView = holder.capitalView;
        textView.setText(state.getCapital());
        ImageView imageView = holder.flagView;
        imageView.setImageResource(state.getFlagResource());

    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public StateAdapter(List<State> mstates) {
        states = mstates;
    }



}
