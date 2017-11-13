package ru.utils.view;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Views
 *
 * @author Vyacheslav Shmakin
 * @version 19.04.2017
 */
public class Views {

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T extends Fragment> T findFragmentByTag(@NonNull FragmentManager fm, @NonNull String tag) {
        return (T) fm.findFragmentByTag(tag);
    }

    @Nullable
    @SuppressWarnings({"unchecked", "unused"})
    public static <T extends Fragment> T findFragmentById(@NonNull FragmentManager fm, @IdRes int id) {
        return (T) fm.findFragmentById(id);
    }
}
