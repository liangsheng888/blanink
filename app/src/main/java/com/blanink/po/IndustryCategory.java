/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;
import java.util.ArrayList;
import java.util.List;



/**
 * 行业类别Entity
 * @author CaoYuan
 * @version 2016-11-02
 */
public class IndustryCategory extends TreeEntity<IndustryCategory> {
	
	private static final long serialVersionUID = 1L;
	private IndustryCategory parent;		// 父级编号
	private  String id;
	private List<RelIndustryCategoryAttribute> categoryAttributeList= new ArrayList<RelIndustryCategoryAttribute>();
	public IndustryCategory() {
		super();
	}

	public IndustryCategory(String id){
		super(id);
	}

	@Override
	public IndustryCategory getParent() {
		return null;
	}

	@Override
	public void setParent(IndustryCategory parent) {

	}


}