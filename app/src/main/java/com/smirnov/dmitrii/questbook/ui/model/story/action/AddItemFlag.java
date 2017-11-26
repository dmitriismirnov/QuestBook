package com.smirnov.dmitrii.questbook.ui.model.story.action;

import java.util.List;

/**
 * @author Дмитрий
 * @version 26.11.2017.
 */

public class AddItemFlag extends FlagModel {

    public AddItemFlag(List<String> flags) {
        super(flags);
    }

    @Override
    boolean canPassTheFlag(List<String> userItems) {
        return true;
    }

    @Override
    void passTheFlag(List<String> userItems) {
        userItems.addAll(getFlags());
    }
}
