package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class Stock {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"total":3,"rows":[{"id":"301ad6ba64df4e3c86cbd5b20cebf5c5","isNewRecord":false,"remarks":"图我现在在","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-09 18:35:54","updateDate":"2017-08-14 19:38:59","name":"11111111","procuteNumber":"2000","companyCategoryId":{"id":"6d364bec5b324391944fb3f36b63023e","isNewRecord":false,"name":"大声道","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"1","unit":"5555","stok":305,"unitPrice":"555"},{"id":"c60cfcb42e6b4c4eb77a692e10b3e743","isNewRecord":false,"remarks":"阿斯顿发","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-14 19:14:29","updateDate":"2017-08-14 19:38:59","name":"mike111","procuteNumber":"wkkk","companyCategoryId":{"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"2","unit":"个","stok":20,"unitPrice":"20"},{"id":"f91b8b7a0ed24426b8fb010843618aa5","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-14 16:57:28","updateDate":"2017-08-14 19:38:59","name":"20*30*40","procuteNumber":"yl002","companyCategoryId":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"1","unit":"吨","stok":120,"unitPrice":"5600"}]}
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

    public static class ResultBean {
        /**
         * total : 3
         * rows : [{"id":"301ad6ba64df4e3c86cbd5b20cebf5c5","isNewRecord":false,"remarks":"图我现在在","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-09 18:35:54","updateDate":"2017-08-14 19:38:59","name":"11111111","procuteNumber":"2000","companyCategoryId":{"id":"6d364bec5b324391944fb3f36b63023e","isNewRecord":false,"name":"大声道","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"1","unit":"5555","stok":305,"unitPrice":"555"},{"id":"c60cfcb42e6b4c4eb77a692e10b3e743","isNewRecord":false,"remarks":"阿斯顿发","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-14 19:14:29","updateDate":"2017-08-14 19:38:59","name":"mike111","procuteNumber":"wkkk","companyCategoryId":{"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"2","unit":"个","stok":20,"unitPrice":"20"},{"id":"f91b8b7a0ed24426b8fb010843618aa5","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""},"createDate":"2017-08-14 16:57:28","updateDate":"2017-08-14 19:38:59","name":"20*30*40","procuteNumber":"yl002","companyCategoryId":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""},"companyId":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},"inventoryType":"1","unit":"吨","stok":120,"unitPrice":"5600"}]
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

        public static class RowsBean implements Serializable{
            /**
             * id : 301ad6ba64df4e3c86cbd5b20cebf5c5
             * isNewRecord : false
             * remarks : 图我现在在
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","mobileMenuList":[],"roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-08-09 18:35:54
             * updateDate : 2017-08-14 19:38:59
             * name : 11111111
             * procuteNumber : 2000
             * companyCategoryId : {"id":"6d364bec5b324391944fb3f36b63023e","isNewRecord":false,"name":"大声道","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryIds":"","industryCategoryNames":"","parentName":"","parentId":"0","attributeIds":""}
             * companyId : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}
             * inventoryType : 1
             * unit : 5555
             * stok : 305
             * unitPrice : 555
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private String name;
            private String procuteNumber;
            private CompanyCategoryIdBean companyCategoryId;
            private CompanyIdBean companyId;
            private String inventoryType;
            private String unit;
            private int stok;
            private int changeAmount;
            private String inOut;
            private String unitPrice;

            public String getId() {
                return id;
            }

            public int getChangeAmount() {
                return changeAmount;
            }

            public String getInOut() {
                return inOut;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProcuteNumber() {
                return procuteNumber;
            }

            public void setProcuteNumber(String procuteNumber) {
                this.procuteNumber = procuteNumber;
            }

            public CompanyCategoryIdBean getCompanyCategoryId() {
                return companyCategoryId;
            }

            public void setCompanyCategoryId(CompanyCategoryIdBean companyCategoryId) {
                this.companyCategoryId = companyCategoryId;
            }

            public CompanyIdBean getCompanyId() {
                return companyId;
            }

            public void setCompanyId(CompanyIdBean companyId) {
                this.companyId = companyId;
            }

            public String getInventoryType() {
                return inventoryType;
            }

            public void setInventoryType(String inventoryType) {
                this.inventoryType = inventoryType;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getStok() {
                return stok;
            }

            public void setStok(int stok) {
                this.stok = stok;
            }

            public String getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(String unitPrice) {
                this.unitPrice = unitPrice;
            }

            public static class CreateByBean implements Serializable {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * loginFlag : 1
                 * mobileMenuList : []
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String loginFlag;
                private boolean admin;
                private String roleNames;
                private List<?> mobileMenuList;
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

                public List<?> getMobileMenuList() {
                    return mobileMenuList;
                }

                public void setMobileMenuList(List<?> mobileMenuList) {
                    this.mobileMenuList = mobileMenuList;
                }

                public List<?> getRoleList() {
                    return roleList;
                }

                public void setRoleList(List<?> roleList) {
                    this.roleList = roleList;
                }
            }

            public static class CompanyCategoryIdBean implements Serializable {
                /**
                 * id : 6d364bec5b324391944fb3f36b63023e
                 * isNewRecord : false
                 * name : 大声道
                 * sort : 30
                 * size : 0
                 * categoryAttributeList : []
                 * relIndustryCompanyCategoryList : []
                 * attributeNames :
                 * industryCategoryIds :
                 * industryCategoryNames :
                 * parentName :
                 * parentId : 0
                 * attributeIds :
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private int size;
                private String attributeNames;
                private String industryCategoryIds;
                private String industryCategoryNames;
                private String parentName;
                private String parentId;
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

            public static class CompanyIdBean implements Serializable {
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
                 * places : 0
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
                private int places;
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

                public int getPlaces() {
                    return places;
                }

                public void setPlaces(int places) {
                    this.places = places;
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
