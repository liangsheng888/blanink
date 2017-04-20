package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class CompanyEmployeeInfo {
    private String companyId;
    private String companyName;
    private List<Role> roleNameList;
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Role> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<Role> roleNameList) {
        this.roleNameList = roleNameList;
    }



}
