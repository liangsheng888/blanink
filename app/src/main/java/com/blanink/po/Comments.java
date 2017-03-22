/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 订单评论Entity
 * @author caoyuan
 * @version 2016-12-07
 */
public class Comments extends TreeEntity<Comments> {
	private String id;
	private static final long serialVersionUID = 1L;
	private Comments parent;		// 父级编号
	private String score;		// 分数
	private OrderProduct orderProduct;		// order_product_id
	private String review;		// 检讨 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Comments() {
		super();
	}

	public Comments(String id){
		super(id);
	}

	public Comments getParent() {
		return parent;
	}

	public void setParent(Comments parent) {
		this.parent = parent;
	}
	
	//@Length(min=1, max=11, message="分数长度必须介于 1 和 11 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	//@Length(min=1, max=64, message="order_product_id长度必须介于 1 和 64 之间")
	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}
	
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}