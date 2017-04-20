package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class NotifyOffice implements Serializable {


    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"id":"6a491e81958e420b8de50be7c05a9e20","isNewRecord":false,"createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-05 10:28:23","updateDate":"2017-04-05 10:48:45","type":"1","companyA":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:13:43","updateDate":"2017-01-05 15:13:43","parentIds":"0,1,","name":"北京总公司","sort":30,"area":{"id":"2","isNewRecord":false,"parentIds":"0,1","name":"北京市","sort":30,"parentId":"0"},"code":"100000003","scope":"手机，笔记本","shortName":"北京总公司","registTime":"2017-01-05 15:12:59","type":"1","serviceType":"1","grade":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[],"homepage":"www.baidu.com","reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"1"},"companyB":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","scope":"手机，笔记本","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[],"homepage":"www.baidu.com","reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"1"},"isCustomer":"0","reviewStatus":"2","resources":[],"next":false,"urls":"","sendMessage":""}
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
         * id : 6a491e81958e420b8de50be7c05a9e20
         * isNewRecord : false
         * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-04-05 10:28:23
         * updateDate : 2017-04-05 10:48:45
         * type : 1
         * companyA : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:13:43","updateDate":"2017-01-05 15:13:43","parentIds":"0,1,","name":"北京总公司","sort":30,"area":{"id":"2","isNewRecord":false,"parentIds":"0,1","name":"北京市","sort":30,"parentId":"0"},"code":"100000003","scope":"手机，笔记本","shortName":"北京总公司","registTime":"2017-01-05 15:12:59","type":"1","serviceType":"1","grade":"1","address":"北京市海淀区","zipCode":"100085","master":"王五","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[],"homepage":"www.baidu.com","reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"1"}
         * companyB : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","scope":"手机，笔记本","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[],"homepage":"www.baidu.com","reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"1"}
         * isCustomer : 0
         * reviewStatus : 2
         * resources : []
         * next : false
         * urls :
         * sendMessage :
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

        public List<?> getResources() {
            return resources;
        }

        public void setResources(List<?> resources) {
            this.resources = resources;
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

        public static class CompanyABean {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
             * isNewRecord : false
             * remarks :
             * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
             * createDate : 2017-01-05 15:13:43
             * updateDate : 2017-01-05 15:13:43
             * parentIds : 0,1,
             * name : 北京总公司
             * sort : 30
             * area : {"id":"2","isNewRecord":false,"parentIds":"0,1","name":"北京市","sort":30,"parentId":"0"}
             * code : 100000003
             * scope : 手机，笔记本
             * shortName : 北京总公司
             * registTime : 2017-01-05 15:12:59
             * type : 1
             * serviceType : 1
             * grade : 1
             * address : 北京市海淀区
             * zipCode : 100085
             * master : 王五
             * phone :
             * fax :
             * email :
             * useable : 1
             * primaryPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * deputyPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * customerServiceList : []
             * homepage : www.baidu.com
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
             * parentId : 1
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanX createBy;
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
            private PrimaryPersonBean primaryPerson;
            private DeputyPersonBean deputyPerson;
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

            public PrimaryPersonBean getPrimaryPerson() {
                return primaryPerson;
            }

            public void setPrimaryPerson(PrimaryPersonBean primaryPerson) {
                this.primaryPerson = primaryPerson;
            }

            public DeputyPersonBean getDeputyPerson() {
                return deputyPerson;
            }

            public void setDeputyPerson(DeputyPersonBean deputyPerson) {
                this.deputyPerson = deputyPerson;
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

            public static class CreateByBeanX {
                /**
                 * id : 1
                 * isNewRecord : false
                 * loginFlag : 1
                 * roleList : []
                 * admin : true
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

            public static class AreaBean {
                /**
                 * id : 2
                 * isNewRecord : false
                 * parentIds : 0,1
                 * name : 北京市
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

            public static class PrimaryPersonBean {
                /**
                 * id :
                 * isNewRecord : true
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

            public static class DeputyPersonBean {
                /**
                 * id :
                 * isNewRecord : true
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
        }

        public static class CompanyBBean {
            /**
             * id : f541afa391974409ba680e9bd9a394fd
             * isNewRecord : false
             * remarks :
             * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
             * createDate : 2017-01-05 15:11:38
             * updateDate : 2017-01-05 15:11:38
             * parentIds : 0,1,
             * name : 江苏总公司
             * sort : 30
             * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
             * code : 100000001
             * scope : 手机，笔记本
             * shortName : 江苏总公司
             * registTime : 2017-01-05 15:10:03
             * type : 1
             * serviceType : 1
             * grade : 1
             * address : 江苏省南京市
             * zipCode : 210000
             * master : 张三
             * phone : 02512345678
             * fax :
             * email : zhagnsan@email.com
             * useable : 1
             * primaryPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * deputyPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * customerServiceList : []
             * homepage : www.baidu.com
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
             * parentId : 1
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanXX createBy;
            private String createDate;
            private String updateDate;
            private String parentIds;
            private String name;
            private int sort;
            private AreaBeanX area;
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
            private PrimaryPersonBeanX primaryPerson;
            private DeputyPersonBeanX deputyPerson;
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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public CreateByBeanXX getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateByBeanXX createBy) {
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

            public AreaBeanX getArea() {
                return area;
            }

            public void setArea(AreaBeanX area) {
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

            public PrimaryPersonBeanX getPrimaryPerson() {
                return primaryPerson;
            }

            public void setPrimaryPerson(PrimaryPersonBeanX primaryPerson) {
                this.primaryPerson = primaryPerson;
            }

            public DeputyPersonBeanX getDeputyPerson() {
                return deputyPerson;
            }

            public void setDeputyPerson(DeputyPersonBeanX deputyPerson) {
                this.deputyPerson = deputyPerson;
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

            public static class CreateByBeanXX {
                /**
                 * id : 1
                 * isNewRecord : false
                 * loginFlag : 1
                 * roleList : []
                 * admin : true
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

            public static class PrimaryPersonBeanX {
                /**
                 * id :
                 * isNewRecord : true
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

            public static class DeputyPersonBeanX {
                /**
                 * id :
                 * isNewRecord : true
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
        }
    }
}
