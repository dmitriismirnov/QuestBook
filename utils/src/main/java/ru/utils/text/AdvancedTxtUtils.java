package ru.utils.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

import ru.pochtabank.utils.Config;
import ru.pochtabank.utils.data.JsonKeys;

/**
 * a
 * Created by deler on 18.08.16.
 */
final public class AdvancedTxtUtils {

    @NonNull
    public static String toTitleCase(@Nullable String givenString) {
        if (TextUtils.isEmpty(givenString))
            return "";

        String[] arr = givenString.toLowerCase(Config.LOCALE).split(" ");
        StringBuilder sb = new StringBuilder(givenString.length());

        for (String word : arr) {
            if (word.length() >= 1) {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            if (word.length() >= 2) {
                sb.append(word.substring(1));
            }

            if (word.length() >= 1) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String capitalize(String text) {
        return TextUtils.isEmpty(text) ? text : text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public static CharSequence processExtendedText(String text) {
        return processExtendedText(text, true);
    }

    public static CharSequence processExtendedText(String text, boolean withHtml) {
        SpannableStringBuilder spannableResultBuilder = new SpannableStringBuilder(withHtml ? Html.fromHtml(text) : text);

        String visibleText = spannableResultBuilder.toString();
        int rurPosition = -1;
        while ((rurPosition = visibleText.indexOf(JsonKeys.JSON_RUBLE_PLACEHOLDER)) != -1) {
            spannableResultBuilder.replace(rurPosition, rurPosition + JsonKeys.JSON_RUBLE_PLACEHOLDER.length(), " " + FontUtils.RUBLE_SIGN_PLACEHOLDER);
            spannableResultBuilder.setSpan(new CustomTypefaceSpan("", FontUtils.RUBLE_TYPEFACE), rurPosition + 1, rurPosition + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            visibleText = spannableResultBuilder.toString();
        }

        return spannableResultBuilder;
    }


    public static int compareVersionName(String version1, String version2) {
        String[] vals1 = version1.split("\\.");
        String[] vals2 = version2.split("\\.");

        int length = Math.max(vals1.length, vals2.length);
        for (int i = 0; i < length; i++) {
            if (i < vals1.length && i < vals2.length){
                int v1 = Integer.valueOf(vals1[i]);
                int v2 = Integer.valueOf(vals2[i]);
                if (v1 != v2){
                    return (v1 < v2) ? -1 : 1;
                }
            } else {
                if (i < vals1.length){
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
}
