package com.blanink.pojo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/12.
 */

public class ProductAttributes implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"颜色":"白","尺寸":"112222"}
     */

    private String errorCode;
    private String reason;
    private Map<String, String> result;

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

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }
}
