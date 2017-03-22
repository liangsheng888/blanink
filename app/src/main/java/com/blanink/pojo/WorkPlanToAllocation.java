package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */

public class WorkPlanToAllocation implements Serializable {

    private String errorCode;
    private String reason;
    private ResultBean result;

    @Override
    public String toString() {
        return "WorkPlanToAllocation{" +
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * id : 0082c7d7b13d49be9cb1bd27103f528a
         * isNewRecord : false
         * createBy : {"id":"ae5db71c02d94d6ba5f994319391fcf1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * createDate : 2016-12-06 15:10:03
         * updateDate : 2016-12-06 15:10:03
         * order : {"id":"01302d67478f4027b5aac0225eb1f00a","isNewRecord":false,"sort":30,"takeOrderTime":"2016-12-21","takeOrderTimeString":"2016-12-21","delieverTimeString":"","orderProductList":[],"orderList":[],"historyOrderNumber":0,"parentId":"0"}
         * companyCategory : {"id":"a09ca24a9cbc4e2783ab22061a6e6062","isNewRecord":false,"name":"奥迪","sort":30,"categoryAttributeList":[],"relIndustryCompanyCategoryList":[],"attributeNames":"","parentId":"0","parentName":"","attributeIds":"","industryCategoryIds":"","industryCategoryNames":""}
         * price : 1
         * amount : 1
         * productDescription : 第二个将工序C分配给张三丰20个，老二4个
         * aConfirmTime : 2017-01-04
         * deliveryTime : 2016-12-13
         * orderProductType : 2
         * orderProductStatus : 1
         * productName : 第二个将工序C分配给张三丰20个，老二4个
         * deliveryTimeString : 2016-12-13
         * relFlowProcess : {"isNewRecord":true,"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0"},"target":1000,"processPriority":"0","status":"1","totalCompletedQuantity":181}
         * processFeedbackList : [{"id":"b1e6cf5c715f4a7e884ddd989960439d","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤1ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-16 12:07:15","updateDate":"2017-03-16 12:07:15","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":1,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"7da400ddc67445d7bf3d295f3ae7452c","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤1ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-16 11:00:24","updateDate":"2017-03-16 11:00:24","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":1,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"8c0551f0fe89459b9c0d48bbe97d1dce","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤1ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-16 10:58:47","updateDate":"2017-03-16 10:58:47","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":1,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"e81b62a9f3214a239b2bc1f3324e460f","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤4ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-16 10:09:32","updateDate":"2017-03-16 10:09:32","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":4,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"7bc75c3d13414cffab0cf048f55b1a00","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤4ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-16 10:07:46","updateDate":"2017-03-16 10:07:46","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":4,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"ee9bb068be554318917dd9a774c92096","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤3ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-15 17:08:50","updateDate":"2017-03-15 17:08:50","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":3,"resources":[],"feedbackUser":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"c89d4a9a6ac0456594a6f3151fef25a1","isNewRecord":false,"remarks":"å¼ ä¸\u0089ä¸°å¸®è\u0080\u0081äº\u008cæ\u008f\u0090äº¤3ä¸ª","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-15 17:06:08","updateDate":"2017-03-15 17:06:08","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":3,"resources":[],"feedbackUser":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"741c619d39c14a2b8bb965c0e8fb59a1","isNewRecord":false,"remarks":"完成5个","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-10 17:41:28","updateDate":"2017-03-10 17:41:28","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":1,"isFinished":"0","achieveAmount":5,"resources":[],"feedbackUser":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"7f1d287c17c2446a96a23a72bbad1c16","isNewRecord":false,"remarks":"今日完成10个","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-10 16:22:17","updateDate":"2017-03-10 16:22:17","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":0,"isFinished":"0","achieveAmount":10,"resources":[],"feedbackUser":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"59b9e2f25d1148be971c5e7d8c2b7572","isNewRecord":false,"remarks":"完成了5个次品1个","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-10 15:06:52","updateDate":"2017-03-10 15:06:52","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":1,"isFinished":"0","achieveAmount":20,"resources":[],"feedbackUser":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""},{"id":"58b163f61e11441d9caffd7e992e9f6d","isNewRecord":false,"remarks":"租了21","createBy":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 11:49:45","updateDate":"2017-03-02 11:49:45","flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]},"process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"faultAmount":1,"isFinished":"0","achieveAmount":21,"resources":[],"feedbackUser":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"target":0,"urls":""}]
         * planedAmount : 255
         * processWorkerList : [{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-15 12:42:51","updateDate":"2017-03-11 14:46:20","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"loginName":"zhang","no":"001","name":"张三丰","email":"","phone":"13384074008","mobile":"","userType":"3","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-03-11 11:11:22","loginFlag":"1","photo":"","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-03-11 11:11:22","isCustomerService":"0","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-01-06 11:28:52","updateDate":"2017-02-23 15:24:46","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"loginName":"laoer","no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","userType":"","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-02-24 12:41:34","loginFlag":"1","photo":"","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-02-24 12:41:34","isCustomerService":"1","roleList":[],"admin":false,"roleNames":""},{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"remarks":"","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-02-16 13:39:35","updateDate":"2017-02-23 13:05:44","company":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"office":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"},"loginName":"dongdong","no":"1000005","name":"dongdong","email":"","phone":"","mobile":"","userType":"2","loginIp":"0:0:0:0:0:0:0:1","loginDate":"2017-03-21 16:16:49","loginFlag":"1","photo":"","oldLoginIp":"0:0:0:0:0:0:0:1","oldLoginDate":"2017-03-21 16:16:49","isCustomerService":"0","roleList":[],"admin":false,"roleNames":""}]
         * workPlanList : [{"id":"2e2db29cea2f4c11b99dc0779b6bdea8","isNewRecord":false,"remarks":"dongdong分配张三丰29","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-21 16:55:57","updateDate":"2017-03-21 16:55:57","process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]},"planTime":"2017-04-21 00:00:00","worker":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"29","priority":"3"},{"id":"7a82e9b378f34e838ac9967a592daba0","isNewRecord":false,"remarks":"费赔给老二10","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-21 16:26:25","updateDate":"2017-03-21 16:26:25","process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]},"planTime":"2017-04-21 00:00:00","worker":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"10","priority":"3"},{"id":"70dbb96c8ba0460aa987f2e6f616d305","isNewRecord":false,"remarks":"分配给老二5个任务","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-21 16:25:51","updateDate":"2017-03-21 16:25:51","process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]},"planTime":"2017-04-21 00:00:00","worker":{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"5","priority":"3"},{"id":"e646b091498247f89d9c341c15755f1e","isNewRecord":false,"remarks":"给老张200个坐坐","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 11:48:00","updateDate":"2017-03-02 11:48:00","process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]},"planTime":"2017-03-29 11:47:50","worker":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"200","priority":"4"},{"id":"99c904d193df43fb87d2dffdeb3b1001","isNewRecord":false,"remarks":"xx","createBy":{"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-03-02 11:38:42","updateDate":"2017-03-02 11:38:42","process":{"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"},"flow":{"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]},"planTime":"2017-03-29 11:38:30","worker":{"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"achieveAmount":"1","priority":"4"}]
         * companyA : {"isNewRecord":true,"name":"江苏总公司","sort":30,"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"0"}
         * companyBOwner : {"isNewRecord":true,"name":"张三","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
         * aconfirmTime : 2017-01-04 15:03:39
         */

        private String id;
        private boolean isNewRecord;
        private CreateByBean createBy;
        private String createDate;
        private String updateDate;
        private OrderBean order;
        private CompanyCategoryBean companyCategory;
        private String price;
        private String amount;
        private String productDescription;
        private String aConfirmTime;
        private String deliveryTime;
        private String orderProductType;
        private String orderProductStatus;
        private String productName;
        private String deliveryTimeString;
        private RelFlowProcessBean relFlowProcess;
        private int planedAmount;
        private CompanyABean companyA;
        private CompanyBOwnerBean companyBOwner;
        private String aconfirmTime;
        private List<ProcessFeedbackListBean> processFeedbackList;
        private List<ProcessWorkerListBean> processWorkerList;
        private List<WorkPlanListBean> workPlanList;

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

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getDeliveryTimeString() {
            return deliveryTimeString;
        }

        public void setDeliveryTimeString(String deliveryTimeString) {
            this.deliveryTimeString = deliveryTimeString;
        }

        public RelFlowProcessBean getRelFlowProcess() {
            return relFlowProcess;
        }

        public void setRelFlowProcess(RelFlowProcessBean relFlowProcess) {
            this.relFlowProcess = relFlowProcess;
        }

        public int getPlanedAmount() {
            return planedAmount;
        }

        public void setPlanedAmount(int planedAmount) {
            this.planedAmount = planedAmount;
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

        public String getAconfirmTime() {
            return aconfirmTime;
        }

        public void setAconfirmTime(String aconfirmTime) {
            this.aconfirmTime = aconfirmTime;
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

        public List<WorkPlanListBean> getWorkPlanList() {
            return workPlanList;
        }

        public void setWorkPlanList(List<WorkPlanListBean> workPlanList) {
            this.workPlanList = workPlanList;
        }

        public static class CreateByBean implements Serializable {
            /**
             * id : ae5db71c02d94d6ba5f994319391fcf1
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
             * id : 01302d67478f4027b5aac0225eb1f00a
             * isNewRecord : false
             * sort : 30
             * takeOrderTime : 2016-12-21
             * takeOrderTimeString : 2016-12-21
             * delieverTimeString :
             * orderProductList : []
             * orderList : []
             * historyOrderNumber : 0
             * parentId : 0
             */

            private String id;
            private boolean isNewRecord;
            private int sort;
            private String takeOrderTime;
            private String takeOrderTimeString;
            private String delieverTimeString;
            private int historyOrderNumber;
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

        public static class CompanyCategoryBean  implements Serializable{
            /**
             * id : a09ca24a9cbc4e2783ab22061a6e6062
             * isNewRecord : false
             * name : 奥迪
             * sort : 30
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

        public static class RelFlowProcessBean implements Serializable{
            /**
             * isNewRecord : true
             * flow : {"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]}
             * process : {"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"sort":30,"relPPList":[],"proList":[],"parentId":"0"}
             * target : 1000
             * processPriority : 0
             * status : 1
             * totalCompletedQuantity : 181
             */

            private boolean isNewRecord;
            private FlowBean flow;
            private ProcessBean process;
            private int target;
            private String processPriority;
            private String status;
            private int totalCompletedQuantity;

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

            public int getTotalCompletedQuantity() {
                return totalCompletedQuantity;
            }

            public void setTotalCompletedQuantity(int totalCompletedQuantity) {
                this.totalCompletedQuantity = totalCompletedQuantity;
            }

            public static class FlowBean implements Serializable {
                /**
                 * id : 87782e91e55c4fb19fda788dfe95ba43
                 * isNewRecord : false
                 * processList : []
                 * remaksList : []
                 */

                private String id;
                private boolean isNewRecord;
                private List<?> processList;
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

                public List<?> getRemaksList() {
                    return remaksList;
                }

                public void setRemaksList(List<?> remaksList) {
                    this.remaksList = remaksList;
                }
            }

            public static class ProcessBean implements Serializable {
                /**
                 * id : f396133570804cc89b95fda4346aee80
                 * isNewRecord : false
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private int sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;

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
            }
        }

        public static class CompanyABean implements Serializable{
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
            private String parentId;
            private List<?> customerServiceList;

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
        }

        public static class CompanyBOwnerBean implements Serializable {
            /**
             * isNewRecord : true
             * name : 张三
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

        public static class ProcessFeedbackListBean implements Serializable {
            /**
             * id : b1e6cf5c715f4a7e884ddd989960439d
             * isNewRecord : false
             * remarks : å¼ ä¸ä¸°å¸®èäºæäº¤1ä¸ª
             * createBy : {"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-03-16 12:07:15
             * updateDate : 2017-03-16 12:07:15
             * flow : {"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"processList":[],"remaksList":[]}
             * process : {"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"}
             * faultAmount : 0
             * isFinished : 0
             * achieveAmount : 1
             * resources : []
             * feedbackUser : {"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"name":"老二","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * target : 0
             * urls :
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

            public static class CreateByBeanX implements Serializable {
                /**
                 * id : b17faaade8754e3eab1bcaba29cb52a8
                 * isNewRecord : false
                 * name : 张三丰
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

            public static class FlowBeanX implements Serializable {
                /**
                 * id : 87782e91e55c4fb19fda788dfe95ba43
                 * isNewRecord : false
                 * processList : []
                 * remaksList : []
                 */

                private String id;
                private boolean isNewRecord;
                private List<?> processList;
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

                public List<?> getRemaksList() {
                    return remaksList;
                }

                public void setRemaksList(List<?> remaksList) {
                    this.remaksList = remaksList;
                }
            }

            public static class ProcessBeanX implements Serializable {
                /**
                 * id : f396133570804cc89b95fda4346aee80
                 * isNewRecord : false
                 * name : 工序二d
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;

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
            }

            public static class FeedbackUserBean implements Serializable {
                /**
                 * id : dbb482a1b0434543a37e2d12408384d2
                 * isNewRecord : false
                 * name : 老二
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

        public static class ProcessWorkerListBean implements Serializable{
            /**
             * id : b17faaade8754e3eab1bcaba29cb52a8
             * isNewRecord : false
             * remarks :
             * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-02-15 12:42:51
             * updateDate : 2017-03-11 14:46:20
             * company : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"}
             * office : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"type":"1","serviceType":"1","customerServiceList":[],"reviewOthers":0,"reviewSelf":0,"otherCosting":0,"otherPayment":0,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":0,"selfPayment":0,"serviceCount":0,"parentId":"1"}
             * loginName : zhang
             * no : 001
             * name : 张三丰
             * email :
             * phone : 13384074008
             * mobile :
             * userType : 3
             * loginIp : 0:0:0:0:0:0:0:1
             * loginDate : 2017-03-11 11:11:22
             * loginFlag : 1
             * photo :
             * oldLoginIp : 0:0:0:0:0:0:0:1
             * oldLoginDate : 2017-03-11 11:11:22
             * isCustomerService : 0
             * roleList : []
             * admin : false
             * roleNames :
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanXX createBy;
            private String createDate;
            private String updateDate;
            private CompanyBean company;
            private OfficeBean office;
            private String loginName;
            private String no;
            private String name;
            private String email;
            private String phone;
            private String mobile;
            private String userType;
            private String loginIp;
            private String loginDate;
            private String loginFlag;
            private String photo;
            private String oldLoginIp;
            private String oldLoginDate;
            private String isCustomerService;
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

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public CreateByBeanXX getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateByBeanXX createBy) {
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

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(String loginIp) {
                this.loginIp = loginIp;
            }

            public String getLoginDate() {
                return loginDate;
            }

            public void setLoginDate(String loginDate) {
                this.loginDate = loginDate;
            }

            public String getLoginFlag() {
                return loginFlag;
            }

            public void setLoginFlag(String loginFlag) {
                this.loginFlag = loginFlag;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getOldLoginIp() {
                return oldLoginIp;
            }

            public void setOldLoginIp(String oldLoginIp) {
                this.oldLoginIp = oldLoginIp;
            }

            public String getOldLoginDate() {
                return oldLoginDate;
            }

            public void setOldLoginDate(String oldLoginDate) {
                this.oldLoginDate = oldLoginDate;
            }

            public String getIsCustomerService() {
                return isCustomerService;
            }

            public void setIsCustomerService(String isCustomerService) {
                this.isCustomerService = isCustomerService;
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

            public static class CreateByBeanXX implements Serializable {
                /**
                 * id : d6c8e9bc4c2b476ba84b962c27882f41
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

            public static class CompanyBean implements Serializable {
                /**
                 * id : f541afa391974409ba680e9bd9a394fd
                 * isNewRecord : false
                 * parentIds : 0,1,
                 * name : 江苏总公司
                 * sort : 30
                 * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
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
                 * parentId : 1
                 */

                private String id;
                private boolean isNewRecord;
                private String parentIds;
                private String name;
                private int sort;
                private AreaBean area;
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
                private String parentId;
                private List<?> customerServiceList;

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

                public String getParentIds() {
                    return parentIds;
                }

                public void setParentIds(String parentIds) {
                    this.parentIds = parentIds;
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

                public AreaBean getArea() {
                    return area;
                }

                public void setArea(AreaBean area) {
                    this.area = area;
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

                public static class AreaBean implements Serializable {
                    /**
                     * id : 12
                     * isNewRecord : false
                     * parentIds : 0,1
                     * name : 江苏省
                     * sort : 30
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String parentIds;
                    private String name;
                    private int sort;
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

                    public String getParentIds() {
                        return parentIds;
                    }

                    public void setParentIds(String parentIds) {
                        this.parentIds = parentIds;
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
                }
            }

            public static class OfficeBean implements Serializable {
                /**
                 * id : f541afa391974409ba680e9bd9a394fd
                 * isNewRecord : false
                 * parentIds : 0,1,
                 * name : 江苏总公司
                 * sort : 30
                 * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
                 * type : 1
                 * serviceType : 1
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
                 * parentId : 1
                 */

                private String id;
                private boolean isNewRecord;
                private String parentIds;
                private String name;
                private int sort;
                private AreaBeanX area;
                private String type;
                private String serviceType;
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
                private String parentId;
                private List<?> customerServiceList;

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

                public String getParentIds() {
                    return parentIds;
                }

                public void setParentIds(String parentIds) {
                    this.parentIds = parentIds;
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

                public AreaBeanX getArea() {
                    return area;
                }

                public void setArea(AreaBeanX area) {
                    this.area = area;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getServiceType() {
                    return serviceType;
                }

                public void setServiceType(String serviceType) {
                    this.serviceType = serviceType;
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

                public static class AreaBeanX implements Serializable {
                    /**
                     * id : 12
                     * isNewRecord : false
                     * parentIds : 0,1
                     * name : 江苏省
                     * sort : 30
                     * parentId : 0
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String parentIds;
                    private String name;
                    private int sort;
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

                    public String getParentIds() {
                        return parentIds;
                    }

                    public void setParentIds(String parentIds) {
                        this.parentIds = parentIds;
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
                }
            }
        }

        public static class WorkPlanListBean implements Serializable {
            /**
             * id : 2e2db29cea2f4c11b99dc0779b6bdea8
             * isNewRecord : false
             * remarks : dongdong分配张三丰29
             * createBy : {"id":"4856035c527b419a9cf70d856e65c93b","isNewRecord":false,"name":"dongdong","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * createDate : 2017-03-21 16:55:57
             * updateDate : 2017-03-21 16:55:57
             * process : {"id":"f396133570804cc89b95fda4346aee80","isNewRecord":false,"name":"工序二d","sort":30,"relPPList":[],"proList":[],"parentId":"0"}
             * flow : {"id":"87782e91e55c4fb19fda788dfe95ba43","isNewRecord":false,"name":"第二个将工序C分配给张三丰20个，老二4个","processList":[],"remaksList":[]}
             * planTime : 2017-04-21 00:00:00
             * worker : {"id":"b17faaade8754e3eab1bcaba29cb52a8","isNewRecord":false,"name":"张三丰","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
             * achieveAmount : 29
             * priority : 3
             */

            private String id;
            private boolean isNewRecord;
            private String remarks;
            private CreateByBeanXXX createBy;
            private String createDate;
            private String updateDate;
            private ProcessBeanXX process;
            private FlowBeanXX flow;
            private String planTime;
            private WorkerBean worker;
            private String achieveAmount;
            private String priority;

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

            public CreateByBeanXXX getCreateBy() {
                return createBy;
            }

            public void setCreateBy(CreateByBeanXXX createBy) {
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

            public ProcessBeanXX getProcess() {
                return process;
            }

            public void setProcess(ProcessBeanXX process) {
                this.process = process;
            }

            public FlowBeanXX getFlow() {
                return flow;
            }

            public void setFlow(FlowBeanXX flow) {
                this.flow = flow;
            }

            public String getPlanTime() {
                return planTime;
            }

            public void setPlanTime(String planTime) {
                this.planTime = planTime;
            }

            public WorkerBean getWorker() {
                return worker;
            }

            public void setWorker(WorkerBean worker) {
                this.worker = worker;
            }

            public String getAchieveAmount() {
                return achieveAmount;
            }

            public void setAchieveAmount(String achieveAmount) {
                this.achieveAmount = achieveAmount;
            }

            public String getPriority() {
                return priority;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public static class CreateByBeanXXX implements Serializable {
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

            public static class ProcessBeanXX implements Serializable {
                /**
                 * id : f396133570804cc89b95fda4346aee80
                 * isNewRecord : false
                 * name : 工序二d
                 * sort : 30
                 * relPPList : []
                 * proList : []
                 * parentId : 0
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private int sort;
                private String parentId;
                private List<?> relPPList;
                private List<?> proList;

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
            }

            public static class FlowBeanXX implements Serializable {
                /**
                 * id : 87782e91e55c4fb19fda788dfe95ba43
                 * isNewRecord : false
                 * name : 第二个将工序C分配给张三丰20个，老二4个
                 * processList : []
                 * remaksList : []
                 */

                private String id;
                private boolean isNewRecord;
                private String name;
                private List<?> processList;
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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getProcessList() {
                    return processList;
                }

                public void setProcessList(List<?> processList) {
                    this.processList = processList;
                }

                public List<?> getRemaksList() {
                    return remaksList;
                }

                public void setRemaksList(List<?> remaksList) {
                    this.remaksList = remaksList;
                }
            }

            public static class WorkerBean implements Serializable{
                /**
                 * id : b17faaade8754e3eab1bcaba29cb52a8
                 * isNewRecord : false
                 * name : 张三丰
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
    }
}



