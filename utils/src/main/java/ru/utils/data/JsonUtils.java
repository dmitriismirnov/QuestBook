package ru.utils.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import ru.pochtabank.utils.LogUtils;

public final class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();
    private static final JsonParser PARSER = new JsonParser();

    private JsonUtils() {
    }

    public static JsonElement getJsonElement(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement value = null;
        if(jsonObj != null) {
            value = jsonObj.get(key);
        }

        if(value == null) {
            throw new NoSuchElementException("Key not found: " + key);
        } else {
            return value;
        }
    }

    public static JsonElement getJsonElement(JsonObject jsonObj, String key, JsonElement defaultVal) {
        JsonElement result = defaultVal;

        try {
            result = getJsonElement(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static JsonObject getJsonObject(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement value = getJsonElement(jsonObj, key);
        if(value != null && value.isJsonObject()) {
            return (JsonObject)value;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static JsonObject getJsonObject(JsonObject jsonObj, String key, JsonObject defaultObj) {
        JsonObject result = defaultObj;

        try {
            result = getJsonObject(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static JsonArray getJsonArray(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement value = getJsonElement(jsonObj, key);
        if(value != null && value.isJsonArray()) {
            return (JsonArray)value;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static JsonArray getJsonArray(JsonObject jsonObj, String key, JsonArray defaultArr) {
        JsonArray result = defaultArr;

        try {
            result = getJsonArray(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static String getString(JsonObject jsonObj, String key) throws NoSuchElementException {
        try {
            JsonElement elem = getJsonElement(jsonObj, key);
            String result = null;
            if(elem.isJsonPrimitive()) {
                result = elem.getAsString();
                return result;
            } else {
                throw new NoSuchElementException("Key not found: " + key);
            }
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public static String getString(JsonObject jsonObj, String key, String defaultVal) {
        String result = defaultVal;

        try {
            result = getString(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static int getInt(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        boolean result = false;
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            int result1;
            if(value.isNumber()) {
                result1 = elem.getAsInt();
            } else {
                if(!value.isString()) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                String string = elem.getAsString();
                if(!ru.pochtabank.utils.data.ParseUtils.tryParseInt(string)) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                result1 = Integer.parseInt(string);
            }

            return result1;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static int getInt(JsonObject jsonObj, String key, int defaultVal) {
        int result = defaultVal;

        try {
            result = getInt(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    /** Reads int from HEX string like #0123ff */
    public static int getIntHexColor(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            try {
                if (value.isString()) {
                    String stringValue = value.getAsString();
                    if (stringValue.startsWith("#")) {
                        stringValue = stringValue.substring(1);
                    }
                    if (stringValue.length() == 6) {
                        stringValue = "ff" + stringValue;
                    }
                    if (stringValue.length() != 8) {
                        throw new IllegalArgumentException("HEX string should be of 8 digits length.");
                    }
                    return Integer.parseInt(stringValue);
                }
            } catch (Exception e) {
                Log.e("JsonUtils", "Error parsing " + value.getAsString() + " as HEX color int", e);
                throw new NoSuchElementException("Can't parse value as HEX color integer. Key: " + key);
            }
        }

        throw new NoSuchElementException("Key not found: " + key);
    }

    /** Reads int from HEX string like #0123ff */
    public static int getIntHexColor(JsonObject jsonObj, String key, int defaultVal) {
        int result = defaultVal;

        try {
            result = getInt(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static long getLong(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        long result = 0L;
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            if(value.isNumber()) {
                result = elem.getAsLong();
            } else {
                if(!value.isString()) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                String string = elem.getAsString();
                if(!ru.pochtabank.utils.data.ParseUtils.tryParseLong(string)) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                result = Long.parseLong(string);
            }

            return result;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static long getLong(JsonObject jsonObj, String key, long defaultVal) {
        long result = defaultVal;

        try {
            result = getLong(jsonObj, key);
        } catch (NoSuchElementException var7) {
        }

        return result;
    }

    public static float getFloat(JsonObject jsonObj, String key, float defaultVal) {
        float result = defaultVal;

        try {
            result = getFloat(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static float getFloat(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        float result = 0.0F;
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            if(value.isNumber()) {
                result = elem.getAsFloat();
            } else {
                if(!value.isString()) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                String string = elem.getAsString();
                if(!ru.pochtabank.utils.data.ParseUtils.tryParseFloat(string)) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                result = Float.parseFloat(string);
            }

            return result;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static double getDouble(JsonObject jsonObj, String key, double defaultVal) {
        double result = defaultVal;

        try {
            result = getDouble(jsonObj, key);
        } catch (NoSuchElementException var7) {
        }

        return result;
    }

    public static double getDouble(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        double result = 0.0D;
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            if(value.isNumber()) {
                result = elem.getAsDouble();
            } else {
                if(!value.isString()) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                String string = elem.getAsString();
                if(!ru.pochtabank.utils.data.ParseUtils.tryParseDouble(string)) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                result = Double.parseDouble(string);
            }

            return result;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static boolean getBoolean(JsonObject jsonObj, String key) throws NoSuchElementException {
        JsonElement elem = getJsonElement(jsonObj, key);
        boolean result = false;
        if(elem.isJsonPrimitive()) {
            JsonPrimitive value = elem.getAsJsonPrimitive();
            if(value.isBoolean()) {
                result = elem.getAsBoolean();
            } else {
                if(!value.isString()) {
                    throw new NoSuchElementException("Key not found: " + key);
                }

                result = Boolean.parseBoolean(elem.getAsString());
            }

            return result;
        } else {
            throw new NoSuchElementException("Key not found: " + key);
        }
    }

    public static boolean getBoolean(JsonObject jsonObj, String key, boolean defaultVal) {
        boolean result = defaultVal;

        try {
            result = getBoolean(jsonObj, key);
        } catch (NoSuchElementException var5) {
        }

        return result;
    }

    public static JsonElement toJsonElement(String jsonStr) {
        JsonElement value = null;
        if(jsonStr != null) {
            value = PARSER.parse(jsonStr);
        }

        return value;
    }

    public static JsonElement toJsonElement(String jsonStr, JsonElement defaultObj) {
        JsonElement result = defaultObj;

        try {
            result = toJsonElement(jsonStr);
        } catch (NoSuchElementException var4) {
        }

        return result;
    }

    public static JsonObject toJsonObject(String jsonStr) {
        JsonElement jsonObj = toJsonElement(jsonStr);
        if(jsonObj != null && !jsonObj.isJsonObject()) {
            jsonObj = null;
        }

        return (JsonObject)jsonObj;
    }

    public static JsonObject toJsonObject(String jsonStr, JsonObject defaultObj) {
        JsonObject result = defaultObj;

        try {
            result = toJsonObject(jsonStr);
        } catch (NoSuchElementException var4) {
        }

        return result;
    }

    public static JsonArray toJsonArray(String jsonStr) {
        JsonElement jsonArr = toJsonElement(jsonStr);
        if(jsonArr != null && !jsonArr.isJsonArray()) {
            jsonArr = null;
        }

        return (JsonArray)jsonArr;
    }

    public static JsonArray toJsonArray(String jsonStr, JsonArray defaultArr) {
        JsonArray result = defaultArr;

        try {
            result = toJsonArray(jsonStr);
        } catch (NoSuchElementException var4) {
        }

        return result;
    }

    public static JsonObject clone(JsonObject jsonObj) {
        JsonObject copyObj = new JsonObject();

        try {
            Iterator e = jsonObj.entrySet().iterator();

            while(e.hasNext()) {
                Entry entry = (Entry)e.next();
                String key = (String)entry.getKey();
                copyObj.add(key, getJsonElement(jsonObj, key));
            }
        } catch (NoSuchElementException var5) {
            LogUtils.w(TAG, var5.getMessage());
            copyObj = null;
        }

        return copyObj;
    }

    @NonNull
    public static JSONObject putIfNonNull(@NonNull JSONObject object, @NonNull String key, @Nullable Object value) {
        if (value == null) {
            return object;
        }
        try {
            return object.put(key, value);
        } catch (JSONException e) {
            LogUtils.e(TAG, e);
        }
        return object;
    }
}
