package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */

public class BigSeekContent implements Serializable {
    private String errorCode;
    private String reason;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "BigSeekContent{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {

        private int pageNo;
        private int pageSize;
        private int count;
        private List<ListBean> list;
        private String html;
        private int firstResult;
        private int maxResults;
        @Override
        public String toString() {
            return "ResultBean{" +
                    "pageNo=" + pageNo +
                    ", pageSize=" + pageSize +
                    ", count=" + count +
                    ", list=" + list +
                    ", html='" + html + '\'' +
                    ", firstResult=" + firstResult +
                    ", maxResults=" + maxResults +
                    '}';
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }

        public int getMaxResults() {
            return maxResults;
        }

        public void setMaxResults(int maxResults) {
            this.maxResults = maxResults;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {

            private boolean isNewRecord;
            private OfficeBean office;
            private CompanyProductBean companyProduct;
            private int categoryAmount;
            private InviteBidBean inviteBid;
            private FinancingBean financing;
            private int myBidCount;
            private int myInvestCount;

            @Override
            public String toString() {
                return "ListBean{" +
                        "isNewRecord=" + isNewRecord +
                        ", office=" + office +
                        ", companyProduct=" + companyProduct +
                        ", categoryAmount=" + categoryAmount +
                        ", inviteBid=" + inviteBid +
                        ", financing=" + financing +
                        ", myBidCount=" + myBidCount +
                        ", myInvestCount=" + myInvestCount +
                        '}';
            }

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public CompanyProductBean getCompanyProduct() {
                return companyProduct;
            }

            public void setCompanyProduct(CompanyProductBean companyProduct) {
                this.companyProduct = companyProduct;
            }

            public int getCategoryAmount() {
                return categoryAmount;
            }

            public void setCategoryAmount(int categoryAmount) {
                this.categoryAmount = categoryAmount;
            }

            public InviteBidBean getInviteBid() {
                return inviteBid;
            }

            public void setInviteBid(InviteBidBean inviteBid) {
                this.inviteBid = inviteBid;
            }

            public FinancingBean getFinancing() {
                return financing;
            }

            public void setFinancing(FinancingBean financing) {
                this.financing = financing;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public OfficeBean getOffice() {
                return office;
            }

            public void setOffice(OfficeBean office) {
                this.office = office;
            }

            public int getMyBidCount() {
                return myBidCount;
            }

            public void setMyBidCount(int myBidCount) {
                this.myBidCount = myBidCount;
            }

            public int getMyInvestCount() {
                return myInvestCount;
            }

            public void setMyInvestCount(int myInvestCount) {
                this.myInvestCount = myInvestCount;
            }

            public static class OfficeBean implements Serializable {


                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBean createBy;
                private String createDate;
                private String updateDate;
                private String parentIds;
                private String name;
                private int sort;
                private AreaBean area;
                private String code;
                private String scope;
                private String shortName;
                private String type;
                private String grade;
                private String address;
                private String zipCode;
                private String master;
                private String phone;
                private String fax;
                private String email;
                private String useable;
                private PrimaryPersonBean primaryPerson;
                private DeputyPersonBean deputyPerson;
                private int reviewOthers;
                private double reviewSelf;
                private double otherCosting;
                private double otherPayment;
                private int otherQuality;
                private int otherService;
                private int otherTime;
                private double selfCosting;
                private int selfPayment;
                private double selfQuality;
                private double selfService;
                private double selfTime;
                private int serviceCount;
                private int grossProfit;
                private String parentId;
                private List<CustomerServiceListBean> customerServiceList;

                @Override
                public String toString() {
                    return "OfficeBean{" +
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
                            ", scope='" + scope + '\'' +
                            ", shortName='" + shortName + '\'' +
                            ", type='" + type + '\'' +
                            ", grade='" + grade + '\'' +
                            ", address='" + address + '\'' +
                            ", zipCode='" + zipCode + '\'' +
                            ", master='" + master + '\'' +
                            ", phone='" + phone + '\'' +
                            ", fax='" + fax + '\'' +
                            ", email='" + email + '\'' +
                            ", useable='" + useable + '\'' +
                            ", primaryPerson=" + primaryPerson +
                            ", deputyPerson=" + deputyPerson +
                            ", reviewOthers=" + reviewOthers +
                            ", reviewSelf=" + reviewSelf +
                            ", otherCosting=" + otherCosting +
                            ", otherPayment=" + otherPayment +
                            ", otherQuality=" + otherQuality +
                            ", otherService=" + otherService +
                            ", otherTime=" + otherTime +
                            ", selfCosting=" + selfCosting +
                            ", selfPayment=" + selfPayment +
                            ", selfQuality=" + selfQuality +
                            ", selfService=" + selfService +
                            ", selfTime=" + selfTime +
                            ", serviceCount=" + serviceCount +
                            ", grossProfit=" + grossProfit +
                            ", parentId='" + parentId + '\'' +
                            ", customerServiceList=" + customerServiceList +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public CreateByBean getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBean createBy) {
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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public AreaBean getArea() {
                    return area;
                }

                public void setArea(AreaBean area) {
                    this.area = area;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getScope() {
                    return scope;
                }

                public void setScope(String scope) {
                    this.scope = scope;
                }

                public String getShortName() {
                    return shortName;
                }

                public void setShortName(String shortName) {
                    this.shortName = shortName;
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

                public String getZipCode() {
                    return zipCode;
                }

                public void setZipCode(String zipCode) {
                    this.zipCode = zipCode;
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

                public PrimaryPersonBean getPrimaryPerson() {
                    return primaryPerson;
                }

                public void setPrimaryPerson(PrimaryPersonBean primaryPerson) {
                    this.primaryPerson = primaryPerson;
                }

                public DeputyPersonBean getDeputyPerson() {
                    return deputyPerson;
                }

                public void setDeputyPerson(DeputyPersonBean deputyPerson) {
                    this.deputyPerson = deputyPerson;
                }

                public int getReviewOthers() {
                    return reviewOthers;
                }

                public void setReviewOthers(int reviewOthers) {
                    this.reviewOthers = reviewOthers;
                }

                public double getReviewSelf() {
                    return reviewSelf;
                }

                public void setReviewSelf(double reviewSelf) {
                    this.reviewSelf = reviewSelf;
                }

                public double getOtherCosting() {
                    return otherCosting;
                }

                public void setOtherCosting(double otherCosting) {
                    this.otherCosting = otherCosting;
                }

                public double getOtherPayment() {
                    return otherPayment;
                }

                public void setOtherPayment(double otherPayment) {
                    this.otherPayment = otherPayment;
                }

                public int getOtherQuality() {
                    return otherQuality;
                }

                public void setOtherQuality(int otherQuality) {
                    this.otherQuality = otherQuality;
                }

                public int getOtherService() {
                    return otherService;
                }

                public void setOtherService(int otherService) {
                    this.otherService = otherService;
                }

                public int getOtherTime() {
                    return otherTime;
                }

                public void setOtherTime(int otherTime) {
                    this.otherTime = otherTime;
                }

                public double getSelfCosting() {
                    return selfCosting;
                }

                public void setSelfCosting(double selfCosting) {
                    this.selfCosting = selfCosting;
                }

                public int getSelfPayment() {
                    return selfPayment;
                }

                public void setSelfPayment(int selfPayment) {
                    this.selfPayment = selfPayment;
                }

                public double getSelfQuality() {
                    return selfQuality;
                }

                public void setSelfQuality(double selfQuality) {
                    this.selfQuality = selfQuality;
                }

                public double getSelfService() {
                    return selfService;
                }

                public void setSelfService(double selfService) {
                    this.selfService = selfService;
                }

                public double getSelfTime() {
                    return selfTime;
                }

                public void setSelfTime(double selfTime) {
                    this.selfTime = selfTime;
                }

                public int getServiceCount() {
                    return serviceCount;
                }

                public void setServiceCount(int serviceCount) {
                    this.serviceCount = serviceCount;
                }

                public int getGrossProfit() {
                    return grossProfit;
                }

                public void setGrossProfit(int grossProfit) {
                    this.grossProfit = grossProfit;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<CustomerServiceListBean> getCustomerServiceList() {
                    return customerServiceList;
                }

                public void setCustomerServiceList(List<CustomerServiceListBean> customerServiceList) {
                    this.customerServiceList = customerServiceList;
                }

                public static class CreateByBean {
                    /**
                     * id : 1
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : true
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class AreaBean implements Serializable{
                    /**
                     * id : 14
                     * isNewRecord : false
                     * parentIds : 0,1
                     * name : 安徽省
                     * sort : 30
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String parentIds;
                    private String name;
                    private int sort;
                    private String parentId;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getParentIds() {
                        return parentIds;
                    }

                    public void setParentIds(String parentIds) {
                        this.parentIds = parentIds;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }
                }

                public static class PrimaryPersonBean implements Serializable {
                    /**
                     * id :
                     * isNewRecord : true
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "PrimaryPersonBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", roleNames='" + roleNames + '\'' +
                                ", admin=" + admin +
                                ", roleList=" + roleList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class DeputyPersonBean implements Serializable {
                    /**
                     * id :
                     * isNewRecord : true
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "DeputyPersonBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", roleNames='" + roleNames + '\'' +
                                ", admin=" + admin +
                                ", roleList=" + roleList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class CustomerServiceListBean implements Serializable {
                    /**
                     * id : cd7bcbfd6fc84f49a7ec908e93093432
                     * isNewRecord : false
                     * no : 001
                     * name : 安徽公司管理员
                     * email :
                     * phone :
                     * mobile :
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String no;
                    private String name;
                    private String email;
                    private String phone;
                    private String mobile;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "CustomerServiceListBean{" +
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
                                ", roleList=" + roleList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }
            }
            public static class CompanyProductBean implements Serializable {

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBeanX createBy;
                private String createDate;
                private String updateDate;
                private CompanyBean company;
                private CompanyCategoryBean companyCategory;
                private String productName;
                private String productDescription;
                private String productPriceDownline;
                private String productPriceHighline;
                private String productPhotos;
                private MapBean map;
                private List<?> specificationList;
                private List<?> urls;

                @Override
                public String toString() {
                    return "CompanyProductBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", company=" + company +
                            ", companyCategory=" + companyCategory +
                            ", productName='" + productName + '\'' +
                            ", productDescription='" + productDescription + '\'' +
                            ", productPriceDownline='" + productPriceDownline + '\'' +
                            ", productPriceHighline='" + productPriceHighline + '\'' +
                            ", productPhotos='" + productPhotos + '\'' +
                            ", map=" + map +
                            ", specificationList=" + specificationList +
                            ", urls=" + urls +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public CreateByBeanX getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBeanX createBy) {
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

                public CompanyBean getCompany() {
                    return company;
                }

                public void setCompany(CompanyBean company) {
                    this.company = company;
                }

                public CompanyCategoryBean getCompanyCategory() {
                    return companyCategory;
                }

                public void setCompanyCategory(CompanyCategoryBean companyCategory) {
                    this.companyCategory = companyCategory;
                }

                public String getProductName() {
                    return productName;
                }

                public void setProductName(String productName) {
                    this.productName = productName;
                }

                public String getProductDescription() {
                    return productDescription;
                }

                public void setProductDescription(String productDescription) {
                    this.productDescription = productDescription;
                }

                public String getProductPriceDownline() {
                    return productPriceDownline;
                }

                public void setProductPriceDownline(String productPriceDownline) {
                    this.productPriceDownline = productPriceDownline;
                }

                public String getProductPriceHighline() {
                    return productPriceHighline;
                }

                public void setProductPriceHighline(String productPriceHighline) {
                    this.productPriceHighline = productPriceHighline;
                }

                public String getProductPhotos() {
                    return productPhotos;
                }

                public void setProductPhotos(String productPhotos) {
                    this.productPhotos = productPhotos;
                }

                public MapBean getMap() {
                    return map;
                }

                public void setMap(MapBean map) {
                    this.map = map;
                }

                public List<?> getSpecificationList() {
                    return specificationList;
                }

                public void setSpecificationList(List<?> specificationList) {
                    this.specificationList = specificationList;
                }

                public List<?> getUrls() {
                    return urls;
                }

                public void setUrls(List<?> urls) {
                    this.urls = urls;
                }

                public static class CreateByBeanX {
                    /**
                     * id : d6c8e9bc4c2b476ba84b962c27882f41
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class CompanyBean implements Serializable{
                    /**
                     * id : f541afa391974409ba680e9bd9a394fd
                     * isNewRecord : false
                     * sort : 30
                     * type : 1
                     * customerServiceList : []
                     * reviewOthers : 0
                     * reviewSelf : 0
                     * otherCosting : 0
                     * otherPayment : 0
                     * otherQuality : 0
                     * otherService : 0
                     * otherTime : 0
                     * selfCosting : 0
                     * selfPayment : 0
                     * serviceCount : 0
                     * grossProfit : 0
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private int sort;
                    private String type;
                    private int reviewOthers;
                    private int reviewSelf;
                    private int otherCosting;
                    private int otherPayment;
                    private int otherQuality;
                    private int otherService;
                    private int otherTime;
                    private int selfCosting;
                    private int selfPayment;
                    private int serviceCount;
                    private int grossProfit;
                    private String parentId;
                    private List<?> customerServiceList;

                    @Override
                    public String toString() {
                        return "CompanyBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", sort=" + sort +
                                ", type='" + type + '\'' +
                                ", reviewOthers=" + reviewOthers +
                                ", reviewSelf=" + reviewSelf +
                                ", otherCosting=" + otherCosting +
                                ", otherPayment=" + otherPayment +
                                ", otherQuality=" + otherQuality +
                                ", otherService=" + otherService +
                                ", otherTime=" + otherTime +
                                ", selfCosting=" + selfCosting +
                                ", selfPayment=" + selfPayment +
                                ", serviceCount=" + serviceCount +
                                ", grossProfit=" + grossProfit +
                                ", parentId='" + parentId + '\'' +
                                ", customerServiceList=" + customerServiceList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public int getReviewOthers() {
                        return reviewOthers;
                    }

                    public void setReviewOthers(int reviewOthers) {
                        this.reviewOthers = reviewOthers;
                    }

                    public int getReviewSelf() {
                        return reviewSelf;
                    }

                    public void setReviewSelf(int reviewSelf) {
                        this.reviewSelf = reviewSelf;
                    }

                    public int getOtherCosting() {
                        return otherCosting;
                    }

                    public void setOtherCosting(int otherCosting) {
                        this.otherCosting = otherCosting;
                    }

                    public int getOtherPayment() {
                        return otherPayment;
                    }

                    public void setOtherPayment(int otherPayment) {
                        this.otherPayment = otherPayment;
                    }

                    public int getOtherQuality() {
                        return otherQuality;
                    }

                    public void setOtherQuality(int otherQuality) {
                        this.otherQuality = otherQuality;
                    }

                    public int getOtherService() {
                        return otherService;
                    }

                    public void setOtherService(int otherService) {
                        this.otherService = otherService;
                    }

                    public int getOtherTime() {
                        return otherTime;
                    }

                    public void setOtherTime(int otherTime) {
                        this.otherTime = otherTime;
                    }

                    public int getSelfCosting() {
                        return selfCosting;
                    }

                    public void setSelfCosting(int selfCosting) {
                        this.selfCosting = selfCosting;
                    }

                    public int getSelfPayment() {
                        return selfPayment;
                    }

                    public void setSelfPayment(int selfPayment) {
                        this.selfPayment = selfPayment;
                    }

                    public int getServiceCount() {
                        return serviceCount;
                    }

                    public void setServiceCount(int serviceCount) {
                        this.serviceCount = serviceCount;
                    }

                    public int getGrossProfit() {
                        return grossProfit;
                    }

                    public void setGrossProfit(int grossProfit) {
                        this.grossProfit = grossProfit;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<?> getCustomerServiceList() {
                        return customerServiceList;
                    }

                    public void setCustomerServiceList(List<?> customerServiceList) {
                        this.customerServiceList = customerServiceList;
                    }
                }

                public static class CompanyCategoryBean implements Serializable {
                    /**
                     * id : 703296ef087a42ecb06ceca9d301ee10
                     * isNewRecord : false
                     * name : 全能卡
                     * sort : 30
                     * serveType : 1
                     * size : 0
                     * categoryAttributeList : []
                     * relIndustryCompanyCategoryList : []
                     * attributeNames :
                     * attributeIds :
                     * parentName :
                     * industryCategoryIds :
                     * industryCategoryNames :
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String name;
                    private int sort;
                    private String serveType;
                    private int size;
                    private String attributeNames;
                    private String attributeIds;
                    private String parentName;
                    private String industryCategoryIds;
                    private String industryCategoryNames;
                    private String parentId;
                    private List<?> categoryAttributeList;
                    private List<?> relIndustryCompanyCategoryList;

                    @Override
                    public String toString() {
                        return "CompanyCategoryBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", name='" + name + '\'' +
                                ", sort=" + sort +
                                ", serveType='" + serveType + '\'' +
                                ", size=" + size +
                                ", attributeNames='" + attributeNames + '\'' +
                                ", attributeIds='" + attributeIds + '\'' +
                                ", parentName='" + parentName + '\'' +
                                ", industryCategoryIds='" + industryCategoryIds + '\'' +
                                ", industryCategoryNames='" + industryCategoryNames + '\'' +
                                ", parentId='" + parentId + '\'' +
                                ", categoryAttributeList=" + categoryAttributeList +
                                ", relIndustryCompanyCategoryList=" + relIndustryCompanyCategoryList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public String getServeType() {
                        return serveType;
                    }

                    public void setServeType(String serveType) {
                        this.serveType = serveType;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public String getAttributeNames() {
                        return attributeNames;
                    }

                    public void setAttributeNames(String attributeNames) {
                        this.attributeNames = attributeNames;
                    }

                    public String getAttributeIds() {
                        return attributeIds;
                    }

                    public void setAttributeIds(String attributeIds) {
                        this.attributeIds = attributeIds;
                    }

                    public String getParentName() {
                        return parentName;
                    }

                    public void setParentName(String parentName) {
                        this.parentName = parentName;
                    }

                    public String getIndustryCategoryIds() {
                        return industryCategoryIds;
                    }

                    public void setIndustryCategoryIds(String industryCategoryIds) {
                        this.industryCategoryIds = industryCategoryIds;
                    }

                    public String getIndustryCategoryNames() {
                        return industryCategoryNames;
                    }

                    public void setIndustryCategoryNames(String industryCategoryNames) {
                        this.industryCategoryNames = industryCategoryNames;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<?> getCategoryAttributeList() {
                        return categoryAttributeList;
                    }

                    public void setCategoryAttributeList(List<?> categoryAttributeList) {
                        this.categoryAttributeList = categoryAttributeList;
                    }

                    public List<?> getRelIndustryCompanyCategoryList() {
                        return relIndustryCompanyCategoryList;
                    }

                    public void setRelIndustryCompanyCategoryList(List<?> relIndustryCompanyCategoryList) {
                        this.relIndustryCompanyCategoryList = relIndustryCompanyCategoryList;
                    }
                }

                public static class MapBean {
                }
            }
            public static class InviteBidBean implements Serializable {
                /**
                 * id : dcb8c9c09efd4554b941791133558bad
                 * isNewRecord : false
                 * remarks : <p>哦三代富贵iupsdfniouneorpin<br/></p>
                 * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":false}
                 * createDate : 2017-04-07 13:00:38
                 * updateDate : 2017-04-07 13:00:38
                 * inviteCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"roleNames":"","admin":true},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"roleNames":"","admin":false},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"roleNames":"","admin":false},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"roleNames":"","admin":false}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":3,"grossProfit":0,"parentId":"1"}
                 * inviteDate : 2017-04-07 12:58:45
                 * buyProductName : 西瓜
                 * targetPrice : 12
                 * downPayment : 20
                 * expireDate : 2017-04-30 13:00:30
                 * attachment : 阿斯顿飞
                 * bidList : []
                 * count : 5000
                 * title : 采购西瓜500个
                 * expired : false
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBean createBy;
                private String createDate;
                private String updateDate;
                private InviteCompanyBean inviteCompany;
                private String inviteDate;
                private String buyProductName;
                private String targetPrice;
                private String downPayment;
                private String expireDate;
                private String attachment;
                private int count;
                private String title;
                private boolean expired;
                private List<?> bidList;

                @Override
                public String toString() {
                    return "InviteBidBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", inviteCompany=" + inviteCompany +
                            ", inviteDate='" + inviteDate + '\'' +
                            ", buyProductName='" + buyProductName + '\'' +
                            ", targetPrice='" + targetPrice + '\'' +
                            ", downPayment='" + downPayment + '\'' +
                            ", expireDate='" + expireDate + '\'' +
                            ", attachment='" + attachment + '\'' +
                            ", count=" + count +
                            ", title='" + title + '\'' +
                            ", expired=" + expired +
                            ", bidList=" + bidList +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public CreateByBean getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBean createBy) {
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

                public InviteCompanyBean getInviteCompany() {
                    return inviteCompany;
                }

                public void setInviteCompany(InviteCompanyBean inviteCompany) {
                    this.inviteCompany = inviteCompany;
                }

                public String getInviteDate() {
                    return inviteDate;
                }

                public void setInviteDate(String inviteDate) {
                    this.inviteDate = inviteDate;
                }

                public String getBuyProductName() {
                    return buyProductName;
                }

                public void setBuyProductName(String buyProductName) {
                    this.buyProductName = buyProductName;
                }

                public String getTargetPrice() {
                    return targetPrice;
                }

                public void setTargetPrice(String targetPrice) {
                    this.targetPrice = targetPrice;
                }

                public String getDownPayment() {
                    return downPayment;
                }

                public void setDownPayment(String downPayment) {
                    this.downPayment = downPayment;
                }

                public String getExpireDate() {
                    return expireDate;
                }

                public void setExpireDate(String expireDate) {
                    this.expireDate = expireDate;
                }

                public String getAttachment() {
                    return attachment;
                }

                public void setAttachment(String attachment) {
                    this.attachment = attachment;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public boolean isExpired() {
                    return expired;
                }

                public void setExpired(boolean expired) {
                    this.expired = expired;
                }

                public List<?> getBidList() {
                    return bidList;
                }

                public void setBidList(List<?> bidList) {
                    this.bidList = bidList;
                }

                public static class CreateByBean implements Serializable {
                    /**
                     * id : d6c8e9bc4c2b476ba84b962c27882f41
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "CreateByBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", roleNames='" + roleNames + '\'' +
                                ", admin=" + admin +
                                ", roleList=" + roleList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class InviteCompanyBean implements Serializable {

                    private String id;
                    private boolean isNewRecord;
                    private String remarks;
                    private CreateByBeanX createBy;
                    private String createDate;
                    private String updateDate;
                    private String parentIds;
                    private String name;
                    private int sort;
                    private AreaBean area;
                    private String code;
                    private String shortName;
                    private String registTime;
                    private String type;
                    private String serviceType;
                    private String grade;
                    private String address;
                    private String zipCode;
                    private String master;
                    private String phone;
                    private String fax;
                    private String email;
                    private String useable;
                    private PrimaryPersonBean primaryPerson;
                    private DeputyPersonBean deputyPerson;
                    private String homepage;
                    private int reviewOthers;
                    private double reviewSelf;
                    private double otherCosting;
                    private double otherPayment;
                    private int otherQuality;
                    private int otherService;
                    private int otherTime;
                    private double selfCosting;
                    private int selfPayment;
                    private double selfQuality;
                    private double selfService;
                    private double selfTime;
                    private int serviceCount;
                    private int grossProfit;
                    private String parentId;
                    private List<CustomerServiceListBean> customerServiceList;

                    @Override
                    public String toString() {
                        return "InviteCompanyBean{" +
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
                                ", serviceType='" + serviceType + '\'' +
                                ", grade='" + grade + '\'' +
                                ", address='" + address + '\'' +
                                ", zipCode='" + zipCode + '\'' +
                                ", master='" + master + '\'' +
                                ", phone='" + phone + '\'' +
                                ", fax='" + fax + '\'' +
                                ", email='" + email + '\'' +
                                ", useable='" + useable + '\'' +
                                ", primaryPerson=" + primaryPerson +
                                ", deputyPerson=" + deputyPerson +
                                ", homepage='" + homepage + '\'' +
                                ", reviewOthers=" + reviewOthers +
                                ", reviewSelf=" + reviewSelf +
                                ", otherCosting=" + otherCosting +
                                ", otherPayment=" + otherPayment +
                                ", otherQuality=" + otherQuality +
                                ", otherService=" + otherService +
                                ", otherTime=" + otherTime +
                                ", selfCosting=" + selfCosting +
                                ", selfPayment=" + selfPayment +
                                ", selfQuality=" + selfQuality +
                                ", selfService=" + selfService +
                                ", selfTime=" + selfTime +
                                ", serviceCount=" + serviceCount +
                                ", grossProfit=" + grossProfit +
                                ", parentId='" + parentId + '\'' +
                                ", customerServiceList=" + customerServiceList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getRemarks() {
                        return remarks;
                    }

                    public void setRemarks(String remarks) {
                        this.remarks = remarks;
                    }

                    public CreateByBeanX getCreateBy() {
                        return createBy;
                    }

                    public void setCreateBy(CreateByBeanX createBy) {
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

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public AreaBean getArea() {
                        return area;
                    }

                    public void setArea(AreaBean area) {
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

                    public String getServiceType() {
                        return serviceType;
                    }

                    public void setServiceType(String serviceType) {
                        this.serviceType = serviceType;
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

                    public String getZipCode() {
                        return zipCode;
                    }

                    public void setZipCode(String zipCode) {
                        this.zipCode = zipCode;
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

                    public PrimaryPersonBean getPrimaryPerson() {
                        return primaryPerson;
                    }

                    public void setPrimaryPerson(PrimaryPersonBean primaryPerson) {
                        this.primaryPerson = primaryPerson;
                    }

                    public DeputyPersonBean getDeputyPerson() {
                        return deputyPerson;
                    }

                    public void setDeputyPerson(DeputyPersonBean deputyPerson) {
                        this.deputyPerson = deputyPerson;
                    }

                    public String getHomepage() {
                        return homepage;
                    }

                    public void setHomepage(String homepage) {
                        this.homepage = homepage;
                    }

                    public int getReviewOthers() {
                        return reviewOthers;
                    }

                    public void setReviewOthers(int reviewOthers) {
                        this.reviewOthers = reviewOthers;
                    }

                    public double getReviewSelf() {
                        return reviewSelf;
                    }

                    public void setReviewSelf(double reviewSelf) {
                        this.reviewSelf = reviewSelf;
                    }

                    public double getOtherCosting() {
                        return otherCosting;
                    }

                    public void setOtherCosting(double otherCosting) {
                        this.otherCosting = otherCosting;
                    }

                    public double getOtherPayment() {
                        return otherPayment;
                    }

                    public void setOtherPayment(double otherPayment) {
                        this.otherPayment = otherPayment;
                    }

                    public int getOtherQuality() {
                        return otherQuality;
                    }

                    public void setOtherQuality(int otherQuality) {
                        this.otherQuality = otherQuality;
                    }

                    public int getOtherService() {
                        return otherService;
                    }

                    public void setOtherService(int otherService) {
                        this.otherService = otherService;
                    }

                    public int getOtherTime() {
                        return otherTime;
                    }

                    public void setOtherTime(int otherTime) {
                        this.otherTime = otherTime;
                    }

                    public double getSelfCosting() {
                        return selfCosting;
                    }

                    public void setSelfCosting(double selfCosting) {
                        this.selfCosting = selfCosting;
                    }

                    public int getSelfPayment() {
                        return selfPayment;
                    }

                    public void setSelfPayment(int selfPayment) {
                        this.selfPayment = selfPayment;
                    }

                    public double getSelfQuality() {
                        return selfQuality;
                    }

                    public void setSelfQuality(double selfQuality) {
                        this.selfQuality = selfQuality;
                    }

                    public double getSelfService() {
                        return selfService;
                    }

                    public void setSelfService(double selfService) {
                        this.selfService = selfService;
                    }

                    public double getSelfTime() {
                        return selfTime;
                    }

                    public void setSelfTime(double selfTime) {
                        this.selfTime = selfTime;
                    }

                    public int getServiceCount() {
                        return serviceCount;
                    }

                    public void setServiceCount(int serviceCount) {
                        this.serviceCount = serviceCount;
                    }

                    public int getGrossProfit() {
                        return grossProfit;
                    }

                    public void setGrossProfit(int grossProfit) {
                        this.grossProfit = grossProfit;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<CustomerServiceListBean> getCustomerServiceList() {
                        return customerServiceList;
                    }

                    public void setCustomerServiceList(List<CustomerServiceListBean> customerServiceList) {
                        this.customerServiceList = customerServiceList;
                    }

                    public static class CreateByBeanX implements Serializable{
                        /**
                         * id : 1
                         * isNewRecord : false
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : true
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "CreateByBeanX{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class AreaBean implements Serializable {
                        /**
                         * id : 12
                         * isNewRecord : false
                         * parentIds : 0,1
                         * name : 江苏省
                         * sort : 30
                         * parentId : 0
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String parentIds;
                        private String name;
                        private int sort;
                        private String parentId;

                        @Override
                        public String toString() {
                            return "AreaBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", parentIds='" + parentIds + '\'' +
                                    ", name='" + name + '\'' +
                                    ", sort=" + sort +
                                    ", parentId='" + parentId + '\'' +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
                        }

                        public String getParentIds() {
                            return parentIds;
                        }

                        public void setParentIds(String parentIds) {
                            this.parentIds = parentIds;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getSort() {
                            return sort;
                        }

                        public void setSort(int sort) {
                            this.sort = sort;
                        }

                        public String getParentId() {
                            return parentId;
                        }

                        public void setParentId(String parentId) {
                            this.parentId = parentId;
                        }
                    }

                    public static class PrimaryPersonBean implements Serializable {
                        /**
                         * id :
                         * isNewRecord : true
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "PrimaryPersonBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class DeputyPersonBean implements Serializable {
                        /**
                         * id :
                         * isNewRecord : true
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "DeputyPersonBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class CustomerServiceListBean implements  Serializable{
                        /**
                         * id : cd7bcbfd6fc84f49a7ec908e93093432
                         * isNewRecord : false
                         * no : 001
                         * name : 安徽公司管理员
                         * email :
                         * phone :
                         * mobile :
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String no;
                        private String name;
                        private String email;
                        private String phone;
                        private String mobile;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "CustomerServiceListBean{" +
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
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }
                }
            }

            public static class FinancingBean {

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBean createBy;
                private String createDate;
                private String updateDate;
                private CompanyBean company;
                private String title;
                private String cooperationType;
                private String fundUsageMode;
                private int sumMoney;
                private String acceptFundSource;
                private int repaymentTerm;
                private String restrictArea;
                private String expiryDate;
                private String repaymentType;
                private int expectRate;
                private double monthlyRepayment;
                private int lastMonthlyRepayment;
                private String transferShare;
                private String toCashType;
                private int lowestMoney;
                private int highestMoney;
                private boolean next;
                private String urls;
                private String restrictAreaIds;
                private List<?> resources;
                private List<?> areaList;
                private List<String> areaIds;

                @Override
                public String toString() {
                    return "FinancingBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", company=" + company +
                            ", title='" + title + '\'' +
                            ", cooperationType='" + cooperationType + '\'' +
                            ", fundUsageMode='" + fundUsageMode + '\'' +
                            ", sumMoney=" + sumMoney +
                            ", acceptFundSource='" + acceptFundSource + '\'' +
                            ", repaymentTerm=" + repaymentTerm +
                            ", restrictArea='" + restrictArea + '\'' +
                            ", expiryDate='" + expiryDate + '\'' +
                            ", repaymentType='" + repaymentType + '\'' +
                            ", expectRate=" + expectRate +
                            ", monthlyRepayment=" + monthlyRepayment +
                            ", lastMonthlyRepayment=" + lastMonthlyRepayment +
                            ", transferShare='" + transferShare + '\'' +
                            ", toCashType='" + toCashType + '\'' +
                            ", lowestMoney=" + lowestMoney +
                            ", highestMoney=" + highestMoney +
                            ", next=" + next +
                            ", urls='" + urls + '\'' +
                            ", restrictAreaIds='" + restrictAreaIds + '\'' +
                            ", resources=" + resources +
                            ", areaList=" + areaList +
                            ", areaIds=" + areaIds +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isIsNewRecord() {
                    return isNewRecord;
                }

                public void setIsNewRecord(boolean isNewRecord) {
                    this.isNewRecord = isNewRecord;
                }

                public String getRemarks() {
                    return remarks;
                }

                public void setRemarks(String remarks) {
                    this.remarks = remarks;
                }

                public CreateByBean getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(CreateByBean createBy) {
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

                public CompanyBean getCompany() {
                    return company;
                }

                public void setCompany(CompanyBean company) {
                    this.company = company;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCooperationType() {
                    return cooperationType;
                }

                public void setCooperationType(String cooperationType) {
                    this.cooperationType = cooperationType;
                }

                public String getFundUsageMode() {
                    return fundUsageMode;
                }

                public void setFundUsageMode(String fundUsageMode) {
                    this.fundUsageMode = fundUsageMode;
                }

                public int getSumMoney() {
                    return sumMoney;
                }

                public void setSumMoney(int sumMoney) {
                    this.sumMoney = sumMoney;
                }

                public String getAcceptFundSource() {
                    return acceptFundSource;
                }

                public void setAcceptFundSource(String acceptFundSource) {
                    this.acceptFundSource = acceptFundSource;
                }

                public int getRepaymentTerm() {
                    return repaymentTerm;
                }

                public void setRepaymentTerm(int repaymentTerm) {
                    this.repaymentTerm = repaymentTerm;
                }

                public String getRestrictArea() {
                    return restrictArea;
                }

                public void setRestrictArea(String restrictArea) {
                    this.restrictArea = restrictArea;
                }

                public String getExpiryDate() {
                    return expiryDate;
                }

                public void setExpiryDate(String expiryDate) {
                    this.expiryDate = expiryDate;
                }

                public String getRepaymentType() {
                    return repaymentType;
                }

                public void setRepaymentType(String repaymentType) {
                    this.repaymentType = repaymentType;
                }

                public int getExpectRate() {
                    return expectRate;
                }

                public void setExpectRate(int expectRate) {
                    this.expectRate = expectRate;
                }

                public double getMonthlyRepayment() {
                    return monthlyRepayment;
                }

                public void setMonthlyRepayment(double monthlyRepayment) {
                    this.monthlyRepayment = monthlyRepayment;
                }

                public int getLastMonthlyRepayment() {
                    return lastMonthlyRepayment;
                }

                public void setLastMonthlyRepayment(int lastMonthlyRepayment) {
                    this.lastMonthlyRepayment = lastMonthlyRepayment;
                }

                public String getTransferShare() {
                    return transferShare;
                }

                public void setTransferShare(String transferShare) {
                    this.transferShare = transferShare;
                }

                public String getToCashType() {
                    return toCashType;
                }

                public void setToCashType(String toCashType) {
                    this.toCashType = toCashType;
                }

                public int getLowestMoney() {
                    return lowestMoney;
                }

                public void setLowestMoney(int lowestMoney) {
                    this.lowestMoney = lowestMoney;
                }

                public int getHighestMoney() {
                    return highestMoney;
                }

                public void setHighestMoney(int highestMoney) {
                    this.highestMoney = highestMoney;
                }

                public boolean isNext() {
                    return next;
                }

                public void setNext(boolean next) {
                    this.next = next;
                }

                public String getUrls() {
                    return urls;
                }

                public void setUrls(String urls) {
                    this.urls = urls;
                }

                public String getRestrictAreaIds() {
                    return restrictAreaIds;
                }

                public void setRestrictAreaIds(String restrictAreaIds) {
                    this.restrictAreaIds = restrictAreaIds;
                }

                public List<?> getResources() {
                    return resources;
                }

                public void setResources(List<?> resources) {
                    this.resources = resources;
                }

                public List<?> getAreaList() {
                    return areaList;
                }

                public void setAreaList(List<?> areaList) {
                    this.areaList = areaList;
                }

                public List<String> getAreaIds() {
                    return areaIds;
                }

                public void setAreaIds(List<String> areaIds) {
                    this.areaIds = areaIds;
                }

                public static class CreateByBean implements Serializable{
                    /**
                     * id : 447e4526d22045f59ed58250046b3842
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * roleNames :
                     * admin : false
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private String roleNames;
                    private boolean admin;
                    private List<?> roleList;

                    @Override
                    public String toString() {
                        return "CreateByBean{" +
                                "id='" + id + '\'' +
                                ", isNewRecord=" + isNewRecord +
                                ", loginFlag='" + loginFlag + '\'' +
                                ", roleNames='" + roleNames + '\'' +
                                ", admin=" + admin +
                                ", roleList=" + roleList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class CompanyBean  implements Serializable{
                    private String id;
                    private boolean isNewRecord;
                    private String remarks;
                    private CreateByBeanX createBy;
                    private String createDate;
                    private String updateDate;
                    private String parentIds;
                    private String name;
                    private int sort;
                    private AreaBean area;
                    private String code;
                    private String shortName;
                    private String registTime;
                    private String type;
                    private String serviceType;
                    private String grade;
                    private String address;
                    private String zipCode;
                    private String master;
                    private String phone;
                    private String fax;
                    private String email;
                    private String useable;
                    private PrimaryPersonBean primaryPerson;
                    private DeputyPersonBean deputyPerson;
                    private int reviewOthers;
                    private double reviewSelf;
                    private double otherCosting;
                    private double otherPayment;
                    private int otherQuality;
                    private int otherService;
                    private int otherTime;
                    private double selfCosting;
                    private int selfPayment;
                    private double selfQuality;
                    private double selfService;
                    private double selfTime;
                    private int serviceCount;
                    private int grossProfit;
                    private String parentId;
                    private List<CustomerServiceListBean> customerServiceList;

                    @Override
                    public String toString() {
                        return "CompanyBean{" +
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
                                ", serviceType='" + serviceType + '\'' +
                                ", grade='" + grade + '\'' +
                                ", address='" + address + '\'' +
                                ", zipCode='" + zipCode + '\'' +
                                ", master='" + master + '\'' +
                                ", phone='" + phone + '\'' +
                                ", fax='" + fax + '\'' +
                                ", email='" + email + '\'' +
                                ", useable='" + useable + '\'' +
                                ", primaryPerson=" + primaryPerson +
                                ", deputyPerson=" + deputyPerson +
                                ", reviewOthers=" + reviewOthers +
                                ", reviewSelf=" + reviewSelf +
                                ", otherCosting=" + otherCosting +
                                ", otherPayment=" + otherPayment +
                                ", otherQuality=" + otherQuality +
                                ", otherService=" + otherService +
                                ", otherTime=" + otherTime +
                                ", selfCosting=" + selfCosting +
                                ", selfPayment=" + selfPayment +
                                ", selfQuality=" + selfQuality +
                                ", selfService=" + selfService +
                                ", selfTime=" + selfTime +
                                ", serviceCount=" + serviceCount +
                                ", grossProfit=" + grossProfit +
                                ", parentId='" + parentId + '\'' +
                                ", customerServiceList=" + customerServiceList +
                                '}';
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIsNewRecord() {
                        return isNewRecord;
                    }

                    public void setIsNewRecord(boolean isNewRecord) {
                        this.isNewRecord = isNewRecord;
                    }

                    public String getRemarks() {
                        return remarks;
                    }

                    public void setRemarks(String remarks) {
                        this.remarks = remarks;
                    }

                    public CreateByBeanX getCreateBy() {
                        return createBy;
                    }

                    public void setCreateBy(CreateByBeanX createBy) {
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

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSort() {
                        return sort;
                    }

                    public void setSort(int sort) {
                        this.sort = sort;
                    }

                    public AreaBean getArea() {
                        return area;
                    }

                    public void setArea(AreaBean area) {
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

                    public String getServiceType() {
                        return serviceType;
                    }

                    public void setServiceType(String serviceType) {
                        this.serviceType = serviceType;
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

                    public String getZipCode() {
                        return zipCode;
                    }

                    public void setZipCode(String zipCode) {
                        this.zipCode = zipCode;
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

                    public PrimaryPersonBean getPrimaryPerson() {
                        return primaryPerson;
                    }

                    public void setPrimaryPerson(PrimaryPersonBean primaryPerson) {
                        this.primaryPerson = primaryPerson;
                    }

                    public DeputyPersonBean getDeputyPerson() {
                        return deputyPerson;
                    }

                    public void setDeputyPerson(DeputyPersonBean deputyPerson) {
                        this.deputyPerson = deputyPerson;
                    }

                    public int getReviewOthers() {
                        return reviewOthers;
                    }

                    public void setReviewOthers(int reviewOthers) {
                        this.reviewOthers = reviewOthers;
                    }

                    public double getReviewSelf() {
                        return reviewSelf;
                    }

                    public void setReviewSelf(double reviewSelf) {
                        this.reviewSelf = reviewSelf;
                    }

                    public double getOtherCosting() {
                        return otherCosting;
                    }

                    public void setOtherCosting(double otherCosting) {
                        this.otherCosting = otherCosting;
                    }

                    public double getOtherPayment() {
                        return otherPayment;
                    }

                    public void setOtherPayment(double otherPayment) {
                        this.otherPayment = otherPayment;
                    }

                    public int getOtherQuality() {
                        return otherQuality;
                    }

                    public void setOtherQuality(int otherQuality) {
                        this.otherQuality = otherQuality;
                    }

                    public int getOtherService() {
                        return otherService;
                    }

                    public void setOtherService(int otherService) {
                        this.otherService = otherService;
                    }

                    public int getOtherTime() {
                        return otherTime;
                    }

                    public void setOtherTime(int otherTime) {
                        this.otherTime = otherTime;
                    }

                    public double getSelfCosting() {
                        return selfCosting;
                    }

                    public void setSelfCosting(double selfCosting) {
                        this.selfCosting = selfCosting;
                    }

                    public int getSelfPayment() {
                        return selfPayment;
                    }

                    public void setSelfPayment(int selfPayment) {
                        this.selfPayment = selfPayment;
                    }

                    public double getSelfQuality() {
                        return selfQuality;
                    }

                    public void setSelfQuality(double selfQuality) {
                        this.selfQuality = selfQuality;
                    }

                    public double getSelfService() {
                        return selfService;
                    }

                    public void setSelfService(double selfService) {
                        this.selfService = selfService;
                    }

                    public double getSelfTime() {
                        return selfTime;
                    }

                    public void setSelfTime(double selfTime) {
                        this.selfTime = selfTime;
                    }

                    public int getServiceCount() {
                        return serviceCount;
                    }

                    public void setServiceCount(int serviceCount) {
                        this.serviceCount = serviceCount;
                    }

                    public int getGrossProfit() {
                        return grossProfit;
                    }

                    public void setGrossProfit(int grossProfit) {
                        this.grossProfit = grossProfit;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<CustomerServiceListBean> getCustomerServiceList() {
                        return customerServiceList;
                    }

                    public void setCustomerServiceList(List<CustomerServiceListBean> customerServiceList) {
                        this.customerServiceList = customerServiceList;
                    }

                    public static class CreateByBeanX implements Serializable{
                        /**
                         * id : 1
                         * isNewRecord : false
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : true
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "CreateByBeanX{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class AreaBean implements Serializable {
                        /**
                         * id : 13
                         * isNewRecord : false
                         * parentIds : 0,1
                         * name : 浙江省
                         * sort : 30
                         * parentId : 0
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String parentIds;
                        private String name;
                        private int sort;
                        private String parentId;

                        @Override
                        public String toString() {
                            return "AreaBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", parentIds='" + parentIds + '\'' +
                                    ", name='" + name + '\'' +
                                    ", sort=" + sort +
                                    ", parentId='" + parentId + '\'' +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
                        }

                        public String getParentIds() {
                            return parentIds;
                        }

                        public void setParentIds(String parentIds) {
                            this.parentIds = parentIds;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getSort() {
                            return sort;
                        }

                        public void setSort(int sort) {
                            this.sort = sort;
                        }

                        public String getParentId() {
                            return parentId;
                        }

                        public void setParentId(String parentId) {
                            this.parentId = parentId;
                        }
                    }

                    public static class PrimaryPersonBean implements Serializable{
                        /**
                         * id :
                         * isNewRecord : true
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "PrimaryPersonBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class DeputyPersonBean implements Serializable {
                        /**
                         * id :
                         * isNewRecord : true
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "DeputyPersonBean{" +
                                    "id='" + id + '\'' +
                                    ", isNewRecord=" + isNewRecord +
                                    ", loginFlag='" + loginFlag + '\'' +
                                    ", roleNames='" + roleNames + '\'' +
                                    ", admin=" + admin +
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }

                    public static class CustomerServiceListBean implements Serializable {
                        /**
                         * id : cd7bcbfd6fc84f49a7ec908e93093432
                         * isNewRecord : false
                         * no : 001
                         * name : 安徽公司管理员
                         * email :
                         * phone :
                         * mobile :
                         * loginFlag : 1
                         * roleList : []
                         * roleNames :
                         * admin : false
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String no;
                        private String name;
                        private String email;
                        private String phone;
                        private String mobile;
                        private String loginFlag;
                        private String roleNames;
                        private boolean admin;
                        private List<?> roleList;

                        @Override
                        public String toString() {
                            return "CustomerServiceListBean{" +
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
                                    ", roleList=" + roleList +
                                    '}';
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public boolean isIsNewRecord() {
                            return isNewRecord;
                        }

                        public void setIsNewRecord(boolean isNewRecord) {
                            this.isNewRecord = isNewRecord;
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

                        public boolean isAdmin() {
                            return admin;
                        }

                        public void setAdmin(boolean admin) {
                            this.admin = admin;
                        }

                        public List<?> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<?> roleList) {
                            this.roleList = roleList;
                        }
                    }
                }
            }

        }
    }
}