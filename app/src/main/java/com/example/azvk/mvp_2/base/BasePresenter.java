package com.example.azvk.mvp_2.base;

import rx.subscriptions.CompositeSubscription;

public abstract class BasePresenter implements Presenter {

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        configureSubscribtion();
    }

    private CompositeSubscription configureSubscribtion(){
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed()){
            compositeSubscription = new CompositeSubscription();
        }
        return compositeSubscription;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    private void unSubscribeAll(){
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }
}
