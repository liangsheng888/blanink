package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/12.
 * 上传结果
 */

public class ResponseDelete implements Serializable {

    /**
     * errorCode : 00000
     * reason : 保存数据成功！
     */

    private String errorCode;
    private String reason;

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
}
