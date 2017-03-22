/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;


/**
 * 资源Entity
 * @author CaoYuan
 * @version 2016-10-28
 */
public class Resource extends DataEntity<Resource> {
	
	private static final long serialVersionUID = 1L;
	private String resourceName;		// 资源名称
	private String resourceType;		// 资源类型
	private String resourceUrl;		// 资源URL
	private String resourceProperty;		// 资源属性
	private String referrenceObjectId;		// 参考对象_id_跟据type来定
	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Resource() {
		super();
	}

	public Resource(String id){
		super(id);
	}
	//@Length(min=1, max=300, message="资源名称长度必须介于 1 和 300 之间")
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	//@Length(min=1, max=10, message="资源类型长度必须介于 1 和 10 之间")
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	//@Length(min=1, max=200, message="资源URL长度必须介于 1 和 200 之间")

	@Override
	public String toString() {
		return "Resource{" +
				"resourceName='" + resourceName + '\'' +
				", resourceType='" + resourceType + '\'' +
				", resourceUrl='" + resourceUrl + '\'' +
				", resourceProperty='" + resourceProperty + '\'' +
				", referrenceObjectId='" + referrenceObjectId + '\'' +
				'}';
	}

	//@Length(min=0, max=100, message="资源属性长度必须介于 0 和 100 之间")
	public String getResourceProperty() {
		return resourceProperty;
	}

	public void setResourceProperty(String resourceProperty) {
		this.resourceProperty = resourceProperty;
	}
	
	//@Length(min=1, max=64, message="参考对象_id_跟据type来定长度必须介于 1 和 64 之间")
	public String getReferrenceObjectId() {
		return referrenceObjectId;
	}

	public void setReferrenceObjectId(String referrenceObjectId) {
		this.referrenceObjectId = referrenceObjectId;
	}
	
}