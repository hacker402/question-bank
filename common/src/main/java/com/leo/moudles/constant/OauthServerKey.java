package com.leo.moudles.constant;

/**
 * <p>
 * OauthServerKey
 * </p>
 *
 * @author jackcooperz
 * @date 2019/8/28 11:57
 */
public class OauthServerKey {

    /**
     * 授权token key获取
     *
     * @param appKey   应用KEY
     * @param appToken 访问TOKEN
     * @return String
     */
    public static String openOAuthServer(String appKey, String appToken) {
        return getOAuthServerKey(RedisKey.FRONT_TOKEN, appKey, appToken);
    }

    /**
     * 获取白名单【对内服务】
     *
     * @param serviceId 服务ID
     * @return String
     */
    public static String internalOAuthServer(String serviceId) {
        return getOAuthServerKey(RedisKey.WHITE_IP, serviceId);
    }

    /**
     * 获取后台管理token
     *
     * @param token token
     * @return String
     */
    public static String adminOAuthServer(String token) {
        return getOAuthServerKey(RedisKey.ADMIN_TOKEN, token);
    }

    /**
     * IP黑名单
     *
     * @param serviceId 服务ID
     * @param ip        请求IP
     * @return String
     */
    public static String blackTempOAuthServer(String serviceId, String ip) {
        return getOAuthServerKey(RedisKey.TEMP_BLACK_IP, serviceId, ip);
    }


    /**
     * IP黑名单
     *
     * @param serviceId 服务Id
     * @return String
     */
    public static String blackForeverOAuthServer(String serviceId) {
        return getOAuthServerKey(RedisKey.FOREVER_BLACK_IP, serviceId);
    }

    private static String getOAuthServerKey(String... keys) {
        return RedisKeyNames.normalKey(RedisKey.OAUTH_SERVER, keys);
    }


}
