package com.blanink.utils;

/**
 * Created by Administrator on 2017/3/22.
 * 订单状态的工具类
 */

public class OrderStatuUtils {
    public static String orderStatus(String orderStatusNumber){
        String orderStatusName="";
        if ("01".equals(orderStatusNumber)) {
            //甲方“去单产品”刚刚创建，但还没有形成订单下发
            orderStatusName="未下发";
        }
        if ("02".equals(orderStatusNumber)) {
            //甲方“去单产品”已经创建，且已经绑定订单，但还没有发送出去
            orderStatusName="已绑定";
        }
        if ("03".equals(orderStatusNumber)) {
            //甲方“去单产品"已经组合成订单，发送给乙方
            orderStatusName="待乙方接收";
        }
        if ("4".equals(orderStatusNumber)) {
            //乙方“来单"已经创建
            orderStatusName="待甲方确认";
        }
        if ("5".equals(orderStatusNumber)) {
            //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认中
            orderStatusName="甲方确认中";
        }
        if ("6".equals(orderStatusNumber)) {
            //乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认后，
            // 甲方已经确认，并重新发送给已方
            orderStatusName="待下发";
        }
        if ("7".equals(orderStatusNumber)) {
            //乙方内部下发生产中
            orderStatusName="生产中";
        }
        if ("8".equals(orderStatusNumber)) {
            //乙方内部流程已创建，未发布
            orderStatusName="生产中";
        }
        if ("9".equals(orderStatusNumber)) {
            //乙方内部流程已创建，并且已发布
            orderStatusName="生产中";
        }
        if ("10".equals(orderStatusNumber)) {
            //乙方内部生产已经完成，未发货-----在反馈任务，改变flow_process状态时候，进行修改本状态
            orderStatusName="未发货";
        }
        if ("11".equals(orderStatusNumber)) {
            //部分发货
            orderStatusName="部分发货";
        }
        if ("12".equals(orderStatusNumber)) {
            // 全部发货完成
            orderStatusName="全部发货";
        }
        if ("13".equals(orderStatusNumber)) {
            //   部分发货，并且已经确认收到
            orderStatusName="甲方部分收货";
        }
        if ("14".equals(orderStatusNumber)) {
            //全部发货完成，并且已经确认收到
            orderStatusName="甲方全部收货";
        }
        if ("15".equals(orderStatusNumber)) {
            // 本订单产品的售后已经发起，等待答复
            orderStatusName="售后处理，等待答复";
        }
        if ("16".equals(orderStatusNumber)) {
            // 本订单产品的售后正在处理中
            orderStatusName="生产中";
        }
        if ("17".equals(orderStatusNumber)) {
            orderStatusName="售后处理结束";
            //   本订单产品的售后处理结束
        }
        if ("18".equals(orderStatusNumber)) {
            orderStatusName="售后处理结束";
            //本订单产品的售后处理结束,并被确认ok
        }
        if ("19".equals(orderStatusNumber)) {
            orderStatusName="发起还款";
            // 本订单产品的还款已经发起
        }
        if ("20".equals(orderStatusNumber)) {
            // 本订单产品的还款已经确认
            orderStatusName="还款已确认";
        }
        return orderStatusName;
        
    }
}
