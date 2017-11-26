package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.LayoutRes;

/**
 * Created by Дмитрий on 18.11.2017.
 */

public abstract class StoryItem {

    @StoryItemType
    private int mType;

    public StoryItem(@StoryItemType int type) {
        this.mType = type;
    }

    public int getType() {
        return mType;
    }

    @LayoutRes
    abstract int getLayoutId();
}
