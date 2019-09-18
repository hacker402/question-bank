package com.leo.moudles.helper;

import com.leo.moudles.response.ApiCode;
import lombok.Builder;
import lombok.Data;

/**
 * 返回code帮助类
 *
 * @author qingweiqu
 */
@Data
@Builder
public class BaseApiCodeHelper implements ApiCode {

    private int code;

    @Override
    public int getCode() {
        return this.code;
    }
}
