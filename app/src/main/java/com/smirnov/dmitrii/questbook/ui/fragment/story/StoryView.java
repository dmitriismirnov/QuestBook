package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;

import ru.mvp.IView;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public interface StoryView extends IView {

    void resetStory();

    void addStoryItem(@NonNull StoryItem storyItem);

    void setUserAction(@Nullable StoryActionItem actionItem);

    void showUserAction();

    void hideUserAction();

    void removeLastItem();

    void showToastMessage(@NonNull String message);

    void scrollToEnd();
}
