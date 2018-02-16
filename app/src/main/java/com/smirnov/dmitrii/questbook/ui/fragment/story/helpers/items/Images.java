package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.smirnov.dmitrii.questbook.R;

import ru.utils.LogUtils;

/**
 * @author Дмитрий
 * @version 02.12.2017.
 */

public enum Images {

    @SerializedName("no_image")
    NO_IMAGE(R.drawable.no_image_available, "no_image"),
    @SerializedName("conan_outside_1")
    CONAN_OUTSIDE_1(R.drawable.conan_outside_1, "conan_outside_1"),
    @SerializedName("conan_win_1")
    CONAN_WIN_1(R.drawable.conan_win_1, "conan_win_1"),
    @SerializedName("conan_win_2")
    CONAN_WIN_2(R.drawable.conan_win_2, "conan_win_2"),
    @SerializedName("debug_image_1")
    DEBUG_1(R.drawable.debug_image_1, "debug_image_1"),
    @SerializedName("debug_image_2")
    DEBUG_2(R.drawable.debug_image_2, "debug_image_2"),
    @SerializedName("debug_image_3")
    DEBUG_3(R.drawable.debug_image_3, "debug_image_3");

    private final static String TAG = Images.class.getSimpleName();

    @DrawableRes
    private int imageId;
    private String imageName;

    Images(@DrawableRes int imageId, @NonNull String imageName) {
        this.imageId = imageId;
        this.imageName = imageName;
    }

    public static Images fromOrdinal(int ordinal) {
        Images images[] = Images.values();
        if (ordinal < images.length && ordinal > 0) {
            return images[ordinal];
        } else {
            return NO_IMAGE;
        }
    }

    public static Images fromString(String imageString) {
        for (Images image : Images.values()) {
            if (image.imageName.equalsIgnoreCase(imageString)) {
                return image;
            }
        }
        LogUtils.d(TAG, "not found image name: " + imageString);
        return NO_IMAGE;
    }

    @DrawableRes
    public int getImageId() {
        return imageId;
    }
}
