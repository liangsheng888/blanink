package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 * 进度
 */
public class OrderProgress implements Serializable {

    /**
     * errorCode : 00000
     * reason : 保存数据成功！
     * result : [{"id":"6c57048a31e741a3810e37440903032d","isNewRecord":false,"remarks":"注意休息","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-06 15:48:00","updateDate":"2017-06-15 18:51:28","order":{"id":"9b753091be574cd78aaabc518e06edd2","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"company":{"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryNames":"","industryCategoryIds":""},"price":"8999999","amount":"899999","productDescription":"注意休息","isAConfirm":"1","aConfirmTime":"2017-06-06","deliveryTime":"2017-06-06","orderProductType":"1","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"我想问一下","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-06-06","companyAPriority":"0","companyAPriorityDesc":"","companyBPriority":"0","companyBPriorityDesc":"","images":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75923.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75922.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75918.pictureunlock","imageList":[],"innerDeliveryTime":1496678400000,"innerDeliveryTimeString":"2017-06-06","flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"productSn":"2808996666","source":"2","aCompany":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompany":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":"","flow":{"id":"989b622b852140de8c45cf74d2136c08","isNewRecord":false,"remarks":"顶顶顶","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-14 11:22:57","updateDate":"2017-06-15 18:51:28","orderProduct":{"id":"6c57048a31e741a3810e37440903032d","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"status":"2","isCommon":"1","name":"d顶顶顶","flowData":"{\"transitions\":{\"8869e39f4be4457287054a344b200759\":\"462b527ae9694c239363e32c46d6969b\",\"462b527ae9694c239363e32c46d6969b\":\"38ac68dffa2c4700ac3491812bea5116\",\"38ac68dffa2c4700ac3491812bea5116\":\"1a9090dd4dbe4808a921900d7b64db01\"},\"names\":{\"8869e39f4be4457287054a344b200759\":\"浙江公司工序A(888999)\",\"38ac68dffa2c4700ac3491812bea5116\":\"浙江公司工序B(888999)\",\"462b527ae9694c239363e32c46d6969b\":\"浙江公司工序C(888999)\",\"1a9090dd4dbe4808a921900d7b64db01\":\"发货(888999)\"},\"positions\":{\"8869e39f4be4457287054a344b200759\":{\"top\":85,\"left\":0},\"38ac68dffa2c4700ac3491812bea5116\":{\"top\":406,\"left\":184},\"462b527ae9694c239363e32c46d6969b\":{\"top\":181,\"left\":330},\"1a9090dd4dbe4808a921900d7b64db01\":{\"top\":328,\"left\":524}},\"container\":\"workflow-2\"}","internalDeliveryDate":1497369600000,"processList":[],"orderProducts":[],"remaksList":[]},"aconfirmTime":"2017-06-06 16:14:04"}]
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
         * id : 6c57048a31e741a3810e37440903032d
         * isNewRecord : false
         * remarks : 注意休息
         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-06-06 15:48:00
         * updateDate : 2017-06-15 18:51:28
         * order : {"id":"9b753091be574cd78aaabc518e06edd2","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
         * companyCategory : {"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"company":{"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryNames":"","industryCategoryIds":""}
         * price : 8999999
         * amount : 899999
         * productDescription : 注意休息
         * isAConfirm : 1
         * aConfirmTime : 2017-06-06
         * deliveryTime : 2017-06-06
         * orderProductType : 1
         * orderProductStatus : 9
         * orderProductStatusDesc : 流程已发布
         * productName : 我想问一下
         * orderProductSpecificationList : []
         * htmlOrderProductSpecificationAttributes :
         * deliveryTimeString : 2017-06-06
         * companyAPriority : 0
         * companyAPriorityDesc :
         * companyBPriority : 0
         * companyBPriorityDesc :
         * images : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75923.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75922.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75918.pictureunlock
         * imageList : []
         * innerDeliveryTime : 1496678400000
         * innerDeliveryTimeString : 2017-06-06
         * flowRemarkList : []
         * processFeedbackList : []
         * processWorkerList : []
         * workPlanList : []
         * productSn : 2808996666
         * source : 2
         * aCompany : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * bCompany : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * urls :
         * flow : {"id":"989b622b852140de8c45cf74d2136c08","isNewRecord":false,"remarks":"顶顶顶","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-14 11:22:57","updateDate":"2017-06-15 18:51:28","orderProduct":{"id":"6c57048a31e741a3810e37440903032d","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"status":"2","isCommon":"1","name":"d顶顶顶","flowData":"{\"transitions\":{\"8869e39f4be4457287054a344b200759\":\"462b527ae9694c239363e32c46d6969b\",\"462b527ae9694c239363e32c46d6969b\":\"38ac68dffa2c4700ac3491812bea5116\",\"38ac68dffa2c4700ac3491812bea5116\":\"1a9090dd4dbe4808a921900d7b64db01\"},\"names\":{\"8869e39f4be4457287054a344b200759\":\"浙江公司工序A(888999)\",\"38ac68dffa2c4700ac3491812bea5116\":\"浙江公司工序B(888999)\",\"462b527ae9694c239363e32c46d6969b\":\"浙江公司工序C(888999)\",\"1a9090dd4dbe4808a921900d7b64db01\":\"发货(888999)\"},\"positions\":{\"8869e39f4be4457287054a344b200759\":{\"top\":85,\"left\":0},\"38ac68dffa2c4700ac3491812bea5116\":{\"top\":406,\"left\":184},\"462b527ae9694c239363e32c46d6969b\":{\"top\":181,\"left\":330},\"1a9090dd4dbe4808a921900d7b64db01\":{\"top\":328,\"left\":524}},\"container\":\"workflow-2\"}","internalDeliveryDate":1497369600000,"processList":[],"orderProducts":[],"remaksList":[]}
         * aconfirmTime : 2017-06-06 16:14:04
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
        private String images;
        private String innerDeliveryTime;
        private String innerDeliveryTimeString;
        private String productSn;
        private String source;
        private ACompanyBean aCompany;
        private BCompanyBean bCompany;
        private String urls;
        private FlowBean flow;
        private String aconfirmTime;
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

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }


        public String getInnerDeliveryTimeString() {
            return innerDeliveryTimeString;
        }

        public void setInnerDeliveryTimeString(String innerDeliveryTimeString) {
            this.innerDeliveryTimeString = innerDeliveryTimeString;
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

        public FlowBean getFlow() {
            return flow;
        }

        public void setFlow(FlowBean flow) {
            this.flow = flow;
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
             * id : 9b753091be574cd78aaabc518e06edd2
             * isNewRecord : false
             * sort : 30
             * takeOrderTimeString :
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
             * company : {"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentId : 0
             * parentName :
             * attributeIds :
             * industryCategoryNames :
             * industryCategoryIds :
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private CompanyBean company;
            private int size;
            private String attributeNames;
            private String parentId;
            private String parentName;
            private String attributeIds;
            private String industryCategoryNames;
            private String industryCategoryIds;
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

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
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

            public String getIndustryCategoryNames() {
                return industryCategoryNames;
            }

            public void setIndustryCategoryNames(String industryCategoryNames) {
                this.industryCategoryNames = industryCategoryNames;
            }

            public String getIndustryCategoryIds() {
                return industryCategoryIds;
            }

            public void setIndustryCategoryIds(String industryCategoryIds) {
                this.industryCategoryIds = industryCategoryIds;
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

            public static class CompanyBean implements Serializable {
                /**
                 * isNewRecord : true
                 * name : 浙江总公司
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

        public static class BCompanyBean implements Serializable{
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

        public static class FlowBean implements Serializable{
            /**
             * id : 989b622b852140de8c45cf74d2136c08
             * isNewRecord : false
             * remarks : 顶顶顶
             * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-06-14 11:22:57
             * updateDate : 2017-06-15 18:51:28
             * orderProduct : {"id":"6c57048a31e741a3810e37440903032d","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""}
             * company : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * status : 2
             * isCommon : 1
             * name : d顶顶顶
             * flowData : {"transitions":{"8869e39f4be4457287054a344b200759":"462b527ae9694c239363e32c46d6969b","462b527ae9694c239363e32c46d6969b":"38ac68dffa2c4700ac3491812bea5116","38ac68dffa2c4700ac3491812bea5116":"1a9090dd4dbe4808a921900d7b64db01"},"names":{"8869e39f4be4457287054a344b200759":"浙江公司工序A(888999)","38ac68dffa2c4700ac3491812bea5116":"浙江公司工序B(888999)","462b527ae9694c239363e32c46d6969b":"浙江公司工序C(888999)","1a9090dd4dbe4808a921900d7b64db01":"发货(888999)"},"positions":{"8869e39f4be4457287054a344b200759":{"top":85,"left":0},"38ac68dffa2c4700ac3491812bea5116":{"top":406,"left":184},"462b527ae9694c239363e32c46d6969b":{"top":181,"left":330},"1a9090dd4dbe4808a921900d7b64db01":{"top":328,"left":524}},"container":"workflow-2"}
             * internalDeliveryDate : 1497369600000
             * processList : []
             * orderProducts : []
             * remaksList : []
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanX createBy;
            private String createDate;
            private String updateDate;
            private OrderProductBean orderProduct;
            private CompanyBeanX company;
            private String status;
            private String isCommon;
            private String name;
            private String flowData;
            private String internalDeliveryDate;
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

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public CompanyBeanX getCompany() {
                return company;
            }

            public void setCompany(CompanyBeanX company) {
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

            public static class CreateByBeanX implements Serializable {
                /**
                 * id : 447e4526d22045f59ed58250046b3842
                 * isNewRecord : false
                 * name : 李四
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

            public static class OrderProductBean implements Serializable {
                /**
                 * id : 6c57048a31e741a3810e37440903032d
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

            public static class CompanyBeanX implements Serializable {
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
}
