/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.lang.*;
import java.util.List;


/**
 * 流程关系表Entity
 * @author caoyuan
 * @version 2016-12-12
 */
public class RelFlowProcess extends DataEntity<RelFlowProcess> {
	
	private static final long serialVersionUID = 1L;
	private Flow flow;		// flow_id
	private Process process;
	private Integer target;
	private String remarks;
    private ProcessFeedback latestFeedback;
    private String sort;//优先级
    
    public RelFlowProcess() {
		super();
	}

	public RelFlowProcess(String flowId,String processId){
		super();
		this.flow = new Flow(flowId);
		this.process = new Process(processId);
	}
	

	public RelFlowProcess(Flow flow) {
		// TODO Auto-generated constructor stub
		super();
		this.flow = flow;
	}

	public RelFlowProcess(Process process) {
		// TODO Auto-generated constructor stub
		super();
		this.process = process;
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public ProcessFeedback getLatestFeedback() {
		return latestFeedback;
	}

	public void setLatestFeedback(ProcessFeedback latestFeedback) {
		this.latestFeedback = latestFeedback;
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}