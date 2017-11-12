package ru.pochtabank.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * FragmentView
 *
 * Created by deler on 21.02.17.
 */

public abstract class FragmentView<V extends IView, Presenter extends IPresenter<V>> extends Fragment implements
        IView,
        IMvpDelegate.Callback<V,Presenter> {

    private IMvpDelegate<V, Presenter> mDelegate;

    public IMvpDelegate<V, Presenter> getDelegate() {
        return mDelegate;
    }

    public boolean isCustomViewCreateEvent(){
        return false;
    }

    @Override
    public boolean isNeedDestroyRetainedPresenter(){
        return getActivity().isFinishing() || isRemoving();
    }

    @Override
    public boolean isNeedRetainPresenter() {
        return true;
    }

    @NonNull
    @Override
    public String getRetainPresenterTag() {
        return "Presenter_"+this.getClass().getSimpleName();
    }

    @NonNull
    public Presenter getPresenter(){
        return mDelegate.getPresenter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDelegate = new MvpDelegate<>(getActivity(), this);
        getDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isCustomViewCreateEvent()) {
            getDelegate().onViewCreated();
        }
    }

    @Override
    public void onResume() {
        getDelegate().onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        getDelegate().onPause();
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getDelegate().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        getDelegate().onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        getDelegate().onDestroy();
        mDelegate = null;
        super.onDestroy();
    }

    @Override
    public V view() {
        //noinspection unchecked
        return (V) this;
    }
}
