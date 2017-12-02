package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;

import com.smirnov.dmitrii.questbook.R;

/**
 * Created by Дмитрий on 19.11.2017.
 */

public class StoryImageItem extends StoryItem {

    private Images mImage = Images.NO_IMAGE;

    public StoryImageItem(Images image) {
        super(StoryItemType.IMAGE);
        this.mImage = image;
    }


    @DrawableRes
    public int getImageResourse() {
       return mImage.getImageId();
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
