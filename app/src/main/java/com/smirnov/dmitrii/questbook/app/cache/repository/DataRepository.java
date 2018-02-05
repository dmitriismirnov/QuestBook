package com.smirnov.dmitrii.questbook.app.cache.repository;

import android.support.annotation.Nullable;

import com.smirnov.dmitrii.questbook.ui.model.story.StoryProgress;

/**
 * Created by Дмитрий on 13.11.2017.
 */

public interface DataRepository {

    @Nullable
    StoryProgress getStoryProgress();

    void storeStoryProgress(@Nullable StoryProgress storyProgress);
}
