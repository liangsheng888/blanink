package com.blanink.utils;

/**
 * Created by Administrator on 2017/5/16.
 *
 */
public class SysConstants {

    public static String OFFICE_ROLE ="3";   //公司管理员



    /**
     * 合作伙伴类型
     */
    public static String PARTNER_TYPE_FORMAL = "1";//长期
    public static String PARTNER_TYPE_NOT_FORMAL = "0";//潜在
    /**
     * 操作方式
     */
    public static String CRUD_TYPE_ADD = "ADD"; //新增
    public static String CRUD_TYPE_RETRIEVE = "RET"; //新增
    public static String CRUD_TYPE_UPPDATE = "UPDATE"; //更新

    public static String ORDER_TYPE_DEFAULT= "1";

    /*
     * 缓存
     */
    public static String PROCESS_CASHE = "processcashe";
    public static String WORKFLOW_DATA = "workflow.data";

    /**
     * 流程
     */
    public static String FLOW_STATUS_UN_PUBLISH = "1";
    public static String FLOW_STATUS_CONFIRM = "3";
    public static String FLOW_STATUS_PUBLISH = "2";

    /**
     * 工序流程
     * 1-未开始
     2-进行中
     3-已完成
     4-售后中
     5-售后已完成
     */
    public static String FLOW_PROCESS_STATUS_UN_START = "1";//未开始
    public static String FLOW_PROCESS_STATUS_PROGRESSING = "2";//进行中
    public static String FLOW_PROCESS_STATUS_COMPLETED = "3";//已完成
    public static String FLOW_PROCESS_STATUS_AFTER_SALES = "4";//售后中
    public static String FLOW_PROCESS_STATUS_AFTER_SALES_FINISH = "5";//售后已完成

    /**
     * 附件类型
     */

    public static String RESOURCE_TYPE_PRODUCT = "company_product";
    public static String RESOURCE_TYPE_PARTNER = "partner";
    public static String RESOURCE_TYPE_ORDER_PRODUCT = "ORDER_PRODUCT";
    public static String RESOURCE_TYPE_FINANCING = "financing";
    public static String RESOURCE_TYPE_INVESTMENT = "investment";
    public static String RESOURCE_TYPE_INVITEBID = "invite_bid";
    public static String RESOURCE_TYPE_BID = "bid";
    public static String RESOURCE_TYPE_FEEDBACK = "process_feedback";


    /**
     * 审核状态
     * partner表
     */
    public static String REVIEW_STATUS_SUBMIT = "1";   //提交
    public static String REVIEW_STATUS_AGREE = "2";	  //同意
    public static String REVIEW_STATUS_REJECT = "3";   //拒绝
    public static String REVIEW_STATUS_REMOVE = "4";   //解除

    //订单类型
    public static String ORDER_TYPE_SOURCE="3";


    /**
     * 售后状态
     */
    public static String AFTERSALES_STATUS_START = "1";//发起售后
    public static String AFTERSALES_STATUS_HANDLING = "2";//已接受并处理
    public static String AFTERSALES_STATUS_HAND_END = "3";//内部处理结束
    public static String AFTERSALES_STATUS_VERIFY = "4";//待发起方确认
    public static String AFTERSALES_STATUS_END = "5";//售后结束

    /**
     * 还款状态
     */
    public static String PAYMENT_STATUS_START = "1";//发起还款
    public static String PAYMENT_STATUS_CONFIRM = "2";//已还款待确认
    public static String PAYMENT_STATUS_END = "3";//还款结束

    /**
     * 还款确认结果
     */
    public static String PAYMENT_CONFIRM_STATUS_RECEIVED = "1";//已收到
    public static String PAYMENT_CONFIRM_STATUS_NOT_RECEIVED = "2";//未收到

