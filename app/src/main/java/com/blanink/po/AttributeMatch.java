/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;

/**
 * 匹配表Entity
 * @author caoyuan
 * @version 2016-11-15
 */
public class AttributeMatch {
	
	private static final long serialVersionUID = 1L;
	private Office aCompany;		// 甲方公司编号
	private Office bCompany;		// 乙方公司编号
	private CompanyCategory aProductCategory;		// 甲方产品类编号
	private CompanyCategory bProductCategory;		// 乙方产品类编号
	private Attribute aCategoryAttribute;		// 甲方属性编号
	private Attribute bCategoryAttribute;		// 乙方属性编号

	public Office getaCompany() {
		return aCompany;
	}

	public void setaCompany(Office aCompany) {
		this.aCompany = aCompany;
	}

	public Office getbCompany() {
		return bCompany;
	}

	public void setbCompany(Office bCompany) {
		this.bCompany = bCompany;
	}

	public CompanyCategory getaProductCategory() {
		return aProductCategory;
	}

	public void setaProductCategory(CompanyCategory aProductCategory) {
		this.aProductCategory = aProductCategory;
	}

	public CompanyCategory getbProductCategory() {
		return bProductCategory;
	}

	public void setbProductCategory(CompanyCategory bProductCategory) {
		this.bProductCategory = bProductCategory;
	}

	public Attribute getaCategoryAttribute() {
		return aCategoryAttribute;
	}

	public void setaCategoryAttribute(Attribute aCategoryAttribute) {
		this.aCategoryAttribute = aCategoryAttribute;
	}

	public Attribute getbCategoryAttribute() {
		return bCategoryAttribute;
	}

	public void setbCategoryAttribute(Attribute bCategoryAttribute) {
		this.bCategoryAttribute = bCategoryAttribute;
	}
}