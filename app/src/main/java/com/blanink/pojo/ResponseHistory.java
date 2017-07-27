package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 * 公司员工反馈记录
 */
public class ResponseHistory implements Serializable {

    /**
     * errorCode : 00000
     * reason : 搜索数据成功！
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

    public static class ResultBean implements Serializable{

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean implements Serializable{
            /**
             * id : 784776b11f3846e5bfefdbef51b815f7
             * isNewRecord : false
             * remarks : nnnm
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-07-05 15:36:33
             * updateDate : 2017-07-05 15:36:33
             * flow : {"id":"f9f133f6d0294b9b8909ed2262b02c69","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
             * process : {"id":"dce551fbde2a46f5881fbc689e275f9e","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
             * isFinished : 0
             * achieveAmount : 10
             * resources : [{"id":"b5c8188f33b348798097b8c19161a0f3","isNewRecord":false,"resourceName":"alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg"],"currentUrlList":[]}]
             * feedbackUser : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * orderProduct : {"id":"5cc3df3070f84a83b3913912d5aa0be2","isNewRecord":false,"order":{"isNewRecord":true,"sort":30,"bCompanyOrderOwnerUser":{"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"takeOrderTime":"2017-06-20","takeOrderTimeString":"2017-06-20","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""},"amount":"500","orderProductStatus":"16","orderProductStatusDesc":"待接受售后申请","productName":"华为荣耀m","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","companyBPriority":"3","companyBPriorityDesc":"高度重视","imageList":[],"innerDeliveryTime":"2017-06-23","innerDeliveryTimeString":"2017-06-23","flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"productSn":"102100633596","urls":"","relFlowProcessList":[]}
             * target : 0
             * aCompany : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","places":0,"parentId":"0"}
             * feedbackAttachmentStr : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg
             * urls : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg
             * faultAmount : 0
             * confirmAmount : -1
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBean createBy;
            private String createDate;
            private String updateDate;
            private FlowBean flow;
            private ProcessBean process;
            private String isFinished;
            private int achieveAmount;
            private FeedbackUserBean feedbackUser;
            private OrderProductBean orderProduct;
            private int target;
            private ACompanyBean aCompany;
            private String feedbackAttachmentStr;
            private String urls;
            private int faultAmount;
            private int confirmAmount;
            private List<ResourcesBean> resources;

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

            public FlowBean getFlow() {
                return flow;
            }

            public void setFlow(FlowBean flow) {
                this.flow = flow;
            }

            public ProcessBean getProcess() {
                return process;
            }

            public void setProcess(ProcessBean process) {
                this.process = process;
            }

            public String getIsFinished() {
                return isFinished;
            }

            public void setIsFinished(String isFinished) {
                this.isFinished = isFinished;
            }

            public int getAchieveAmount() {
                return achieveAmount;
            }

            public void setAchieveAmount(int achieveAmount) {
                this.achieveAmount = achieveAmount;
            }

            public FeedbackUserBean getFeedbackUser() {
                return feedbackUser;
            }

            public void setFeedbackUser(FeedbackUserBean feedbackUser) {
                this.feedbackUser = feedbackUser;
            }

            public OrderProductBean getOrderProduct() {
                return orderProduct;
            }

            public void setOrderProduct(OrderProductBean orderProduct) {
                this.orderProduct = orderProduct;
            }

            public int getTarget() {
                return target;
            }

            public void setTarget(int target) {
                this.target = target;
            }

            public ACompanyBean getACompany() {
                return aCompany;
            }

            public void setACompany(ACompanyBean aCompany) {
                this.aCompany = aCompany;
            }

            public String getFeedbackAttachmentStr() {
                return feedbackAttachmentStr;
            }

            public void setFeedbackAttachmentStr(String feedbackAttachmentStr) {
                this.feedbackAttachmentStr = feedbackAttachmentStr;
            }

            public String getUrls() {
                return urls;
            }

            public void setUrls(String urls) {
                this.urls = urls;
            }

            public int getFaultAmount() {
                return faultAmount;
            }

            public void setFaultAmount(int faultAmount) {
                this.faultAmount = faultAmount;
            }

            public int getConfirmAmount() {
                return confirmAmount;
            }

            public void setConfirmAmount(int confirmAmount) {
                this.confirmAmount = confirmAmount;
            }

            public List<ResourcesBean> getResources() {
                return resources;
            }

            public void setResources(List<ResourcesBean> resources) {
                this.resources = resources;
            }

            public static class CreateByBean implements Serializable {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * name : dongdong
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

            public static class FlowBean implements Serializable{
                /**
                 * id : f9f133f6d0294b9b8909ed2262b02c69
                 * isNewRecord : false
                 * processList : []
                 * orderProducts : []
                 * remaksList : []
                 */

