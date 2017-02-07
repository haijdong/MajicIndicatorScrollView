package com.example.donghaijun.indicatorscroolview;

import android.content.Context;

public class DensityUtil {

	/**
	 * 鏍规嵁鎵嬫満鐨勫垎杈ㄧ巼浠� dp 鐨勫崟浣� 杞垚涓� px(鍍忕礌)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 鏍规嵁鎵嬫満鐨勫垎杈ㄧ巼浠� px(鍍忕礌) 鐨勫崟浣� 杞垚涓� dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static int sp2px(Context paramContext, float paramFloat)
	{
		float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
		return (int)(paramFloat * f + 0.5F);
	}

	public static int px2sp(Context paramContext, float paramFloat)
	{
		float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
		return (int)(paramFloat / f + 0.5F);
	}
	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
