/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 岗位Entity
 * @author caoyuan
 * @version 2016-11-08
 */
public class Position extends TreeEntity<Position> {
	
	private static final long serialVersionUID = 1L;
	private Position parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private Office company;		// 所在机构编号
	private String id;
	public Position() {
		super();
	}

	public Position(String id){
		super(id);
	}

	//@JsonBackReference
	//@NotNull(message="父级编号不能为空")
	public Position getParent() {
		return parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setParent(Position parent) {
		this.parent = parent;
	}
	
	//@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	//@NotNull(message="所在机构编号不能为空")
	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}