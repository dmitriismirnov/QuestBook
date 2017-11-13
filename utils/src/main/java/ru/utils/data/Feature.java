package ru.utils.data;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey Bobrov on 22.09.2016.
 */
public enum Feature {
    kUndefined(""),
    kImages(ru.pochtabank.utils.data.JsonKeys.JSON_FEATURE_IMAGES),
    kSearch(ru.pochtabank.utils.data.JsonKeys.JSON_FEATURE_SEARCH);

    private static Map<String, Feature> mValuesMap;
    private String mKey;

    /**
     * Returns corresponding enum key value for JSON field value
     *
     * @param value JSON field value
     * @return enum key or {@code null} if there's no matching key
     */
    public static Feature fromString(String value) {
        // cache values
        if (mValuesMap == null) {
            mValuesMap = new HashMap<>();
            for (Feature state : Feature.values()) {
                mValuesMap.put(state.mKey.toLowerCase(), state);
            }
        }

        // done
        Feature feature = TextUtils.isEmpty(value) ? kUndefined : mValuesMap.get(value.toLowerCase());
        return feature == null ? kUndefined : feature;
    }

    Feature(String key) {
        mKey = key;
    }

    @Override
    public String toString() {
        return mKey;
    }

    // -- variables
}
