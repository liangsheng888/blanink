package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 * 反馈详情
 */
public class FeedPrcessDetail {

    /**
     * errorCode : 00000
     * reason : 查询数据成功！
     * result : {"id":"9bd1673ca1e849d8ac7a318a62cb03ad","isNewRecord":false,"remarks":"恶魔咯无头无尾xxl","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-16 09:21:10","updateDate":"2017-06-16 09:21:10","flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"faultAmount":1,"isFinished":"0","achieveAmount":100,"resources":[{"id":"3a1365c2159f442798e8206945a9c048","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"],"currentUrlList":[]},{"id":"4ebdc8011c704c0b91d7306dfa901d18","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock"],"currentUrlList":[]},{"id":"876dcf0027d64af2ae1415b26b664475","isNewRecord":false,"resourceName":"ull","resourceType":"process_feedback","resourceUrl":"ull","urlList":["ull"],"currentUrlList":[]},{"id":"fe372e045d674250b49c13fad8a00759","isNewRecord":false,"resourceName":"alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,ull,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,ull,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"}
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
         * id : 9bd1673ca1e849d8ac7a318a62cb03ad
         * isNewRecord : false
         * remarks : 恶魔咯无头无尾xxl
         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-06-16 09:21:10
         * updateDate : 2017-06-16 09:21:10
         * flow : {"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
         * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
         * faultAmount : 1
         * isFinished : 0
         * achieveAmount : 100
         * resources : [{"id":"3a1365c2159f442798e8206945a9c048","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"],"currentUrlList":[]},{"id":"4ebdc8011c704c0b91d7306dfa901d18","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock"],"currentUrlList":[]},{"id":"876dcf0027d64af2ae1415b26b664475","isNewRecord":false,"resourceName":"ull","resourceType":"process_feedback","resourceUrl":"ull","urlList":["ull"],"currentUrlList":[]},{"id":"fe372e045d674250b49c13fad8a00759","isNewRecord":false,"resourceName":"alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"],"currentUrlList":[]}]
         * feedbackUser : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * target : 0
         * feedbackAttachmentStr : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,ull,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock
         * urls : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,ull,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private FlowBean flow;
        private ProcessBean process;
        private int faultAmount;
        private String isFinished;
        private int achieveAmount;
        private FeedbackUserBean feedbackUser;
        private int target;
        private String feedbackAttachmentStr;
        private String urls;
        private List<ResourcesBean> resources;

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

        public FlowBean getFlow() {
            return flow;
        }

        public void setFlow(FlowBean flow) {
            this.flow = flow;
        }

        public ProcessBean getProcess() {
            return process;
        }

        public void setProcess(ProcessBean process) {
            this.process = process;
        }

        public int getFaultAmount() {
            return faultAmount;
        }

        public void setFaultAmount(int faultAmount) {
            this.faultAmount = faultAmount;
        }

        public String getIsFinished() {
            return isFinished;
        }

        public void setIsFinished(String isFinished) {
            this.isFinished = isFinished;
        }

        public int getAchieveAmount() {
            return achieveAmount;
        }

        public void setAchieveAmount(int achieveAmount) {
            this.achieveAmount = achieveAmount;
        }

        public FeedbackUserBean getFeedbackUser() {
            return feedbackUser;
        }

        public void setFeedbackUser(FeedbackUserBean feedbackUser) {
            this.feedbackUser = feedbackUser;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public String getFeedbackAttachmentStr() {
            return feedbackAttachmentStr;
        }

        public void setFeedbackAttachmentStr(String feedbackAttachmentStr) {
            this.feedbackAttachmentStr = feedbackAttachmentStr;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        public List<ResourcesBean> getResources() {
            return resources;
        }

        public void setResources(List<ResourcesBean> resources) {
            this.resources = resources;
        }

        public static class CreateByBean {
            /**
             * id : 447e4526d22045f59ed58250046b3842
             * isNewRecord : false
             * name : 李四
             * loginFlag : 1
             * roleList : []
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
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

        public static class FlowBean {
            /**
             * id : 2695060d06604c7e98f007e06592d22b
             * isNewRecord : false
             * processList : []
             * orderProducts : []
             * remaksList : []
             */

            private String id;
            private boolean isNewRecord;
            private List<?> processList;
            private List<?> orderProducts;
            private List<?> remaksList;

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

            public List<?> getProcessList() {
                return processList;
            }

            public void setProcessList(List<?> processList) {
                this.processList = processList;
            }

            public List<?> getOrderProducts() {
                return orderProducts;
            }

            public void setOrderProducts(List<?> orderProducts) {
                this.orderProducts = orderProducts;
            }

            public List<?> getRemaksList() {
                return remaksList;
            }

            public void setRemaksList(List<?> remaksList) {
                this.remaksList = remaksList;
            }
        }

        public static class ProcessBean {
            /**
             * id : 1a9090dd4dbe4808a921900d7b64db01
             * isNewRecord : false
             * name : 发货
             * sort : 30
             * relPPList : []
             * proList : []
             * parentId : 0
             * positionNames : []
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private String parentId;
            private List<?> relPPList;
            private List<?> proList;
            private List<?> positionNames;

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

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public List<?> getRelPPList() {
                return relPPList;
            }

            public void setRelPPList(List<?> relPPList) {
                this.relPPList = relPPList;
            }

            public List<?> getProList() {
                return proList;
            }

            public void setProList(List<?> proList) {
                this.proList = proList;
            }

            public List<?> getPositionNames() {
                return positionNames;
            }

            public void setPositionNames(List<?> positionNames) {
                this.positionNames = positionNames;
            }
        }

        public static class FeedbackUserBean {
            /**
             * id : 447e4526d22045f59ed58250046b3842
             * isNewRecord : false
             * name : 李四
             * loginFlag : 1
             * roleList : []
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
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

        public static class ResourcesBean {
            /**
             * id : 3a1365c2159f442798e8206945a9c048
             * isNewRecord : false
             * resourceName : alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK
             * resourceType : process_feedback
             * resourceUrl : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock
             * urlList : ["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"]
             * currentUrlList : []
             */

            private String id;
            private boolean isNewRecord;
            private String resourceName;
            private String resourceType;
            private String resourceUrl;
            private List<String> urlList;
            private List<?> currentUrlList;

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

            public String getResourceName() {
                return resourceName;
            }

            public void setResourceName(String resourceName) {
                this.resourceName = resourceName;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getResourceUrl() {
                return resourceUrl;
            }

            public void setResourceUrl(String resourceUrl) {
                this.resourceUrl = resourceUrl;
            }

            public List<String> getUrlList() {
                return urlList;
            }

            public void setUrlList(List<String> urlList) {
                this.urlList = urlList;
            }

            public List<?> getCurrentUrlList() {
                return currentUrlList;
            }

            public void setCurrentUrlList(List<?> currentUrlList) {
                this.currentUrlList = currentUrlList;
            }
        }
    }
}
