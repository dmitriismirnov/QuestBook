package ru.utils.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import ru.utils.LogUtils;

/**
 * a
 * Created by deler on 21.02.17.
 */

public class StreamUtils {

    private static final String TAG = StreamUtils.class.getSimpleName();

    // ------------------------------------------------------------------------------------------------------------------------------------
    // различные close

    public static void close(InputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }

    public static void close(InputStreamReader is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }

    public static void close(BufferedReader is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }

    public static void close(BufferedWriter is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }

    public static void close(OutputStream is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }

    public static void close(OutputStreamWriter is) {
        try {
            if (is != null) {
                is.close();
            }
        } catch (Throwable th) {
            LogUtils.e(TAG, th);
        }
    }
}
