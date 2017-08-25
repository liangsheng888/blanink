package com.blanink.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.blanink.R;
import com.blanink.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/25 0025.
 */
public class CertificateAdapter extends BaseAdapter {
    private Context context;
    private List<String> stringList;
    private SparseArray<View> sparseArray;

    public CertificateAdapter(Context context, List<String> stringList) {
        this.stringList = stringList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        sparseArray=new SparseArray<>();
        ViewHolder viewHolder=null;
        if(sparseArray.get(position,null)==null){
           convertView= View.inflate(context, R.layout.item_certificate, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            sparseArray.put(position,convertView);

        }else {
            convertView=sparseArray.get(position);
            viewHolder=(ViewHolder)convertView.getTag();

        }
        GlideUtils.glideImageView(context,viewHolder.iv,stringList.get(position),false);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
