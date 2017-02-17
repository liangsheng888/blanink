/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.util.Date;
import java.util.List;


/**
 * 订单Entity
 * @author CaoYuan
 * @version 2016-11-07
 */
public class OrderProduct extends DataEntity<OrderProduct> {
	
	private static final long serialVersionUID = 1L;
	private Order order;		// 订单编号 父类
	private String actualFlowId;		// 流程实例编号
	private CompanyCategory companyCategory;		// 公司叶子节点
	private String price;		// 产品价格（借款资金额度）
	private String amount;		// 产品数量
	private String productDescription;		// 订单实例描述
	private String rate;		// 利率
	private String isAConfirm;		// 是否甲方确认
	private String confirmUserid;		// 甲方确认人
	private Date aConfirmTime;		// 确认时间
	private Date deliveryTime;       //交付时间
	private String orderProductType;		// 订单产品采购类型（外加工，采购）
	private String crudType ;		// 添删改查状态
	private String productName;     // 产品规格
	private List<OrderProductSpecification> orderProductSpecificationList;
	
	public OrderProduct() {
		super();
	}

	public OrderProduct(String id){
		super(id);
	}

	public OrderProduct(Order order){
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public String getProductName() {
		return productName;
	}
	

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<OrderProductSpecification> getOrderProductSpecificationList() {
		return orderProductSpecificationList;
	}

	public void setOrderProductSpecificationList(List<OrderProductSpecification> orderProductSpecificationList) {
		this.orderProductSpecificationList = orderProductSpecificationList;
	}

	//@Length(min=0, max=64, message="流程实例编号长度必须介于 0 和 64 之间")
	public String getActualFlowId() {
		return actualFlowId;
	}

	public void setActualFlowId(String actualFlowId) {
		this.actualFlowId = actualFlowId;
	}
	
	
	
	public CompanyCategory getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(CompanyCategory companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	//@Length(min=1, max=11, message="产品数量长度必须介于 1 和 11 之间")
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
//	@Length(min=0, max=45, message="利率长度必须介于 0 和 45 之间")
	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	//
	//@Length(min=0, max=1, message="是否甲方确认长度必须介于 0 和 1 之间")
	public String getIsAConfirm() {
		return isAConfirm;
	}

	public void setIsAConfirm(String isAConfirm) {
		this.isAConfirm = isAConfirm;
	}
	
	//@Length(min=0, max=64, message="甲方确认人长度必须介于 0 和 64 之间")
	public String getConfirmUserid() {
		return confirmUserid;
	}

	public void setConfirmUserid(String confirmUserid) {
		this.confirmUserid = confirmUserid;
	}
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAConfirmTime() {
		return aConfirmTime;
	}

	public void setAConfirmTime(Date aConfirmTime) {
		this.aConfirmTime = aConfirmTime;
	}
	
	//@Length(min=0, max=1, message="订单产品采购类型（外加工，采购）长度必须介于 0 和 1 之间")
	public String getOrderProductType() {
		return orderProductType;
	}

	public void setOrderProductType(String orderProductType) {
		this.orderProductType = orderProductType;
	}

	public String getCrudType() {
		return crudType;
	}

	public void setCrudType(String crudType) {
		this.crudType = crudType;
	}
	
	
	
}