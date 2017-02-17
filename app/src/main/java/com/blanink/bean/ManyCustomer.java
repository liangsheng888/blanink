package com.blanink.bean;

import com.blanink.pojo.Resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 * 公司客户
 */
/*
  "errorCode": "00000",
  "reason": "获取数据成功！",
  "result": {
    "total": 15,
    "rows": [
      {
        "id": "1849513223234c9f89dd35ad3a8b6387",
        "isNewRecord": false,
        "createBy": {
          "id": "d6c8e9bc4c2b476ba84b962c27882f41",
          "isNewRecord": false,
          "loginFlag": "1",
          "roleNames": "",
          "admin": false
        },
        "createDate": "2017-01-17 15:30:47",
        "updateDate": "2017-01-17 15:30:47",
        "companyA": {
          "id": "ee45bdbac1df402a8a7b6e195ab6ce53",
          "isNewRecord": false,
          "remarks": "dddd",
          "createBy": {
            "id": "d6c8e9bc4c2b476ba84b962c27882f41",
            "isNewRecord": false,
            "loginFlag": "1",
            "roleNames": "",
            "admin": false
          },
          "createDate": "2017-01-17 15:30:47",
          "updateDate": "2017-01-17 15:30:47",
          "parentIds": "0,",
          "name": "郑州富士康",
          "sort": 30,
          "area": {
            "id": "12",
            "isNewRecord": false,
            "parentIds": "0,1",
            "name": "江苏省",
            "sort": 30,
            "parentId": "0"
          },
          "scope": "零件加工",
          "type": "1",
          "grade": "1",
          "address": "河南郑州",
          "master": "李四",
          "phone": "133840000",
          "email": "1360@1663.com",
          "useable": "1",
          "createCompanyBy": {
            "id": "f541afa391974409ba680e9bd9a394fd",
            "isNewRecord": false,
            "sort": 30,
            "type": "1",
            "customerServiceList": [],
            "parentId": "0"
          },
          "customerServiceList": [
            {
              "id": "d6c8e9bc4c2b476ba84b962c27882f41",
              "isNewRecord": false,
              "no": "1000001",
              "name": "张三",
              "email": "jsadmin@123.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "447e4526d22045f59ed58250046b3842",
              "isNewRecord": false,
              "no": "1000001",
              "name": "李四",
              "email": "zjadmin@12.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "3c70d715d02a4c4aadc1952ecde286e1",
              "isNewRecord": false,
              "no": "1000001",
              "name": "王五",
              "email": "bjadmin@12.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "dbb482a1b0434543a37e2d12408384d2",
              "isNewRecord": false,
              "no": "1000002",
              "name": "老二",
              "email": "laoer@13.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            }
          ],
          "parentId": "0"
        },
        "companyB": {
          "id": "f541afa391974409ba680e9bd9a394fd",
          "isNewRecord": false,
          "remarks": "",
          "createBy": {
            "id": "1",
            "isNewRecord": false,
            "loginFlag": "1",
            "roleNames": "",
            "admin": true
          },
          "createDate": "2017-01-05 15:11:38",
          "updateDate": "2017-01-05 15:11:38",
          "parentIds": "0,1,",
          "name": "江苏总公司",
          "sort": 30,
          "area": {
            "id": "12",
            "isNewRecord": false,
            "parentIds": "0,1",
            "name": "江苏省",
            "sort": 30,
            "parentId": "0"
          },
          "code": "100000001",
          "shortName": "江苏总公司",
          "registTime": "2017-01-05 15:10:03",
          "type": "1",
          "grade": "1",
          "address": "江苏省南京市",
          "zipCode": "210000",
          "master": "张三",
          "phone": "02512345678",
          "fax": "",
          "email": "zhagnsan@email.com",
          "useable": "1",
          "primaryPerson": {
            "id": "",
            "isNewRecord": true,
            "loginFlag": "1",
            "roleNames": "",
            "admin": false
          },
          "deputyPerson": {
            "id": "",
            "isNewRecord": true,
            "loginFlag": "1",
            "roleNames": "",
            "admin": false
          },
          "customerServiceList": [
            {
              "id": "d6c8e9bc4c2b476ba84b962c27882f41",
              "isNewRecord": false,
              "no": "1000001",
              "name": "张三",
              "email": "jsadmin@123.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "447e4526d22045f59ed58250046b3842",
              "isNewRecord": false,
              "no": "1000001",
              "name": "李四",
              "email": "zjadmin@12.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "3c70d715d02a4c4aadc1952ecde286e1",
              "isNewRecord": false,
              "no": "1000001",
              "name": "王五",
              "email": "bjadmin@12.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            },
            {
              "id": "dbb482a1b0434543a37e2d12408384d2",
              "isNewRecord": false,
              "no": "1000002",
              "name": "老二",
              "email": "laoer@13.com",
              "phone": "",
              "mobile": "",
              "loginFlag": "1",
              "roleNames": "",
              "admin": false
            }
          ],
          "parentId": "1"
        },
        "isCustomer": "1",
        "resources": [],
        "next": false,
        "urls": ""
      },
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

    @Override
    public String toString() {
        return "ManyCustomer{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
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
            //public String remarks;
            public CreateBy createBy;
            public String createDate;
            public String updateDate;
            public String type;
            public CompanyA companyA;//上家
            public CompanyB companyB;//下家
            public String isCustomer;
            public String reviewStatus;
            public List<String> resources;//url以,号隔开
            public Boolean next;
            public String urls;
            public float comeOrderSelfRated;
            public float comeOrderOthersRated;

            public float getComeOrderSelfRated() {
                return comeOrderSelfRated;
            }

            public void setComeOrderSelfRated(float comeOrderSelfRated) {
                this.comeOrderSelfRated = comeOrderSelfRated;
            }

            public float getComeOrderOthersRated() {
                return comeOrderOthersRated;
            }

            public void setComeOrderOthersRated(float comeOrderOthersRated) {
                this.comeOrderOthersRated = comeOrderOthersRated;
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

          /*  public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }*/

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
            public CompanyA getCompanyA() {
                return companyA;
            }

            public void setCompanyA(CompanyA companyA) {
                this.companyA = companyA;
            }

            public CompanyB getCompanyB() {
                return companyB;
            }

            public void setCompanyB(CompanyB companyB) {
                this.companyB = companyB;
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
                        ", comeOrderSelfRated=" + comeOrderSelfRated +
                        ", comeOrderOthersRated=" + comeOrderOthersRated +
                        '}';
            }
        }

        public static class CreateBy implements Serializable {
            public String id;
            public Boolean isNewRecord;
            public String loginFlag;
            public Boolean admin;
            public String roleNames;


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
                return "CreateBy{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", loginFlag=" + loginFlag +
                        ", roleNames='" + roleNames + '\'' +
                        ", admin=" + admin +
                        '}';
            }
        }

        public static class CompanyB implements Serializable {
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
           // private String scope;
            public String type;
            public String grade;
            public String address;
            public String master;
            public String zipCode;
            public String phone;
            public String fax;
            public String email;
            public String useable;
            public Person primaryPerson;
            public Person deputyPerson;
            public List<CustomerService> customerServiceList;
            public String parentId;

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

            public String getParentIds() {
                return parentIds;
            }

            public void setParentIds(String parentIds) {
                this.parentIds = parentIds;
            }

            public List<CustomerService> getCustomerServiceList() {
                return customerServiceList;
            }

            public void setCustomerServiceList(List<CustomerService> customerServiceList) {
                this.customerServiceList = customerServiceList;
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

            public Area getArea() {
                return area;
            }

            public void setArea(Area area) {
                this.area = area;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public String getRegistTime() {
                return registTime;
            }

            public void setRegistTime(String registTime) {
                this.registTime = registTime;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
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

            public String getZipCode() {
                return zipCode;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
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

            public Person getPrimaryPerson() {
                return primaryPerson;
            }

            public void setPrimaryPerson(Person primaryPerson) {
                this.primaryPerson = primaryPerson;
            }

            public Person getDeputyPerson() {
                return deputyPerson;
            }

            public void setDeputyPerson(Person deputyPerson) {
                this.deputyPerson = deputyPerson;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            @Override
            public String toString() {
                return "CompanyB{" +
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
                        ", type='" + type + '\'' +
                        ", grade='" + grade + '\'' +
                        ", address='" + address + '\'' +
                        ", master='" + master + '\'' +
                        ", zipCode='" + zipCode + '\'' +
                        ", phone='" + phone + '\'' +
                        ", fax='" + fax + '\'' +
                        ", email='" + email + '\'' +
                        ", useable='" + useable + '\'' +
                        ", primaryPerson=" + primaryPerson +
                        ", deputyPerson=" + deputyPerson +
                        ", customerServiceList=" + customerServiceList +
                        ", parentId='" + parentId + '\'' +
                        '}';
            }
        }

        public static class CompanyA implements Serializable {
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
            public String scope;
            public String type;
            public String grade;
            public String address;
            public String master;
            public String phone;
            public String email;
            public String useable;
            public CreateCompanyBy createCompanyBy;//创建虚拟客户
            public List<CustomerService> customerServiceList;
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
                return "CompanyA{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", remarks='" + remarks + '\'' +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", area=" + area +
                        ", scope='" + scope + '\'' +
                        ", type='" + type + '\'' +
                        ", grade='" + grade + '\'' +
                        ", address='" + address + '\'' +
                        ", master='" + master + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ", useable='" + useable + '\'' +
                        ", createCompanyBy=" + createCompanyBy +
                        ", customerServiceList=" + customerServiceList +
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
        /*"primaryPerson": {
            "id": "",
                    "isNewRecord": true,
                    "loginFlag": "1",
                    "roleNames": "",
                    "admin": false*/
        public String id;
        public Boolean isNewRecord;
        public String loginFlag;
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
            return "PrimaryPerson{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
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
        public String parentId;

        @Override
        public String toString() {
            return "CreateCompanyBy{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", sort=" + sort +
                    ", type='" + type + '\'' +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }

    public static class Area implements Serializable {
        public Boolean isNewRecord;
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
                    "isNewRecord=" + isNewRecord +
                    ", name='" + name + '\'' +
                    ", sort='" + sort + '\'' +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }
}



