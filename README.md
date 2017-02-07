# MajicIndicatorScrollView
带有滑动指示器+悬浮框的scrollview
##关键代码


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
        

![image](https://github.com/haijdong/MajicIndicatorScrollView/blob/master/indicatorscrollview.gif)


