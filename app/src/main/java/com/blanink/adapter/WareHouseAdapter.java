package com.blanink.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.stock.WareHouseAdd;
import com.blanink.activity.stock.WareHouseModify;
import com.blanink.pojo.ResponseDelete;
import com.blanink.pojo.Stock;
import com.blanink.utils.DialogLoadUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class WareHouseAdapter extends BaseAdapter {
    private Context context;
    private List<Stock.ResultBean.RowsBean> srr;
    private SparseArray<View> sparseArray;

    public WareHouseAdapter(Context context, List<Stock.ResultBean.RowsBean> srr) {
        this.context = context;
        this.srr = srr;
    }

    @Override
    public int getCount() {
        return srr.size();
    }

    @Override
    public Object getItem(int position) {
        return srr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        sparseArray = new SparseArray<>();
        ViewHolder viewHolder=null;
        if (sparseArray.get(position, null) == null) {
            convertView = View.inflate(context, R.layout.item_ware_house, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            sparseArray.put(position,convertView);
        }else {
            convertView=sparseArray.get(position);
            viewHolder=(ViewHolder)convertView.getTag();
        }

        final Stock.ResultBean.RowsBean rowsBean = srr.get(position);
        viewHolder.tvNo.setText(rowsBean.getProcuteNumber());
        viewHolder.tvCategory.setText(rowsBean.getCompanyCategoryId().getName());
        viewHolder.tvNum.setText(rowsBean.getStok()+"");
        viewHolder.tvPrice.setText(rowsBean.getUnitPrice()+"元/"+rowsBean.getUnit());
        viewHolder.tvName.setText(rowsBean.getName());
        viewHolder.tvType.setText("1".equals(rowsBean.getInventoryType())?"原材料":"成品");
        viewHolder.tvModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, WareHouseModify.class);
                intent.putExtra("rowsBean",rowsBean);
                context.startActivity(intent);
            }

        });

        viewHolder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteNofity(rowsBean,position,"你真要删除吗","取消","确定");
            }

        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.no)
        TextView no;
        @BindView(R.id.tv_no)
        TextView tvNo;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.category)
        TextView category;
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.tv_delete)
        TextView tvDelete;
        @BindView(R.id.tv_modify)
        TextView tvModify;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


    private void delete(final Stock.ResultBean.RowsBean rb) {
        String url = NetUrlUtils.NET_URL + "companyInventory/delete";
        OkHttpClient ok = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", rb.getId())
                .build();
        final Request request = new Request.Builder().post(body).url(url).build();
        ok.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final ResponseDelete rd = gson.fromJson(result, ResponseDelete.class);
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DialogLoadUtils.dismissDialog();
                        if("00000".equals(rd.getErrorCode())){
                            srr.remove(rb);
                            notifyDataSetChanged();
                        }else {
                            Toast.makeText(context, "操作失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }


    private void deleteNofity(final Stock.ResultBean.RowsBean rb, final int position, String content, String left, String right) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_custom_exit);
        final Window window = alertDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        ((TextView) window.findViewById(R.id.tv_content)).setText(content);
        ((TextView) window.findViewById(R.id.tv_continue)).setText(left);
        ((TextView) window.findViewById(R.id.tv_exit)).setText(right);
        window.findViewById(R.id.tv_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        window.findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLoadUtils.getInstance(context);
                DialogLoadUtils.showDialogLoad("正在删除...");
                delete(rb);
                alertDialog.dismiss();
            }
        });
    }
}
