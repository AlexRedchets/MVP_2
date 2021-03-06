package com.example.azvk.mvp_2.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.azvk.mvp_2.R;
import com.example.azvk.mvp_2.application.PlayerApplication;
import com.example.azvk.mvp_2.base.PlayerPresenter;
import com.example.azvk.mvp_2.model.Player;
import com.example.azvk.mvp_2.model.PlayerAdapter;
import com.example.azvk.mvp_2.service.PlayerService;
import com.example.azvk.mvp_2.service.PlayerViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements PlayerViewInterface{

    @Inject
    PlayerService service;

    private PlayerPresenter playerPresenter;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    private PlayerAdapter adapter;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolveDependency();

        ButterKnife.bind(MainActivity.this);
        configViews();

        playerPresenter = new PlayerPresenter(MainActivity.this);
        playerPresenter.onCreate();
    }

    private void resolveDependency() {
        ((PlayerApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configViews() {
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new PlayerAdapter(getLayoutInflater());
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        playerPresenter.onResume();
        playerPresenter.fetchPlayers();
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setIndeterminate(true);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Downloading List");
        dialog.setMessage("Please wait...");
        dialog.show();
    }

    @Override
    public void onCompleted() {
        dialog.dismiss();
    }

    @Override
    public void onError(String message) {
        dialog.dismiss();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPlayers(List<Player> players) {
        adapter.addPlayers(players);
    }

    @Override
    public Observable<List<Player>> getPlayers() {
        return service.player("Russia");
    }
}
