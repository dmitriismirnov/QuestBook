package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;

import com.smirnov.dmitrii.questbook.R;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryImageItem extends StoryItem {

    @ImageType
    private int mImageType = ImageType.NO_IMAGE;

    public StoryImageItem(@ImageType int imageType) {
        super(StoryItemType.IMAGE);
        this.mImageType = imageType;
    }


    @DrawableRes
    public int getImageResourse() {
        switch (mImageType) {
            case ImageType.DEBUG_1:
                return getDebugImage1();
            case ImageType.DEBUG_2:
                return getDebugImage2();
            case ImageType.DEBUG_3:
                return getDebugImage3();
            default:
            case ImageType.NO_IMAGE:
                return getNoImageAvailable();
        }
    }



    @DrawableRes
    private int getNoImageAvailable(){
        return R.drawable.no_image_available;
    }

    @DrawableRes
    private int getDebugImage1() {
        return R.drawable.debug_image_1;
    }

    @DrawableRes
    private int getDebugImage2() {
        return R.drawable.debug_image_2;
    }

    @DrawableRes
    private int getDebugImage3() {
        return R.drawable.debug_image_3;
    }


    @LayoutRes
    @Override
    int getLayoutId() {
        return R.layout.item_story_image;
    }
}
