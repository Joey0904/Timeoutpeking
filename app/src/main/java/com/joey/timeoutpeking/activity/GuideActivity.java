package com.joey.timeoutpeking.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.Utils.DensityUtil;
import com.joey.timeoutpeking.Utils.MyConst;
import com.joey.timeoutpeking.Utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * guide page for app
 * Created by Di on 10/13/15.
 */
public class GuideActivity extends Activity {
    private ViewPager mPager;
    private List<ImageView> mImageData = new ArrayList<>();
    private int[] pages_id = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private LinearLayout mLinearLayout;
    private View mView_RedPoints;
    private int mPointDis;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.putBoolean(GuideActivity.this, MyConst.IS_SETUP_FINISH, true);

                Intent home = new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(home);
                finish();
            }
        });
//listen if the layout has been implement
        mView_RedPoints.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                mPointDis = mLinearLayout.getChildAt(1).getLeft() - mLinearLayout.getChildAt(0).getLeft();
                mView_RedPoints.getViewTreeObserver().removeOnGlobalLayoutListener(this);

            }
        });
        final ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 页面滑动的调用
                //position 页面的当前位置
                //positionOffset 比例值
                //positionOffsetPixels 偏移的像素

                //确定红点的位置
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mView_RedPoints.getLayoutParams();
                layoutParams.leftMargin = Math.round(mPointDis * (position + positionOffset));
                mView_RedPoints.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("zjd", "onpageselect");
                if (position == mImageData.size() - 1) {
                    mButton.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        mPager.addOnPageChangeListener(listener);

//        mPager.removeOnPageChangeListener(listener);
    }

    private void initData() {
        for (int i = 0; i < pages_id.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(pages_id[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageData.add(imageView);

            //dp dip convert
            int dis = DensityUtil.dip2px(this, 10);
            View view = new View(this);
            view.setBackgroundResource(R.drawable.v_point_grey);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dis, dis);
            if (i != 0) {
                //not the 1st point
                layoutParams.leftMargin = dis;
            }
            view.setLayoutParams(layoutParams);
            mLinearLayout.addView(view);
        }

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        mPager.setAdapter(myPagerAdapter);
    }

    private void initView() {
        setContentView(R.layout.activity_guide);
        mPager = (ViewPager) findViewById(R.id.pager_guide_activity);
        mButton = (Button) findViewById(R.id.bt_guid_expr);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_guid_graypoints);
        mView_RedPoints = findViewById(R.id.v_guid_redpoint);

    }


    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mImageData.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mImageData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
