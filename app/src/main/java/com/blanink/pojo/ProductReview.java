package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class ProductReview implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"review":{"id":"45038ee5d24f468b8ef90b67a2fc5c3c","isNewRecord":false,"createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-30 17:19:54","updateDate":"2017-06-30 17:19:54","order":{"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"orderProduct":{"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"contents":"ddd","type":"2","serviceGrade":"1","qualityGrade":"0","timingGrade":"1","costingGrade":"0","paymentGrade":"0","integrityGrade":"0","reviewReplyList":[],"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}},"comments":{"id":"d2323c4699a3413b9deb977899c0f8f2","isNewRecord":false,"createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-30 17:19:54","updateDate":"2017-06-30 17:19:54","order":{"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"orderProduct":{"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"contents":"dd","type":"1","serviceGrade":"0","qualityGrade":"0","timingGrade":"0","costingGrade":"1","paymentGrade":"0","integrityGrade":"1","reviewReplyList":[],"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}}}
     */

    private String errorCode;
    private String reason;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * review : {"id":"45038ee5d24f468b8ef90b67a2fc5c3c","isNewRecord":false,"createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-30 17:19:54","updateDate":"2017-06-30 17:19:54","order":{"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"orderProduct":{"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"contents":"ddd","type":"2","serviceGrade":"1","qualityGrade":"0","timingGrade":"1","costingGrade":"0","paymentGrade":"0","integrityGrade":"0","reviewReplyList":[],"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}}
         * comments : {"id":"d2323c4699a3413b9deb977899c0f8f2","isNewRecord":false,"createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-30 17:19:54","updateDate":"2017-06-30 17:19:54","order":{"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"orderProduct":{"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"contents":"dd","type":"1","serviceGrade":"0","qualityGrade":"0","timingGrade":"0","costingGrade":"1","paymentGrade":"0","integrityGrade":"1","reviewReplyList":[],"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}}
         */

        private ReviewBean review;
        private CommentsBean comments;

        public ReviewBean getReview() {
            return review;
        }

        public void setReview(ReviewBean review) {
            this.review = review;
        }

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public static class ReviewBean {
            /**
             * id : 45038ee5d24f468b8ef90b67a2fc5c3c
             * isNewRecord : false
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-06-30 17:19:54
             * updateDate : 2017-06-30 17:19:54
             * order : {"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
             * orderProduct : {"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]}
             * contents : ddd
             * type : 2
             * serviceGrade : 1
             * qualityGrade : 0
             * timingGrade : 1
             * costingGrade : 0
             * paymentGrade : 0
             * integrityGrade : 0
             * reviewReplyList : []
             * company : {"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             */

            private String id;
            private boolean isNewRecord;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private OrderBean order;
            private OrderProductBean orderProduct;
            private String contents;
            private String type;
            private String serviceGrade;
            private String qualityGrade;
            private String timingGrade;
            private String costingGrade;
            private String paymentGrade;
            private String integrityGrade;
            private CompanyBean company;
            private List<?> reviewReplyList;

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

            public OrderBean getOrder() {
                return order;
            }

            public void setOrder(OrderBean order) {
                this.order = order;
            }

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getServiceGrade() {
                return serviceGrade;
            }

            public void setServiceGrade(String serviceGrade) {
                this.serviceGrade = serviceGrade;
            }

            public String getQualityGrade() {
                return qualityGrade;
            }

            public void setQualityGrade(String qualityGrade) {
                this.qualityGrade = qualityGrade;
            }

            public String getTimingGrade() {
                return timingGrade;
            }

            public void setTimingGrade(String timingGrade) {
                this.timingGrade = timingGrade;
            }

            public String getCostingGrade() {
                return costingGrade;
            }

            public void setCostingGrade(String costingGrade) {
                this.costingGrade = costingGrade;
            }

            public String getPaymentGrade() {
                return paymentGrade;
            }

            public void setPaymentGrade(String paymentGrade) {
                this.paymentGrade = paymentGrade;
            }

            public String getIntegrityGrade() {
                return integrityGrade;
            }

            public void setIntegrityGrade(String integrityGrade) {
                this.integrityGrade = integrityGrade;
            }

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
            }

            public List<?> getReviewReplyList() {
                return reviewReplyList;
            }

            public void setReviewReplyList(List<?> reviewReplyList) {
                this.reviewReplyList = reviewReplyList;
            }

            public static class CreateByBean {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
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

            public static class OrderBean {
                /**
                 * id : 5e53b068c33c42b48b4f26345797c2c1
                 * isNewRecord : false
                 * sort : 30
                 * takeOrderTimeString :
                 * delieverTimeString :
                 * orderProductList : []
                 * orderList : []
                 * historyOrderNumber : 0
                 * takeOrderTimeBeginString :
                 * takeOrderTimeEndString :
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private int sort;
                private String takeOrderTimeString;
                private String delieverTimeString;
                private int historyOrderNumber;
                private String takeOrderTimeBeginString;
                private String takeOrderTimeEndString;
                private String parentId;
                private List<?> orderProductList;
                private List<?> orderList;

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

                public String getTakeOrderTimeString() {
                    return takeOrderTimeString;
                }

                public void setTakeOrderTimeString(String takeOrderTimeString) {
                    this.takeOrderTimeString = takeOrderTimeString;
                }

                public String getDelieverTimeString() {
                    return delieverTimeString;
                }

                public void setDelieverTimeString(String delieverTimeString) {
                    this.delieverTimeString = delieverTimeString;
                }

                public int getHistoryOrderNumber() {
                    return historyOrderNumber;
                }

                public void setHistoryOrderNumber(int historyOrderNumber) {
                    this.historyOrderNumber = historyOrderNumber;
                }

                public String getTakeOrderTimeBeginString() {
                    return takeOrderTimeBeginString;
                }

                public void setTakeOrderTimeBeginString(String takeOrderTimeBeginString) {
                    this.takeOrderTimeBeginString = takeOrderTimeBeginString;
                }

                public String getTakeOrderTimeEndString() {
                    return takeOrderTimeEndString;
                }

                public void setTakeOrderTimeEndString(String takeOrderTimeEndString) {
                    this.takeOrderTimeEndString = takeOrderTimeEndString;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getOrderProductList() {
                    return orderProductList;
                }

                public void setOrderProductList(List<?> orderProductList) {
                    this.orderProductList = orderProductList;
                }

                public List<?> getOrderList() {
                    return orderList;
                }

                public void setOrderList(List<?> orderList) {
                    this.orderList = orderList;
                }
            }

            public static class OrderProductBean {
                /**
                 * id : 5cc3df3070f84a83b3913912d5aa0be2
                 * isNewRecord : false
                 * orderProductSpecificationList : []
                 * htmlOrderProductSpecificationAttributes :
                 * imageList : []
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * urls :
                 * relFlowProcessList : []
                 */

                private String id;
                private boolean isNewRecord;
                private String htmlOrderProductSpecificationAttributes;
                private String urls;
                private List<?> orderProductSpecificationList;
                private List<?> imageList;
                private List<?> flowRemarkList;
                private List<?> processFeedbackList;
                private List<?> processWorkerList;
                private List<?> workPlanList;
                private List<?> relFlowProcessList;

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

                public String getHtmlOrderProductSpecificationAttributes() {
                    return htmlOrderProductSpecificationAttributes;
                }

                public void setHtmlOrderProductSpecificationAttributes(String htmlOrderProductSpecificationAttributes) {
                    this.htmlOrderProductSpecificationAttributes = htmlOrderProductSpecificationAttributes;
                }

                public String getUrls() {
                    return urls;
                }

                public void setUrls(String urls) {
                    this.urls = urls;
                }

                public List<?> getOrderProductSpecificationList() {
                    return orderProductSpecificationList;
                }

                public void setOrderProductSpecificationList(List<?> orderProductSpecificationList) {
                    this.orderProductSpecificationList = orderProductSpecificationList;
                }

                public List<?> getImageList() {
                    return imageList;
                }

                public void setImageList(List<?> imageList) {
                    this.imageList = imageList;
                }

                public List<?> getFlowRemarkList() {
                    return flowRemarkList;
                }

                public void setFlowRemarkList(List<?> flowRemarkList) {
                    this.flowRemarkList = flowRemarkList;
                }

                public List<?> getProcessFeedbackList() {
                    return processFeedbackList;
                }

                public void setProcessFeedbackList(List<?> processFeedbackList) {
                    this.processFeedbackList = processFeedbackList;
                }

                public List<?> getProcessWorkerList() {
                    return processWorkerList;
                }

                public void setProcessWorkerList(List<?> processWorkerList) {
                    this.processWorkerList = processWorkerList;
                }

                public List<?> getWorkPlanList() {
                    return workPlanList;
                }

                public void setWorkPlanList(List<?> workPlanList) {
                    this.workPlanList = workPlanList;
                }

                public List<?> getRelFlowProcessList() {
                    return relFlowProcessList;
                }

                public void setRelFlowProcessList(List<?> relFlowProcessList) {
                    this.relFlowProcessList = relFlowProcessList;
                }
            }

            public static class CompanyBean {
                /**
                 * isNewRecord : true
                 * name : 江苏总公司
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
                 * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock
                 * roleList : []
                 * grossProfit : 0
                 * pType :
                 * parentId : 0
                 */

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
                private String parentId;
                private List<?> customerServiceList;
                private List<?> roleList;

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

        public static class CommentsBean {
            /**
             * id : d2323c4699a3413b9deb977899c0f8f2
             * isNewRecord : false
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-06-30 17:19:54
             * updateDate : 2017-06-30 17:19:54
             * order : {"id":"5e53b068c33c42b48b4f26345797c2c1","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
             * orderProduct : {"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]}
             * contents : dd
             * type : 1
             * serviceGrade : 0
             * qualityGrade : 0
             * timingGrade : 0
             * costingGrade : 1
             * paymentGrade : 0
             * integrityGrade : 1
             * reviewReplyList : []
             * company : {"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             */

            private String id;
            private boolean isNewRecord;
            private CreateByBeanX createBy;
            private String createDate;
            private String updateDate;
            private OrderBeanX order;
            private OrderProductBeanX orderProduct;
            private String contents;
            private String type;
            private String serviceGrade;
            private String qualityGrade;
            private String timingGrade;
            private String costingGrade;
            private String paymentGrade;
            private String integrityGrade;
            private CompanyBeanX company;
            private List<?> reviewReplyList;

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

            public OrderBeanX getOrder() {
                return order;
            }

            public void setOrder(OrderBeanX order) {
                this.order = order;
            }

            public OrderProductBeanX getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBeanX orderProduct) {
                this.orderProduct = orderProduct;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getServiceGrade() {
                return serviceGrade;
            }

            public void setServiceGrade(String serviceGrade) {
                this.serviceGrade = serviceGrade;
            }

            public String getQualityGrade() {
                return qualityGrade;
            }

            public void setQualityGrade(String qualityGrade) {
                this.qualityGrade = qualityGrade;
            }

            public String getTimingGrade() {
                return timingGrade;
            }

            public void setTimingGrade(String timingGrade) {
                this.timingGrade = timingGrade;
            }

            public String getCostingGrade() {
                return costingGrade;
            }

            public void setCostingGrade(String costingGrade) {
                this.costingGrade = costingGrade;
            }

            public String getPaymentGrade() {
                return paymentGrade;
            }

            public void setPaymentGrade(String paymentGrade) {
                this.paymentGrade = paymentGrade;
            }

            public String getIntegrityGrade() {
                return integrityGrade;
            }

            public void setIntegrityGrade(String integrityGrade) {
                this.integrityGrade = integrityGrade;
            }

            public CompanyBeanX getCompany() {
                return company;
            }

            public void setCompany(CompanyBeanX company) {
                this.company = company;
            }

            public List<?> getReviewReplyList() {
                return reviewReplyList;
            }

            public void setReviewReplyList(List<?> reviewReplyList) {
                this.reviewReplyList = reviewReplyList;
            }

            public static class CreateByBeanX {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
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

            public static class OrderBeanX {
                /**
                 * id : 5e53b068c33c42b48b4f26345797c2c1
                 * isNewRecord : false
                 * sort : 30
                 * takeOrderTimeString :
                 * delieverTimeString :
                 * orderProductList : []
                 * orderList : []
                 * historyOrderNumber : 0
                 * takeOrderTimeBeginString :
                 * takeOrderTimeEndString :
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private int sort;
                private String takeOrderTimeString;
                private String delieverTimeString;
                private int historyOrderNumber;
                private String takeOrderTimeBeginString;
                private String takeOrderTimeEndString;
                private String parentId;
                private List<?> orderProductList;
                private List<?> orderList;

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

                public String getTakeOrderTimeString() {
                    return takeOrderTimeString;
                }

                public void setTakeOrderTimeString(String takeOrderTimeString) {
                    this.takeOrderTimeString = takeOrderTimeString;
                }

                public String getDelieverTimeString() {
                    return delieverTimeString;
                }

                public void setDelieverTimeString(String delieverTimeString) {
                    this.delieverTimeString = delieverTimeString;
                }

                public int getHistoryOrderNumber() {
                    return historyOrderNumber;
                }

                public void setHistoryOrderNumber(int historyOrderNumber) {
                    this.historyOrderNumber = historyOrderNumber;
                }

                public String getTakeOrderTimeBeginString() {
                    return takeOrderTimeBeginString;
                }

                public void setTakeOrderTimeBeginString(String takeOrderTimeBeginString) {
                    this.takeOrderTimeBeginString = takeOrderTimeBeginString;
                }

                public String getTakeOrderTimeEndString() {
                    return takeOrderTimeEndString;
                }

                public void setTakeOrderTimeEndString(String takeOrderTimeEndString) {
                    this.takeOrderTimeEndString = takeOrderTimeEndString;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getOrderProductList() {
                    return orderProductList;
                }

                public void setOrderProductList(List<?> orderProductList) {
                    this.orderProductList = orderProductList;
                }

                public List<?> getOrderList() {
                    return orderList;
                }

                public void setOrderList(List<?> orderList) {
                    this.orderList = orderList;
                }
            }

            public static class OrderProductBeanX {
                /**
                 * id : 5cc3df3070f84a83b3913912d5aa0be2
                 * isNewRecord : false
                 * orderProductSpecificationList : []
                 * htmlOrderProductSpecificationAttributes :
                 * imageList : []
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * urls :
                 * relFlowProcessList : []
                 */

                private String id;
                private boolean isNewRecord;
                private String htmlOrderProductSpecificationAttributes;
                private String urls;
                private List<?> orderProductSpecificationList;
                private List<?> imageList;
                private List<?> flowRemarkList;
                private List<?> processFeedbackList;
                private List<?> processWorkerList;
                private List<?> workPlanList;
                private List<?> relFlowProcessList;

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

                public String getHtmlOrderProductSpecificationAttributes() {
                    return htmlOrderProductSpecificationAttributes;
                }

                public void setHtmlOrderProductSpecificationAttributes(String htmlOrderProductSpecificationAttributes) {
                    this.htmlOrderProductSpecificationAttributes = htmlOrderProductSpecificationAttributes;
                }

                public String getUrls() {
                    return urls;
                }

                public void setUrls(String urls) {
                    this.urls = urls;
                }

                public List<?> getOrderProductSpecificationList() {
                    return orderProductSpecificationList;
                }

                public void setOrderProductSpecificationList(List<?> orderProductSpecificationList) {
                    this.orderProductSpecificationList = orderProductSpecificationList;
                }

                public List<?> getImageList() {
                    return imageList;
                }

                public void setImageList(List<?> imageList) {
                    this.imageList = imageList;
                }

                public List<?> getFlowRemarkList() {
                    return flowRemarkList;
                }

                public void setFlowRemarkList(List<?> flowRemarkList) {
                    this.flowRemarkList = flowRemarkList;
                }

                public List<?> getProcessFeedbackList() {
                    return processFeedbackList;
                }

                public void setProcessFeedbackList(List<?> processFeedbackList) {
                    this.processFeedbackList = processFeedbackList;
                }

                public List<?> getProcessWorkerList() {
                    return processWorkerList;
                }

                public void setProcessWorkerList(List<?> processWorkerList) {
                    this.processWorkerList = processWorkerList;
                }

                public List<?> getWorkPlanList() {
                    return workPlanList;
                }

                public void setWorkPlanList(List<?> workPlanList) {
                    this.workPlanList = workPlanList;
                }

                public List<?> getRelFlowProcessList() {
                    return relFlowProcessList;
                }

                public void setRelFlowProcessList(List<?> relFlowProcessList) {
                    this.relFlowProcessList = relFlowProcessList;
                }
            }

            public static class CompanyBeanX {
                /**
                 * isNewRecord : true
                 * name : 江苏总公司
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
                 * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_f88f16b298faf6cc0177ad3d572e29fd.pictureunlock
                 * roleList : []
                 * grossProfit : 0
                 * pType :
                 * parentId : 0
                 */

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
                private String parentId;
                private List<?> customerServiceList;
                private List<?> roleList;

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
}
