package ru.utils.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * a
 * Created by deler on 18.08.16.
 */
final public class StreamUtils {
    public static String convertStreamToString(InputStream istream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\r\n");
        }

        return sb.toString();
    }
}
