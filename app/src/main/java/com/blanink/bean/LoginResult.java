package com.blanink.bean;

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

    @Override
    public String toString() {
        return "LoginResult{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result {
        public String id;
        public Boolean isNewRecord;
        public String remarks;
        public CreateBy createBy;
        public String createDate;
        public String updateDate;
        public Company company;
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
        public String roleNames;
        public Boolean admin;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(Boolean newRecord) {
            isNewRecord = newRecord;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public CreateBy getCreateBy() {
            return createBy;
        }

        public void setCreateBy(CreateBy createBy) {
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

        public String getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", loginName='" + loginName + '\'' +
                    ", no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", userType=" + userType +
                    ", loginIp='" + loginIp + '\'' +
                    ", loginDate='" + loginDate + '\'' +
                    ", loginFlag=" + loginFlag +
                    ", photo='" + photo + '\'' +
                    ", oldLoginIp='" + oldLoginIp + '\'' +
                    ", oldLoginDate='" + oldLoginDate + '\'' +
                    ", roleNames='" + roleNames + '\'' +
                    ", admin=" + admin +
                    '}';
        }

        public static class CreateBy {
            public String id;
            public Boolean isNewRecord;
            public Integer loginFlag;
            public String roleNames;
            public Boolean admin;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Boolean getNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(Boolean newRecord) {
                isNewRecord = newRecord;
            }

            public Integer getLoginFlag() {
                return loginFlag;
            }

            public void setLoginFlag(Integer loginFlag) {
                this.loginFlag = loginFlag;
            }

            public String getRoleNames() {
                return roleNames;
            }

            public void setRoleNames(String roleNames) {
                this.roleNames = roleNames;
            }

            public Boolean getAdmin() {
                return admin;
            }

            public void setAdmin(Boolean admin) {
                this.admin = admin;
            }

            @Override
            public String toString() {
                return "CreateBy{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", loginFlag=" + loginFlag +
                        ", roleNames='" + roleNames + '\'' +
                        ", admin=" + admin +
                        '}';
            }
        }

    }

    public static class Company {
          public String id;
          public Boolean isNewRecord;
          public String parentIds;
          public String name;
          public Integer sort;
          public ManyCustomer.Area area;
          public String type;
          public ManyCustomer.Person primaryPerson;
          public List customerServiceList;
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
                    ", primaryPerson=" + primaryPerson +
                    ", customerServiceList=" + customerServiceList +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }
   /* "company": {
        "id": "d38f321fb31546edbf6927e5fc9e65d9",
                "isNewRecord": false,
                "parentIds": "0,",
                "name": "江苏省总公司",
                "sort": 30,
                "area": {
            "id": "2",
                    "isNewRecord": false,
                    "parentIds": "0,1",
                    "name": "北京市",
                    "sort": 30,
                    "parentId": "0"
        },
        "type": "1",
                "primaryPerson": {
            "id": "3e87b8706d0a449dabb050102faf56a1",
                    "isNewRecord": false,
                    "name": "李四",
                    "loginFlag": "1",
                    "admin": false,
                    "roleNames": ""
        },
        "customerServiceList": [],
        "parentId": "0"
    },*/
}
