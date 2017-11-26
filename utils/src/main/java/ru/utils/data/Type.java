package ru.utils.data;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey Bobrov on 23.09.2016.
 */
public enum Type {
    kUndefined(""),
    kItem(JsonKeys.JSON_MENU_TYPE_ITEM),
    kFolder(JsonKeys.JSON_MENU_TYPE_FOLDER);

    /**
     * Returns corresponding enum key value for JSON field value
     *
     * @param value JSON field value
     * @return enum key or {@code null} if there's no matching key
     */
    public static Type fromString(String value) {
        // cache values
        if (mValuesMap == null) {
            mValuesMap = new HashMap<>();
            for (Type state : Type.values()) {
                mValuesMap.put(state.mKey.toLowerCase(), state);
            }
        }

        // done
        Type eventType = TextUtils.isEmpty(value) ? kUndefined : mValuesMap.get(value.toLowerCase());
        return eventType == null ? kUndefined : eventType;
    }

    Type(String key) {
        mKey = key;
    }

    // -- functions

    @Override
    public String toString() {
        return mKey;
    }

    // -- variables

    private String mKey;
    private static Map<String, Type> mValuesMap;
}
