package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Дмитрий on 18.11.2017.
 */
@IntDef({})
@Retention(RetentionPolicy.SOURCE)
public @interface StoryItemType {
    int CHAPTER = 1;
    int ACTION = 2;
    int IMAGE = 3;
}
