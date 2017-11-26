package com.smirnov.dmitrii.questbook.ui.fragment.story;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.app.App;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.ImageType;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryImageItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

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

//        for (int i = 0; i < 10; i++) {
            getView().addStoryItem(getRandomChapterItem());
            getView().addStoryItem(getRandomActionItem());
            if (mRandom.nextBoolean()) {
                getView().addStoryItem(getRandomImageItem());
            }
//        }
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
        List<String> actions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            actions.add(getRandomAction());
        }
        return new StoryActionItem(actions);
    }

    private StoryImageItem getRandomImageItem() {
        return new StoryImageItem(getRandomImageType());
    }

    Random mRandom = new Random();

    @ImageType
    private int getRandomImageType() {
        int images[] = {ImageType.DEBUG_1, ImageType.DEBUG_2, ImageType.DEBUG_3};
        int pos = mRandom.nextInt(images.length);
        return images[pos];
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

    private String getRandomAction() {
        int rnd = mRandom.nextInt(10);

        switch (rnd) {
            case 0:
                return "Налево";
            case 1:
                return "Вперед";
            case 2:
                return "Направо";
            case 3:
                return "Назад";
            case 4:
                return "ДРАКА";
            case 5:
                return "ОТСТУПАЮ";
            case 6:
                return "Попытка украсть деньги";
            case 7:
                return "Попытка взломать замок";
            case 8:
                return "Использовать силу земли";
            case 9:
                return "Лососнуть тунца";
            default:
                return "ПОБЕДИТЬ";
        }
    }

    private ActionModel getRandomActionModel(){
        return new ActionModel(getRandomAction(), null);
    }

}
