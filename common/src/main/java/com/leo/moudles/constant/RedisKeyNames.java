package com.leo.moudles.constant;

import java.util.Arrays;

/**
 * RedisKeyName
 *
 * @author jackcooperz
 */
public enum RedisKeyNames {


    /**
     * Normal
     * OAUTH_SERVER 授权服务Redis基础key
     * MANAGE_SERVER 后台服务Redis基础key
     */
    NORMAL_KEY("normal_key"),
    MANAGE_SERVER("manage_server");

    private final String prefix;

    RedisKeyNames(String prefix) {
        this.prefix = prefix;
    }

    private String get() {
        return prefix;
    }

    private String get(String... suffixList) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);
        Arrays.asList(suffixList).forEach(suffix -> stringBuilder.append(":").append(suffix));
        return stringBuilder.toString();
    }

    private String getByPrefix(String prefix, String... suffixList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);
        Arrays.asList(suffixList).forEach(suffix -> stringBuilder.append(RedisKey.SPLIT_FOLDER).append(suffix));
        return stringBuilder.toString();
    }

    /**
     * 后台服务token key
     *
     * @param appName appName
     * @param token   token
     * @return String
     */
    public static String manageTokenKey(String appName, String token) {
        return NORMAL_KEY.getByPrefix(appName, RedisKey.MANAGE_TOKEN, token);
    }

    /**
     * 后台服务 验证码key
     *
     * @param appName appName
     * @param code    code
     * @return String
     */
    public static String manageCodeKey(String appName, String code) {
        return NORMAL_KEY.getByPrefix(appName, RedisKey.MANAGE_CODE, code);
    }

    /**
     * key生成
     *
     * @param prefix 前缀
     * @param key    key
     * @return String
     */
    public static String normalKey(String prefix, String... key) {
        return NORMAL_KEY.getByPrefix(prefix, key);
    }


}
