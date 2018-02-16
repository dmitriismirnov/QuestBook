package com.smirnov.dmitrii.questbook.ui.activity.story;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.app.books.Books;
import com.smirnov.dmitrii.questbook.app.cache.DataProvider;
import com.smirnov.dmitrii.questbook.ui.activity.BaseFragmentActivity;
import com.smirnov.dmitrii.questbook.ui.fragment.story.StoryFragment;
import com.smirnov.dmitrii.questbook.ui.widget.common.NavigationToolbar;

import butterknife.BindView;
import ru.utils.LogUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class StoryActivity extends BaseFragmentActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();

    private static final String EXTRA_BOOK_TYPE = "book-type";
    private static final String EXTRA_CONTINUE = "is-continue";

    @BindView(R.id.toolbar)
    NavigationToolbar mToolbar;

    protected static void start(@NonNull Activity activity, @NonNull Books book, boolean isContinue) {
        Intent intent = new Intent(activity, StoryActivity.class);
        intent.putExtra(EXTRA_BOOK_TYPE, book);
        intent.putExtra(EXTRA_CONTINUE, isContinue);
        activity.startActivity(intent);
    }

    public static void start(@NonNull Activity activity, @NonNull Books book) {
        start(activity, book, false);
    }

    @SuppressWarnings("ConstantConditions")
    public static void load(@NonNull Activity activity) {
        start(activity, DataProvider.provide().getStoryProgress().getBook(), true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(TAG, getBook().getBookName());
        mToolbar.setTitle(getBook().getBookName());  }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_story;
    }

    @Nullable
    @Override
    protected Fragment getReplacingFragment() {
        return StoryFragment.newInstance(getExtras());
    }

    @NonNull
    private Bundle getExtras() {
        Bundle extras = new Bundle();
        extras.putSerializable(EXTRA_BOOK_TYPE, getBook());
        extras.putBoolean(EXTRA_CONTINUE, isContinue());
        return extras;
    }

    private boolean isContinue() {
        return getIntent().getBooleanExtra(EXTRA_CONTINUE, false);
    }

    private Books getBook() {
        return (Books) getIntent().getSerializableExtra(EXTRA_BOOK_TYPE);
    }
}
