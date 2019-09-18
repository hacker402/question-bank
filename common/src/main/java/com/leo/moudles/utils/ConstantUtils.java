package com.leo.moudles.utils;

import com.leo.moudles.annotation.ConstantNames;
import com.leo.moudles.annotation.ConstantValues;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 常量工具类
 * </p>
 *
 * @author qingweiqu
 */
public class ConstantUtils {

    public static String getValue(Object constantValue, Class<?> constantClazz) {
        Optional<Field> maybeValuesField = ReflectUtils.getAllStaticFields(constantClazz).stream()
                .filter(field -> field.isAnnotationPresent(ConstantValues.class))
                .findFirst();

        return getMaybeFiled(maybeValuesField, constantValue);
    }


    public static String getName(Object constantValue, Class<?> constantClazz) {
        Optional<Field> maybeNamesField = ReflectUtils.getAllStaticFields(constantClazz).stream()
                .filter(field -> field.isAnnotationPresent(ConstantNames.class))
                .findFirst();

        return getMaybeFiled(maybeNamesField, constantValue);
    }


    public static Map list(Class<?> constantClazz) {

        Optional<Object> maybeNamesField = ReflectUtils.getAllStaticFields(constantClazz).stream()
                .filter(field -> field.isAnnotationPresent(ConstantNames.class))
                .map(ReflectUtils::getStaticFieldValue)
                .findFirst();

        if (maybeNamesField.isPresent()) {
            return (Map) maybeNamesField.get();
        } else {
            return MapUtils.EMPTY;
        }
    }


    private static String getMaybeFiled(Optional<Field> maybeField, Object constantValue) {
        return maybeField
                .map(ReflectUtils::getStaticFieldValue)
                .flatMap(value -> {
                    if (TypeUtils.isMap(value.getClass())) {
                        return Optional.ofNullable(((Map) value).get(constantValue));
                    } else {
                        return Optional.empty();
                    }
                })
                .map(String::valueOf)
                .orElse(String.valueOf(constantValue));
    }
}
