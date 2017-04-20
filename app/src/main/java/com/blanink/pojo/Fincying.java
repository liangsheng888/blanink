package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Fincying {
    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"pageNo":1,"pageSize":10,"count":1,"list":[{"isNewRecord":true,"financing":{"id":"1a02152ea83947d18b1dcd18fa199b4a","isNewRecord":false,"remarks":"阿斯顿发生发","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-10 15:18:13","updateDate":"2017-04-10 15:18:13","company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:12:44","updateDate":"2017-01-05 15:12:44","parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"code":"100000002","shortName":"浙江总公司","registTime":"2017-01-05 15:12:20","type":"1","serviceType":"1","grade":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":3,"grossProfit":0,"parentId":"1"},"title":"融资500万","cooperationType":"1","fundUsageMode":"1","sumMoney":500,"acceptFundSource":"1","repaymentTerm":12,"restrictArea":"1584,1586","expiryDate":"2017-04-26","repaymentType":"1","expectRate":0,"monthlyRepayment":416666.66,"lastMonthlyRepayment":0,"transferShare":"","toCashType":"1","resources":[],"areaList":[],"areaIds":["1584","1586"],"lowestMoney":0,"highestMoney":0,"restrictAreaIds":"1584,1586","next":false,"urls":""},"myBidCount":0,"myInvestCount":0}],"html":"<ul>\n<li class=\"disabled\"><a href=\"javascript:\">« 上一页<\/a><\/li>\n<li class=\"active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"disabled\"><a href=\"javascript:\">下一页 »<\/a><\/li>\n<li class=\"disabled controls\"><a href=\"javascript:\">当前 <input type=\"text\" value=\"1\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');\" onclick=\"this.select();\"/> / <input type=\"text\" value=\"10\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');\" onclick=\"this.select();\"/> 条，共 1 条<\/a><\/li>\n<\/ul>\n<div style=\"clear:both;\"><\/div>","firstResult":0,"maxResults":10}]
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

    public static class ResultBean {
        /**
         * pageNo : 1
         * pageSize : 10
         * count : 1
         * list : [{"isNewRecord":true,"financing":{"id":"1a02152ea83947d18b1dcd18fa199b4a","isNewRecord":false,"remarks":"阿斯顿发生发","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-10 15:18:13","updateDate":"2017-04-10 15:18:13","company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:12:44","updateDate":"2017-01-05 15:12:44","parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"code":"100000002","shortName":"浙江总公司","registTime":"2017-01-05 15:12:20","type":"1","serviceType":"1","grade":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":3,"grossProfit":0,"parentId":"1"},"title":"融资500万","cooperationType":"1","fundUsageMode":"1","sumMoney":500,"acceptFundSource":"1","repaymentTerm":12,"restrictArea":"1584,1586","expiryDate":"2017-04-26","repaymentType":"1","expectRate":0,"monthlyRepayment":416666.66,"lastMonthlyRepayment":0,"transferShare":"","toCashType":"1","resources":[],"areaList":[],"areaIds":["1584","1586"],"lowestMoney":0,"highestMoney":0,"restrictAreaIds":"1584,1586","next":false,"urls":""},"myBidCount":0,"myInvestCount":0}]
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

        public static class ListBean {
            /**
             * isNewRecord : true
             * financing : {"id":"1a02152ea83947d18b1dcd18fa199b4a","isNewRecord":false,"remarks":"阿斯顿发生发","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-10 15:18:13","updateDate":"2017-04-10 15:18:13","company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:12:44","updateDate":"2017-01-05 15:12:44","parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"code":"100000002","shortName":"浙江总公司","registTime":"2017-01-05 15:12:20","type":"1","serviceType":"1","grade":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":3,"grossProfit":0,"parentId":"1"},"title":"融资500万","cooperationType":"1","fundUsageMode":"1","sumMoney":500,"acceptFundSource":"1","repaymentTerm":12,"restrictArea":"1584,1586","expiryDate":"2017-04-26","repaymentType":"1","expectRate":0,"monthlyRepayment":416666.66,"lastMonthlyRepayment":0,"transferShare":"","toCashType":"1","resources":[],"areaList":[],"areaIds":["1584","1586"],"lowestMoney":0,"highestMoney":0,"restrictAreaIds":"1584,1586","next":false,"urls":""}
             * myBidCount : 0
             * myInvestCount : 0
             */

            private boolean isNewRecord;
            private FinancingBean financing;
            private int myBidCount;
            private int myInvestCount;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public FinancingBean getFinancing() {
                return financing;
            }

            public void setFinancing(FinancingBean financing) {
                this.financing = financing;
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

            public static class FinancingBean {
                /**
                 * id : 1a02152ea83947d18b1dcd18fa199b4a
                 * isNewRecord : false
                 * remarks : 阿斯顿发生发
                 * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * createDate : 2017-04-10 15:18:13
                 * updateDate : 2017-04-10 15:18:13
                 * company : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:12:44","updateDate":"2017-01-05 15:12:44","parentIds":"0,1,","name":"浙江总公司","sort":30,"area":{"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"},"code":"100000002","shortName":"浙江总公司","registTime":"2017-01-05 15:12:20","type":"1","serviceType":"1","grade":"1","address":"浙江省杭州市","zipCode":"310000","master":"李四","phone":"","fax":"","email":"","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":3,"grossProfit":0,"parentId":"1"}
                 * title : 融资500万
                 * cooperationType : 1
                 * fundUsageMode : 1
                 * sumMoney : 500
                 * acceptFundSource : 1
                 * repaymentTerm : 12
                 * restrictArea : 1584,1586
                 * expiryDate : 2017-04-26
                 * repaymentType : 1
                 * expectRate : 0
                 * monthlyRepayment : 416666.66
                 * lastMonthlyRepayment : 0
                 * transferShare :
                 * toCashType : 1
                 * resources : []
                 * areaList : []
                 * areaIds : ["1584","1586"]
                 * lowestMoney : 0
                 * highestMoney : 0
                 * restrictAreaIds : 1584,1586
                 * next : false
                 * urls :
                 */

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
                private String restrictAreaIds;
                private boolean next;
                private String urls;
                private List<?> resources;
                private List<?> areaList;
                private List<String> areaIds;

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

                public String getRestrictAreaIds() {
                    return restrictAreaIds;
                }

                public void setRestrictAreaIds(String restrictAreaIds) {
                    this.restrictAreaIds = restrictAreaIds;
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

                public static class CreateByBean {
                    /**
                     * id : 447e4526d22045f59ed58250046b3842
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

                public static class CompanyBean {
                    /**
                     * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
                     * isNewRecord : false
                     * remarks :
                     * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
                     * createDate : 2017-01-05 15:12:44
                     * updateDate : 2017-01-05 15:12:44
                     * parentIds : 0,1,
                     * name : 浙江总公司
                     * sort : 30
                     * area : {"id":"13","isNewRecord":false,"parentIds":"0,1","name":"浙江省","sort":30,"parentId":"0"}
                     * code : 100000002
                     * shortName : 浙江总公司
                     * registTime : 2017-01-05 15:12:20
                     * type : 1
                     * serviceType : 1
                     * grade : 1
                     * address : 浙江省杭州市
                     * zipCode : 310000
                     * master : 李四
                     * phone :
                     * fax :
                     * email :
                     * useable : 1
                     * primaryPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                     * deputyPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                     * customerServiceList : [{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
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
                     * serviceCount : 3
                     * grossProfit : 0
                     * parentId : 1
                     */

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

                    public static class CreateByBeanX {
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

                    public static class AreaBean {
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

                    public static class PrimaryPersonBean {
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

                    public static class DeputyPersonBean {
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

                    public static class CustomerServiceListBean {
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
            }
        }
    }
}
