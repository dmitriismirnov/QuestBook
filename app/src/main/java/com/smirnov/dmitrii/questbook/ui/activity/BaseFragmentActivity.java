package com.smirnov.dmitrii.questbook.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.smirnov.dmitrii.questbook.R;

import butterknife.ButterKnife;

import static ru.utils.view.Views.findFragmentByTag;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {

    private static final String BUNDLE_CURRENT_FRAGMENT_TAG = "current_fragment_tag";

    protected String mCurrentFragmentTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            restoreFromSavedState(savedInstanceState);
        }

        if (getCurrentFragment() == null) {
            replaceFragment(getReplacingFragment());
        }
    }

    protected void restoreFromSavedState(@NonNull Bundle savedState) {
        mCurrentFragmentTag = savedState.getString(BUNDLE_CURRENT_FRAGMENT_TAG);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId_ = item.getItemId();
        if (itemId_ == android.R.id.home) {
            return onClickHome();
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onClickHome() {
        Fragment fragment = getCurrentFragment();
        boolean result = false;
        if (fragment instanceof BaseFragmentActivity.FragmentHomePressed) {
            result = ((BaseFragmentActivity.FragmentHomePressed) fragment).onHomePressed();
        }

        if (!result) {
            result = this.onHomePressed();
        }
        return result;
    }

    public boolean onHomePressed() {
        return false;
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getCurrentFragment();
        boolean result = false;
        if (fragment instanceof BaseFragmentActivity.FragmentBackPressed) {
            result = ((BaseFragmentActivity.FragmentBackPressed) fragment).onBackPressed();
        }

        if (!result) {
            super.onBackPressed();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_CURRENT_FRAGMENT_TAG, mCurrentFragmentTag);
    }

    @Nullable
    protected Fragment getCurrentFragment() {
        if (mCurrentFragmentTag == null) {
            return null;
        }
        return findFragmentByTag(getSupportFragmentManager(), mCurrentFragmentTag);
    }

    protected void replaceFragment(@Nullable Fragment f) {
        if (f == null) {
            return;
        }

        String tag = f.getClass().getSimpleName();

        FragmentManager fm = getSupportFragmentManager();
        if (findFragmentByTag(fm, tag) == null) {
            mCurrentFragmentTag = tag;
            fm.beginTransaction()
                    .replace(R.id.container, f, tag)
                    .commit();
        }
    }

    @Nullable
    protected abstract Fragment getReplacingFragment();

    public interface FragmentBackPressed {
        boolean onBackPressed();
    }

    public interface FragmentHomePressed {
        boolean onHomePressed();
    }
}
