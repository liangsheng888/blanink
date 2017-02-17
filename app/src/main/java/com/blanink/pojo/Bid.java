/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

import java.util.Date;
import java.util.List;

/**
 * 投标Entity
 * @author 投标
 * @version 2016-11-11
 */
public class Bid  {
	
	private static final long serialVersionUID = 1L;
	private InviteBid inviteBid;		// 招标编号
	private Office bidCompany;		// 投标公司编号
	private Date bidDate;		// 应标时间
	private String bidPrice;		// 应标价格
	private String attachment;		// 附件
	private List<InviteBidTalk> inviteBidTalkList;//某个Bid相关的所有沟通信息

	public InviteBid getInviteBid() {
		return inviteBid;
	}

	public void setInviteBid(InviteBid inviteBid) {
		this.inviteBid = inviteBid;
	}

	public Office getBidCompany() {
		return bidCompany;
	}

	public void setBidCompany(Office bidCompany) {
		this.bidCompany = bidCompany;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public List<InviteBidTalk> getInviteBidTalkList() {
		return inviteBidTalkList;
	}

	public void setInviteBidTalkList(List<InviteBidTalk> inviteBidTalkList) {
		this.inviteBidTalkList = inviteBidTalkList;
	}
}