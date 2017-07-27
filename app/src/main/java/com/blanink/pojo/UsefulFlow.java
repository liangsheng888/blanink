package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 * 常用流程
 */

public class UsefulFlow  implements Serializable{

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"total":1,"rows":[{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 10:56:15","updateDate":"2017-03-16 18:18:34","orderProduct":{"id":"0082c7d7b13d49be9cb1bd27103f528a","isNewRecord":false,"processFeedbackList":[],"processWorkerList":[],"workPlanList":[]},"company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"status":"1","isCommon":"1","name":"第二个将工序C分配给张三丰20个，老二4个","flowData":"{\"transitions\":{\"be091cd5cdbc4b778494d54c870e7add\":\"84fd0bf593f9402a8e1d96daf7b34816\",\"84fd0bf593f9402a8e1d96daf7b34816\":\"f396133570804cc89b95fda4346aee80\",\"f396133570804cc89b95fda4346aee80\":\"a3a9942bbd0845be8e18fc7fe2d88db7\"},\"names\":{\"be091cd5cdbc4b778494d54c870e7add\":\"工序A\",\"f396133570804cc89b95fda4346aee80\":\"工序二d\",\"84fd0bf593f9402a8e1d96daf7b34816\":\"工序二e\",\"a3a9942bbd0845be8e18fc7fe2d88db7\":\"工序C\"},\"positions\":{\"be091cd5cdbc4b778494d54c870e7add\":{\"top\":65.4188461303711,\"left\":8.996509552001953},\"f396133570804cc89b95fda4346aee80\":{\"top\":79.41535949707031,\"left\":450.9947814941406},\"84fd0bf593f9402a8e1d96daf7b34816\":{\"top\":77.41710662841797,\"left\":250.99476623535156},\"a3a9942bbd0845be8e18fc7fe2d88db7\":{\"top\":75.42757415771484,\"left\":675.9860229492188}},\"container\":\"workflow-2\"}","internalDeliveryDate":1490756075000,"processList":[],"remaksList":[{"id":"e42d0a3ac256441baf03aa098ba51d0e","isNewRecord":false,"remarks":"%E9%99%84%E8%BF%91%E7%9A%84%E6%B2%99%E5%8F%91","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-24 16:28:07","flow":{"id":"cc242b91ad1b452cbc3c55f0232c6176","isNewRecord":false,"processList":[],"remaksList":[]}}]}]}
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

    @Override
    public String toString() {
        return "UsefulFlow{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * total : 1
         * rows : [{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 10:56:15","updateDate":"2017-03-16 18:18:34","orderProduct":{"id":"0082c7d7b13d49be9cb1bd27103f528a","isNewRecord":false,"processFeedbackList":[],"processWorkerList":[],"workPlanList":[]},"company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"status":"1","isCommon":"1","name":"第二个将工序C分配给张三丰20个，老二4个","flowData":"{\"transitions\":{\"be091cd5cdbc4b778494d54c870e7add\":\"84fd0bf593f9402a8e1d96daf7b34816\",\"84fd0bf593f9402a8e1d96daf7b34816\":\"f396133570804cc89b95fda4346aee80\",\"f396133570804cc89b95fda4346aee80\":\"a3a9942bbd0845be8e18fc7fe2d88db7\"},\"names\":{\"be091cd5cdbc4b778494d54c870e7add\":\"工序A\",\"f396133570804cc89b95fda4346aee80\":\"工序二d\",\"84fd0bf593f9402a8e1d96daf7b34816\":\"工序二e\",\"a3a9942bbd0845be8e18fc7fe2d88db7\":\"工序C\"},\"positions\":{\"be091cd5cdbc4b778494d54c870e7add\":{\"top\":65.4188461303711,\"left\":8.996509552001953},\"f396133570804cc89b95fda4346aee80\":{\"top\":79.41535949707031,\"left\":450.9947814941406},\"84fd0bf593f9402a8e1d96daf7b34816\":{\"top\":77.41710662841797,\"left\":250.99476623535156},\"a3a9942bbd0845be8e18fc7fe2d88db7\":{\"top\":75.42757415771484,\"left\":675.9860229492188}},\"container\":\"workflow-2\"}","internalDeliveryDate":1490756075000,"processList":[],"remaksList":[{"id":"e42d0a3ac256441baf03aa098ba51d0e","isNewRecord":false,"remarks":"%E9%99%84%E8%BF%91%E7%9A%84%E6%B2%99%E5%8F%91","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-24 16:28:07","flow":{"id":"cc242b91ad1b452cbc3c55f0232c6176","isNewRecord":false,"processList":[],"remaksList":[]}}]}]
         */

        private int total;
        private List<RowsBean> rows;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean implements Serializable {
            /**
             * id : 87782e91e55c4fb19fda788dfe95ba43
             * isNewRecord : false
             * remarks :
             * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-03-02 10:56:15
             * updateDate : 2017-03-16 18:18:34
             * orderProduct : {"id":"0082c7d7b13d49be9cb1bd27103f528a","isNewRecord":false,"processFeedbackList":[],"processWorkerList":[],"workPlanList":[]}
             * company : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"}
             * status : 1
             * isCommon : 1
             * name : 第二个将工序C分配给张三丰20个，老二4个
             * flowData : {"transitions":{"be091cd5cdbc4b778494d54c870e7add":"84fd0bf593f9402a8e1d96daf7b34816","84fd0bf593f9402a8e1d96daf7b34816":"f396133570804cc89b95fda4346aee80","f396133570804cc89b95fda4346aee80":"a3a9942bbd0845be8e18fc7fe2d88db7"},"names":{"be091cd5cdbc4b778494d54c870e7add":"工序A","f396133570804cc89b95fda4346aee80":"工序二d","84fd0bf593f9402a8e1d96daf7b34816":"工序二e","a3a9942bbd0845be8e18fc7fe2d88db7":"工序C"},"positions":{"be091cd5cdbc4b778494d54c870e7add":{"top":65.4188461303711,"left":8.996509552001953},"f396133570804cc89b95fda4346aee80":{"top":79.41535949707031,"left":450.9947814941406},"84fd0bf593f9402a8e1d96daf7b34816":{"top":77.41710662841797,"left":250.99476623535156},"a3a9942bbd0845be8e18fc7fe2d88db7":{"top":75.42757415771484,"left":675.9860229492188}},"container":"workflow-2"}
             * internalDeliveryDate : 1490756075000
             * processList : []
             * remaksList : [{"id":"e42d0a3ac256441baf03aa098ba51d0e","isNewRecord":false,"remarks":"%E9%99%84%E8%BF%91%E7%9A%84%E6%B2%99%E5%8F%91","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-24 16:28:07","flow":{"id":"cc242b91ad1b452cbc3c55f0232c6176","isNewRecord":false,"processList":[],"remaksList":[]}}]
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private OrderProductBean orderProduct;
            private CompanyBean company;
            private String status;
            private String isCommon;
            private String name;
            private String flowData;
            private String internalDeliveryDate;
            private List<?> processList;
            private List<?> orderProducts;
            private List<RemaksListBean> remaksList;

            @Override
            public String toString() {
                return "RowsBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", orderProduct=" + orderProduct +
                        ", company=" + company +
                        ", status='" + status + '\'' +
                        ", isCommon='" + isCommon + '\'' +
                        ", name='" + name + '\'' +
                        ", flowData='" + flowData + '\'' +
                        ", internalDeliveryDate=" + internalDeliveryDate +
                        ", processList=" + processList +
                        ", remaksList=" + remaksList +
                        '}';
            }

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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
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

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIsCommon() {
                return isCommon;
            }

            public void setIsCommon(String isCommon) {
                this.isCommon = isCommon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFlowData() {
                return flowData;
            }

            public void setFlowData(String flowData) {
                this.flowData = flowData;
            }

            public List<?> getProcessList() {
                return processList;
            }

            public void setProcessList(List<?> processList) {
                this.processList = processList;
            }

            public List<RemaksListBean> getRemaksList() {
                return remaksList;
            }

            public void setRemaksList(List<RemaksListBean> remaksList) {
                this.remaksList = remaksList;
            }

            public static class CreateByBean implements Serializable {
                /**
                 * id : d6c8e9bc4c2b476ba84b962c27882f41
                 * isNewRecord : false
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private boolean admin;
                private String roleNames;
                private List<?> roleList;

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
            }

            public static class OrderProductBean  implements Serializable{
                /**
                 * id : 0082c7d7b13d49be9cb1bd27103f528a
                 * isNewRecord : false
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 */

                private String id;
                private boolean isNewRecord;
                private List<?> processFeedbackList;
                private List<?> processWorkerList;
                private List<?> workPlanList;

                @Override
                public String toString() {
                    return "OrderProductBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", processFeedbackList=" + processFeedbackList +
                            ", processWorkerList=" + processWorkerList +
                            ", workPlanList=" + workPlanList +
                            '}';
                }

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
            }

            public static class CompanyBean implements Serializable {
                /**
                 * id : f541afa391974409ba680e9bd9a394fd
                 * isNewRecord : false
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
                 * grossProfit : 0
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
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
                private int grossProfit;
                private String photo;
                private List<?> roleList;
                private String parentId;
                private List<?> customerServiceList;

                @Override
                public String toString() {
                    return "CompanyBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
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
                            ", grossProfit=" + grossProfit +
                            ", parentId='" + parentId + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            '}';
                }

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

                public int getGrossProfit() {
                    return grossProfit;
                }

                public void setGrossProfit(int grossProfit) {
                    this.grossProfit = grossProfit;
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
            }

            public static class RemaksListBean  implements Serializable{
                /**
                 * id : e42d0a3ac256441baf03aa098ba51d0e
                 * isNewRecord : false
                 * remarks : %E9%99%84%E8%BF%91%E7%9A%84%E6%B2%99%E5%8F%91
                 * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * createDate : 2017-02-24 16:28:07
                 * flow : {"id":"cc242b91ad1b452cbc3c55f0232c6176","isNewRecord":false,"processList":[],"remaksList":[]}
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBeanX createBy;
                private String createDate;
                private FlowBean flow;

                @Override
                public String toString() {
                    return "RemaksListBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", flow=" + flow +
                            '}';
                }

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

                public FlowBean getFlow() {
                    return flow;
                }

                public void setFlow(FlowBean flow) {
                    this.flow = flow;
                }

                public static class CreateByBeanX implements Serializable{
                    /**
                     * id : 4856035c527b419a9cf70d856e65c93b
                     * isNewRecord : false
                     * name : dongdong
                     * loginFlag : 1
                     * roleList : []
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String name;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "CreateByBeanX{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", name='" + name + '\'' +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", admin=" + admin +
                                ", roleNames='" + roleNames + '\'' +
                                ", roleList=" + roleList +
                                '}';
                    }

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

                public static class FlowBean implements Serializable {
                    /**
                     * id : cc242b91ad1b452cbc3c55f0232c6176
                     * isNewRecord : false
                     * processList : []
                     * remaksList : []
                     */

                    private String id;
                    private boolean isNewRecord;
                    private List<?> processList;
                    private List<?> remaksList;

                    @Override
                    public String toString() {
                        return "FlowBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", processList=" + processList +
                                ", remaksList=" + remaksList +
                                '}';
                    }

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
                }
            }
        }
    }
}
