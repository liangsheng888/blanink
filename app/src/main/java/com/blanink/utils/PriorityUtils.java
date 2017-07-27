package com.blanink.utils;

/**
 * Created by Administrator on 2017/5/19.
 * 转换优先级的工具类
 */
public class PriorityUtils {

    public static String getPriority(String flag) {
        String priority = "";
        if ("1".equals(flag)) {
            priority="马上解决";
        }
        if ("2".equals(flag)) {
            priority="急需解决";
        }
        if ("3".equals(flag)) {
            priority="重视";
        }
        if ("4".equals(flag)) {
            priority="正常处理";
        }
        if ("5".equals(flag)) {
            priority="稍缓处理";
        }


        return priority;
    }
}
