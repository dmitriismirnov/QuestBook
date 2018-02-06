package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

@Deprecated
public class UseFlag extends FlagModel {

    public UseFlag(List<String> flags) {
        super(flags);
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
        List<String> loopUserItems = new ArrayList<>();
        loopUserItems.addAll(userItems);
        for (String flag : getFlags()) {
            for (String userItem : loopUserItems) {
                if (flag.equalsIgnoreCase(userItem)) {
                    userItems.remove(userItem);
                }
            }
        }
    }
}
