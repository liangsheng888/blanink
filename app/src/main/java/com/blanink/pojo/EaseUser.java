package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class EaseUser {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-15 12:42:51","updateDate":"2017-07-04 18:37:18","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"loginName":"zhang","no":"001","name":"张三丰","email":"","phone":"13384074008","mobile":"","userType":"","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-07-04 18:29:32","loginFlag":"1","photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/PictureUnlock_736e94a250b8e163284d3ff65bbf9738.pictureunlock","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-07-04 18:29:32","isCustomerService":"0","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"remarks":"公司管理员","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:56:21","updateDate":"2017-06-20 21:46:10","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"loginName":"jsadmin","no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"1898995566666","userType":"1","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-07-04 18:36:32","loginFlag":"1","photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/PictureUnlock_75036.pictureunlock","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-07-04 18:36:32","isCustomerService":"1","roleList":[],"admin":false,"roleNames":""}]
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
         * id : b17faaade8754e3eab1bcaba29cb52a8
         * isNewRecord : false
         * remarks :
         * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-02-15 12:42:51
         * updateDate : 2017-07-04 18:37:18
         * company : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"}
         * office : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"}
         * loginName : zhang
         * no : 001
         * name : 张三丰
         * email :
         * phone : 13384074008
         * mobile :
         * userType :
         * loginIp : 0:0:0:0:0:0:0:1
         * loginDate : 2017-07-04 18:29:32
         * loginFlag : 1
         * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/PictureUnlock_736e94a250b8e163284d3ff65bbf9738.pictureunlock
         * oldLoginIp : 0:0:0:0:0:0:0:1
         * oldLoginDate : 2017-07-04 18:29:32
         * isCustomerService : 0
         * roleList : []
         * admin : false
         * roleNames :
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private CompanyBean company;
        private OfficeBean office;
        private String loginName;
        private String no;
        private String name;
        private String email;
        private String phone;
        private String mobile;
        private String userType;
        private String loginIp;
        private String loginDate;
        private String loginFlag;
        private String photo;
        private String oldLoginIp;
        private String oldLoginDate;
        private String isCustomerService;
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

        public CompanyBean getCompany() {
            return company;
        }

        public void setCompany(CompanyBean company) {
            this.company = company;
        }

        public OfficeBean getOffice() {
            return office;
        }

        public void setOffice(OfficeBean office) {
            this.office = office;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getOldLoginIp() {
            return oldLoginIp;
        }

        public void setOldLoginIp(String oldLoginIp) {
            this.oldLoginIp = oldLoginIp;
        }

        public String getOldLoginDate() {
            return oldLoginDate;
        }

        public void setOldLoginDate(String oldLoginDate) {
            this.oldLoginDate = oldLoginDate;
        }

        public String getIsCustomerService() {
            return isCustomerService;
        }

        public void setIsCustomerService(String isCustomerService) {
            this.isCustomerService = isCustomerService;
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

        public static class CompanyBean {
            /**
             * id : f541afa391974409ba680e9bd9a394fd
             * isNewRecord : false
             * parentIds : 0,1,
             * name : 江苏总公司
             * sort : 30
             * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
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
             * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock
             * roleList : []
             * grossProfit : 0
             * pType :
             * places : 0
             * parentId : 1
             */

            private String id;
            private boolean isNewRecord;
            private String parentIds;
            private String name;
            private int sort;
            private AreaBean area;
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

            public static class AreaBean {
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
        }

        public static class OfficeBean {
            /**
             * id : f541afa391974409ba680e9bd9a394fd
             * isNewRecord : false
             * parentIds : 0,1,
             * name : 江苏总公司
             * sort : 30
             * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
             * type : 1
             * serviceType : 1
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
             * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock
             * roleList : []
             * grossProfit : 0
             * pType :
             * places : 0
             * parentId : 1
             */

            private String id;
            private boolean isNewRecord;
            private String parentIds;
            private String name;
            private int sort;
            private AreaBeanX area;
            private String type;
            private String serviceType;
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

            public AreaBeanX getArea() {
                return area;
            }

            public void setArea(AreaBeanX area) {
                this.area = area;
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

            public static class AreaBeanX {
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
        }
    }
}
