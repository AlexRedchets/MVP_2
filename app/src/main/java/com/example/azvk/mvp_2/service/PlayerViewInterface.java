package com.example.azvk.mvp_2.service;

import com.example.azvk.mvp_2.model.Player;

import java.util.List;

import rx.Observable;

public interface PlayerViewInterface {

    void onCompleted();

    void onError(String message);

    void onPlayers(List<Player> players);

    Observable<List<Player>> getPlayers();
}
