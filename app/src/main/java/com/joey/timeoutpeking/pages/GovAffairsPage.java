package com.joey.timeoutpeking.pages;

import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/20/15.
 */
public class GovAffairsPage extends BasePage {
    public GovAffairsPage(HomeActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        mTitle.setText("Government Affairs");

        TextView textView = new TextView(mContext);
        textView.setText("What's new");
        textView.setTextSize(30);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);

        mContent.addView(textView);
    }
}
