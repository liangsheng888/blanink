package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 * 应收应付
 */
public class ReportPay {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"isNewRecord":true,"saleAmount":4294612,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"office":{"isNewRecord":true,"sort":30,"shortName":"安徽分公司ah500","type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}},{"isNewRecord":true,"saleAmount":55311,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"office":{"isNewRecord":true,"sort":30,"shortName":"测试公司621","type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}},{"isNewRecord":true,"saleAmount":151827264,"costAmount":9999,"profitAmount":0,"accountReceivable":151817264,"lossAmount":0,"office":{"isNewRecord":true,"sort":30,"shortName":"浙江总公司","type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}},{"isNewRecord":true,"saleAmount":299460,"costAmount":0,"profitAmount":0,"accountReceivable":0,"lossAmount":0,"office":{"isNewRecord":true,"sort":30,"shortName":"北京总公司","type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}}]
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
         * saleAmount : 4294612
         * costAmount : 0
         * profitAmount : 0
         * accountReceivable : 0
         * lossAmount : 0
         * office : {"isNewRecord":true,"sort":30,"shortName":"安徽分公司ah500","type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}
         */

        private boolean isNewRecord;
        private Double saleAmount;
        private Double costAmount;
        private Double profitAmount;
        private Double accountReceivable;
        private Double lossAmount;
        private OfficeBean office;

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

        public Double getLossAmount() {
            return lossAmount;
        }

        public void setLossAmount(Double lossAmount) {
            this.lossAmount = lossAmount;
        }

        public OfficeBean getOffice() {
            return office;
        }

        public void setOffice(OfficeBean office) {
            this.office = office;
        }

        public static class OfficeBean {
            /**
             * isNewRecord : true
             * sort : 30
             * shortName : 安徽分公司ah500
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
             * places : 0
             * parentId : 0
             */

            private boolean isNewRecord;
            private Double sort;
            private String shortName;
            private String type;
            private Double reviewOthers;
            private Double reviewSelf;
            private Double otherCosting;
            private Double otherPayment;
            private Double otherQuality;
            private Double otherService;
            private Double otherTime;
            private Double selfCosting;
            private Double selfPayment;
            private Double serviceCount;
            private String photo;
            private Double grossProfit;
            private String pType;
            private Double places;
            private String parentId;
            private List<?> customerServiceList;
            private List<?> roleList;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public Double getSort() {
                return sort;
            }

            public void setSort(Double sort) {
                this.sort = sort;
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

            public Double getReviewOthers() {
                return reviewOthers;
            }

            public void setReviewOthers(Double reviewOthers) {
                this.reviewOthers = reviewOthers;
            }

            public Double getReviewSelf() {
                return reviewSelf;
            }

            public void setReviewSelf(Double reviewSelf) {
                this.reviewSelf = reviewSelf;
            }

            public Double getOtherCosting() {
                return otherCosting;
            }

            public void setOtherCosting(Double otherCosting) {
                this.otherCosting = otherCosting;
            }

            public Double getOtherPayment() {
                return otherPayment;
            }

            public void setOtherPayment(Double otherPayment) {
                this.otherPayment = otherPayment;
            }

            public Double getOtherQuality() {
                return otherQuality;
            }

            public void setOtherQuality(Double otherQuality) {
                this.otherQuality = otherQuality;
            }

            public Double getOtherService() {
                return otherService;
            }

            public void setOtherService(Double otherService) {
                this.otherService = otherService;
            }

            public Double getOtherTime() {
                return otherTime;
            }

            public void setOtherTime(Double otherTime) {
                this.otherTime = otherTime;
            }

            public Double getSelfCosting() {
                return selfCosting;
            }

            public void setSelfCosting(Double selfCosting) {
                this.selfCosting = selfCosting;
            }

            public Double getSelfPayment() {
                return selfPayment;
            }

            public void setSelfPayment(Double selfPayment) {
                this.selfPayment = selfPayment;
            }

            public Double getServiceCount() {
                return serviceCount;
            }

            public void setServiceCount(Double serviceCount) {
                this.serviceCount = serviceCount;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public Double getGrossProfit() {
                return grossProfit;
            }

            public void setGrossProfit(Double grossProfit) {
                this.grossProfit = grossProfit;
            }

            public String getPType() {
                return pType;
            }

            public void setPType(String pType) {
                this.pType = pType;
            }

            public Double getPlaces() {
                return places;
            }

            public void setPlaces(Double places) {
                this.places = places;
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

            public List<?> getRoleList() {
                return roleList;
            }

            public void setRoleList(List<?> roleList) {
                this.roleList = roleList;
            }
        }
    }
}
