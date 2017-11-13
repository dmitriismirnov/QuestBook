package ru.utils.data;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public final class GsonUtils {

    @SuppressWarnings("unused")
    private static final String TAG = GsonUtils.class.getSimpleName();
    private static final String DATE_FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static transient Gson sGson;

    public static Gson gson() {
        if (sGson == null) {
            Gson gson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .setDateFormat(DATE_FORMAT_ISO8601)
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            synchronized (GsonUtils.class) {
                sGson = gson;
            }
        }
        return sGson;
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) throws JsonSyntaxException {
        return GsonUtils.gson().fromJson(jsonStr, clazz);
    }

    public static <T> T fromJson(String jsonStr, Type type) throws JsonSyntaxException {
        return GsonUtils.gson().fromJson(jsonStr, type);
    }

    public static <T> T fromJson(JsonElement jsonElem, Class<T> clazz) throws JsonSyntaxException {
        return GsonUtils.gson().fromJson(jsonElem, clazz);
    }

    public static String toJson(Object object) {
        return GsonUtils.gson().toJson(object);
    }

    public static String toJson(JsonElement jsonElem) {
        return GsonUtils.gson().toJson(jsonElem);
    }

    public static JsonElement toJsonTree(Object src) {
        return GsonUtils.gson().toJsonTree(src);
    }

}
