package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 * 流程工序
 */
public class RelFlow implements Serializable{

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"isNewRecord":true,"remarks":"试试事实上","flow":{"id":"1028a9c909124ccda57561a2d58c20f5","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"38ac68dffa2c4700ac3491812bea5116","isNewRecord":false,"name":"浙江公司工序B","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":888999,"processPriority":"1","status":"1","isPublic":"1"}
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
         * isNewRecord : true
         * remarks : 试试事实上
         * flow : {"id":"1028a9c909124ccda57561a2d58c20f5","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
         * process : {"id":"38ac68dffa2c4700ac3491812bea5116","isNewRecord":false,"name":"浙江公司工序B","sort":30,"type":"1","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
         * target : 888999
         * processPriority : 1
         * status : 1
         * isPublic : 1
         */

        private boolean isNewRecord;
        private String remarks;
        private FlowBean flow;
        private ProcessBean process;
        private int target;
        private String processPriority;
        private String status;
        private String isPublic;

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

        public String getIsPublic() {
            return isPublic;
        }

        public void setIsPublic(String isPublic) {
            this.isPublic = isPublic;
        }

        public static class FlowBean {
            /**
             * id : 1028a9c909124ccda57561a2d58c20f5
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
             * id : 38ac68dffa2c4700ac3491812bea5116
             * isNewRecord : false
             * name : 浙江公司工序B
             * sort : 30
             * type : 1
             * feedbackType : 1
             * relPPList : []
             * proList : []
             * parentId : 0
             * positionNames : []
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
    }
}
