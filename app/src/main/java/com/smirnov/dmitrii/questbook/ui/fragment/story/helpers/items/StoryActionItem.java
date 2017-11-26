package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryActionItem extends StoryItem {

    //TODO made for UI-only purposes, think about FLAGs model, create StoryActionView and refactor StoryActionItem
    private List<String> mActions;

    public StoryActionItem(@NonNull List<String> actions) {
        super(StoryItemType.ACTION);
        mActions = actions;
    }

    public List<String> getActions() {
        return mActions;
    }


    @LayoutRes
    @Override
    int getLayoutId() {
        return R.layout.item_story_action;
    }
}
