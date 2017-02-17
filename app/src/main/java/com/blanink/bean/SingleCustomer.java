package com.blanink.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 * 客户详情
 */

public class SingleCustomer implements Serializable {
    private String errorCode;
    private String reason;
    private Result result;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SingleCustomer{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static  class Result implements Serializable{
        public String id;
        public Boolean isNewRecord;
        public ManyCustomer.Result.CreateBy createBy;
        public String createDate;
        public String updateDate;
        public String type;
        public ManyCustomer.Result.CompanyA companyA;
        public ManyCustomer.Result.CompanyB companyB;
        public String isCustomer;
        public String reviewStatus;
        public List<String> resources;//url以,号隔开
        public float comeOrderSelfRated;
        public float comeOrderOthersRated;
        public Boolean next;
        public String urls;
        public float getComeOrderSelfRated() {
            return comeOrderSelfRated;
        }

        public void setComeOrderSelfRated(float comeOrderSelfRated) {
            this.comeOrderSelfRated = comeOrderSelfRated;
        }

        public float getComeOrderOthersRated() {
            return comeOrderOthersRated;
        }

        public void setComeOrderOthersRated(float comeOrderOthersRated) {
            this.comeOrderOthersRated = comeOrderOthersRated;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(Boolean newRecord) {
            isNewRecord = newRecord;
        }

        public ManyCustomer.Result.CreateBy getCreateBy() {
            return createBy;
        }

        public void setCreateBy(ManyCustomer.Result.CreateBy createBy) {
            this.createBy = createBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public ManyCustomer.Result.CompanyA getCompanyA() {
            return companyA;
        }

        public void setCompanyA(ManyCustomer.Result.CompanyA companyA) {
            this.companyA = companyA;
        }

        public ManyCustomer.Result.CompanyB getCompanyB() {
            return companyB;
        }

        public void setCompanyB(ManyCustomer.Result.CompanyB companyB) {
            this.companyB = companyB;
        }

        public String getIsCustomer() {
            return isCustomer;
        }

        public void setIsCustomer(String isCustomer) {
            this.isCustomer = isCustomer;
        }

        public String getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(String reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public List<String> getResources() {
            return resources;
        }

        public void setResources(List<String> resources) {
            this.resources = resources;
        }

        public Boolean getNext() {
            return next;
        }

        public void setNext(Boolean next) {
            this.next = next;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", type='" + type + '\'' +
                    ", companyA=" + companyA +
                    ", companyB=" + companyB +
                    ", isCustomer='" + isCustomer + '\'' +
                    ", reviewStatus='" + reviewStatus + '\'' +
                    ", resources=" + resources +
                    ", comeOrderSelfRated=" + comeOrderSelfRated +
                    ", comeOrderOthersRated=" + comeOrderOthersRated +
                    ", next=" + next +
                    ", urls='" + urls + '\'' +
                    '}';
        }
    }
}
