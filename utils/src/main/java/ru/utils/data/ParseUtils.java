package ru.utils.data;

public final class ParseUtils {
    private ParseUtils() {
    }

    public static int parseInt(String value, int defaultValue) {
        int result = defaultValue;

        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException var4) {
        }

        return result;
    }

    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }

    public static long parseLong(String value, long defaultValue) {
        long result = defaultValue;

        try {
            result = Long.parseLong(value);
        } catch (NumberFormatException var6) {
        }

        return result;
    }

    public static boolean tryParseLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }

    public static float parseFloat(String value, float defaultValue) {
        float result = defaultValue;

        try {
            result = Float.parseFloat(value);
        } catch (NumberFormatException var4) {
        }

        return result;
    }

    public static boolean tryParseFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }

    public static double parseDouble(String value, double defaultValue) {
        double result = defaultValue;

        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException var6) {
        }

        return result;
    }

    public static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }
}
