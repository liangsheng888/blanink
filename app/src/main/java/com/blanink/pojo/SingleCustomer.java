package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 * 客户详情
 */

public class SingleCustomer implements Serializable {
    private String errorCode;
    private String reason;
    public ManyCustomer.Result.Company result;

    @Override
    public String toString() {
        return "SingleCustomer{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
