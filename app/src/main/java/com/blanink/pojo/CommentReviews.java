package com.blanink.pojo;

import java.io.Serializable;

public class CommentReviews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Review review; //自我检讨

	private Review comments;//评论

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Review getComments() {
		return comments;
	}

	public void setComments(Review comments) {
		this.comments = comments;
	}

}
