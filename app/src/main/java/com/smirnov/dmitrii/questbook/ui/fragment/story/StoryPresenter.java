package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.app.utils.CommonUtils;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.model.story.StoryModel;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

import java.util.Random;

import ru.mvp.RxPresenter;
import ru.utils.data.GsonUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryPresenter extends RxPresenter<StoryView> {

    private static final String TAG = StoryPresenter.class.getSimpleName();

    private Random mRandom = new Random();

    private static final String FIRST_CHAPTER = "1.json";
    private static final String PATH_TESTBOOK_DIR = "books/testbook/";

    private StoryModel mCurrentStoryModel;

    public void init() {
        getView().resetStory();

        processChapter(FIRST_CHAPTER);
    }

    public void processTextShown() {
        getView().setUserAction(new StoryActionItem(mCurrentStoryModel.getActions()));
    }

    public void processActionChosen(@NonNull ActionModel model) {
        getView().showToastMessage(model.getNextChapter());
        getView().hideUserAction();
        processChapter(model.getNextChapter());
    }

    void processChapter(@NonNull String chapterName) {
        String jsonStr = CommonUtils.loadAsset(getBookPath() + chapterName);
        mCurrentStoryModel = GsonUtils.fromJson(jsonStr, StoryModel.class);

        getView().addStoryItem(new StoryChaperItem(mCurrentStoryModel.getText()));
    }

    private String getBookPath() {
        return PATH_TESTBOOK_DIR;
    }

}
