package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class FlowProgress implements Serializable {

    /**
     * errorCode : 00000
     * reason : 保存数据成功！
     * result : [{"isNewRecord":true,"remarks":"好好做","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"name":"工序A","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"latestFeedback":{"id":"63373666a21d4d8c8b4b6939169c6e7a","isNewRecord":false,"remarks":"东东本人反馈150-次品10","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 22:12:25","updateDate":"2017-06-20 22:12:25","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"name":"工序A","sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"faultAmount":10,"isFinished":"0","achieveAmount":150,"resources":[],"feedbackUser":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""},"processPriority":"1","status":"2","totalCompletedQuantity":150,"isPublic":"1"},{"isNewRecord":true,"remarks":"好好做","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"processPriority":"1","status":"2","isPublic":"1"},{"isNewRecord":true,"remarks":"顶顶顶","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"84fd0bf593f9402a8e1d96daf7b34816","isNewRecord":false,"name":"工序二e","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"processPriority":"1","status":"2","isPublic":"1"},{"isNewRecord":true,"remarks":"顶顶顶顶","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"57d1d29392fc4b188cf497ba90b6b01d","isNewRecord":false,"name":"工序c1","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"processPriority":"1","status":"2","isPublic":"1"},{"isNewRecord":true,"remarks":"顶顶顶","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"4c6bbb3dae2d4ef0a6aa5013136d49d9","isNewRecord":false,"name":"工序E","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"processPriority":"1","status":"2","isPublic":"1"},{"isNewRecord":true,"remarks":"要发货了","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"dce551fbde2a46f5881fbc689e275f9e","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"target":500,"processPriority":"1","status":"2","isPublic":"1"}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "FlowProgress{" +
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * isNewRecord : true
         * remarks : 好好做
         * flow : {"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
         * process : {"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"name":"工序A","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"positionNames":[],"parentId":"0"}
         * target : 500
         * latestFeedback : {"id":"63373666a21d4d8c8b4b6939169c6e7a","isNewRecord":false,"remarks":"东东本人反馈150-次品10","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 22:12:25","updateDate":"2017-06-20 22:12:25","flow":{"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"name":"工序A","sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"},"faultAmount":10,"isFinished":"0","achieveAmount":150,"resources":[],"feedbackUser":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""}
         * processPriority : 1
         * status : 2
         * totalCompletedQuantity : 150
         * isPublic : 1
         */

        private boolean isNewRecord;
        private String remarks;
        private FlowBean flow;
        private ProcessBean process;
        private int target;
        private LatestFeedbackBean latestFeedback;
        private String processPriority;
        private String status;
        private int totalCompletedQuantity;
        private String isPublic;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", flow=" + flow +
                    ", process=" + process +
                    ", target=" + target +
                    ", latestFeedback=" + latestFeedback +
                    ", processPriority='" + processPriority + '\'' +
                    ", status='" + status + '\'' +
                    ", totalCompletedQuantity=" + totalCompletedQuantity +
                    ", isPublic='" + isPublic + '\'' +
                    '}';
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

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public LatestFeedbackBean getLatestFeedback() {
            return latestFeedback;
        }

        public void setLatestFeedback(LatestFeedbackBean latestFeedback) {
            this.latestFeedback = latestFeedback;
        }

        public String getProcessPriority() {
            return processPriority;
        }

        public void setProcessPriority(String processPriority) {
            this.processPriority = processPriority;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTotalCompletedQuantity() {
            return totalCompletedQuantity;
        }

        public void setTotalCompletedQuantity(int totalCompletedQuantity) {
            this.totalCompletedQuantity = totalCompletedQuantity;
        }

        public String getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(String isPublic) {
            this.isPublic = isPublic;
        }

        public static class FlowBean {
            /**
             * id : f9f133f6d0294b9b8909ed2262b02c69
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
             * id : be091cd5cdbc4b778494d54c870e7add
             * isNewRecord : false
             * name : 工序A
             * sort : 30
             * type : 1
             * feedbackType : 1
             * relPPList : []
             * proList : []
             * positionNames : []
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private String type;
            private String feedbackType;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getFeedbackType() {
                return feedbackType;
            }

            public void setFeedbackType(String feedbackType) {
                this.feedbackType = feedbackType;
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

        public static class LatestFeedbackBean {
            /**
             * id : 63373666a21d4d8c8b4b6939169c6e7a
             * isNewRecord : false
             * remarks : 东东本人反馈150-次品10
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-06-20 22:12:25
             * updateDate : 2017-06-20 22:12:25
             * flow : {"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
             * process : {"id":"be091cd5cdbc4b778494d54c870e7add","isNewRecord":false,"name":"工序A","sort":30,"relPPList":[],"proList":[],"positionNames":[],"parentId":"0"}
             * faultAmount : 10
             * isFinished : 0
             * achieveAmount : 150
             * resources : []
             * feedbackUser : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * target : 0
             * feedbackAttachmentStr :
             * urls :
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private FlowBeanX flow;
            private ProcessBeanX process;
            private int faultAmount;
            private String isFinished;
            private int achieveAmount;
            private FeedbackUserBean feedbackUser;
            private int target;
            private String feedbackAttachmentStr;
            private String urls;
            private List<?> resources;

            @Override
            public String toString() {
                return "LatestFeedbackBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", flow=" + flow +
                        ", process=" + process +
                        ", faultAmount=" + faultAmount +
                        ", isFinished='" + isFinished + '\'' +
                        ", achieveAmount=" + achieveAmount +
                        ", feedbackUser=" + feedbackUser +
                        ", target=" + target +
                        ", feedbackAttachmentStr='" + feedbackAttachmentStr + '\'' +
                        ", urls='" + urls + '\'' +
                        ", resources=" + resources +
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

            public FlowBeanX getFlow() {
                return flow;
            }

            public void setFlow(FlowBeanX flow) {
                this.flow = flow;
            }

            public ProcessBeanX getProcess() {
                return process;
            }

            public void setProcess(ProcessBeanX process) {
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

            public List<?> getResources() {
                return resources;
            }

            public void setResources(List<?> resources) {
                this.resources = resources;
            }

            public static class CreateByBean {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * name : dongdong
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

            public static class FlowBeanX {
                /**
                 * id : f9f133f6d0294b9b8909ed2262b02c69
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

            public static class ProcessBeanX {
                /**
                 * id : be091cd5cdbc4b778494d54c870e7add
                 * isNewRecord : false
                 * name : 工序A
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * positionNames : []
                 * parentId : 0
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
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * name : dongdong
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
        }
    }
}
