/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


import java.util.Date;

import java.util.List;


/**
 * 流程Entity
 * @author caoyuan
 * @version 2016-11-10
 */
public class Flow extends DataEntity<Flow> {
	
	private static final long serialVersionUID = 1L;
	private OrderProduct  orderProduct;		// 订单产品编号
	private String status;		// 状态
	private String isCommon;		// 是否常用
	private String isConfirm;		// 是否被确认
	private User confirmBy;		// 确认人
	private Date confirmDate;		// 确认时间
	private String name;		// 名称
	private String flowData;
	private String relations;
	private Date internalDeliveryDate; //内部交货日期
	private List<RelFlowProcess> processList ;		// 子表列表>
	private List<FlowRemaks> remaksList ;
	public Flow() {
		super();
	}

	public Flow(String id){
		super(id);
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public List<FlowRemaks> getRemaksList() {
		return remaksList;
	}

	public void setRemaksList(List<FlowRemaks> remaksList) {
		this.remaksList = remaksList;
	}

	public List<RelFlowProcess> getProcessList() {
		return processList;
	}

	public void setProcessList(List<RelFlowProcess> processList) {
		this.processList = processList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsCommon() {
		return isCommon;
	}

	public void setIsCommon(String isCommon) {
		this.isCommon = isCommon;
	}

	public String getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(String isConfirm) {
		this.isConfirm = isConfirm;
	}

	public User getConfirmBy() {
		return confirmBy;
	}

	public void setConfirmBy(User confirmBy) {
		this.confirmBy = confirmBy;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlowData() {
		return flowData;
	}

	public void setFlowData(String flowData) {
		this.flowData = flowData;
	}

	public String getRelations() {
		return relations;
	}

	public void setRelations(String relations) {
		this.relations = relations;
	}

	public Date getInternalDeliveryDate() {
		return internalDeliveryDate;
	}

	public void setInternalDeliveryDate(Date internalDeliveryDate) {
		this.internalDeliveryDate = internalDeliveryDate;
	}
}