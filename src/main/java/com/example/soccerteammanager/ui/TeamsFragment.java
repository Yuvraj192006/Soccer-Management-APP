package com.example.soccerteammanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.data.DataProvider;
import com.example.soccerteammanager.model.Team;
import com.example.soccerteammanager.repository.Repository;

import java.util.List;

public class TeamsFragment extends Fragment {

    private Repository<Team> repository;
    private TeamAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        SearchView searchView = view.findViewById(R.id.searchView);
        Button sortButton = view.findViewById(R.id.sortButton);

        repository = new Repository<>();

        DataProvider dataProvider = new DataProvider();
        for (Team team : dataProvider.getTeams()) {
            repository.add(team);
        }

        adapter = new TeamAdapter(repository.getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // 🔍 FILTER (lambda)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                List<Team> filtered = repository.filter(team ->
                        team.getName().toLowerCase().contains(query.toLowerCase()));

                adapter.updateList(filtered);
                return true;
            }
        });

        // 🔽 SORT (lambda)
        sortButton.setOnClickListener(v -> {
            List<Team> teams = repository.getAll();

            teams.sort((a, b) -> a.getName().compareTo(b.getName()));

            adapter.updateList(teams);
        });

        return view;
    }
}
