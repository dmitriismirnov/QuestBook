package com.smirnov.dmitrii.questbook.ui.model.story.action;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * ActionModel
 *
 * @author Дмитрий
 * @version 26.11.2017.
 */

public class ActionModel {

    private String mName;
    private List<FlagModel> mFlags;

    public ActionModel(String mName, List<FlagModel> mFlags) {
        this.mName = mName;
        this.mFlags = mFlags;
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
}
