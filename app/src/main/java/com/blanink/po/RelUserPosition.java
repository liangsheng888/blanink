/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 用户岗位Entity
 * @author caoyuan
 * @version 2016-11-08
 */
public class RelUserPosition extends DataEntity<RelUserPosition> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 用户编号
	private Position position;		// 角色编号
	
	public RelUserPosition() {
		super();
	}

	public RelUserPosition(String id){
		super(id);
	}

	//@NotNull(message="用户编号不能为空")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//@NotNull(message="角色编号不能为空")
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}