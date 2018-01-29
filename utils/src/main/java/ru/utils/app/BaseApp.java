package ru.utils.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.multidex.BuildConfig;
import android.support.multidex.MultiDexApplication;


public class BaseApp extends MultiDexApplication {

    private static BaseApp sInstance;

    public static BaseApp instance() {
        return sInstance;
    }

    public static Context context() {
        return sInstance.getApplicationContext();
    }

    @Nullable
    public static String getAppVersion(@Nullable Context context) {
        if (context == null) {
            return "";
        } else {
            String version = null;

            try {
                PackageManager e = context.getPackageManager();
                version = e.getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException var3) {
                var3.printStackTrace();
            }

            return version;
        }
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    public static String getFullAppVersion() {
        if (context() == null) {
            return "";
        } else {
            String version = "";
            int code = 0;
            String releaseCode = BuildConfig.DEBUG ? "d" : "r";
            try {
                PackageManager e = context().getPackageManager();
                version = e.getPackageInfo(context().getPackageName(), 0).versionName;
                code = e.getPackageInfo(context().getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException var3) {
                var3.printStackTrace();
            }

            return String.format("Версия %s (%d)%s", version, code, releaseCode);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
