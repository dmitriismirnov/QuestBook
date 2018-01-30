package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.app.App;
import com.smirnov.dmitrii.questbook.ui.fragment.BaseFragmentView;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.StoryAdapter;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.TextDisplayingListener;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.UserInteractionListener;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.widget.StoryUserActionView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import ru.utils.LogUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryFragment extends BaseFragmentView<StoryView, StoryPresenter>
        implements StoryView,
        TextDisplayingListener,
        UserInteractionListener {

    @SuppressWarnings("unused")
    private static final String TAG = StoryFragment.class.getSimpleName();

    private static final String PATH_TESTBOOK = "books/testbook/exsample.json";

    @BindView(R.id.recycler_view)
    RecyclerView mStoryList;
    @BindView(R.id.user_action_view)
    StoryUserActionView mActionView;

    private StoryAdapter mAdapter;

    @SuppressWarnings("SameParameterValue")
    @NonNull
    public static Fragment newInstance(@Nullable Bundle extras) {
        Fragment fragment = new StoryFragment();
        fragment.setArguments(extras == null ? new Bundle() : extras);
        return fragment;
    }

    @Override
    public StoryPresenter createPresenter() {
        return new StoryPresenter();
    }

    @Override
    @LayoutRes
    protected int getLayoutId() {
        return R.layout.fragment_story;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new StoryAdapter(getContext());
        mStoryList.setAdapter(mAdapter);
        getPresenter().init();
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.setTextDisplayFinishListener(this);
        mActionView.setUserInteractionListener(this);
//        mAdapter.setUserInteractionListener(this);
    }

    @Override
    public void onPause() {
        mAdapter.setTextDisplayFinishListener(null);
        mActionView.setUserInteractionListener(null);
//        mAdapter.setUserInteractionListener(null);
        super.onPause();
    }

    @Override
    public void resetStory() {
        mAdapter.removeAllItems();
    }

    @Override
    public void addStoryItem(@NonNull StoryItem storyItem) {
        mAdapter.addItem(storyItem);
        scrollDownDelayed();
    }

    @Override
    public void setUserAction(@NonNull StoryActionItem actionItem) {
        mActionView.clear();
        mActionView.setUpActionItem(actionItem);
        mActionView.show();

    }

    @Override
    public void showUserAction() {
        mActionView.show();
    }

    @Override
    public void hideUserAction() {
        mActionView.hide();
    }

    @Override
    public void removeLastItem() {
        mAdapter.removeItem(mAdapter.getItemCount() - 1);
    }

    @Override
    public void showToastMessage(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextDisplayingFinished() {
        getPresenter().processTextShown();
        scrollDown();
        scrollDownDelayed();
    }

    @Override
    public void onViewSizeChanged() {
        scrollDown();
    }

    @Override
    public void onChooseAction(@NonNull ActionModel action) {
        getPresenter().processActionChosen(action);
    }

    @Override
    public void scrollDown() {
        mStoryList.smoothScrollToPosition(mAdapter.getItemCount() - 1);
    }
    @Override
    public void scrollDownDelayed() {
        new Handler().postDelayed(() -> mStoryList.smoothScrollBy(0, getTargetScrollPosition(mStoryList)), 300);
    }

    public static int getTargetScrollPosition(@NonNull RecyclerView view) {
        return view.computeVerticalScrollRange() - view.computeVerticalScrollOffset();
    }


    public static String loadAsset(String path) {
        //TODO: move to CommonUtils
        AssetManager manager = App.context().getAssets();
        String content = null;

        try {
            InputStream e = manager.open(path);
            if (e != null) {
                byte[] buffer = new byte[e.available()];
                e.read(buffer);
                e.close();
                content = new String(buffer);
            }
        } catch (IOException var5) {
            LogUtils.w(TAG, var5);
        }

        return content;
    }
}
