package com.joey.timeoutpeking.newscenterpages;

import android.view.View;
import android.widget.TextView;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/17/15.
 */
public class InteractPage_NewsCenter extends BaseNewscenterPage {
    public InteractPage_NewsCenter(HomeActivity context) {

        super(context);

    }

    @Override
    public View initView() {
        TextView title = new TextView(mContext);
        title.setText("Interact news");
        title.setTextSize(30);
        title.setGravity(View.TEXT_ALIGNMENT_CENTER);

        return title;
    }
}
