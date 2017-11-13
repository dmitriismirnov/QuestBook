package ru.utils.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.pochtabank.utils.LogUtils;

// FIXME: code refactoring is needed
public class JsonPath
{
// -- construction

    private JsonPath() {
        // do nothing ..
    }

// -- functions

    // -- safe functions with defaults

    // TODO refactor

    public static void removeByPath(JsonObject root, String path)
    {
        List<String> splitPath = splitPath(path);
        if( ! splitPath.isEmpty())
        {
            String fieldName = splitPath.remove(splitPath.size() - 1);
            makePath(root, splitPath);
            JsonElement parentElement = getJsonElement(root, splitPath, null);
            if (parentElement != null && parentElement.isJsonObject())
            {
                JsonObject parentObject = parentElement.getAsJsonObject();
                parentObject.remove(fieldName);
            }
            else {
                LogUtils.d(TAG, "Element {" + parentElement + "} at " + path + " is not JsonObject and cannot be parent");
            }
        }
        else {
            LogUtils.d(TAG, "Path " + path + " is empty");
        }
    }

    public static void setByPath(JsonObject root, String path, JsonElement value)
    {
        List<String> splitPath = splitPath(path);
        if( ! splitPath.isEmpty())
        {
            String fieldName = splitPath.remove(splitPath.size() - 1);
            makePath(root, splitPath);
            JsonElement parentElement = getJsonElement(root, splitPath, null);
            if (parentElement != null && parentElement.isJsonObject())
            {
                JsonObject parentObject = parentElement.getAsJsonObject();
                JsonElement jsonElement = parentObject.get(fieldName);
                if (value != null&&value.isJsonObject() && !value.getAsJsonObject().has(JsonKeys.JSON_SCHEMA)) {
                    if (jsonElement != null && jsonElement.isJsonObject() && jsonElement.getAsJsonObject().has(JsonKeys.JSON_SCHEMA)) {
                        JsonElement schema = jsonElement.getAsJsonObject().get(JsonKeys.JSON_SCHEMA);
                        value.getAsJsonObject().add(JsonKeys.JSON_SCHEMA, schema);
                    }
                }
                parentObject.add(fieldName, value);
            }
            else {
                LogUtils.d(TAG, "Element {" + parentElement + "} at " + path + " is not JsonObject and cannot be parent");
            }
        }
        else {
            LogUtils.d(TAG, "Path " + path + " is empty");
        }
    }

    private static void makePath(JsonObject obj, List<String> path)
    {
        JsonObject parentObj = obj;
        for (String item : path)
        {
            JsonElement itemAtPath = parentObj.get(item);
            if (itemAtPath == null)
            {
                JsonObject childObj = new JsonObject();
                parentObj.add(item, childObj);
                parentObj = childObj;
            }
            else
            {
                if (itemAtPath.isJsonObject()) {
                    parentObj = itemAtPath.getAsJsonObject();
                }
                else
                {
                    LogUtils.d(TAG, "Element {" + itemAtPath + "} at " + item + " is not JsonObject and cannot be parent");
                    break;
                }
            }
        }
    }

    public static String getString(JsonObject root, String path, String defaultValue) {
        return getString(root, splitPath(path), defaultValue);
    }

    public static String getString(JsonObject root, List<String> keys, String defaultValue)
    {
        JsonElement possibleResult = getElementsForPath(root, keys, Collections.singletonList(new JsonPrimitive(defaultValue))).get(0);
        return possibleResult.isJsonPrimitive() ? possibleResult.getAsString() : defaultValue;
    }

    public static boolean getBoolean(JsonObject root, String path, boolean defaultValue) {
        return getBoolean(root, splitPath(path), defaultValue);
    }

