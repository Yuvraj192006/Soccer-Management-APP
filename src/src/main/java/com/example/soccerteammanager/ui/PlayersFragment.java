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
import com.example.soccerteammanager.model.Player;
import com.example.soccerteammanager.repository.Repository;

import java.util.List;

public class PlayersFragment extends Fragment {

    private Repository<Player> repository;
    private PlayerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_players, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        SearchView searchView = view.findViewById(R.id.searchView);

        repository = new Repository<>();
        DataProvider dataProvider = new DataProvider();

        for (Player p : dataProvider.getPlayers()) {
            repository.add(p);
        }

        adapter = new PlayerAdapter(repository.getAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                List<Player> filtered = repository.filter(player ->
                        player.getName().toLowerCase().contains(query.toLowerCase()) ||
                                player.getPosition().toLowerCase().contains(query.toLowerCase()));
                adapter.updateList(filtered);
                return true;
            }
        });

        return view;
    }
}
