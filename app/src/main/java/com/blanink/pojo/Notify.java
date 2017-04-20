package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class Notify implements Serializable {


    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"total":2,"rows":[{"id":"e8409d12ba0d40a3abe5dafe1895cb5d","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-01 15:22:04","updateDate":"2017-04-01 16:24:24","type":"6","title":"您的申请答复","content":"您的客户申请已同意","status":"1","readNum":"0","unReadNum":"1","readFlag":"0","referrenceObjectId":"5043d70ef6f24c229cae0d42093e64e8","oaNotifyRecordList":[],"oaNotifyRecordIds":"","oaNotifyRecordNames":"","self":false},{"id":"7d8304de2ef941e49ebeee744bb9db64","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-01 15:22:04","updateDate":"2017-04-01 15:23:03","type":"6","title":"您的申请答复","content":"您的客户申请已同意","status":"1","readNum":"0","unReadNum":"1","readFlag":"0","referrenceObjectId":"5043d70ef6f24c229cae0d42093e64e8","oaNotifyRecordList":[],"oaNotifyRecordIds":"","oaNotifyRecordNames":"","self":false}]}
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
         * total : 2
         * rows : [{"id":"e8409d12ba0d40a3abe5dafe1895cb5d","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-01 15:22:04","updateDate":"2017-04-01 16:24:24","type":"6","title":"您的申请答复","content":"您的客户申请已同意","status":"1","readNum":"0","unReadNum":"1","readFlag":"0","referrenceObjectId":"5043d70ef6f24c229cae0d42093e64e8","oaNotifyRecordList":[],"oaNotifyRecordIds":"","oaNotifyRecordNames":"","self":false},{"id":"7d8304de2ef941e49ebeee744bb9db64","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-01 15:22:04","updateDate":"2017-04-01 15:23:03","type":"6","title":"您的申请答复","content":"您的客户申请已同意","status":"1","readNum":"0","unReadNum":"1","readFlag":"0","referrenceObjectId":"5043d70ef6f24c229cae0d42093e64e8","oaNotifyRecordList":[],"oaNotifyRecordIds":"","oaNotifyRecordNames":"","self":false}]
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

        public static class RowsBean {
            /**
             * id : e8409d12ba0d40a3abe5dafe1895cb5d
             * isNewRecord : false
             * createBy : {"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-04-01 15:22:04
             * updateDate : 2017-04-01 16:24:24
             * type : 6
             * title : 您的申请答复
             * content : 您的客户申请已同意
             * status : 1
             * readNum : 0
             * unReadNum : 1
             * readFlag : 0
             * referrenceObjectId : 5043d70ef6f24c229cae0d42093e64e8
             * oaNotifyRecordList : []
             * oaNotifyRecordIds :
             * oaNotifyRecordNames :
             * self : false
             */

            private String id;
            private boolean isNewRecord;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private String type;
            private String title;
            private String content;
            private String status;
            private String readNum;
            private String unReadNum;
            private String readFlag;
            private String referrenceObjectId;
            private String oaNotifyRecordIds;
            private String oaNotifyRecordNames;
            private boolean self;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public String getReadFlag() {
                return readFlag;
            }

            public void setReadFlag(String readFlag) {
                this.readFlag = readFlag;
            }

            public String getReferrenceObjectId() {
                return referrenceObjectId;
            }

            public void setReferrenceObjectId(String referrenceObjectId) {
                this.referrenceObjectId = referrenceObjectId;
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

            public boolean isSelf() {
                return self;
            }

            public void setSelf(boolean self) {
                this.self = self;
            }

            public List<?> getOaNotifyRecordList() {
                return oaNotifyRecordList;
            }

            public void setOaNotifyRecordList(List<?> oaNotifyRecordList) {
                this.oaNotifyRecordList = oaNotifyRecordList;
            }

            public static class CreateByBean {
                /**
                 * id : 3c70d715d02a4c4aadc1952ecde286e1
                 * isNewRecord : false
                 * office : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"}
                 * name : 王五
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private OfficeBean office;
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

                public static class OfficeBean {
                    /**
                     * id : 9ce7467e94884e7192a14ad3c29c554d
                     * isNewRecord : false
                     * name : 北京总公司
                     * sort : 30
                     * type : 1
                     * address : 北京市海淀区
                     * zipCode : 100085
                     * master : 王五
                     * phone :
                     * fax :
                     * email :
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
                    private int grossProfit;
                    private String parentId;
                    private List<?> customerServiceList;

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
