package com.smirnov.dmitrii.questbook.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smirnov.dmitrii.questbook.app.DialogFragmentManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import ru.mvp.FragmentView;
import ru.mvp.IPresenter;
import ru.mvp.IView;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public abstract class BaseFragmentView<V extends IView, Presenter extends IPresenter<V>> extends FragmentView<V, Presenter> {
    protected CompositeDisposable mSubscriptions = new CompositeDisposable();
    protected Unbinder mUnbinder;

    private DialogFragmentManager mDialogManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialogManager = DialogFragmentManager.build(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected boolean isNeedToolbarInset() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mDialogManager != null) {
            mDialogManager.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        unsubscribeAllSubscriptions();
        super.onDestroyView();
        mUnbinder.unbind();
    }

    protected void unsubscribeAllSubscriptions() {
        if (mSubscriptions != null && !mSubscriptions.isDisposed()) {
            mSubscriptions.clear();
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (mDialogManager != null) {
                mDialogManager.onViewStateRestored(savedInstanceState);
            }
        }
        super.onViewStateRestored(savedInstanceState);
    }

    public DialogFragmentManager getDialogManager() {
        return mDialogManager;
    }
}
