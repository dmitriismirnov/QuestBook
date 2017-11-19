package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.ImageType.DEBUG_1;
import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.ImageType.DEBUG_2;
import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.ImageType.DEBUG_3;
import static com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.ImageType.NO_IMAGE;

/**
 * Created by Дмитрий on 19.11.2017.
 */
@IntDef({NO_IMAGE, DEBUG_1, DEBUG_2, DEBUG_3})
@Retention(RetentionPolicy.SOURCE)
public @interface ImageType {
    int NO_IMAGE = 0;
    int DEBUG_1 = 1;
    int DEBUG_2 = 2;
    int DEBUG_3 = 3;
}
