package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class CompanyEmployee implements Serializable {


    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"officeName":"北京总公司500","officeId":"9ce7467e94884e7192a14ad3c29c554d","roleId":"3","roleName":"公司管理员","userId":"3c70d715d02a4c4aadc1952ecde286e1","userName":"王五"},{"isNewRecord":true,"officeName":"江苏总公司500","officeId":"f541afa391974409ba680e9bd9a394fd","roleId":"8d08c1e7e0794508abd04bb6c8a1d162","roleName":"总经理","userId":"4856035c527b419a9cf70d856e65c93b","userName":"dongdong"},{"isNewRecord":true,"officeName":"江苏总公司500","officeId":"f541afa391974409ba680e9bd9a394fd","roleId":"27ffeff161d048b6839fd0a0998bd5b9","roleName":"工人","userId":"b17faaade8754e3eab1bcaba29cb52a8","userName":"张三丰"},{"isNewRecord":true,"officeName":"江苏总公司500","officeId":"f541afa391974409ba680e9bd9a394fd","roleId":"3","roleName":"公司管理员","userId":"d6c8e9bc4c2b476ba84b962c27882f41","userName":"张三"},{"isNewRecord":true,"officeName":"江苏总公司500","officeId":"f541afa391974409ba680e9bd9a394fd","roleId":"27ffeff161d048b6839fd0a0998bd5b9","roleName":"工人","userId":"dbb482a1b0434543a37e2d12408384d2","userName":"老二"}]
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
         * isNewRecord : true
         * officeName : 北京总公司500
         * officeId : 9ce7467e94884e7192a14ad3c29c554d
         * roleId : 3
         * roleName : 公司管理员
         * userId : 3c70d715d02a4c4aadc1952ecde286e1
         * userName : 王五
         */

        private boolean isNewRecord;
        private String officeName;
        private String officeId;
        private String roleId;
        private String roleName;
        private String userId;
        private String userName;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getOfficeName() {
            return officeName;
        }

        public void setOfficeName(String officeName) {
            this.officeName = officeName;
        }

        public String getOfficeId() {
            return officeId;
        }

        public void setOfficeId(String officeId) {
            this.officeId = officeId;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
