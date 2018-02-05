package com.smirnov.dmitrii.questbook.ui.model.story;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.smirnov.dmitrii.questbook.app.books.Books;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Smirnov
 * @version 05.02.2018.
 */

public class StoryProgress {

    private Books mBook;
    private String mChapter;
    private List<String> mFlags;

    public StoryProgress(@NonNull Books book, @NonNull String chapter, @Nullable List<String> flags) {
        this.mBook = book;
        this.mChapter = chapter;
        this.mFlags = flags == null ? new ArrayList<>() : flags;
    }

    public Books getBook() {
        return mBook;
    }

    public String getChapter() {
        return mChapter;
    }

    public List<String> getFlags() {
        return mFlags;
    }
}
