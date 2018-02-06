package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

@Deprecated
public class AndFlag extends FlagModel {

    public AndFlag(List<String> items) {
        super(items);
    }

    @Override
    public boolean canPassTheFlag(List<String> userItems) {
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
    public void passTheFlag(List<String> userItems) {
        //do nothing
    }
}
