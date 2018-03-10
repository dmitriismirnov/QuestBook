package com.smirnov.dmitrii.questbook.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.UserInteractionListener;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.utils.AnimUtils;

/**
 * @author Dmitry Smirnov
 * @version 29.01.2018.
 */

public class StoryUserActionView extends LinearLayout {

    private final static String TAG = StoryUserActionView.class.getSimpleName();

    @BindView(R.id.story_action_container)
    LinearLayout mActionContainer;

    private UserInteractionListener mUserInteractionListener;
    private boolean isClickPossible = true;

    public StoryUserActionView(Context context) {
        super(context);
        init(context, null);
    }

    public StoryUserActionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StoryUserActionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StoryUserActionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        inflate(context, R.layout.view_story_user_action, this);
        ButterKnife.bind(this);
    }

    public void setUserInteractionListener(@Nullable UserInteractionListener listener) {
        this.mUserInteractionListener = listener;
    }

    public void setUpActionItem(@NonNull StoryActionItem actionItem) {
//        clear();
        List<ActionModel> actionList = actionItem.getActionList();
        for (int i = 0; i < actionList.size(); i++) {
            mActionContainer.addView(getSingleActionItemView(actionList.get(i)));
        }
    }

    public void clear() {
        mActionContainer.removeAllViewsInLayout();
    }

    public void show() {
        unBlockClick();
        AnimUtils.animateViewAppear(mActionContainer, R.anim.slide_in_from_bottom);
    }

    public void hide() {
        blockClick();
        AnimUtils.animateViewHide(mActionContainer, R.anim.slide_out_to_bottom);
    }

    private void unBlockClick(){
        isClickPossible = true;
    }
    private void blockClick(){
        isClickPossible = false;
    }

    @NonNull
    private TextView getSingleActionItemView(@NonNull final ActionModel action) {
        @SuppressLint("InflateParams")
        TextView v = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_action, null);
        v.setText(action.getName());
        v.setOnClickListener(v1 -> {
            if (mUserInteractionListener != null && isClickPossible) {
                mUserInteractionListener.onChooseAction(action);
//                mUserInteractionListener = null;
            }
        });
        return v;
    }

}
