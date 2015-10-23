package com.joey.timeoutpeking.pages;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/20/15.
 */
public class BasePage {
    protected HomeActivity mContext;
    protected TextView mTitle;
    protected ImageView mMenu;
    protected FrameLayout mContent;
    private View mRootView;

    public BasePage(HomeActivity context) {
        mContext = context;

        initView();
        initEvent();
    }

    private void initEvent() {
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.getSlidingMenu().toggle();
            }
        });
    }

    private void initView() {
        mRootView = View.inflate(mContext, R.layout.basepage_view, null);
        mTitle = (TextView) mRootView.findViewById(R.id.tv_basepage_title);
        mMenu = (ImageView) mRootView.findViewById(R.id.iv_basepage_menu);
        mContent = (FrameLayout) mRootView.findViewById(R.id.fl_basepage_content);
    }

    public View getRootView() {
        return mRootView;
    }

    public void initData() {

    }

    /**
     * override this one to change the page.
     *
     * @param pageIndex
     */
    public void selectPage(int pageIndex) {

    }


}
