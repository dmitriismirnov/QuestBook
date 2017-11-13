package ru.utils;

import android.util.Log;

public final class LogUtils {
    private static int MAX_TAG_LEN = 23;

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable ex) {
        Log.w(tag, msg, ex);
    }

    public static void w(String tag, Throwable ex) {
        Log.w(tag, ex);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg != null ? msg : "");
    }

    public static void e(String tag, String msg, Throwable ex) {
        Log.e(tag, msg, ex);
    }

    public static void e(String tag, Throwable ex) {
        Log.e(tag, "", ex);
    }

    private LogUtils() {
    }
}
