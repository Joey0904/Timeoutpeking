package com.joey.timeoutpeking.views;

import android.view.View;

import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.pages.BasePage;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by Di on 10/23/15.
 */
public class MainFragment  extends BaseFragment{
    @ViewInject(R.id.pagers_homescr)


    @Override
    public View initView() {

    }

    public BasePage getSelectPage() {
        return mSelectIndex;
    }
}
