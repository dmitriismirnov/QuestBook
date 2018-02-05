package com.smirnov.dmitrii.questbook.app.cache.repository;

import android.support.annotation.Nullable;

import com.smirnov.dmitrii.questbook.app.Preferences;
import com.smirnov.dmitrii.questbook.ui.model.story.StoryProgress;

/**
 * Created by Дмитрий on 13.11.2017.
 */

public class DataRepositoryImpl implements DataRepository {

    private static final String TAG = DataRepositoryImpl.class.getSimpleName();

    private static final String PREF_STORY_PROGRESS_KEY = "story-progress";

    private static StoryProgress sStoryProgress;

    @Nullable
    @Override
    public StoryProgress getStoryProgress() {
        if (sStoryProgress == null) {
            StoryProgress storyProgress = Preferences.getStoredData(PREF_STORY_PROGRESS_KEY, StoryProgress.class);
            synchronized (DataRepositoryImpl.class) {
                sStoryProgress = storyProgress;
            }
        }
        return sStoryProgress;
    }

    @Override
    public void storeStoryProgress(@Nullable StoryProgress storyProgress) {
        synchronized (DataRepositoryImpl.class) {
            sStoryProgress = storyProgress;
        }
        Preferences.storeData(storyProgress, PREF_STORY_PROGRESS_KEY);
    }
}
