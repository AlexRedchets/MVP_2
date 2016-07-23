package com.example.azvk.mvp_2.dependency_injection;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
