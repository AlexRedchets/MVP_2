package com.example.azvk.mvp_2.service;

import com.example.azvk.mvp_2.model.Player;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface PlayerService {

    @GET("api/player/{team}")
    Observable<List<Player>> player(
            @Path("team") String team
    );
}
