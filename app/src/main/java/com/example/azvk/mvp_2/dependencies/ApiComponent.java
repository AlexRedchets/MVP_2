package com.example.azvk.mvp_2.dependencies;

import com.example.azvk.mvp_2.MainActivity;

import dagger.Component;

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);

}
