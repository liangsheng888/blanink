package com.blanink.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.Emp;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 * 公司员工适配器
 */
public class EmpAdapter extends BaseAdapter {
    List<Emp> EmpList;
    Context context;

    public EmpAdapter(Context context, List<Emp> EmpList) {
        this.context = context;
        this.EmpList = EmpList;
    }

    @Override
    public int getCount() {
        return EmpList.size();
    }

    @Override
    public Object getItem(int position) {
        return EmpList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item_receiver_name, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        ImageView iv_del = (ImageView) view.findViewById(R.id.iv_del);
        textView.setText(EmpList.get(position).getEmpName());
        iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmpList.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}