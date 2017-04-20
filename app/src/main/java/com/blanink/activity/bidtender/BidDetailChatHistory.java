package com.blanink.activity.bidTender;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.adapter.ChatMsgViewAdapter;
import com.blanink.pojo.TalkHistoryLog;
import com.blanink.pojo.ChatMsgEntity;
import com.blanink.utils.MyActivityManager;
import com.blanink.utils.NetUrlUtils;
import com.blanink.view.UpLoadListView;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * 投标详情 历史回复记录
 */
public class BidDetailChatHistory extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sp;
    private int pageNo = 1;
    private Button mBtnSend;// 发送btn
    private TextView mBtnBack;// 返回btn
    private EditText mEditTextContent;
    private UpLoadListView mListView;
    private ChatMsgViewAdapter mAdapter;// 消息视图的Adapter
    private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();// 消息对象数组
    private MyActivityManager myActivityManager;
    private TalkHistoryLog talkHistoryLog;
    private String bidId;
    private String inviteBidId;
    private boolean isHasData = true;//判断是否有数据
    private ChatMsgEntity entity = null;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mListView.completeRefresh(isHasData);
            if(mAdapter!=null)
            mAdapter.notifyDataSetChanged();
        }
    };
    private String contString;
    private String createBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);
        sp = getSharedPreferences("DATA", MODE_PRIVATE);
        myActivityManager = MyActivityManager.getInstance();
        myActivityManager.pushOneActivity(this);
        receivedBidDetail();
        initView();
        initData();
    }

    private void receivedBidDetail() {
        Intent intent = getIntent();
        bidId = intent.getStringExtra("bid.id");
        inviteBidId = intent.getStringExtra("inviteBid.id");
        createBy = intent.getStringExtra("createBy");
        Log.e("BidDetailChatHistory","createBy:"+createBy);
    }

    private void initView() {
        mListView = (UpLoadListView) findViewById(R.id.listview);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
            mBtnBack = (TextView) findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(this);
        mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);

    }

    private void initData() {
        loadChatLogFromServer();
        mListView.setOnRefreshListener(new UpLoadListView.OnRefreshListener() {
            @Override
            public void onLoadingMore() {
                pageNo++;
                loadChatLogFromServer();
            }
        });
    }

    public void loadChatLogFromServer() {
        RequestParams requestParams = new RequestParams(NetUrlUtils.NET_URL + "inviteBid/bidReturn");
        requestParams.addBodyParameter("userId", sp.getString("USER_ID", null));
        requestParams.addBodyParameter("bid.id", bidId);
        requestParams.addBodyParameter("inviteBid.id", inviteBidId);
        requestParams.addBodyParameter("pageNo", pageNo + "");
        x.http().post(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("BidDetailChatHistory", "chatNote:" + result);
                Gson gson = new Gson();
                talkHistoryLog = gson.fromJson(result, TalkHistoryLog.class);
                Log.e("BidDetailChatHistory", "talkHistoryLog:" + talkHistoryLog.toString());
                if (talkHistoryLog.result.total <= mDataArrays.size()) {
                    isHasData = false;
                } else {
                    for (TalkHistoryLog.Result.Row row :
                            talkHistoryLog.result.rows) {
                        entity=new ChatMsgEntity();
                        if (row.createBy.id.equals(sp.getString("USER_ID", null))) {
                            entity.setName(sp.getString("LOGIN_NAME", ""));
                            entity.setMsgType(false);// 自己发送的消息
                        } else {
                            entity.setName(row.receiveUser.name);
                            entity.setMsgType(true);
                        }
                        Log.e("BidDetailChatHistory","receiverId:"+row.receiveUser.id+"userId:"+sp.getString("USER_ID",null));
                        entity.setMessage(row.message);
                        entity.setDate(row.createDate);
                        mDataArrays.add(entity);
                    }
                }
                Log.e("BidDetailChatHistory","mDataArrays:"+mDataArrays.toString());
                if(mAdapter==null){
                    mAdapter = new ChatMsgViewAdapter(BidDetailChatHistory.this, mDataArrays);
                    mListView.setAdapter(mAdapter);
                }else {
                    mAdapter.notifyDataSetChanged();
                }
              handler.sendEmptyMessage(0);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myActivityManager.popOneActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:// 发送按钮点击事件
                send();
                break;
            case R.id.btn_back:// 返回按钮点击事件
                finish();// 结束,实际开发中，可以返回主界面
                break;
        }
    }

    /**
     * 发送消息
     */
    private void send() {
        contString = mEditTextContent.getText().toString();
        if (contString.length() > 0) {
            ChatMsgEntity entity = new ChatMsgEntity();
            entity.setName(sp.getString("LOGIN_NAME",null));
            entity.setDate(getDate());
            entity.setMessage(contString);
            entity.setMsgType(false);
            mDataArrays.add(0,entity);
            mAdapter.notifyDataSetChanged();// 通知ListView，数据已发生改变
            mEditTextContent.setText("");// 清空编辑框数据
            mListView.setSelection(0);// 发送一条消息时，ListView显示选择最后一项

            loadMessagetoServer();
        }

    }

    /**
     * 发送消息时，获取当前事件
     *
     * @return 当前时间
     */
    private String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(new Date());
    }

    public void loadMessagetoServer(){
        //http://localhost:8080/blanink-api/inviteBid/bidAddReturn?
        // currentUser.id=f4a9e8882339458ba7d03ace8ca93aad&
        // inviteBid.id=e4cbdfe0cd72434f8823714714e48d71&
        // bid.id=5d7034f285404e9fba4016b1489f84a5&
        // message=哈哈哈哈哈哈哈哈&
        // attachment
        // &title
        // &receiveUser=fec25c7f7634448581e21876ef517c57
        RequestParams rp=new RequestParams(NetUrlUtils.NET_URL+"inviteBid/bidAddReturn");
        rp.addBodyParameter("currentUser.id",sp.getString("USER_ID",null));
        rp.addBodyParameter("inviteBid.id",inviteBidId);
        rp.addBodyParameter("bid.id",bidId);
        if(talkHistoryLog.result.rows.size()==0){
            rp.addBodyParameter("receiveUser",createBy);
        }else {
            rp.addBodyParameter("receiveUser",talkHistoryLog.result.rows.get(0).createBy.id);
            Log.e("BidDetailChatHistory","senddata:["+"createBy："+talkHistoryLog.result.rows.get(0).createBy.id+"]");
        }

        rp.addBodyParameter("message",contString);
       // Log.e("BidDetailChatHistory","senddata:["+"receiveUser："+talkHistoryLog.result.rows.get(0).receiveUser.id+",message:"+contString+"]");
        x.http().post(rp, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("BidDetailChatHistory","send:"+result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("BidDetailChatHistory","error"+ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

}
