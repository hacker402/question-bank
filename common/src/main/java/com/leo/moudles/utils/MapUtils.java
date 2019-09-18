package com.leo.moudles.utils;

import com.leo.moudles.exception.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * <p>
 * Map工具类
 * </p>
 *
 */
public class MapUtils {

    private static final Logger logger = LoggerFactory.getLogger(MapUtils.class);

    public static final Map EMPTY = Collections.unmodifiableMap(new HashMap<>());

    public static final Map<String, Object> EMPTY_STRING_MAP = Collections.unmodifiableMap(new HashMap<>());

    @SuppressWarnings("unchecked")
    public static Map<String, String> toStrStr(Map map) {
        UnmodifiedMapBuilder<String, String> builder = strStrBuilder();
        map.keySet().forEach(
                key -> builder.add(String.valueOf(key), String.valueOf(map.get(key)))
        );
        return builder.build();
    }

    public static Map<String, Object> objectToMap(Object obj) {
        try {
            if (obj == null) {
                return null;
            }
            Map<String, Object> map = new HashMap<String, Object>();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
            return map;
        } catch (Exception e) {
            logger.error("objectToMap failed,Error:", e);
            throw new GeneralException("对象转换map失败");
        }

    }

    public static UnmodifiedMapBuilder<String, Object> strObjBuilder() {
        return builder();
    }

    public static UnmodifiedMapBuilder<String, String> strStrBuilder() {
        return builder();
    }

    public static UnmodifiedMapBuilder<String, Integer> strIntBuilder() {
        return builder();
    }

    public static UnmodifiedMapBuilder<Integer, String> intStrBuilder() {
        return builder();
    }

    public static UnmodifiedMapBuilder<Integer, Integer> intIntBuilder() {
        return builder();
    }

    private static <K, V> UnmodifiedMapBuilder<K, V> builder() {
        return new UnmodifiedMapBuilder<>();
    }

    public static class UnmodifiedMapBuilder<K, V> {

        public Map<K, V> map = new HashMap<>();

        public UnmodifiedMapBuilder<K, V> reset() {
            map.clear();
            return this;
        }

        public UnmodifiedMapBuilder<K, V> add(K key, V value) {
            map.put(key, value);
            return this;
        }

        public <T> UnmodifiedMapBuilder<K, V> addIf(T t, Predicate<T> predicate, K key, V value) {
            if (predicate.test(t)) {
                map.put(key, value);
            }
            return this;
        }

        public Map<K, V> build() {
            return Collections.unmodifiableMap(map);
        }
    }
}
