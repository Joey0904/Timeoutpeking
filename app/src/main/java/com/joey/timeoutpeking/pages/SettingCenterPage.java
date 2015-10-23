package com.joey.timeoutpeking.pages;

import android.view.View;
import android.widget.TextView;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/21/15.
 */
public class SettingCenterPage extends BasePage {
    public SettingCenterPage(HomeActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        mMenu.setVisibility(View.GONE);
        mTitle.setText("Setting Center");

        TextView textView = new TextView(mContext);
        textView.setText("settings");
        textView.setTextSize(30);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        mContent.addView(textView);
    }
}
