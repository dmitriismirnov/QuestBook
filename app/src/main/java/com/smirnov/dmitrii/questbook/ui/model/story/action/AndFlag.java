package com.smirnov.dmitrii.questbook.ui.model.story.action;

import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

public class AndFlag extends FlagModel {

    public AndFlag(List<String> items) {
        super(items);
    }

    @Override
    boolean canPassTheFlag(List<String> userItems) {
        for (String flag : getFlags()) {
            boolean currentFlagFound = false;
            for (String userItem : userItems) {
                if (flag.equalsIgnoreCase(userItem)) {
                    currentFlagFound = true;
                    break;
                }
            }
            if (!currentFlagFound) {
                return false;
            }
        }
        return true;
    }

    @Override
    void passTheFlag(List<String> userItems) {
        //do nothing
    }
}
