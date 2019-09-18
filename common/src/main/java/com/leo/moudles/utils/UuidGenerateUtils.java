package com.leo.moudles.utils;

import java.util.UUID;

/**
 * UUID 生成工具类
 *
 */
public class UuidGenerateUtils {

    /**
     * 默认间隔符
     */
    private static final String REPLACE_STR = "-";

    /**
     * 生成不带中划线的 UUID
     *
     * @return String
     */
    public static String uuidOnUnderLine() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toLowerCase().replaceAll(REPLACE_STR, DataUtils.EMPTY_STR);
    }

    /**
     * 带中划线的UUID
     *
     * @return static
     */
    public static String uuidLine() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
