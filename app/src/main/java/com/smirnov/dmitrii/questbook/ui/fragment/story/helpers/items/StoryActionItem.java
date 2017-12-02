package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryActionItem extends StoryItem {

    private List<ActionModel> mActionList;

    public StoryActionItem(@NonNull List<ActionModel> actions) {
        super(StoryItemType.ACTION);
        this.mActionList = actions;
    }

    public List<ActionModel> getActionList() {
        return mActionList;
    }

    @LayoutRes
    @Override
    int getLayoutId() {
        return R.layout.item_story_action;
    }
}
