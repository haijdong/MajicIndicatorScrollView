package com.example.donghaijun.indicatorscroolview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by donghaijun on 2017/2/7.
 */
public class MyScrollView extends ScrollView {
	private OnScrollListener mListener;

	public MyScrollView(Context context) {
		this(context,null);
	}

	public MyScrollView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public MyScrollView(Context context, AttributeSet attrs,
						int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (mListener != null)
			mListener.onScroll(t);
	}

	public void setOnScrollListener(OnScrollListener listener) {
		this.mListener = listener;
	}
	
	public interface OnScrollListener {
		public void onScroll(int y);
	}
}
