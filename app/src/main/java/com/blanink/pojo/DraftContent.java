package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * cao gao
 */

public class DraftContent implements Serializable {

    /**
     * errorCode : 00000
     * reason : 通知获取成功！
     * result : {"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"remarks":"萨达撒多","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"office":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司500","sort":30,"type":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四A员工","phone":"1236699563333","fax":"1236699563333","email":"1236699563333","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"李四","loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-04-17 16:06:51","updateDate":"2017-04-17 16:06:51","type":"1","title":"这是草稿呀","files":"","status":"0","readNum":"0","unReadNum":"2","oaNotifyRecordList":[{"id":"9d1d00bb459447f1bbc3d38f2c931435","isNewRecord":false,"oaNotify":{"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"oaNotifyRecordList":[],"self":false,"oaNotifyRecordIds":"","oaNotifyRecordNames":""},"user":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"office":{"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"李四","loginFlag":"1","roleList":[],"roleNames":"","admin":false},"readFlag":"0"},{"id":"ada9acb9d7ef4007a840af568106f9fc","isNewRecord":false,"oaNotify":{"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"oaNotifyRecordList":[],"self":false,"oaNotifyRecordIds":"","oaNotifyRecordNames":""},"user":{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"office":{"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"西西","loginFlag":"1","roleList":[],"roleNames":"","admin":false},"readFlag":"0"}],"self":false,"oaNotifyRecordIds":"447e4526d22045f59ed58250046b3842,8bb75d847a564d29bc2c1cb368fd3af0","oaNotifyRecordNames":"李四,西西"}
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
         * id : 6e4f450822be4097aaf9b1062693c6c3
         * isNewRecord : false
         * remarks : 萨达撒多
         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"office":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司500","sort":30,"type":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四A员工","phone":"1236699563333","fax":"1236699563333","email":"1236699563333","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"李四","loginFlag":"1","roleList":[],"roleNames":"","admin":false}
         * createDate : 2017-04-17 16:06:51
         * updateDate : 2017-04-17 16:06:51
         * type : 1
         * title : 这是草稿呀
         * files :
         * status : 0
         * readNum : 0
         * unReadNum : 2
         * oaNotifyRecordList : [{"id":"9d1d00bb459447f1bbc3d38f2c931435","isNewRecord":false,"oaNotify":{"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"oaNotifyRecordList":[],"self":false,"oaNotifyRecordIds":"","oaNotifyRecordNames":""},"user":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"office":{"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"李四","loginFlag":"1","roleList":[],"roleNames":"","admin":false},"readFlag":"0"},{"id":"ada9acb9d7ef4007a840af568106f9fc","isNewRecord":false,"oaNotify":{"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"oaNotifyRecordList":[],"self":false,"oaNotifyRecordIds":"","oaNotifyRecordNames":""},"user":{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"office":{"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"西西","loginFlag":"1","roleList":[],"roleNames":"","admin":false},"readFlag":"0"}]
         * self : false
         * oaNotifyRecordIds : 447e4526d22045f59ed58250046b3842,8bb75d847a564d29bc2c1cb368fd3af0
         * oaNotifyRecordNames : 李四,西西
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private String type;
        private String title;
        private String content;
        private String files;
        private String status;
        private String readNum;
        private String unReadNum;
        private boolean self;
        private String oaNotifyRecordIds;
        private String oaNotifyRecordNames;
        private List<OaNotifyRecordListBean> oaNotifyRecordList;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFiles() {
            return files;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReadNum() {
            return readNum;
        }

        public void setReadNum(String readNum) {
            this.readNum = readNum;
        }

        public String getUnReadNum() {
            return unReadNum;
        }

        public void setUnReadNum(String unReadNum) {
            this.unReadNum = unReadNum;
        }

        public boolean isSelf() {
            return self;
        }

        public void setSelf(boolean self) {
            this.self = self;
        }

        public String getOaNotifyRecordIds() {
            return oaNotifyRecordIds;
        }

        public void setOaNotifyRecordIds(String oaNotifyRecordIds) {
            this.oaNotifyRecordIds = oaNotifyRecordIds;
        }

        public String getOaNotifyRecordNames() {
            return oaNotifyRecordNames;
        }

        public void setOaNotifyRecordNames(String oaNotifyRecordNames) {
            this.oaNotifyRecordNames = oaNotifyRecordNames;
        }

        public List<OaNotifyRecordListBean> getOaNotifyRecordList() {
            return oaNotifyRecordList;
        }

        public void setOaNotifyRecordList(List<OaNotifyRecordListBean> oaNotifyRecordList) {
            this.oaNotifyRecordList = oaNotifyRecordList;
        }

        public static class CreateByBean {
            /**
             * id : 447e4526d22045f59ed58250046b3842
             * isNewRecord : false
             * office : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司500","sort":30,"type":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四A员工","phone":"1236699563333","fax":"1236699563333","email":"1236699563333","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * name : 李四
             * loginFlag : 1
             * roleList : []
             * roleNames :
             * admin : false
             */

