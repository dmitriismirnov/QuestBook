package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.NonNull;

import ru.utils.LogUtils;

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
        LogUtils.d("getChapterText", mChapterText);
        return mChapterText;
    }
}
