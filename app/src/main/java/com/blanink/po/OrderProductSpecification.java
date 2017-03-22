/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 产品规格Entity
 * @author CaoYuan
 * @version 2016-10-28
 */
public class OrderProductSpecification extends DataEntity<OrderProductSpecification> {
	
	private static final long serialVersionUID = 1L;
	private OrderProduct orderProduct;		// 订单产品编号
	private Attribute attribute;		// 产品属性编号
	private String attributeValue;		// 产品属性值
	
	public OrderProductSpecification() {
		super();
	}

	public OrderProductSpecification(String id){
		super(id);
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}
	
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	//@Length(min=1, max=255, message="产品属性值长度必须介于 1 和 255 之间")
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	
}