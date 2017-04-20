package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class Office implements Serializable {

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
         * id : 8beffe31efe24a6981b6fc3db337b357
         * isNewRecord : false
         * remarks : sssss
         * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false}
         * createDate : 2017-01-12 11:59:53
         * updateDate : 2017-01-12 11:59:53
         * parentIds : 0,
         * name : SSS
         * sort : 30
         * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
         * code : 100000001002
         * scope : 范德萨范德萨发大水
         * shortName : ssssss
         * registTime : 2017-04-21 16:17:44
         * type : 1
         * serviceType : 1
         * grade : 1
         * address : 范德萨范德萨
         * zipCode : 100085
         * master : C员工
         * phone : 555555
         * fax : 00000
         * email : linghuchong
         * useable : 1
         * createCompanyBy : {"id":"","isNewRecord":true,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * customerServiceList : []
         * homepage : ssssssssss
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
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private String parentIds;
        private String name;
        private int sort;
        private AreaBean area;
        private String code;
        private String scope;
        private String shortName;
        private String registTime;
        private String type;
        private String serviceType;
        private String grade;
        private String address;
        private String zipCode;
        private String master;
        private String phone;
        private String fax;
        private String email;
        private String useable;
        private CreateCompanyByBean createCompanyBy;
        private String homepage;
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

        public String getParentIds() {
            return parentIds;
        }

        public void setParentIds(String parentIds) {
            this.parentIds = parentIds;
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

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getRegistTime() {
            return registTime;
        }

        public void setRegistTime(String registTime) {
            this.registTime = registTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUseable() {
            return useable;
        }

        public void setUseable(String useable) {
            this.useable = useable;
        }

        public CreateCompanyByBean getCreateCompanyBy() {
            return createCompanyBy;
        }

        public void setCreateCompanyBy(CreateCompanyByBean createCompanyBy) {
            this.createCompanyBy = createCompanyBy;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
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

        public static class CreateByBean implements Serializable {
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

        public static class AreaBean implements Serializable{
            /**
             * id : 12
             * isNewRecord : false
             * parentIds : 0,1
             * name : 江苏省
             * sort : 30
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String parentIds;
            private String name;
            private int sort;
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

            public String getParentIds() {
                return parentIds;
            }

            public void setParentIds(String parentIds) {
                this.parentIds = parentIds;
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

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }
        }

        public static class CreateCompanyByBean implements Serializable {
            /**
             * id :
             * isNewRecord : true
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
