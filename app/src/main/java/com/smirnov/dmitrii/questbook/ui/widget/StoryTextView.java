package com.smirnov.dmitrii.questbook.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.TextDisplayFinishListener;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryTextView extends android.support.v7.widget.AppCompatTextView {

    private CharSequence mChars;
    private int mIndex;
    private long mDelay = 50; //default is 50 milliseconds
    private TextDisplayFinishListener mListener;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;

    public StoryTextView(Context context) {
        super(context);
        init();
    }

    public StoryTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StoryTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRunnable = () -> {
            setText(mChars.subSequence(0, mIndex++));
            if (mIndex <= mChars.length()) {
                mHandler.postDelayed(mRunnable, mDelay);
            } else if (mListener != null) {
                mListener.onTextDisplayingFinished();
            }
        };
    }


    public void displayTextWithAnimation(CharSequence txt) {
        mChars = txt;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(mRunnable);
        mHandler.postDelayed(mRunnable, mDelay);
    }

    public void finishDisplaying() {
        mHandler.removeCallbacks(mRunnable);
        setText(mChars);
        if (mListener != null) {
            mListener.onTextDisplayingFinished();
        }
    }

    public long getDelay() {
        return mDelay;
    }

    public void setDelay(long millis) {
        this.mDelay = millis;
    }

    public void setTextDisplayListener(TextDisplayFinishListener listener) {
        this.mListener = listener;
    }

}
