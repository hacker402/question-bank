package com.leo.moudles.response;

import java.io.Serializable;

/**
 * @author qingweiqu
 */
public class ApiResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private long time;

    public ApiResult(ApiCode apiCode, String msg) {
        this.code = apiCode.getCode();
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    public ApiResult(ApiCode apiCode, String msg, T data) {
        this.code = apiCode.getCode();
        this.msg = msg;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public ApiResult(ApiCode apiCode, T data) {
        this.code = apiCode.getCode();
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public static ApiResult success(Object data) {
        return new ApiResult(BaseApiCode.SUCCESS, (String)null, data);
    }

    public static ApiResult success() {
        return new ApiResult(BaseApiCode.SUCCESS, (String)null);
    }

    public static ApiResult failed(ApiCode code, String msg) {
        return new ApiResult(code, msg);
    }

    public static ApiResult failed(String msg) {
        return new ApiResult(BaseApiCode.FAILED, msg);
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public long getTime() {
        return this.time;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResult)) {
            return false;
        } else {
            ApiResult other = (ApiResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label41: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label41;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label41;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                if (this.getTime() != other.getTime()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiResult;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        long $time = this.getTime();
        result = result * 59 + (int)($time >>> 32 ^ $time);
        return result;
    }

    @Override
    public String toString() {
        return "ApiResult(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ", time=" + this.getTime() + ")";
    }
}
