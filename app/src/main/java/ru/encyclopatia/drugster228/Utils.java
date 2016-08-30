package ru.encyclopatia.drugster228;

import android.util.Log;

public final class Utils {
    private final static String LOG_TAG = "Drugster";

    private Utils() {
    }

    public static void Log(String message) {
        Log.d(LOG_TAG, message);
    }
}
