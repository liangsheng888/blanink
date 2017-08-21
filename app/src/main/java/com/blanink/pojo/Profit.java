package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class Profit {
    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"saleAmount":0,"costAmount":5000000,"profitAmount":-5000000,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossAmount":0,"achieveAmount":0,"dateString":"2017-06"},{"isNewRecord":true,"saleAmount":100034000,"costAmount":7896200,"profitAmount":92137800,"accountReceivable":0,"receivedAmount":0,"payedAmount":0,"unPayedAmount":0,"lossAmount":0,"achieveAmount":0,"dateString":"2017-07"}]
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
         * saleAmount : 0
         * costAmount : 5000000
         * profitAmount : -5000000
         * accountReceivable : 0
         * receivedAmount : 0
         * payedAmount : 0
         * unPayedAmount : 0
         * lossAmount : 0
         * achieveAmount : 0
         * dateString : 2017-06
         */

        private boolean isNewRecord;
        private Double saleAmount;
        private Double costAmount;
        private Double profitAmount;
        private Double accountReceivable;
        private Double receivedAmount;
        private Double payedAmount;
        private Double unPayedAmount;
        private Double lossAmount;
        private Double achieveAmount;
        private String dateString;

        public boolean isIsNewRecord() {
            return isNewRecord;
        }

        public void setIsNewRecord(boolean isNewRecord) {
            this.isNewRecord = isNewRecord;
        }

        public Double getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(Double saleAmount) {
            this.saleAmount = saleAmount;
        }

        public Double getCostAmount() {
            return costAmount;
        }

        public void setCostAmount(Double costAmount) {
            this.costAmount = costAmount;
        }

        public Double getProfitAmount() {
            return profitAmount;
        }

        public void setProfitAmount(Double profitAmount) {
            this.profitAmount = profitAmount;
        }

        public Double getAccountReceivable() {
            return accountReceivable;
        }

        public void setAccountReceivable(Double accountReceivable) {
            this.accountReceivable = accountReceivable;
        }

        public Double getReceivedAmount() {
            return receivedAmount;
        }

        public void setReceivedAmount(Double receivedAmount) {
            this.receivedAmount = receivedAmount;
        }

        public Double getPayedAmount() {
            return payedAmount;
        }

        public void setPayedAmount(Double payedAmount) {
            this.payedAmount = payedAmount;
        }

        public Double getUnPayedAmount() {
            return unPayedAmount;
        }

        public void setUnPayedAmount(Double unPayedAmount) {
            this.unPayedAmount = unPayedAmount;
        }

        public Double getLossAmount() {
            return lossAmount;
        }

        public void setLossAmount(Double lossAmount) {
            this.lossAmount = lossAmount;
        }

        public Double getAchieveAmount() {
            return achieveAmount;
        }

        public void setAchieveAmount(Double achieveAmount) {
            this.achieveAmount = achieveAmount;
        }

        public String getDateString() {
            return dateString;
        }

        public void setDateString(String dateString) {
            this.dateString = dateString;
        }
    }
}
