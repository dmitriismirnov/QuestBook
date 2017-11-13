package ru.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;

/**
 * NetworkUtils
 *
 * @author Vyacheslav Shmakin
 * @version 22.09.2017
 */

public class NetworkUtils {

    public static boolean isConnected(@NonNull Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //noinspection deprecation
            NetworkInfo[] allNetworks = manager.getAllNetworkInfo();
            for (NetworkInfo networkInfo : allNetworks) {
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        } else {
            Network[] networks = manager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network network : networks) {
                networkInfo = manager.getNetworkInfo(network);
                if (networkInfo.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }
}
