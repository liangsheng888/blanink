package com.blanink.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 * 招标投标
 */
public class TenderAndBid implements Serializable {
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
        return "TenderAndBid{" +
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
                    ", rows=" + rows +
                    '}';
        }

        public static class Row implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public ManyCustomer.Result.CreateBy createBy;
            public String createDate;
            public String updateDate;
            public Company inviteCompany;
            public String inviteDate;
            public String buyProductName;
            public String targetPrice;
            public String downPayment;
            public String expireDate;
            public String attachment;
            public List<Bid> bidList;
            public Integer count;
            public String title;
            public String bidStatus;
            public Boolean expired;

            @Override
            public String toString() {
                return "Row{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", inviteCompany=" + inviteCompany +
                        ", inviteDate='" + inviteDate + '\'' +
                        ", buyProductName='" + buyProductName + '\'' +
                        ", targetPrice='" + targetPrice + '\'' +
                        ", downPayment='" + downPayment + '\'' +
                        ", expireDate='" + expireDate + '\'' +
                        ", attachment='" + attachment + '\'' +
                        ", bidList=" + bidList +
                        ", count=" + count +
                        ", title='" + title + '\'' +
                        ", bidStatus='" + bidStatus + '\'' +
                        ", expired=" + expired +
                        '}';
            }

            public static class Bid implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String remarks;
                public ManyCustomer.Result.CreateBy createBy;
                public String createDate;
                public String updateDate;
                public InviteBid inviteBid;
                public Company bidCompany;
                public String bidDate;
                public String bidPrice;
                public String attachment;
                public List inviteBidTalkList;
                public String title;
                public Integer productionCycleUnit;
                public String productionCycle;
                public Integer bidStatus;

                @Override
                public String toString() {
                    return "Bid{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", inviteBid=" + inviteBid +
                            ", bidCompany=" + bidCompany +
                            ", bidDate='" + bidDate + '\'' +
                            ", bidPrice='" + bidPrice + '\'' +
                            ", attachment='" + attachment + '\'' +
                            ", inviteBidTalkList=" + inviteBidTalkList +
                            ", title='" + title + '\'' +
                            ", productionCycleUnit=" + productionCycleUnit +
                            ", productionCycle='" + productionCycle + '\'' +
                            '}';
                }
            }

            public static class InviteBid implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public List bidList;
                public Integer count;
                public Boolean expired;

                @Override
                public String toString() {
                    return "InviteBid{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", bidList=" + bidList +
                            ", count=" + count +
                            ", expired=" + expired +
                            '}';
                }
            }

            public static class Company implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String remarks;
                public String name;
                public Integer sort;
                public ManyCustomer.Area area;
                public String code;
                public String shortName;
                public String registTime;
                public String scope;
                public String type;
                public String grade;
                public String address;
                public String zipCode;
                public String master;
                public String phone;
                public String fax;
                public String email;
                public String useable;
                public ManyCustomer.Person primaryPerson;
                public ManyCustomer.Person deputyPerson;
                public List customerServiceList;
                public String homepage;
                public Double reviewOthers;
                public Double reviewSelf;
                public Double otherCosting;
                public Double otherPayment;
                public Double otherQuality;
                public Double otherService;
                public Double otherTime;
                public Double selfPayment;
                public Double selfQuality;
                public Double selfService;
                public Double selfCosting;
                public Double selfTime;
                public Integer serviceCount;
                public String photo;
                public String parentId;

                @Override
                public String toString() {
                    return "BidCompany{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", code='" + code + '\'' +
                            ", scope='" + scope + '\'' +
                            ", shortName='" + shortName + '\'' +
                            ", registTime=" + registTime +
                            ", type='" + type + '\'' +
                            ", grade='" + grade + '\'' +
                            ", address='" + address + '\'' +
                            ", zipCode='" + zipCode + '\'' +
                            ", master='" + master + '\'' +
                            ", phone='" + phone + '\'' +
                            ", fax='" + fax + '\'' +
                            ", email='" + email + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }


        }

    }


}


