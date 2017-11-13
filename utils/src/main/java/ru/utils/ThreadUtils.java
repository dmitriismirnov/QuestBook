package ru.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class ThreadUtils {
    private static final Object sLock = new Object();
    private static boolean sWillOverride = false;
    private static Handler sUiThreadHandler = null;

    private ThreadUtils() {
    }

    public static void setWillOverrideUiThread() {
        Object var0 = sLock;
        synchronized(sLock) {
            sWillOverride = true;
        }
    }

    public static void setUiThread(Looper looper) {
        Object var1 = sLock;
        synchronized(sLock) {
            if(sUiThreadHandler != null && sUiThreadHandler.getLooper() != looper) {
                throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + looper);
            } else {
                sUiThreadHandler = new Handler(looper);
            }
        }
    }

    private static Handler getUiThreadHandler() {
        Object var0 = sLock;
        synchronized(sLock) {
            if(sUiThreadHandler == null) {
                if(sWillOverride) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }

                sUiThreadHandler = new Handler(Looper.getMainLooper());
            }

            return sUiThreadHandler;
        }
    }

    public static void runOnUiThreadBlocking(Runnable r) {
        if(runningOnUiThread()) {
            r.run();
        } else {
            FutureTask task = new FutureTask(r, null);
            postOnUiThread(task);

            try {
                task.get();
            } catch (Exception var3) {
                throw new RuntimeException("Exception occured while waiting for runnable", var3);
            }
        }

    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> c) {
        try {
            return runOnUiThreadBlocking(c);
        } catch (ExecutionException var2) {
            throw new RuntimeException("Error occured waiting for callable", var2);
        }
    }

    public static <T> T runOnUiThreadBlocking(Callable<T> c) throws ExecutionException {
        FutureTask task = new FutureTask(c);
        runOnUiThread(task);

        try {
            return (T) task.get();
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted waiting for callable", var3);
        }
    }

    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> task) {
        if(runningOnUiThread()) {
            task.run();
        } else {
            postOnUiThread(task);
        }

        return task;
    }

    public static <T> FutureTask<T> runOnUiThread(Callable<T> c) {
        return runOnUiThread(new FutureTask(c));
    }

    public static void runOnUiThread(Runnable r) {
        if(runningOnUiThread()) {
            r.run();
        } else {
            getUiThreadHandler().post(r);
        }

    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> task) {
        getUiThreadHandler().post(task);
        return task;
    }

    public static void postOnUiThread(Runnable task) {
        getUiThreadHandler().post(task);
    }

    public static void postOnUiThreadDelayed(Runnable task, long delayMillis) {
        getUiThreadHandler().postDelayed(task, delayMillis);
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    public static void setThreadPriorityAudio(int tid) {
        Process.setThreadPriority(tid, -16);
    }
}
