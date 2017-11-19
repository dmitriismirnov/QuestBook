package com.smirnov.dmitrii.questbook.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryTextView extends android.support.v7.widget.AppCompatTextView {

    //TODO add listener text ends; add finish/fasten displaying text on click.

    private CharSequence mChars;
    private int mIndex;
    private long mDelay = 50; //default is 50 milliseconds

    public StoryTextView(Context context) {
        super(context);
    }

    public StoryTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StoryTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            setText(mChars.subSequence(0, mIndex++));
            if (mIndex <= mChars.length()) {
                mHandler.postDelayed(mRunnable, mDelay);
            }
        }
    };

    public void displayTextWithAnimation(CharSequence txt) {
        mChars = txt;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(mRunnable);
        mHandler.postDelayed(mRunnable, mDelay);
    }

    public void setDelay(long millis) {
        mDelay = millis;
    }
}
