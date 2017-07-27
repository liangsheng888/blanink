package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */

public class TypeCateGory implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"dba2451757ec45c18c0f40ab26642dab","isNewRecord":false,"remarks":"","createDate":"2017-03-04 13:38:18","updateDate":"2017-03-04 13:38:18","value":"1","label":"马上解决","type":"sys_assign_priority","description":"分配任务优先级","sort":10,"parentId":"0"},{"id":"0d6d7aa9b6b4475d80ec7d065d593786","isNewRecord":false,"remarks":"","createDate":"2017-03-04 13:38:27","updateDate":"2017-03-04 13:38:27","value":"2","label":"急需解决","type":"sys_assign_priority","description":"分配任务优先级","sort":20,"parentId":"0"},{"id":"8cfd29dff0c841f1a62be2151c6e9d7c","isNewRecord":false,"remarks":"","createDate":"2017-03-04 13:38:39","updateDate":"2017-03-04 13:38:39","value":"3","label":"高度重视","type":"sys_assign_priority","description":"分配任务优先级","sort":30,"parentId":"0"},{"id":"1527bc665b934fc29d57ccedd72058cd","isNewRecord":false,"remarks":"","createDate":"2017-03-04 13:38:48","updateDate":"2017-03-04 13:38:48","value":"4","label":"正常处理","type":"sys_assign_priority","description":"分配任务优先级","sort":40,"parentId":"0"},{"id":"de9f7ebead4f44f1b59b170a8268fdaa","isNewRecord":false,"remarks":"","createDate":"2017-03-04 13:39:03","updateDate":"2017-03-04 13:39:03","value":"5","label":"稍缓","type":"sys_assign_priority","description":"分配任务优先级","sort":50,"parentId":"0"}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "TypeCateGory{" +
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
         * id : dba2451757ec45c18c0f40ab26642dab
         * isNewRecord : false
         * remarks :
         * createDate : 2017-03-04 13:38:18
         * updateDate : 2017-03-04 13:38:18
         * value : 1
         * label : 马上解决
         * type : sys_assign_priority
         * description : 分配任务优先级
         * sort : 10
         * parentId : 0
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private String createDate;
        private String updateDate;
        private String value;
        private String label;
        private String type;
        private String description;
        private int sort;
        private String parentId;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", value='" + value + '\'' +
                    ", label='" + label + '\'' +
                    ", type='" + type + '\'' +
                    ", description='" + description + '\'' +
                    ", sort=" + sort +
                    ", parentId='" + parentId + '\'' +
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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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
