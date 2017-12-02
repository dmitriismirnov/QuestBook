package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.DrawableRes;

import com.smirnov.dmitrii.questbook.R;

/**
 * @author Дмитрий
 * @version 02.12.2017.
 */

public enum Images {

    NO_IMAGE(R.drawable.no_image_available),
    DEBUG_1(R.drawable.debug_image_1),
    DEBUG_2(R.drawable.debug_image_2),
    DEBUG_3(R.drawable.debug_image_3);

    @DrawableRes
    private int imageId;

    Images(int imageId) {
        this.imageId = imageId;
    }

    public static Images fromOrdinal(int ordinal) {
        switch (ordinal) {
            case 1:
                return DEBUG_1;
            case 2:
                return DEBUG_2;
            case 3:
                return DEBUG_3;
            default:
                return NO_IMAGE;
        }
    }

    @DrawableRes
    public int getImageId() {
        return imageId;
    }
}
