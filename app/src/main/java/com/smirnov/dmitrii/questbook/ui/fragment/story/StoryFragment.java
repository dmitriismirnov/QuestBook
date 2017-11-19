package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.fragment.BaseFragmentView;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.StoryAdapter;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;

import butterknife.BindView;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryFragment extends BaseFragmentView<StoryView, StoryPresenter> implements StoryView {

    private static final String TAG = StoryFragment.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView mStoryList;

    private StoryAdapter mAdapter;

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
    public void resetStory() {
        mAdapter.removeAllItems();
    }

    @Override
    public void addStoryItem(@NonNull StoryItem storyItem) {
        mAdapter.addItem(storyItem);
    }
}