    public static boolean getBoolean(JsonObject root, List<String> keys, boolean defaultValue)
    {
        JsonElement possibleResult = getElementsForPath(root, keys, Collections.singletonList(new JsonPrimitive(defaultValue))).get(0);

        try {
            return possibleResult.getAsBoolean();
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    public static int getInt(JsonObject root, String path, int defaultValue) {
        return getInt(root, splitPath(path), defaultValue);
    }

    public static int getInt(JsonObject root, List<String> keys, int defaultValue)
    {
        JsonElement possibleResult = getElementsForPath(root, keys, Collections.singletonList(new JsonPrimitive(defaultValue))).get(0);
        return possibleResult.isJsonPrimitive() ?
                ru.pochtabank.utils.data.ParseUtils.parseInt(possibleResult.getAsString(), defaultValue) : defaultValue;
    }

    public static float getFloat(JsonObject root, String path, float defaultValue) {
        return getFloat(root, splitPath(path), defaultValue);
    }

    public static float getFloat(JsonObject root, List<String> keys, float defaultValue)
    {
        JsonElement possibleResult = getElementsForPath(root, keys, Collections.singletonList(new JsonPrimitive(defaultValue))).get(0);
        return possibleResult.isJsonPrimitive() ?
                ru.pochtabank.utils.data.ParseUtils.parseFloat(possibleResult.getAsString(), defaultValue) : defaultValue;
    }

    public static JsonElement getJsonElement(JsonObject root, String path, JsonElement defaultValue)
    {
        return getJsonElement(root, splitPath(path), defaultValue);
    }

    public static JsonElement getJsonElement(JsonObject root, List<String> keys, JsonElement defaultValue)
    {
        return getElementsForPath(root, keys, Collections.singletonList(defaultValue)).get(0);
    }

    public static JsonArray getJsonArray(JsonObject root, List<String> keys, JsonArray defaultValue)
    {
        JsonElement possibleResult = getJsonElement(root, keys, defaultValue);
        return possibleResult.isJsonArray() ? possibleResult.getAsJsonArray() : defaultValue;
    }

    public static JsonObject getJsonObject(JsonObject root, String path, JsonObject defaultValue) {
        return getJsonObject(root, splitPath(path), defaultValue);
    }

    public static JsonObject getJsonObject(JsonObject root, List<String> keys, JsonObject defaultValue)
    {
        JsonElement possibleResult = getJsonElement(root, keys, defaultValue);
        return possibleResult != null && possibleResult.isJsonObject() ? possibleResult.getAsJsonObject() : defaultValue;
    }

    public static List<JsonObject> getJsonObjectList(JsonObject root, String path, @NonNull List<JsonObject> defaultValues)
    {
        return getJsonObjectList(root, splitPath(path), defaultValues);
    }

    public static List<JsonObject> getJsonObjectList(JsonObject root, List<String> keys, @NonNull List<JsonObject> defaultValues)
    {
        List<? extends JsonElement> possibleResults = getElementsForPath(root, keys, defaultValues);
        List<JsonObject> resultList = new ArrayList<>(possibleResults.size());

        for (JsonElement possibleResult : possibleResults) {
            if (possibleResult.isJsonObject()) {
                resultList.add(possibleResult.getAsJsonObject());
            }
        }
        return resultList;
    }

    // -- functions with exceptions

    public static String getString(JsonObject root, String path) throws InvalidPathException {
        return getString(root, splitPath(path));
    }

    public static String getString(JsonObject root, List<String> keys) throws InvalidPathException
    {
        JsonElement possibleResult = getElementsForPath(root, keys).get(0);
        if (possibleResult.isJsonPrimitive()) {
            return possibleResult.getAsString();
        }
        else {
            throw new InvalidPathException("Failed to resolve path {" + TextUtils.join(",", keys) +
                    "}: expected primitive, but <" + possibleResult.toString() + "> was found");
        }
    }

    public static int getInt(JsonObject root, String path) throws InvalidPathException {
        return getInt(root, splitPath(path));
    }

    public static int getInt(JsonObject root, List<String> keys) throws InvalidPathException
    {
        JsonElement possibleResult = getElementsForPath(root, keys).get(0);
        if (possibleResult.isJsonPrimitive() && ru.pochtabank.utils.data.ParseUtils.tryParseInt(possibleResult.getAsString())) {
            return possibleResult.getAsInt();
        }
        else {
            throw new InvalidPathException("Failed to resolve path {" + TextUtils.join(",", keys) +
                    "}: expected integer, but <" + possibleResult.toString() + "> was found");
        }
    }

    public static float getFloat(JsonObject root, String path) throws InvalidPathException {
        return getFloat(root, splitPath(path));
    }

    public static float getFloat(JsonObject root, List<String> keys) throws InvalidPathException
    {
        JsonElement possibleResult = getElementsForPath(root, keys).get(0);
        if (possibleResult.isJsonPrimitive() && ru.pochtabank.utils.data.ParseUtils.tryParseFloat(possibleResult.getAsString())) {
            return possibleResult.getAsFloat();
        }
        else {
            throw new InvalidPathException("Failed to resolve path {" + TextUtils.join(",", keys) +
                    "}: expected float, but <" + possibleResult.toString() + "> was found");
        }
    }
    public static JsonElement getJsonElement(JsonObject root, String path) throws InvalidPathException {
        return getJsonElement(root, splitPath(path));
    }

    public static JsonElement getJsonElement(JsonObject root, List<String> keys) throws InvalidPathException {
        return getElementsForPath(root, keys).get(0);
    }

    public static JsonArray getJsonArray(JsonObject root, String path) throws InvalidPathException {
        return getJsonArray(root, splitPath(path));
    }

    public static JsonArray getJsonArray(JsonObject root, List<String> keys) throws InvalidPathException
    {
        JsonElement possibleResult = getJsonElement(root, keys);
        if (possibleResult.isJsonArray()) {
            return possibleResult.getAsJsonArray();
        }
        else {
            throw new InvalidPathException("Failed to resolve path {" + TextUtils.join(",", keys) +
                    "}: expected json array, but <" + possibleResult.toString() + "> was found");
        }
    }

    public static JsonObject getJsonObject(JsonObject root, String path) throws InvalidPathException {
        return getJsonObject(root, splitPath(path));
    }

    public static JsonObject getJsonObject(JsonObject root, List<String> keys) throws InvalidPathException
    {
        JsonElement possibleResult = getJsonElement(root, keys);
        if (possibleResult.isJsonObject()) {
            return possibleResult.getAsJsonObject();
        }
        else {
            throw new InvalidPathException("Failed to resolve path {" + TextUtils.join(",", keys) +
                    "}: expected json object, but <" + possibleResult.toString() + "> was found");
        }
    }

    public static List<JsonObject> getJsonObjectList(JsonObject root, String path) throws InvalidPathException {
        return getJsonObjectList(root, splitPath(path));
    }

    public static List<JsonObject> getJsonObjectList(JsonObject root, List<String> keys) throws InvalidPathException
    {
        List<? extends JsonElement> possibleResults = getElementsForPath(root, keys);
        List<JsonObject> resultList = new ArrayList<>(possibleResults.size());

        for (JsonElement possibleResult : possibleResults) {
            if (possibleResult.isJsonObject()) {
                resultList.add(possibleResult.getAsJsonObject());
            }
        }
        return resultList;
    }

// -- internals

    private static List<String> splitPath(String path)
    {
        String[] parts = path.split("\\" + DELIMITER);
        return new ArrayList<>(Arrays.asList(parts));
    }

    private static List<? extends JsonElement> getElementsForPath(JsonObject root, List<String> keys, @NonNull List<? extends JsonElement> defaultValues)
    {
        List<String> disposableKeys = new LinkedList<>(keys);

        try {
            return find(root, disposableKeys);
        } catch (InvalidPathException e) {
            return defaultValues;
        }
    }

    private static List<? extends JsonElement> getElementsForPath(JsonObject root, List<String> keys) throws InvalidPathException
    {
        List<String> disposableKeys = new LinkedList<>(keys);
        return find(root, disposableKeys);
    }

    private static List<JsonElement> find(JsonElement rootElement, List<String> keys) throws InvalidPathException
    {
        if (keys.isEmpty()) {
            return Collections.singletonList(rootElement);
        }

        String key = keys.get(0);
        keys.remove(0);

        if (rootElement.isJsonArray())
        {
            JsonArray rootArr = rootElement.getAsJsonArray();

            if (key.equals(WILDCARD))
            {
                List<JsonElement> result = new LinkedList<>();

                for (int idx = 0; idx < rootArr.size(); ++idx) {
                    result.addAll(find(rootArr.get(idx), keys));
                }
                return result;
            }
            else
            {
                if (ru.pochtabank.utils.data.ParseUtils.tryParseInt(key))
                {
                    int keyAsInt = Integer.valueOf(key);
                    if (keyAsInt >= 0 && keyAsInt < rootArr.size()) {
                        return find(rootArr.get(keyAsInt), keys);
                    }
                }
            }

            // if we're here - then something went wrong with array processing
            throw new InvalidPathException("Failed to resolve key " + key);
        }
        else
        {
            if (rootElement.isJsonObject())
            {
                JsonObject rootObj = rootElement.getAsJsonObject();

                if (key.equals(WILDCARD))
                {
                    List<JsonElement> result = new LinkedList<>();

                    for (Map.Entry<String, JsonElement> jsonElementEntry : rootObj.entrySet()) {
                        result.addAll(find(jsonElementEntry.getValue(), keys));
                    }

                    return result;
                }
                else
                {
                    JsonElement elementForKeyPart = rootElement.getAsJsonObject().get(key);

                    if (elementForKeyPart == null) {
                        throw new InvalidPathException("Failed to resolve key " + key);
                    }
                    else {
                        return find(elementForKeyPart, keys);
                    }
                }
            }
            else {
                throw new InvalidPathException("Failed to resolve key " + key);
            }
        }
    }

// -- constants

    private static final String TAG = JsonPath.class.getSimpleName();
    public static final String DELIMITER = ".";
    public static final String WILDCARD  = "*";

}
