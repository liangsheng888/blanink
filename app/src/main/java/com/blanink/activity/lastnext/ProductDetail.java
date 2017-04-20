package com.blanink.activity.lastNext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.pojo.CompanyProduct;
import com.blanink.utils.MyActivityManager;
import com.blanink.view.MyPager;
import com.blanink.view.MyViewPager;
import com.blanink.view.NoScrollGridview;

import java.util.HashMap;
import java.util.Map;

import static com.blanink.R.id.iv_product_picture;

/***
 * 产品详情
 */
public class ProductDetail extends AppCompatActivity {
    private CompanyProduct.Result.Row row;
    private TextView activity_product_detail_iv_last;
    private MyActivityManager myActivityManager;
    private TextView tv_product_name;
    private TextView tv_price;
    private TextView tv_remark;
    private NoScrollGridview gv_keyField;
    private Map<String, String> map = new HashMap<>();
    private MyPager iv_product_picture;
    private Map<Integer, Map<String, String>> maps = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedIntent();
        initView();
        initData();
    }

    private void receivedIntent() {
        Intent intent = getIntent();
        row = (CompanyProduct.Result.Row) intent.getExtras().getSerializable("ProductDetail");
        Log.e("ProductDetail", row.toString());
        map.putAll(row.map);
        Integer index = 0;
        Log.e("ProductDetail","map："+ map.toString());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
           Map<String, String> mapNew = new HashMap<>();
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
            mapNew.put(entry.getKey(), entry.getValue());
            maps.put(index, mapNew);
            index++;
        }
        Log.e("ProductDetail", "maps:" + maps.toString());
    }

    private void initView() {
        activity_product_detail_iv_last = ((TextView) findViewById(R.id.activity_product_detail_iv_last));
        tv_product_name = ((TextView) findViewById(R.id.tv_product_name));
        tv_price = ((TextView) findViewById(R.id.tv_price));
        iv_product_picture = ((MyPager) findViewById(R.id.iv_product_picture));
        tv_remark = ((TextView) findViewById(R.id.tv_remark));
        gv_keyField = ((NoScrollGridview) findViewById(R.id.gv_keyField));
    }

    private void initData() {
        activity_product_detail_iv_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //setData
        tv_product_name.setText(row.productName);
        tv_price.setText(row.productPriceDownline + "-" + row.productPriceHighline);
        tv_remark.setText(row.remarks);
        //属性
        gv_keyField.setAdapter(new MapAdapter());
        String[] pics=row.productPhotos.split(",");
        iv_product_picture.pictureRoll(pics);//显示图片
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    class MapAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return maps.size();
        }

        @Override
        public Object getItem(int position) {
            return maps.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(ProductDetail.this, R.layout.item_product_attribute, null);
            TextView tv_attribute_name = (TextView) view.findViewById(R.id.tv_attribute_name);
            TextView tv_attribute_value = (TextView) view.findViewById(R.id.tv_attribute_value);
            Map<String,String> map = maps.get(position);
            Log.e("ProductDetail","getView："+map.toString()+"map.size():"+maps.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                //entry.getKey() ;entry.getValue(); entry.setValue();
                //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
                System.out.println("key= " + entry.getKey() + " and value= "
                        + entry.getValue());
                tv_attribute_name.setText(entry.getKey()+":");
                tv_attribute_value.setText(entry.getValue());

            }
            return view;
        }
    }
}