    /**
     * 订单产品的不同状态
     */
    public static String ORDER_PRODUCT_STATUS_COMPANY_A_CREATED ="1";//甲方“去单产品”刚刚创建，但还没有形成订单下发
    public static String ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED ="2";//甲方“去单产品”已经创建，且已经绑定订单，但还没有发送出去
    public static String ORDER_PRODUCT_STATUS_COMPANY_A_CONBINED_SEND ="3";//甲方“去单产品"已经组合成订单，发送给乙方
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_CREATED ="4";//乙方“来单"已经创建
    public static String ORDER_PRODUCT_STATUS_BACK_TO_A ="5";//乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认中
    public static String ORDER_PRODUCT_STATUS_BACK_TO_A_CONFIRMED_TO_B="6";//乙方“来单"已经创建（或者编辑甲方发来的产品信息）,并打回甲方确认后，甲方已经确认，并重新发送给乙方
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_DISTRIBUTE="7";//乙方内部下发生产中
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_CREATED="8";//乙方内部流程已创建，未发布
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_FLOW_PULISHED="9";//乙方内部流程已创建，并且已发布
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_PRODUCTION_END="10";//乙方内部生产已经完成，未发货-----在反馈任务，改变flow_process状态时候，进行修改本状态
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_PART="11";//部分发货
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_DELIEVERY_OVER="12";//全部发货完成
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_PART="13";//部分发货，并且已经确认收到
    public static String ORDER_PRODUCT_STATUS_COMPANY_B_RECEIVED_OVER="14";//全部发货完成，并且已经确认收到---带评论
    public static String ORDER_PRODUCT_STATUS_COMMENT_OVER="15";// 评论、检讨结束（判断是否可以评论）
    public static String ORDER_PRODUCT_STATUS_AFTERSALES_START="16";// 本订单产品的售后已经发起，等待答复
    public static String ORDER_PRODUCT_STATUS_AFTERSALES_DEALING="17";// 本订单产品的售后正在处理中
    public static String ORDER_PRODUCT_STATUS_AFTERSALES_DEALING_OVER="18";// 本订单产品的售后处理结束
    public static String ORDER_PRODUCT_STATUS_AFTERSALES_DEALING_OVER_CONFIRMED="19";// 本订单产品的售后处理结束,并被确认ok
    public static String ORDER_PRODUCT_STATUS_PAYMENT_START="20";// 本订单产品的还款已经发起
    public static String ORDER_PRODUCT_STATUS_PAYMENT_OVER="21";// 本订单产品的还款已经确认收到
    public static String ORDER_PRODUCT_STATUS_PAYMENT_REJECT="22";// 本订单产品的还款未收到
    public static String ORDER_PRODUCT_SRTATUS_REJECT="23";// 乙方拒绝生产本产品
    public static String ORDER_PRODUCT_SRTATUS_REJECT_TAKE="24";// 甲方拒绝收货
    /**
     * 订单类型tbl_order表里面的order_type
     */
    public static String ORDER_TYPE_SOURCE_A="1";//甲方传送的订单
    public static String ORDER_TYPE_SOURCE_B="2";//乙方自己创建的
    public static String ORDER_TYPE_SOURCE_AFTER_SERVICE="3";//售后的
    public static String ORDER_TYPE_SOURCE_PAY_BACK="4"; //发起还款的
    /**
     * 订单成品的来源source字段
     */
    public static String ORDER_PRODUCT_SOURCE_A ="1"; //甲方传输来的
    public static String ORDER_PRODUCT_SOURCE_B ="2"; //乙方自己创建的
    public static String ORDER_PRODUCT_SOURCE_AFTER_SERVICE="3"; //发起售后的
    public static String ORDER_PRODUCT_SOURCE_PAY_BACK="4"; //发起还款的
    /**
     * order_product表里的订单产品的采购类型order_product_type
     */
    public static String ORDER_PRODUCT_TYPE_BUY ="1"; //采购
    public static String ORDER_PRODUCT_TYPE_SERVICE ="2";//外加工-服务

    /**
     * 订单产品的来源 tbl_order_product 表内source字段
     */
    public static String ORDER_PPODUCT_SOURCE_FROM_A ="1";//甲方“传输的单子”，不是我方自己填写的
    public static String ORDER_PPODUCT_SOURCE_FROM_OWN ="2";//乙方“自己填写的单子”
    public static String ORDER_PPODUCT_SOURCE_FROM_AFTER_SELL ="3";//来自售后的单子

    /**
     * tbl_partner表的apply_direct申请方向
     */
    public static String PARTNER_APPLY_A_B ="0";//A-->B
    public static String PARTNER_APPLY_B_A ="1";//B-->A

