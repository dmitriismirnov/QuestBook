package com.smirnov.dmitrii.questbook.app.books;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.app.App;

/**
 * @author Dmitry Smirnov
 * @version 01.02.2018.
 */

public enum Books {
    KONAN(App.context().getString(R.string.konan_bookname), "books/konan/", "0.json"),
    TEST("TESTBOOK", "books/testbook/", "1.json");


    private String mBookName;
    private String mBookPath;
    private String mFirstChapter;

    Books(@NonNull String mBookName, @NonNull String mBookPath, @NonNull String mFirstChapter) {
        this.mBookName = mBookName;
        this.mBookPath = mBookPath;
        this.mFirstChapter = mFirstChapter;
    }

    @NonNull
    public String getBookName() {
        return mBookName;
    }

    @NonNull
    public String getBookPath() {
        return mBookPath;
    }

    @NonNull
    public String getFirstChapter() {
        return mFirstChapter;
    }
}
