package ru.utils.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/**
 * a
 * Created by deler on 10.08.16.
 */
public class ParcelUtils {
    public static boolean writeBooleanToParcel(Parcel parcel, boolean value) {
        parcel.writeInt(value ? 1 : 0);
        return value;
    }

    public static boolean writeBooleanToParcel(Parcel parcel, Object object) {
        return writeBooleanToParcel(parcel, object != null);
    }

    public static boolean readBooleanFromParcel(Parcel parcel) {
        // How to read/write a boolean when implementing the Parcelable interface?
        // @link http://stackoverflow.com/a/7089687

        return (parcel.readInt() != 0);
    }

    public static void writeStringMapToParcel(Parcel out, Map<String, String> map){
        out.writeInt(map.size());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());

            final String item = entry.getValue();
            out.writeString(item);
        }
    }

    public static Map<String, String> readStringHashMapFromParcel(Parcel in){
        final int size = in.readInt();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            final String key = in.readString();
            final String value = in.readString();
            map.put(key, value);
        }

        return map;
    }

    public static void writeMapToParcel(Parcel out, int flags, Map<String, ? extends Parcelable> map){
        out.writeInt(map.size());

        for (Map.Entry<String, ? extends Parcelable> entry : map.entrySet()) {
            out.writeString(entry.getKey());

            final Parcelable item = entry.getValue();
            out.writeParcelable(item, flags);
        }
    }

    public static <T extends Parcelable> Map<String, T> readHashMapFromParcel(Parcel in, ClassLoader valueLoader) {
        final int size = in.readInt();

        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            final String key = in.readString();
            final T value = in.readParcelable(valueLoader);
            map.put(key, value);
        }

        return map;
    }

    public static void writeJsonObject(Parcel dest, JsonObject jsonObject) {
        String string = jsonObject.toString();
        dest.writeString(string);
    }

    public static JsonObject readJsonObject(Parcel in) {
        String string = in.readString();
        return new Gson().fromJson(string, JsonObject.class);
    }
}
