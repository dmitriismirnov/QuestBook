package com.smirnov.dmitrii.questbook.ui.model.story;

import com.google.gson.annotations.SerializedName;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.Images;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.model.story.flags.FlagModel;

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

    @SerializedName("text")
    private String mText;
    @SerializedName("actions")
    private List<ActionModel> mActions;
    @SerializedName("flags")
    private List<FlagModel> mFlags;
    @SerializedName("image")
    private Images mImage;

    public StoryModel() {
    }

    public String getText() {
        return mText;
    }

    public List<ActionModel> getActions() {
        return mActions;
    }

    public List<FlagModel> getFlags() {
        return mFlags;
    }

    public Images getImage() {
        return mImage;
    }
}
