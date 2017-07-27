package com.blanink.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.ResponseHistory;
import com.blanink.utils.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 * 员工反馈适配器
 */
public class ResponseAdapter extends BaseAdapter {
    private Context context;
    private List<ResponseHistory.ResultBean.RowsBean> rowsBeenList;

    public ResponseAdapter(Context context, List<ResponseHistory.ResultBean.RowsBean> rowsBeenList) {
        this.context = context;
        this.rowsBeenList = rowsBeenList;
    }

    @Override
    public int getCount() {
        return rowsBeenList.size();
    }

    @Override
    public Object getItem(int position) {
        return rowsBeenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_task_response, null);
            viewHolder.companyName = (TextView) convertView.findViewById(R.id.tv_companyName);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_pro_name = (TextView) convertView.findViewById(R.id.tv_pro_name);
            viewHolder.tv_feedBack_user = (TextView) convertView.findViewById(R.id.tv_feedBack_user);
            viewHolder.tv_response = (TextView) convertView.findViewById(R.id.tv_response);
            viewHolder.tv_bad = (TextView) convertView.findViewById(R.id.tv_bad);
            viewHolder.tv_note = (TextView) convertView.findViewById(R.id.tv_note);
            viewHolder.iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ResponseHistory.ResultBean.RowsBean rowsBean = rowsBeenList.get(position);
        viewHolder.companyName.setText(rowsBean.getACompany().getShortName());
        viewHolder.tv_time.setText(rowsBean.getCreateDate());
        viewHolder.tv_bad.setText(rowsBean.getFaultAmount() + "");
        viewHolder.tv_response.setText(rowsBean.getAchieveAmount() + "");
        if (rowsBean.getFeedbackUser() != null) {
            viewHolder.tv_feedBack_user.setText(rowsBean.getFeedbackUser().getName());
        }
        viewHolder.tv_pro_name.setText(rowsBean.getOrderProduct().getProductName());
        viewHolder.tv_note.setText(rowsBean.getRemarks());
        if (rowsBean.getFeedbackUser() != null) {
            GlideUtils.glideImageView(context, viewHolder.iv_photo, rowsBean.getFeedbackUser().getPhoto(), true);
        }
        return convertView;
    }

    static class ViewHolder {
        TextView companyName;
        TextView tv_time;
        TextView tv_pro_name;
        TextView tv_feedBack_user;
        TextView tv_response;
        TextView tv_bad;
        TextView tv_note;
        ImageView iv_photo;
    }
}
