package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 * 去单 组合下单
 */
public class GoFormDownOrder implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[{"id":"0a73cc6487cd4335a85486355cbe486e","isNewRecord":false,"companyCategory":{"isNewRecord":true,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryNames":"","industryCategoryIds":"","attributeIds":""},"price":"11","amount":"11","deliveryTime":"2017-05-18","productName":"11","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-05-18","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"parentOrderProductId":"4648c2dfd86c4d9496c68a3086cb570a","bCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""},{"id":"125717b3c1d344d8bdd13a9460c7cfc8","isNewRecord":false,"companyCategory":{"isNewRecord":true,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryNames":"","industryCategoryIds":"","attributeIds":""},"price":"12","amount":"1000","deliveryTime":"2017-05-31","productName":"、。\u2019。","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-05-31","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"parentOrderProductId":"4648c2dfd86c4d9496c68a3086cb570a","bCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""}],"orderList":[],"historyOrderNumber":0,"providerId":"f541afa391974409ba680e9bd9a394fd","providerName":"江苏总公司","parentId":"0"}]
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
         * isNewRecord : true
         * sort : 30
         * takeOrderTimeString :
         * delieverTimeString :
         * orderProductList : [{"id":"0a73cc6487cd4335a85486355cbe486e","isNewRecord":false,"companyCategory":{"isNewRecord":true,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryNames":"","industryCategoryIds":"","attributeIds":""},"price":"11","amount":"11","deliveryTime":"2017-05-18","productName":"11","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-05-18","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"parentOrderProductId":"4648c2dfd86c4d9496c68a3086cb570a","bCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""},{"id":"125717b3c1d344d8bdd13a9460c7cfc8","isNewRecord":false,"companyCategory":{"isNewRecord":true,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryNames":"","industryCategoryIds":"","attributeIds":""},"price":"12","amount":"1000","deliveryTime":"2017-05-31","productName":"、。\u2019。","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-05-31","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"parentOrderProductId":"4648c2dfd86c4d9496c68a3086cb570a","bCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""}]
         * orderList : []
         * historyOrderNumber : 0
         * providerId : f541afa391974409ba680e9bd9a394fd
         * providerName : 江苏总公司
         * parentId : 0
         */

        private boolean isNewRecord;
        private int sort;
        private String takeOrderTimeString;
        private String delieverTimeString;
        private int historyOrderNumber;
        private String providerId;
        private String providerName;
        private String parentId;
        private List<OrderProductListBean> orderProductList;
        private List<?> orderList;

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

        public String getProviderId() {
            return providerId;
        }

        public void setProviderId(String providerId) {
            this.providerId = providerId;
        }

        public String getProviderName() {
            return providerName;
        }

        public void setProviderName(String providerName) {
            this.providerName = providerName;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public List<OrderProductListBean> getOrderProductList() {
            return orderProductList;
        }

        public void setOrderProductList(List<OrderProductListBean> orderProductList) {
            this.orderProductList = orderProductList;
        }

        public List<?> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<?> orderList) {
            this.orderList = orderList;
        }

        public static class OrderProductListBean implements Serializable {
            /**
             * id : 0a73cc6487cd4335a85486355cbe486e
             * isNewRecord : false
             * companyCategory : {"isNewRecord":true,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryNames":"","industryCategoryIds":"","attributeIds":""}
             * price : 11
             * amount : 11
             * deliveryTime : 2017-05-18
             * productName : 11
             * orderProductSpecificationList : []
             * htmlOrderProductSpecificationAttributes :
             * deliveryTimeString : 2017-05-18
             * imageList : []
             * flowRemarkList : []
             * processFeedbackList : []
             * processWorkerList : []
             * workPlanList : []
             * parentOrderProductId : 4648c2dfd86c4d9496c68a3086cb570a
             * bCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * urls :
             */

            private String id;
            private boolean isNewRecord;
            private CompanyCategoryBean companyCategory;
            private String price;
            private String amount;
            private String productDescription;
            private String deliveryTime;
            private String productName;
            private String htmlOrderProductSpecificationAttributes;
            private String deliveryTimeString;
            private String parentOrderProductId;
            private BCompanyBean bCompany;
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

            public String getProductDescription() {
                return productDescription;
            }

            public void setProductDescription(String productDescription) {
                this.productDescription = productDescription;
            }

            public BCompanyBean getbCompany() {
                return bCompany;
            }

            public void setbCompany(BCompanyBean bCompany) {
                this.bCompany = bCompany;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
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

            public String getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(String deliveryTime) {
                this.deliveryTime = deliveryTime;
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

            public String getParentOrderProductId() {
                return parentOrderProductId;
            }

            public void setParentOrderProductId(String parentOrderProductId) {
                this.parentOrderProductId = parentOrderProductId;
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

            public static class CompanyCategoryBean implements Serializable{
                /**
                 * isNewRecord : true
                 * name : TCL
                 * sort : 30
                 * size : 0
                 * categoryAttributeList : []
                 * relIndustryCompanyCategoryList : []
                 * attributeNames :
                 * parentName :
                 * parentId : 0
                 * industryCategoryNames :
                 * industryCategoryIds :
                 * attributeIds :
                 */
                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private int size;
                private String attributeNames;
                private String parentName;
                private String parentId;
                private String industryCategoryNames;
                private String industryCategoryIds;
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

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
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
            }

            public static class BCompanyBean implements Serializable {
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
}
