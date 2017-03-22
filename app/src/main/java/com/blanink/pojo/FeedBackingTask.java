package com.blanink.pojo;

import com.blanink.po.Office;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 * 我反馈过的摸个产品的所有信息
 */


public class FeedBackingTask implements Serializable {
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "FeedBackingTask{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public CreateBy createBy;

        public static class CreateBy implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String name;
            public String loginFlag;
            public List roleList;
            public String roleNames;
            public Boolean admin;

            @Override
            public String toString() {
                return "CreateBy{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", name='" + name + '\'' +
                        ", loginFlag='" + loginFlag + '\'' +
                        ", roleList=" + roleList +
                        ", roleNames='" + roleNames + '\'' +
                        ", admin=" + admin +
                        '}';
            }
        }

        public String createDate;
        public String updateDate;
        public Order order;

        // 订单编号 父类
        public static class Order implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public Integer sort;
            public String takeOrderTime;
            public String takeOrderTimeString;
            public String delieverTimeString;
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
                        ", takeOrderTime='" + takeOrderTime + '\'' +
                        ", takeOrderTimeString='" + takeOrderTimeString + '\'' +
                        ", delieverTimeString='" + delieverTimeString + '\'' +
                        ", orderProductList=" + orderProductList +
                        ", orderList=" + orderList +
                        ", historyOrderNumber=" + historyOrderNumber +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

        public CompanyCategory companyCategory;

        public static class CompanyCategory implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String name;
            public Integer sort;
            public List categoryAttributeList;
            public List relIndustryCompanyCategoryList;
            public String attributeNames;
            public String parentName;
            public String parentId;
            public String attributeIds;
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
                        ", parentName='" + parentName + '\'' +
                        ", attributeIds='" + attributeIds + '\'' +
                        ", industryCategoryIds='" + industryCategoryIds + '\'' +
                        ", industryCategoryNames='" + industryCategoryNames + '\'' +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

        public String price;        // 产品价格（借款资金额度）
        public String amount;        // 产品数量
        public String productDescription;
        public String deliveryTime;// 订单实例描述
        public String orderProductStatus;
        public String productName;
        public String deliveryTimeString;
        public String companyAPriority; //甲方优先级
        public RelFlowProcess relFlowProcess;

        public static class RelFlowProcess implements Serializable {
            public Boolean isNewRecord;
            public Flow flow;

            public static class Flow implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public List processList;
                public List remaksList;

                @Override
                public String toString() {
                    return "Flow{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", processList=" + processList +
                            ", remaksList=" + remaksList +
                            '}';
                }
            }

            public Process process;

            public static class Process implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public List relPPList;
                public String parentId;

                @Override
                public String toString() {
                    return "Process{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", relPPList=" + relPPList +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }

            public Integer target;
            public String status;

            @Override
            public String toString() {
                return "RelFlowProcess{" +
                        "isNewRecord=" + isNewRecord +
                        ", flow=" + flow +
                        ", process=" + process +
                        ", target=" + target +
                        ", status='" + status + '\'' +
                        '}';
            }
        }

        public Integer finishedAmount;
        public ProcessFeedback processFeedback;

        public static class ProcessFeedback implements Serializable {
            public Boolean isNewRecord;
            public String createDate;
            public Integer faultAmount;
            public List resources;
            public Integer target;
            public String urls;

            @Override
            public String toString() {
                return "ProcessFeedback{" +
                        "isNewRecord=" + isNewRecord +
                        ", createDate='" + createDate + '\'' +
                        ", faultAmount=" + faultAmount +
                        ", resources=" + resources +
                        ", target=" + target +
                        ", urls='" + urls + '\'' +
                        '}';
            }
        }

        public Integer allFinishedAmount;
        public List<ProcessFeedbackUser> processFeedbackList;

        public static class ProcessFeedbackUser implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public CreateBy createBy;
            public String createDate;
            public String updateDate;
            public RelFlowProcess.Flow flow;
            public RelFlowProcess.Process process;
            public Integer faultAmount;
            public String isFinished;
            public Integer achieveAmount;
            public List resources;
            public FeedbackUser feedbackUser;

            public static class FeedbackUser implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public String loginFlag;
                public List roleList;
                public String roleNames;
                public Boolean admin;

                @Override
                public String toString() {
                    return "feedbackUser{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", loginFlag='" + loginFlag + '\'' +
                            ", roleList=" + roleList +
                            ", roleNames='" + roleNames + '\'' +
                            ", admin=" + admin +
                            '}';
                }
            }

            public Integer target;
            public String urls;

            @Override
            public String toString() {
                return "ProcessFeedbackUser{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", flow=" + flow +
                        ", process=" + process +
                        ", faultAmount=" + faultAmount +
                        ", isFinished='" + isFinished + '\'' +
                        ", achieveAmount=" + achieveAmount +
                        ", resources=" + resources +
                        ", feedbackUser=" + feedbackUser +
                        ", target=" + target +
                        ", urls='" + urls + '\'' +
                        '}';
            }
        }

        public Integer planedAmount;
        public List<Worker> processWorkerList;

        public static class Worker implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public Office company;
            public Office office;

            public static class Office implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public Integer sort;
                public String type;
                public List customerServiceList;
                public Integer reviewOthers;
                public Integer reviewSelf;
                public Integer otherCosting;
                public Integer otherPayment;
                public Integer otherQuality;
                public Integer otherService;
                public Integer otherTime;
                public Integer selfPayment;
                public Integer selfQuality;
                public Integer selfService;
                public Integer selfCosting;
                public Integer selfTime;
                public Integer serviceCount;
                public String parentId;

                @Override
                public String toString() {
                    return "Office{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", sort=" + sort +
                            ", type='" + type + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            ", reviewOthers=" + reviewOthers +
                            ", reviewSelf=" + reviewSelf +
                            ", otherCosting=" + otherCosting +
                            ", otherPayment=" + otherPayment +
                            ", otherQuality=" + otherQuality +
                            ", otherService=" + otherService +
                            ", otherTime=" + otherTime +
                            ", selfPayment=" + selfPayment +
                            ", selfQuality=" + selfQuality +
                            ", selfService=" + selfService +
                            ", selfCosting=" + selfCosting +
                            ", selfTime=" + selfTime +
                            ", serviceCount=" + serviceCount +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }

            public String loginName;
            public String no;
            public String name;
            public String userType;
            public String loginFlag;
            public List roleList;
            public String roleNames;
            public Boolean admin;

            @Override
            public String toString() {
                return "Worker{" +
                        "id='" + id + '\'' +
                        ", company=" + company +
                        ", office=" + office +
                        ", loginName='" + loginName + '\'' +
                        ", no='" + no + '\'' +
                        ", name='" + name + '\'' +
                        ", userType='" + userType + '\'' +
                        ", loginFlag='" + loginFlag + '\'' +
                        ", roleList=" + roleList +
                        ", roleNames='" + roleNames + '\'' +
                        ", admin=" + admin +
                        '}';
            }
        }

        public List workPlanList;
        public Worker.Office companyA;
        public CreateBy companyBOwner;

        @Override
        public String toString() {
            return "Result{" +
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
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", orderProductStatus='" + orderProductStatus + '\'' +
                    ", productName='" + productName + '\'' +
                    ", deliveryTimeString='" + deliveryTimeString + '\'' +
                    ", companyAPriority='" + companyAPriority + '\'' +
                    ", relFlowProcess=" + relFlowProcess +
                    ", finishedAmount=" + finishedAmount +
                    ", processFeedback=" + processFeedback +
                    ", allFinishedAmount=" + allFinishedAmount +
                    ", processFeedbackList=" + processFeedbackList +
                    ", planedAmount=" + planedAmount +
                    ", processWorkerList=" + processWorkerList +
                    ", workPlanList=" + workPlanList +
                    ", companyA=" + companyA +
                    ", companyBOwner=" + companyBOwner +
                    '}';
        }
    }

}
