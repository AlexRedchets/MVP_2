package com.example.azvk.mvp_2.dependency_injection;

import com.example.azvk.mvp_2.service.PlayerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @CustomScope
    PlayerService providePlayerService(Retrofit retrofit){
        return retrofit.create(PlayerService.class);
    }
}
