package com.smirnov.dmitrii.questbook.ui.fragment.story;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.app.utils.CommonUtils;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.model.story.StoryModel;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.model.story.flags.FlagModel;

import java.util.ArrayList;
import java.util.List;

import ru.mvp.RxPresenter;
import ru.utils.LogUtils;
import ru.utils.data.GsonUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

class StoryPresenter extends RxPresenter<StoryView> {

    private static final String TAG = StoryPresenter.class.getSimpleName();

    void init() {
        getView().resetStory();

        processChapter(getView().getCurrentChapterName());
    }

    void processTextShown() {
        getView().setUserAction(
                new StoryActionItem(
                        getPossibleActions(
                                getView().getCurrentChapter().getActions())));
    }

    private List<ActionModel> getPossibleActions(List<ActionModel> actions) {
        List<ActionModel> result = new ArrayList<>();

        LogUtils.d(TAG, "FLAG CHECK START");
        LogUtils.d(TAG, "User Items: " + getView().getUserItems().toString());
        for (ActionModel action : actions) {
            if (action.allFlagsCanPass(
                    getView().getUserItems())) {
                result.add(action);
                LogUtils.d(TAG, "CAN PASS: " + action.toString());
            } else {
                LogUtils.d(TAG, "CAN NOT PASS: " + action.toString());
            }
        }

        LogUtils.d(TAG, "FLAG CHECK END");
        return result;
    }

    void processActionChosen(@NonNull ActionModel action) {
        getView().showToastMessage(action.getNextChapter());
        getView().hideUserAction();
        action.pass(
                getView().getUserItems());
        processChapter(action.getNextChapter());
    }

    private void processChapter(@NonNull String chapterName) {
        String jsonStr = CommonUtils.loadAsset(getBookPath() + chapterName + ".json");
        StoryModel newChapter = GsonUtils.fromJson(jsonStr, StoryModel.class);

        if (newChapter != null) {
            activateChapter(newChapter, chapterName);
        } else {
            getView().showToastMessage("chapter is missing\nrestarting book");
            getView().resetStory();
            processChapter(getView().getCurrentBook().getFirstChapter());
        }
    }

    private void activateChapter(@NonNull StoryModel newChapter, @NonNull String chapterName) {
        LogUtils.d(TAG, "User Items before activation: " + getView().getUserItems().toString());
        List<FlagModel> chapterFlags = newChapter.getFlags();
        if (chapterFlags != null && !chapterFlags.isEmpty()) {
            for (FlagModel flag : chapterFlags) {
                flag.passTheFlag(getView().getUserItems());
            }
        }
        LogUtils.d(TAG, "User Items after activation: " + getView().getUserItems().toString());

        getView().setCurrentChapter(newChapter, chapterName);
        getView().addStoryItem(
                new StoryChaperItem(
                        getView().getCurrentChapter().getText()));
    }

    private String getBookPath() {
        return getView().getCurrentBook().getBookPath();
    }

}
