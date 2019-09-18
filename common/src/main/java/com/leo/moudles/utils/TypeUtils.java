package com.leo.moudles.utils;

import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collection;
import java.util.Map;

public class TypeUtils {
    public static boolean isPrimitive(Class<?> clazz) {
        return isNumber(clazz)
                || isBoolean(clazz)
                || isChar(clazz)
                || isString(clazz)
                || isLocalTime(clazz)
                || isLocalDateTime(clazz)
                || isDate(clazz);
    }

    public static boolean isNotPrimitive(Class<?> clazz) {
        return !isPrimitive(clazz);
    }

    public static boolean isCollection(Class<?> clazz) {
        return isOrSubClass(clazz, Collection.class);
    }

    public static boolean isNotCollection(Class<?> clazz) {
        return !isCollection(clazz);
    }

    public static boolean isMap(Class<?> clazz) {
        return isOrSubClass(clazz, Map.class);
    }

    public static boolean isNotMap(Class<?> clazz) {
        return !isMap(clazz);
    }

    public static boolean isNumber(Class<?> clazz) {
        return isByte(clazz)
                || isShort(clazz)
                || isInt(clazz)
                || isLong(clazz)
                || isFloat(clazz)
                || isDouble(clazz);
    }

    public static boolean isFloatOrDouble(Class<?> clazz) {
        return isFloat(clazz) || isDouble(clazz);
    }

    public static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }

    public static boolean isByte(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Byte.class);
    }

    public static boolean isShort(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Short.class);
    }

    public static boolean isInt(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Integer.class);
    }

    public static boolean isLong(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Long.class);
    }

    public static boolean isFloat(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Float.class);
    }

    public static boolean isDouble(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Double.class);
    }

    public static boolean isBoolean(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Boolean.class);
    }

    public static boolean isChar(Class<?> clazz) {
        return getWrapperClass(clazz).equals(Character.class);
    }

    public static boolean isString(Class<?> clazz) {
        return isOrSubClass(clazz, String.class);
    }

    public static boolean isDate(Class<?> clazz) {
        return isOrSubClass(clazz, ChronoLocalDate.class);
    }


    public static boolean isLocalDateTime(Class<?> clazz) {
        return isOrSubClass(clazz, ChronoLocalDateTime.class);
    }

    public static boolean isLocalTime(Class<?> clazz) {
        return isOrSubClass(clazz, LocalTime.class);
    }

    public static boolean isOrSubClass(Class<?> clazz, Class<?> target) {
        return target.isAssignableFrom(clazz);
    }

    public static Class<?> getWrapperClass(Class<?> clazz) {
        if (clazz.equals(boolean.class)) {
            return Boolean.class;
        }
        if (clazz.equals(byte.class)) {
            return Byte.class;
        }
        if (clazz.equals(short.class)) {
            return Short.class;
        }
        if (clazz.equals(int.class)) {
            return Integer.class;
        }
        if (clazz.equals(long.class)) {
            return Long.class;
        }
        if (clazz.equals(float.class)) {
            return Float.class;
        }
        if (clazz.equals(double.class)) {
            return Double.class;
        }
        if (clazz.equals(char.class)) {
            return Character.class;
        }

        return clazz;
    }
}
