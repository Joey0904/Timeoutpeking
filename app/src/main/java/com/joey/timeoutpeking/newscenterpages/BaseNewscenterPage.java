package com.joey.timeoutpeking.newscenterpages;

import android.view.View;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/15/15.
 */
public abstract class BaseNewscenterPage {
    protected HomeActivity mContext;
    private View rootView;

    public BaseNewscenterPage(HomeActivity context) {
        mContext = context;
        rootView = initView();
        initView();
    }

    public abstract View initView();

    public View getRootView() {
        return rootView;
    }

    public void initData() {

    }

    public void initEvent() {

    }
}
