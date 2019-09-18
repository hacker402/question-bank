package com.leo.moudles.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class ReflectUtils {
    public static Optional<Field> findFieldByName(Class<?> clazz, String fieldName) {
        return getDeclaredAndInheritFields(clazz).stream().filter(field -> field.getName().equals(fieldName)).findFirst();
    }

    public static Optional<Field> findFieldByAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClazz) {
        return getDeclaredAndInheritFields(clazz).stream().filter(field -> field.isAnnotationPresent(annotationClazz)).findFirst();
    }

    public static Class<?> getSupperClass(Class<?> clazz) {
        if (clazz.getSuperclass() == null || clazz.getSuperclass().equals(Object.class)) {
            return clazz;
        }
        else {
            return getSupperClass(clazz.getSuperclass());
        }
    }

    public static Object getFieldValue(Field field, Object target) {
        if (target == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(target);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public static Object getStaticFieldValue(Field field) {
        field.setAccessible(true);
        try {
            return field.get(null);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public static void setFieldValue(Field field, Object target, Object value) {
        if (target == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(target, value);
        }
        catch (IllegalAccessException ex) {
            throw new IllegalStateException(
                    "Unexpected reflection exception - " + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public static List<Field> getPublicStaticFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(
                        field -> Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())
                )
                .collect(toList());
    }

    public static List<Field> getAllStaticFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(
                        field -> Modifier.isStatic(field.getModifiers())
                )
                .collect(toList());
    }

    public static List<Field> getDeclaredAndInheritFields(Class<?> clazz) {

        List<Field> fields = new ArrayList<>();
        boolean inheritOnly = false;
        for (; clazz != null && ! clazz.equals(Object.class); clazz = clazz.getSuperclass()) {
            fields.addAll(getDeclaredFieldsStream(clazz, inheritOnly));
            if (! inheritOnly) {
                inheritOnly = true;
            }
        }
        return fields;
    }

    public static Field requireField(Class<?> clazz, String fieldName) {
        return getField(clazz, fieldName).orElseThrow(() -> new RuntimeException(String.format("NoSuchField: %s in %s", fieldName, clazz.getName())));
    }

    public static Optional<Field> getField(Class<?> clazz, String fieldName) {
        return getDeclaredAndInheritFields(clazz).stream().filter(field -> field.getName().equals(fieldName)).findFirst();
    }

    private static List<Field> getDeclaredFieldsStream(Class<?> clazz, boolean inheritOnly) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> ! Modifier.isFinal(field.getModifiers()) && ! Modifier.isStatic(field.getModifiers()) && (Modifier.isPublic(field.getModifiers()) || Modifier.isProtected(field.getModifiers()) || ! inheritOnly))
                .collect(toList());
    }
}
