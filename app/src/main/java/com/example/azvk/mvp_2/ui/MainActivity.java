package com.example.azvk.mvp_2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.azvk.mvp_2.R;
import com.example.azvk.mvp_2.application.PlayerApplication;
import com.example.azvk.mvp_2.service.PlayerService;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    PlayerService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((PlayerApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }
}
