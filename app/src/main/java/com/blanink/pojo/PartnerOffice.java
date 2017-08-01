package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class PartnerOffice {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"2af38a403d944ef6935a8faa649e867b","isNewRecord":false,"name":"测试公司621","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司萨达阿萨德","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"259deb948da746928a89c0d3c2a23c15","isNewRecord":false,"name":"真北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"name":"安徽分公司ah500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"97e18a9774b6410190891050151d958c","isNewRecord":false,"name":"虚拟公司1","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"name":"安徽分公司ah500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司萨达阿萨德","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"name":"安徽分公司ah500","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"},{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"name":"江苏总公司萨达阿萨德","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}]
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
         * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
         * isNewRecord : false
         * name : 浙江总公司
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
         * photo :
         * roleList : []
         * grossProfit : 0
         * pType :
         * places : 0
         * parentId : 0
         */

        private String id;
        private boolean isNewRecord;
        private String name;
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
        private String photo;
        private int grossProfit;
        private String pType;
        private int places;
        private String parentId;
        private List<?> customerServiceList;
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

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getGrossProfit() {
            return grossProfit;
        }

        public void setGrossProfit(int grossProfit) {
            this.grossProfit = grossProfit;
        }

        public String getPType() {
            return pType;
        }

        public void setPType(String pType) {
            this.pType = pType;
        }

        public int getPlaces() {
            return places;
        }

        public void setPlaces(int places) {
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
