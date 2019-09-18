package com.leo.modules.common.constant;


import com.leo.moudles.annotation.ConstantNames;
import com.leo.moudles.utils.MapUtils;

import java.util.Map;

/**
 * <p>
 * WebExceptionCodes
 * </p>
 *
 */
public class WebExceptionCodes {

    public static final int CODE_TIME_OUT = -10001;
    public static final int REPORT_NOT_EXISTS = -10002;
    public static final int TAO_BAO_ORDER_NOT_EXISTS = -10003;
    public static final int TAO_BAO_API_FAILED = -10004;
    public static final int DISPATCH_SIMILARITY_ERROR = -10005;
    public static final int THESIS_NOT_EXISTS = -10006;
    public static final int THESIS_NOT_FINISH = -10007;
    public static final int CODE_INCORRECT = -10008;
    public static final int TAO_BAO_SEND_FAILED = -10009;
    public static final int AMOUNT_INSUFFICIENT = -10010;
    public static final int SITE_EXISTS_BIND = -10011;
    public static final int NO_BALANCE = -10012;

    @ConstantNames
    private static Map<Integer, String> names = MapUtils.intStrBuilder()
            .add(CODE_TIME_OUT, "验证码已过期")
            .add(REPORT_NOT_EXISTS, "报告不存在")
            .add(TAO_BAO_ORDER_NOT_EXISTS, "淘宝订单不存在")
            .add(TAO_BAO_API_FAILED, "淘宝API调用失败")
            .add(DISPATCH_SIMILARITY_ERROR, "调度中心API调用失败")
            .add(THESIS_NOT_EXISTS, "论文查重不存在")
            .add(THESIS_NOT_FINISH, "论文查重检测中")
            .add(CODE_INCORRECT, "验证码错误")
            .add(TAO_BAO_SEND_FAILED, "淘宝发货失败")
            .add(AMOUNT_INSUFFICIENT, "淘宝订单件数不足")
            .add(SITE_EXISTS_BIND, "站点已绑定店铺")
            .add(NO_BALANCE, "代理商余额不足")
            .build();
}
