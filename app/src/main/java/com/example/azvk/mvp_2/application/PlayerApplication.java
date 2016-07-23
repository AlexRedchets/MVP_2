package com.example.azvk.mvp_2.application;

import android.app.Application;

import com.example.azvk.mvp_2.dependencies.ApiComponent;
import com.example.azvk.mvp_2.dependencies.DaggerApiComponent;
import com.example.azvk.mvp_2.dependencies.DaggerNetworkComponent;
import com.example.azvk.mvp_2.dependencies.NetworkComponent;
import com.example.azvk.mvp_2.dependencies.NetworkModule;
import com.example.azvk.mvp_2.model.Constatnt;

public class PlayerApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        apiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constatnt.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
