package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
public class OfficeEmp {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"b1c01269fd314a66babc965fc1c17ce2","isNewRecord":false,"loginName":"bjmanager","name":"大神","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginName":"bjadmin","name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
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
         * id : b1c01269fd314a66babc965fc1c17ce2
         * isNewRecord : false
         * loginName : bjmanager
         * name : 大神
         * loginFlag : 1
         * roleList : []
         * admin : false
         * roleNames :
         */

        private String id;
        private boolean isNewRecord;
        private String loginName;
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

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
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
    }
}
