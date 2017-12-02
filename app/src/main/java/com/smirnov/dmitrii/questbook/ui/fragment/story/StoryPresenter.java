package com.smirnov.dmitrii.questbook.ui.fragment.story;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.Images;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryImageItem;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.model.story.action.FlagModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.mvp.RxPresenter;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryPresenter extends RxPresenter<StoryView> {

    private static final String TAG = StoryPresenter.class.getSimpleName();

    public void init() {
        getView().resetStory();

        if (mRandom.nextBoolean()) {
            getView().addStoryItem(getRandomImageItem());
        }
        getView().addStoryItem(getRandomChapterItem());

    }

    public void processTextShown() {
        getView().addStoryItem(getRandomActionItem());
    }

    public void processActionChosen(ActionModel model) {
        getView().showToastMessage(model.getName());
        getView().removeLastItem();
        if (mRandom.nextBoolean()) {
            getView().addStoryItem(getRandomImageItem());
        }
        getView().addStoryItem(getRandomChapterItem());
    }

    /**
     * --------------------------------------------------------------------------------------------------------------
     * DEBUGGING PART ONLY
     * --------------------------------------------------------------------------------------------------------------
     */

    private StoryChaperItem getRandomChapterItem() {
        return new StoryChaperItem(getRandomDebugText());
    }

    private StoryActionItem getRandomActionItem() {
        int size = mRandom.nextInt(3) + 1;
        List<ActionModel> actions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            actions.add(getRandomAction());
        }
        return new StoryActionItem(actions);
    }

    private StoryImageItem getRandomImageItem() {
        return new StoryImageItem(getRandomImageType());
    }

    private Random mRandom = new Random();

    private Images getRandomImageType() {
        int pos = mRandom.nextInt(Images.values().length);
        return Images.fromOrdinal(pos);
    }

    private String getRandomDebugText() {
        int rnd = mRandom.nextInt(2) + 1;
        if (rnd == 2) {
            return getLongDebugText();
        } else {
            return getShortDebugText();
        }
    }

    private String getShortDebugText() {
//        return App.context().getString(R.string.debug_short_text);
        return getView().getContext().getString(R.string.debug_short_text);
    }

    private String getLongDebugText() {
//        return App.context().getString(R.string.debug_long_text);
        return getView().getContext().getString(R.string.debug_long_text);
    }

    private ActionModel getRandomAction() {
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
            default:
                name = "ПОБЕДИТЬ";
                break;
        }
        return new ActionModel(name, flags);
    }

}
