/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blanink.activity.EaseChat;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.blanink.R;
import com.blanink.activity.EaseChat.modle.DemoHelper;
import com.blanink.pojo.EaseUser;
import com.blanink.utils.GlideUtils;
import com.blanink.utils.NetUrlUtils;
import com.google.gson.Gson;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.ui.EaseBaseActivity;
import com.hyphenate.easeui.widget.EaseAlertDialog;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EaseAddContactActivity extends EaseBaseActivity {
	private EditText editText;
	private TextView nameText;
	private Button searchBtn;
	private String toAddUsername;
	private ProgressDialog progressDialog;
	private ListView lvUser;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.em_activity_add_contact);
		initView();
		initData();
	}

	private void initView() {
		mTextView = (TextView) findViewById(R.id.add_list_friends);
		//searchedUserLayout = (RelativeLayout) findViewById(R.id.ll_user);
		lvUser = ((ListView) findViewById(R.id.lv_user));
		editText = (EditText) findViewById(R.id.edit_note);

		//nameText = (TextView) findViewById(R.id.name);
		searchBtn = (Button) findViewById(R.id.search);
	}

	private void initData() {
		String strAdd = getResources().getString(R.string.add_friend);
		mTextView.setText(strAdd);
		String strUserName = getResources().getString(R.string.user_name);
		editText.setHint(strUserName);

	}


	/**
	 * 搜索要添加的好友
	 * @param v
	 */
	public void searchContact(View v) {
		final String name = editText.getText().toString();
		String saveText = searchBtn.getText().toString();
		
		if (getString(R.string.button_search).equals(saveText)) {
			if(TextUtils.isEmpty(name)) {
				new EaseAlertDialog(this, R.string.Please_enter_a_username).show();
				return;
			}
			seekUser(name);
			// TODO you can search the user from your app server here.
			
			//show the userame and add button if user exist
			//search edUserLayout.setVisibility(View.VISIBLE);
			//nameText.setText(toAddUsername);
			
		} 
	}	

	/**
	 *  add contact
	 * @param
	 */
	public void addContact(final String name, final String userId){
		Log.e("addUser","当前用户:"+EMClient.getInstance().getCurrentUser()+"添加userId:"+userId);

		//如果当前账户是自己
		if(EMClient.getInstance().getCurrentUser().equals(userId)){
			new EaseAlertDialog(this, R.string.not_add_myself).show();
			return;
		}

		if(DemoHelper.getInstance().getContactList().containsKey(userId)){
		    //let the user know the contact already in your contact list
		    if(EMClient.getInstance().contactManager().getBlackListUsernames().contains(userId)){
		        new EaseAlertDialog(this, R.string.user_already_in_contactlist).show();
		        return;
		    }
			new EaseAlertDialog(this, R.string.This_user_is_already_your_friend).show();
			return;
		}

		progressDialog = new ProgressDialog(this);
		String stri = getResources().getString(R.string.Is_sending_a_request);
		progressDialog.setMessage(stri);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.show();

		new Thread(new Runnable() {
			public void run() {

				try {
					//demo use a hardcode reason here, you need let user to input if you like
					String s = getResources().getString(R.string.Add_a_friend);
					EMClient.getInstance().contactManager().addContact(userId, s);
					runOnUiThread(new Runnable() {
						public void run() {
							progressDialog.dismiss();
							String s1 = getResources().getString(R.string.send_successful);
							Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_LONG).show();
						}
					});
				} catch (final Exception e) {
					runOnUiThread(new Runnable() {
						public void run() {
							progressDialog.dismiss();
							String s2 = getResources().getString(R.string.Request_add_buddy_failure);
							Toast.makeText(getApplicationContext(), s2 + e.getMessage(), Toast.LENGTH_LONG).show();
							Log.e("add","添加好友"+e.toString());
						}
					});
				}
			}
		}).start();
	}

	public void back(View v) {
		finish();
	}


	public void seekUser(String name){
		String url= NetUrlUtils.NET_URL+"talk/seekUserlist";
		OkHttpClient okHttpClient=new OkHttpClient();
		RequestBody body=new FormBody.Builder().add("name",name).build();
		Request request=new Request.Builder().post(body).url(url).build();
		okHttpClient.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
				Gson gson=new Gson();
				final EaseUser user=gson.fromJson(result,EaseUser.class);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if(user.getResult().size()==0){
							new EaseAlertDialog(EaseAddContactActivity.this,"没有符合条件的用户").show();

						}
						lvUser.setAdapter(new UserAdapter(user.getResult()));

					}
				});
			}
		});
	}

	public class UserAdapter extends BaseAdapter {
		private List<EaseUser.ResultBean> userList;

		public UserAdapter(List<EaseUser.ResultBean> userList) {
			this.userList = userList;
		}

		@Override
		public int getCount() {
			return userList.size();
		}

		@Override
		public Object getItem(int position) {
			return userList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				convertView = View.inflate(EaseAddContactActivity.this, R.layout.item_user, null);
				viewHolder.add = (Button) convertView.findViewById(R.id.add);
				viewHolder.name = (TextView) convertView.findViewById(R.id.name);
				viewHolder.iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);
				convertView.setTag(viewHolder);

			} else {
				viewHolder = ((ViewHolder) convertView.getTag());
			}

			viewHolder.add.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
                 addContact(userList.get(position).getName(),userList.get(position).getId());
				}
			});
			GlideUtils.glideImageView(EaseAddContactActivity.this,viewHolder.iv_photo,userList.get(position).getPhoto(),true);
			viewHolder.name.setText(userList.get(position).getName());
			return convertView;
		}


	}
	static class ViewHolder {
		Button add;
		ImageView iv_photo;
		TextView name;
	}


}
