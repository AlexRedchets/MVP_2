package com.example.azvk.mvp_2.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.azvk.mvp_2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<Player> playersList;

    public PlayerAdapter (LayoutInflater inflater){
        this.inflater = inflater;
        playersList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.custom_row, parent ,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Player currentPlayerData = playersList.get(position);

        holder.playerName.setText(currentPlayerData.getName());
        Picasso.with(inflater.getContext()).load(currentPlayerData.getImageUrl()).into(holder.playerImage);
    }

    @Override
    public int getItemCount() {
        return playersList.size();
    }

    public void addPlayers(List<Player> players) {
        playersList.addAll(players);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView playerName;
        ImageView playerImage;

        private ViewHolder(View itemView) {
            super(itemView);

            playerImage = (ImageView)itemView.findViewById(R.id.playerImage);
            playerName = (TextView)itemView.findViewById(R.id.playerName);
        }
    }
}
