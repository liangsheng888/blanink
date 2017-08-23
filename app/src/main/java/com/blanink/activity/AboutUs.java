package com.blanink.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blanink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUs extends AppCompatActivity {

    @BindView(R.id.come_order_tv_seek)
    TextView comeOrderTvSeek;
    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.come_order)
    RelativeLayout comeOrder;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    private String msg="     “空行”是微小型实体企业（尤其是制造业）的协同制造平台，将我国企业推向工业4.0的过度的承载平台，包含企业之间的协同配合与企业内部的运营管理，可适应几乎所有行业。对企业外部管理，解决了企业的“猪一样的队友”问题；对企业内部管理，解决了“企业快速发展的瓶颈因素”。对于想“长久存活”、“做大做强”，且“原意付出努力”的企业具有绝对的帮助\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
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

        tvMsg.setText(msg);
    }
}
