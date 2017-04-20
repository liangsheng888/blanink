package com.blanink.pojo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/10.
 * 公司产品
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
            public Map<String,String> map;
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
                        ", map=" + map +
                        '}';
            }
        }

            public static class Company implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public String type;
                public List customerServiceList;
                public Integer serviceCount;
                public String parentId;

                @Override
                public String toString() {
                    return "Company{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", type='" + type + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            ", serviceCount=" + serviceCount +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }

            public static class CompanyCategory implements Serializable {

                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public List categoryAttributeList;
                public List relIndustryCompanyCategoryList;
                public String attributeNames;
                public String attributeIds;
                public String parentId;
                public String parentName;
                public String industryCategoryIds;
                public String industryCategoryNames;
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
        }
    }


