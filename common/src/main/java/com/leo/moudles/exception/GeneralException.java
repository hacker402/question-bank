package com.leo.moudles.exception;

import com.leo.moudles.constant.ExceptionCodes;
import org.slf4j.event.Level;

/**
 * 自定义运行时异常
 *
 * @author jackcooperz
 */
public class GeneralException extends RuntimeException {
    /**
     * 日志级别
     */
    protected Level logLevel = Level.ERROR;
    /**
     * 状态码
     */
    protected int code = ExceptionCodes.FAILED;
    /**
     * 数据对象
     */
    protected Object data = null;

    /**
     * 构造自定义异常
     *
     * @param message 异常返回消息
     */
    public GeneralException(String message) {
        super(message);
    }

    /**
     * 构造自定义异常
     *
     * @param message 异常返回消息
     * @param data    异常返回数据
     */
    public GeneralException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public int getCode() {
        return code;
    }

    public Object getData(){
        return data;
    }
}
