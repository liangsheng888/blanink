package com.blanink.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/20.
 * 评分
 */
public class Review implements Serializable{
    public String errorCode;
    public String reason;
    public Result result;

    @Override
    public String toString() {
        return "Review{" +
                "errorCode='" + errorCode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static  class Result implements Serializable{
        public Boolean isNewRecord;
        public String otherGrader;
        public String otherServiceGrade;
        public String otherQualityGrade;
        public String otherTimingGrade;
        public String otherCostingGrade;
        public String otherPaymentGrade;
        public String selfGrade;
        public String selfServiceGrade;
        public String selfQualityGrade;
        public String selfTimingGrade;
        public String selfCostingGrade;
        public String selfPaymentGrade;

        @Override
        public String toString() {
            return "Result{" +
                    "isNewRecord=" + isNewRecord +
                    ", otherGrader='" + otherGrader + '\'' +
                    ", otherServiceGrade='" + otherServiceGrade + '\'' +
                    ", otherQualityGrade='" + otherQualityGrade + '\'' +
                    ", otherTimingGrade='" + otherTimingGrade + '\'' +
                    ", otherCostingGrade='" + otherCostingGrade + '\'' +
                    ", otherPaymentGrade='" + otherPaymentGrade + '\'' +
                    ", selfGrade='" + selfGrade + '\'' +
                    ", selfServiceGrade='" + selfServiceGrade + '\'' +
                    ", selfQualityGrade='" + selfQualityGrade + '\'' +
                    ", selfTimingGrade='" + selfTimingGrade + '\'' +
                    ", selfCostingGrade='" + selfCostingGrade + '\'' +
                    ", selfPaymentGrade='" + selfPaymentGrade + '\'' +
                    '}';
        }
    }
}
