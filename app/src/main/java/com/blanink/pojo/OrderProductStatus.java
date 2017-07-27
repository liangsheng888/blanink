package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/5.
 */
public class OrderProductStatus implements Serializable {
    public String errorCode;
    public String reason;
    public String result;

    @Override
    public String toString() {
        return "OrderProductStatus{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
