/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 合作伙伴Entity
 * @author CaoYuan
 * @version 2016-11-01
 */
public class Partner extends DataEntity<Partner> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 合作伙伴类型
	private Office companyA;		// 甲方公司
	private Office companyB;		// 乙方公司
	private String flag;  //1.上家，2.下家
	private List<Resource> resources  = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Office getCompanyA() {
		return companyA;
	}

	public void setCompanyA(Office companyA) {
		this.companyA = companyA;
	}

	public Office getCompanyB() {
		return companyB;
	}

	public void setCompanyB(Office companyB) {
		this.companyB = companyB;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}