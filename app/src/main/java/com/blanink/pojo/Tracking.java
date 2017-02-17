/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.pojo;

/**
 * 追踪器Entity
 * @author 追踪器
 * @version 2016-11-14
 */
public class Tracking extends DataEntity<Tracking> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 追踪器名称
	private String keyword;		// 关键字
	private String country;		// 国家
	private String province;		// 省
	private String city;		// 市
	private String type;		// 追踪器类型(1,买家/招标,2,卖家/产品)
	private String searchFrom;		// 搜索来源（全文，标题）
	
	public Tracking() {
		super();
	}

	public Tracking(String id){
		super(id);
	}

	//@Length(min=1, max=128, message="追踪器名称长度必须介于 1 和 128 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//@Length(min=0, max=255, message="关键字长度必须介于 0 和 255 之间")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	//@Length(min=0, max=64, message="国家长度必须介于 0 和 64 之间")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	//@Length(min=0, max=64, message="省长度必须介于 0 和 64 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	//@Length(min=0, max=64, message="市长度必须介于 0 和 64 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	//@Length(min=0, max=1, message="追踪器类型(1,买家/招标,2,卖家/产品)长度必须介于 0 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//@Length(min=0, max=1, message="搜索来源（全文，标题）长度必须介于 0 和 1 之间")
	public String getSearchFrom() {
		return searchFrom;
	}

	public void setSearchFrom(String searchFrom) {
		this.searchFrom = searchFrom;
	}
	
}