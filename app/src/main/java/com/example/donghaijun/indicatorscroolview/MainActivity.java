package com.example.donghaijun.indicatorscroolview;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout ll_top;
    private MajicIndicatorScrollView majicScrollVeiw;
    private TabLayout tabsOrder;
    //页卡标题集合
    private ArrayList<String> mTitleList = new ArrayList<String>();
    //判断  粘性头部的距离测量方法  是不是加载一次
    private boolean isFirstOnMeasure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        majicScrollVeiw = (MajicIndicatorScrollView) findViewById(R.id.scrollview);
        linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        linearLayout3 = (LinearLayout) findViewById(R.id.ll3);
        ll_top = (LinearLayout) findViewById(R.id.ll_top);
        tabsOrder = (TabLayout) findViewById(R.id.tabs_order);
        initTabLayout();
        setListener();
    }
    private void initTabLayout() {
        mTitleList.add("第一部分");
        mTitleList.add("第二部分");
        mTitleList.add("第三部分");
        //设置tab模式，当前为系统默认模式
        tabsOrder.setTabMode(TabLayout.MODE_FIXED);
        //添加tab选项卡
        tabsOrder.addTab(tabsOrder.newTab().setText(mTitleList.get(0)));
        tabsOrder.addTab(tabsOrder.newTab().setText(mTitleList.get(1)));
        tabsOrder.addTab(tabsOrder.newTab().setText(mTitleList.get(2)));
    }
    private void setListener() {
        majicScrollVeiw.setOnTopScrollListener(new MajicIndicatorScrollView.OnTopScrollListener() {
            @Override
            public void onScrollY(int scrollY) {
                if (isFirstOnMeasure) {
                    //防止控件获取 粘性头部 距离顶部的距离
                    majicScrollVeiw.onWindowFocusChanged(true);
                    isFirstOnMeasure = false;
                }
                if (scrollY < ll_top.getHeight() + linearLayout1.getHeight() +
                        DensityUtil.dp2px(MainActivity.this, 10)) {
                    tabsOrder.setScrollPosition(0, 0, true);
                } else if (scrollY < ll_top.getHeight() + linearLayout1.getHeight() +
                        linearLayout2.getHeight() + DensityUtil.dp2px(MainActivity.this, 20)) {
                    tabsOrder.setScrollPosition(1, 0, true);
                } else if (scrollY < ll_top.getHeight() + linearLayout1.getHeight() +
                        linearLayout2.getHeight() + linearLayout3.getHeight() +
                        DensityUtil.dp2px(MainActivity.this, 30)) {
                    tabsOrder.setScrollPosition(2, 0, true);
                }
            }
        });

        //标卡  监听   定位
        tabsOrder.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        majicScrollVeiw.onScroll(0, ll_top.getHeight());
                        break;
                    case 1:
                        majicScrollVeiw.onScroll(0, ll_top.getHeight() + linearLayout1.getHeight() +
                                DensityUtil.dp2px(MainActivity.this, 10));
                        break;
                    case 2:
                        majicScrollVeiw.onScroll(0, ll_top.getHeight() + linearLayout1.getHeight() +
                                linearLayout2.getHeight() + DensityUtil.dp2px(MainActivity.this, 20));
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //必须加上
                tabsOrder.setScrollPosition(tab.getPosition(), 0F, true);
            }
        });

    }


}
