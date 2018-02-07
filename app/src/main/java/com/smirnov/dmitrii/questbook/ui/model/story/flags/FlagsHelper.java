package com.smirnov.dmitrii.questbook.ui.model.story.flags;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author Dmitry Smirnov
 * @version 07.02.2018.
 */

final class FlagsHelper {

    private final static String TAG = FlagsHelper.class.getSimpleName();

    static boolean canPassTheFlag(@NonNull List<String> userItems, @NonNull List<String> flags, @NonNull FlagType type) {
        switch (type) {
            case USER_HAS:
                return canPassUserHasFlag(userItems, flags);
            case USER_HAS_AT_LEAST:
                return canPassUserHasAtLeastFlag(userItems, flags);
            case USER_HAS_NOT:
                return canPassUserHasNotFlag(userItems, flags);
            case ADD_FLAG:
                return canPassAddItemFlag(userItems, flags);
            case REMOVE_FLAG:
                return canPassRemoveItemFlag(userItems, flags);
        }
        return false;
    }

    static void passTheFlag(List<String> userItems, List<String> flags, FlagType type) {
        switch (type) {
            case USER_HAS:
                passUserHasFlag(userItems, flags);
            case USER_HAS_AT_LEAST:
                passUserHasAtLeastFlag(userItems, flags);
            case USER_HAS_NOT:
                passUserHasNotFlag(userItems, flags);
            case ADD_FLAG:
                passAddItemFlag(userItems, flags);
            case REMOVE_FLAG:
                passRemoveItemFlag(userItems, flags);
        }
    }


    /*****************************
     ******* ADD_FLAG ************
     *****************************/

    private static boolean canPassAddItemFlag(List<String> userItems, List<String> flags) {
        return true;
    }

    private static void passAddItemFlag(List<String> userItems, List<String> flags) {
        userItems.addAll(flags);
    }


    /*****************************
     ******* USER_HAS ************
     *****************************/

    private static boolean canPassUserHasFlag(List<String> userItems, List<String> flags) {
        for (String flag : flags) {
            if (!userItems.contains(flag)) {
                return false;
            }
        }
        return true;
    }

    private static void passUserHasFlag(List<String> userItems, List<String> flags) {
        //do nothing
    }


    /*****************************
     ******* USER_HAS_AT_LEAST ************
     *****************************/


    private static boolean canPassUserHasAtLeastFlag(List<String> userItems, List<String> flags) {
        for (String flag : flags) {
            if (userItems.contains(flag)) {
                return true;
            }
        }
        return false;
    }

    private static void passUserHasAtLeastFlag(List<String> userItems, List<String> flags) {
        //do nothing
    }


    /*****************************
     ******* USER_HAS_NOT ************
     *****************************/


    private static boolean canPassUserHasNotFlag(List<String> userItems, List<String> flags) {
        for (String flag : flags) {
            if (userItems.contains(flag)) {
                return false;
            }
        }
        return true;
    }


    private static void passUserHasNotFlag(List<String> userItems, List<String> flags) {
        //do nothing
    }


    /*****************************
     ******* REMOVE_FLAG ************
     *****************************/


    private static boolean canPassRemoveItemFlag(List<String> userItems, List<String> flags) {
        return canPassUserHasFlag(userItems, flags);
    }


    private static void passRemoveItemFlag(List<String> userItems, List<String> flags) {
        userItems.removeAll(flags);
    }
}
