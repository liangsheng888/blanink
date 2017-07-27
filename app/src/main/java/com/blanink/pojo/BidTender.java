package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class BidTender implements Serializable {

    /**
     * errorCode : 00000
     * reason : 获取数据成功！
     * result : [{"pageNo":1,"pageSize":10,"count":1,"list":[{"isNewRecord":true,"inviteBid":{"id":"dcb8c9c09efd4554b941791133558bad","isNewRecord":false,"remarks":"<p>哦三代富贵iupsdfniouneorpin<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-07 13:00:38","updateDate":"2017-04-07 13:00:38","inviteCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"},"inviteDate":"2017-04-07 12:58:45","buyProductName":"西瓜","targetPrice":"12","downPayment":"20","expireDate":"2017-04-30 13:00:30","attachment":"阿斯顿飞","bidList":[],"count":5000,"title":"采购西瓜500个","expired":false},"myBidCount":0,"myInvestCount":0}],"html":"<ul>\n<li class=\"disabled\"><a href=\"javascript:\">« 上一页<\/a><\/li>\n<li class=\"active\"><a href=\"javascript:\">1<\/a><\/li>\n<li class=\"disabled\"><a href=\"javascript:\">下一页 »<\/a><\/li>\n<li class=\"disabled controls\"><a href=\"javascript:\">当前 <input type=\"text\" value=\"1\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');\" onclick=\"this.select();\"/> / <input type=\"text\" value=\"10\" onkeypress=\"var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');\" onclick=\"this.select();\"/> 条，共 1 条<\/a><\/li>\n<\/ul>\n<div style=\"clear:both;\"><\/div>","firstResult":0,"maxResults":10}]
     */

    private String errorCode;
    private String reason;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "BidTender{" +
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

    public static class ResultBean implements Serializable {
        /**
         * pageNo : 1
         * pageSize : 10
         * count : 1
         * list : [{"isNewRecord":true,"inviteBid":{"id":"dcb8c9c09efd4554b941791133558bad","isNewRecord":false,"remarks":"<p>哦三代富贵iupsdfniouneorpin<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-07 13:00:38","updateDate":"2017-04-07 13:00:38","inviteCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"},"inviteDate":"2017-04-07 12:58:45","buyProductName":"西瓜","targetPrice":"12","downPayment":"20","expireDate":"2017-04-30 13:00:30","attachment":"阿斯顿飞","bidList":[],"count":5000,"title":"采购西瓜500个","expired":false},"myBidCount":0,"myInvestCount":0}]
         * html : <ul>
         <li class="disabled"><a href="javascript:">« 上一页</a></li>
         <li class="active"><a href="javascript:">1</a></li>
         <li class="disabled"><a href="javascript:">下一页 »</a></li>
         <li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(this.value,10,'');" onclick="this.select();"/> / <input type="text" value="10" onkeypress="var e=window.event||event;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 1 条</a></li>
         </ul>
         <div style="clear:both;"></div>
         * firstResult : 0
         * maxResults : 10
         */

        private int pageNo;
        private int pageSize;
        private int count;
        private String html;
        private int firstResult;
        private int maxResults;
        private List<ListBean> list;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "pageNo=" + pageNo +
                    ", pageSize=" + pageSize +
                    ", count=" + count +
                    ", html='" + html + '\'' +
                    ", firstResult=" + firstResult +
                    ", maxResults=" + maxResults +
                    ", list=" + list +
                    '}';
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public int getFirstResult() {
            return firstResult;
        }

        public void setFirstResult(int firstResult) {
            this.firstResult = firstResult;
        }

        public int getMaxResults() {
            return maxResults;
        }

        public void setMaxResults(int maxResults) {
            this.maxResults = maxResults;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * isNewRecord : true
             * inviteBid : {"id":"dcb8c9c09efd4554b941791133558bad","isNewRecord":false,"remarks":"<p>哦三代富贵iupsdfniouneorpin<br/><\/p>","createBy":{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"createDate":"2017-04-07 13:00:38","updateDate":"2017-04-07 13:00:38","inviteCompany":{"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"},"inviteDate":"2017-04-07 12:58:45","buyProductName":"西瓜","targetPrice":"12","downPayment":"20","expireDate":"2017-04-30 13:00:30","attachment":"阿斯顿飞","bidList":[],"count":5000,"title":"采购西瓜500个","expired":false}
             * myBidCount : 0
             * myInvestCount : 0
             */

            private boolean isNewRecord;
            private InviteBidBean inviteBid;
            private int bidCount;
            private int myBidCount;
            private int myInvestCount;

            public boolean isNewRecord() {
                return isNewRecord;
            }

            public void setNewRecord(boolean newRecord) {
                isNewRecord = newRecord;
            }

            public int getBidCount() {
                return bidCount;
            }

            public void setBidCount(int bidCount) {
                this.bidCount = bidCount;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "isNewRecord=" + isNewRecord +
                        ", inviteBid=" + inviteBid +
                        ", myBidCount=" + myBidCount +
                        ", myInvestCount=" + myInvestCount +
                        '}';
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public InviteBidBean getInviteBid() {
                return inviteBid;
            }

            public void setInviteBid(InviteBidBean inviteBid) {
                this.inviteBid = inviteBid;
            }

            public int getMyBidCount() {
                return myBidCount;
            }

            public void setMyBidCount(int myBidCount) {
                this.myBidCount = myBidCount;
            }

            public int getMyInvestCount() {
                return myInvestCount;
            }

            public void setMyInvestCount(int myInvestCount) {
                this.myInvestCount = myInvestCount;
            }

            public static class InviteBidBean implements Serializable{
                /**
                 * id : dcb8c9c09efd4554b941791133558bad
                 * isNewRecord : false
                 * remarks : <p>哦三代富贵iupsdfniouneorpin<br/></p>
                 * createBy : {"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                 * createDate : 2017-04-07 13:00:38
                 * updateDate : 2017-04-07 13:00:38
                 * inviteCompany : {"id":"f541afa391974409ba680e9bd9a394fd","isNewRecord":false,"remarks":"","createBy":{"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""},"createDate":"2017-01-05 15:11:38","updateDate":"2017-01-05 15:11:38","parentIds":"0,1,","name":"江苏总公司","sort":30,"area":{"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"},"code":"100000001","shortName":"江苏总公司","registTime":"2017-01-05 15:10:03","type":"1","serviceType":"1","grade":"1","address":"江苏省南京市","zipCode":"210000","master":"张三","phone":"02512345678","fax":"","email":"zhagnsan@email.com","useable":"1","primaryPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"deputyPerson":{"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""},"customerServiceList":[{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}],"homepage":"www.baidu.com","reviewOthers":3,"reviewSelf":2.2,"otherCosting":4.8,"otherPayment":4.3,"otherQuality":0,"otherService":0,"otherTime":0,"selfCosting":4.3,"selfPayment":0,"selfQuality":4.5,"selfService":4.8,"selfTime":4.5,"serviceCount":5,"grossProfit":0,"parentId":"1"}
                 * inviteDate : 2017-04-07 12:58:45
                 * buyProductName : 西瓜
                 * targetPrice : 12
                 * downPayment : 20
                 * expireDate : 2017-04-30 13:00:30
                 * attachment : 阿斯顿飞
                 * bidList : []
                 * count : 5000
                 * title : 采购西瓜500个
                 * expired : false
                 */

                private String id;
                private boolean isNewRecord;
                private String remarks;
                private CreateByBean createBy;
                private String createDate;
                private String updateDate;
                private InviteCompanyBean inviteCompany;
                private String inviteDate;
                private String buyProductName;
                private String targetPrice;
                private String downPayment;
                private String expireDate;
                private String attachment;
                private int count;
                private String title;
                private boolean expired;
                private List<?> bidList;

                @Override
                public String toString() {
                    return "InviteBidBean{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", remarks='" + remarks + '\'' +
                            ", createBy=" + createBy +
                            ", createDate='" + createDate + '\'' +
                            ", updateDate='" + updateDate + '\'' +
                            ", inviteCompany=" + inviteCompany +
                            ", inviteDate='" + inviteDate + '\'' +
                            ", buyProductName='" + buyProductName + '\'' +
                            ", targetPrice='" + targetPrice + '\'' +
                            ", downPayment='" + downPayment + '\'' +
                            ", expireDate='" + expireDate + '\'' +
                            ", attachment='" + attachment + '\'' +
                            ", count=" + count +
                            ", title='" + title + '\'' +
                            ", expired=" + expired +
                            ", bidList=" + bidList +
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

                public InviteCompanyBean getInviteCompany() {
                    return inviteCompany;
                }

                public void setInviteCompany(InviteCompanyBean inviteCompany) {
                    this.inviteCompany = inviteCompany;
                }

                public String getInviteDate() {
                    return inviteDate;
                }

                public void setInviteDate(String inviteDate) {
                    this.inviteDate = inviteDate;
                }

                public String getBuyProductName() {
                    return buyProductName;
                }

                public void setBuyProductName(String buyProductName) {
                    this.buyProductName = buyProductName;
                }

                public String getTargetPrice() {
                    return targetPrice;
                }

                public void setTargetPrice(String targetPrice) {
                    this.targetPrice = targetPrice;
                }

                public String getDownPayment() {
                    return downPayment;
                }

                public void setDownPayment(String downPayment) {
                    this.downPayment = downPayment;
                }

                public String getExpireDate() {
                    return expireDate;
                }

                public void setExpireDate(String expireDate) {
                    this.expireDate = expireDate;
                }

                public String getAttachment() {
                    return attachment;
                }

                public void setAttachment(String attachment) {
                    this.attachment = attachment;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public boolean isExpired() {
                    return expired;
                }

                public void setExpired(boolean expired) {
                    this.expired = expired;
                }

                public List<?> getBidList() {
                    return bidList;
                }

                public void setBidList(List<?> bidList) {
                    this.bidList = bidList;
                }

                public static class CreateByBean implements Serializable{
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

                public static class InviteCompanyBean implements Serializable{
                    /**
                     * id : f541afa391974409ba680e9bd9a394fd
                     * isNewRecord : false
                     * remarks :
                     * createBy : {"id":"1","isNewRecord":false,"loginFlag":"1","roleList":[],"admin":true,"roleNames":""}
                     * createDate : 2017-01-05 15:11:38
                     * updateDate : 2017-01-05 15:11:38
                     * parentIds : 0,1,
                     * name : 江苏总公司
                     * sort : 30
                     * area : {"id":"12","isNewRecord":false,"parentIds":"0,1","name":"江苏省","sort":30,"parentId":"0"}
                     * code : 100000001
                     * shortName : 江苏总公司
                     * registTime : 2017-01-05 15:10:03
                     * type : 1
                     * serviceType : 1
                     * grade : 1
                     * address : 江苏省南京市
                     * zipCode : 210000
                     * master : 张三
                     * phone : 02512345678
                     * fax :
                     * email : zhagnsan@email.com
                     * useable : 1
                     * primaryPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                     * deputyPerson : {"id":"","isNewRecord":true,"loginFlag":"1","roleList":[],"admin":false,"roleNames":""}
                     * customerServiceList : [{"id":"cd7bcbfd6fc84f49a7ec908e93093432","isNewRecord":false,"no":"001","name":"安徽公司管理员","email":"","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"d6c8e9bc4c2b476ba84b962c27882f41","isNewRecord":false,"no":"1000001","name":"张三","email":"jsadmin@123.com","phone":"1338965425999","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"447e4526d22045f59ed58250046b3842","isNewRecord":false,"no":"1000001","name":"李四","email":"zjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"1d8da8fbeb7b4986bfddb048463e6c3e","isNewRecord":false,"no":"00001","name":"火火测试公司","email":"123@aaa.com","phone":"13553565634","mobile":"13553565634","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"3c70d715d02a4c4aadc1952ecde286e1","isNewRecord":false,"no":"1000001","name":"王五","email":"bjadmin@12.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"dbb482a1b0434543a37e2d12408384d2","isNewRecord":false,"no":"1000002","name":"老二","email":"laoer@13.com","phone":"","mobile":"","loginFlag":"1","roleList":[],"admin":false,"roleNames":""},{"id":"8bb75d847a564d29bc2c1cb368fd3af0","isNewRecord":false,"no":"10000020","name":"西西","email":"","phone":"","mobile":"15250461064","loginFlag":"1","roleList":[],"admin":false,"roleNames":""}]
                     * homepage : www.baidu.com
                     * reviewOthers : 3
                     * reviewSelf : 2.2
                     * otherCosting : 4.8
                     * otherPayment : 4.3
                     * otherQuality : 0
                     * otherService : 0
                     * otherTime : 0
                     * selfCosting : 4.3
                     * selfPayment : 0
                     * selfQuality : 4.5
                     * selfService : 4.8
                     * selfTime : 4.5
                     * serviceCount : 5
                     * grossProfit : 0
                     * parentId : 1
                     */

                    private String id;
                    private boolean isNewRecord;
                    private String remarks;
                    private CreateByBeanX createBy;
                    private String createDate;
                    private String updateDate;
                    private String parentIds;
                    private String name;
                    private int sort;
                    private AreaBean area;
                    private String code;
                    private String shortName;
                    private String registTime;
                    private String type;
                    private String serviceType;
                    private String grade;
                    private String address;
                    private String zipCode;
                    private String master;
                    private String phone;
                    private String fax;
                    private String email;
                    private String useable;
                    private PrimaryPersonBean primaryPerson;
                    private DeputyPersonBean deputyPerson;
                    private String homepage;
                    private double reviewOthers;
                    private double reviewSelf;
                    private double otherCosting;
                    private double otherPayment;
                    private double otherQuality;
                    private double otherService;
                    private double otherTime;
                    private double selfCosting;
                    private double selfPayment;
                    private double selfQuality;
                    private double selfService;
                    private double selfTime;
                    private int serviceCount;
                    private int grossProfit;
                    private String parentId;
                    public String photo;

                    public String getPhoto() {
                        return photo;
                    }

                    public void setPhoto(String photo) {
                        this.photo = photo;
                    }

                    private List<CustomerServiceListBean> customerServiceList;

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

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    public String getShortName() {
                        return shortName;
                    }

                    public void setShortName(String shortName) {
                        this.shortName = shortName;
                    }

                    public String getRegistTime() {
                        return registTime;
                    }

                    public void setRegistTime(String registTime) {
                        this.registTime = registTime;
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

                    public String getGrade() {
                        return grade;
                    }

                    public void setGrade(String grade) {
                        this.grade = grade;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public String getZipCode() {
                        return zipCode;
                    }

                    public void setZipCode(String zipCode) {
                        this.zipCode = zipCode;
                    }

                    public String getMaster() {
                        return master;
                    }

                    public void setMaster(String master) {
                        this.master = master;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getFax() {
                        return fax;
                    }

                    public void setFax(String fax) {
                        this.fax = fax;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getUseable() {
                        return useable;
                    }

                    public void setUseable(String useable) {
                        this.useable = useable;
                    }

                    public PrimaryPersonBean getPrimaryPerson() {
                        return primaryPerson;
                    }

                    public void setPrimaryPerson(PrimaryPersonBean primaryPerson) {
                        this.primaryPerson = primaryPerson;
                    }

                    public DeputyPersonBean getDeputyPerson() {
                        return deputyPerson;
                    }

                    public void setDeputyPerson(DeputyPersonBean deputyPerson) {
                        this.deputyPerson = deputyPerson;
                    }

                    public boolean isNewRecord() {
                        return isNewRecord;
                    }

                    public void setNewRecord(boolean newRecord) {
                        isNewRecord = newRecord;
                    }

                    public String getHomepage() {
                        return homepage;
                    }

                    public void setHomepage(String homepage) {
                        this.homepage = homepage;
                    }

                    public double getReviewOthers() {
                        return reviewOthers;
                    }

                    public void setReviewOthers(double reviewOthers) {
                        this.reviewOthers = reviewOthers;
                    }

                    public double getReviewSelf() {
                        return reviewSelf;
                    }

                    public void setReviewSelf(double reviewSelf) {
                        this.reviewSelf = reviewSelf;
                    }

                    public double getOtherCosting() {
                        return otherCosting;
                    }

                    public void setOtherCosting(double otherCosting) {
                        this.otherCosting = otherCosting;
                    }

                    public double getOtherPayment() {
                        return otherPayment;
                    }

                    public void setOtherPayment(double otherPayment) {
                        this.otherPayment = otherPayment;
                    }

                    public double getOtherQuality() {
                        return otherQuality;
                    }

                    public void setOtherQuality(double otherQuality) {
                        this.otherQuality = otherQuality;
                    }

                    public double getOtherService() {
                        return otherService;
                    }

                    public void setOtherService(double otherService) {
                        this.otherService = otherService;
                    }

                    public double getOtherTime() {
                        return otherTime;
                    }

                    public void setOtherTime(double otherTime) {
                        this.otherTime = otherTime;
                    }

                    public double getSelfCosting() {
                        return selfCosting;
                    }

                    public void setSelfCosting(double selfCosting) {
                        this.selfCosting = selfCosting;
                    }

                    public double getSelfPayment() {
                        return selfPayment;
                    }

                    public void setSelfPayment(double selfPayment) {
                        this.selfPayment = selfPayment;
                    }

                    public double getSelfQuality() {
                        return selfQuality;
                    }

                    public void setSelfQuality(double selfQuality) {
                        this.selfQuality = selfQuality;
                    }

                    public double getSelfService() {
                        return selfService;
                    }

                    public void setSelfService(double selfService) {
                        this.selfService = selfService;
                    }

                    public double getSelfTime() {
                        return selfTime;
                    }

                    public void setSelfTime(double selfTime) {
                        this.selfTime = selfTime;
                    }

                    public int getServiceCount() {
                        return serviceCount;
                    }

                    public void setServiceCount(int serviceCount) {
                        this.serviceCount = serviceCount;
                    }

                    public int getGrossProfit() {
                        return grossProfit;
                    }

                    public void setGrossProfit(int grossProfit) {
                        this.grossProfit = grossProfit;
                    }

                    public String getParentId() {
                        return parentId;
                    }

                    public void setParentId(String parentId) {
                        this.parentId = parentId;
                    }

                    public List<CustomerServiceListBean> getCustomerServiceList() {
                        return customerServiceList;
                    }

                    public void setCustomerServiceList(List<CustomerServiceListBean> customerServiceList) {
                        this.customerServiceList = customerServiceList;
                    }

                    public static class CreateByBeanX implements Serializable{
                        /**
                         * id : 1
                         * isNewRecord : false
                         * loginFlag : 1
                         * roleList : []
                         * admin : true
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

                    public static class AreaBean implements Serializable{
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

                    public static class PrimaryPersonBean implements Serializable{
                        /**
                         * id :
                         * isNewRecord : true
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

                    public static class DeputyPersonBean implements Serializable{
                        /**
                         * id :
                         * isNewRecord : true
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

                    public static class CustomerServiceListBean implements Serializable{
                        /**
                         * id : cd7bcbfd6fc84f49a7ec908e93093432
                         * isNewRecord : false
                         * no : 001
                         * name : 安徽公司管理员
                         * email :
                         * phone :
                         * mobile :
                         * loginFlag : 1
                         * roleList : []
                         * admin : false
                         * roleNames :
                         */

                        private String id;
                        private boolean isNewRecord;
                        private String no;
                        private String name;
                        private String email;
                        private String phone;
                        private String mobile;
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
    }
}
