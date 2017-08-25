package com.blanink.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blanink.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpLoadListView extends ListView implements OnScrollListener{
	private View footerView;
	private int footerViewHeight;
	private RotateAnimation upAnimation,downAnimation;
	private boolean isLoadingMore = false;//当前是否正在处于加载更多
	public UpLoadListView(Context context) {
		super(context);
		init();
	}

	public UpLoadListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init(){

		initFooterView();
		initRotateAnimation();
		setOnScrollListener(this);
	}


	/**
	 * 初始化headerView
	 */
	private void initFooterView() {
		footerView = View.inflate(getContext(), R.layout.layout_footer, null);
		footerView.measure(0, 0);//主动通知系统去测量该view;
		footerViewHeight = footerView.getMeasuredHeight();
		Log.e("RefreshListView","footerViewHeight:"+footerViewHeight);
		footerView.setPadding(0, -footerViewHeight, 0, 0);
		addFooterView(footerView);
	}
	
	/**
	 * 初始化旋转动画
	 */
	private void initRotateAnimation() {
		upAnimation = new RotateAnimation(0, -180, 
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		upAnimation.setDuration(300);
		upAnimation.setFillAfter(true);
		downAnimation = new RotateAnimation(-180, -360, 
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		downAnimation.setDuration(300);
		downAnimation.setFillAfter(true);
	}
	/**
	 * 完成刷新操作，重置状态,在你获取完数据并更新完adater之后，去在UI线程中调用该方法
	 */
	public void completeRefresh(Boolean hasData){
			//重置footerView状态
			Log.e("@@@@","是否有数据:"+hasData);
			if(hasData){
				footerView.setPadding(0, -footerViewHeight,0, 0);
				footerView.findViewById(R.id.ll_load_more).setVisibility(View.VISIBLE);
				footerView.findViewById(R.id.rl_load_not_data).setVisibility(View.GONE);
			}else{
				footerView.findViewById(R.id.ll_load_more).setVisibility(View.GONE);
				footerView.findViewById(R.id.rl_load_not_data).setVisibility(View.VISIBLE);
			}
			isLoadingMore = false;

	}

	private OnRefreshListener listener;
	public void setOnRefreshListener(OnRefreshListener listener){
		this.listener = listener;
	}
	public interface OnRefreshListener{
		void onLoadingMore();
		void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount);
	}
	
	/**
	 * SCROLL_STATE_IDLE:闲置状态，就是手指松开
	 * SCROLL_STATE_TOUCH_SCROLL：手指触摸滑动，就是按着来滑动
	 * SCROLL_STATE_FLING：快速滑动后松开
	 */
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		if(scrollState==OnScrollListener.SCROLL_STATE_IDLE
				&& getLastVisiblePosition()==(getCount()-1) &&!isLoadingMore){
			isLoadingMore = true;
			footerView.setVisibility(VISIBLE);
			footerView.setPadding(0, 0, 0, 0);//显示出footerView
			setSelection(getCount());//让listview最后一条显示出来
			Log.e("RefreshListView","footerView show");
			if(listener!=null){
				listener.onLoadingMore();
				Log.e("RefreshListView","load more");
			}
		}
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		    if(listener!=null){
		    listener.onScroll(view,firstVisibleItem,
		    visibleItemCount,totalItemCount);}
		}

}
