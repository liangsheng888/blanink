package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class CompanyCateGory implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"pageNo":1,"pageSize":10,"count":1,"list":[{"isNewRecord":true,"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"},"companyProduct":{"id":"a0e604fd2e2b44a3ac99af76b360423c","isNewRecord":false,"remarks":"<p>阿斯发沙敦府沙敦府<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-28 11:35:10","updateDate":"2017-04-10 17:26:11","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"companyCategory":{"id":"703296ef087a42ecb06ceca9d301ee10","isNewRecord":false,"name":"全能卡","sort":30,"serveType":"1","size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":""},"productName":"奥迪Q3500","productDescription":"小型suv","productPriceDownline":"180000","productPriceHighline":"279999","productPhotos":"","specificationList":[],"urls":[],"map":{}},"categoryAmount":1559,"myBidCount":0,"myInvestCount":0}],"html":"<ul>\n<li class=\"disabled\"><a href=\"javascript:\">« 上一页<\/a><\/li>\n<li class=\"active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"disabled\"><a href=\"javascript:\">下一页 »<\/a><\/li>\n<li class=\"disabled controls\"><a href=\"javascript:\">当前 <input type=\"text\" value=\"1\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');\" onclick=\"this.select();\"/> / <input type=\"text\" value=\"10\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');\" onclick=\"this.select();\"/> 条，共 1 条<\/a><\/li>\n<\/ul>\n<div style=\"clear:both;\"><\/div>","firstResult":0,"maxResults":10}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

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
        /**
         * pageNo : 1
         * pageSize : 10
         * count : 1
         * list : [{"isNewRecord":true,"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"},"companyProduct":{"id":"a0e604fd2e2b44a3ac99af76b360423c","isNewRecord":false,"remarks":"<p>阿斯发沙敦府沙敦府<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-28 11:35:10","updateDate":"2017-04-10 17:26:11","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"companyCategory":{"id":"703296ef087a42ecb06ceca9d301ee10","isNewRecord":false,"name":"全能卡","sort":30,"serveType":"1","size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":""},"productName":"奥迪Q3500","productDescription":"小型suv","productPriceDownline":"180000","productPriceHighline":"279999","productPhotos":"","specificationList":[],"urls":[],"map":{}},"categoryAmount":1559,"myBidCount":0,"myInvestCount":0}]
         * html : <ul>
         <li class="disabled"><a href="javascript:">« 上一页</a></li>
         <li class="active"><a href="javascript:">1</a></li>
         <li class="disabled"><a href="javascript:">下一页 »</a></li>
         <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');" onclick="this.select();"/> / <input type="text" value="10" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
         </ul>
         <div style="clear:both;"></div>
         * firstResult : 0
         * maxResults : 10
         */

        private int pageNo;
        private int pageSize;
        private int count;
        private String html;
        private int firstResult;
        private int maxResults;
        private List<ListBean> list;

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

        public static class ListBean implements Serializable{
            /**
             * isNewRecord : true
             * office : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"}
             * companyProduct : {"id":"a0e604fd2e2b44a3ac99af76b360423c","isNewRecord":false,"remarks":"<p>阿斯发沙敦府沙敦府<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-28 11:35:10","updateDate":"2017-04-10 17:26:11","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"},"companyCategory":{"id":"703296ef087a42ecb06ceca9d301ee10","isNewRecord":false,"name":"全能卡","sort":30,"serveType":"1","size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":""},"productName":"奥迪Q3500","productDescription":"小型suv","productPriceDownline":"180000","productPriceHighline":"279999","productPhotos":"","specificationList":[],"urls":[],"map":{}}
             * categoryAmount : 1559
             * myBidCount : 0
             * myInvestCount : 0
             */

            private boolean isNewRecord;
            private OfficeBean office;
            private CompanyProductBean companyProduct;
            private int categoryAmount;
            private int myBidCount;
            private int myInvestCount;

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
                /**
                 * id : f541afa391974409ba680e9bd9a394fd
                 * isNewRecord : false
                 * remarks :
                 * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
                 * createDate : 2017-01-05 15:11:38
                 * updateDate : 2017-01-05 15:11:38
                 * parentIds : 0,1,
                 * name : 江苏总公司
                 * sort : 30
                 * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
                 * code : 100000001
                 * shortName : 江苏总公司
                 * registTime : 2017-01-05 15:10:03
                 * type : 1
                 * serviceType : 1
                 * grade : 1
                 * address : 江苏省南京市
                 * zipCode : 210000
                 * master : 张三
                 * phone : 02512345678
                 * fax :
                 * email : zhagnsan@email.com
                 * useable : 1
                 * primaryPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * deputyPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * customerServiceList : [{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
                 * homepage : www.baidu.com
                 * reviewOthers : 3
                 * reviewSelf : 2.2
                 * otherCosting : 4.8
                 * otherPayment : 4.3
                 * otherQuality : 0
                 * otherService : 0
                 * otherTime : 0
                 * selfCosting : 4.3
                 * selfPayment : 0
                 * selfQuality : 4.5
                 * selfService : 4.8
                 * selfTime : 4.5
                 * serviceCount : 5
                 * grossProfit : 0
                 * parentId : 1
                 */

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
                private String pType;
                private String parentId;

                public String getpType() {
                    return pType;
                }

                public void setpType(String pType) {
                    this.pType = pType;
                }

                public boolean isNewRecord() {
                    return isNewRecord;
                }

                public void setNewRecord(boolean newRecord) {
                    isNewRecord = newRecord;
                }

                private List<CustomerServiceListBean> customerServiceList;

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

                public static class CreateByBean implements Serializable {
                    /**
                     * id : 1
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
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
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
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
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
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
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String no;
                    private String name;
                    private String email;
                    private String phone;
                    private String mobile;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
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
                /**
                 * id : a0e604fd2e2b44a3ac99af76b360423c
                 * isNewRecord : false
                 * remarks : <p>阿斯发沙敦府沙敦府<br/></p>
                 * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * createDate : 2017-03-28 11:35:10
                 * updateDate : 2017-04-10 17:26:11
                 * company : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"grossProfit":0,"parentId":"0"}
                 * companyCategory : {"id":"703296ef087a42ecb06ceca9d301ee10","isNewRecord":false,"name":"全能卡","sort":30,"serveType":"1","size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","industryCategoryNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":""}
                 * productName : 奥迪Q3500
                 * productDescription : 小型suv
                 * productPriceDownline : 180000
                 * productPriceHighline : 279999
                 * productPhotos :
                 * specificationList : []
                 * urls : []
                 * map : {}
                 */

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

                public static class CreateByBeanX implements Serializable {
                    /**
                     * id : d6c8e9bc4c2b476ba84b962c27882f41
                     * isNewRecord : false
                     * loginFlag : 1
                     * roleList : []
                     * admin : false
                     * roleNames :
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;
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

                    public boolean isAdmin() {
                        return admin;
                    }

                    public void setAdmin(boolean admin) {
                        this.admin = admin;
                    }

                    public String getRoleNames() {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames) {
                        this.roleNames = roleNames;
                    }

                    public List<?> getRoleList() {
                        return roleList;
                    }

                    public void setRoleList(List<?> roleList) {
                        this.roleList = roleList;
                    }
                }

                public static class CompanyBean implements Serializable {
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
                }

                public static class MapBean implements Serializable {
                }
            }
        }
    }
}
