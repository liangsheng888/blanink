package com.blanink.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.AttachmentAdapter;
import com.blanink.adapter.GridSpacingItemDecoration;
import com.blanink.adapter.RecyclerItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * 附件列表
 */
public class AttachmentBrow extends AppCompatActivity {

    @BindView(R.id.come_order)
    TextView comeOrder;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order_detail_rl)
    RelativeLayout comeOrderDetailRl;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;
    @BindView(R.id.loading_error_img)
    ImageView loadingErrorImg;
    @BindView(R.id.rl_load_fail)
    RelativeLayout rlLoadFail;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.rl_not_data)
    RelativeLayout rlNotData;
    @BindView(R.id.fl_load)
    FrameLayout flLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attachment_brow);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final List<String> pics = new Gson().fromJson(getIntent().getStringExtra("imageList"), new TypeToken<List<String>>() {
        }.getType());
        Log.e("AttachmentBrow", pics.size()+""+pics.toString());
        if (pics.size()!=0) {
            llLoad.setVisibility(View.GONE);
            // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
            final ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.addAll(pics);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, getResources().getDimensionPixelSize(R.dimen.padding_middle), true));//设置间隙
            recyclerView.setAdapter(new AttachmentAdapter(AttachmentBrow.this, arrayList));
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(AttachmentBrow.this, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {


                    Intent intent = new Intent(AttachmentBrow.this, AttachmentDownLoad.class);
                    intent.putExtra("url", arrayList.get(position));
                    startActivity(intent);


                }


            }));
        }else {
            llLoad.setVisibility(View.GONE);
            rlNotData.setVisibility(View.VISIBLE);
            tvNot.setText("附件库空空的");
        }
    }
}
