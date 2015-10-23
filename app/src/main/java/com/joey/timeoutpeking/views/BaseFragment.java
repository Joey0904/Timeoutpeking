package com.joey.timeoutpeking.views;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joey.timeoutpeking.activity.HomeActivity;

/**
 * Created by Di on 10/21/15.
 */
public abstract class BaseFragment extends Fragment {

    protected HomeActivity mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mContext = (HomeActivity) getActivity();
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }

    public abstract View initView();

    public void initData() {

    }

    public void initEvent() {

    }

    @Override
    public void onStart() {
        initData();
        initEvent();
        super.onStart();
    }
}
