package com.smirnov.dmitrii.questbook.ui.model.story.action;

import java.util.List;

/**
 * FlagModel
 *
 * @author Дмитрий
 * @version 26.11.2017.
 */

public abstract class FlagModel {

    private List<String> mFlags;

    public FlagModel(List<String> flags) {
        this.mFlags = flags;
    }

    public List<String> getFlags() {
        return mFlags;
    }

    abstract boolean canPassTheFlag(List<String> userItems);

    abstract void passTheFlag(List<String> userItems);
}
