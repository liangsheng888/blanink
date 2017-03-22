package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 * 历史反馈
 */

public class WorkedTask implements Serializable {
    public String errorCode;
    public String reason;
    public List<Result> result;

    @Override
    public String toString() {
        return "OrderProduct{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public LoginResult.CreateBy createBy;
        public String createDate;
        public String updateDate;
        private OrderProduct.Result.Order order;

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

        public CompanyProduct.Result.CompanyCategory companyCategory;
        public String price;        // 产品价格（借款资金额度）
        public String amount;        // 产品数量
        public String productDescription;
        public String deliveryTime;// 订单实例描述
        public String orderProductStatus;
        public String productName;
        public String companyAPriority; //甲方优先级
        public String companyBPriority; //已方优先级
        public RelFlowProcess relFlowProcess;

        public static class RelFlowProcess implements Serializable {
            public Boolean isNewRecord;
            public OrderProduct.Result.RelFlowProcess.Flow flow;

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
            public Integer totalCompletedQuantity;
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
        public FeedBackingTask.Result.ProcessFeedback  processFeedback;
        public Integer allFinishedAmount;
        public List processFeedbackList;
        public Integer planedAmount;
        public List processWorkerList;
        public List workPlanList;
        public FeedBackingTask.Result.Worker.Office companyA;
        public FeedBackingTask.Result.CreateBy companyBOwner;
        public String aconfirmTime;
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
                    ", companyAPriority='" + companyAPriority + '\'' +
                    ", companyBPriority='" + companyBPriority + '\'' +
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
                    ", aconfirmTime='" + aconfirmTime + '\'' +
                    '}';
        }
    }
}