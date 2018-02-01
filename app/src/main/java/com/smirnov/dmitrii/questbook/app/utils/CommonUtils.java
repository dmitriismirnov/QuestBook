package com.smirnov.dmitrii.questbook.app.utils;

import android.content.res.AssetManager;

import com.smirnov.dmitrii.questbook.app.App;

import java.io.IOException;
import java.io.InputStream;

import ru.utils.LogUtils;

/**
 * @author Dmitry Smirnov
 * @version 01.02.2018.
 */

final public class CommonUtils {

    private final static String TAG = CommonUtils.class.getSimpleName();

    public static String loadAsset(String path) {
        AssetManager manager = App.context().getAssets();
        String content = null;

        try {
            InputStream e = manager.open(path);
            if (e != null) {
                byte[] buffer = new byte[e.available()];
                e.read(buffer);
                e.close();
                content = new String(buffer);
            }
        } catch (IOException var5) {
            LogUtils.w(TAG, var5);
        }

        return content;
    }

}
