package com.smirnov.dmitrii.questbook.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import ru.utils.LogUtils;
import ru.utils.data.GsonUtils;

/**
 * Created by Дмитрий on 13.11.2017.
 */

public final class Preferences {

    private static final String TAG = Preferences.class.getSimpleName();

    public static void storeData(@Nullable Object object, @NonNull String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.instance());
        String data = object == null ? null : GsonUtils.toJson(object);
        prefs.edit().putString(key, data).apply();
    }

    @Nullable
    public static <T> T getStoredData(@NonNull String key, @NonNull Class<T> tClass) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(App.instance());
        String data = prefs.getString(key, null);
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        try {
            return GsonUtils.fromJson(data, tClass);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
        return null;
    }
}
