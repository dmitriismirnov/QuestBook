package ru.utils;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.Spanned;

/**
 * HtmlCompat
 *
 * @author Vyacheslav Shmakin
 * @version 26.09.2017
 */

public class HtmlCompat {

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(@NonNull String html){
        Spanned result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
