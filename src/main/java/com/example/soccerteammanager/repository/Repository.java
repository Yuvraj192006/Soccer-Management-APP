package com.example.soccerteammanager.repository;

import com.example.soccerteammanager.model.SoccerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends SoccerEntity> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}