            private String id;
            private boolean isNewRecord;
            private OfficeBean office;
            private String name;
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

            public OfficeBean getOffice() {
                return office;
            }

            public void setOffice(OfficeBean office) {
                this.office = office;
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

            public static class OfficeBean {
                /**
                 * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
                 * isNewRecord : false
                 * name : 浙江总公司500
                 * sort : 30
                 * type : 1
                 * address : 浙江省杭州市
                 * zipCode : 310000
                 * master : 李四A员工
                 * phone : 1236699563333
                 * fax : 1236699563333
                 * email : 1236699563333
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
                private String address;
                private String zipCode;
                private String master;
                private String phone;
                private String fax;
                private String email;
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

        public static class OaNotifyRecordListBean {
            /**
             * id : 9d1d00bb459447f1bbc3d38f2c931435
             * isNewRecord : false
             * oaNotify : {"id":"6e4f450822be4097aaf9b1062693c6c3","isNewRecord":false,"oaNotifyRecordList":[],"self":false,"oaNotifyRecordIds":"","oaNotifyRecordNames":""}
             * user : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"office":{"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"name":"李四","loginFlag":"1","roleList":[],"roleNames":"","admin":false}
             * readFlag : 0
             */

            private String id;
            private boolean isNewRecord;
            private OaNotifyBean oaNotify;
            private UserBean user;
            private String readFlag;

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

            public OaNotifyBean getOaNotify() {
                return oaNotify;
            }

            public void setOaNotify(OaNotifyBean oaNotify) {
                this.oaNotify = oaNotify;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getReadFlag() {
                return readFlag;
            }

            public void setReadFlag(String readFlag) {
                this.readFlag = readFlag;
            }

            public static class OaNotifyBean {
                /**
                 * id : 6e4f450822be4097aaf9b1062693c6c3
                 * isNewRecord : false
                 * oaNotifyRecordList : []
                 * self : false
                 * oaNotifyRecordIds :
                 * oaNotifyRecordNames :
                 */

                private String id;
                private boolean isNewRecord;
                private boolean self;
                private String oaNotifyRecordIds;
                private String oaNotifyRecordNames;
                private List<?> oaNotifyRecordList;

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

                public boolean isSelf() {
                    return self;
                }

                public void setSelf(boolean self) {
                    this.self = self;
                }

                public String getOaNotifyRecordIds() {
                    return oaNotifyRecordIds;
                }

                public void setOaNotifyRecordIds(String oaNotifyRecordIds) {
                    this.oaNotifyRecordIds = oaNotifyRecordIds;
                }

                public String getOaNotifyRecordNames() {
                    return oaNotifyRecordNames;
                }

                public void setOaNotifyRecordNames(String oaNotifyRecordNames) {
                    this.oaNotifyRecordNames = oaNotifyRecordNames;
                }

                public List<?> getOaNotifyRecordList() {
                    return oaNotifyRecordList;
                }

                public void setOaNotifyRecordList(List<?> oaNotifyRecordList) {
                    this.oaNotifyRecordList = oaNotifyRecordList;
                }
            }

            public static class UserBean {
                /**
                 * id : 447e4526d22045f59ed58250046b3842
                 * isNewRecord : false
                 * office : {"isNewRecord":true,"name":"浙江总公司500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
                 * name : 李四
                 * loginFlag : 1
                 * roleList : []
                 * roleNames :
                 * admin : false
                 */

                private String id;
                private boolean isNewRecord;
                private OfficeBeanX office;
                private String name;
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

                public OfficeBeanX getOffice() {
                    return office;
                }

                public void setOffice(OfficeBeanX office) {
                    this.office = office;
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

                public static class OfficeBeanX {
                    /**
                     * isNewRecord : true
                     * name : 浙江总公司500
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
        }
    }
}
