package com.blanink.utils;

/**
 * Created by Administrator on 2017/3/22.
 * 订单状态的工具类
 */

public class OrderStateUtils {
    public static String orderStatus(String orderStatusNumber){
        String orderStatusName="";
        if ("1".equals(orderStatusNumber)) {
            orderStatusName="订单已创建未发送乙方";
        }
        if ("2".equals(orderStatusNumber)) {
            orderStatusName="组合订单已发送乙方";
        }
        if ("3".equals(orderStatusNumber)) {
            orderStatusName="乙方订单已创建";
        }
        if ("4".equals(orderStatusNumber)) {
            orderStatusName="订单生产中";
        }
        if ("5".equals(orderStatusNumber)) {
            orderStatusName="订单已完成";
        }
        if ("6".equals(orderStatusNumber)) {

            orderStatusName="部分已发货";
        }
        if ("7".equals(orderStatusNumber)) {
            orderStatusName="全部已发货";
        }

        return orderStatusName;
        
    }
}
