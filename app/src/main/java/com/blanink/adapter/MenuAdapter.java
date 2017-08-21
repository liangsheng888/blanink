package com.blanink.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglua on 15/5/31.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.PhotoViewHolder> {

    private List<String> menuList = new ArrayList<String>();
    private LayoutInflater inflater;
    private Context mContext;

    public MenuAdapter(Context mContext, List<String> menuList) {
        this.menuList = menuList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = inflater.inflate(R.layout.item_menu, parent, false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {
        holder.tvMenu.setText(menuList.get(position));
        //招标管理，投标管理，客户管理，供应商管理，工作反馈，任务分工，采购管理，订单管理，排流程，售后处理，我的售后，收货，报表，工作记录
        if ("招标管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.zb);
        }
        if ("投标管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.tb);
        }
        if ("客户管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.kh);

        }
        if ("供应商管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.hzgl);

        }
        if ("工作反馈".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.gzfk);

        }
        if ("任务分工".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.jt);

        }
        if ("采购管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.qd);

        }
        if ("订单管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.ld);

        }
        if ("排流程".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.plc);

        }
        if ("售后处理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.shgl);

        }
        if ("我的售后".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.wdsh);

        }
        if ("收货".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.sh);

        }
        if ("报表".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.bb);

        }
        if ("工作记录".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.gzjl);

        }
        if ("仓库管理".equals(menuList.get(position))) {
            holder.ivMenu.setImageResource(R.drawable.stock);

        }

    }


    @Override
    public int getItemCount() {
        if(menuList==null){
            menuList=new ArrayList<>();
        }
        int count = menuList.size();
        return count;
    }


    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMenu;
        private ImageView ivMenu;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            tvMenu = (TextView) itemView.findViewById(R.id.tv_menu);
            ivMenu = (ImageView) itemView.findViewById(R.id.iv_menu);

        }

    }
}
