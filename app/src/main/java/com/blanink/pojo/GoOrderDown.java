package com.blanink.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 * 去单已下单
 */
public class GoOrderDown implements Serializable {


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

    public static class ResultBean implements Serializable{
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

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private int sort;
            private ACompanyOrderOwnerUserBean aCompanyOrderOwnerUser;
            private BCompanyBean bCompany;
            private String aOrderNumber;
            private String orderStatus;
            private String takeOrderTime;
            private String takeOrderTimeString;
            private String delieverTimeString;
            private int historyOrderNumber;
            private String parentId;
            private List<OrderProductListBean> orderProductList;
            private List<?> orderList;

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public BCompanyBean getbCompany() {
                return bCompany;
            }

            public void setbCompany(BCompanyBean bCompany) {
                this.bCompany = bCompany;
            }

            public ACompanyOrderOwnerUserBean getaCompanyOrderOwnerUser() {
                return aCompanyOrderOwnerUser;
            }

            public void setaCompanyOrderOwnerUser(ACompanyOrderOwnerUserBean aCompanyOrderOwnerUser) {
                this.aCompanyOrderOwnerUser = aCompanyOrderOwnerUser;
            }

            public String getaOrderNumber() {
                return aOrderNumber;
            }

            public void setaOrderNumber(String aOrderNumber) {
                this.aOrderNumber = aOrderNumber;
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

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public ACompanyOrderOwnerUserBean getACompanyOrderOwnerUser() {
                return aCompanyOrderOwnerUser;
            }

            public void setACompanyOrderOwnerUser(ACompanyOrderOwnerUserBean aCompanyOrderOwnerUser) {
                this.aCompanyOrderOwnerUser = aCompanyOrderOwnerUser;
            }

            public BCompanyBean getBCompany() {
                return bCompany;
            }

            public void setBCompany(BCompanyBean bCompany) {
                this.bCompany = bCompany;
            }

            public String getAOrderNumber() {
                return aOrderNumber;
            }

            public void setAOrderNumber(String aOrderNumber) {
                this.aOrderNumber = aOrderNumber;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
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

            public static class ACompanyOrderOwnerUserBean implements Serializable{
                /**
                 * id : b17faaade8754e3eab1bcaba29cb52a8
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
                private String name;
                private List<?> roleList;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

            public static class BCompanyBean implements Serializable {
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

            public static class OrderProductListBean implements Serializable{
                /**
                 * id : acbe0e7036094e49ba0db45a53933d73
                 * isNewRecord : false
                 * order : {"id":"f0a4e90099ef46e2817d866daa36b107","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"}
                 * companyCategory : {"isNewRecord":true,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""}
                 * price : 2
                 * amount : 2
                 * deliveryTime : 2017-05-31
                 * orderProductStatus : 4
                 * orderProductStatusDesc : 乙方自己已创建
                 * productName : js-bj-o1-p1
                 * orderProductSpecificationList : [{"id":"304a680a7225456db379acb9a8f5c52f","isNewRecord":false,"orderProduct":{"id":"acbe0e7036094e49ba0db45a53933d73","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"},"attributeValue":"js-bj-o1-p1js-bj-o1-p1js-bj-o1-p1","hardCodeValueList":[]},{"id":"db5b61f90f3c4dc0800631a89d345e80","isNewRecord":false,"orderProduct":{"id":"acbe0e7036094e49ba0db45a53933d73","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"292c2053b9c54bd684cc9ce2e5789df0","isNewRecord":false,"name":"颜色","sort":30,"public":false,"parentId":"0"},"attributeValue":"黑色","hardCodeValueList":[]},{"id":"9d72bfbef24a4c838f34e9f10a18c0ef","isNewRecord":false,"orderProduct":{"id":"acbe0e7036094e49ba0db45a53933d73","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"b8b0228502a344989522d603bdc15035","isNewRecord":false,"name":"品牌","sort":30,"public":false,"parentId":"0"},"attributeValue":"js-bj-o1-p1","hardCodeValueList":[]},{"id":"3d11233a83eb470fa4e6f9189b8ab1e2","isNewRecord":false,"orderProduct":{"id":"acbe0e7036094e49ba0db45a53933d73","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"js-bj-o1-p1","hardCodeValueList":[]}]
                 * htmlOrderProductSpecificationAttributes : 容量:js-bj-o1-p1js-bj-o1-p1js-bj-o1-p1    颜色:黑色    品牌:js-bj-o1-p1    尺寸:js-bj-o1-p1    
                 * deliveryTimeString : 2017-05-31
                 * imageList : []
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * source : 2
                 * reviewFinish : 0
                 * urls :
                 */

                private String id;
                private boolean isNewRecord;
                private OrderBean order;
                private CompanyCategoryBean companyCategory;
                private String price;
                private String amount;
                private String deliveryTime;
                private String orderProductStatus;
                private String orderProductStatusDesc;
                private String productName;
                private String htmlOrderProductSpecificationAttributes;
                private String deliveryTimeString;
                private String source;
                private String reviewFinish;
                private String urls;
                private List<OrderProductSpecificationListBean> orderProductSpecificationList;
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

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getReviewFinish() {
                    return reviewFinish;
                }

                public void setReviewFinish(String reviewFinish) {
                    this.reviewFinish = reviewFinish;
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

                public static class OrderBean implements Serializable {
                    /**
                     * id : f0a4e90099ef46e2817d866daa36b107
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
                     * isNewRecord : true
                     * name : TCL
                     * sort : 30
                     * size : 0
                     * categoryAttributeList : []
                     * relIndustryCompanyCategoryList : []
                     * attributeNames :
                     * parentId : 0
                     * parentName :
                     * industryCategoryIds :
                     * industryCategoryNames :
                     * attributeIds :
                     */

                    private boolean isNewRecord;
                    private String name;
                    private int sort;
                    private int size;
                    private String attributeNames;
                    private String parentId;
                    private String parentName;
                    private String industryCategoryIds;
                    private String industryCategoryNames;
                    private String attributeIds;
                    private List<?> categoryAttributeList;
                    private List<?> relIndustryCompanyCategoryList;

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

                public static class OrderProductSpecificationListBean implements Serializable {
                    /**
                     * id : 304a680a7225456db379acb9a8f5c52f
                     * isNewRecord : false
                     * orderProduct : {"id":"acbe0e7036094e49ba0db45a53933d73","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""}
                     * attribute : {"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"}
                     * attributeValue : js-bj-o1-p1js-bj-o1-p1js-bj-o1-p1
                     * hardCodeValueList : []
                     */

                    private String id;
                    private boolean isNewRecord;
                    private OrderProductBean orderProduct;
                    private AttributeBean attribute;
                    private String attributeValue;
                    private List<?> hardCodeValueList;

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

                    public static class OrderProductBean implements Serializable {
                        /**
                         * id : acbe0e7036094e49ba0db45a53933d73
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

                    public static class AttributeBean implements Serializable{
                        /**
                         * id : 267a9460de74443cb8d292aac1b2e0ab
                         * isNewRecord : false
                         * name : 容量
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
    }
}
