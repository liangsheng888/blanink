package com.blanink.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */
public class OrderProductAttributes {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"01dd57451aa446088b0fd696bbbdf138","isNewRecord":false,"createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-04-27 13:55:08","updateDate":"2017-05-17 17:14:08","order":{"id":"07f06a4196984a06a36249573d6b7df6","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"},"companyCategory":{"id":"c34ab28047734e5abc123a60872b276e","isNewRecord":false,"name":"北京公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","attributeIds":"","parentName":"","industryCategoryIds":"","industryCategoryNames":""},"price":"40","amount":"300","productDescription":"khljkhljhj卢卡斯就浪蝶狂蜂就绿卡点击","deliveryTime":"2017-04-30","orderProductStatus":"3","orderProductStatusDesc":"甲方已发给乙方","productName":"john-o1-op1-go1","orderProductSpecificationList":[{"id":"f5147790445b41df9a3786f752d0ba5a","isNewRecord":false,"orderProduct":{"id":"01dd57451aa446088b0fd696bbbdf138","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"2acb8207924249d69e7c2ac2be8fe166","isNewRecord":false,"name":"内存","sort":30,"public":false,"parentId":"0"},"attributeValue":"128g","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"内存:128g    ","deliveryTimeString":"2017-04-30","companyAPriority":"3","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"productSn":"john-o1-op1-go1","source":"1","parentOrderProductId":"5b2087b31a5b45cfb3d254beeb5696ed","aCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompany":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""}]
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

    @Override
    public String toString() {
        return "OrderProductAttributes{" +
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * id : 01dd57451aa446088b0fd696bbbdf138
         * isNewRecord : false
         * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false}
         * createDate : 2017-04-27 13:55:08
         * updateDate : 2017-05-17 17:14:08
         * order : {"id":"07f06a4196984a06a36249573d6b7df6","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"}
         * companyCategory : {"id":"c34ab28047734e5abc123a60872b276e","isNewRecord":false,"name":"北京公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","attributeIds":"","parentName":"","industryCategoryIds":"","industryCategoryNames":""}
         * price : 40
         * amount : 300
         * productDescription : khljkhljhj卢卡斯就浪蝶狂蜂就绿卡点击
         * deliveryTime : 2017-04-30
         * orderProductStatus : 3
         * orderProductStatusDesc : 甲方已发给乙方
         * productName : john-o1-op1-go1
         * orderProductSpecificationList : [{"id":"f5147790445b41df9a3786f752d0ba5a","isNewRecord":false,"orderProduct":{"id":"01dd57451aa446088b0fd696bbbdf138","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"2acb8207924249d69e7c2ac2be8fe166","isNewRecord":false,"name":"内存","sort":30,"public":false,"parentId":"0"},"attributeValue":"128g","hardCodeValueList":[]}]
         * htmlOrderProductSpecificationAttributes : 内存:128g    
         * deliveryTimeString : 2017-04-30
         * companyAPriority : 3
         * imageList : []
         * flowRemarkList : []
         * processFeedbackList : []
         * processWorkerList : []
         * workPlanList : []
         * productSn : john-o1-op1-go1
         * source : 1
         * parentOrderProductId : 5b2087b31a5b45cfb3d254beeb5696ed
         * aCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * bCompany : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * urls :
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
        private String deliveryTime;
        private String orderProductStatus;
        private String orderProductStatusDesc;
        private String productName;
        private String htmlOrderProductSpecificationAttributes;
        private String deliveryTimeString;
        private String companyAPriority;
        private String productSn;
        private String source;
        private String parentOrderProductId;
        private ACompanyBean aCompany;
        private BCompanyBean bCompany;
        private String urls;
        private List<OrderProductSpecificationListBean> orderProductSpecificationList;
        private List<?> imageList;
        private List<?> flowRemarkList;
        private List<?> processFeedbackList;
        private List<?> processWorkerList;
        private List<?> workPlanList;

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
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", orderProductStatus='" + orderProductStatus + '\'' +
                    ", orderProductStatusDesc='" + orderProductStatusDesc + '\'' +
                    ", productName='" + productName + '\'' +
                    ", htmlOrderProductSpecificationAttributes='" + htmlOrderProductSpecificationAttributes + '\'' +
                    ", deliveryTimeString='" + deliveryTimeString + '\'' +
                    ", companyAPriority='" + companyAPriority + '\'' +
                    ", productSn='" + productSn + '\'' +
                    ", source='" + source + '\'' +
                    ", parentOrderProductId='" + parentOrderProductId + '\'' +
                    ", aCompany=" + aCompany +
                    ", bCompany=" + bCompany +
                    ", urls='" + urls + '\'' +
                    ", orderProductSpecificationList=" + orderProductSpecificationList +
                    ", imageList=" + imageList +
                    ", flowRemarkList=" + flowRemarkList +
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

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getOrderProductStatus() {
            return orderProductStatus;
        }

        public void setOrderProductStatus(String orderProductStatus) {
            this.orderProductStatus = orderProductStatus;
        }

        public String getOrderProductStatusDesc() {
            return orderProductStatusDesc;
        }

        public void setOrderProductStatusDesc(String orderProductStatusDesc) {
            this.orderProductStatusDesc = orderProductStatusDesc;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getHtmlOrderProductSpecificationAttributes() {
            return htmlOrderProductSpecificationAttributes;
        }

        public void setHtmlOrderProductSpecificationAttributes(String htmlOrderProductSpecificationAttributes) {
            this.htmlOrderProductSpecificationAttributes = htmlOrderProductSpecificationAttributes;
        }

        public String getDeliveryTimeString() {
            return deliveryTimeString;
        }

        public void setDeliveryTimeString(String deliveryTimeString) {
            this.deliveryTimeString = deliveryTimeString;
        }

        public String getCompanyAPriority() {
            return companyAPriority;
        }

        public void setCompanyAPriority(String companyAPriority) {
            this.companyAPriority = companyAPriority;
        }

        public String getProductSn() {
            return productSn;
        }

        public void setProductSn(String productSn) {
            this.productSn = productSn;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getParentOrderProductId() {
            return parentOrderProductId;
        }

        public void setParentOrderProductId(String parentOrderProductId) {
            this.parentOrderProductId = parentOrderProductId;
        }

        public ACompanyBean getACompany() {
            return aCompany;
        }

        public void setACompany(ACompanyBean aCompany) {
            this.aCompany = aCompany;
        }

        public BCompanyBean getBCompany() {
            return bCompany;
        }

        public void setBCompany(BCompanyBean bCompany) {
            this.bCompany = bCompany;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        public List<OrderProductSpecificationListBean> getOrderProductSpecificationList() {
            return orderProductSpecificationList;
        }

        public void setOrderProductSpecificationList(List<OrderProductSpecificationListBean> orderProductSpecificationList) {
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

        public static class CreateByBean {
            /**
             * id : d6c8e9bc4c2b476ba84b962c27882f41
             * isNewRecord : false
             * loginFlag : 1
             * roleList : []
             * roleNames :
             * admin : false
             */

            private String id;
            private boolean isNewRecord;
            private String loginFlag;
            private String roleNames;
            private boolean admin;
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

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public boolean isAdmin() {
                return admin;
            }

            public void setAdmin(boolean admin) {
                this.admin = admin;
            }

            public List<?> getRoleList() {
                return roleList;
            }

            public void setRoleList(List<?> roleList) {
                this.roleList = roleList;
            }
        }

        public static class OrderBean {
            /**
             * id : 07f06a4196984a06a36249573d6b7df6
             * isNewRecord : false
             * sort : 30
             * takeOrderTimeString :
             * delieverTimeString :
             * orderProductList : []
             * orderList : []
             * historyOrderNumber : 0
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private int sort;
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
        }

        public static class CompanyCategoryBean {
            /**
             * id : c34ab28047734e5abc123a60872b276e
             * isNewRecord : false
             * name : 北京公司手机
             * sort : 30
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentId : 0
             * attributeIds :
             * parentName :
             * industryCategoryIds :
             * industryCategoryNames :
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private int size;
            private String attributeNames;
            private String parentId;
            private String attributeIds;
            private String parentName;
            private String industryCategoryIds;
            private String industryCategoryNames;
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

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getAttributeNames() {
                return attributeNames;
            }

            public void setAttributeNames(String attributeNames) {
                this.attributeNames = attributeNames;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getAttributeIds() {
                return attributeIds;
            }

            public void setAttributeIds(String attributeIds) {
                this.attributeIds = attributeIds;
            }

            public String getParentName() {
                return parentName;
            }

            public void setParentName(String parentName) {
                this.parentName = parentName;
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
        }

        public static class ACompanyBean {
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
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

        public static class BCompanyBean {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
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

        public static class OrderProductSpecificationListBean {
            /**
             * id : f5147790445b41df9a3786f752d0ba5a
             * isNewRecord : false
             * orderProduct : {"id":"01dd57451aa446088b0fd696bbbdf138","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""}
             * attribute : {"id":"2acb8207924249d69e7c2ac2be8fe166","isNewRecord":false,"name":"内存","sort":30,"public":false,"parentId":"0"}
             * attributeValue : 128g
             * hardCodeValueList : []
             */

            private String id;
            private boolean isNewRecord;
            private OrderProductBean orderProduct;
            private AttributeBean attribute;
            private String attributeValue;
            private List<?> hardCodeValueList;

            @Override
            public String toString() {
                return "OrderProductSpecificationListBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", orderProduct=" + orderProduct +
                        ", attribute=" + attribute +
                        ", attributeValue='" + attributeValue + '\'' +
                        ", hardCodeValueList=" + hardCodeValueList +
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

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public AttributeBean getAttribute() {
                return attribute;
            }

            public void setAttribute(AttributeBean attribute) {
                this.attribute = attribute;
            }

            public String getAttributeValue() {
                return attributeValue;
            }

            public void setAttributeValue(String attributeValue) {
                this.attributeValue = attributeValue;
            }

            public List<?> getHardCodeValueList() {
                return hardCodeValueList;
            }

            public void setHardCodeValueList(List<?> hardCodeValueList) {
                this.hardCodeValueList = hardCodeValueList;
            }

            public static class OrderProductBean {
                /**
                 * id : 01dd57451aa446088b0fd696bbbdf138
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

            public static class AttributeBean {
                /**
                 * id : 2acb8207924249d69e7c2ac2be8fe166
                 * isNewRecord : false
                 * name : 内存
                 * sort : 30
                 * public : false
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                @SerializedName("public")
                private boolean publicX;
                private String parentId;

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

                public boolean isPublicX() {
                    return publicX;
                }

                public void setPublicX(boolean publicX) {
                    this.publicX = publicX;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }
        }
    }
}
