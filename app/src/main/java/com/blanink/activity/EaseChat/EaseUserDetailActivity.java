package com.blanink.activity.EaseChat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.Constant;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 用户详情
 */
public class EaseUserDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_last)
    TextView ivLast;
    @BindView(R.id.tender_manager)
    RelativeLayout tenderManager;
    @BindView(R.id.iv_user_photo)
    ImageView ivUserPhoto;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.rl_photo)
    RelativeLayout rlPhoto;
    @BindView(R.id.company)
    TextView company;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.role)
    TextView role;
    @BindView(R.id.tv_role)
    TextView tvRole;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_detail)
    LinearLayout rlDetail;
    @BindView(R.id.video_call)
    TextView videoCall;
    @BindView(R.id.chat)
    TextView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ease_user_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        if("chat".equals(getIntent().getStringExtra("flag"))){
            videoCall.setVisibility(View.GONE);
            chat.setVisibility(View.GONE);
        }
        seekUser(getIntent().getStringExtra("userId"));
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EaseUserDetailActivity.this,EaseChatActivity.class);
                intent.putExtra("userId", getIntent().getStringExtra("userId"));
                intent.putExtra("chatType", Constant.CHATTYPE_SINGLE);
                startActivity(intent);
            }
        });
        videoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceCall(getIntent().getStringExtra("userId"));
            }
        });
        ivLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void seekUser(String id) {
        String url = NetUrlUtils.NET_URL + "user";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("id", id).build();
        Request request = new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final LoginResult loginResult = gson.fromJson(result, LoginResult.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GlideUtils.glideImageView(EaseUserDetailActivity.this,ivUserPhoto,loginResult.getResult().getPhoto(),true);
                        tvUserName.setText(loginResult.getResult().getName());
                        tvAddress.setText(loginResult.getResult().getCompany().getAddress());
                        tvArea.setText(loginResult.getResult().getCompany().getArea().getName());
                        tvCompany.setText(loginResult.getResult().getCompany().getName());
                        tvRole.setText(loginResult.getResult().getRoleNames());
                        tvPhone.setText(loginResult.getResult().getPhone());
                    }
                });

            }
        });
    }

    protected void startVoiceCall(String userId) {
        if (!EMClient.getInstance().isConnected()) {
            Toast.makeText(EaseUserDetailActivity.this, R.string.not_connect_to_server, Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(EaseUserDetailActivity.this, VoiceCallActivity.class).putExtra("username", userId)
                    .putExtra("isComingCall", false));
            // voiceCallBtn.setEnabled(false);
        }
    }
}
