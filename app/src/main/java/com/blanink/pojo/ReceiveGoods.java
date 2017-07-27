package com.blanink.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 * 收货专用
 */
public class ReceiveGoods implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"total":1,"rows":[{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"remarks":"希望你能好好做","createDate":"2017-06-20 18:17:24","sort":30,"bCompany":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompanyOrderOwnerUser":{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"aOrderNumber":"100120001","orderStatus":"6","takeOrderTime":"2017-06-20","delieverTime":"2017-06-30","takeOrderTimeString":"2017-06-20","delieverTimeString":"2017-06-30","orderProductList":[{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"2500","amount":"1000","deliveryTime":"2017-06-30","orderProductStatus":"13","orderProductStatusDesc":"已确认收到部分货","productName":"华为荣耀","orderProductSpecificationList":[{"id":"2ef541b95e2b473d9c2ac2edbc539fba","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"fe05a9659fa847d580495cd81f6b4822","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"58","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:58    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"发货啦","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":1000,"latestFeedback":{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""},"processPriority":"1","status":"2","totalCompletedQuantity":100,"isPublic":"1","processFeedbackList":[{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"}]}]},{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"5000","amount":"500","deliveryTime":"2017-06-30","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"苹果手机","orderProductSpecificationList":[{"id":"c51d951fc9794b3ba02db20bac7eda02","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"4f79f27781be47a4ac299bae8b2c3e33","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"87","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:87    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"或 顶顶顶顶","flow":{"id":"9e0df473e91f45f48c2972e94fb252fc","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":500,"processPriority":"1","status":"2","isPublic":"1","processFeedbackList":[]}]}],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}]}
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

    public static class ResultBean implements Serializable {
        /**
         * total : 1
         * rows : [{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"remarks":"希望你能好好做","createDate":"2017-06-20 18:17:24","sort":30,"bCompany":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompanyOrderOwnerUser":{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"aOrderNumber":"100120001","orderStatus":"6","takeOrderTime":"2017-06-20","delieverTime":"2017-06-30","takeOrderTimeString":"2017-06-20","delieverTimeString":"2017-06-30","orderProductList":[{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"2500","amount":"1000","deliveryTime":"2017-06-30","orderProductStatus":"13","orderProductStatusDesc":"已确认收到部分货","productName":"华为荣耀","orderProductSpecificationList":[{"id":"2ef541b95e2b473d9c2ac2edbc539fba","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"fe05a9659fa847d580495cd81f6b4822","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"58","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:58    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"发货啦","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":1000,"latestFeedback":{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""},"processPriority":"1","status":"2","totalCompletedQuantity":100,"isPublic":"1","processFeedbackList":[{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"}]}]},{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"5000","amount":"500","deliveryTime":"2017-06-30","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"苹果手机","orderProductSpecificationList":[{"id":"c51d951fc9794b3ba02db20bac7eda02","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"4f79f27781be47a4ac299bae8b2c3e33","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"87","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:87    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"或 顶顶顶顶","flow":{"id":"9e0df473e91f45f48c2972e94fb252fc","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":500,"processPriority":"1","status":"2","isPublic":"1","processFeedbackList":[]}]}],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}]
         */

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

        public static class RowsBean implements Serializable {
            /**
             * id : 7e14c0f074db4232870369b66d583ad8
             * isNewRecord : false
             * remarks : 希望你能好好做
             * createDate : 2017-06-20 18:17:24
             * sort : 30
             * bCompany : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"name":"浙江总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * bCompanyOrderOwnerUser : {"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * aOrderNumber : 100120001
             * orderStatus : 6
             * takeOrderTime : 2017-06-20
             * delieverTime : 2017-06-30
             * takeOrderTimeString : 2017-06-20
             * delieverTimeString : 2017-06-30
             * orderProductList : [{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"2500","amount":"1000","deliveryTime":"2017-06-30","orderProductStatus":"13","orderProductStatusDesc":"已确认收到部分货","productName":"华为荣耀","orderProductSpecificationList":[{"id":"2ef541b95e2b473d9c2ac2edbc539fba","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"fe05a9659fa847d580495cd81f6b4822","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"58","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:58    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"发货啦","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":1000,"latestFeedback":{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""},"processPriority":"1","status":"2","totalCompletedQuantity":100,"isPublic":"1","processFeedbackList":[{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"}]}]},{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"order":{"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"5000","amount":"500","deliveryTime":"2017-06-30","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"苹果手机","orderProductSpecificationList":[{"id":"c51d951fc9794b3ba02db20bac7eda02","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"4f79f27781be47a4ac299bae8b2c3e33","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"87","hardCodeValueList":[]}],"htmlOrderProductSpecificationAttributes":"总量:哈哈    尺寸:87    ","deliveryTimeString":"2017-06-30","companyAPriority":"3","companyAPriorityDesc":"高度重视","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"source":"2","reviewFinish":"0","urls":"","relFlowProcessList":[{"isNewRecord":true,"remarks":"或 顶顶顶顶","flow":{"id":"9e0df473e91f45f48c2972e94fb252fc","isNewRecord":false,"orderProduct":{"id":"f51f5adcd4c14dbe8598efe3826f95ab","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":500,"processPriority":"1","status":"2","isPublic":"1","processFeedbackList":[]}]}]
             * orderList : []
             * historyOrderNumber : 0
             * takeOrderTimeBeginString :
             * takeOrderTimeEndString :
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private String createDate;
            private int sort;
            private BCompanyBean bCompany;
            private BCompanyOrderOwnerUserBean bCompanyOrderOwnerUser;
            private String aOrderNumber;
            private String orderStatus;
            private String takeOrderTime;
            private String delieverTime;
            private String takeOrderTimeString;
            private String delieverTimeString;
            private int historyOrderNumber;
            private String takeOrderTimeBeginString;
            private String takeOrderTimeEndString;
            private String parentId;
            private List<OrderProductListBean> orderProductList;
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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public BCompanyBean getBCompany() {
                return bCompany;
            }

            public void setBCompany(BCompanyBean bCompany) {
                this.bCompany = bCompany;
            }

            public BCompanyOrderOwnerUserBean getBCompanyOrderOwnerUser() {
                return bCompanyOrderOwnerUser;
            }

            public void setBCompanyOrderOwnerUser(BCompanyOrderOwnerUserBean bCompanyOrderOwnerUser) {
                this.bCompanyOrderOwnerUser = bCompanyOrderOwnerUser;
            }

            public String getAOrderNumber() {
                return aOrderNumber;
            }

            public void setAOrderNumber(String aOrderNumber) {
                this.aOrderNumber = aOrderNumber;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getTakeOrderTime() {
                return takeOrderTime;
            }

            public void setTakeOrderTime(String takeOrderTime) {
                this.takeOrderTime = takeOrderTime;
            }

            public String getDelieverTime() {
                return delieverTime;
            }

            public void setDelieverTime(String delieverTime) {
                this.delieverTime = delieverTime;
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

            public List<OrderProductListBean> getOrderProductList() {
                return orderProductList;
            }

            public void setOrderProductList(List<OrderProductListBean> orderProductList) {
                this.orderProductList = orderProductList;
            }

            public List<?> getOrderList() {
                return orderList;
            }

            public void setOrderList(List<?> orderList) {
                this.orderList = orderList;
            }

            public static class BCompanyBean implements Serializable {
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
                 * photo : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_75303.pictureunlock
                 * roleList : []
                 * grossProfit : 0
                 * pType :
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

            public static class BCompanyOrderOwnerUserBean implements Serializable {
                /**
                 * id : 8bb75d847a564d29bc2c1cb368fd3af0
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

            public static class OrderProductListBean implements Serializable {
                /**
                 * id : 3bf348feb52c4b4ea3c3106eec87fea9
                 * isNewRecord : false
                 * order : {"id":"7e14c0f074db4232870369b66d583ad8","isNewRecord":false,"sort":30,"takeOrderTimeString":"","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
                 * companyCategory : {"isNewRecord":true,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentName":"","parentId":"0","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""}
                 * price : 2500
                 * amount : 1000
                 * deliveryTime : 2017-06-30
                 * orderProductStatus : 13
                 * orderProductStatusDesc : 已确认收到部分货
                 * productName : 华为荣耀
                 * orderProductSpecificationList : [{"id":"2ef541b95e2b473d9c2ac2edbc539fba","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"},"attributeValue":"哈哈","hardCodeValueList":[]},{"id":"fe05a9659fa847d580495cd81f6b4822","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"attribute":{"id":"db14779d29c9436db4b766a649e00a51","isNewRecord":false,"name":"尺寸","sort":30,"public":false,"parentId":"0"},"attributeValue":"58","hardCodeValueList":[]}]
                 * htmlOrderProductSpecificationAttributes : 总量:哈哈    尺寸:58    
                 * deliveryTimeString : 2017-06-30
                 * companyAPriority : 3
                 * companyAPriorityDesc : 高度重视
                 * imageList : []
                 * flowRemarkList : []
                 * processFeedbackList : []
                 * processWorkerList : []
                 * workPlanList : []
                 * source : 2
                 * reviewFinish : 0
                 * urls :
                 * relFlowProcessList : [{"isNewRecord":true,"remarks":"发货啦","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":1000,"latestFeedback":{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""},"processPriority":"1","status":"2","totalCompletedQuantity":100,"isPublic":"1","processFeedbackList":[{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"}]}]
                 */

                private String id;
                private boolean isNewRecord;
                private OrderBean order;
                private CompanyCategoryBean companyCategory;
                private String price;
                private String amount;
                private String deliveryTime;
                private String orderProductStatus;
                private String orderProductStatusDesc;
                private String productName;
                private String htmlOrderProductSpecificationAttributes;
                private String deliveryTimeString;
                private String companyAPriority;
                private String companyAPriorityDesc;
                private String source;
                private String reviewFinish;
                private String urls;
                private List<OrderProductSpecificationListBean> orderProductSpecificationList;
                private List<?> imageList;
                private List<?> flowRemarkList;
                private List<?> processFeedbackList;
                private List<?> processWorkerList;
                private List<?> workPlanList;
                private List<RelFlowProcessListBean> relFlowProcessList;

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

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getReviewFinish() {
                    return reviewFinish;
                }

                public void setReviewFinish(String reviewFinish) {
                    this.reviewFinish = reviewFinish;
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

                public List<RelFlowProcessListBean> getRelFlowProcessList() {
                    return relFlowProcessList;
                }

                public void setRelFlowProcessList(List<RelFlowProcessListBean> relFlowProcessList) {
                    this.relFlowProcessList = relFlowProcessList;
                }

                public static class OrderBean implements Serializable {
                    /**
                     * id : 7e14c0f074db4232870369b66d583ad8
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

                public static class CompanyCategoryBean implements Serializable {
                    /**
                     * isNewRecord : true
                     * name : 浙江公司手机
                     * sort : 30
                     * size : 0
                     * categoryAttributeList : []
                     * relIndustryCompanyCategoryList : []
                     * attributeNames :
                     * parentName :
                     * parentId : 0
                     * industryCategoryIds :
                     * industryCategoryNames :
                     * attributeIds :
                     */

                    private boolean isNewRecord;
                    private String name;
                    private int sort;
                    private int size;
                    private String attributeNames;
                    private String parentName;
                    private String parentId;
                    private String industryCategoryIds;
                    private String industryCategoryNames;
                    private String attributeIds;
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

                    public String getAttributeIds() {
                        return attributeIds;
                    }

                    public void setAttributeIds(String attributeIds) {
                        this.attributeIds = attributeIds;
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

                public static class OrderProductSpecificationListBean implements Serializable {
                    /**
                     * id : 2ef541b95e2b473d9c2ac2edbc539fba
                     * isNewRecord : false
                     * orderProduct : {"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]}
                     * attribute : {"id":"3b38822579eb4e2dbcd20f1d5cc22e5d","isNewRecord":false,"name":"总量","sort":30,"public":false,"parentId":"0"}
                     * attributeValue : 哈哈
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

                    public static class OrderProductBean implements Serializable {
                        /**
                         * id : 3bf348feb52c4b4ea3c3106eec87fea9
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

                    public static class AttributeBean implements Serializable {
                        /**
                         * id : 3b38822579eb4e2dbcd20f1d5cc22e5d
                         * isNewRecord : false
                         * name : 总量
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

                public static class RelFlowProcessListBean {
                    /**
                     * isNewRecord : true
                     * remarks : 发货啦
                     * flow : {"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"orderProduct":{"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]},"processList":[],"orderProducts":[],"remaksList":[]}
                     * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"type":"3","feedbackType":"1","relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
                     * target : 1000
                     * latestFeedback : {"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"","urls":""}
                     * processPriority : 1
                     * status : 2
                     * totalCompletedQuantity : 100
                     * isPublic : 1
                     * processFeedbackList : [{"id":"ee9e9f53fe7b4388bf03e1e551329129","isNewRecord":false,"remarks":"总任务量1000,已完成100,李四","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-20 21:04:21","updateDate":"2017-06-20 21:04:21","flow":{"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"isFinished":"0","achieveAmount":100,"resources":[{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"}]
                     */

                    private boolean isNewRecord;
                    private String remarks;
                    private FlowBean flow;
                    private ProcessBean process;
                    private int target;
                    private LatestFeedbackBean latestFeedback;
                    private String processPriority;
                    private String status;
                    private int totalCompletedQuantity;
                    private String isPublic;
                    private List<ProcessFeedbackListBean> processFeedbackList;

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

                    public int getTarget() {
                        return target;
                    }

                    public void setTarget(int target) {
                        this.target = target;
                    }

                    public LatestFeedbackBean getLatestFeedback() {
                        return latestFeedback;
                    }

                    public void setLatestFeedback(LatestFeedbackBean latestFeedback) {
                        this.latestFeedback = latestFeedback;
                    }

                    public String getProcessPriority() {
                        return processPriority;
                    }

                    public void setProcessPriority(String processPriority) {
                        this.processPriority = processPriority;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public int getTotalCompletedQuantity() {
                        return totalCompletedQuantity;
                    }

                    public void setTotalCompletedQuantity(int totalCompletedQuantity) {
                        this.totalCompletedQuantity = totalCompletedQuantity;
                    }

                    public String getIsPublic() {
                        return isPublic;
                    }

                    public void setIsPublic(String isPublic) {
                        this.isPublic = isPublic;
                    }

                    public List<ProcessFeedbackListBean> getProcessFeedbackList() {
                        return processFeedbackList;
                    }

                    public void setProcessFeedbackList(List<ProcessFeedbackListBean> processFeedbackList) {
                        this.processFeedbackList = processFeedbackList;
                    }

                    public static class FlowBean {
                        /**
                         * id : 5b1c8224ffd442b0baeaa5632f78b5f9
                         * isNewRecord : false
                         * orderProduct : {"id":"3bf348feb52c4b4ea3c3106eec87fea9","isNewRecord":false,"orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","imageList":[],"flowRemarkList":[],"processFeedbackList":[],"processWorkerList":[],"workPlanList":[],"urls":"","relFlowProcessList":[]}
                         * processList : []
                         * orderProducts : []
                         * remaksList : []
                         */

                        private String id;
                        private boolean isNewRecord;
                        private OrderProductBeanX orderProduct;
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

                        public OrderProductBeanX getOrderProduct() {
                            return orderProduct;
                        }

                        public void setOrderProduct(OrderProductBeanX orderProduct) {
                            this.orderProduct = orderProduct;
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

                        public static class OrderProductBeanX {
                            /**
                             * id : 3bf348feb52c4b4ea3c3106eec87fea9
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
                    }

                    public static class ProcessBean {
                        /**
                         * id : 1a9090dd4dbe4808a921900d7b64db01
                         * isNewRecord : false
                         * name : 发货
                         * sort : 30
                         * type : 3
                         * feedbackType : 1
                         * relPPList : []
                         * proList : []
                         * parentId : 0
                         * positionNames : []
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String name;
                        private int sort;
                        private String type;
                        private String feedbackType;
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

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public String getFeedbackType() {
                            return feedbackType;
                        }

                        public void setFeedbackType(String feedbackType) {
                            this.feedbackType = feedbackType;
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

                    public static class LatestFeedbackBean {
                        /**
                         * id : ee9e9f53fe7b4388bf03e1e551329129
                         * isNewRecord : false
                         * remarks : 总任务量1000,已完成100,李四
                         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                         * createDate : 2017-06-20 21:04:21
                         * updateDate : 2017-06-20 21:04:21
                         * flow : {"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
                         * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
                         * isFinished : 0
                         * achieveAmount : 100
                         * resources : []
                         * feedbackUser : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                         * target : 0
                         * feedbackAttachmentStr :
                         * urls :
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String remarks;
                        private CreateByBean createBy;
                        private String createDate;
                        private String updateDate;
                        private FlowBeanX flow;
                        private ProcessBeanX process;
                        private String isFinished;
                        private int achieveAmount;
                        private FeedbackUserBean feedbackUser;
                        private int target;
                        private String feedbackAttachmentStr;
                        private String urls;
                        private List<?> resources;

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

                        public FlowBeanX getFlow() {
                            return flow;
                        }

                        public void setFlow(FlowBeanX flow) {
                            this.flow = flow;
                        }

                        public ProcessBeanX getProcess() {
                            return process;
                        }

                        public void setProcess(ProcessBeanX process) {
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

                        public int getTarget() {
                            return target;
                        }

                        public void setTarget(int target) {
                            this.target = target;
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

                        public List<?> getResources() {
                            return resources;
                        }

                        public void setResources(List<?> resources) {
                            this.resources = resources;
                        }

                        public static class CreateByBean {
                            /**
                             * id : 447e4526d22045f59ed58250046b3842
                             * isNewRecord : false
                             * name : 李四
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

                        public static class FlowBeanX {
                            /**
                             * id : 5b1c8224ffd442b0baeaa5632f78b5f9
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

                        public static class ProcessBeanX {
                            /**
                             * id : 1a9090dd4dbe4808a921900d7b64db01
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

                        public static class FeedbackUserBean {
                            /**
                             * id : 447e4526d22045f59ed58250046b3842
                             * isNewRecord : false
                             * name : 李四
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
                    }

                    public static class ProcessFeedbackListBean {
                        /**
                         * id : ee9e9f53fe7b4388bf03e1e551329129
                         * isNewRecord : false
                         * remarks : 总任务量1000,已完成100,李四
                         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                         * createDate : 2017-06-20 21:04:21
                         * updateDate : 2017-06-20 21:04:21
                         * flow : {"id":"5b1c8224ffd442b0baeaa5632f78b5f9","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
                         * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
                         * isFinished : 0
                         * achieveAmount : 100
                         * resources : [{"id":"3243571b125b4771960006adf62a57ee","isNewRecord":false,"resourceName":"alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"],"currentUrlList":[]}]
                         * feedbackUser : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                         * target : 0
                         * feedbackAttachmentStr : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock
                         * urls : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String remarks;
                        private CreateByBeanX createBy;
                        private String createDate;
                        private String updateDate;
                        private FlowBeanXX flow;
                        private ProcessBeanXX process;
                        private String isFinished;
                        private int achieveAmount;
                        private FeedbackUserBeanX feedbackUser;
                        private int target;
                        private String feedbackAttachmentStr;
                        private String urls;
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

                        public FlowBeanXX getFlow() {
                            return flow;
                        }

                        public void setFlow(FlowBeanXX flow) {
                            this.flow = flow;
                        }

                        public ProcessBeanXX getProcess() {
                            return process;
                        }

                        public void setProcess(ProcessBeanXX process) {
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

                        public FeedbackUserBeanX getFeedbackUser() {
                            return feedbackUser;
                        }

                        public void setFeedbackUser(FeedbackUserBeanX feedbackUser) {
                            this.feedbackUser = feedbackUser;
                        }

                        public int getTarget() {
                            return target;
                        }

                        public void setTarget(int target) {
                            this.target = target;
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

                        public List<ResourcesBean> getResources() {
                            return resources;
                        }

                        public void setResources(List<ResourcesBean> resources) {
                            this.resources = resources;
                        }

                        public static class CreateByBeanX {
                            /**
                             * id : 447e4526d22045f59ed58250046b3842
                             * isNewRecord : false
                             * name : 李四
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

                        public static class FlowBeanXX {
                            /**
                             * id : 5b1c8224ffd442b0baeaa5632f78b5f9
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

                        public static class ProcessBeanXX {
                            /**
                             * id : 1a9090dd4dbe4808a921900d7b64db01
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

                        public static class FeedbackUserBeanX {
                            /**
                             * id : 447e4526d22045f59ed58250046b3842
                             * isNewRecord : false
                             * name : 李四
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

                        public static class ResourcesBean {
                            /**
                             * id : 3243571b125b4771960006adf62a57ee
                             * isNewRecord : false
                             * resourceName : alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d
                             * resourceType : process_feedback
                             * resourceUrl : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock|http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock
                             * urlList : ["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_2cb7851e1989b2a045038528a9be010c.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c39eb0d617a9672b67e02fd9651b3389.pictureunlock","http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_c218f47db8a070edfed40eb77bcbf45d.pictureunlock"]
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
        }
    }
}
