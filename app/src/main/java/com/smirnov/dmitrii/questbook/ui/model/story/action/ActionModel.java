package com.smirnov.dmitrii.questbook.ui.model.story.action;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import com.smirnov.dmitrii.questbook.ui.model.story.flags.FlagModel;

import java.util.List;

/**
 * ActionModel
 *
 * @author Дмитрий
 * @version 26.11.2017.
 */

public class ActionModel {

    @SerializedName("name")
    private String mName;
    @SerializedName("flags")
    private List<FlagModel> mFlags;
    @SerializedName("next")
    private String mNextChapter;

    public ActionModel(String name, List<FlagModel> flags, String nextChapter) {
        this.mName = name;
        this.mFlags = flags;
        this.mNextChapter = nextChapter;
    }

    public void passWithFlag(@Nullable FlagModel flag, List<String> userItems) {
        if (flag == null) {
            return;
        }
        flag.passTheFlag(userItems);
    }

    public boolean atLeastOneFlagCanPass(@Nullable List<String> userItems) {
        if (mFlags == null || mFlags.isEmpty()) {
            return true;
        }
        if (userItems == null || userItems.isEmpty()) {
            return false;
        }

        for (FlagModel flag : mFlags) {
            if (flag.canPassTheFlag(userItems)) {
                return true;
            }
        }
        return false;
    }

    public boolean allFlagsCanPass(@Nullable List<String> userItems) {
        if (mFlags == null || mFlags.isEmpty()) {
            return true;
        }
        if (userItems == null || userItems.isEmpty()) {
            return false;
        }

        for (FlagModel flag : mFlags) {
            if (!flag.canPassTheFlag(userItems)) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return mName;
    }

    public String getNextChapter() {
        return mNextChapter;
    }
}
