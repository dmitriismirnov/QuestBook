package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

@Deprecated
public class OrFlag extends FlagModel {

    public OrFlag(List<String> items) {
        super(items);
    }

    @Override
    public boolean canPassTheFlag(List<String> userItems) {
        for (String flag : getFlags()) {
            for (String userItem : userItems) {
                if (flag.equalsIgnoreCase(userItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void passTheFlag(List<String> userItems) {
        //do nothing
    }
}
