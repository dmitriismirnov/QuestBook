package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.app.App;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.Images;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChapterItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryImageItem;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.model.story.flags.FlagModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Dmitry Smirnov
 * @version 29.01.2018.
 */

public class Generator {

    private static Random mRandom = new Random();

    public static StoryChapterItem getRandomChapterItem() {
        return new StoryChapterItem(getRandomDebugText());
    }

    public static StoryActionItem getRandomActionItem() {
        int size = mRandom.nextInt(3) + 1;
        List<ActionModel> actions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            actions.add(getRandomAction());
        }
        return new StoryActionItem(actions);
    }

    public static StoryImageItem getRandomImageItem() {
        return new StoryImageItem(getRandomImageType());
    }

    public static Images getRandomImageType() {
        int pos = mRandom.nextInt(Images.values().length);
        return Images.fromOrdinal(pos);
    }

    public static String getRandomDebugText() {
        int rnd = mRandom.nextInt(2) + 1;
        if (rnd == 2) {
            return getLongDebugText();
        } else {
            return getShortDebugText();
        }
    }

    public static String getShortDebugText() {
        return App.context().getString(R.string.debug_short_text);
    }

    public static String getLongDebugText() {
        return App.context().getString(R.string.debug_long_text);
    }

    public static ActionModel getRandomAction() {
        int rnd = mRandom.nextInt(10);
        String name;
        List<FlagModel> flags = new ArrayList<>();
        switch (rnd) {
            case 0:
                name = "Налево";
                break;
            case 1:
                name = "Вперед";
                break;
            case 2:
                name = "Направо";
                break;
            case 3:
                name = "Назад";
                break;
            case 4:
                name = "ДРАКА";
                break;
            case 5:
                name = "ОТСТУПАЮ";
                break;
            case 6:
                name = "Попытка украсть деньги";
                break;
            case 7:
                name = "Попытка взломать замок";
                break;
            case 8:
                name = "Использовать силу земли";
                break;
            case 9:
                name = "Лососнуть тунца";
                break;
            default:
                name = "ПОБЕДИТЬ";
                break;
        }
        return new ActionModel(name, flags, rnd + ".json");
    }
}
