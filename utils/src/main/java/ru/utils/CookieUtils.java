package ru.utils;

import java.net.HttpCookie;

public final class CookieUtils
{
// -- construction

    private CookieUtils() {
        // do nothing ..
    }

    //TODO: check age
    public static boolean isExpiredOrNull(HttpCookie cookie, long offsetInMilliseconds)
    {
        boolean isExpired = true;
        if (cookie != null) {
            isExpired = cookie.hasExpired();
        }

        // done
        return isExpired;
    }

}
