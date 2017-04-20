package com.blanink.pojo;

public class CompanyEmp {
	
      public String officeId;
      public String officeName;
      public String roleId;
      public String roleName;
      public String empId;
      public String empName;
      
      
	@Override
	public String toString() {
		return "CompanyEmp [officeId=" + officeId + ", officeName=" + officeName + ", roleId=" + roleId + ", roleName="
				+ roleName + ", empId=" + empId + ", empName=" + empName + "]";
	}
	public CompanyEmp(String officeId, String officeName, String roleId, String roleName, String empId,
			String empName) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.empId = empId;
		this.empName = empName;
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
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
      
}
