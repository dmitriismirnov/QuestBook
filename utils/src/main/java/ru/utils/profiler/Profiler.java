package ru.utils.profiler;

import java.util.HashMap;
import java.util.Map;

import ru.utils.LogUtils;

/**
 * a
 * Created by deler on 30.05.16.
 */
public class Profiler {
    private static final String TAG = Profiler.class.getSimpleName();

    private static Profiler singleton;

    public Map<String, Long> startTimeRequestMap;
    public Map<String, Long> startTimeParsingMap;

    public static Profiler instance() {
        if (singleton == null) {
            synchronized (Profiler.class) {
                if (singleton == null) {
                    singleton = new Profiler();
                }
            }
        }
        return singleton;
    }

    public Profiler() {
        startTimeRequestMap = new HashMap<>();
        startTimeParsingMap = new HashMap<>();
    }

    public void startRequest(String tag) {
        try {
            startTimeRequestMap.put(tag, System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long stopRequest(String tag) {
        try {
            Long startTime = startTimeRequestMap.get(tag);
            if (startTime == null) {
                LogUtils.d(TAG, "REQUEST " + tag + " elapsed for: NULL");
                return 0;
            }
            long elapsed = System.currentTimeMillis() - startTime;
            LogUtils.d(TAG, "REQUEST " + tag + " elapsed for: " + elapsed + " ms");
            startTimeRequestMap.remove(tag);
            return elapsed;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void startParsing(String tag) {
        try {
            startTimeParsingMap.put(tag, System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long stopParsing(String tag) {
        try {
            Long startTime = startTimeParsingMap.get(tag);
            if (startTime == null) {
                LogUtils.d(TAG, "PARSING " + tag + " elapsed for: NULL");
                return 0;
            }
            long elapsed = System.currentTimeMillis() - startTime;
            LogUtils.d(TAG, "PARSING " + tag + " elapsed for: " + elapsed + " ms");
            startTimeParsingMap.remove(tag);
            return elapsed;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
