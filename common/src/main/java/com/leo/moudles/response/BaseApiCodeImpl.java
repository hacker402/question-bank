package com.leo.moudles.response;

import lombok.Builder;
import lombok.Data;

/**
 * 返回code
 *
 * @author qingweiqu
 */
@Data
@Builder
public class BaseApiCodeImpl implements ApiCode {

    private Integer code;


    @Override
    public int getCode() {
        return this.code;
    }
}
