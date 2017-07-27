package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 * 历史反馈
 */

public class WorkedTask implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"62299d624a294b0787e52a4f8cec3f25","isNewRecord":false,"remarks":"兔崽子我","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-06 15:47:35","updateDate":"2017-06-14 13:50:42","order":{"id":"1c91eb51f65640888e13f8562d28792b","isNewRecord":false,"sort":30,"takeOrderTime":"2017-06-06","takeOrderTimeString":"2017-06-06","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","attributeIds":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":""},"price":"8899","amount":"888999","productDescription":"兔崽子我","isAConfirm":"1","aConfirmTime":"2017-06-08","deliveryTime":"2017-06-06","orderProductType":"1","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"兔崽子我4555","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-06-06","companyAPriority":"0","companyAPriorityDesc":"","companyBPriority":"0","companyBPriorityDesc":"","imageList":[],"innerDeliveryTime":1496678400000,"innerDeliveryTimeString":"2017-06-06","relFlowProcess":{"isNewRecord":true,"flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":888999,"processPriority":"2","status":"2"},"finishedAmount":10,"processFeedback":{"isNewRecord":true,"createDate":"2017-06-15 15:30:42","faultAmount":10,"resources":[],"target":0,"feedbackAttachmentStr":"","urls":""},"allFinishedAmount":120,"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"companyA":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyBOwner":{"isNewRecord":true,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"productSn":"123356666","source":"2","aCompany":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompany":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":"","aconfirmTime":"2017-06-08 23:17:42"}]
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

    public static class ResultBean implements Serializable {
        /**
         * id : 62299d624a294b0787e52a4f8cec3f25
         * isNewRecord : false
         * remarks : 兔崽子我
         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-06-06 15:47:35
         * updateDate : 2017-06-14 13:50:42
         * order : {"id":"1c91eb51f65640888e13f8562d28792b","isNewRecord":false,"sort":30,"takeOrderTime":"2017-06-06","takeOrderTimeString":"2017-06-06","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
         * companyCategory : {"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","attributeIds":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":""}
         * price : 8899
         * amount : 888999
         * productDescription : 兔崽子我
         * isAConfirm : 1
         * aConfirmTime : 2017-06-08
         * deliveryTime : 2017-06-06
         * orderProductType : 1
         * orderProductStatus : 9
         * orderProductStatusDesc : 流程已发布
         * productName : 兔崽子我4555
         * orderProductSpecificationList : []
         * htmlOrderProductSpecificationAttributes :
         * deliveryTimeString : 2017-06-06
         * companyAPriority : 0
         * companyAPriorityDesc :
         * companyBPriority : 0
         * companyBPriorityDesc :
         * imageList : []
         * innerDeliveryTime : 1496678400000
         * innerDeliveryTimeString : 2017-06-06
         * relFlowProcess : {"isNewRecord":true,"flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":888999,"processPriority":"2","status":"2"}
         * finishedAmount : 10
         * processFeedback : {"isNewRecord":true,"createDate":"2017-06-15 15:30:42","faultAmount":10,"resources":[],"target":0,"feedbackAttachmentStr":"","urls":""}
         * allFinishedAmount : 120
         * flowRemarkList : []
         * processFeedbackList : []
         * processWorkerList : []
         * workPlanList : []
         * companyA : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * companyBOwner : {"isNewRecord":true,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * productSn : 123356666
         * source : 2
         * aCompany : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * bCompany : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * urls :
         * aconfirmTime : 2017-06-08 23:17:42
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private OrderBean order;
        private CompanyCategoryBean companyCategory;
        private String price;
        private String amount;
        private String productDescription;
        private String isAConfirm;
        private String aConfirmTime;
        private String deliveryTime;
        private String orderProductType;
        private String orderProductStatus;
        private String orderProductStatusDesc;
        private String productName;
        private String htmlOrderProductSpecificationAttributes;
        private String deliveryTimeString;
        private String companyAPriority;
        private String companyAPriorityDesc;
        private String companyBPriority;
        private String companyBPriorityDesc;
        private String innerDeliveryTime;
        private String innerDeliveryTimeString;
        private RelFlowProcessBean relFlowProcess;
        private int finishedAmount;
        private ProcessFeedbackBean processFeedback;
        private int allFinishedAmount;
        private CompanyABean companyA;
        private CompanyBOwnerBean companyBOwner;
        private String productSn;
        private String source;
        private ACompanyBean aCompany;
        private BCompanyBean bCompany;
        private String urls;
        private String aconfirmTime;
        private List<?> orderProductSpecificationList;
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
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", order=" + order +
                    ", companyCategory=" + companyCategory +
                    ", price='" + price + '\'' +
                    ", amount='" + amount + '\'' +
                    ", productDescription='" + productDescription + '\'' +
                    ", isAConfirm='" + isAConfirm + '\'' +
                    ", aConfirmTime='" + aConfirmTime + '\'' +
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", orderProductType='" + orderProductType + '\'' +
                    ", orderProductStatus='" + orderProductStatus + '\'' +
                    ", orderProductStatusDesc='" + orderProductStatusDesc + '\'' +
                    ", productName='" + productName + '\'' +
                    ", htmlOrderProductSpecificationAttributes='" + htmlOrderProductSpecificationAttributes + '\'' +
                    ", deliveryTimeString='" + deliveryTimeString + '\'' +
                    ", companyAPriority='" + companyAPriority + '\'' +
                    ", companyAPriorityDesc='" + companyAPriorityDesc + '\'' +
                    ", companyBPriority='" + companyBPriority + '\'' +
                    ", companyBPriorityDesc='" + companyBPriorityDesc + '\'' +
                    ", innerDeliveryTime=" + innerDeliveryTime +
                    ", innerDeliveryTimeString='" + innerDeliveryTimeString + '\'' +
                    ", relFlowProcess=" + relFlowProcess +
                    ", finishedAmount=" + finishedAmount +
                    ", processFeedback=" + processFeedback +
                    ", allFinishedAmount=" + allFinishedAmount +
                    ", companyA=" + companyA +
                    ", companyBOwner=" + companyBOwner +
                    ", productSn='" + productSn + '\'' +
                    ", source='" + source + '\'' +
                    ", aCompany=" + aCompany +
                    ", bCompany=" + bCompany +
                    ", urls='" + urls + '\'' +
                    ", aconfirmTime='" + aconfirmTime + '\'' +
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

        public String getIsAConfirm() {
            return isAConfirm;
        }

        public void setIsAConfirm(String isAConfirm) {
            this.isAConfirm = isAConfirm;
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

        public String getCompanyAPriorityDesc() {
            return companyAPriorityDesc;
        }

        public void setCompanyAPriorityDesc(String companyAPriorityDesc) {
            this.companyAPriorityDesc = companyAPriorityDesc;
        }

        public String getCompanyBPriority() {
            return companyBPriority;
        }

        public void setCompanyBPriority(String companyBPriority) {
            this.companyBPriority = companyBPriority;
        }

        public String getCompanyBPriorityDesc() {
            return companyBPriorityDesc;
        }

        public void setCompanyBPriorityDesc(String companyBPriorityDesc) {
            this.companyBPriorityDesc = companyBPriorityDesc;
        }

        public String getInnerDeliveryTimeString() {
            return innerDeliveryTimeString;
        }

        public void setInnerDeliveryTimeString(String innerDeliveryTimeString) {
            this.innerDeliveryTimeString = innerDeliveryTimeString;
        }

        public RelFlowProcessBean getRelFlowProcess() {
            return relFlowProcess;
        }

        public void setRelFlowProcess(RelFlowProcessBean relFlowProcess) {
            this.relFlowProcess = relFlowProcess;
        }

        public int getFinishedAmount() {
            return finishedAmount;
        }

        public void setFinishedAmount(int finishedAmount) {
            this.finishedAmount = finishedAmount;
        }

        public ProcessFeedbackBean getProcessFeedback() {
            return processFeedback;
        }

        public void setProcessFeedback(ProcessFeedbackBean processFeedback) {
            this.processFeedback = processFeedback;
        }

        public int getAllFinishedAmount() {
            return allFinishedAmount;
        }

        public void setAllFinishedAmount(int allFinishedAmount) {
            this.allFinishedAmount = allFinishedAmount;
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

        public String getAconfirmTime() {
            return aconfirmTime;
        }

        public void setAconfirmTime(String aconfirmTime) {
            this.aconfirmTime = aconfirmTime;
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

        public static class CreateByBean implements Serializable {
            /**
             * id : 447e4526d22045f59ed58250046b3842
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

        public static class OrderBean implements Serializable {
            /**
             * id : 1c91eb51f65640888e13f8562d28792b
             * isNewRecord : false
             * sort : 30
             * takeOrderTime : 2017-06-06
             * takeOrderTimeString : 2017-06-06
             * delieverTimeString :
             * orderProductList : []
             * orderList : []
             * historyOrderNumber : 0
             * takeOrderTimeBeginString :
             * takeOrderTimeEndString :
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private int sort;
            private String takeOrderTime;
            private String takeOrderTimeString;
            private String delieverTimeString;
            private int historyOrderNumber;
            private String takeOrderTimeBeginString;
            private String takeOrderTimeEndString;
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

            public String getTakeOrderTimeBeginString() {
                return takeOrderTimeBeginString;
            }

            public void setTakeOrderTimeBeginString(String takeOrderTimeBeginString) {
                this.takeOrderTimeBeginString = takeOrderTimeBeginString;
            }

            public String getTakeOrderTimeEndString() {
                return takeOrderTimeEndString;
            }

            public void setTakeOrderTimeEndString(String takeOrderTimeEndString) {
                this.takeOrderTimeEndString = takeOrderTimeEndString;
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

        public static class CompanyCategoryBean implements Serializable {
            /**
             * id : e1cd97176f354f6f8933443cdef9933f
             * isNewRecord : false
             * name : 浙江公司手机
             * sort : 30
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentName :
             * attributeIds :
             * parentId : 0
             * industryCategoryIds :
             * industryCategoryNames :
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private int size;
            private String attributeNames;
            private String parentName;
            private String attributeIds;
            private String parentId;
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

            public String getParentName() {
                return parentName;
            }

            public void setParentName(String parentName) {
                this.parentName = parentName;
            }

            public String getAttributeIds() {
                return attributeIds;
            }

            public void setAttributeIds(String attributeIds) {
                this.attributeIds = attributeIds;
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

        public static class RelFlowProcessBean implements Serializable {
            /**
             * isNewRecord : true
             * flow : {"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
             * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"}
             * target : 888999
             * processPriority : 2
             * status : 2
             */

            private boolean isNewRecord;
            private FlowBean flow;
            private ProcessBean process;
            private int totalCompletedQuantity;
            private int target;
            private String processPriority;
            private String status;

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public int getTotalCompletedQuantity() {
                return totalCompletedQuantity;
            }

            public void setTotalCompletedQuantity(int totalCompletedQuantity) {
                this.totalCompletedQuantity = totalCompletedQuantity;
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

            public static class FlowBean implements Serializable {
                /**
                 * id : 2695060d06604c7e98f007e06592d22b
                 * isNewRecord : false
                 * processList : []
                 * orderProducts : []
                 * remaksList : []
                 */

                private String id;
                private boolean isNewRecord;
                private List<?> processList;
                private List<?> orderProducts;
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

                public List<?> getOrderProducts() {
                    return orderProducts;
                }

                public void setOrderProducts(List<?> orderProducts) {
                    this.orderProducts = orderProducts;
                }

                public List<?> getRemaksList() {
                    return remaksList;
                }

                public void setRemaksList(List<?> remaksList) {
                    this.remaksList = remaksList;
                }
            }

            public static class ProcessBean implements Serializable {
                /**
                 * id : 1a9090dd4dbe4808a921900d7b64db01
                 * isNewRecord : false
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * positionNames : []
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private int sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;
                private List<?> positionNames;

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

                public List<?> getPositionNames() {
                    return positionNames;
                }

                public void setPositionNames(List<?> positionNames) {
                    this.positionNames = positionNames;
                }
            }
        }

        public static class ProcessFeedbackBean implements Serializable {
            /**
             * isNewRecord : true
             * createDate : 2017-06-15 15:30:42
             * faultAmount : 10
             * resources : []
             * target : 0
             * feedbackAttachmentStr :
             * urls :
             */
            private String id;
            private boolean isNewRecord;
            private String createDate;
            private int faultAmount;
            private int target;
            private String feedbackAttachmentStr;
            private int achieveAmount;
            private int confirmAmount;
            private String urls;
            private List<?> resources;

            @Override
            public String toString() {
                return "ProcessFeedbackBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", createDate='" + createDate + '\'' +
                        ", faultAmount=" + faultAmount +
                        ", target=" + target +
                        ", feedbackAttachmentStr='" + feedbackAttachmentStr + '\'' +
                        ", achieveAmount=" + achieveAmount +
                        ", confirmAmount=" + confirmAmount +
                        ", urls='" + urls + '\'' +
                        ", resources=" + resources +
                        '}';
            }

            public int getConfirmAmount() {
                return confirmAmount;
            }

            public void setConfirmAmount(int confirmAmount) {
                this.confirmAmount = confirmAmount;
            }

            public int getAchieveAmount() {
                return achieveAmount;
            }

            public void setAchieveAmount(int achieveAmount) {
                this.achieveAmount = achieveAmount;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getFaultAmount() {
                return faultAmount;
            }

            public void setFaultAmount(int faultAmount) {
                this.faultAmount = faultAmount;
            }

            public int getTarget() {
                return target;
            }

            public void setTarget(int target) {
                this.target = target;
            }

            public String getFeedbackAttachmentStr() {
                return feedbackAttachmentStr;
            }

            public void setFeedbackAttachmentStr(String feedbackAttachmentStr) {
                this.feedbackAttachmentStr = feedbackAttachmentStr;
            }

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }

            public List<?> getResources() {
                return resources;
            }

            public void setResources(List<?> resources) {
                this.resources = resources;
            }
        }

        public static class CompanyABean implements Serializable {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
             * isNewRecord : false
             * name : 北京总公司
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

            @Override
            public String toString() {
                return "CompanyABean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
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
                        ", photo='" + photo + '\'' +
                        ", grossProfit=" + grossProfit +
                        ", pType='" + pType + '\'' +
                        ", parentId='" + parentId + '\'' +
                        ", customerServiceList=" + customerServiceList +
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

        public static class CompanyBOwnerBean implements Serializable {
            /**
             * isNewRecord : true
             * name : 李四
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

        public static class ACompanyBean implements Serializable {
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

        public static class BCompanyBean implements Serializable {
            /**
             * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
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
    }
}