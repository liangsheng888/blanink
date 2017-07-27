package com.blanink.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.afterSale.AfterSaleToHandle;
import com.blanink.pojo.AfterSaleHistory;
import com.blanink.pojo.AfterSales;
import com.blanink.pojo.OrderProductStatus;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.OrderProductStateUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 * /售后处理记录
 */
public class AfterSaleAdapter extends BaseAdapter {
    private Context context;
    private SparseArray<View> sparseArray = new SparseArray<>();
    ;
    private List<AfterSaleHistory.ResultBean.RowsBean> afterSalesList;

    public AfterSaleAdapter(Activity context, List<AfterSaleHistory.ResultBean.RowsBean> afterSalesList) {
        this.context = context;
        this.afterSalesList = afterSalesList;
    }

    @Override
    public int getCount() {
        return afterSalesList.size();
    }

    @Override
    public Object getItem(int position) {
        return afterSalesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (sparseArray.get(position, null) == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_sale_history_queue, null);
            viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name);
            viewHolder.tv_is_phone = (TextView) convertView.findViewById(R.id.tv_is_phone);

            viewHolder.tv_state = (TextView) convertView.findViewById(R.id.tv_state);

            viewHolder.tv_user = (TextView) convertView.findViewById(R.id.tv_user);

            viewHolder.tv_note = (TextView) convertView.findViewById(R.id.tv_note);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);
            convertView.setTag(viewHolder);
            sparseArray.put(position, convertView);
        } else {
            convertView = sparseArray.get(position);
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final AfterSaleHistory.ResultBean.RowsBean rb = afterSalesList.get(position);
        viewHolder.tv_user.setText(rb.getCreateBy().getName());
        viewHolder.tv_product_name.setText(rb.getCompany().getName());
        if("1".equals(rb.getSolution())){
            viewHolder.tv_state.setTextColor(context.getResources().getColor(R.color.colorBlue));
        }
        if("2".equals(rb.getSolution())){
            viewHolder.tv_state.setTextColor(context.getResources().getColor(R.color.colorAccent));

        }
        viewHolder.tv_time.setText(DateUtils.format(DateUtils.stringToDate(rb.getCreateDate())));
        viewHolder.tv_state.setText("1".equals(rb.getSolution())?"整改":"退货");
        viewHolder.tv_is_phone.setText("1".equals(rb.getIsCalled())?"是":"否");
        viewHolder.tv_note.setText(rb.getRemarks());
        GlideUtils.glideImageView(context,viewHolder.iv_photo,rb.getCompany().getPhoto(),true);
        return convertView;
    }

    static class ViewHolder {
        TextView tv_product_name;
        TextView tv_is_phone;
        TextView tv_state;
        TextView tv_note;
        TextView tv_user;
        ImageView iv_photo;
        TextView tv_time;

    }
}
