package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.NonNull;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryChaperItem extends StoryItem {

    private String mChapterText;

    public StoryChaperItem(@NonNull String chapterText) {
        super(StoryItemType.CHAPTER);
        this.mChapterText = chapterText;
    }

    public String getChapterText(){
        return mChapterText;
    }
}
