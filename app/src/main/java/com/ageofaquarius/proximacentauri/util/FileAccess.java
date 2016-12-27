package com.ageofaquarius.proximacentauri.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import com.ageofaquarius.proximacentauri.ServiceLocator;
import com.ageofaquarius.proximacentauri.infra.DefinitionSchemaException;
import com.ageofaquarius.proximacentauri.infra.DefinitionSchemas;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

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

    public static ArrayList<String[]> readTextFileAsArray(Context context, int key) {
        ArrayList<String> fileContents = readTextFileFromResource(context, key);
        ArrayList<String[]> results = new ArrayList<>();
        for (int i = 0; i < fileContents.size(); i++) {
            results.add(fileContents.get(i).split(","));
        }
        return results;
    }

    public static ArrayList<String> readTextFileFromResource(Context context, int resourceId) {
        ArrayList<String> results = new ArrayList<>();
        try {
            InputStream inputStream =
                    context.getResources().openRawResource(resourceId);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                results.add(nextLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not open resource: " + resourceId, e);
        } catch (Resources.NotFoundException nfe) {
            throw new RuntimeException("Resource not found: " + resourceId, nfe);
        }
        return results;
    }
}
