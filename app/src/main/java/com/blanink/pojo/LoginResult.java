package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 * 登录结果
 */

public class LoginResult implements Serializable {
    private String errorCode;
    private String reason;
    private Result result;

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public String remarks;
        public CreateBy createBy;
        public String createDate;
        public String updateDate;
        public Company company;
        public Company office;

        public static class Company implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String parentIds;
            public String name;
            public Integer sort;
            public Area area;

            public static class Area implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String parentIds;
                public String name;
                public Integer sort;
                public String parentId;

                @Override
                public String toString() {
                    return "Area{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", parentIds='" + parentIds + '\'' +
                            ", name='" + name + '\'' +
                            ", sort=" + sort +
                            ", parentId='" + parentId + '\'' +
                            '}';
                }
            }

            public String type;
            public String serviceType;
            public String master;
            public Person primaryPerson;

            public static class Person implements Serializable {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public String loginFlag;
                public String roleNames;
                public Boolean admin;

                @Override
                public String toString() {
                    return "Person{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", loginFlag='" + loginFlag + '\'' +
                            ", roleNames='" + roleNames + '\'' +
                            ", admin=" + admin +
                            '}';
                }
            }

            public List<ManyCustomer.CustomerService> customerServiceList;
            public String homepage;
            public Double reviewOthers;
            public Double reviewSelf;
            public Integer otherCosting;
            public Integer otherPayment;
            public Integer otherQuality;
            public Integer otherService;
            public Integer otherTime;
            public Integer selfPayment;
            public Integer selfQuality;
            public Integer selfService;
            public Integer selfCosting;
            public Integer selfTime;
            public Integer serviceCount;
            public String parentId;

            @Override
            public String toString() {
                return "Company{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", parentIds='" + parentIds + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", area=" + area +
                        ", type='" + type + '\'' +
                        ", master='" + master + '\'' +
                        ", primaryPerson=" + primaryPerson +
                        ", customerServiceList=" + customerServiceList +
                        ", homepage='" + homepage + '\'' +
                        ", reviewOthers=" + reviewOthers +
                        ", reviewSelf=" + reviewSelf +
                        ", otherCosting=" + otherCosting +
                        ", otherPayment=" + otherPayment +
                        ", otherQuality=" + otherQuality +
                        ", otherService=" + otherService +
                        ", otherTime=" + otherTime +
                        ", selfPayment=" + selfPayment +
                        ", selfQuality=" + selfQuality +
                        ", selfService=" + selfService +
                        ", selfCosting=" + selfCosting +
                        ", selfTime=" + selfTime +
                        ", serviceCount=" + serviceCount +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

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
        public List<Role> roleList;

        public static class Role implements Serializable {
            public String id;
            public String isNewRecord;
            public String remarks;
            public String name;
            public String roleType;
            public String dataScope;
            public String sysData;
            public String useable;
            public String isPublic;
            public List menuList;
            public List officeList;
            public List permissions;
            public List menuIdList;
            public String menuIds;
            public List officeIdList;
            public String officeIds;

            @Override
            public String toString() {
                return "Role{" +
                        "id='" + id + '\'' +
                        ", isNewRecord='" + isNewRecord + '\'' +
                        ", remarks='" + remarks + '\'' +
                        ", name='" + name + '\'' +
                        ", roleType='" + roleType + '\'' +
                        ", dataScope='" + dataScope + '\'' +
                        ", sysData='" + sysData + '\'' +
                        ", useable='" + useable + '\'' +
                        ", isPublic='" + isPublic + '\'' +
                        ", menuList=" + menuList +
                        ", officeList=" + officeList +
                        ", permissions=" + permissions +
                        ", menuIdList=" + menuIdList +
                        ", menuIds='" + menuIds + '\'' +
                        ", officeIdList=" + officeIdList +
                        ", officeIds='" + officeIds + '\'' +
                        '}';
            }

        }

        public String roleNames;
        public Boolean admin;

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", company=" + company +
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
                    ", roleList=" + roleList +
                    ", roleNames='" + roleNames + '\'' +
                    ", admin=" + admin +
                    '}';
        }
    }

    public static class CreateBy implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public String name;
        public String loginFlag;
        public List<Result.Role> roleList;
        public String roleNames;
        public Boolean admin;

        @Override
        public String toString() {
            return "CreateBy{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", name='" + name + '\'' +
                    ", loginFlag='" + loginFlag + '\'' +
                    ", roleList=" + roleList +
                    ", roleNames='" + roleNames + '\'' +
                    ", admin=" + admin +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}



