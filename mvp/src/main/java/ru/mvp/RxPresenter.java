package ru.pochtabank.mvp;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;

/**
 * RxPresenter
 * Created by deler on 03.03.17.
 */

public abstract class RxPresenter<V extends IView> implements IPresenter<V> {

    private V mView;

    private CompositeDisposable mSubscriptions = new CompositeDisposable();
    private CompositeDisposable mViewSubscriptions;
    private BehaviorSubject<Boolean> mViewDetachSubject = BehaviorSubject.createDefault(true);

    @Override
    public void onAttachView(@NonNull V view) {
        mView = view;
        mViewSubscriptions = new CompositeDisposable();
        mViewDetachSubject.onNext(false);
    }

    @Override
    public void onDetachView() {
        mViewDetachSubject.onNext(true);
        mViewSubscriptions.clear();
        mView = null;
    }

    @Override
    public void onDestroy() {
        mViewDetachSubject.onComplete();
        mSubscriptions.clear();
    }

    public V getView() {
        return mView;
    }

    protected void addSubscription(Disposable s) {
        mSubscriptions.add(s);
    }

    protected <T> Disposable viewSubscribe(final Observable<T> observable, final DisposableObserver<T> subscriber) {
        Disposable subscription = observable.subscribeWith(subscriber);
        mViewSubscriptions.add(subscription);
        return subscription;
    }

    protected <T> Disposable viewSubscribe(final Observable<T> observable, final Action action) {
        Disposable subscription = observable.subscribe(t -> {}, throwable -> {}, action);
        mViewSubscriptions.add(subscription);
        return subscription;
    }

    protected <T> Disposable subscribe(final Observable<T> observable, final DisposableObserver<T> subscriber) {
        Disposable subscription = observable.subscribeWith(subscriber);
        mSubscriptions.add(subscription);
        return subscription;
    }

    protected <T> Disposable subscribe(final Observable<T> observable, final Action action) {
        Disposable subscription = observable.subscribe(t -> {}, throwable -> {}, action);
        mSubscriptions.add(subscription);
        return subscription;
    }

    protected <T> Disposable freezableSubscribe(final Observable<T> observable, final DisposableObserver<T> subscriber) {
        Disposable disposable = observable
                .lift(this.createOperatorFreeze())
                .subscribeWith(subscriber);
        mSubscriptions.add(disposable);
        return disposable;
    }

    protected <T> Disposable freezableSubscribe(final Observable<T> observable, final Action action) {
        Disposable disposable = observable
                .lift(this.createOperatorFreeze())
                .subscribe(t -> {}, throwable -> {}, action);
        mSubscriptions.add(disposable);
        return disposable;
    }

    protected <T> OperatorFreeze<T> createOperatorFreeze() {
        return new OperatorFreeze<>(mViewDetachSubject);
    }


}
