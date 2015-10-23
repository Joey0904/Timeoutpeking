package com.joey.timeoutpeking.pages;

import android.view.View;
import android.widget.TextView;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/21/15.
 */
public class SmartServicePage extends BasePage {
    public SmartServicePage(HomeActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        mTitle.setText("Smart Service");

        TextView textView = new TextView(mContext);
        textView.setText("Smart pants!");
        textView.setTextSize(30);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        mContent.addView(textView);
    }
}
