package com.smirnov.dmitrii.questbook.ui.model.story;

import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

import java.util.List;

/**
 * Created by Дмитрий on 18.11.2017.
 */

public class StoryModel {

    /**
     * this is main story model that will be stored in JSON files
     * each model (JsonObject) has
     * TEXT part from which we generate StoryChapterItem
     * ACTION part with possible actions, flags and links to next chapter
     */

    private String mText;
    private List<ActionModel> mActions;
}
