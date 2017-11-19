package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;

import ru.mvp.IView;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public interface StoryView extends IView {

    void resetStory();

    void addStoryItem(@NonNull StoryItem storyItem);


}
