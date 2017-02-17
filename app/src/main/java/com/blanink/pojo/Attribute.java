/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;


/**
 * 属性Entity
 * @author CaoYuan
 * @version 2016-10-31
 */
public class Attribute {
	
	private static final long serialVersionUID = 1L;
	private Attribute parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private Office company;
	private boolean isPublic;

	public Attribute getParent() {
		return parent;
	}

	public void setParent(Attribute parent) {
		this.parent = parent;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}
}