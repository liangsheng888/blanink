/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 工序岗位表Entity
 * @author Caoyuan
 * @version 2016-11-08
 */
public class RelProcessPosition extends DataEntity<RelProcessPosition> {
	
	private static final long serialVersionUID = 1L;
	private Process process;		// process_id
	private Role position;		// position_id
	private String workRequest;		// work_request
	
	public RelProcessPosition() {
		super();
	}

	public RelProcessPosition(Process process,Role position){
		super();
		this.process = process;
		this.position = position;
	}

	public RelProcessPosition(Process process){
		super();
		this.process = process;
	}

	//@NotNull(message="process_id不能为空")
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
	
	//@NotNull(message="position_id不能为空")
	public Role getPosition() {
		return position;
	}

	public void setPosition(Role position) {
		this.position = position;
	}
	
	public String getWorkRequest() {
		return workRequest;
	}

	public void setWorkRequest(String workRequest) {
		this.workRequest = workRequest;
	}
	
}