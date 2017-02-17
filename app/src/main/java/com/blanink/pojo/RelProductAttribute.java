/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

/**
 * 产品与属性关系Entity
 * @author CaoYuan
 * @version 2016-10-31
 */
public class RelProductAttribute extends DataEntity<RelProductAttribute> {
	
	private static final long serialVersionUID = 1L;
	private String product;		// 公司产品编号
	private String attribute;		// 属性编号
	
	public RelProductAttribute() {
		super();
	}

	public RelProductAttribute(String id){
		super(id);
	}

	//@Length(min=1, max=64, message="公司产品编号长度必须介于 1 和 64 之间")
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	//@Length(min=1, max=64, message="属性编号长度必须介于 1 和 64 之间")
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}