package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 * 公司客户
 */

public class ManyCustomer implements Serializable {
    private String errorCode;
    private String reason;
    private Result result;
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result implements Serializable {
        public Integer total;
        public List<Customer> rows;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<Customer> getRows() {
            return rows;
        }

        public void setRows(List<Customer> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        public static class Customer implements Serializable {

            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public CreateBy createBy;
            public String createDate;
            public String updateDate;
            public String type;
            public Company companyA;//上家
            public Company companyB;//下家
            public String isCustomer;
            public String reviewStatus;
            public List<String> resources;//url以,号隔开
            public Boolean next;
            public String urls;
            public String sendMessage;

            public Company getCompanyA() {
                return companyA;
            }

            public void setCompanyA(Company companyA) {
                this.companyA = companyA;
            }

            public Company getCompanyB() {
                return companyB;
            }

            public void setCompanyB(Company companyB) {
                this.companyB = companyB;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Boolean getNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(Boolean newRecord) {
                isNewRecord = newRecord;
            }

            public CreateBy getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateBy createBy) {
                this.createBy = createBy;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
            public String getIsCustomer() {
                return isCustomer;
            }

            public void setIsCustomer(String isCustomer) {
                this.isCustomer = isCustomer;
            }

            public String getReviewStatus() {
                return reviewStatus;
            }

            public void setReviewStatus(String reviewStatus) {
                this.reviewStatus = reviewStatus;
            }

            public List<String> getResources() {
                return resources;
            }

            public void setResources(List<String> resources) {
                this.resources = resources;
            }

            public Boolean getNext() {
                return next;
            }

            public void setNext(Boolean next) {
                this.next = next;
            }

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }
            @Override
            public String toString() {
                return "Customer{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", type='" + type + '\'' +
                        ", companyA=" + companyA +
                        ", companyB=" + companyB +
                        ", isCustomer='" + isCustomer + '\'' +
                        ", reviewStatus='" + reviewStatus + '\'' +
                        ", resources=" + resources +
                        ", next=" + next +
                        ", urls='" + urls + '\'' +
                        ", sendMessage='" + sendMessage + '\'' +
                        '}';
            }
        }

        public static class CreateBy implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String name;
            public String loginFlag;
            public List roleList;
            public String roleNames;
            public Boolean admin;

            @Override
            public String toString() {
                return "CreateBy{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", name='" + name + '\'' +
                        ", loginFlag='" + loginFlag + '\'' +
                        ", admin=" + admin +
                        ", roleNames='" + roleNames + '\'' +
                        '}';
            }
        }

        public static class Company implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String remarks;
            public CreateBy createBy;
            public String createDate;
            public String updateDate;
            public String parentIds;
            public String name;
            public Integer sort;
            public Area area;
            public String code;
            public String shortName;
            public String registTime;
            public String scope;
            public String type;
            public String serviceType;
            public String grade;
            public String address;
            public String zipCode;
            public String master;
            public String phone;
            public String photo;
            public String fax;
            public String email;
            public String useable;
            public CreateCompanyBy createCompanyBy;//创建虚拟客户
            public Person primaryPerson;
            public Person deputyPerson;
            public List<CustomerService> customerServiceList;
            public String homepage;
            public Double reviewOthers;
            public Double reviewSelf;
            public Double otherCosting;
            public Double otherPayment;
            public Double otherQuality;
            public Double otherService;
            public Double otherTime;
            public Double selfPayment;
            public Double selfQuality;
            public Double selfService;
            public Double selfCosting;
            public Double selfTime;
            public Integer serviceCount;
            public String parentId;

            public Area getArea() {
                return area;
            }

            public void setArea(Area area) {
                this.area = area;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getUseable() {
                return useable;
            }

            public void setUseable(String useable) {
                this.useable = useable;
            }

            public List<CustomerService> getCustomerServiceList() {
                return customerServiceList;
            }

            public void setCustomerServiceList(List<CustomerService> customerServiceList) {
                this.customerServiceList = customerServiceList;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Boolean getNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(Boolean newRecord) {
                isNewRecord = newRecord;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getSort() {
                return sort;
            }

            public void setSort(Integer sort) {
                this.sort = sort;
            }


            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getMaster() {
                return master;
            }

            public void setMaster(String master) {
                this.master = master;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public CreateCompanyBy getCreateCompanyBy() {
                return createCompanyBy;
            }

            public void setCreateCompanyBy(CreateCompanyBy createCompanyBy) {
                this.createCompanyBy = createCompanyBy;
            }

            @Override
            public String toString() {
                return "Company{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", parentIds='" + parentIds + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", area=" + area +
                        ", code='" + code + '\'' +
                        ", shortName='" + shortName + '\'' +
                        ", registTime='" + registTime + '\'' +
                        ", scope='" + scope + '\'' +
                        ", type='" + type + '\'' +
                        ", serviceType='" + serviceType + '\'' +
                        ", grade='" + grade + '\'' +
                        ", address='" + address + '\'' +
                        ", zipCode='" + zipCode + '\'' +
                        ", master='" + master + '\'' +
                        ", phone='" + phone + '\'' +
                        ", fax='" + fax + '\'' +
                        ", email='" + email + '\'' +
                        ", useable='" + useable + '\'' +
                        ", createCompanyBy=" + createCompanyBy +
                        ", primaryPerson=" + primaryPerson +
                        ", deputyPerson=" + deputyPerson +
                        ", customerServiceList=" + customerServiceList +
                        ", homepage='" + homepage + '\'' +
                        ", reviewOthers=" + reviewOthers +
                        ", reviewSelf=" + reviewSelf +
                        ", otherCosting=" + otherCosting +
                        ", otherPayment=" + otherPayment +
                        ", otherQuality=" + otherQuality +
                        ", otherService=" + otherService +
                        ", otherTime=" + otherTime +
                        ", selfPayment=" + selfPayment +
                        ", selfQuality=" + selfQuality +
                        ", selfService=" + selfService +
                        ", selfCosting=" + selfCosting +
                        ", selfTime=" + selfTime +
                        ", serviceCount=" + serviceCount +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

    }

    public static class CustomerService implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public String no;
        public String name;
        public String email;
        public String phone;
        public String mobile;
        public String loginFlag;
        public List roleList;
        public String roleNames;
        public Boolean admin;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(Boolean newRecord) {
            isNewRecord = newRecord;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        @Override
        public String toString() {
            return "CustomerService{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", loginFlag='" + loginFlag + '\'' +
                    ", roleNames='" + roleNames + '\'' +
                    ", admin=" + admin +
                    '}';
        }

    }

    public static class Person implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public String name;
        public String loginFlag;
        public List  roleList;
        public String roleNames;
        public Boolean admin;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Boolean getNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(Boolean newRecord) {
            isNewRecord = newRecord;
        }

        public String getLoginFlag() {
            return loginFlag;
        }

        public void setLoginFlag(String loginFlag) {
            this.loginFlag = loginFlag;
        }

        public String getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(String roleNames) {
            this.roleNames = roleNames;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", name='" + name + '\'' +
                    ", loginFlag='" + loginFlag + '\'' +
                    ", roleNames='" + roleNames + '\'' +
                    ", admin=" + admin +
                    '}';
        }
    }

    public static class CreateCompanyBy implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public Integer sort;
        public String type;
        public List<CustomerService> customerServiceList;
        public Double reviewOthers;
        public Double reviewSelf;
        public Integer otherCosting;
        public Integer otherPayment;
        public Integer otherQuality;
        public Integer otherService;
        public Integer otherTime;
        public Integer selfPayment;
        public Integer selfQuality;
        public Integer selfService;
        public Integer selfCosting;
        public Integer selfTime;
        public Integer serviceCount;
        public String parentId;

        @Override
        public String toString() {
            return "CreateCompanyBy{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", sort=" + sort +
                    ", type='" + type + '\'' +
                    ", customerServiceList=" + customerServiceList +
                    ", reviewOthers=" + reviewOthers +
                    ", reviewSelf=" + reviewSelf +
                    ", otherCosting=" + otherCosting +
                    ", otherPayment=" + otherPayment +
                    ", otherQuality=" + otherQuality +
                    ", otherService=" + otherService +
                    ", otherTime=" + otherTime +
                    ", selfPayment=" + selfPayment +
                    ", selfQuality=" + selfQuality +
                    ", selfService=" + selfService +
                    ", selfCosting=" + selfCosting +
                    ", selfTime=" + selfTime +
                    ", serviceCount=" + serviceCount +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }

    public static class Area implements Serializable {
        public String id;
        public Boolean isNewRecord;
        public String parentIds;
        public String name;
        public Integer sort;
        public String parentId;

        public Boolean getNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(Boolean newRecord) {
            isNewRecord = newRecord;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "Area{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", parentIds='" + parentIds + '\'' +
                    ", name='" + name + '\'' +
                    ", sort=" + sort +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ManyCustomer{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}



