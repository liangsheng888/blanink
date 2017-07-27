package com.blanink.utils;

/**
 * Created by Administrator on 2017/3/22.
 * 订单产品状态的工具类
 */

public class OrderProductStateUtils {
    public static String orderProductStatus(String orderStatusNumber){
        String orderStatusName="";
        if ("1".equals(orderStatusNumber)) {
            //甲方“去单产品”刚刚创建，但还没有形成订单下发
            orderStatusName="甲方已创建未发送";
        }
        if ("2".equals(orderStatusNumber)) {
            //甲方“去单产品”已经创建，且已经绑定订单，但还没有发送出去
            orderStatusName="甲方已绑定订单未发送";
        }
        if ("3".equals(orderStatusNumber)) {
            //甲方“去单产品"已经组合成订单，发送给乙方
            orderStatusName="甲方已发给乙方";
        }
        if ("4".equals(orderStatusNumber)) {
            //乙方“来单"已经创建
            orderStatusName="乙方自己已创建";
        }
        if ("5".equals(orderStatusNumber)) {
            //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认中
            orderStatusName="待甲方确认/修改";
        }
        if ("6".equals(orderStatusNumber)) {
            //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认后，
            // 甲方已经确认，并重新发送给已方
            orderStatusName="甲方已确认";
        }
        if ("7".equals(orderStatusNumber)) {
            //乙方内部下发生产中
            orderStatusName="下发生产中";
        }
        if ("8".equals(orderStatusNumber)) {
            //乙方内部流程已创建，未发布
            orderStatusName="流程已创建待发布";
        }
        if ("9".equals(orderStatusNumber)) {
            //乙方内部流程已创建，并且已发布
            orderStatusName="流程已发布";
        }
        if ("10".equals(orderStatusNumber)) {
            //乙方内部生产已经完成，未发货-----在反馈任务，改变flow_process状态时候，进行修改本状态
            orderStatusName="生产完成待发货";
        }
        if ("11".equals(orderStatusNumber)) {
            //部分发货
            orderStatusName="部分发货";
        }
        if ("12".equals(orderStatusNumber)) {
            // 全部发货完成
            orderStatusName="全部发出";
        }
        if ("13".equals(orderStatusNumber)) {
            //   部分发货，并且已经确认收到
            orderStatusName="已确认收到部分货";
        }
        if ("14".equals(orderStatusNumber)) {
            //全部发货完成，并且已经确认收到
            orderStatusName="确认收到全部货";
        }
        if ("15".equals(orderStatusNumber)) {
            // 本订单产品的售后已经发起，等待答复
            orderStatusName="已完成评论和检讨";
        }
        if ("16".equals(orderStatusNumber)) {
            // 本订单产品的售后正在处理中
            orderStatusName="待接受售后申请";
        }
        if ("17".equals(orderStatusNumber)) {
            orderStatusName="售后已接受处理中";
            //   本订单产品的售后处理结束
        }
        if ("18".equals(orderStatusNumber)) {
            orderStatusName="售后处理已结束";
            //本订单产品的售后处理结束,并被确认ok
        }
        if ("19".equals(orderStatusNumber)) {
            orderStatusName="售后被接受";
            // 本订单产品的还款已经发起
        }
        if ("20".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="发起还款";
        }
        if ("21".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="还款已被确认收到";
        }
        if ("22".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="还款未收到";
        }
        if ("23".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="拒绝生产";
        }
        if ("24".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="拒绝收货";
        }
        return orderStatusName;
        
    }


    public static String getAfterSaleType(String state){
        String st="";
        if("1".equals(state)){
            st="质量问题";
        }
        if("2".equals(state)){
            st="时效问题";
        }
        if("3".equals(state)){
            st="产品与需求不符";
        }
        if("4".equals(state)){
            st="外观";
        }
        if("5".equals(state)){
            st="包装";
        }
        return st;
    }

    public static String getAfterSaleState(String state){
        String st="";
        if("1".equals(state)){
            st="发起售后";
        }
        if("2".equals(state)){
            st="已接受并处理";
        }
        if("3".equals(state)){
            st="内部处理结束";
        }
        if("4".equals(state)){
            st="待发起方确认";
        }
        if("5".equals(state)){
            st="售后结束";
        }
        if("6".equals(state)){
            st="发起方不认同";
        }
        return st;
    }
}
