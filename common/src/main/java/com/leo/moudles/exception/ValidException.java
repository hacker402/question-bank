package com.leo.moudles.exception;

import com.leo.moudles.constant.ExceptionCodes;

/**
 * @author qingweiqu
 */
public class ValidException extends GeneralException {

    public ValidException(String message){
        super(message);
        this.code = ExceptionCodes.VALID_ERROR;
    }
}
