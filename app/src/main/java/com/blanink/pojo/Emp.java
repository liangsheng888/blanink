package com.blanink.pojo;

public class Emp {
    public String EmpId;
    public String EmpName;
    
	public Emp() {
		super();
	}
	public Emp(String empId, String empName) {
		super();
		EmpId = empId;
		EmpName = empName;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	@Override
	public String toString() {
		return "Emp [EmpId=" + EmpId + ", EmpName=" + EmpName + "]";
	}
    
}
