package com.leo.moudles.hanlder;

import com.leo.moudles.constant.ExceptionCodes;
import com.leo.moudles.response.BaseApiCodeImpl;
import com.leo.moudles.response.ApiResult;
import com.leo.moudles.response.BaseApiCode;
import com.leo.moudles.utils.ConstantUtils;
import com.leo.moudles.utils.DataUtils;

/**
 * baseController
 *
 * @author qingweiqu
 */
public class BaseController {

    protected ApiResult success(String message, Object body) {
        return new ApiResult(BaseApiCode.SUCCESS, message, body);
    }

    protected ApiResult success(Object body) {
        return new ApiResult(BaseApiCode.SUCCESS, ConstantUtils.getName(ExceptionCodes.SUCCESS,
                ExceptionCodes.class), body);
    }

    protected ApiResult success(String message) {
        return new ApiResult(BaseApiCode.SUCCESS, message, DataUtils.EMPTY_STR);
    }


    protected ApiResult failed() {
        return new ApiResult(BaseApiCode.FAILED, ConstantUtils.getName(ExceptionCodes.FAILED,
                ExceptionCodes.class));
    }

    protected ApiResult failed(String message) {
        return new ApiResult(BaseApiCode.FAILED, message);
    }

    protected ApiResult failed(int code, String message) {
        return new ApiResult(BaseApiCodeImpl.builder().code(code).build(), message);
    }

    protected ApiResult failed(int code, String message, Object data) {
        return new ApiResult(BaseApiCodeImpl.builder().code(code).build(), message, data);
    }


}
