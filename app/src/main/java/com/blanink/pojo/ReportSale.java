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

    @Override
    public String toString() {
        return "ReportSale{" +
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

        @Override
        public String toString() {
            return "ResultBean{" +
                    "isNewRecord=" + isNewRecord +
                    ", companyCategoryName='" + companyCategoryName + '\'' +
                    ", totalSaleAmount=" + totalSaleAmount +
                    ", totalCostAmount=" + totalCostAmount +
                    ", totalProfitAmount=" + totalProfitAmount +
                    ", totalaccountReceivable=" + totalaccountReceivable +
                    ", totalLossAmount=" + totalLossAmount +
                    ", reportList=" + reportList +
                    '}';
        }

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
        private double saleAmount;
        private double costAmount;
        private double profitAmount;
        private double accountReceivable;
        private double lossAmount;
        private String companyCategoryName;
        private String dateString;

        public boolean isNewRecord() {
            return isNewRecord;
        }

        public void setNewRecord(boolean newRecord) {
            isNewRecord = newRecord;
        }

        public long getStartDate() {
            return startDate;
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

        public double getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(double saleAmount) {
            this.saleAmount = saleAmount;
        }

        public double getCostAmount() {
            return costAmount;
        }

        public void setCostAmount(double costAmount) {
            this.costAmount = costAmount;
        }

        public double getProfitAmount() {
            return profitAmount;
        }

        public void setProfitAmount(double profitAmount) {
            this.profitAmount = profitAmount;
        }

        public double getAccountReceivable() {
            return accountReceivable;
        }

        public void setAccountReceivable(double accountReceivable) {
            this.accountReceivable = accountReceivable;
        }

        public double getLossAmount() {
            return lossAmount;
        }

        public void setLossAmount(double lossAmount) {
            this.lossAmount = lossAmount;
        }

        public String getCompanyCategoryName() {
            return companyCategoryName;
        }

        public void setCompanyCategoryName(String companyCategoryName) {
            this.companyCategoryName = companyCategoryName;
        }

        public String getDateString() {
            return dateString;
        }

        public void setDateString(String dateString) {
            this.dateString = dateString;
        }

        @Override
        public String toString() {
            return "Report{" +
                    "isNewRecord=" + isNewRecord +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", saleAmount=" + saleAmount +
                    ", costAmount=" + costAmount +
                    ", profitAmount=" + profitAmount +
                    ", accountReceivable=" + accountReceivable +
                    ", lossAmount=" + lossAmount +
                    ", companyCategoryName='" + companyCategoryName + '\'' +
                    ", dateString='" + dateString + '\'' +
                    '}';
        }
    }
}
