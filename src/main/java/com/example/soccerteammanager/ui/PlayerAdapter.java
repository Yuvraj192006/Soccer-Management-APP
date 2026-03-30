package com.example.soccerteammanager.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private List<Player> players;

    public PlayerAdapter(List<Player> players) {
        this.players = players;
    }

    public void updateList(List<Player> newList) {
        players = newList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, position, team;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.playerName);
            position = view.findViewById(R.id.playerPosition);
            team = view.findViewById(R.id.playerTeam);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Player player = players.get(position);

        holder.name.setText(player.getName());
        holder.position.setText(player.getPosition());
        holder.team.setText(player.getTeam());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
