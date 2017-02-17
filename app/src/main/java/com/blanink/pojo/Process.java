/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 工序Entity
 * @author CaoYuan
 * @version 2016-11-08
 */
public class Process extends TreeEntity<Process> {
	
	private static final long serialVersionUID = 1L;
	private String id;



	private Process parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String type;		// 工序类型（采购，外加工，发货，借钱，还钱，外购，售后）
	private String feedbackType;		// 工序反馈类型（计件，非计件，其他）
	private String isPublic;		// 本工序是否公开
	private Office company;
	private List<RelProcessPosition> relPPList = new ArrayList<>();
	
	public Process() {
		super();
	}

	public Process(String id){
		super(id);
	}

	//@JsonBackReference
	//@NotNull(message="父级编号不能为空")
	public Process getParent() {
		return parent;
	}

	public void setParent(Process parent) {
		this.parent = parent;
	}
	
	//@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	//@Length(min=0, max=1, message="工序类型（采购，外加工，发货，借钱，还钱，外购，售后）长度必须介于 0 和 1 之间")
	public String getType() {
		return type;
	}

	public void setProcessType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	//@Length(min=0, max=1, message="工序反馈类型（计件，非计件，其他）长度必须介于 0 和 1 之间")
	public String getFeedbackType() {
		return feedbackType;
	}

	public void setProcessFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	
	//@Length(min=1, max=1, message="本工序是否公开长度必须介于 1 和 1 之间")
	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
	
	//@NotNull(message="公司编号不能为空")
	public Office getCompany() {
		return company;
	}

	
	public void setCompany(Office company) {
		this.company = company;
	}

	
	public List<RelProcessPosition> getRelPPList() {
		return relPPList;
	}

	public void setRelPPList(List<RelProcessPosition> relPPList) {
		this.relPPList = relPPList;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	//
	//@JsonIgnore
	public List<String> getPositionIdList() {
		List<String> positionIdList = new ArrayList<>();
		for (RelProcessPosition relpp : relPPList) {
			positionIdList.add(relpp.getPosition().getId());
		}
		return positionIdList;
	}
	
	//@JsonIgnore
	public List<String> getPositionNames() {
		List<String> positionNames = new ArrayList<>();
		for (RelProcessPosition relpp : relPPList) {
			positionNames.add(relpp.getPosition().getName());
		}
		return positionNames;
	}

	public void setPositionIdList(List<String> positionIdList) {
		relPPList = new ArrayList<>();
		for (String positionId : positionIdList) {
			RelProcessPosition relPP = new RelProcessPosition();
			relPP.setPosition(new Role(positionId));
			relPP.setProcess(this);
			relPPList.add(relPP);
		}
	}
}