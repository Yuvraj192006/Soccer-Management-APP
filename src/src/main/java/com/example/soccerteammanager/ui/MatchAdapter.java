package com.example.soccerteammanager.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.model.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchAdapter(List<Match> matches) {
        this.matches = matches;
    }

    public void updateList(List<Match> newList) {
        matches = newList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teams, score, league, date;

        public ViewHolder(View view) {
            super(view);
            teams = view.findViewById(R.id.matchTeams);
            score = view.findViewById(R.id.matchScore);
            league = view.findViewById(R.id.matchLeague);
            date = view.findViewById(R.id.matchDate);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Match match = matches.get(position);

        holder.teams.setText(match.getName()); // "Home vs Away"
        holder.score.setText(match.getScore());
        holder.league.setText(match.getLeague());
        holder.date.setText(match.getDate());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }
}
