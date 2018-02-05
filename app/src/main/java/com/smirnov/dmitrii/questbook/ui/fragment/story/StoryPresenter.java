package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.app.utils.CommonUtils;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.model.story.StoryModel;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

import ru.mvp.RxPresenter;
import ru.utils.data.GsonUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryPresenter extends RxPresenter<StoryView> {

    private static final String TAG = StoryPresenter.class.getSimpleName();

    public void init() {
        getView().resetStory();

        processChapter(getView().getCurrentChapterName());
    }

    public void processTextShown() {
        getView().setUserAction(
                new StoryActionItem(
                        getView().getCurrentChapter().getActions()));
    }

    public void processActionChosen(@NonNull ActionModel model) {
        getView().showToastMessage(model.getNextChapter());
        getView().hideUserAction();
        processChapter(model.getNextChapter());
    }

    void processChapter(@NonNull String chapterName) {
        String jsonStr = CommonUtils.loadAsset(getBookPath() + chapterName + ".json");
        StoryModel newChapter = GsonUtils.fromJson(jsonStr, StoryModel.class);

        if (newChapter != null) {
            getView().setCurrentChapter(newChapter, chapterName);
            getView().addStoryItem(
                    new StoryChaperItem(
                            getView().getCurrentChapter().getText()));
        } else {
            getView().showToastMessage("chapter is missing\nrestarting book");
            getView().resetStory();
            processChapter(getView().getCurrentBook().getFirstChapter());
        }
    }

    private String getBookPath() {
        return getView().getCurrentBook().getBookPath();
    }

}
