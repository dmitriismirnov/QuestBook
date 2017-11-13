package ru.utils.text;

import android.graphics.Color;
import android.text.TextUtils;

/**
 * a
 * Created by deler on 18.08.16.
 */
final public class ColorsUtils {
    public static int setColorAlpha(int color, float ratio) {
        int alpha = Math.round(Color.alpha(color) * ratio);
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    public static int parseColor(String color, String defaultColor) {
        try {
            return Color.parseColor(!TextUtils.isEmpty(color) ? color : defaultColor);
        } catch (Exception e) {
            e.printStackTrace();
            return parseColor(defaultColor);
        }
    }

    public static int parseColor(String color, int defaultColor) {
        try {
            return !TextUtils.isEmpty(color) ? Color.parseColor(color) : defaultColor;
        } catch (Exception e) {
            try {
                color = "#"+color;
                return Color.parseColor(color);
            } catch (Exception er) {
                er.printStackTrace();
                return defaultColor;
            }
        }
    }

    public static int parseColor(String color) {
        return parseColor(color, Color.BLACK);
    }
}
