package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.R;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryChapterItem extends StoryItem {

    private String mChapterText;
    private boolean mIsNeedDisplayAnimation = true;

    public StoryChapterItem(@NonNull String chapterText) {
        super(StoryItemType.CHAPTER);
        this.mChapterText = chapterText;
    }

    public String getChapterText() {
        return mChapterText;
    }

    public boolean isNeedDisplayAnimation() {
        return mIsNeedDisplayAnimation;
    }

    public void setTextAnimated() {
        mIsNeedDisplayAnimation = false;
    }

    @LayoutRes
    @Override
    int getLayoutId() {
        return R.layout.item_story_chapter;
    }

    @Override
    public String toString() {
        return "StoryChaperItem{" +
                "ChapterText='" + mChapterText + '\'' +
                '}';
    }
}
