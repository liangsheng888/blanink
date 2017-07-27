package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 * 菜单配置
 */
public class MenuControl {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : ["排流程","采购管理","供应商管理","售后处理","招标管理","订单管理","投标管理","客户管理","我的售后","工作反馈","任务分工"]
     */

    private String errorCode;
    private String reason;
    private List<String> result;

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

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
