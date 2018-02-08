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

    public FlagModel(List<String> flags, FlagType type) {
        this.mFlags = flags;
        this.mType = type;
    }

    public FlagModel() {
    }

    public List<String> getFlags() {
        return mFlags;
    }

    public FlagType getType() {
        return mType;
    }

    public boolean canPassTheFlag(List<String> userItems) {
        return FlagsHelper.canPassTheFlag(userItems, mFlags, mType);
    }

    public void passTheFlag(List<String> userItems) {
        FlagsHelper.passTheFlag(userItems, mFlags, mType);
    }

    @Override
    public String toString() {
        return "FlagModel{" +
                "mFlags=" + mFlags +
                ", mType=" + mType +
                '}';
    }
}
