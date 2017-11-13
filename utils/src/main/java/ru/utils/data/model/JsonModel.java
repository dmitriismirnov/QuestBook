package ru.utils.data.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import ru.utils.LogUtils;
import ru.utils.data.GsonUtils;

public abstract class JsonModel extends ru.utils.data.model.ParcelableObject
{
// -- construction

    protected static <T extends JsonModel> T factory(Class<T> clazz, String jsonStr, boolean validate)
    {
        JsonObject jsonObj = null;
        try {
            jsonObj = ru.utils.data.JsonUtils.toJsonObject(jsonStr);
        }
        catch (JsonSyntaxException e) {
            LogUtils.w(TAG, e);
        }

        // done
        return factory(clazz, jsonObj, validate);
    }

    protected static <T extends JsonModel> T factory(Class<T> clazz, JsonObject jsonObj, boolean validate)
    {
        if (jsonObj == null)
            return null;

        boolean isValid = false;
        if (validate)
        {
            try {
                JsonElement schema = getJsonSchema((String)clazz.getMethod("getJsonSchemaPath").invoke(null));
                if (schema != null && schema.isJsonObject())
                {
                    ru.utils.data.validator.JsonValidator.validate((JsonObject) schema, jsonObj);
                    isValid = true;
                }
            }
            catch (NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | ru.utils.data.validator.JsonValidationException e) {
                LogUtils.w(TAG, e);
            }

            if ( ! isValid) {
                jsonObj = null;
            }
        }

        T object = null;
        try {
            // create POJO from JSON object
            object = GsonUtils.fromJson(jsonObj, clazz);
        }
        catch (JsonSyntaxException e) {
            LogUtils.w(TAG, e);
        }

        // done
        return object;
    }

    static {
        final String pkgName = JsonModel.class.getPackage().getName();
        PKGBASE = '/' + pkgName.replace(".", "/") + "/model";
    }

    protected JsonModel() {
        // do nothing ..
    }

// -- functions

    protected static String getJsonSchemaPath() {
        throw new RuntimeException();
    }

    protected static JsonElement getJsonSchema(final String path)
    {
        try {
            if (mJsonSchema == null) {
                mJsonSchema = JsonModel.loadResource(path);
            }
        }
        catch (IOException e) {
            LogUtils.w(TAG, e);
        }

        // done
        return mJsonSchema;
    }

    public static boolean isValid(JsonModel object) {
        return (object != null) && object.validate();
    }

    public static boolean isValid(JsonModel... objects) {
        boolean result = true;

        for (int idx = 0, count = objects.length; result && (idx < count); ++idx) {
            result = JsonModel.isValid(objects[idx]);
        }

        return result;
    }

    public static boolean isValidOrNull(JsonModel object) {
        return (object == null) || object.validate();
    }

    public static boolean isValidOrNull(JsonModel... objects) {
        boolean result = true;

        for (int idx = 0, count = objects.length; result && (idx < count); ++idx) {
            result = JsonModel.isValidOrNull(objects[idx]);
        }

        return result;
    }

    public static boolean isNonNull(Object object) {
        return (object != null);
    }

    public static boolean isNonNull(Object... objects) {
        boolean result = true;

        for (int idx = 0, count = objects.length; result && (idx < count); ++idx) {
            result = JsonModel.isNonNull(objects[idx]);
        }

        return result;
    }

    public abstract boolean validate();

// -- private functions

    /**
     * Load one resource from the current package as a {@link JsonObject}
     *
     * @param   path  Name of the resource (<b>MUST</b> start with {@code /}
     * @return  JSON document
     * @throws  IOException resource not found
     */
    private static JsonElement loadResource(final String path)
            throws IOException
    {
        return JsonModel.fromResource(PKGBASE + path);
    }

    /**
     * Read a {@link JsonElement} from a resource path.
     *
     * <p>This method explicitly throws an {@link IOException} if the resource
     * does not exist, instead of letting a {@link NullPointerException} slip
     * through.</p>
     *
     * @param   resource  The path to the resource
     * @return  The JSON document at the resource
     * @throws  IOException if the resource does not exist or there was a problem
     *          loading it, or if the JSON document is invalid
     */
    private static JsonElement fromResource(final String resource)
            throws IOException
    {
        final InputStream is = JsonModel.class.getResourceAsStream(resource);

        if (is == null)
            throw new IOException("Resource " + resource + " not found.");

        // build JsonElement from JSON String
        JsonElement jsonElm = null;
        try {
            jsonElm = ru.utils.data.JsonUtils.toJsonElement(ru.utils.data.StreamUtils.convertStreamToString(is));
        }
        finally {
            if (is != null) {
                is.close();
            }
        }

        // done
        return jsonElm;
    }

// -- constants

    private static final String TAG = JsonModel.class.getSimpleName();

// -- variables

    private static final String PKGBASE;

    private static transient JsonElement mJsonSchema;

}
