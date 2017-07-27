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

package com.blanink.activity.EaseChat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.pojo.LoginResult;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupInfo;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.exceptions.HyphenateException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 群简单介绍
 */
public class GroupSimpleDetailActivity extends Activity {
    private Button btn_add_group;
    private TextView tv_admin;
    private TextView tv_name;
    private TextView tv_introduction;
    private EMGroup group;
    private String groupid;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_group_simle_details);
        tv_name = (TextView) findViewById(R.id.name);
        tv_admin = (TextView) findViewById(R.id.tv_admin);
        btn_add_group = (Button) findViewById(R.id.btn_add_to_group);
        tv_introduction = (TextView) findViewById(R.id.tv_introduction);
        progressBar = (ProgressBar) findViewById(R.id.loading);

        EMGroupInfo groupInfo = (EMGroupInfo) getIntent().getSerializableExtra("groupinfo");
        String groupname = null;
        if (groupInfo != null) {
            groupname = groupInfo.getGroupName();
            groupid = groupInfo.getGroupId();
        } else {
            group = PublicGroupsSeachActivity.searchedGroup;
            if (group == null)
                return;
            groupname = group.getGroupName();
            groupid = group.getGroupId();
        }

        tv_name.setText(groupname);


        if (group != null) {
            showGroupDetail();
            return;
        }
        new Thread(new Runnable() {

            public void run() {
                //get detail from server
                try {
                    group = EMClient.getInstance().groupManager().getGroupFromServer(groupid);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            showGroupDetail();
                        }
                    });
                } catch (final HyphenateException e) {
                    e.printStackTrace();
                    final String st1 = getResources().getString(R.string.Failed_to_get_group_chat_information);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(GroupSimpleDetailActivity.this, st1 + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        }).start();

    }

    //join the group
    public void addToGroup(View view) {
        String st1 = getResources().getString(R.string.Is_sending_a_request);
        final String st2 = getResources().getString(R.string.Request_to_join);
        final String st3 = getResources().getString(R.string.send_the_request_is);
        final String st4 = getResources().getString(R.string.Join_the_group_chat);
        final String st5 = getResources().getString(R.string.Failed_to_join_the_group_chat);
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage(st1);
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        new Thread(new Runnable() {
            public void run() {
                try {
                    //if group is membersOnly，you need apply to join
                    if (group.isMembersOnly()) {
                        EMClient.getInstance().groupManager().applyJoinToGroup(groupid, st2);
                    } else {
                        EMClient.getInstance().groupManager().joinGroup(groupid);
                    }
                    runOnUiThread(new Runnable() {
                        public void run() {
                            pd.dismiss();
                            if (group.isMembersOnly())
                                Toast.makeText(GroupSimpleDetailActivity.this, st3, Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(GroupSimpleDetailActivity.this, st4, Toast.LENGTH_SHORT).show();
                            btn_add_group.setEnabled(false);
                        }
                    });
                } catch (final HyphenateException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            pd.dismiss();
                            Toast.makeText(GroupSimpleDetailActivity.this, st5 + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    private void showGroupDetail() {
        progressBar.setVisibility(View.INVISIBLE);

        //get group detail, and you are not in, then show join button
        if (!group.getMembers().contains(EMClient.getInstance().getCurrentUser()))
            btn_add_group.setEnabled(true);
        seekUser(group.getOwner());
        tv_name.setText(group.getGroupName());
        tv_introduction.setText(group.getDescription());
    }

    public void back(View view) {
        finish();
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
                        if (loginResult.getResult() != null) {
                            tv_admin.setText(loginResult.getResult().getName());
                        }
                    }
                });
            }
        });
    }

}
