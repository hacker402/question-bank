package com.leo.moudles.response;

/**
 * @author qingweiqu
 */

public enum BaseApiCode implements ApiCode<Enum> {
    SUCCESS(0),
    FAILED(-1),
    SYSTEM_EXCEPTION(500),
    RESOURCE_NOT_FOUND(404);

    private int code;

    private BaseApiCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}