/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;
import java.util.ArrayList;
import java.util.List;


/**
 * tbl_review_replyEntity
 * @author caoyuan
 * @version 2016-12-29
 */
public class Review extends DataEntity<Review> {
	
	private static final long serialVersionUID = 1L;
	private String order;		// 订单
	private String orderProduct;		// 订单产品
	private String contents;		// 内容
	private String serviceGrade;		// 服务评分
	private String qualityGrade;		// 质量评分
	private String timingGrade;		// 时效评分
	private String costingGrade;		// 成本评分
	private String paymentGrade;		// 付款满意度
	private List<ReviewReply> reviewReplyList = new ArrayList<>();		// 子表列表
	
	public Review() {
		super();
	}

	public Review(String id){
		super(id);
	}

	//@Length(min=1, max=64, message="订单长度必须介于 1 和 64 之间")
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	//@Length(min=1, max=64, message="订单产品长度必须介于 1 和 64 之间")
	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}
	
	//@Length(min=1, max=245, message="内容长度必须介于 1 和 245 之间")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	//@Length(min=1, max=11, message="服务评分长度必须介于 1 和 11 之间")
	public String getServiceGrade() {
		return serviceGrade;
	}

	public void setServiceGrade(String serviceGrade) {
		this.serviceGrade = serviceGrade;
	}
	
	//@Length(min=1, max=11, message="质量评分长度必须介于 1 和 11 之间")
	public String getQualityGrade() {
		return qualityGrade;
	}

	public void setQualityGrade(String qualityGrade) {
		this.qualityGrade = qualityGrade;
	}
	
//	@Length(min=1, max=11, message="时效评分长度必须介于 1 和 11 之间")
	public String getTimingGrade() {
		return timingGrade;
	}

	public void setTimingGrade(String timingGrade) {
		this.timingGrade = timingGrade;
	}
	
	//@Length(min=1, max=11, message="成本评分长度必须介于 1 和 11 之间")
	public String getCostingGrade() {
		return costingGrade;
	}

	public void setCostingGrade(String costingGrade) {
		this.costingGrade = costingGrade;
	}
	
	//@Length(min=1, max=11, message="付款满意度长度必须介于 1 和 11 之间")
	public String getPaymentGrade() {
		return paymentGrade;
	}

	public void setPaymentGrade(String paymentGrade) {
		this.paymentGrade = paymentGrade;
	}
	
	public List<ReviewReply> getReviewReplyList() {
		return reviewReplyList;
	}

	public void setReviewReplyList(List<ReviewReply> reviewReplyList) {
		this.reviewReplyList = reviewReplyList;
	}
}