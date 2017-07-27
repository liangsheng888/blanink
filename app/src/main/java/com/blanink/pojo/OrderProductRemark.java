package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public class OrderProductRemark implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"01ccacfe5ab347c396a0a974160055a0","isNewRecord":false,"createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-31 13:32:31","updateDate":"2017-03-31 13:32:31","orderProduct":{"id":"13ca69d4c53c4a7c8185f5929cbc93b5","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"sender":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"name":"张三","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"senderCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"comments":"迟发","type":"2"},{"id":"146a898c34ca43e68c882f6c3ba3108d","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-05-25 14:12:38","updateDate":"2017-05-25 14:12:38","orderProduct":{"id":"13ca69d4c53c4a7c8185f5929cbc93b5","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"sender":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"comments":"dddddd","type":"2"}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 01ccacfe5ab347c396a0a974160055a0
         * isNewRecord : false
         * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-03-31 13:32:31
         * updateDate : 2017-03-31 13:32:31
         * orderProduct : {"id":"13ca69d4c53c4a7c8185f5929cbc93b5","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""}
         * sender : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"name":"张三","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * senderCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * comments : 迟发
         * type : 2
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private OrderProductBean orderProduct;
        private SenderBean sender;
        private SenderCompanyBean senderCompany;
        private String comments;
        private String type;

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

        public OrderProductBean getOrderProduct() {
            return orderProduct;
        }

        public void setOrderProduct(OrderProductBean orderProduct) {
            this.orderProduct = orderProduct;
        }

        public SenderBean getSender() {
            return sender;
        }

        public void setSender(SenderBean sender) {
            this.sender = sender;
        }

        public SenderCompanyBean getSenderCompany() {
            return senderCompany;
        }

        public void setSenderCompany(SenderCompanyBean senderCompany) {
            this.senderCompany = senderCompany;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class CreateByBean {
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
        }

        public static class OrderProductBean {
            /**
             * id : 13ca69d4c53c4a7c8185f5929cbc93b5
             * isNewRecord : false
             * orderProductSpecificationList : []
             * htmlOrderProductSpecificationAttributes :
             * imageList : []
             * flowRemarkList : []
             * processFeedbackList : []
             * processWorkerList : []
             * workPlanList : []
             * urls :
             */

            private String id;
            private boolean isNewRecord;
            private String htmlOrderProductSpecificationAttributes;
            private String urls;
            private List<?> orderProductSpecificationList;
            private List<?> imageList;
            private List<?> flowRemarkList;
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

            public String getHtmlOrderProductSpecificationAttributes() {
                return htmlOrderProductSpecificationAttributes;
            }

            public void setHtmlOrderProductSpecificationAttributes(String htmlOrderProductSpecificationAttributes) {
                this.htmlOrderProductSpecificationAttributes = htmlOrderProductSpecificationAttributes;
            }

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }

            public List<?> getOrderProductSpecificationList() {
                return orderProductSpecificationList;
            }

            public void setOrderProductSpecificationList(List<?> orderProductSpecificationList) {
                this.orderProductSpecificationList = orderProductSpecificationList;
            }

            public List<?> getImageList() {
                return imageList;
            }

            public void setImageList(List<?> imageList) {
                this.imageList = imageList;
            }

            public List<?> getFlowRemarkList() {
                return flowRemarkList;
            }

            public void setFlowRemarkList(List<?> flowRemarkList) {
                this.flowRemarkList = flowRemarkList;
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

        public static class SenderBean {
            /**
             * id : d6c8e9bc4c2b476ba84b962c27882f41
             * isNewRecord : false
             * name : 张三
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

        public static class SenderCompanyBean {
            /**
             * id : f541afa391974409ba680e9bd9a394fd
             * isNewRecord : false
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
             * parentId : 0
             */

            private String id;
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
            private String photo;
            private int grossProfit;
            private String pType;
            private String parentId;
            private List<?> customerServiceList;
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

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getGrossProfit() {
                return grossProfit;
            }

            public void setGrossProfit(int grossProfit) {
                this.grossProfit = grossProfit;
            }

            public String getPType() {
                return pType;
            }

            public void setPType(String pType) {
                this.pType = pType;
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

            public List<?> getRoleList() {
                return roleList;
            }

            public void setRoleList(List<?> roleList) {
                this.roleList = roleList;
            }
        }
    }
}
