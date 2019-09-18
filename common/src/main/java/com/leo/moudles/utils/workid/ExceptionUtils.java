package com.leo.moudles.utils.workid;

import com.leo.moudles.exception.GeneralException;
import com.leo.moudles.utils.DataUtils;

/**
 * 异常辅助工具类
 *
 * @author HCL
 * @since 2018-07-24
 */
public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    /**
     * 返回一个新的异常，统一构建，方便统一处理
     *
     * @param msg 消息
     * @param t   异常信息
     * @return 返回异常
     */
    public static GeneralException mpe(String msg, Throwable t, Object... params) {
        return new GeneralException(DataUtils.format(msg, params)+",Error:"+t.getMessage());
    }

    /**
     * 重载的方法
     *
     * @param msg 消息
     * @return 返回异常
     */
    public static GeneralException mpe(String msg, Object... params) {
        return new GeneralException(DataUtils.format(msg, params));
    }

    /**
     * 重载的方法
     *
     * @param t 异常
     * @return 返回异常
     */
    public static GeneralException mpe(Throwable t) {
        return new GeneralException(t.getMessage());
    }

}
