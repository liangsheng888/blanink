package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class Order implements Serializable {
    public String errorCode;
    public String reason;
    public  Result result;

    @Override
    public String toString() {
        return "Order{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static  class  Result implements Serializable{
        public Integer total;
        public List<Rows> rows;

        @Override
        public String toString() {
            return "Result{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        public static  class  Rows implements Serializable{
            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public ManyCustomer.Result.CreateBy createBy;
            public String createDate;
            public String updateDate;
            public String parentIds;
            public String name;
            public Integer sort;
            public String superId;
            public TenderAndBid.Result.Row.Company aCompany;
            public TenderAndBid.Result.Row.Company bCompany;
            public ManyCustomer.Result.CreateBy bCompanyOrderOwnerUser;
            public String aOrderNumber;
            public String bOrderNumber;
            public String orderStatus;
            public String takeOrderTime;
            public String delieverTime;
            public String takeOrderTimeString;
            public String orderType;
            public List orderProductList;
            public List orderList;
            public Integer historyOrderNumber;
            public String parentId;

            @Override
            public String toString() {
                return "Rows{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", parentIds='" + parentIds + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", superId='" + superId + '\'' +
                        ", aCompany=" + aCompany +
                        ", bCompany=" + bCompany +
                        ", bCompanyOrderOwnerUser=" + bCompanyOrderOwnerUser +
                        ", aOrderNumber='" + aOrderNumber + '\'' +
                        ", bOrderNumber='" + bOrderNumber + '\'' +
                        ", orderStatus='" + orderStatus + '\'' +
                        ", takeOrderTime='" + takeOrderTime + '\'' +
                        ", delieverTime='" + delieverTime + '\'' +
                        ", takeOrderTimeString='" + takeOrderTimeString + '\'' +
                        ", orderType='" + orderType + '\'' +
                        ", orderProductList=" + orderProductList +
                        ", orderList=" + orderList +
                        ", historyOrderNumber=" + historyOrderNumber +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }
    }
}
