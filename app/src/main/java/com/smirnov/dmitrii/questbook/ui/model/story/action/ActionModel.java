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

    public void pass(List<String> userItems) {
        if (mFlags == null) {
            return;
        }
        for (FlagModel flag : mFlags) {
            flag.passTheFlag(userItems);
        }
    }

    public boolean allFlagsCanPass(@Nullable List<String> userItems) {
        if (mFlags == null || mFlags.isEmpty()) {
            return true;
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

    @Override
    public String toString() {
        return "ActionModel{" +
                "mName='" + mName + '\'' +
                ", mFlags=" + mFlags +
                ", mNextChapter='" + mNextChapter + '\'' +
                '}';
    }
}
