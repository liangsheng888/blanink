package com.blanink.adpater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.blanink.activity.task.TaskResponseDetailActivity;
import com.blanink.pojo.FeedBackingTask;

import java.util.List;

/**
 * Created by dliu on 2016/9/30.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    Context context;
    List<T> lists;
    int layoutId;
    int size;

    public CommonAdapter(Context context, List<T> lists, int layoutId) {

        this.context = context;
        this.lists = lists;
        this.layoutId = layoutId;
        this.size = (lists==null?0:lists.size());
    }

    /***
     *
     * @param context 上下文
     * @param lists  资源集合
     * @param layoutId  显示item
     * @param length 显示条目个数
     */
    public CommonAdapter(Context context, List<T> lists, int layoutId, int length) {

        this.context = context;
        this.lists = lists;
        this.layoutId = layoutId;
        if (length > lists.size()) {
            this.size = lists.size();
        } else {
            this.size = length;
        }

    }

    @Override
    public int getCount() {
        return (lists != null) ? size : 0;
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);//每个item的数据源
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //找到控件，赋值
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = ViewHolder.get(context, layoutId, convertView, parent);
        convert(viewHolder, lists.get(position), position);
        return viewHolder.getConvertView();
    }
    //取出控件，赋值
    public abstract void convert(ViewHolder viewHolder, T t, int position);

}
