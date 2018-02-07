package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * FlagModel
 *
 * @author Дмитрий
 * @version 26.11.2017.
 */

public class FlagModel {

    @SerializedName("names")
    private List<String> mFlags;
    @SerializedName("type")
    private FlagType mType;

    public FlagModel(List<String> flags) {
        this.mFlags = flags;
    }

    public List<String> getFlags() {
        return mFlags;
    }

    public FlagType getFlagType() {
        return mType;
    }

    public boolean canPassTheFlag(List<String> userItems) {
        return FlagsHelper.canPassTheFlag(userItems, mFlags, mType);
    }

    public void passTheFlag(List<String> userItems) {
        FlagsHelper.passTheFlag(userItems, mFlags, mType);
    }
}
