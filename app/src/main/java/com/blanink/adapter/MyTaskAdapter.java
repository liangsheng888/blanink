package com.blanink.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.stock.OutInStockAdd;
import com.blanink.activity.task.TaskResponseDeliver;
import com.blanink.activity.task.TaskResponseMine;
import com.blanink.pojo.OrderProduct;
import com.blanink.utils.CommonUtil;
import com.blanink.utils.PriorityUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class MyTaskAdapter extends BaseAdapter {
    private Context context;
    List<OrderProduct.Result> list;
    SparseArray<View> sparseArray;
    private String processType,processId;

    public MyTaskAdapter(Context context, List<OrderProduct.Result> list, String processType, String processId) {
        this.context = context;
        this.list = list;
        this.processType = processType;
        this.processId = processId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        sparseArray = new SparseArray<>();
        ViewHolder viewHolder = null;
        if (sparseArray.get(position, null) == null) {
            convertView = View.inflate(context, R.layout.item_my_task, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            sparseArray.put(position, convertView);

        } else {
            convertView = sparseArray.get(position);
            viewHolder = (ViewHolder) convertView.getTag();

        }
        final OrderProduct.Result result = list.get(position);
        viewHolder.tvCompanyName.setText(result.companyA.name);
        viewHolder.tvTime.setText(CommonUtil.dateToString(CommonUtil.stringToDate(result.createDate)));
        //  tv_master.setText(result.companyBOwner.name);
        viewHolder.tvProName.setText(result.productName);
        viewHolder.tvProCategory.setText(result.companyCategory.name);
        viewHolder.tvResponse.setText((result.finishedAmount == null ? 0 : result.finishedAmount) + "");//我的反馈
        viewHolder.tvMyTaskNum.setText(result.workPlan.achieveAmount);//我的任务
        viewHolder.tvNum.setText(result.amount);//订单产品数量
        viewHolder.tvPriority.setText(PriorityUtils.getPriority(result.workPlan.priority));

        viewHolder.tvIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OutInStockAdd.class);
                intent.putExtra("inOut","1");
                context.startActivity(intent);
            }
        });

        viewHolder.tvOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OutInStockAdd.class);
                intent.putExtra("inOut","2");
                context.startActivity(intent);
            }
        });

        viewHolder.tvDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("3".equals(processType)) {
                    Intent intent = new Intent(context, TaskResponseDeliver.class);
                    intent.putExtra("processId",processId);
                    intent.putExtra("companyId", result.companyA.id);
                    intent.putExtra("flowId",result.relFlowProcess.flow.id);
                    context.startActivity(intent);

                } else {
                    Intent intent = new Intent(context, TaskResponseMine.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("TaskDetail", result);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            }
        });
        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.tv_pro_category)
        TextView tvProCategory;
        @BindView(R.id.order_item_ll2_guigeName)
        TextView orderItemLl2GuigeName;
        @BindView(R.id.tv_pro_name)
        TextView tvProName;
        @BindView(R.id.order_item_ll2)
        LinearLayout orderItemLl2;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.priority)
        TextView priority;
        @BindView(R.id.tv_priority)
        TextView tvPriority;
        @BindView(R.id.order_item_ll3)
        LinearLayout orderItemLl3;
        @BindView(R.id.response)
        TextView response;
        @BindView(R.id.tv_response)
        TextView tvResponse;
        @BindView(R.id.tv_my_task)
        TextView tvMyTask;
        @BindView(R.id.tv_my_task_num)
        TextView tvMyTaskNum;
        @BindView(R.id.order_item)
        LinearLayout orderItem;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.tv_companyName)
        TextView tvCompanyName;
        @BindView(R.id.tv_master)
        TextView tvMaster;
        @BindView(R.id.tv_order_time)
        TextView tvOrderTime;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.order_item_ll)
        RelativeLayout orderItemLl;
        @BindView(R.id.tv_in)
        TextView tvIn;
        @BindView(R.id.tv_out)
        TextView tvOut;
        @BindView(R.id.tv_deliver)
        TextView tvDeliver;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
