/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;



/**
 * tbl_review_replyEntity
 * @author caoyuan
 * @version 2016-12-29
 */
public class ReviewReply extends DataEntity<ReviewReply> {
	
	private static final long serialVersionUID = 1L;
	private Review review;		// review_id 父类
	private String contents;		// contents
	
	public ReviewReply() {
		super();
	}

	public ReviewReply(String id){
		super(id);
	}

	public ReviewReply(Review review){
		this.review = review;
	}

	//@Length(min=1, max=64, message="review_id长度必须介于 1 和 64 之间")
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	//@Length(min=1, max=64, message="contents长度必须介于 1 和 64 之间")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}