/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;



/**
 * 类别与属性关系Entity
 * @author CaoYuan
 * @version 2016-11-05
 */

public class RelCategoryAttribute extends DataEntity<RelCategoryAttribute> {
	
	private static final long serialVersionUID = 1L;
	private CompanyCategory category;		// 类别编号
	private Attribute attribute;		// 属性编号
	private String isRequired;          //是否必填    1必填  0可选
	private String inputType; 			//插入类型    1 文本框  2 下拉框 
	private String hardcodeValue;       //默认值         多个默认值之间用,隔开
	private String remarks;             //备注
	private int sort;                   //排序
	
	
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public RelCategoryAttribute() {
		super();
	}

	public RelCategoryAttribute(String id){
		super(id);
	}

	public RelCategoryAttribute(CompanyCategory companyCategory) {
		super();
		this.category = companyCategory;
	}

	//@NotNull(message="类别编号不能为空")
	public CompanyCategory getCategory() {
		return category;
	}

	public void setCategory(CompanyCategory category) {
		this.category = category;
	}
	
	//@NotNull(message="属性编号不能为空")
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getHardcodeValue() {
		return hardcodeValue;
	}

	public void setHardcodeValue(String hardcodeValue) {
		this.hardcodeValue = hardcodeValue;
	}

}