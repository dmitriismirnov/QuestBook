package ru.utils.text;

import android.net.Uri;
import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * a
 * Created by deler on 18.08.16.
 */
final public class PhoneUtils {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(7|8)[0-9]{10}$");

    public static Uri phoneNumberToUri(String phoneNumber) {
        phoneNumber = phoneNumber.trim();

        if (phoneNumber.length() > 0) {
            phoneNumber = ((phoneNumber.charAt(0) == '+') ? "+" : "") + phoneNumber.replaceAll("[^0-9]", "");
        }

        return Uri.parse("tel:" + phoneNumber);
    }

    public static boolean isPhoneMask(String mask) {
        return !TextUtils.isEmpty(mask) && (mask.startsWith("+{7}") || mask.startsWith("+[7]") || mask.startsWith("+(7)"));
    }

    public static boolean isPhoneNumber(CharSequence target) {
        return (!TextUtils.isEmpty(target) && PHONE_NUMBER_PATTERN.matcher(target).matches());
    }

}
