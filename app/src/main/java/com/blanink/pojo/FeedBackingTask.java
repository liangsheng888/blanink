package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10.
 * 我反馈过的摸个产品的所有信息
 */


public class FeedBackingTask implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : {"id":"62299d624a294b0787e52a4f8cec3f25","isNewRecord":false,"remarks":"兔崽子我","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-06 15:47:35","updateDate":"2017-06-14 13:50:42","order":{"id":"1c91eb51f65640888e13f8562d28792b","isNewRecord":false,"sort":30,"takeOrderTime":"2017-06-06","takeOrderTimeString":"2017-06-06","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"},"companyCategory":{"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""},"price":"8899","amount":"888999","productDescription":"兔崽子我","isAConfirm":"1","aConfirmTime":"2017-06-08","deliveryTime":"2017-06-06","orderProductType":"1","orderProductStatus":"9","orderProductStatusDesc":"流程已发布","productName":"兔崽子我4555","orderProductSpecificationList":[],"htmlOrderProductSpecificationAttributes":"","deliveryTimeString":"2017-06-06","companyAPriority":"0","companyAPriorityDesc":"","companyBPriority":"0","companyBPriorityDesc":"","imageList":[],"innerDeliveryTime":"2017-06-06","innerDeliveryTimeString":"2017-06-06","relFlowProcess":{"isNewRecord":true,"flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":888999,"processPriority":"2","status":"2"},"allFinishedAmount":100,"flowRemarkList":[],"processFeedbackList":[{"id":"9bd1673ca1e849d8ac7a318a62cb03ad","isNewRecord":false,"remarks":"恶魔咯无头无尾xxl","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-16 09:21:10","updateDate":"2017-06-16 09:21:10","flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"faultAmount":1,"isFinished":"0","achieveAmount":100,"resources":[{"id":"3a1365c2159f442798e8206945a9c048","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"],"currentUrlList":[]},{"id":"4ebdc8011c704c0b91d7306dfa901d18","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock"],"currentUrlList":[]},{"id":"fe372e045d674250b49c13fad8a00759","isNewRecord":false,"resourceName":"alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"}],"processWorkerList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"company":{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"ahadmin","no":"001","name":"安徽公司管理员","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"ffe38b7074f84c90a6fef16a0456ebb8","isNewRecord":false,"company":{"id":"dfe9a7555b754027bcac1dc57a623508","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"dfe9a7555b754027bcac1dc57a623508","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"hebei","no":"21321","name":"河北老大","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"036af10af69f41c49ad76b9b9f48b3bc","isNewRecord":false,"company":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"bjadminz","no":"009","name":"北京管理员","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"zjadmin","no":"1000001","name":"李四","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"jsadmin","no":"1000001","name":"张三","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"sendUserList":[{"id":"036af10af69f41c49ad76b9b9f48b3bc","isNewRecord":false,"loginName":"bjadminz","name":"北京管理员","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"64c155d1a3334246b6f96ca2dedf8ce4","isNewRecord":false,"loginName":"beizong","name":"北总经理","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"b1c01269fd314a66babc965fc1c17ce2","isNewRecord":false,"loginName":"bjmanager","name":"大神","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginName":"bjadmin","name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"workPlanList":[],"companyA":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"companyBOwner":{"isNewRecord":true,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"productSn":"123356666","source":"2","aCompany":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"bCompany":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"urls":"","aconfirmTime":"2017-06-08 23:17:42"}
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
         * id : 62299d624a294b0787e52a4f8cec3f25
         * isNewRecord : false
         * remarks : 兔崽子我
         * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2017-06-06 15:47:35
         * updateDate : 2017-06-14 13:50:42
         * order : {"id":"1c91eb51f65640888e13f8562d28792b","isNewRecord":false,"sort":30,"takeOrderTime":"2017-06-06","takeOrderTimeString":"2017-06-06","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"takeOrderTimeBeginString":"","takeOrderTimeEndString":"","parentId":"0"}
         * companyCategory : {"id":"e1cd97176f354f6f8933443cdef9933f","isNewRecord":false,"name":"浙江公司手机","sort":30,"size":0,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","industryCategoryIds":"","industryCategoryNames":"","attributeIds":""}
         * price : 8899
         * amount : 888999
         * productDescription : 兔崽子我
         * isAConfirm : 1
         * aConfirmTime : 2017-06-08
         * deliveryTime : 2017-06-06
         * orderProductType : 1
         * orderProductStatus : 9
         * orderProductStatusDesc : 流程已发布
         * productName : 兔崽子我4555
         * orderProductSpecificationList : []
         * htmlOrderProductSpecificationAttributes :
         * deliveryTimeString : 2017-06-06
         * companyAPriority : 0
         * companyAPriorityDesc :
         * companyBPriority : 0
         * companyBPriorityDesc :
         * imageList : []
         * innerDeliveryTime : 2017-06-06
         * innerDeliveryTimeString : 2017-06-06
         * relFlowProcess : {"isNewRecord":true,"flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"target":888999,"processPriority":"2","status":"2"}
         * allFinishedAmount : 100
         * flowRemarkList : []
         * processFeedbackList : [{"id":"9bd1673ca1e849d8ac7a318a62cb03ad","isNewRecord":false,"remarks":"恶魔咯无头无尾xxl","createBy":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-06-16 09:21:10","updateDate":"2017-06-16 09:21:10","flow":{"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]},"process":{"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]},"faultAmount":1,"isFinished":"0","achieveAmount":100,"resources":[{"id":"3a1365c2159f442798e8206945a9c048","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"],"currentUrlList":[]},{"id":"4ebdc8011c704c0b91d7306dfa901d18","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock"],"currentUrlList":[]},{"id":"fe372e045d674250b49c13fad8a00759","isNewRecord":false,"resourceName":"alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"],"currentUrlList":[]}],"feedbackUser":{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"feedbackAttachmentStr":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urls":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"}]
         * processWorkerList : [{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"company":{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"ahadmin","no":"001","name":"安徽公司管理员","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"ffe38b7074f84c90a6fef16a0456ebb8","isNewRecord":false,"company":{"id":"dfe9a7555b754027bcac1dc57a623508","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"dfe9a7555b754027bcac1dc57a623508","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"hebei","no":"21321","name":"河北老大","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"036af10af69f41c49ad76b9b9f48b3bc","isNewRecord":false,"company":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"bjadminz","no":"009","name":"北京管理员","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"company":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"zjadmin","no":"1000001","name":"李四","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"},"loginName":"jsadmin","no":"1000001","name":"张三","userType":"1","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
         * sendUserList : [{"id":"036af10af69f41c49ad76b9b9f48b3bc","isNewRecord":false,"loginName":"bjadminz","name":"北京管理员","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"64c155d1a3334246b6f96ca2dedf8ce4","isNewRecord":false,"loginName":"beizong","name":"北总经理","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"b1c01269fd314a66babc965fc1c17ce2","isNewRecord":false,"loginName":"bjmanager","name":"大神","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"loginName":"bjadmin","name":"王五","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
         * workPlanList : []
         * companyA : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"name":"北京总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * companyBOwner : {"isNewRecord":true,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * productSn : 123356666
         * source : 2
         * aCompany : {"id":"9ce7467e94884e7192a14ad3c29c554d","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * bCompany : {"id":"7c10ee5fadd044e68f2b29f8a01d3f9a","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
         * urls :
         * aconfirmTime : 2017-06-08 23:17:42
         */

        private String id;
        private boolean isNewRecord;
        private String remarks;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private OrderBean order;
        private CompanyCategoryBean companyCategory;
        private String price;
        private String amount;
        private String productDescription;
        private String isAConfirm;
        private String aConfirmTime;
        private String deliveryTime;
        private String orderProductType;
        private String orderProductStatus;
        private String orderProductStatusDesc;
        private String productName;
        private String htmlOrderProductSpecificationAttributes;
        private String deliveryTimeString;
        private String companyAPriority;
        private String companyAPriorityDesc;
        private String companyBPriority;
        private String companyBPriorityDesc;
        private String innerDeliveryTime;
        private String innerDeliveryTimeString;
        private RelFlowProcessBean relFlowProcess;
        private int allFinishedAmount;
        private CompanyABean companyA;
        private CompanyBOwnerBean companyBOwner;
        private String productSn;
        private String source;
        private ACompanyBean aCompany;
        private BCompanyBean bCompany;
        private String urls;
        private String aconfirmTime;
        private List<?> orderProductSpecificationList;
        private List<?> imageList;
        private List<?> flowRemarkList;
        private List<ProcessFeedbackListBean> processFeedbackList;
        private List<ProcessWorkerListBean> processWorkerList;
        private List<SendUserListBean> sendUserList;
        private List<?> workPlanList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", order=" + order +
                    ", companyCategory=" + companyCategory +
                    ", price='" + price + '\'' +
                    ", amount='" + amount + '\'' +
                    ", productDescription='" + productDescription + '\'' +
                    ", isAConfirm='" + isAConfirm + '\'' +
                    ", aConfirmTime='" + aConfirmTime + '\'' +
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", orderProductType='" + orderProductType + '\'' +
                    ", orderProductStatus='" + orderProductStatus + '\'' +
                    ", orderProductStatusDesc='" + orderProductStatusDesc + '\'' +
                    ", productName='" + productName + '\'' +
                    ", htmlOrderProductSpecificationAttributes='" + htmlOrderProductSpecificationAttributes + '\'' +
                    ", deliveryTimeString='" + deliveryTimeString + '\'' +
                    ", companyAPriority='" + companyAPriority + '\'' +
                    ", companyAPriorityDesc='" + companyAPriorityDesc + '\'' +
                    ", companyBPriority='" + companyBPriority + '\'' +
                    ", companyBPriorityDesc='" + companyBPriorityDesc + '\'' +
                    ", innerDeliveryTime='" + innerDeliveryTime + '\'' +
                    ", innerDeliveryTimeString='" + innerDeliveryTimeString + '\'' +
                    ", relFlowProcess=" + relFlowProcess +
                    ", allFinishedAmount=" + allFinishedAmount +
                    ", companyA=" + companyA +
                    ", companyBOwner=" + companyBOwner +
                    ", productSn='" + productSn + '\'' +
                    ", source='" + source + '\'' +
                    ", aCompany=" + aCompany +
                    ", bCompany=" + bCompany +
                    ", urls='" + urls + '\'' +
                    ", aconfirmTime='" + aconfirmTime + '\'' +
                    ", orderProductSpecificationList=" + orderProductSpecificationList +
                    ", imageList=" + imageList +
                    ", flowRemarkList=" + flowRemarkList +
                    ", processFeedbackList=" + processFeedbackList +
                    ", processWorkerList=" + processWorkerList +
                    ", sendUserList=" + sendUserList +
                    ", workPlanList=" + workPlanList +
                    '}';
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

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getIsAConfirm() {
            return isAConfirm;
        }

        public void setIsAConfirm(String isAConfirm) {
            this.isAConfirm = isAConfirm;
        }

        public String getAConfirmTime() {
            return aConfirmTime;
        }

        public void setAConfirmTime(String aConfirmTime) {
            this.aConfirmTime = aConfirmTime;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getOrderProductType() {
            return orderProductType;
        }

        public void setOrderProductType(String orderProductType) {
            this.orderProductType = orderProductType;
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

        public RelFlowProcessBean getRelFlowProcess() {
            return relFlowProcess;
        }

        public void setRelFlowProcess(RelFlowProcessBean relFlowProcess) {
            this.relFlowProcess = relFlowProcess;
        }

        public int getAllFinishedAmount() {
            return allFinishedAmount;
        }

        public void setAllFinishedAmount(int allFinishedAmount) {
            this.allFinishedAmount = allFinishedAmount;
        }

        public CompanyABean getCompanyA() {
            return companyA;
        }

        public void setCompanyA(CompanyABean companyA) {
            this.companyA = companyA;
        }

        public CompanyBOwnerBean getCompanyBOwner() {
            return companyBOwner;
        }

        public void setCompanyBOwner(CompanyBOwnerBean companyBOwner) {
            this.companyBOwner = companyBOwner;
        }

        public String getProductSn() {
            return productSn;
        }

        public void setProductSn(String productSn) {
            this.productSn = productSn;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public String getAconfirmTime() {
            return aconfirmTime;
        }

        public void setAconfirmTime(String aconfirmTime) {
            this.aconfirmTime = aconfirmTime;
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

        public List<ProcessFeedbackListBean> getProcessFeedbackList() {
            return processFeedbackList;
        }

        public void setProcessFeedbackList(List<ProcessFeedbackListBean> processFeedbackList) {
            this.processFeedbackList = processFeedbackList;
        }

        public List<ProcessWorkerListBean> getProcessWorkerList() {
            return processWorkerList;
        }

        public void setProcessWorkerList(List<ProcessWorkerListBean> processWorkerList) {
            this.processWorkerList = processWorkerList;
        }

        public List<SendUserListBean> getSendUserList() {
            return sendUserList;
        }

        public void setSendUserList(List<SendUserListBean> sendUserList) {
            this.sendUserList = sendUserList;
        }

        public List<?> getWorkPlanList() {
            return workPlanList;
        }

        public void setWorkPlanList(List<?> workPlanList) {
            this.workPlanList = workPlanList;
        }

        public static class CreateByBean implements Serializable {
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

        public static class OrderBean implements Serializable {
            /**
             * id : 1c91eb51f65640888e13f8562d28792b
             * isNewRecord : false
             * sort : 30
             * takeOrderTime : 2017-06-06
             * takeOrderTimeString : 2017-06-06
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
            private String takeOrderTime;
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
        }

        public static class CompanyCategoryBean implements Serializable {
            /**
             * id : e1cd97176f354f6f8933443cdef9933f
             * isNewRecord : false
             * name : 浙江公司手机
             * sort : 30
             * size : 0
             * categoryAttributeList : []
             * relIndustryCompanyCategoryList : []
             * attributeNames :
             * parentId : 0
             * parentName :
             * industryCategoryIds :
             * industryCategoryNames :
             * attributeIds :
             */

            private String id;
            private boolean isNewRecord;
            private String name;
            private int sort;
            private int size;
            private String attributeNames;
            private String parentId;
            private String parentName;
            private String industryCategoryIds;
            private String industryCategoryNames;
            private String attributeIds;
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

        public static class RelFlowProcessBean implements Serializable {
            /**
             * isNewRecord : true
             * flow : {"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
             * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
             * target : 888999
             * processPriority : 2
             * status : 2
             */

            private boolean isNewRecord;
            private FlowBean flow;
            private ProcessBean process;
            private int target;
            private String processPriority;
            private String status;

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
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

            public static class FlowBean implements Serializable{
                /**
                 * id : 2695060d06604c7e98f007e06592d22b
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
                 * id : 1a9090dd4dbe4808a921900d7b64db01
                 * isNewRecord : false
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 * positionNames : []
                 */

                private String id;
                private boolean isNewRecord;
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
        }

        public static class CompanyABean implements Serializable {
            /**
             * id : 9ce7467e94884e7192a14ad3c29c554d
             * isNewRecord : false
             * name : 北京总公司
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

        public static class CompanyBOwnerBean  implements Serializable{
            /**
             * isNewRecord : true
             * name : 李四
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

        public static class ACompanyBean implements Serializable {
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

        public static class BCompanyBean implements Serializable {
            /**
             * id : 7c10ee5fadd044e68f2b29f8a01d3f9a
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

        public static class ProcessFeedbackListBean implements Serializable {
            /**
             * id : 9bd1673ca1e849d8ac7a318a62cb03ad
             * isNewRecord : false
             * remarks : 恶魔咯无头无尾xxl
             * createBy : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-06-16 09:21:10
             * updateDate : 2017-06-16 09:21:10
             * flow : {"id":"2695060d06604c7e98f007e06592d22b","isNewRecord":false,"processList":[],"orderProducts":[],"remaksList":[]}
             * process : {"id":"1a9090dd4dbe4808a921900d7b64db01","isNewRecord":false,"name":"发货","sort":30,"relPPList":[],"proList":[],"parentId":"0","positionNames":[]}
             * faultAmount : 1
             * isFinished : 0
             * achieveAmount : 100
             * resources : [{"id":"3a1365c2159f442798e8206945a9c048","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"],"currentUrlList":[]},{"id":"4ebdc8011c704c0b91d7306dfa901d18","isNewRecord":false,"resourceName":"alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock"],"currentUrlList":[]},{"id":"fe372e045d674250b49c13fad8a00759","isNewRecord":false,"resourceName":"alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc","resourceType":"process_feedback","resourceUrl":"http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock","urlList":["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock"],"currentUrlList":[]}]
             * feedbackUser : {"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"name":"李四","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * target : 0
             * feedbackAttachmentStr : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock
             * urls : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fn12RQxh7tDBLH_ehMsVqlXau43Z.pictureunlock,http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_FpQDnZ-Rg4rA3prPAsWniAp_z4Jc.pictureunlock
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanX createBy;
            private String createDate;
            private String updateDate;
            private FlowBeanX flow;
            private ProcessBeanX process;
            private int faultAmount;
            private String isFinished;
            private int achieveAmount;
            private FeedbackUserBean feedbackUser;
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

            public int getFaultAmount() {
                return faultAmount;
            }

            public void setFaultAmount(int faultAmount) {
                this.faultAmount = faultAmount;
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

            public static class FlowBeanX {
                /**
                 * id : 2695060d06604c7e98f007e06592d22b
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

            public static class ResourcesBean {
                /**
                 * id : 3a1365c2159f442798e8206945a9c048
                 * isNewRecord : false
                 * resourceName : alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK
                 * resourceType : process_feedback
                 * resourceUrl : http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock
                 * urlList : ["http://blanink.oss-cn-hangzhou.aliyuncs.com/alioss_PictureUnlock_Fo_DFtBc5STIwbWtXZF_Vt25V5YK.pictureunlock"]
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

        public static class ProcessWorkerListBean implements Serializable {
            /**
             * id : cd7bcbfd6fc84f49a7ec908e93093432
             * isNewRecord : false
             * company : {"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * office : {"id":"0713118213ac47069ef6e0f41da4476c","isNewRecord":false,"sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"photo":"","roleList":[],"grossProfit":0,"pType":"","parentId":"0"}
             * loginName : ahadmin
             * no : 001
             * name : 安徽公司管理员
             * userType : 1
             * loginFlag : 1
             * roleList : []
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
            private CompanyBean company;
            private OfficeBean office;
            private String loginName;
            private String no;
            private String name;
            private String userType;
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

            public CompanyBean getCompany() {
                return company;
            }

            public void setCompany(CompanyBean company) {
                this.company = company;
            }

            public OfficeBean getOffice() {
                return office;
            }

            public void setOffice(OfficeBean office) {
                this.office = office;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
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

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
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

            public static class CompanyBean implements Serializable {
                /**
                 * id : 0713118213ac47069ef6e0f41da4476c
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

            public static class OfficeBean implements Serializable {
                /**
                 * id : 0713118213ac47069ef6e0f41da4476c
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
        }

        public static class SendUserListBean implements Serializable {
            /**
             * id : 036af10af69f41c49ad76b9b9f48b3bc
             * isNewRecord : false
             * loginName : bjadminz
             * name : 北京管理员
             * loginFlag : 1
             * roleList : []
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
            private String loginName;
            private String name;
            private String loginFlag;
            private boolean admin;
            private String roleNames;
            private List<?> roleList;

            @Override
            public String toString() {
                return "SendUserListBean{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", loginName='" + loginName + '\'' +
                        ", name='" + name + '\'' +
                        ", loginFlag='" + loginFlag + '\'' +
                        ", admin=" + admin +
                        ", roleNames='" + roleNames + '\'' +
                        ", roleList=" + roleList +
                        '}';
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

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
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
}
