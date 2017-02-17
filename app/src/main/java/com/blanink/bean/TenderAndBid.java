package com.blanink.bean;


import java.io.Serializable;
import java.util.Date;
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

            public static class Company implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public String type;
                public List customerServiceList;
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
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }

            public String inviteDate;
            public String buyProductName;
            public String targetPrice;
            public String downPayment;
            public String expireDate;
            public String attachment;
            public List<Bid> bidList;
            public Integer count;
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
                        ", expired=" + expired +
                        '}';
            }

            public static class Bid implements Serializable{
                public String id;
                public Boolean isNewRecord;
                public String remarks;
                public ManyCustomer.Result.CreateBy createBy;
                public String createDate;
                public String updateDate;
                public InviteBid inviteBid;
                public BidCompany bidCompany;
                public String bidDate;
                public String bidPrice;
                public List inviteBidTalkList;

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
                            ", inviteBidTalkList=" + inviteBidTalkList +
                            '}';
                }

                public static class InviteBid implements Serializable {
                    /* "id": "8afe1359fe9741568332dcbcf6ec0e96",
                     "isNewRecord": false,
                     "bidList": [],
                     "count": 0,
                     "expired": false*/
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

                public static class BidCompany implements Serializable {
                    public String id;
                    public Boolean isNewRecord;
                    public String remarks;
                    public String name;    // 机构名称
                    public Integer sort;
                    //	private Office parent;	// 父级编号
                    //	private String parentIds; // 所有父级编号
                    //  private Area area;		// 归属区域
                    private String code;    // 机构编码

                    // 排序
                    public String scope;      //经营范围
                    public String shortName;        // 公司简称
                    public String registTime;        // 公司注册时间
                    public String type;    // 机构类型（1：公司；2：部门；3：小组）
                    public String grade;    // 机构等级（1：一级；2：二级；3：三级；4：四级）
                    public String address; // 联系地址
                    public String zipCode; // 邮政编码
                    public String master;    // 负责人
                    public String phone;    // 电话
                    public String fax;    // 传真
                    public String email;    // 邮箱
                    public List customerServiceList;
                    public String parentId;
            /*private String useable;//是否可用
            private User primaryPerson;//主负责人
            private User deputyPerson;//副负责人
            private List<String> childDeptList;//快速添加子部门
            private Office createCompanyBy;//被我机构创建的上家机构
            private String cssStyle ;*/

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

}
