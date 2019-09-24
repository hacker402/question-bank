package com.leo.moudles.exception;

/**
 * @author qingweiqu
 */
public class NotExistException extends GeneralException {
    public NotExistException(String message) {
        super(message);
    }

    public NotExistException(String message, Object data) {
        super(message, data);
    }
}
