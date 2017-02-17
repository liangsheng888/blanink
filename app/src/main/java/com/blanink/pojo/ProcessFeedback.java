/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.lang.*;

/**
 * 工序反馈Entity
 * @author 工序反馈
 * @version 2016-12-08
 */
public class ProcessFeedback extends DataEntity<ProcessFeedback> {
	
	private static final long serialVersionUID = 1L;
	private Flow flow;
	private java.lang.Process process;
	private Integer faultAmount;		// 次品数量
	private String isFinished;		// 工序完成
	private Integer achieveAmount;		// 完成数量
	private Integer achievePercent;		// 完成百分比
	
	public ProcessFeedback() {
		super();
	}

	public ProcessFeedback(String id){
		super(id);
	}

	public Integer getFaultAmount() {
		return faultAmount;
	}

	public void setFaultAmount(Integer faultAmount) {
		this.faultAmount = faultAmount;
	}
	
	//@Length(min=0, max=1, message="工序完成长度必须介于 0 和 1 之间")
	public String getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
	
	public Integer getAchieveAmount() {
		return achieveAmount;
	}

	public void setAchieveAmount(Integer achieveAmount) {
		this.achieveAmount = achieveAmount;
	}
	
	public Integer getAchievePercent() {
		return achievePercent;
	}

	public void setAchievePercent(Integer achievePercent) {
		this.achievePercent = achievePercent;
	}

	//@NotNull
	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}

	//@NotNull
	public java.lang.Process getProcess() {
		return process;
	}

	public void setProcess(java.lang.Process process) {
		this.process = process;
	}
	
	
	
}