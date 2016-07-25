package com.example.azvk.mvp_2.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azvk.mvp_2.R;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.Holder> {

    private final LayoutInflater inflater;
    private List<Player> playersList;

    public PlayerAdapter (LayoutInflater inflater){
        this.inflater = inflater;
        playersList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.custom_row, parent ,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

    public void addPlayers(List<Player> players) {
        playersList.addAll(players);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }
    }

}
