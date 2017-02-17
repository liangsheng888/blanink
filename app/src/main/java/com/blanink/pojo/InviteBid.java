/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 招标Entity
 * @author 招标
 * @version 2016-11-11
 */
public class InviteBid extends DataEntity<InviteBid> {
	
	private static final long serialVersionUID = 1L;
	private Office inviteCompany;		// 招标公司编号
	private Date inviteDate;			// 招标日期
	private String buyProductName;		// 购买产品名称
	private String targetPrice;		// 目标价格
	private String downPayment;		// 预付定金
	private Date expireDate;      //采购失效时间
	private String attachment;		// 附件
	private List<Bid> bidList = new ArrayList<>();		// 子表列表
	private int count; //需采购的数量

	
	public InviteBid() {
		super();
	}

	public InviteBid(String id){
		super(id);
	}

	//@NotNull(message="招标公司编号不能为空")
	public Office getInviteCompany() {
		return inviteCompany;
	}

	public void setInviteCompany(Office inviteCompany) {
		this.inviteCompany = inviteCompany;
	}
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@NotNull(message="招标日期不能为空")
	public Date getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(Date inviteDate) {
		this.inviteDate = inviteDate;
	}
	
	//@Length(min=1, max=255, message="购买产品名称长度必须介于 1 和 255 之间")
	public String getBuyProductName() {
		return buyProductName;
	}

	public void setBuyProductName(String buyProductName) {
		this.buyProductName = buyProductName;
	}
	
	public String getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(String targetPrice) {
		this.targetPrice = targetPrice;
	}
	
	public String getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(String downPayment) {
		this.downPayment = downPayment;
	}

	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@NotNull(message="招标日期不能为空")
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	//@Length(min=0, max=255, message="附件长度必须介于 0 和 255 之间")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	public List<Bid> getBidList() {
		return bidList;
	}

	public void setBidList(List<Bid> bidList) {
		this.bidList = bidList;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}