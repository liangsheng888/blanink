/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * 类别Entity
 * @author CaoYuan
 * @version 2016-11-02
 */
public class CompanyCategory {
	
	private static final long serialVersionUID = 1L;
	private CompanyCategory parent;		// 父级编号
	private Office company;			    // 公司
	private String isLeaf;              //0:公司产品类别  1:产品类
	private String serveType;           //0:采购 , 1:外加工, 2:贷款 , 3:股权投资
	private String unit;                //单位
	private RelIndustryCategoryAttribute relIndustryCategoryAttribute; //行业类别与属性关系表的id

	public CompanyCategory getParent() {
		return parent;
	}

	public void setParent(CompanyCategory parent) {
		this.parent = parent;
	}

	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getServeType() {
		return serveType;
	}

	public void setServeType(String serveType) {
		this.serveType = serveType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public RelIndustryCategoryAttribute getRelIndustryCategoryAttribute() {
		return relIndustryCategoryAttribute;
	}

	public void setRelIndustryCategoryAttribute(RelIndustryCategoryAttribute relIndustryCategoryAttribute) {
		this.relIndustryCategoryAttribute = relIndustryCategoryAttribute;
	}
}