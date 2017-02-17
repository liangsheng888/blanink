/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;


import java.util.List;

/**
 * 公司产品Entity
 * @author CaoYuan
 * @version 2016-11-03
 */
public class CompanyProduct  {
	
	private static final long serialVersionUID = 1L;
	private Office company;		// 公司编号
	private CompanyCategory companyCategory;		// 产品类别编号
	private String productName;		// 产品名称
	private String productDescription;		// 产品描述
	private String productPriceDownline;		// 公司产品价格下限
	private String productPriceHighline;		// 公司产品价格上限
	private String productPhotos;          // 产品图片
	private List<CompanyProductSpecification> specificationList;   //公司产品规格表

	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public CompanyCategory getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(CompanyCategory companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPriceDownline() {
		return productPriceDownline;
	}

	public void setProductPriceDownline(String productPriceDownline) {
		this.productPriceDownline = productPriceDownline;
	}

	public String getProductPriceHighline() {
		return productPriceHighline;
	}

	public void setProductPriceHighline(String productPriceHighline) {
		this.productPriceHighline = productPriceHighline;
	}

	public String getProductPhotos() {
		return productPhotos;
	}

	public void setProductPhotos(String productPhotos) {
		this.productPhotos = productPhotos;
	}

	public List<CompanyProductSpecification> getSpecificationList() {
		return specificationList;
	}

	public void setSpecificationList(List<CompanyProductSpecification> specificationList) {
		this.specificationList = specificationList;
	}
}