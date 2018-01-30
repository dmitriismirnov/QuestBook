package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.R;

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
        return mChapterText;
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
