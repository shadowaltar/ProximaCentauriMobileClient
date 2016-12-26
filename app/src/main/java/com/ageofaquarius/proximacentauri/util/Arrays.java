package com.ageofaquarius.proximacentauri.util;

import java.lang.reflect.Method;

/**
 * Created by Mars on 2016-11-20.
 */

public class Arrays {
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result;
        try {
            Method arraysCopyOf = Arrays.class.getMethod("copyOf", Object[].class, int.class);
            result = (T[]) arraysCopyOf.invoke(null, first, totalLength);
        } catch (Exception e){
            //Java 6 / Android >= 9 way didn't work, so use the "traditional" approach
            result = (T[]) java.lang.reflect.Array.newInstance(first.getClass().getComponentType(), totalLength);
            System.arraycopy(first, 0, result, 0, first.length);
        }
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
