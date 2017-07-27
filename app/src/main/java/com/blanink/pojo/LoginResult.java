package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 * 登录结果
 */

public class LoginResult implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:57:07","updateDate":"2017-07-10 23:12:22","company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"office":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"},"loginName":"zjadmin","no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"1334455666677","mobile":"150089963879","userType":"1","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-07-10 09:18:37","loginFlag":"1","photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/1498883960753","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-07-10 09:18:37","isCustomerService":"1","roleList":[{"id":"3","isNewRecord":false,"remarks":"","name":"公司管理员","enname":"a","roleType":"security-role","dataScope":"3","sysData":"1","useable":"1","isPublic":"0","userList":[],"menuList":[],"officeList":[],"permissions":[],"menuIdList":[],"officeIdList":[],"officeIds":"","menuIds":""}],"admin":false,"roleNames":"公司管理员"}
     */

    public String errorCode;
    public String reason;
    public ResultBean result;

    @Override
    public String toString() {
        return "LoginResult{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

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
         * id : 447e4526d22045f59ed58250046b3842
         * isNewRecord : false
         * remarks : 
         * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
         * createDate : 2017-01-05 15:57:07
         * updateDate : 2017-07-10 23:12:22
         * company : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"}
         * office : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"1"}
         * loginName : zjadmin
         * no : 1000001
         * name : 李四
         * email : zjadmin@12.com
         * phone : 1334455666677
         * mobile : 150089963879
         * userType : 1
         * loginIp : 0:0:0:0:0:0:0:1
         * loginDate : 2017-07-10 09:18:37
         * loginFlag : 1
         * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/1498883960753
         * oldLoginIp : 0:0:0:0:0:0:0:1
         * oldLoginDate : 2017-07-10 09:18:37
         * isCustomerService : 1
         * roleList : [{"id":"3","isNewRecord":false,"remarks":"","name":"公司管理员","enname":"a","roleType":"security-role","dataScope":"3","sysData":"1","useable":"1","isPublic":"0","userList":[],"menuList":[],"officeList":[],"permissions":[],"menuIdList":[],"officeIdList":[],"officeIds":"","menuIds":""}]
         * admin : false
         * roleNames : 公司管理员
         */

        public String id;
        public boolean isNewRecord;
        public String remarks;
        public CreateByBean createBy;
        public String createDate;
        public String updateDate;
        public CompanyBean company;
        public OfficeBean office;
        public String loginName;
        public String no;
        public String name;
        public String email;
        public String phone;
        public String mobile;
        public String userType;
        public String loginIp;
        public String loginDate;
        public String loginFlag;
        public String photo;
        public String oldLoginIp;
        public String oldLoginDate;
        public String isCustomerService;
        public boolean admin;
        public String roleNames;
        public List<RoleListBean> roleList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", company=" + company +
                    ", office=" + office +
                    ", loginName='" + loginName + '\'' +
                    ", no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", userType='" + userType + '\'' +
                    ", loginIp='" + loginIp + '\'' +
                    ", loginDate='" + loginDate + '\'' +
                    ", loginFlag='" + loginFlag + '\'' +
                    ", photo='" + photo + '\'' +
                    ", oldLoginIp='" + oldLoginIp + '\'' +
                    ", oldLoginDate='" + oldLoginDate + '\'' +
                    ", isCustomerService='" + isCustomerService + '\'' +
                    ", admin=" + admin +
                    ", roleNames='" + roleNames + '\'' +
                    ", roleList=" + roleList +
                    '}';
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

        public List<RoleListBean> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<RoleListBean> roleList) {
            this.roleList = roleList;
        }

        public static class CreateByBean implements Serializable {
            /**
             * id : 1
             * isNewRecord : false
             * loginFlag : 1
             * roleList : []
             * admin : true
             * roleNames : 
             */

            public String id;
            public boolean isNewRecord;
            public String loginFlag;
            public boolean admin;
            public String roleNames;
            public List<?> roleList;

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

        public static class CompanyBean implements Serializable {
            /**
             * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
             * isNewRecord : false
             * parentIds : 0,1,
             * name : 浙江总公司
             * sort : 30
             * area : {"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"}
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
             * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock
             * roleList : []
             * grossProfit : 0
             * pType : 
             * places : 0
             * parentId : 1
             */

            public String id;
            public boolean isNewRecord;
            public String parentIds;
            public String name;
            public int sort;
            public AreaBean area;
            public String type;
            public String address;
            public int reviewOthers;
            public int reviewSelf;
            public int otherCosting;
            public int otherPayment;
            public int otherQuality;
            public int otherService;
            public int otherTime;
            public int selfCosting;
            public int selfPayment;
            public int serviceCount;
            public String photo;
            public int grossProfit;
            public String pType;
            public int places;
            public String parentId;
            public List<?> customerServiceList;
            public List<?> roleList;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            @Override
            public String toString() {
                return "CompanyBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", parentIds='" + parentIds + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", area=" + area +
                        ", type='" + type + '\'' +
                        ", reviewOthers=" + reviewOthers +
                        ", reviewSelf=" + reviewSelf +
                        ", otherCosting=" + otherCosting +
                        ", otherPayment=" + otherPayment +
                        ", otherQuality=" + otherQuality +
                        ", otherService=" + otherService +
                        ", otherTime=" + otherTime +
                        ", selfCosting=" + selfCosting +
                        ", selfPayment=" + selfPayment +
                        ", serviceCount=" + serviceCount +
                        ", photo='" + photo + '\'' +
                        ", grossProfit=" + grossProfit +
                        ", pType='" + pType + '\'' +
                        ", places=" + places +
                        ", parentId='" + parentId + '\'' +
                        ", customerServiceList=" + customerServiceList +
                        ", roleList=" + roleList +
                        '}';
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

            public static class AreaBean implements Serializable {
                /**
                 * id : 13
                 * isNewRecord : false
                 * parentIds : 0,1
                 * name : 浙江省
                 * sort : 30
                 * parentId : 0
                 */

                public String id;
                public boolean isNewRecord;
                public String parentIds;
                public String name;
                public int sort;
                public String parentId;

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

        public static class OfficeBean implements Serializable {
            /**
             * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
             * isNewRecord : false
             * parentIds : 0,1,
             * name : 浙江总公司
             * sort : 30
             * area : {"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"}
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
             * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock
             * roleList : []
             * grossProfit : 0
             * pType : 
             * places : 0
             * parentId : 1
             */

            public String id;
            public boolean isNewRecord;
            public String parentIds;
            public String name;
            public int sort;
            public AreaBeanX area;
            public String type;
            public String serviceType;
            public int reviewOthers;
            public int reviewSelf;
            public int otherCosting;
            public int otherPayment;
            public int otherQuality;
            public int otherService;
            public int otherTime;
            public int selfCosting;
            public int selfPayment;
            public int serviceCount;
            public String photo;
            public int grossProfit;
            public String pType;
            public int places;
            public String parentId;
            public String address;
            public List<?> customerServiceList;
            public List<?> roleList;

            public String getAddress() {
                return address;
            }

            @Override
            public String toString() {
                return "OfficeBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", parentIds='" + parentIds + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", area=" + area +
                        ", type='" + type + '\'' +
                        ", serviceType='" + serviceType + '\'' +
                        ", reviewOthers=" + reviewOthers +
                        ", reviewSelf=" + reviewSelf +
                        ", otherCosting=" + otherCosting +
                        ", otherPayment=" + otherPayment +
                        ", otherQuality=" + otherQuality +
                        ", otherService=" + otherService +
                        ", otherTime=" + otherTime +
                        ", selfCosting=" + selfCosting +
                        ", selfPayment=" + selfPayment +
                        ", serviceCount=" + serviceCount +
                        ", photo='" + photo + '\'' +
                        ", grossProfit=" + grossProfit +
                        ", pType='" + pType + '\'' +
                        ", places=" + places +
                        ", parentId='" + parentId + '\'' +
                        ", customerServiceList=" + customerServiceList +
                        ", roleList=" + roleList +
                        '}';
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

            public static class AreaBeanX implements Serializable {
                /**
                 * id : 13
                 * isNewRecord : false
                 * parentIds : 0,1
                 * name : 浙江省
                 * sort : 30
                 * parentId : 0
                 */

                public String id;
                public boolean isNewRecord;
                public String parentIds;
                public String name;
                public int sort;
                public String parentId;

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

        public static class RoleListBean implements Serializable {
            /**
             * id : 3
             * isNewRecord : false
             * remarks : 
             * name : 公司管理员
             * enname : a
             * roleType : security-role
             * dataScope : 3
             * sysData : 1
             * useable : 1
             * isPublic : 0
             * userList : []
             * menuList : []
             * officeList : []
             * permissions : []
             * menuIdList : []
             * officeIdList : []
             * officeIds : 
             * menuIds : 
             */

            public String id;
            public boolean isNewRecord;
            public String remarks;
            public String name;
            public String enname;
            public String roleType;
            public String dataScope;
            public String sysData;
            public String useable;
            public String isPublic;
            public String officeIds;
            public String menuIds;
            public List<?> userList;
            public List<?> menuList;
            public List<?> officeList;
            public List<?> permissions;
            public List<?> menuIdList;
            public List<?> officeIdList;

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

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getRoleType() {
                return roleType;
            }

            public void setRoleType(String roleType) {
                this.roleType = roleType;
            }

            public String getDataScope() {
                return dataScope;
            }

            public void setDataScope(String dataScope) {
                this.dataScope = dataScope;
            }

            public String getSysData() {
                return sysData;
            }

            public void setSysData(String sysData) {
                this.sysData = sysData;
            }

            public String getUseable() {
                return useable;
            }

            public void setUseable(String useable) {
                this.useable = useable;
            }

            public String getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(String isPublic) {
                this.isPublic = isPublic;
            }

            public String getOfficeIds() {
                return officeIds;
            }

            public void setOfficeIds(String officeIds) {
                this.officeIds = officeIds;
            }

            public String getMenuIds() {
                return menuIds;
            }

            public void setMenuIds(String menuIds) {
                this.menuIds = menuIds;
            }

            public List<?> getUserList() {
                return userList;
            }

            public void setUserList(List<?> userList) {
                this.userList = userList;
            }

            public List<?> getMenuList() {
                return menuList;
            }

            public void setMenuList(List<?> menuList) {
                this.menuList = menuList;
            }

            public List<?> getOfficeList() {
                return officeList;
            }

            public void setOfficeList(List<?> officeList) {
                this.officeList = officeList;
            }

            public List<?> getPermissions() {
                return permissions;
            }

            public void setPermissions(List<?> permissions) {
                this.permissions = permissions;
            }

            public List<?> getMenuIdList() {
                return menuIdList;
            }

            public void setMenuIdList(List<?> menuIdList) {
                this.menuIdList = menuIdList;
            }

            public List<?> getOfficeIdList() {
                return officeIdList;
            }

            public void setOfficeIdList(List<?> officeIdList) {
                this.officeIdList = officeIdList;
            }
        }
    }
}



