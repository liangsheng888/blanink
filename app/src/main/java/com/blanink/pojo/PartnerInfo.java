package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 * 合作伙伴
 */

public class PartnerInfo implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"01ac9390b12a4fe6aed96a161a1b8fb7","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-05-24 18:28:29","updateDate":"2017-05-24 18:29:13","type":"1","companyA":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","master":"王五","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyB":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","name":"浙江总公司","sort":30,"area":{"isNewRecord":true,"name":"浙江省","sort":30,"parentId":"0"},"type":"1","address":"浙江省杭州市","master":"李四","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"isCustomer":"1","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""},{"id":"19fd46580d984f41bb0c4c29c1b669f0","isNewRecord":false,"createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-05-11 15:35:42","updateDate":"2017-05-11 15:35:42","type":"1","companyA":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","name":"浙江总公司","sort":30,"type":"1","address":"浙江省杭州市","master":"李四","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyB":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","name":"江苏总公司","sort":30,"area":{"isNewRecord":true,"name":"江苏省","sort":30,"parentId":"0"},"type":"1","address":"江苏省南京市","master":"张三","phone":"02512345678","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"isCustomer":"0","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""},{"id":"474e113fd6224170be991f8427969dab","isNewRecord":false,"remarks":"kjjjj","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-04-27 11:01:25","updateDate":"2017-05-02 14:35:57","type":"1","companyA":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","name":"江苏总公司","sort":30,"type":"1","address":"江苏省南京市","master":"张三","phone":"02512345678","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyB":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","name":"北京总公司","sort":30,"area":{"isNewRecord":true,"name":"北京市","sort":30,"parentId":"0"},"type":"1","address":"北京市海淀区","master":"王五","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"isCustomer":"0","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""},{"id":"a5c6fbe16bbc467f842a6cbcbe79ee1a","isNewRecord":false,"remarks":"添加","createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-04-26 14:55:55","updateDate":"2017-04-26 14:56:33","type":"1","companyA":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","master":"王五","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyB":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","name":"江苏总公司","sort":30,"area":{"isNewRecord":true,"name":"江苏省","sort":30,"parentId":"0"},"type":"1","address":"江苏省南京市","master":"张三","phone":"02512345678","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"isCustomer":"0","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""},{"id":"f2f97e7616a94a6a97bd6906e6fa0256","isNewRecord":false,"remarks":"123","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"createDate":"2017-04-26 14:50:25","updateDate":"2017-04-26 14:53:08","type":"1","companyA":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","name":"江苏总公司","sort":30,"type":"1","address":"江苏省南京市","master":"张三","phone":"02512345678","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyB":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","name":"浙江总公司","sort":30,"area":{"isNewRecord":true,"name":"浙江省","sort":30,"parentId":"0"},"type":"1","address":"浙江省杭州市","master":"李四","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"isCustomer":"0","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""}]
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
         * id : 01ac9390b12a4fe6aed96a161a1b8fb7
         * isNewRecord : false
         * createBy : {"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false}
         * createDate : 2017-05-24 18:28:29
         * updateDate : 2017-05-24 18:29:13
         * type : 1
         * companyA : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","name":"北京总公司","sort":30,"type":"1","address":"北京市海淀区","master":"王五","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * companyB : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","name":"浙江总公司","sort":30,"area":{"isNewRecord":true,"name":"浙江省","sort":30,"parentId":"0"},"type":"1","address":"浙江省杭州市","master":"李四","phone":"","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * isCustomer : 1
         * reviewStatus : 2
         * resources : []
         * next : false
         * urls :
         * sendMessage :
         * remarks : kjjjj
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private String type;
        private CompanyABean companyA;
        private CompanyBBean companyB;
        private String isCustomer;
        private String reviewStatus;
        private boolean next;
        private String urls;
        private String sendMessage;
        private String remarks;
        private List<?> resources;

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

        public CompanyABean getCompanyA() {
            return companyA;
        }

        public void setCompanyA(CompanyABean companyA) {
            this.companyA = companyA;
        }

        public CompanyBBean getCompanyB() {
            return companyB;
        }

        public void setCompanyB(CompanyBBean companyB) {
            this.companyB = companyB;
        }

        public String getIsCustomer() {
            return isCustomer;
        }

        public void setIsCustomer(String isCustomer) {
            this.isCustomer = isCustomer;
        }

        public String getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(String reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public boolean isNext() {
            return next;
        }

        public void setNext(boolean next) {
            this.next = next;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        public String getSendMessage() {
            return sendMessage;
        }

        public void setSendMessage(String sendMessage) {
            this.sendMessage = sendMessage;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public List<?> getResources() {
            return resources;
        }

        public void setResources(List<?> resources) {
            this.resources = resources;
        }

        public static class CreateByBean {
            /**
             * id : 3c70d715d02a4c4aadc1952ecde286e1
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

        public static class CompanyABean {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
             * isNewRecord : false
             * remarks :
             * name : 北京总公司
             * sort : 30
             * type : 1
             * address : 北京市海淀区
             * master : 王五
             * phone :
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
            private String remarks;
            private String name;
            private int sort;
            private String type;
            private String address;
            private String master;
            private String phone;
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

        public static class CompanyBBean {
            /**
             * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
             * isNewRecord : false
             * remarks :
             * name : 浙江总公司
             * sort : 30
             * area : {"isNewRecord":true,"name":"浙江省","sort":30,"parentId":"0"}
             * type : 1
             * address : 浙江省杭州市
             * master : 李四
             * phone :
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
            private String remarks;
            private String name;
            private int sort;
            private AreaBean area;
            private String type;
            private String address;
            private String master;
            private String phone;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public static class AreaBean {
                /**
                 * isNewRecord : true
                 * name : 浙江省
                 * sort : 30
                 * parentId : 0
                 */

                private boolean isNewRecord;
                private String name;
                private int sort;
                private String parentId;

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
