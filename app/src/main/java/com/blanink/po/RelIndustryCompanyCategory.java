/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;
/**
 * 行业与公司分类关系Entity
 * @author CaoYuan
 * @version 2016-11-02
 */
public class RelIndustryCompanyCategory extends DataEntity<RelIndustryCompanyCategory> {
	
	private static final long serialVersionUID = 1L;
	private IndustryCategory industryCategory;		// industry_category_id
	private CompanyCategory companyCategory;		// company_category_id
	
	public RelIndustryCompanyCategory() {
		super();
	}

	public RelIndustryCompanyCategory(String id){
		super(id);
	}
	
	public RelIndustryCompanyCategory(CompanyCategory companyCategory){
		super();
		this.companyCategory = companyCategory;
	}
	//@NotNull(message="industry_category_id不能为空")
	public IndustryCategory getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(IndustryCategory industryCategory) {
		this.industryCategory = industryCategory;
	}
	
	//@NotNull(message="company_category_id不能为空")
	public CompanyCategory getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(CompanyCategory companyCategory) {
		this.companyCategory = companyCategory;
	}
	
}