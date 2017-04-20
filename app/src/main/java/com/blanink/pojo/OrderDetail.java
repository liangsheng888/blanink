package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 * 订单详情
 */

public class OrderDetail implements Serializable {


    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"total":1,"rows":[{"id":"a3404c72ea2a49138fda9554c12ed8f6","isNewRecord":false,"createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-21 14:47:28","updateDate":"2017-02-21 14:47:28","order":{"id":"0257a8d8b68742b3a44240c0a415559d","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"},"companyCategory":{"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"company":{"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentId":"0"},"price":"11","amount":"22","productDescription":"1111","deliveryTime":"2017-02-23","orderProductStatus":"14","productName":"222","deliveryTimeString":"2017-02-23","companyAPriority":"5","processFeedbackList":[],"processWorkerList":[],"workPlanList":[]}]}
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

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
         * rows : [{"id":"a3404c72ea2a49138fda9554c12ed8f6","isNewRecord":false,"createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-21 14:47:28","updateDate":"2017-02-21 14:47:28","order":{"id":"0257a8d8b68742b3a44240c0a415559d","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"},"companyCategory":{"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"company":{"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentId":"0"},"price":"11","amount":"22","productDescription":"1111","deliveryTime":"2017-02-23","orderProductStatus":"14","productName":"222","deliveryTimeString":"2017-02-23","companyAPriority":"5","processFeedbackList":[],"processWorkerList":[],"workPlanList":[]}]
         */

        private int total;
        private List<RowsBean> rows;

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
             * id : a3404c72ea2a49138fda9554c12ed8f6
             * isNewRecord : false
             * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-02-21 14:47:28
             * updateDate : 2017-02-21 14:47:28
             * order : {"id":"0257a8d8b68742b3a44240c0a415559d","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"}
             * companyCategory : {"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"company":{"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":"","parentId":"0"}
             * price : 11
             * amount : 22
             * productDescription : 1111
             * deliveryTime : 2017-02-23
             * orderProductStatus : 14
             * productName : 222
             * deliveryTimeString : 2017-02-23
             * companyAPriority : 5
             * processFeedbackList : []
             * processWorkerList : []
             * workPlanList : []
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
            private String productName;
            private String deliveryTimeString;
            private String companyAPriority;
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

            public String getCompanyAPriority() {
                return companyAPriority;
            }

            public void setCompanyAPriority(String companyAPriority) {
                this.companyAPriority = companyAPriority;
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

            public static class OrderBean  implements Serializable{
                /**
                 * id : 0257a8d8b68742b3a44240c0a415559d
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

            public static class CompanyCategoryBean implements Serializable {
                /**
                 * id : a09ca24a9cbc4e2783ab22061a6e6062
                 * isNewRecord : false
                 * name : 奥迪
                 * sort : 30
                 * company : {"isNewRecord":true,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"}
                 * size : 0
                 * categoryAttributeList : []
                 * relIndustryCompanyCategoryList : []
                 * attributeNames :
                 * parentName :
                 * industryCategoryIds :
                 * industryCategoryNames :
                 * attributeIds :
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private CompanyBean company;
                private int size;
                private String attributeNames;
                private String parentName;
                private String industryCategoryIds;
                private String industryCategoryNames;
                private String attributeIds;
                private String parentId;
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

                public static class CompanyBean  implements Serializable{
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
                     * grossProfit : 0
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
                    private int grossProfit;
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
            }
        }
    }
}
