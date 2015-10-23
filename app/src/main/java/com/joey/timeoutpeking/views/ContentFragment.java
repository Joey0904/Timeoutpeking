package com.joey.timeoutpeking.views;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Di on 10/21/15.
 */
public class ContentFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("content frag");
        textView.setTextSize(30);
        return textView;
    }
}
