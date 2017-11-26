package ru.utils.text;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;

import ru.utils.app.BaseApp;

public final class FontUtils {
    public static final String DEFAULT_NORMAL_BOLD_FONT_FILENAME = "fonts/Roboto/Roboto-Regular.ttf";
    public static final String DEFAULT_NORMAL_BOLD_ITALIC_FONT_FILENAME = "fonts/Roboto/Roboto-BoldItalic.ttf";
    public static final String DEFAULT_NORMAL_ITALIC_FONT_FILENAME = "fonts/Roboto/Roboto-Italic.ttf";
    public static final String DEFAULT_NORMAL_NORMAL_FONT_FILENAME = "fonts/Roboto/Roboto-Light.ttf";
    public static final String SYMBOLS_FONT_FILENAME = "fonts/Arial.ttf";
    public static final String CARD_FONT_FILENAME_OLD = "fonts/OCRAStd.ttf";
    public static final String CARD_FONT_FILENAME = "fonts/PochtaFont_release-Regular.ttf";

    public static final Typeface SYMBOLS_TYPEFACE = Typeface.createFromAsset(BaseApp.context().getAssets(), SYMBOLS_FONT_FILENAME);

    public static final String RUBLE_DEFAULT_NORMAL_NORMAL_FONT_FILENAME = "fonts/Roboto/Roboto-Rur-Light.ttf";
    public static final String RUBLE_DEFAULT_NORMAL_BOLD_FONT_FILENAME = "fonts/Roboto/Roboto-Rur-Regular.ttf";

    public static final Typeface RUBLE_TYPEFACE = Typeface.createFromAsset(BaseApp.context().getAssets(), RUBLE_DEFAULT_NORMAL_NORMAL_FONT_FILENAME);
    public static final Typeface RUBLE_BOLD_TYPEFACE = Typeface.createFromAsset(BaseApp.context().getAssets(), RUBLE_DEFAULT_NORMAL_BOLD_FONT_FILENAME);

    public static final String RUBLE_SIGN_PLACEHOLDER = "P";
    public static final String PERCENT_FONT_FILENAME = "fonts/fregat.ttf";

    public static final String POCHTA_DIGHTS_REGULAR = "fonts/PochtaDights-Regular.ttf";
    public static final Typeface POCHTA_DIGHTS_REGULAR_TYPEFACE = Typeface.createFromAsset(BaseApp.context().getAssets(), POCHTA_DIGHTS_REGULAR);


    public static CharSequence getSymbols(String symbol) {
        CharSequence currencyString = "";
        if (!TextUtils.isEmpty(symbol)) {
            Spannable rubSign = new SpannableString(symbol);
            rubSign.setSpan(new CustomTypefaceSpan("", SYMBOLS_TYPEFACE), 0, rubSign.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            currencyString = rubSign;
        }

        return currencyString;
    }
}
