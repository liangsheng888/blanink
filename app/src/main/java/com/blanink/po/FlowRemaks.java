/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 流程留言Entity
 * @author caoyuan
 * @version 2016-12-20
 */
public class FlowRemaks extends DataEntity<FlowRemaks> {
	
	private static final long serialVersionUID = 1L;
	private Flow flow;		// flow_id
	
	public FlowRemaks() {
		super();
	}

	public FlowRemaks(String id){
		super(id);
	}

	public Flow getFlow() {
		return flow;
	}

	public void setFlow(Flow flow) {
		this.flow = flow;
	}
	
}