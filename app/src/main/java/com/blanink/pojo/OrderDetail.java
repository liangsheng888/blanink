package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public class OrderDetail implements Serializable {
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static  class Result{
        public Integer total;
        public List<Rows> rows;

        @Override
        public String toString() {
            return "Result{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }
    }



    public static  class Rows implements Serializable{
        public String id;
        public Boolean isNewRecord;
        public LoginResult.CreateBy createBy;
        public String createDate;
        public String updateDate;
        public Order order;
        public CompanyCategory companyCategory;
        public String price;
        public String amount;
        public String productDescription;
        public String aConfirmTime;
        public String deliveryTime;
        public String orderProductType;
        public String productName;
        public String deliveryTimeString;
        public String aconfirmTime;

        @Override
        public String toString() {
            return "Rows{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", order=" + order +
                    ", companyCategory=" + companyCategory +
                    ", price='" + price + '\'' +
                    ", amount='" + amount + '\'' +
                    ", productDescription='" + productDescription + '\'' +
                    ", aConfirmTime='" + aConfirmTime + '\'' +
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", orderProductType='" + orderProductType + '\'' +
                    ", productName='" + productName + '\'' +
                    ", deliveryTimeString='" + deliveryTimeString + '\'' +
                    ", aconfirmTime='" + aconfirmTime + '\'' +
                    '}';
        }
        public static  class  Order implements Serializable{
            public String id;
            public Boolean isNewRecord;
            public Integer sort;
            public List orderProductList;
            public List orderList;
            public Integer historyOrderNumber;
            public String parentId;

            @Override
            public String toString() {
                return "Order{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", sort=" + sort +
                        ", orderProductList=" + orderProductList +
                        ", orderList=" + orderList +
                        ", historyOrderNumber=" + historyOrderNumber +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

        public static class CompanyCategory implements Serializable {

            public String id;
            public Boolean isNewRecord;
            public Integer sort;
            public List categoryAttributeList;
            public List relIndustryCompanyCategoryList;
            public String attributeNames;
            public String parentId;
            public String attributeIds;
            public String industryCategoryIds;
            public String industryCategoryNames;
            public String parentName;
            @Override
            public String toString() {
                return "CompanyCategory{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", sort=" + sort +
                        ", categoryAttributeList=" + categoryAttributeList +
                        ", relIndustryCompanyCategoryList=" + relIndustryCompanyCategoryList +
                        ", attributeNames='" + attributeNames + '\'' +
                        ", industryCategoryIds='" + industryCategoryIds + '\'' +
                        ", industryCategoryNames='" + industryCategoryNames + '\'' +
                        ", parentId='" + parentId + '\'' +
                        ", parentName='" + parentName + '\'' +
                        ", attributeIds='" + attributeIds + '\'' +
                        '}';
            }
        }
    }
}
