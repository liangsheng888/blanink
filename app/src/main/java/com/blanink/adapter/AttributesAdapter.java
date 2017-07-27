package com.blanink.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.RelIndustryCategoryAttribute;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 * 产品属性adapter
 */

public class AttributesAdapter extends BaseAdapter {
    private List<RelIndustryCategoryAttribute.ResultBean> attributeLists;
    private Context context;

    public AttributesAdapter(Context context,List<RelIndustryCategoryAttribute.ResultBean> attributeLists) {
        this.attributeLists = attributeLists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return attributeLists.size();
    }

    @Override
    public Object getItem(int position) {
        return attributeLists.get(position);
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
            convertView = View.inflate(context, R.layout.attributes, null);
            viewHolder.tv_attribute_name = (TextView) convertView.findViewById(R.id.tv_attribute_name);
            viewHolder.sp_attribute_value = (Spinner) convertView.findViewById(R.id.sp_attribute_value);
            viewHolder.attribute_name = (TextView) convertView.findViewById(R.id.attribute_name);
            viewHolder.et_attribute = (EditText) convertView.findViewById(R.id.et_attribute);
            viewHolder.rl_edt = (LinearLayout) convertView.findViewById(R.id.rl_edt);
            viewHolder.rl_sp = (LinearLayout) convertView.findViewById(R.id.rl_sp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        if (attributeLists.get(position).getInputType().equals("1")) {
            //文本框
             viewHolder.rl_sp.setVisibility(View.GONE);
            viewHolder.rl_edt.setVisibility(View.VISIBLE);
            viewHolder.et_attribute.setText(attributeLists.get(position).getHardcodeValue());
            viewHolder.attribute_name.setText(attributeLists.get(position).getAttribute().getName()+":");
        } else {
            //下拉框
            viewHolder.rl_edt.setVisibility(View.GONE);
            viewHolder.rl_sp.setVisibility(View.VISIBLE);
            viewHolder.tv_attribute_name.setText(attributeLists.get(position).getAttribute().getName()+":");
            viewHolder.sp_attribute_value.setAdapter(new ArrayAdapter<String>(context,R.layout.spanner_item,attributeLists.get(position).getHardcodeValue().split(",")));
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tv_attribute_name;
        Spinner sp_attribute_value;
        TextView attribute_name;
        EditText et_attribute;
        LinearLayout rl_sp;
        LinearLayout rl_edt;
    }
}

