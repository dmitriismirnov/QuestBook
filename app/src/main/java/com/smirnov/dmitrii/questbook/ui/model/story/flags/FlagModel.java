package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * FlagModel
 *
 * @author Дмитрий
 * @version 26.11.2017.
 */

public abstract class FlagModel {

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

    @Deprecated
    public abstract boolean canPassTheFlag(List<String> userItems);

    @Deprecated
    public abstract void passTheFlag(List<String> userItems);
}
