package com.blanink.pojo;

/**
 * Created by Administrator on 2017/4/9.
 */

public class VersionInfo {

    /**
     * errorCode : 00000
     * reason : 版本信息
     * result : {"versionName":"2.0","versionCode":2}
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * versionName : 2.0
         * versionCode : 2
         */

        private String versionName;
        private int versionCode;

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }
    }
}
