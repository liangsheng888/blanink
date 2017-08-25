package com.blanink.activity.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.activity.AttachmentBrow;
import com.blanink.pojo.ResponseHistory;
import com.blanink.utils.StringToListUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkResponseHistoryDetail extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.tv_pro_category)
    TextView tvProCategory;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.order_item_ll2)
    LinearLayout orderItemLl2;
    @BindView(R.id.order_item_ll2_guigeName)
    TextView orderItemLl2GuigeName;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.task)
    TextView task;
    @BindView(R.id.tv_target)
    TextView tvTarget;
    @BindView(R.id.response)
    TextView response;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.tv_my_task)
    TextView tvMyTask;
    @BindView(R.id.bad_num)
    TextView badNum;
    @BindView(R.id.attactment)
    TextView attactment;
    @BindView(R.id.tv_attactment)
    TextView tvAttactment;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.note)
    TextView note;
    @BindView(R.id.tv_note)
    TextView tvNote;
    private ResponseHistory.ResultBean.RowsBean detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_response_history_detail);
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
        detail = ((ResponseHistory.ResultBean.RowsBean) getIntent().getSerializableExtra("Detail"));
        tvTarget.setText(detail.getTarget() + "");
        tvResponse.setText(detail.getAchieveAmount() + "");
        badNum.setText(detail.getFaultAmount() + "");
        tvNote.setText(detail.getRemarks());
        tvTime.setText(detail.getCreateDate());
        tvProName.setText(detail.getOrderProduct().getProductName());
        tvProCategory.setText(detail.getOrderProduct().getCompanyCategory().getName());
        tvNum.setText(detail.getOrderProduct().getAmount());
        List<String> arrayList = null;
        if (detail.getFeedbackAttachmentStr() != null && detail.getFeedbackAttachmentStr() != "" && !"".equals(detail.getFeedbackAttachmentStr())) {
            arrayList = StringToListUtils.stringToList(detail.getFeedbackAttachmentStr(), ",");
        } else {
            arrayList = new ArrayList<>();
        }

        final List<String> finalArrayList = arrayList;
        if (arrayList.size() == 0) {
            tvAttactment.setText("无附件");
        } else {
            tvAttactment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WorkResponseHistoryDetail.this, AttachmentBrow.class);
                    intent.putExtra("imageList", new Gson().toJson(finalArrayList));
                    startActivity(intent);
                }
            });
        }

    }
}
