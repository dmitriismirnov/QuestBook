package ru.utils.text;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * a
 * Created by deler on 18.08.16.
 */
final public class EmailUtils {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
