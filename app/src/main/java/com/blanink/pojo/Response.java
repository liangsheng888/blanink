package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/12.
 * 上传结果
 */

public class Response implements Serializable {
    public String errorCode;
    public String reason;
    public Boolean result;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
