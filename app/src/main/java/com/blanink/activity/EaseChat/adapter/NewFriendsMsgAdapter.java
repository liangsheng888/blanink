/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blanink.activity.EaseChat.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.EaseChat.modle.DemoHelper;
import com.blanink.activity.EaseChat.domain.InviteMessage;
import com.blanink.activity.EaseChat.modle.InviteMessgeDao;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewFriendsMsgAdapter extends ArrayAdapter<InviteMessage> {

    private Context context;
    private InviteMessgeDao messgeDao;
    Boolean isSingleChat;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    private LoginResult loginResult;
    private String str="";

    public NewFriendsMsgAdapter(Context context, int textViewResourceId, List<InviteMessage> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        messgeDao = new InviteMessgeDao(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.em_row_invite_msg, null);
            holder.avator = (ImageView) convertView.findViewById(R.id.avatar);
            holder.reason = (TextView) convertView.findViewById(R.id.message);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.agree = (Button) convertView.findViewById(R.id.agree);
            holder.status = (Button) convertView.findViewById(R.id.user_state);
            holder.groupContainer = (LinearLayout) convertView.findViewById(R.id.ll_group);
            holder.groupname = (TextView) convertView.findViewById(R.id.tv_groupName);
            // holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        str1 = context.getResources().getString(R.string.Has_agreed_to_your_friend_request);
        str2 = context.getResources().getString(R.string.agree);

        str3 = context.getResources().getString(R.string.Request_to_add_you_as_a_friend);
        str4 = context.getResources().getString(R.string.Apply_to_the_group_of);
        str5 = context.getResources().getString(R.string.Has_agreed_to);
        str6 = context.getResources().getString(R.string.Has_refused_to);

        str7 = context.getResources().getString(R.string.refuse);
        str8 = context.getResources().getString(R.string.invite_join_group);
        str9 = context.getResources().getString(R.string.accept_join_group);
        str10 = context.getResources().getString(R.string.refuse_join_group);

        final InviteMessage msg = getItem(position);
        if (msg != null) {

            holder.agree.setVisibility(View.INVISIBLE);

            if(msg.getGroupId() != null){ // show group name
                holder.groupContainer.setVisibility(View.VISIBLE);
                holder.groupname.setText(msg.getGroupName());
            } else{
                holder.groupContainer.setVisibility(View.GONE);
            }

            holder.reason.setText(msg.getReason());
            seekUser(msg.getFrom(),holder);
            // holder.time.setText(DateUtils.getTimestampString(new
            // Date(msg.getTime())));
            if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEAGREED) {
                holder.status.setVisibility(View.INVISIBLE);
                holder.reason.setText(str1);
            } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEINVITEED || msg.getStatus() == InviteMessage.InviteMesageStatus.BEAPPLYED ||
                    msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION) {
                holder.agree.setVisibility(View.VISIBLE);
                holder.agree.setEnabled(true);
                holder.agree.setBackgroundResource(android.R.drawable.btn_default);
                holder.agree.setText(str2);

                holder.status.setVisibility(View.VISIBLE);
                holder.status.setEnabled(true);
                holder.status.setBackgroundResource(android.R.drawable.btn_default);
                holder.status.setText(str7);
                if(msg.getStatus() == InviteMessage.InviteMesageStatus.BEINVITEED){
                    if (msg.getReason() == null) {
                        // use default text
                        holder.reason.setText(str3);
                    }
                }else if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEAPPLYED) { //application to join group
                    if (TextUtils.isEmpty(msg.getReason())) {
                        holder.reason.setText(str4 + msg.getGroupName());
                    }
                } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION) {
                    if (TextUtils.isEmpty(msg.getReason())) {
                        holder.reason.setText(str8 + msg.getGroupName());
                    }
                }

                // set click listener
                holder.agree.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // accept invitation
                        acceptInvitation(holder.agree, holder.status, msg);
                    }
                });
                holder.status.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // decline invitation
                        refuseInvitation(holder.agree, holder.status, msg);
                    }
                });
            } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.AGREED) {
                holder.status.setText(str5);
                holder.status.setBackgroundDrawable(null);
                holder.status.setEnabled(false);
            } else if(msg.getStatus() == InviteMessage.InviteMesageStatus.REFUSED){
                holder.status.setText(str6);
                holder.status.setBackgroundDrawable(null);
                holder.status.setEnabled(false);
            } else if(msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION_ACCEPTED){
                String str =str9 + msg.getGroupName();
                seekUser(msg.getGroupInviter(),holder,str);

            } else if(msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION_DECLINED){
                String str = str10 + msg.getGroupName();
                seekUser(msg.getGroupInviter(),holder,str);

            }
        }

        return convertView;
    }

    /**
     * accept invitation
     *
     * @param
     * @param
     */
    private void acceptInvitation(final Button buttonAgree, final Button buttonRefuse, final InviteMessage msg) {
        final ProgressDialog pd = new ProgressDialog(context);
        String str1 = context.getResources().getString(R.string.Are_agree_with);
        final String str2 = context.getResources().getString(R.string.Has_agreed_to);
        final String str3 = context.getResources().getString(R.string.Agree_with_failure);
        pd.setMessage(str1);
        pd.setCanceledOnTouchOutside(false);
        pd.show();

        new Thread(new Runnable() {
            public void run() {
                // call api
                try {
                    if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEINVITEED) {//accept be friends
                        EMClient.getInstance().contactManager().acceptInvitation(msg.getFrom());
                        //保存联系人到数据库
                        com.hyphenate.easeui.domain.EaseUser user=new com.hyphenate.easeui.domain.EaseUser(msg.getFrom());
                        user.setNick(loginResult.getResult().getName());
                        user.setAvatar(loginResult.getResult().getPhoto());
                        DemoHelper.getInstance().saveContact(user);
                        DemoHelper.getInstance().getContactList().put(user.getUsername(),user);
                    } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEAPPLYED) { //accept application to join group
                        EMClient.getInstance().groupManager().acceptApplication(msg.getFrom(), msg.getGroupId());

                    } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION) {
                        EMClient.getInstance().groupManager().acceptInvitation(msg.getGroupId(), msg.getGroupInviter());
                    }
                    msg.setStatus(InviteMessage.InviteMesageStatus.AGREED);
                    // update database
                    ContentValues values = new ContentValues();
                    values.put(InviteMessgeDao.COLUMN_NAME_STATUS, msg.getStatus().ordinal());
                    messgeDao.updateMessage(msg.getId(), values);
                    ((Activity) context).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            pd.dismiss();
                            buttonAgree.setText(str2);
                            buttonAgree.setBackgroundDrawable(null);
                            buttonAgree.setEnabled(false);

                            buttonRefuse.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (final Exception e) {
                    ((Activity) context).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            pd.dismiss();
                            Toast.makeText(context, str3 + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        }).start();
    }

    /**
     * decline invitation
     *
     * @param
     * @param
     */
    private void refuseInvitation(final Button buttonAgree, final Button buttonRefuse, final InviteMessage msg) {
        final ProgressDialog pd = new ProgressDialog(context);
        String str1 = context.getResources().getString(R.string.Are_refuse_with);
        final String str2 = context.getResources().getString(R.string.Has_refused_to);
        final String str3 = context.getResources().getString(R.string.Refuse_with_failure);
        pd.setMessage(str1);
        pd.setCanceledOnTouchOutside(false);
        pd.show();

        new Thread(new Runnable() {
            public void run() {
                // call api
                try {
                    if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEINVITEED) {//decline the invitation
                        EMClient.getInstance().contactManager().declineInvitation(msg.getFrom());
                    } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.BEAPPLYED) { //decline application to join group
                        EMClient.getInstance().groupManager().declineApplication(msg.getFrom(), msg.getGroupId(), "");
                    } else if (msg.getStatus() == InviteMessage.InviteMesageStatus.GROUPINVITATION) {
                        EMClient.getInstance().groupManager().declineInvitation(msg.getGroupId(), msg.getGroupInviter(), "");
                    }
                    msg.setStatus(InviteMessage.InviteMesageStatus.REFUSED);
                    // update database
                    ContentValues values = new ContentValues();
                    values.put(InviteMessgeDao.COLUMN_NAME_STATUS, msg.getStatus().ordinal());
                    messgeDao.updateMessage(msg.getId(), values);
                    ((Activity) context).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            pd.dismiss();
                            buttonRefuse.setText(str2);
                            buttonRefuse.setBackgroundDrawable(null);
                            buttonRefuse.setEnabled(false);

                            buttonAgree.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (final Exception e) {
                    ((Activity) context).runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            pd.dismiss();
                            Toast.makeText(context, str3 + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        }).start();
    }

    private static class ViewHolder {
        ImageView avator;
        TextView name;
        TextView reason;
        Button agree;
        Button status;
        LinearLayout groupContainer;
        TextView groupname;
        // TextView time;
    }

    public void seekUser(String id, final ViewHolder holder) {
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
                loginResult = gson.fromJson(result, LoginResult.class);
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (loginResult.getResult() != null) {
                            holder.name.setText(loginResult.getResult().getName());
                            GlideUtils.glideImageView(context, holder.avator, loginResult.getResult().getPhoto(), true);
                        }
                    }
                });
            }
        });
    }

    public void seekUser(String id, final ViewHolder holder, final String str) {
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
                loginResult = gson.fromJson(result, LoginResult.class);
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (loginResult.getResult() != null) {
                            holder.status.setText(loginResult.getResult().getName()+str);
                            holder.status.setBackgroundDrawable(null);
                            holder.status.setEnabled(false);
                        }
                    }
                });
            }
        });
    }
}

