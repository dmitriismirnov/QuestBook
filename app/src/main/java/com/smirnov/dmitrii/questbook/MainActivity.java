package com.smirnov.dmitrii.questbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.smirnov.dmitrii.questbook.ui.activity.story.StoryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.new_game)
    TextView mNewGame;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.new_game)
    void clickNewGame() {
        LogUtils.d(TAG, "clickNewGame");
        StoryActivity.start(this);
    }

    @OnClick(R.id.continue_game)
    void clickContinue() {
        LogUtils.d(TAG, "clickContinue");
    }
}
