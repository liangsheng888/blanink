package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/12.
 * 上传结果
 */

public class ResponseOrder implements Serializable {
    public String errorCode;
    public String reason;
    public String result;

    @Override
    public String toString() {
        return "Response{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
