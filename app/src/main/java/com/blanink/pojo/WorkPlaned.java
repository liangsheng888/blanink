package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class WorkPlaned implements Serializable {
    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"0082c7d7b13d49be9cb1bd27103f528a","isNewRecord":false,"createBy":{"id":"ae5db71c02d94d6ba5f994319391fcf1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2016-12-06 15:10:03","updateDate":"2016-12-06 15:10:03","order":{"id":"01302d67478f4027b5aac0225eb1f00a","isNewRecord":false,"sort":30,"takeOrderTime":"2016-12-21","takeOrderTimeString":"2016-12-21","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"},"companyCategory":{"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"1","amount":"1","productDescription":"第二个将工序C分配给张三丰20个，老二4个","aConfirmTime":"2017-01-04","deliveryTime":"2016-12-13","orderProductType":"2","orderProductStatus":"1","productName":"第二个将工序C分配给张三丰20个，老二4个","deliveryTimeString":"2016-12-13","relFlowProcess":{"isNewRecord":true,"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0"},"target":1000,"processPriority":"0","status":"1","totalCompletedQuantity":73},"workPlan":{"isNewRecord":true,"remarks":"xx","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 11:38:42","updateDate":"2017-03-02 11:38:42","planTime":"2017-03-29 11:38:30","worker":{"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"1","priority":"4"},"processFeedbackList":[],"planedAmount":201,"processWorkerList":[],"workPlanList":[],"companyA":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"0"},"companyBOwner":{"isNewRecord":true,"name":"张三","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"aconfirmTime":"2017-01-04 15:03:39"}]
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean implements Serializable {
        public int total;
        public List<Rows> rows;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        public static class Rows implements Serializable {

            /**
             * id : 0082c7d7b13d49be9cb1bd27103f528a
             * isNewRecord : false
             * createBy : {"id":"ae5db71c02d94d6ba5f994319391fcf1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2016-12-06 15:10:03
             * updateDate : 2016-12-06 15:10:03
             * order : {"id":"01302d67478f4027b5aac0225eb1f00a","isNewRecord":false,"sort":30,"takeOrderTime":"2016-12-21","takeOrderTimeString":"2016-12-21","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"}
             * companyCategory : {"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""}
             * price : 1
             * amount : 1
             * productDescription : 第二个将工序C分配给张三丰20个，老二4个
             * aConfirmTime : 2017-01-04
             * deliveryTime : 2016-12-13
             * orderProductType : 2
             * orderProductStatus : 1
             * productName : 第二个将工序C分配给张三丰20个，老二4个
             * deliveryTimeString : 2016-12-13
             * relFlowProcess : {"isNewRecord":true,"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0"},"target":1000,"processPriority":"0","status":"1","totalCompletedQuantity":73}
             * workPlan : {"isNewRecord":true,"remarks":"xx","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 11:38:42","updateDate":"2017-03-02 11:38:42","planTime":"2017-03-29 11:38:30","worker":{"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"1","priority":"4"}
             * processFeedbackList : []
             * planedAmount : 201
             * processWorkerList : []
             * workPlanList : []
             * companyA : {"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"0"}
             * companyBOwner : {"isNewRecord":true,"name":"张三","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * aconfirmTime : 2017-01-04 15:03:39
             */

            private String id;
            private boolean isNewRecord;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private OrderBean order;
            private CompanyCategoryBean companyCategory;
            private String price;
            private String amount;
            private String productDescription;
            private String aConfirmTime;
            private String deliveryTime;
            private String orderProductType;
            private String orderProductStatus;
            private String productName;
            private String deliveryTimeString;
            private RelFlowProcessBean relFlowProcess;
            private WorkPlanBean workPlan;
            private int planedAmount;
            private CompanyABean companyA;
            private CompanyBOwnerBean companyBOwner;
            private String aconfirmTime;
            private List<?> processFeedbackList;
            private List<?> processWorkerList;
            private List<?> workPlanList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public CreateByBean getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateByBean createBy) {
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

            public OrderBean getOrder() {
                return order;
            }

            public void setOrder(OrderBean order) {
                this.order = order;
            }

            public CompanyCategoryBean getCompanyCategory() {
                return companyCategory;
            }

            public void setCompanyCategory(CompanyCategoryBean companyCategory) {
                this.companyCategory = companyCategory;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getProductDescription() {
                return productDescription;
            }

            public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
            }

            public String getAConfirmTime() {
                return aConfirmTime;
            }

            public void setAConfirmTime(String aConfirmTime) {
                this.aConfirmTime = aConfirmTime;
            }

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public String getOrderProductType() {
                return orderProductType;
            }

            public void setOrderProductType(String orderProductType) {
                this.orderProductType = orderProductType;
            }

            public String getOrderProductStatus() {
                return orderProductStatus;
            }

            public void setOrderProductStatus(String orderProductStatus) {
                this.orderProductStatus = orderProductStatus;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getDeliveryTimeString() {
                return deliveryTimeString;
            }

            public void setDeliveryTimeString(String deliveryTimeString) {
                this.deliveryTimeString = deliveryTimeString;
            }

            public RelFlowProcessBean getRelFlowProcess() {
                return relFlowProcess;
            }

            public void setRelFlowProcess(RelFlowProcessBean relFlowProcess) {
                this.relFlowProcess = relFlowProcess;
            }

            public WorkPlanBean getWorkPlan() {
                return workPlan;
            }

            public void setWorkPlan(WorkPlanBean workPlan) {
                this.workPlan = workPlan;
            }

            public int getPlanedAmount() {
                return planedAmount;
            }

            public void setPlanedAmount(int planedAmount) {
                this.planedAmount = planedAmount;
            }

            public CompanyABean getCompanyA() {
                return companyA;
            }

            public void setCompanyA(CompanyABean companyA) {
                this.companyA = companyA;
            }

            public CompanyBOwnerBean getCompanyBOwner() {
                return companyBOwner;
            }

            public void setCompanyBOwner(CompanyBOwnerBean companyBOwner) {
                this.companyBOwner = companyBOwner;
            }

            public String getAconfirmTime() {
                return aconfirmTime;
            }

            public void setAconfirmTime(String aconfirmTime) {
                this.aconfirmTime = aconfirmTime;
            }

            public List<?> getProcessFeedbackList() {
                return processFeedbackList;
            }

            public void setProcessFeedbackList(List<?> processFeedbackList) {
                this.processFeedbackList = processFeedbackList;
            }

            public List<?> getProcessWorkerList() {
                return processWorkerList;
            }

            public void setProcessWorkerList(List<?> processWorkerList) {
                this.processWorkerList = processWorkerList;
            }

            public List<?> getWorkPlanList() {
                return workPlanList;
            }

            public void setWorkPlanList(List<?> workPlanList) {
                this.workPlanList = workPlanList;
            }

            @Override
            public String toString() {
                return "ResultBean{" +
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
                        ", orderProductStatus='" + orderProductStatus + '\'' +
                        ", productName='" + productName + '\'' +
                        ", deliveryTimeString='" + deliveryTimeString + '\'' +
                        ", relFlowProcess=" + relFlowProcess +
                        ", workPlan=" + workPlan +
                        ", planedAmount=" + planedAmount +
                        ", companyA=" + companyA +
                        ", companyBOwner=" + companyBOwner +
                        ", aconfirmTime='" + aconfirmTime + '\'' +
                        ", processFeedbackList=" + processFeedbackList +
                        ", processWorkerList=" + processWorkerList +
                        ", workPlanList=" + workPlanList +
                        '}';
            }

            public static class CreateByBean implements Serializable {
                /**
                 * id : ae5db71c02d94d6ba5f994319391fcf1
                 * isNewRecord : false
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String loginFlag;
                private boolean admin;
                private String roleNames;
                private List<?> roleList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public List<?> getRoleList() {
                    return roleList;
                }

                public void setRoleList(List<?> roleList) {
                    this.roleList = roleList;
                }

                @Override
                public String toString() {
                    return "CreateByBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", loginFlag='" + loginFlag + '\'' +
                            ", admin=" + admin +
                            ", roleNames='" + roleNames + '\'' +
                            ", roleList=" + roleList +
                            '}';
                }
            }

            public static class OrderBean implements Serializable {
                /**
                 * id : 01302d67478f4027b5aac0225eb1f00a
                 * isNewRecord : false
                 * sort : 30
                 * takeOrderTime : 2016-12-21
                 * takeOrderTimeString : 2016-12-21
                 * delieverTimeString :
                 * orderProductList : []
                 * orderList : []
                 * historyOrderNumber : 0
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private int sort;
                private String takeOrderTime;
                private String takeOrderTimeString;
                private String delieverTimeString;
                private int historyOrderNumber;
                private String parentId;
                private List<?> orderProductList;
                private List<?> orderList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getTakeOrderTime() {
                    return takeOrderTime;
                }

                public void setTakeOrderTime(String takeOrderTime) {
                    this.takeOrderTime = takeOrderTime;
                }

                public String getTakeOrderTimeString() {
                    return takeOrderTimeString;
                }

                public void setTakeOrderTimeString(String takeOrderTimeString) {
                    this.takeOrderTimeString = takeOrderTimeString;
                }

                public String getDelieverTimeString() {
                    return delieverTimeString;
                }

                public void setDelieverTimeString(String delieverTimeString) {
                    this.delieverTimeString = delieverTimeString;
                }

                public int getHistoryOrderNumber() {
                    return historyOrderNumber;
                }

                public void setHistoryOrderNumber(int historyOrderNumber) {
                    this.historyOrderNumber = historyOrderNumber;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getOrderProductList() {
                    return orderProductList;
                }

                public void setOrderProductList(List<?> orderProductList) {
                    this.orderProductList = orderProductList;
                }

                public List<?> getOrderList() {
                    return orderList;
                }

                public void setOrderList(List<?> orderList) {
                    this.orderList = orderList;
                }

                @Override
                public String toString() {
                    return "OrderBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", sort=" + sort +
                            ", takeOrderTime='" + takeOrderTime + '\'' +
                            ", takeOrderTimeString='" + takeOrderTimeString + '\'' +
                            ", delieverTimeString='" + delieverTimeString + '\'' +
                            ", historyOrderNumber=" + historyOrderNumber +
                            ", parentId='" + parentId + '\'' +
                            ", orderProductList=" + orderProductList +
                            ", orderList=" + orderList +
                            '}';
                }
            }

            public static class CompanyCategoryBean implements Serializable {
                /**
                 * id : a09ca24a9cbc4e2783ab22061a6e6062
                 * isNewRecord : false
                 * name : 奥迪
                 * sort : 30
                 * categoryAttributeList : []
                 * relIndustryCompanyCategoryList : []
                 * attributeNames :
                 * parentName :
                 * parentId : 0
                 * industryCategoryIds :
                 * industryCategoryNames :
                 * attributeIds :
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private String attributeNames;
                private String parentName;
                private String parentId;
                private String industryCategoryIds;
                private String industryCategoryNames;
                private String attributeIds;
                private List<?> categoryAttributeList;
                private List<?> relIndustryCompanyCategoryList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getAttributeNames() {
                    return attributeNames;
                }

                public void setAttributeNames(String attributeNames) {
                    this.attributeNames = attributeNames;
                }

                public String getParentName() {
                    return parentName;
                }

                public void setParentName(String parentName) {
                    this.parentName = parentName;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public String getIndustryCategoryIds() {
                    return industryCategoryIds;
                }

                public void setIndustryCategoryIds(String industryCategoryIds) {
                    this.industryCategoryIds = industryCategoryIds;
                }

                public String getIndustryCategoryNames() {
                    return industryCategoryNames;
                }

                public void setIndustryCategoryNames(String industryCategoryNames) {
                    this.industryCategoryNames = industryCategoryNames;
                }

                public String getAttributeIds() {
                    return attributeIds;
                }

                public void setAttributeIds(String attributeIds) {
                    this.attributeIds = attributeIds;
                }

                public List<?> getCategoryAttributeList() {
                    return categoryAttributeList;
                }

                public void setCategoryAttributeList(List<?> categoryAttributeList) {
                    this.categoryAttributeList = categoryAttributeList;
                }

                public List<?> getRelIndustryCompanyCategoryList() {
                    return relIndustryCompanyCategoryList;
                }

                public void setRelIndustryCompanyCategoryList(List<?> relIndustryCompanyCategoryList) {
                    this.relIndustryCompanyCategoryList = relIndustryCompanyCategoryList;
                }

                @Override
                public String toString() {
                    return "CompanyCategoryBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", attributeNames='" + attributeNames + '\'' +
                            ", parentName='" + parentName + '\'' +
                            ", parentId='" + parentId + '\'' +
                            ", industryCategoryIds='" + industryCategoryIds + '\'' +
                            ", industryCategoryNames='" + industryCategoryNames + '\'' +
                            ", attributeIds='" + attributeIds + '\'' +
                            ", categoryAttributeList=" + categoryAttributeList +
                            ", relIndustryCompanyCategoryList=" + relIndustryCompanyCategoryList +
                            '}';
                }
            }

            public static class RelFlowProcessBean implements Serializable {
                /**
                 * isNewRecord : true
                 * flow : {"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]}
                 * process : {"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0"}
                 * target : 1000
                 * processPriority : 0
                 * status : 1
                 * totalCompletedQuantity : 73
                 */

                private boolean isNewRecord;
                private FlowBean flow;
                private ProcessBean process;
                private int target;
                private String processPriority;
                private String status;
                private int totalCompletedQuantity;

                @Override
                public String toString() {
                    return "RelFlowProcessBean{" +
                            "isNewRecord=" + isNewRecord +
                            ", flow=" + flow +
                            ", process=" + process +
                            ", target=" + target +
                            ", processPriority='" + processPriority + '\'' +
                            ", status='" + status + '\'' +
                            ", totalCompletedQuantity=" + totalCompletedQuantity +
                            '}';
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public FlowBean getFlow() {
                    return flow;
                }

                public void setFlow(FlowBean flow) {
                    this.flow = flow;
                }

                public ProcessBean getProcess() {
                    return process;
                }

                public void setProcess(ProcessBean process) {
                    this.process = process;
                }

                public int getTarget() {
                    return target;
                }

                public void setTarget(int target) {
                    this.target = target;
                }

                public String getProcessPriority() {
                    return processPriority;
                }

                public void setProcessPriority(String processPriority) {
                    this.processPriority = processPriority;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public int getTotalCompletedQuantity() {
                    return totalCompletedQuantity;
                }

                public void setTotalCompletedQuantity(int totalCompletedQuantity) {
                    this.totalCompletedQuantity = totalCompletedQuantity;
                }

                public static class FlowBean implements Serializable {
                    /**
                     * id : 87782e91e55c4fb19fda788dfe95ba43
                     * isNewRecord : false
                     * processList : []
                     * remaksList : []
                     */

                    private String id;
                    private boolean isNewRecord;
                    private List<?> processList;
                    private List<?> remaksList;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public List<?> getProcessList() {
                        return processList;
                    }

                    public void setProcessList(List<?> processList) {
                        this.processList = processList;
                    }

                    public List<?> getRemaksList() {
                        return remaksList;
                    }

                    public void setRemaksList(List<?> remaksList) {
                        this.remaksList = remaksList;
                    }

                    @Override
                    public String toString() {
                        return "FlowBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", processList=" + processList +
                                ", remaksList=" + remaksList +
                                '}';
                    }
                }

                public static class ProcessBean implements Serializable {
                    /**
                     * id : f396133570804cc89b95fda4346aee80
                     * isNewRecord : false
                     * sort : 30
                     * relPPList : []
                     * proList : []
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private int sort;
                    private String parentId;
                    private List<?> relPPList;
                    private List<?> proList;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<?> getRelPPList() {
                        return relPPList;
                    }

                    public void setRelPPList(List<?> relPPList) {
                        this.relPPList = relPPList;
                    }

                    public List<?> getProList() {
                        return proList;
                    }

                    public void setProList(List<?> proList) {
                        this.proList = proList;
                    }
                }

            }

            public static class WorkPlanBean implements Serializable {
                /**
                 * isNewRecord : true
                 * remarks : xx
                 * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * createDate : 2017-03-02 11:38:42
                 * updateDate : 2017-03-02 11:38:42
                 * planTime : 2017-03-29 11:38:30
                 * worker : {"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * achieveAmount : 1
                 * priority : 4
                 */

                private boolean isNewRecord;
                private String remarks;
                private CreateByBeanX createBy;
                private String createDate;
                private String updateDate;
                private String planTime;
                private WorkerBean worker;
                private String achieveAmount;
                private String priority;

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public CreateByBeanX getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBeanX createBy) {
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

                public String getPlanTime() {
                    return planTime;
                }

                public void setPlanTime(String planTime) {
                    this.planTime = planTime;
                }

                public WorkerBean getWorker() {
                    return worker;
                }

                public void setWorker(WorkerBean worker) {
                    this.worker = worker;
                }

                public String getAchieveAmount() {
                    return achieveAmount;
                }

                public void setAchieveAmount(String achieveAmount) {
                    this.achieveAmount = achieveAmount;
                }

                public String getPriority() {
                    return priority;
                }

                public void setPriority(String priority) {
                    this.priority = priority;
                }

                public static class CreateByBeanX implements Serializable {
                    /**
                     * id : 4856035c527b419a9cf70d856e65c93b
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
                    private List<?> roleList;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getLoginFlag() {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag) {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }

                    @Override
                    public String toString() {
                        return "CreateByBeanX{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", admin=" + admin +
                                ", roleNames='" + roleNames + '\'' +
                                ", roleList=" + roleList +
                                '}';
                    }
                }

                public static class WorkerBean implements Serializable {
                    /**
                     * isNewRecord : true
                     * name : 张三丰
                     * loginFlag : 1
                     * roleList : []
                     * admin : false
                     * roleNames :
                     */

                    private boolean isNewRecord;
                    private String name;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
                    private List<?> roleList;

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getLoginFlag() {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag) {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                @Override
                public String toString() {
                    return "WorkPlanBean{" +
                            "isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", planTime='" + planTime + '\'' +
                            ", worker=" + worker +
                            ", achieveAmount='" + achieveAmount + '\'' +
                            ", priority='" + priority + '\'' +
                            '}';
                }
            }

            public static class CompanyABean implements Serializable {
                /**
                 * isNewRecord : true
                 * name : 江苏总公司
                 * sort : 30
                 * type : 1
                 * customerServiceList : []
                 * reviewOthers : 0
                 * reviewSelf : 0
                 * otherCosting : 0
                 * otherPayment : 0
                 * otherQuality : 0
                 * otherService : 0
                 * otherTime : 0
                 * selfCosting : 0
                 * selfPayment : 0
                 * serviceCount : 0
                 * parentId : 0
                 */

                private boolean isNewRecord;
                private String name;
                private int sort;
                private String type;
                private int reviewOthers;
                private int reviewSelf;
                private int otherCosting;
                private int otherPayment;
                private int otherQuality;
                private int otherService;
                private int otherTime;
                private int selfCosting;
                private int selfPayment;
                private int serviceCount;
                private String parentId;
                private List<?> customerServiceList;

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getReviewOthers() {
                    return reviewOthers;
                }

                public void setReviewOthers(int reviewOthers) {
                    this.reviewOthers = reviewOthers;
                }

                public int getReviewSelf() {
                    return reviewSelf;
                }

                public void setReviewSelf(int reviewSelf) {
                    this.reviewSelf = reviewSelf;
                }

                public int getOtherCosting() {
                    return otherCosting;
                }

                public void setOtherCosting(int otherCosting) {
                    this.otherCosting = otherCosting;
                }

                public int getOtherPayment() {
                    return otherPayment;
                }

                public void setOtherPayment(int otherPayment) {
                    this.otherPayment = otherPayment;
                }

                public int getOtherQuality() {
                    return otherQuality;
                }

                public void setOtherQuality(int otherQuality) {
                    this.otherQuality = otherQuality;
                }

                public int getOtherService() {
                    return otherService;
                }

                public void setOtherService(int otherService) {
                    this.otherService = otherService;
                }

                public int getOtherTime() {
                    return otherTime;
                }

                public void setOtherTime(int otherTime) {
                    this.otherTime = otherTime;
                }

                public int getSelfCosting() {
                    return selfCosting;
                }

                public void setSelfCosting(int selfCosting) {
                    this.selfCosting = selfCosting;
                }

                public int getSelfPayment() {
                    return selfPayment;
                }

                public void setSelfPayment(int selfPayment) {
                    this.selfPayment = selfPayment;
                }

                public int getServiceCount() {
                    return serviceCount;
                }

                public void setServiceCount(int serviceCount) {
                    this.serviceCount = serviceCount;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getCustomerServiceList() {
                    return customerServiceList;
                }

                public void setCustomerServiceList(List<?> customerServiceList) {
                    this.customerServiceList = customerServiceList;
                }

                @Override
                public String toString() {
                    return "CompanyABean{" +
                            "isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", type='" + type + '\'' +
                            ", reviewOthers=" + reviewOthers +
                            ", reviewSelf=" + reviewSelf +
                            ", otherCosting=" + otherCosting +
                            ", otherPayment=" + otherPayment +
                            ", otherQuality=" + otherQuality +
                            ", otherService=" + otherService +
                            ", otherTime=" + otherTime +
                            ", selfCosting=" + selfCosting +
                            ", selfPayment=" + selfPayment +
                            ", serviceCount=" + serviceCount +
                            ", parentId='" + parentId + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            '}';
                }
            }

            public static class CompanyBOwnerBean implements Serializable {
                /**
                 * isNewRecord : true
                 * name : 张三
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private boolean admin;
                private String roleNames;
                private List<?> roleList;

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLoginFlag() {
                    return loginFlag;
                }

                public void setLoginFlag(String loginFlag) {
                    this.loginFlag = loginFlag;
                }

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }

                public String getRoleNames() {
                    return roleNames;
                }

                public void setRoleNames(String roleNames) {
                    this.roleNames = roleNames;
                }

                public List<?> getRoleList() {
                    return roleList;
                }

                public void setRoleList(List<?> roleList) {
                    this.roleList = roleList;
                }

                @Override
                public String toString() {
                    return "CompanyBOwnerBean{" +
                            "isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", loginFlag='" + loginFlag + '\'' +
                            ", admin=" + admin +
                            ", roleNames='" + roleNames + '\'' +
                            ", roleList=" + roleList +
                            '}';
                }
            }
        }
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
