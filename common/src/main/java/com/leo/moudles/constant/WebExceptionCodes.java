package com.leo.moudles.constant;

import com.leo.moudles.annotation.ConstantNames;
import com.leo.moudles.utils.MapUtils;

import java.util.Map;

/**
 * <p>
 * WebExceptionCodes
 * </p>
 *
 * @author jackcooperz
 * @date 2019/8/19 10:35
 */
public class WebExceptionCodes {

    public static final Integer CAPTCHA_VALID_ERROR = -20001;
    public static final Integer VISIT_LIMIT_ERROR = -20002;
    public static final Integer FILE_EXISTS_ERROR = -20003;

    @ConstantNames
    private static final Map<Integer, String> names = MapUtils.intStrBuilder()
            .add(CAPTCHA_VALID_ERROR, "验证码验证失败")
            .add(VISIT_LIMIT_ERROR, "访问限制")
            .add(FILE_EXISTS_ERROR, "文件已存在")
            .build();
}
