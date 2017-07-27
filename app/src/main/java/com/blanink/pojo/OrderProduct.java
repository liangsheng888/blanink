package com.blanink.pojo;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class OrderProduct implements Serializable{
    public String errorCode;
    public String reason;
    public List<Result> result;

    @Override
    public String toString() {
        return "OrderProd{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class  Result implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public LoginResult.ResultBean.CreateByBean createBy;
        public String createDate;
        public String updateDate;
        private Order  order;
        // 订单编号 父类
        public static class Order implements Serializable{
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
        public String price;		// 产品价格（借款资金额度）
        public String amount;		// 产品数量
        public String productDescription;
        public String deliveryTime;// 订单实例描述
        public String orderProductStatus;
        public String productName;
        public String companyAPriority ; //甲方优先级
        public String companyBPriority ; //已方优先级
        public RelFlowProcess relFlowProcess;
        public static class RelFlowProcess implements Serializable{
            public Boolean isNewRecord;
            public Flow flow;
            public static class Flow implements Serializable{
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
            public static class Process implements Serializable{
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
         public WorkPlan workPlan;
         public static class WorkPlan implements Serializable{
             public Boolean isNewRecord;
             public String remarks;
             public LoginResult.ResultBean.CreateByBean createBy;
             public RelFlowProcess.Flow flow;
             public String planTime;
             public String achieveAmount;
             public String priority;

             @Override
             public String toString() {
                 return "WorkPlanProcessQueue{" +
                         "isNewRecord=" + isNewRecord +
                         ", remarks='" + remarks + '\'' +
                         ", createBy=" + createBy +
                         ", flow=" + flow +
                         ", planTime='" + planTime + '\'' +
                         ", achieveAmount='" + achieveAmount + '\'' +
                         ", priority='" + priority + '\'' +
                         '}';
             }
         }
        public Integer finishedAmount;
        public List processFeedbackList;
        public List processWorkerList;
        public List workPlanList;
        public CompanyProduct.Result.Company companyA;
        public ManyCustomer.Result.CreateBy companyBOwner;

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
                    ", relFlowProcess=" + relFlowProcess +
                    ", workPlan=" + workPlan +
                    ", finishedAmount='" + finishedAmount + '\'' +
                    ", processFeedbackList=" + processFeedbackList +
                    ", processWorkerList=" + processWorkerList +
                    ", workPlanList=" + workPlanList +
                    ", companyA=" + companyA +
                    ", companyBOwner=" + companyBOwner +
                    '}';
        }
    }
}
