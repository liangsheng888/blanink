/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;

import java.util.Date;


/**
 * 分工Entity
 * @author caoyuan
 * @version 2017-01-04
 */
public class WorkPlan {
	
	private static final long serialVersionUID = 1L;
	private String process;		// process_id
	private String fflow;		// flow_id
	private String user;		// 分配人编号
	private Date planTime;		// 计划完成时间
	private String workerId;		// 被分配人编号
	private Date finishTime;		// 完成时间
	private String achieveAmount;		// 完成数量
	
	public WorkPlan() {
		super();
	}


	//@Length(min=1, max=64, message="process_id长度必须介于 1 和 64 之间")
	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}
	
	//@Length(min=1, max=64, message="flow_id长度必须介于 1 和 64 之间")
	public String getFflow() {
		return fflow;
	}

	public void setFflow(String fflow) {
		this.fflow = fflow;
	}
	
	//@Length(min=1, max=64, message="分配人编号长度必须介于 1 和 64 之间")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@NotNull(message="计划完成时间不能为空")
	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}
	
	//@Length(min=1, max=64, message="被分配人编号长度必须介于 1 和 64 之间")
	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@NotNull(message="完成时间不能为空")
	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	public String getAchieveAmount() {
		return achieveAmount;
	}

	public void setAchieveAmount(String achieveAmount) {
		this.achieveAmount = achieveAmount;
	}
	
}