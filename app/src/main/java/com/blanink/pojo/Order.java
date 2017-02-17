/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;


import android.text.format.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 订单Entity
 * @author CaoYuan
 * @version 2016-11-08
 */
public class Order extends TreeEntity<Order> {
	
	private static final long serialVersionUID = 1L;
	private String superId;		// 订单超级编号
	private Order parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private Office aCompany;		// 甲方公司编号
	private User aCompanyOrderOwnerUser;		// 甲方公司订单所有人编号
	private User aCompanyBuyUser;		// 甲方采购人编号
	private Office bCompany;		// 乙方公司编号
	private User bCompanyOrderOwnerUser;		// 乙方公司订单所有人编号
	private String aOrderNumber;		// 甲方公司用订单编号
	private String bOrderNumber;		// 甲方公司用订单编号
	private String orderStatus;		// 订单状态
	private Date takeOrderTime;		// 下单日期（yyyy-mm-dd）
	private Date delieverTime;		// 订单交货日期
	private String takeOrderTimeString ;
	private String delieverTimeString ;
	private String orderComments;		// 订单备注
	private String orderType;		// 订单类型
	private List<OrderProduct> orderProductList = new ArrayList<OrderProduct>(); // 订单下的产品集合
	private List<Order> orderList = new ArrayList<Order>();	
	private String crudType ;	    //添删改查类型
	private String action ;
	private int historyOrderNumber;

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	@Override
	public Order getParent() {
		return parent;
	}

	@Override
	public void setParent(Order parent) {
		this.parent = parent;
	}

	@Override
	public String getParentIds() {
		return parentIds;
	}

	@Override
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Office getaCompany() {
		return aCompany;
	}

	public void setaCompany(Office aCompany) {
		this.aCompany = aCompany;
	}

	public User getaCompanyOrderOwnerUser() {
		return aCompanyOrderOwnerUser;
	}

	public void setaCompanyOrderOwnerUser(User aCompanyOrderOwnerUser) {
		this.aCompanyOrderOwnerUser = aCompanyOrderOwnerUser;
	}

	public User getaCompanyBuyUser() {
		return aCompanyBuyUser;
	}

	public void setaCompanyBuyUser(User aCompanyBuyUser) {
		this.aCompanyBuyUser = aCompanyBuyUser;
	}

	public String getaOrderNumber() {
		return aOrderNumber;
	}

	public void setaOrderNumber(String aOrderNumber) {
		this.aOrderNumber = aOrderNumber;
	}

	public Office getbCompany() {
		return bCompany;
	}

	public void setbCompany(Office bCompany) {
		this.bCompany = bCompany;
	}

	public User getbCompanyOrderOwnerUser() {
		return bCompanyOrderOwnerUser;
	}

	public void setbCompanyOrderOwnerUser(User bCompanyOrderOwnerUser) {
		this.bCompanyOrderOwnerUser = bCompanyOrderOwnerUser;
	}

	public String getbOrderNumber() {
		return bOrderNumber;
	}

	public void setbOrderNumber(String bOrderNumber) {
		this.bOrderNumber = bOrderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getTakeOrderTime() {
		return takeOrderTime;
	}

	public void setTakeOrderTime(Date takeOrderTime) {
		this.takeOrderTime = takeOrderTime;
	}

	public Date getDelieverTime() {
		return delieverTime;
	}

	public void setDelieverTime(Date delieverTime) {
		this.delieverTime = delieverTime;
	}

	public String getTakeOrderTimeString() {
		return takeOrderTimeString;
	}

	public void setTakeOrderTimeString(String takeOrderTimeString) {
		this.takeOrderTimeString = takeOrderTimeString;
	}

	public String getDelieverTimeString() {
		return delieverTimeString;
	}

	public void setDelieverTimeString(String delieverTimeString) {
		this.delieverTimeString = delieverTimeString;
	}

	public String getOrderComments() {
		return orderComments;
	}

	public void setOrderComments(String orderComments) {
		this.orderComments = orderComments;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}

	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public String getCrudType() {
		return crudType;
	}

	public void setCrudType(String crudType) {
		this.crudType = crudType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getHistoryOrderNumber() {
		return historyOrderNumber;
	}

	public void setHistoryOrderNumber(int historyOrderNumber) {
		this.historyOrderNumber = historyOrderNumber;
	}
}