package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

/**
 * @author Дмитрий
 * @version 02.12.2017.
 */

public interface UserInteractionListener {
    void onChooseAction(@NonNull ActionModel action);
}
