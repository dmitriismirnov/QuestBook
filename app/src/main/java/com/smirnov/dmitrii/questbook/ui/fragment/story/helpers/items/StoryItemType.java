package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItemType.ACTION;
import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItemType.CHAPTER;
import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItemType.IMAGE;

/**
 * Created by Дмитрий on 18.11.2017.
 */
@IntDef({CHAPTER, ACTION, IMAGE})
@Retention(RetentionPolicy.SOURCE)
public @interface StoryItemType {
    int CHAPTER = 1;
    int ACTION = 2;
    int IMAGE = 3;
}
