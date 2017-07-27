package com.blanink.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public class PurchaseProduct {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"createBy":{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-02 18:06:49","updateDate":"2017-06-02 18:06:49","companyCategory":{"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":"","parentId":"0"},"price":"6000","amount":"5000","productDescription":"bnkmmm","deliveryTime":"2017-06-02","orderProductStatus":"1","orderProductStatusDesc":"甲方已创建未发送","productName":"hbnnn","orderProductSpecificationList":[{"id":"05f414f19ce94cd59ad7b0b3938b99a9","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"},"attributeValue":"89","hardCodeValueList":[]},{"id":"9c78ea44a462426480865650d9f9eafa","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"850269acf3cf4cc198ef2225d3d7c66f","isNewRecord":false,"name":"大小","sort":30,"public":false,"parentId":"0"},"attributeValue":"60","hardCodeValueList":[]},{"id":"14539fb4c05d47e3a35eeaa680205d9f","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"b8b0228502a344989522d603bdc15035","isNewRecord":false,"name":"品牌","sort":30,"public":false,"parentId":"0"},"attributeValue":"48899","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"容量:89    大小:60    品牌:48899    ","deliveryTimeString":"2017-06-02","companyAPriority":"0","companyAPriorityDesc":"","images":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"1","parentOrderProductId":"b2b15b6f2aa24690afe5abd69867fa9e","aCompany":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":""}]
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
         * id : ab4ad9d5502345d9a10c3d5a98219404
         * isNewRecord : false
         * createBy : {"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-06-02 18:06:49
         * updateDate : 2017-06-02 18:06:49
         * companyCategory : {"id":"0f03365e4999401e8ec2926d5621dbc7","isNewRecord":false,"name":"孙手机","sort":30,"company":{"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":"","parentId":"0"}
         * price : 6000
         * amount : 5000
         * productDescription : bnkmmm
         * deliveryTime : 2017-06-02
         * orderProductStatus : 1
         * orderProductStatusDesc : 甲方已创建未发送
         * productName : hbnnn
         * orderProductSpecificationList : [{"id":"05f414f19ce94cd59ad7b0b3938b99a9","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"},"attributeValue":"89","hardCodeValueList":[]},{"id":"9c78ea44a462426480865650d9f9eafa","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"850269acf3cf4cc198ef2225d3d7c66f","isNewRecord":false,"name":"大小","sort":30,"public":false,"parentId":"0"},"attributeValue":"60","hardCodeValueList":[]},{"id":"14539fb4c05d47e3a35eeaa680205d9f","isNewRecord":false,"orderProduct":{"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""},"attribute":{"id":"b8b0228502a344989522d603bdc15035","isNewRecord":false,"name":"品牌","sort":30,"public":false,"parentId":"0"},"attributeValue":"48899","hardCodeValueList":[]}]
         * htmlOrderProductSpecificationAttributes : 容量:89    大小:60    品牌:48899    
         * deliveryTimeString : 2017-06-02
         * companyAPriority : 0
         * companyAPriorityDesc :
         * images : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75699.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75701.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75700.pictureunlock
         * imageList : []
         * flowRemarkList : []
         * processFeedbackList : []
         * processWorkerList : []
         * workPlanList : []
         * source : 1
         * parentOrderProductId : b2b15b6f2aa24690afe5abd69867fa9e
         * aCompany : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * bCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * urls :
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private CompanyCategoryBean companyCategory;
        private String price;
        private String amount;
        private String productDescription;
        private String deliveryTime;
        private String orderProductStatus;
        private String orderProductStatusDesc;
        private String productName;
        private String htmlOrderProductSpecificationAttributes;
        private String deliveryTimeString;
        private String companyAPriority;
        private String companyAPriorityDesc;
        private String images;
        private String source;
        private String parentOrderProductId;
        private ACompanyBean aCompany;
        private BCompanyBean bCompany;
        private String urls;
        private List<OrderProductSpecificationListBean> orderProductSpecificationList;
        private List<?> imageList;
        private List<?> flowRemarkList;
        private List<?> processFeedbackList;
        private List<?> processWorkerList;
        private List<?> workPlanList;

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

        public CompanyCategoryBean getCompanyCategory() {
            return companyCategory;
        }

        public void setCompanyCategory(CompanyCategoryBean companyCategory) {
            this.companyCategory = companyCategory;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getOrderProductStatus() {
            return orderProductStatus;
        }

        public void setOrderProductStatus(String orderProductStatus) {
            this.orderProductStatus = orderProductStatus;
        }

        public String getOrderProductStatusDesc() {
            return orderProductStatusDesc;
        }

        public void setOrderProductStatusDesc(String orderProductStatusDesc) {
            this.orderProductStatusDesc = orderProductStatusDesc;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getHtmlOrderProductSpecificationAttributes() {
            return htmlOrderProductSpecificationAttributes;
        }

        public void setHtmlOrderProductSpecificationAttributes(String htmlOrderProductSpecificationAttributes) {
            this.htmlOrderProductSpecificationAttributes = htmlOrderProductSpecificationAttributes;
        }

        public String getDeliveryTimeString() {
            return deliveryTimeString;
        }

        public void setDeliveryTimeString(String deliveryTimeString) {
            this.deliveryTimeString = deliveryTimeString;
        }

        public String getCompanyAPriority() {
            return companyAPriority;
        }

        public void setCompanyAPriority(String companyAPriority) {
            this.companyAPriority = companyAPriority;
        }

        public String getCompanyAPriorityDesc() {
            return companyAPriorityDesc;
        }

        public void setCompanyAPriorityDesc(String companyAPriorityDesc) {
            this.companyAPriorityDesc = companyAPriorityDesc;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getParentOrderProductId() {
            return parentOrderProductId;
        }

        public void setParentOrderProductId(String parentOrderProductId) {
            this.parentOrderProductId = parentOrderProductId;
        }

        public ACompanyBean getACompany() {
            return aCompany;
        }

        public void setACompany(ACompanyBean aCompany) {
            this.aCompany = aCompany;
        }

        public BCompanyBean getBCompany() {
            return bCompany;
        }

        public void setBCompany(BCompanyBean bCompany) {
            this.bCompany = bCompany;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        public List<OrderProductSpecificationListBean> getOrderProductSpecificationList() {
            return orderProductSpecificationList;
        }

        public void setOrderProductSpecificationList(List<OrderProductSpecificationListBean> orderProductSpecificationList) {
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

        public static class CreateByBean {
            /**
             * id : 3c70d715d02a4c4aadc1952ecde286e1
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

        public static class CompanyCategoryBean {
            /**
             * id : 0f03365e4999401e8ec2926d5621dbc7
             * isNewRecord : false
             * name : 孙手机
             * sort : 30
             * company : {"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentName :
             * attributeIds :
             * industryCategoryIds :
             * industryCategoryNames :
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private CompanyBean company;
            private int size;
            private String attributeNames;
            private String parentName;
            private String attributeIds;
            private String industryCategoryIds;
            private String industryCategoryNames;
            private String parentId;
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

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
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
                 * photo :
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

        public static class ACompanyBean {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
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
            private String photo;
            private int grossProfit;
            private String pType;
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

        public static class BCompanyBean {
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
             * photo :
             * roleList : []
             * grossProfit : 0
             * pType :
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
            private String photo;
            private int grossProfit;
            private String pType;
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

        public static class OrderProductSpecificationListBean {
            /**
             * id : 05f414f19ce94cd59ad7b0b3938b99a9
             * isNewRecord : false
             * orderProduct : {"id":"ab4ad9d5502345d9a10c3d5a98219404","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":""}
             * attribute : {"id":"267a9460de74443cb8d292aac1b2e0ab","isNewRecord":false,"name":"容量","sort":30,"public":false,"parentId":"0"}
             * attributeValue : 89
             * hardCodeValueList : []
             */

            private String id;
            private boolean isNewRecord;
            private OrderProductBean orderProduct;
            private AttributeBean attribute;
            private String attributeValue;
            private List<?> hardCodeValueList;

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

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public AttributeBean getAttribute() {
                return attribute;
            }

            public void setAttribute(AttributeBean attribute) {
                this.attribute = attribute;
            }

            public String getAttributeValue() {
                return attributeValue;
            }

            public void setAttributeValue(String attributeValue) {
                this.attributeValue = attributeValue;
            }

            public List<?> getHardCodeValueList() {
                return hardCodeValueList;
            }

            public void setHardCodeValueList(List<?> hardCodeValueList) {
                this.hardCodeValueList = hardCodeValueList;
            }

            public static class OrderProductBean {
                /**
                 * id : ab4ad9d5502345d9a10c3d5a98219404
                 * isNewRecord : false
                 * orderProductSpecificationList : []
                 * htmlOrderProductSpecificationAttributes :
                 * imageList : []
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * urls :
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
            }

            public static class AttributeBean {
                /**
                 * id : 267a9460de74443cb8d292aac1b2e0ab
                 * isNewRecord : false
                 * name : 容量
                 * sort : 30
                 * public : false
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                @SerializedName("public")
                private boolean publicX;
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

                public boolean isPublicX() {
                    return publicX;
                }

                public void setPublicX(boolean publicX) {
                    this.publicX = publicX;
                }

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }
            }
        }
    }
}
