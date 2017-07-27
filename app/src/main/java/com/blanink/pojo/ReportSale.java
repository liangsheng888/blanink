package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
public class ReportSale {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"companyCategoryName":"阿萨德撒多","reportList":[]},{"isNewRecord":true,"companyCategoryName":"TCL","reportList":[{"isNewRecord":true,"startDate":1499413095000,"endDate":1499413417000,"saleAmount":11000,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"companyCategory":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""},"companyCategoryName":"TCL"},{"isNewRecord":true,"startDate":1498883147000,"endDate":1499836913000,"saleAmount":100000000,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"companyCategory":{"id":"0c89ee5b537e4056b92d009508375f22","isNewRecord":false,"name":"TCL","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""},"companyCategoryName":"TCL"}]},{"isNewRecord":true,"companyCategoryName":"孙手机","reportList":[{"isNewRecord":true,"startDate":1499340441000,"endDate":1499755601000,"saleAmount":23000,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"companyCategory":{"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""},"companyCategoryName":"孙手机"}]},{"isNewRecord":true,"companyCategoryName":"第三方","reportList":[]},{"isNewRecord":true,"companyCategoryName":"fcasdfasdf","reportList":[]},{"isNewRecord":true,"companyCategoryName":"打撒","reportList":[]},{"isNewRecord":true,"companyCategoryName":"22222","reportList":[]},{"isNewRecord":true,"companyCategoryName":"john汽车产品类测试多次点击","reportList":[]},{"isNewRecord":true,"companyCategoryName":"汽车","reportList":[]},{"isNewRecord":true,"companyCategoryName":"大声道","reportList":[]},{"isNewRecord":true,"companyCategoryName":"手机","reportList":[]},{"isNewRecord":true,"companyCategoryName":"阿萨德撒","reportList":[]},{"isNewRecord":true,"companyCategoryName":"wewe","reportList":[]}]
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
         * isNewRecord : true
         * companyCategoryName : 阿萨德撒多
         * reportList : []
         */

        private boolean isNewRecord;
        private String companyCategoryName;
        private double totalSaleAmount;
        private double totalCostAmount;
        private double totalProfitAmount;
        private double totalaccountReceivable;
        private double totalLossAmount;

        private List<Report> reportList;

        public double getTotalSaleAmount() {
            return totalSaleAmount;
        }

        public void setTotalSaleAmount(double totalSaleAmount) {
            this.totalSaleAmount = totalSaleAmount;
        }

        public double getTotalCostAmount() {
            return totalCostAmount;
        }

        public void setTotalCostAmount(double totalCostAmount) {
            this.totalCostAmount = totalCostAmount;
        }

        public double getTotalProfitAmount() {
            return totalProfitAmount;
        }

        public void setTotalProfitAmount(double totalProfitAmount) {
            this.totalProfitAmount = totalProfitAmount;
        }

        public double getTotalaccountReceivable() {
            return totalaccountReceivable;
        }

        public void setTotalaccountReceivable(double totalaccountReceivable) {
            this.totalaccountReceivable = totalaccountReceivable;
        }

        public double getTotalLossAmount() {
            return totalLossAmount;
        }

        public void setTotalLossAmount(double totalLossAmount) {
            this.totalLossAmount = totalLossAmount;
        }

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public String getCompanyCategoryName() {
            return companyCategoryName;
        }

        public void setCompanyCategoryName(String companyCategoryName) {
            this.companyCategoryName = companyCategoryName;
        }

        public List<Report> getReportList() {
            return reportList;
        }

        public void setReportList(List<Report> reportList) {
            this.reportList = reportList;
        }
    }

    public static class Report {

        /**
         * isNewRecord : true
         * startDate : 1499340441000
         * endDate : 1499755601000
         * saleAmount : 23000
         * costAmount : 0
         * profitAmount : 0
         * accountReceivable : 0
         * lossAmount : 0
         * companyCategory : {"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""}
         * companyCategoryName : 孙手机
         */

        private boolean isNewRecord;
        private long startDate;
        private long endDate;
        private int saleAmount;
        private int costAmount;
        private int profitAmount;
        private int accountReceivable;
        private int lossAmount;
        private CompanyCategoryBean companyCategory;
        private String companyCategoryName;
        private String  startDateString;
        private String  endDateString;
        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public long getStartDate() {
            return startDate;
        }

        public String getStartDateString() {
            return startDateString;
        }

        public void setStartDateString(String startDateString) {
            this.startDateString = startDateString;
        }

        public String getEndDateString() {
            return endDateString;
        }

        public void setEndDateString(String endDateString) {
            this.endDateString = endDateString;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public int getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(int saleAmount) {
            this.saleAmount = saleAmount;
        }

        public int getCostAmount() {
            return costAmount;
        }

        public void setCostAmount(int costAmount) {
            this.costAmount = costAmount;
        }

        public int getProfitAmount() {
            return profitAmount;
        }

        public void setProfitAmount(int profitAmount) {
            this.profitAmount = profitAmount;
        }

        public int getAccountReceivable() {
            return accountReceivable;
        }

        public void setAccountReceivable(int accountReceivable) {
            this.accountReceivable = accountReceivable;
        }

        public int getLossAmount() {
            return lossAmount;
        }

        public void setLossAmount(int lossAmount) {
            this.lossAmount = lossAmount;
        }

        public CompanyCategoryBean getCompanyCategory() {
            return companyCategory;
        }

        public void setCompanyCategory(CompanyCategoryBean companyCategory) {
            this.companyCategory = companyCategory;
        }

        public String getCompanyCategoryName() {
            return companyCategoryName;
        }

        public void setCompanyCategoryName(String companyCategoryName) {
            this.companyCategoryName = companyCategoryName;
        }

        public static class CompanyCategoryBean {
            /**
             * id : 0f03365e4999401e8ec2926d5621dbc7
             * isNewRecord : false
             * name : 孙手机
             * sort : 30
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentId : 0
             * parentName :
             * attributeIds :
             * industryCategoryIds :
             * industryCategoryNames :
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private int size;
            private String attributeNames;
            private String parentId;
            private String parentName;
            private String attributeIds;
            private String industryCategoryIds;
            private String industryCategoryNames;
            private List<?> categoryAttributeList;
            private List<?> relIndustryCompanyCategoryList;

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

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getParentName() {
                return parentName;
            }

            public void setParentName(String parentName) {
                this.parentName = parentName;
            }

            public String getAttributeIds() {
                return attributeIds;
            }

            public void setAttributeIds(String attributeIds) {
                this.attributeIds = attributeIds;
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
    }
}
