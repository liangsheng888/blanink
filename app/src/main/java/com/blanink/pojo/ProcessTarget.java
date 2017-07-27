package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/10.
 * 工序 目标
 */
public class ProcessTarget implements Serializable{
    public String errorCode;
    public String reason;
    public Integer result;

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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
