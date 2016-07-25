package com.example.azvk.mvp_2.base;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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

    protected void unSubscribeAll(){
        if (compositeSubscription != null){
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }

    protected <P> void subscribe(Observable<P> observable, Observer<P> observer){
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscribtion().add(subscription);
    }


}
