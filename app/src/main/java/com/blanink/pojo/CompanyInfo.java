package com.blanink.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfo {
   public String officeId;
   public String officeName;
   public List<Role> roleList=new ArrayList<>();
   
public CompanyInfo() {
	super();
}
public CompanyInfo(String officeId, String officeName) {
	super();
	this.officeId = officeId;
	this.officeName = officeName;
}
@Override
public String toString() {
	return "CompanyInfo [officeId=" + officeId + ", officeName=" + officeName + ", roleList=" + roleList + "]";
}
public String getOfficeId() {
	return officeId;
}
public void setOfficeId(String officeId) {
	this.officeId = officeId;
}
public String getOfficeName() {
	return officeName;
}
public void setOfficeName(String officeName) {
	this.officeName = officeName;
}
public List<Role> getRoleList() {
	return roleList;
}
public void setRoleList(List<Role> roleList) {
	this.roleList = roleList;
}
   
}