    /**
     * 通知类型
     */
    public static String NOTIFY_MEETING ="1";//会议通告
    public static String NOTIFY_CONSULT ="2";//咨询沟通
    public static String NOTIFY_ACTIVITY ="3";//活动通告
    public static String NOTIFY_ORDER_PRODUCT ="4";//订单产品沟通
    public static String NOTIFY_PARTNER ="5";//下家申请通知
    public static String NOTIFY_CUSTOMER ="6";//上家申请通知
    public static String NOTIFY_PARTNER_REMOVE ="7";//下家解除通知
    public static String NOTIFY_CUSTOMER_REMOVE ="8";//上家解除通知
    public static String NOTIFY_OTHER ="9";//其他通知
    public static String NOTIFY_ORDER ="10";//订单消息

    /**
     * 通知的status状态
     */
    public static String NOTIFY_STATUS_DRAFT="0";//通知的草稿
    public static String NOTIFY_STATUS_NOMAL="1";//通知的正式稿件

    /**
     * 订单产品的来源 tbl_company_category 表内serve_type字段
     */
    public static String COMPANY_CATEGORY_NOMAL ="1";//公司正常的产品，非资金等特殊产品
    public static String COMPANY_CATEGORY_SERVICE ="2";//本产品属于服务类型的产品（例如外加工等）
    public static String COMPANY_CATEGORY_LOAN ="3";//贷款类型的产品
    public static String COMPANY_CATEGORY_INVESTMENT ="4";//股权投资类的产品

    /**
     * tbl_product_remark表type
     */

    public static String PRODUCT_REMARK_TYPE_OWN ="1";//h755
    public static String PRODUCT_REMARK_TYPE_BOTH ="2";//双方公司都可见

    /**
     * 搜索类型
     */

    public static String SEARCH_COMPANY ="1";//公司
    public static String SEARCH_PRODUCT ="2";//产品/资金
    public static String SEARCH_BIDS ="3";//招标
    public static String SEARCH_FINANCING ="4";//借贷

    /**
     * 沟通类型
     */

    public static String TALK_TYPE_BID ="1"; //普通投标
    public static String TALK_TYPE_FINANCING ="2"; //资金投标
    public static String TALK_TYPE_COMPANY_PRODUCT ="3"; //公司产品投标
    public static String TALK_TYPE_COMPANY="4";//对公司的沟通

    /**
     * 工序类型tbl_process里面的type字段
     */

    public static String PROCESS_TYPE_NORMAL ="1"; //普通工序
    public static String PROCESS_TYPE_OUT_PROCESS="2";//外加工
    public static String PROCESS_TYPE_DELIVERY="3";//发货
    public static String PROCESS_TYPE_BROW="4";//借钱
    public static String PROCESS_TYPE_BUY="5";//采购
    public static String PROCESS_TYPE_SERVICE="6";//售后类型
    public static String PROCESS_TYPE_OTHER="7";//其他类型的

    /**
     * sys_office表里面的type，公司类型
     */
    public static String OFFICE_TYPE_PRODUCT = "1";//生产型
    public static String OFFICE_TYPE_MONEY = "2";//资金型
    public static String OFFICE_TYPE_SERVE = "3";//服务型
    public static int EXPAND_TIMES=2;// 流程放大倍数
    public static int SHRINK_TIMES=2;// 流程放大倍数 shrink


    /**
     * 订单的不同状态
     */
    public static String ORDER_STATUS_COMPANY_A_CREATED ="1";//甲方订单已经创建，未发给乙方
    public static String ORDER_STATUS_COMPANY_A_CREATED_SEND ="2";//甲方“订单刚刚组合”好，发给了乙方
    public static String ORDER_STATUS_COMPANY_B_CREATED ="3";//乙方“订单刚刚创建”好
    public static String ORDER_STATUS_WORKING ="4";//“订单进入生产中”，某一个产品下发生产中--至--所有产品生产已完成之间
    public static String ORDER_STATUS_OVER ="5";//“订单已完成”所有产品都已经被甲方确认收货
    public static String ORDER_STATUS_DEVELIVERY ="6";//“订单”有部分产品在发货中
    public static String ORDER_STATUS_DEVELIVERY_OVER ="7";//“订单”所有产品在发货中

    /**
     * processFeedback表里面的is_finished字段
     */

    public static String PROCESS_FEEDBACK_WORKING = "0";//未完成 或者 部分发货
    public static String PROCESS_FEEDBACK_OVER = "1";//已经完成 或者 全部发货

}
