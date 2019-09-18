package com.leo.moudles.constant;

import com.leo.moudles.annotation.ConstantNames;
import com.leo.moudles.utils.MapUtils;

import java.util.Map;

/**
 * <p>
 * ExceptionCodes
 * </p>
 *
 */
public class ExceptionCodes {

    /**
     * 操作失败状态码
     */
    public static final int FAILED = -1;
    /**
     * 操作成功状态码
     */
    public static final int SUCCESS = 0;

    public static final int VALID_ERROR = -10001;
    public static final int SIGNATURE_FAILED = -10002;
    public static final int NOT_FOUND = -404;

    public static final int NOT_EXIST = -10003;
    public static final int NEED_LOGIN = 401;
    public static final int NO_PERM = 403;

    public static final int REDIS_KEY_EXIST = -10004;
    public static final int UPLOAD_TEXT_OSS_FAILED = -10005;
    public static final int CODE_TIME_OUT = -10006;
    public static final int CODE_INCORRECT = -10007;

    @ConstantNames
    private static final Map<Integer, String> names = MapUtils.intStrBuilder()
            .add(FAILED, "操作失败")
            .add(SUCCESS, "操作成功")
            .add(VALID_ERROR, "验证失败")
            .add(SIGNATURE_FAILED, "验签失败")
            .add(NOT_EXIST, "记录不存在")

            .add(NOT_FOUND, "not found")
            .add(NEED_LOGIN, "需要登录，请先登录")
            .add(NO_PERM, "操作失败,无权限访问")
            .add(REDIS_KEY_EXIST, "redis存在记录,不可删除")

            .add(UPLOAD_TEXT_OSS_FAILED, "OSS文本上传失败")

            .add(CODE_TIME_OUT, "验证码已过期")
            .add(CODE_INCORRECT, "验证码错误")
            .build();
}
