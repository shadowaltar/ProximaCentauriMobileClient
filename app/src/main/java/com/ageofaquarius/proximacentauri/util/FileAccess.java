package com.ageofaquarius.proximacentauri.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import com.ageofaquarius.proximacentauri.R;
import com.ageofaquarius.proximacentauri.ServiceLocator;
import com.ageofaquarius.proximacentauri.infra.DefinitionSchemaException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
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

    public static <T> ArrayList<T> construct(Class definitionClass,
                                             String[][] data,
                                             String[][] colDefinitions) {
        ArrayList<T> results = new ArrayList<T>();
        try {
            if (colDefinitions.length != 2 || colDefinitions[0].length < 1
                    || !colDefinitions[0][0].equals("NAME") || !colDefinitions[1][0].equals("STRING"))
                // must be two sets of strings: 1st is col name, 2nd is col type.
                // 1st column must be NAME (STRING).
                throw new DefinitionSchemaException();

            int colCount = colDefinitions[0].length;
            for (String[] row : data) {
                Object result;
                for (int i = 1; i < colCount; i++) {
                    result = definitionClass.newInstance();

                    String value = row[i];
                    String key = colDefinitions[0][i];
                    String typeHint = colDefinitions[1][i];

                    Field field = definitionClass.getField(key);
                    switch (typeHint) {
                        case "STRING":
                            field.set(result, value);
                            break;
                        case "INTEGER":
                            field.setInt(result, Integer.parseInt(value));
                            break;
                        case "DOUBLE":
                            field.setDouble(result, Double.parseDouble(value));
                            break;
                        case "BOOLEAN":
                            field.setBoolean(result, Boolean.parseBoolean(value));
                            break;
                        case "INTEGERS":
                            String[] intStrings = value.split(",");
                            int[] intResults = new int[intStrings.length];
                            for (int j = 0; j < intStrings.length; j++)
                                intResults[j] = Integer.parseInt(intStrings[j]);
                            field.set(result, intResults);
                            break;
                        case "DOUBLES":
                            String[] doubleStrings = value.split(",");
                            int[] doubleResults = new int[doubleStrings.length];
                            for (int j = 0; j < doubleStrings.length; j++)
                                doubleResults[j] = Integer.parseInt(doubleStrings[j]);
                            field.set(result, doubleResults);
                            break;
                        case "STRINGS":
                            String[] strings = value.split(",");
                            field.set(result, strings);
                            break;
                        default:
                            field.set(result, value);
                            break;
                    }
                    results.add((T) result);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (DefinitionSchemaException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static String[][] readRawDefinitions(Class definitionClass) {
        Context context = ServiceLocator.getAppContext();
        ArrayList<String> fileContents = readTextFileFromResource(context, R.raw.def_resources);
        String[][] results = new String[fileContents.size()][];
        for (int i = 0; i < fileContents.size(); i++){
            results[i] = fileContents.get(i).split(",");
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
