/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/charley/blanink">Blanink</a> All rights reserved.
 */
package com.blanink.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 订单Entity
 * @author CaoYuan
 * @version 2016-11-07
 */
public class OrderProduct implements Serializable {
	private String id;
	private Order  order;		// 订单编号 父类
	private String actualFlowId;		// 流程实例编号
	private CompanyCategory companyCategory;		// 公司叶子节点
	private String price;		// 产品价格（借款资金额度）
	private String amount;		// 产品数量
	private String productDescription;		// 订单实例描述
	private String rate;		// 利率
	private String isAConfirm;		// 是否甲方确认
	private String confirmUserid;		// 甲方确认人
	private Date aConfirmTime;		// 确认时间
	private Date deliveryTime;       //交付时间
	private String orderProductType;		// 订单产品采购类型（外加工，采购）
	private String orderProductStatus; 	    //
	private String crudType ;		// 添删改查状态
	private String productName;     // 产品名称
	private List<OrderProductSpecification> orderProductSpecificationList;
	private String percentCompleted; //完成百分比
	private String deliveryTimeString ; //交货时间string类型
	private String companyAPriority ; //甲方优先级
	private String companyBPriority ;  //内部生产优先级
	private String images ;      //图片
	private List<Resource> imageList ;//图片列表
	private Date innerDeliveryTime ;   //内部交货时间
	private String innerDeliveryTimeString ;//内部交货时间string类型
	private RelFlowProcess relFlowProcess;      //本订单产品关联的流程（id）
	private WorkPlan workPlan; //本订单产品在某工序的工作分配情况
	private Integer finishedAmount;//本订单产品,针对某个user，目前总共已完成数量
	private ProcessFeedback processFeedback; //本订单产品在某个工序的信息反馈信息
	private Integer allFinishedAmount; //本订单产品,目前总共已经完成数量
	private List<FlowRemaks> flowRemarkList; //流程评价留言
	private List<ProcessFeedback> processFeedbackList;; //本工序已经反馈的历史记录
	private Integer planedAmount; //分配给某用户的总数
	private List<User> processWorkerList;
	private List<WorkPlan> workPlanList;//某个工序的分配列表
	private Office companyA;//A公司信息
	private User companyBOwner;//B公司责任人
	private String productSn ;
	private String source ;

	private Office aCompany;

	private Office bCompany;

	@Override
	public String toString() {
		return "OrderProduct{" +
				"id='" + id + '\'' +
				", order=" + order +
				", actualFlowId='" + actualFlowId + '\'' +
				", companyCategory=" + companyCategory +
				", price='" + price + '\'' +
				", amount='" + amount + '\'' +
				", productDescription='" + productDescription + '\'' +
				", rate='" + rate + '\'' +
				", isAConfirm='" + isAConfirm + '\'' +
				", confirmUserid='" + confirmUserid + '\'' +
				", aConfirmTime=" + aConfirmTime +
				", deliveryTime=" + deliveryTime +
				", orderProductType='" + orderProductType + '\'' +
				", orderProductStatus='" + orderProductStatus + '\'' +
				", crudType='" + crudType + '\'' +
				", productName='" + productName + '\'' +
				", orderProductSpecificationList=" + orderProductSpecificationList +
				", percentCompleted='" + percentCompleted + '\'' +
				", deliveryTimeString='" + deliveryTimeString + '\'' +
				", companyAPriority='" + companyAPriority + '\'' +
				", companyBPriority='" + companyBPriority + '\'' +
				", images='" + images + '\'' +
				", imageList=" + imageList +
				", innerDeliveryTime=" + innerDeliveryTime +
				", innerDeliveryTimeString='" + innerDeliveryTimeString + '\'' +
				", relFlowProcess=" + relFlowProcess +
				", workPlan=" + workPlan +
				", finishedAmount=" + finishedAmount +
				", processFeedback=" + processFeedback +
				", allFinishedAmount=" + allFinishedAmount +
				", flowRemarkList=" + flowRemarkList +
				", processFeedbackList=" + processFeedbackList +
				", planedAmount=" + planedAmount +
				", processWorkerList=" + processWorkerList +
				", workPlanList=" + workPlanList +
				", companyA=" + companyA +
				", companyBOwner=" + companyBOwner +
				", productSn='" + productSn + '\'' +
				", source='" + source + '\'' +
				", aCompany=" + aCompany +
				", bCompany=" + bCompany +
				'}';
	}
}