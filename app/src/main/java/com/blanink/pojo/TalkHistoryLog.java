package com.blanink.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */

public class TalkHistoryLog {
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "TalkHistoryLog{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result {
        public Integer total;
        public List<Row> rows;

        @Override
        public String toString() {
            return "Result{" +
                    "total=" + total +
                    ", rows=" + rows +
                    '}';
        }

        public static class Row {
            public String id;
            public Boolean isNewRecord;
            public ManyCustomer.Result.CreateBy createBy;
            public String createDate;
            public String updateDate;
            public Bid bid;

            public static class Bid {
                public String id;
                public Boolean isNewRecord;
                public List inviteBidTalkList;
                public Integer productionCycleUnit;
                public Integer bidStatus;

                @Override
                public String toString() {
                    return "Bid{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", inviteBidTalkList=" + inviteBidTalkList +
                            ", productionCycleUnit=" + productionCycleUnit +
                            ", bidStatus=" + bidStatus +
                            '}';
                }
            }

            public TenderAndBid.Result.Row.InviteBid inviteBid;
            public ReceiveUser receiveUser;
            public static class ReceiveUser {
                public String id;
                public Boolean isNewRecord;
                public String name;
                public String loginFlag;
                public Boolean admin;
                public String roleNames;
                @Override
                public String toString() {
                    return "ReceiveUser{" +
                            "id='" + id + '\'' +
                            ", isNewRecord=" + isNewRecord +
                            ", name='" + name + '\'' +
                            ", loginFlag='" + loginFlag + '\'' +
                            ", admin=" + admin +
                            ", roleNames='" + roleNames + '\'' +
                            '}';
                }
            }
            public String message;
            public String attachment;
            public String title;

            @Override
            public String toString() {
                return "Row{" +
                        "id='" + id + '\'' +
                        ", isNewRecord=" + isNewRecord +
                        ", createBy=" + createBy +
                        ", createDate='" + createDate + '\'' +
                        ", updateDate='" + updateDate + '\'' +
                        ", bid=" + bid +
                        ", inviteBid=" + inviteBid +
                        ", receiveUser=" + receiveUser +
                        ", message='" + message + '\'' +
                        ", attachment='" + attachment + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }
    }
}

