/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;

/**
 * 公司产品规格表Entity
 * @author caoyuan
 * @version 2016-11-15
 */
public class CompanyProductSpecification {
	
	private static final long serialVersionUID = 1L;
	private CompanyProduct companyProduct;		// 公司 产品编号
	private String  attributeId;		// 产品类的id
	private String attributeValue;		// 产品属性值

	public CompanyProduct getCompanyProduct() {
		return companyProduct;
	}

	public void setCompanyProduct(CompanyProduct companyProduct) {
		this.companyProduct = companyProduct;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
}