package com.smirnov.dmitrii.questbook.ui.activity.story;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.activity.BaseFragmentActivity;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryActivity extends BaseFragmentActivity {

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, StoryActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_story;
    }

    @Nullable
    @Override
    protected Fragment getReplacingFragment() {
        return null;
    }
}
