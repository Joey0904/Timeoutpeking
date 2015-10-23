package com.joey.timeoutpeking.pages;

import android.view.View;
import android.widget.TextView;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/20/15.
 */
public class HomePage extends BasePage {
    public HomePage(HomeActivity context) {
        super(context);
    }
    @Override
    public void initData() {
        mMenu.setVisibility(View.GONE);
        mTitle.setText("HomePage");

        TextView textView = new TextView(mContext);
        textView.setText("content of HomePage");
        textView.setTextSize(30);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        mContent.addView(textView);
    }
}
