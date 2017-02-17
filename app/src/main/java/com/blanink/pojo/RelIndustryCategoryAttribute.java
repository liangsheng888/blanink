/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;


import java.util.List;


import org.jetbrains.annotations.NotNull;

/**
 * 行业类别属性Entity
 * @author 行业类别属性
 * @version 2016-11-15
 */
public class RelIndustryCategoryAttribute extends DataEntity<RelIndustryCategoryAttribute> {
	
	private static final long serialVersionUID = 1L;
	private IndustryCategory category;		// 类别编号
	private Attribute attribute;		// 属性编号
	private String isRequired;          //是否必填    1必填  0可选
	private String inputType; 			//插入类型    1 文本框  2 下拉框 
	private String hardcodeValue;       //默认值         多个默认值之间用,隔开
	private String remarks;             //备注
	private int sort;					// 排序

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
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getHardcodeValue() {
		return hardcodeValue;
	}

	public void setHardcodeValue(String hardcodeValue) {
		this.hardcodeValue = hardcodeValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public RelIndustryCategoryAttribute() {
		super();
	}

	public RelIndustryCategoryAttribute(String id){
		super(id);
	}

	public RelIndustryCategoryAttribute(IndustryCategory industryCategory) {
		// TODO Auto-generated constructor stub
		super();
		this.category = industryCategory;
	}

	@NotNull("类别编号不能为空")
	public IndustryCategory getCategory() {
		return category;
	}

	public void setCategory(IndustryCategory category) {
		this.category = category;
	}
	
	@NotNull("属性编号不能为空")
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	
}