/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;
/**
 * 招标沟通Entity
 * @author 招标沟通
 * @version 2016-11-17
 */
public class InviteBidTalk extends DataEntity<InviteBidTalk> {
	private static final long serialVersionUID = 1L;
	private Bid bid;				//投标编号（里面有id的）
	private InviteBid inviteBid;	//招标id
	private User receiveUser;		//信息接收人id
	private String message;        //沟通内容
	private String attachment;     //招标沟通中用到的附件
	private String title;			//招标沟通的标题
	private Office sendPartyCompany; //发送方所在公司的id
	private Office receivePartyCompany;//接收方所在公司的id
	
	
	public InviteBidTalk(Bid bid) {
		super();
		this.bid = bid;
	}

	public Bid getBid() {
		return bid;
	}
	
	
	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public InviteBid getInviteBid() {
		return inviteBid;
	}

	public void setInviteBid(InviteBid inviteBid) {
		this.inviteBid = inviteBid;
	}

	public User getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(User receiveUser) {
		this.receiveUser = receiveUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InviteBidTalk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InviteBidTalk(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//@Length(min=0, max=255, message="附件长度必须介于 0 和 255 之间")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Office getSendPartyCompany() {
		return sendPartyCompany;
	}

	public void setSendPartyCompany(Office sendPartyCompany) {
		this.sendPartyCompany = sendPartyCompany;
	}

	public Office getReceivePartyCompany() {
		return receivePartyCompany;
	}

	public void setReceivePartyCompany(Office receivePartyCompany) {
		this.receivePartyCompany = receivePartyCompany;
	}
	
	
}