package com.blanink.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */

public class CompanyProduct implements Serializable {
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "CompanyProduct{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result implements Serializable {
        public Integer total;
        public List<Row> rows;

        @Override
        public String toString() {
            return "Result{" +
                    "total=" + total +
                    ", ros=" + rows +
                    '}';
        }

        public static class Row implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public ManyCustomer.Result.CreateBy createBy;
            public String createDate;
            public String updateDate;
            public Company company;
            public CompanyCategory companyCategory;
            public String productName;
            public String productDescription;
            public String productPriceDownline;
            public String productPriceHighline;
            public String productPhotos;
            public List specificationList;

            @Override
            public String toString() {
                return "Row{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", company=" + company +
                        ", companyCategory=" + companyCategory +
                        ", productName='" + productName + '\'' +
                        ", productDescription='" + productDescription + '\'' +
                        ", productPriceDownline='" + productPriceDownline + '\'' +
                        ", productPriceHighline='" + productPriceHighline + '\'' +
                        ", productPhotos='" + productPhotos + '\'' +
                        ", specificationList=" + specificationList +
                        '}';
            }

            public static class Company implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public Integer sort;
                public String type;
                public List customerServiceList;
                public String parentId;

                @Override
                public String toString() {
                    return "Company{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", sort=" + sort +
                            ", type='" + type + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }


            }

            public static class CompanyCategory implements Serializable {

                /*       "id": "78f327f0dc8744fe85c82ba21a5b42db",
                        "isNewRecord": false,
                        "name": "苹果手机",
                        "sort": 30,
                        "categoryAttributeList": [],
                        "relIndustryCompanyCategoryList": [],
                        "attributeNames": "",
                        "industryCategoryIds": "",
                        "industryCategoryNames": "",
                        "parentId": "0",
                        "parentName": "",
                        "attributeIds": ""*/
                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public List categoryAttributeList;
                public List relIndustryCompanyCategoryList;
                public String attributeNames;
                public String attributeIds;
                public String industryCategoryIds;
                public String industryCategoryNames;
                public String parentId;
                public String parentName;
                @Override
                public String toString() {
                    return "CompanyCategory{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
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

            /*"productName": "苹果4S",
                    "productDescription": "苹果4S",
                    "productPriceDownline": "5555",
                    "productPriceHighline": "6666",
                    "productPhotos": "",
                    "specificationList": []*/


        }
    }
    /*"errorCode": "00000",
            "reason": "获取数据成功！",
            "result": {
        "total": 3,
                "rows": [
        {
                "id": "90d59ca08490447d9fbe468a8f931e3d",
                "isNewRecord": false,
                "remarks": "<p>苹果4S！！！！！！！</p>",
                "createBy": {
            "id": "2",
                    "isNewRecord": false,
                    "loginFlag": "1",
                    "roleNames": "",
                    "admin": false
        },
            "createDate": "2017-02-08 11:49:39",
                "updateDate": "2017-02-08 11:49:39",
                "company": {
                    "id": "d38f321fb31546edbf6927e5fc9e65d9",
                    "isNewRecord": false,
                    "sort": 30,
                    "type": "1",
                    "customerServiceList": [],
                    "parentId": "0"
        },
            "companyCategory": {
                    "id": "78f327f0dc8744fe85c82ba21a5b42db",
                    "isNewRecord": false,
                    "name": "苹果手机",
                    "sort": 30,
                    "categoryAttributeList": [],
                    "relIndustryCompanyCategoryList": [],
                     "attributeNames": "",
                    "industryCategoryIds": "",
                    "industryCategoryNames": "",
                    "parentId": "0",
                    "parentName": "",
                    "attributeIds": ""
        },
                "productName": "苹果4S",
                "productDescription": "苹果4S",
                "productPriceDownline": "5555",
                "productPriceHighline": "6666",
                "productPhotos": "",
                "specificationList": []
        },*/
}
