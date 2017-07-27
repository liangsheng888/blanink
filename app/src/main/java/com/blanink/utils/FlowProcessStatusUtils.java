package com.blanink.utils;

/**
 * Created by Administrator on 2017/6/20.
 * 流程工序状态
 */
public class FlowProcessStatusUtils {
    public static String FLOW_PROCESS_STATUS_UN_START = "1";//未开始
    public static String FLOW_PROCESS_STATUS_PROGRESSING = "2";//进行中
    public static String FLOW_PROCESS_STATUS_COMPLETED = "3";//已完成
    public static String FLOW_PROCESS_STATUS_AFTER_SALES = "4";//售后中
    public static String FLOW_PROCESS_STATUS_AFTER_SALES_FINISH = "5";//售后已完成
    public static String getProcessStatus(String status){
        String st="";
        if("1".equals(status)){
            st="未开始";
        }
        if("2".equals(status)){
            st="进行中";
        }
        if("3".equals(status)){
            st="已完成";
        }
        if("4".equals(status)){
            st="售后中";
        }
        if("5".equals(status)){
            st="售后已完成";
        }
        return st;
    }
}