                private String id;
                private boolean isNewRecord;
                private List<?> processList;
                private List<?> orderProducts;
                private List<?> remaksList;

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

                public List<?> getProcessList() {
                    return processList;
                }

                public void setProcessList(List<?> processList) {
                    this.processList = processList;
                }

                public List<?> getOrderProducts() {
                    return orderProducts;
                }

                public void setOrderProducts(List<?> orderProducts) {
                    this.orderProducts = orderProducts;
                }

                public List<?> getRemaksList() {
                    return remaksList;
                }

                public void setRemaksList(List<?> remaksList) {
                    this.remaksList = remaksList;
                }
            }

            public static class ProcessBean implements Serializable {
                /**
                 * id : dce551fbde2a46f5881fbc689e275f9e
                 * isNewRecord : false
                 * name : 发货
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 * positionNames : []
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;
                private List<?> positionNames;

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

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
                }

                public List<?> getRelPPList() {
                    return relPPList;
                }

                public void setRelPPList(List<?> relPPList) {
                    this.relPPList = relPPList;
                }

                public List<?> getProList() {
                    return proList;
                }

                public void setProList(List<?> proList) {
                    this.proList = proList;
                }

                public List<?> getPositionNames() {
                    return positionNames;
                }

                public void setPositionNames(List<?> positionNames) {
                    this.positionNames = positionNames;
                }
            }

            public static class FeedbackUserBean implements Serializable {
                /**
                 * id : 4856035c527b419a9cf70d856e65c93b
                 * isNewRecord : false
                 * name : dongdong
                 * loginFlag : 1
                 * roleList : []
                 * admin : false
                 * roleNames :
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private String loginFlag;
                private boolean admin;
                private String roleNames;
                private String photo;
                private List<?> roleList;

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
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

            public static class OrderProductBean implements Serializable{
                /**
                 * id : 5cc3df3070f84a83b3913912d5aa0be2
                 * isNewRecord : false
                 * order : {"isNewRecord":true,"sort":30,"bCompanyOrderOwnerUser":{"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"takeOrderTime":"2017-06-20","takeOrderTimeString":"2017-06-20","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
                 * companyCategory : {"isNewRecord":true,"name":"孙手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""}
                 * amount : 500
                 * orderProductStatus : 16
                 * orderProductStatusDesc : 待接受售后申请
                 * productName : 华为荣耀m
                 * orderProductSpecificationList : []
                 * htmlOrderProductSpecificationAttributes :
                 * companyBPriority : 3
                 * companyBPriorityDesc : 高度重视
                 * imageList : []
                 * innerDeliveryTime : 2017-06-23
                 * innerDeliveryTimeString : 2017-06-23
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * productSn : 102100633596
                 * urls :
                 * relFlowProcessList : []
                 */

                private String id;
                private boolean isNewRecord;
                private OrderBean order;
                private CompanyCategoryBean companyCategory;
                private String amount;
                private String orderProductStatus;
                private String orderProductStatusDesc;
                private String productName;
                private String htmlOrderProductSpecificationAttributes;
                private String companyBPriority;
                private String companyBPriorityDesc;
                private String innerDeliveryTime;
                private String innerDeliveryTimeString;
                private String productSn;
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

                public OrderBean getOrder() {
                    return order;
                }

                public void setOrder(OrderBean order) {
                    this.order = order;
                }

                public CompanyCategoryBean getCompanyCategory() {
                    return companyCategory;
                }

                public void setCompanyCategory(CompanyCategoryBean companyCategory) {
                    this.companyCategory = companyCategory;
                }

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
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

                public String getCompanyBPriority() {
                    return companyBPriority;
                }

                public void setCompanyBPriority(String companyBPriority) {
                    this.companyBPriority = companyBPriority;
                }

                public String getCompanyBPriorityDesc() {
                    return companyBPriorityDesc;
                }

                public void setCompanyBPriorityDesc(String companyBPriorityDesc) {
                    this.companyBPriorityDesc = companyBPriorityDesc;
                }

                public String getInnerDeliveryTime() {
                    return innerDeliveryTime;
                }

                public void setInnerDeliveryTime(String innerDeliveryTime) {
                    this.innerDeliveryTime = innerDeliveryTime;
                }

                public String getInnerDeliveryTimeString() {
                    return innerDeliveryTimeString;
                }

                public void setInnerDeliveryTimeString(String innerDeliveryTimeString) {
                    this.innerDeliveryTimeString = innerDeliveryTimeString;
                }

                public String getProductSn() {
                    return productSn;
                }

                public void setProductSn(String productSn) {
                    this.productSn = productSn;
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

                public static class OrderBean implements Serializable {
                    /**
                     * isNewRecord : true
                     * sort : 30
                     * bCompanyOrderOwnerUser : {"isNewRecord":true,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                     * takeOrderTime : 2017-06-20
                     * takeOrderTimeString : 2017-06-20
                     * delieverTimeString :
                     * orderProductList : []
                     * orderList : []
                     * historyOrderNumber : 0
                     * takeOrderTimeBeginString :
                     * takeOrderTimeEndString :
                     * parentId : 0
                     */

                    private boolean isNewRecord;
                    private int sort;
                    private BCompanyOrderOwnerUserBean bCompanyOrderOwnerUser;
                    private String takeOrderTime;
                    private String takeOrderTimeString;
                    private String delieverTimeString;
                    private int historyOrderNumber;
                    private String takeOrderTimeBeginString;
                    private String takeOrderTimeEndString;
                    private String parentId;
                    private List<?> orderProductList;
                    private List<?> orderList;

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

                    public BCompanyOrderOwnerUserBean getBCompanyOrderOwnerUser() {
                        return bCompanyOrderOwnerUser;
                    }

                    public void setBCompanyOrderOwnerUser(BCompanyOrderOwnerUserBean bCompanyOrderOwnerUser) {
                        this.bCompanyOrderOwnerUser = bCompanyOrderOwnerUser;
                    }

                    public String getTakeOrderTime() {
                        return takeOrderTime;
                    }

                    public void setTakeOrderTime(String takeOrderTime) {
                        this.takeOrderTime = takeOrderTime;
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

                    public static class BCompanyOrderOwnerUserBean implements Serializable {
                        /**
                         * isNewRecord : true
                         * name : 张三丰
                         * loginFlag : 1
                         * roleList : []
                         * admin : false
                         * roleNames :
                         */

                        private boolean isNewRecord;
                        private String name;
                        private String loginFlag;
                        private boolean admin;
                        private String roleNames;
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

                public static class CompanyCategoryBean implements Serializable {
                    /**
                     * isNewRecord : true
                     * name : 孙手机
                     * sort : 30
                     * size : 0
                     * categoryAttributeList : []
                     * relIndustryCompanyCategoryList : []
                     * attributeNames :
                     * parentName :
                     * parentId : 0
                     * attributeIds :
                     * industryCategoryIds :
                     * industryCategoryNames :
                     */

                    private boolean isNewRecord;
                    private String name;
                    private int sort;
                    private int size;
                    private String attributeNames;
                    private String parentName;
                    private String parentId;
                    private String attributeIds;
                    private String industryCategoryIds;
                    private String industryCategoryNames;
                    private List<?> categoryAttributeList;
                    private List<?> relIndustryCompanyCategoryList;

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

                    public String getParentName() {
                        return parentName;
                    }

                    public void setParentName(String parentName) {
                        this.parentName = parentName;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
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

            public static class ACompanyBean implements Serializable{
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
                private String shortName;
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

                public String getShortName() {
                    return shortName;
                }

                public void setShortName(String shortName) {
                    this.shortName = shortName;
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

            public static class ResourcesBean implements Serializable {
                /**
                 * id : b5c8188f33b348798097b8c19161a0f3
                 * isNewRecord : false
                 * resourceName : alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock
                 * resourceType : process_feedback
                 * resourceUrl : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg
                 * urlList : ["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_1eec9813fd0b79686052651c30f513a1.pictureunlock.jpg"]
                 * currentUrlList : []
                 */

                private String id;
                private boolean isNewRecord;
                private String resourceName;
                private String resourceType;
                private String resourceUrl;
                private List<String> urlList;
                private List<?> currentUrlList;

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

                public String getResourceName() {
                    return resourceName;
                }

                public void setResourceName(String resourceName) {
                    this.resourceName = resourceName;
                }

                public String getResourceType() {
                    return resourceType;
                }

                public void setResourceType(String resourceType) {
                    this.resourceType = resourceType;
                }

                public String getResourceUrl() {
                    return resourceUrl;
                }

                public void setResourceUrl(String resourceUrl) {
                    this.resourceUrl = resourceUrl;
                }

                public List<String> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<String> urlList) {
                    this.urlList = urlList;
                }

                public List<?> getCurrentUrlList() {
                    return currentUrlList;
                }

                public void setCurrentUrlList(List<?> currentUrlList) {
                    this.currentUrlList = currentUrlList;
                }
            }
        }
    }
}
