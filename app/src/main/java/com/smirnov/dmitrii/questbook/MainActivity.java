package com.smirnov.dmitrii.questbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.smirnov.dmitrii.questbook.app.books.Books;
import com.smirnov.dmitrii.questbook.app.cache.DataProvider;
import com.smirnov.dmitrii.questbook.ui.activity.story.StoryActivity;
import com.smirnov.dmitrii.questbook.ui.model.story.StoryProgress;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.continue_game)
    TextView mContinueGame;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpContinueButtonAvailability();
    }

    private void setUpContinueButtonAvailability() {
        mContinueGame.setEnabled(isStoryProgressAvailable());
    }

    private boolean isStoryProgressAvailable() {
        StoryProgress progress = DataProvider.provide().getStoryProgress();
        return progress != null
                && !progress.getChapter().equalsIgnoreCase(progress.getBook().getFirstChapter());
    }

    @OnClick(R.id.new_game)
    void clickNewKonanGame() {
        StoryActivity.start(this, Books.KONAN);
    }

    @OnClick(R.id.test_game)
    void clickTestGame() {
        StoryActivity.start(this, Books.TEST);
    }

    @OnClick(R.id.continue_game)
    void clickContinue() {
        StoryActivity.load(this);
    }
}
