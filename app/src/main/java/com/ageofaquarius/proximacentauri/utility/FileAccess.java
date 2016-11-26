package com.ageofaquarius.proximacentauri.utility;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by Mars on 2016-11-05.
 */

public class FileAccess {
    private static final String LOG_TAG = "FileAccess";
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public File getUnitSettingFile() {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "unit_setting.pc");
        if (!file.exists()) {
            Log.e(LOG_TAG, "Unit setting file cannot be read.");
        }
        return file;
    }
}
