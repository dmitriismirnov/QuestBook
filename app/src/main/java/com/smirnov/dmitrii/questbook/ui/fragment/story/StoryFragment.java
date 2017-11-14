package com.smirnov.dmitrii.questbook.ui.fragment.story;

import com.smirnov.dmitrii.questbook.ui.fragment.BaseFragmentView;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryFragment extends BaseFragmentView<StoryView, StoryPresenter> implements StoryView {

    @Override
    public StoryPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
