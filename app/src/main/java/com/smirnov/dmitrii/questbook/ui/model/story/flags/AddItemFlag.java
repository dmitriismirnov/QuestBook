package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

@Deprecated
public class AddItemFlag extends FlagModel {

    public AddItemFlag(List<String> flags) {
        super(flags);
    }

    @Override
    public boolean canPassTheFlag(List<String> userItems) {
        return true;
    }

    @Override
    public void passTheFlag(List<String> userItems) {
        userItems.addAll(getFlags());
    }
}
