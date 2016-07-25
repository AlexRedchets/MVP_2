package com.example.azvk.mvp_2.base;

import com.example.azvk.mvp_2.model.Player;
import com.example.azvk.mvp_2.service.PlayerViewInterface;

import java.util.List;

import rx.Observer;

public class PlayerPresenter extends BasePresenter implements Observer<List<Player>> {

    private PlayerViewInterface playerViewInterface;

    public PlayerPresenter(PlayerViewInterface playerViewInterface) {
        this.playerViewInterface = playerViewInterface;
    }

    @Override
    public void onCompleted() {
        playerViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        playerViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<Player> players) {
        playerViewInterface.onPlayers(players);
    }

    public void fetchPlayers() {
        unSubscribeAll();
        subscribe(playerViewInterface.getPlayers(), PlayerPresenter.this);
    }
}
