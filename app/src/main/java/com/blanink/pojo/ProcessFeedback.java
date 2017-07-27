package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 * 工序
 */

public class ProcessFeedback implements Serializable {
    public String errorCode;
    public String reason;
    public List<Result> result;

    @Override
    public String toString() {
        return "ProcessFeedback{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result{
        public String id;
        public Boolean isNewRecord;
        public String remarks;
        public LoginResult.ResultBean.CreateByBean createBy;
        public String createDate;
        public String updateDate;
        public String parentIds;
        public String name;//工序名称
        public Integer sort;
        public String type;
        public String feedbackType;
        public String isPublic;
        public CompanyProduct.Result.Company company;
        public List relPPList;
        public String parentId;

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", parentIds='" + parentIds + '\'' +
                    ", name='" + name + '\'' +
                    ", sort=" + sort +
                    ", type='" + type + '\'' +
                    ", feedbackType='" + feedbackType + '\'' +
                    ", isPublic='" + isPublic + '\'' +
                    ", company=" + company +
                    ", relPPList=" + relPPList +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }

}
