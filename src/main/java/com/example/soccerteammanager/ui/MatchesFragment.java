package com.example.soccerteammanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.data.DataProvider;
import com.example.soccerteammanager.model.Match;
import com.example.soccerteammanager.repository.Repository;

import java.util.List;

public class MatchesFragment extends Fragment {

    private Repository<Match> repository;
    private MatchAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        SearchView searchView = view.findViewById(R.id.searchView);

        repository = new Repository<>();
        DataProvider dataProvider = new DataProvider();

        for (Match m : dataProvider.getMatches()) {
            repository.add(m);
        }

        adapter = new MatchAdapter(repository.getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                List<Match> filtered = repository.filter(match ->
                        match.getName().toLowerCase().contains(query.toLowerCase()) ||
                                match.getLeague().toLowerCase().contains(query.toLowerCase()));
                adapter.updateList(filtered);
                return true;
            }
        });

        return view;
    }
}
