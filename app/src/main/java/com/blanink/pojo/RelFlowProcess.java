package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/12.
 * 流程工序
 */
public class RelFlowProcess implements Serializable{
    private String processId;
    private String processName;
    private String flowId;

    private String type;
    private Integer target;
    private String processPriority;//本工序的优先级
    private String isPublic;		// 本工序是否公开

    private String remarks;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "RelFlowProcess{" +
                "target=" + target +
                ", remarks='" + remarks + '\'' +
                ", processPriority='" + processPriority + '\'' +
                ", isPublic='" + isPublic + '\'' +
                '}';
    }


    public RelFlowProcess(String processId, String processName, String flowId, String type, Integer target, String processPriority, String isPublic, String remarks) {
        this.processId = processId;
        this.processName = processName;
        this.flowId = flowId;
        this.type = type;
        this.target = target;
        this.processPriority = processPriority;
        this.isPublic = isPublic;
        this.remarks = remarks;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProcessPriority() {
        return processPriority;
    }

    public void setProcessPriority(String processPriority) {
        this.processPriority = processPriority;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
