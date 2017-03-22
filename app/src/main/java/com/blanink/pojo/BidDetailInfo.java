package com.blanink.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */

public class BidDetailInfo implements Serializable {
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "BidDetailInfo{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result{
        public String id;
        public Boolean isNewRecord;
        public String remarks;
        public ManyCustomer.Result.CreateBy createBy;
        public String createDate;
        public String updateDate;
        public TenderAndBid.Result.Row.InviteBid inviteBid;
        public TenderAndBid.Result.Row.Company bidCompany;
        public String bidDate;
        public String bidPrice;
        public String attachment;
        public List inviteBidTalkList;
        public String title;
        public Integer productionCycleUnit;//周期类型
        public String productionCycle;//周期
        public String bidStatus;

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", isNewRecord=" + isNewRecord +
                    ", remarks='" + remarks + '\'' +
                    ", createBy=" + createBy +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", inviteBid=" + inviteBid +
                    ", bidCompany=" + bidCompany +
                    ", bidDate='" + bidDate + '\'' +
                    ", bidPrice='" + bidPrice + '\'' +
                    ", attachment='" + attachment + '\'' +
                    ", inviteBidTalkList=" + inviteBidTalkList +
                    ", title='" + title + '\'' +
                    ", productionCycleUnit=" + productionCycleUnit +
                    ", productionCycle='" + productionCycle + '\'' +
                    ", bidStatus='" + bidStatus + '\'' +
                    '}';
        }
    }
    }


