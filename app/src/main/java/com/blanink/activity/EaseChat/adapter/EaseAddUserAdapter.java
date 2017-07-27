package com.blanink.activity.EaseChat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.EaseUser;
import com.blanink.utils.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class EaseAddUserAdapter extends BaseAdapter {
    private Context context;
    private List<EaseUser.ResultBean> userList;

    public EaseAddUserAdapter(Context context, List<EaseUser.ResultBean> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
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
            convertView = View.inflate(context, R.layout.item_user, null);
            viewHolder.add = (Button) convertView.findViewById(R.id.add);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = ((ViewHolder) convertView.getTag());
        }

        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        GlideUtils.glideImageView(context,viewHolder.iv_photo,userList.get(position).getPhoto(),true);
        viewHolder.name.setText(userList.get(position).getName());
        return convertView;
    }

    static class ViewHolder {
        Button add;
        ImageView iv_photo;
        TextView name;
    }


}
