package com.leo.moudles.constant;


import com.leo.moudles.annotation.ConstantNames;
import com.leo.moudles.utils.MapUtils;

import java.util.Map;

/**
 * redis key配置
 *
 * @author jackcooperz
 */
public class RedisKey {

    /**
     * 接口授权
     */
    public static final String OAUTH_SERVER = "oauth_server";

    /**
     * IP白名单
     */
    public static final String WHITE_IP = "white_ip";

    /**
     * IP临时黑名单
     */
    public static final String TEMP_BLACK_IP = "temp_black_ip";
    /**
     * IP永久黑名单
     */
    public static final String FOREVER_BLACK_IP = "forever_black_ip";

    /**
     * 后台管理token
     */
    public static final String ADMIN_TOKEN = "manage_token";

    /**
     * 前台访问
     */
    public static final String FRONT_TOKEN = "front_token";

    /**
     * 后台服务用户token
     */
    public static final String MANAGE_TOKEN = "manage_token";

    /**
     * 后台服务验证码
     */
    public static final String MANAGE_CODE = "manage_code";

    public static final String SPLIT_FOLDER = ":";


    @ConstantNames
    private static Map<String, String> names = MapUtils.strStrBuilder()
            .add(OAUTH_SERVER, "授权服务根ROOT")
            .add(WHITE_IP, "ip白名单")
            .add(TEMP_BLACK_IP, "ip黑名单")
            .add(FRONT_TOKEN, "前台访问TOKEN")
            .add(ADMIN_TOKEN, "后台管理TOKEN")
            .add(MANAGE_TOKEN, "后台服务用户token")
            .add(MANAGE_CODE, "后台服务验证码")
            .build();
}
