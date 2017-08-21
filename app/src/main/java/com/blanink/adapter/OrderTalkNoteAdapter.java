package com.blanink.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.OrderProductRemark;
import com.blanink.utils.DateUtils;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.XUtilsImageUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class OrderTalkNoteAdapter extends BaseAdapter {
    private SparseArray<View> sparseArray;
    private Context context;
    List<OrderProductRemark.ResultBean> remarkList;

    public OrderTalkNoteAdapter(Context context, List<OrderProductRemark.ResultBean> remarkList) {
        this.context = context;
        this.remarkList = remarkList;
    }

    @Override
    public int getCount() {
        return remarkList.size();
    }

    @Override
    public Object getItem(int position) {
        return remarkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderProductRemark.ResultBean resultBean = remarkList.get(position);
        ViewHolder viewHolder = null;
       sparseArray =new SparseArray<>();
        if (sparseArray.get(position,null)==null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_order_product_remark, null);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv_photo);
            viewHolder.tv_company = (TextView) convertView.findViewById(R.id.tv_company);
            viewHolder.tv_user = (TextView) convertView.findViewById(R.id.tv_user);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_message = (TextView) convertView.findViewById(R.id.tv_message);
            viewHolder.tv_type = (TextView) convertView.findViewById(R.id.tv_note_type);
            convertView.setTag(viewHolder);
            sparseArray.put(position,convertView);
        } else {
            convertView=sparseArray.get(position);
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (resultBean.getSenderCompany() != null) {
            viewHolder.tv_company.setText(resultBean.getSenderCompany().getName());
            GlideUtils.glideImageView(context,viewHolder.iv, resultBean.getSenderCompany().getPhoto(), true);
        }
        viewHolder.tv_user.setText(resultBean.getSender().getName());
        viewHolder.tv_time.setText(DateUtils.format(DateUtils.stringToDate(resultBean.getCreateDate())));
        viewHolder.tv_message.setText(resultBean.getComments());
        if ("1".equals(resultBean.getType())) {
            viewHolder.tv_type.setVisibility(View.VISIBLE);
        }


        return convertView;
    }


    static class ViewHolder {
        ImageView iv;
        TextView tv_company;
        TextView tv_user;
        TextView tv_time;
        TextView tv_message;
        TextView tv_type;
    }
}
