package ru.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * IView
 * Created by deler on 21.02.17.
 */

public interface IView {
    Context getContext();

    void onPause();

    void onResume();

    void onDestroyView();

    void onSaveInstanceState(Bundle outState);

    void onViewStateRestored(@Nullable Bundle savedInstanceState);

    View getView();
}
