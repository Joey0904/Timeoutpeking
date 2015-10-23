package com.joey.timeoutpeking.newscenterpages;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.activity.HomeActivity;
import com.joey.timeoutpeking.domain.NewsCenterData;
import com.joey.timeoutpeking.tpiPages.NewsTagPageDetail;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.viewpagerindicator.TabPageIndicator;

import java.util.List;

/**
 * Created by Di on 10/15/15.
 */
public class NewsPage_NewsCenter extends BaseNewscenterPage {
    @ViewInject(R.id.tpi_newspage_news)
    private TabPageIndicator mIndicator;
    @ViewInject(R.id.pager_newspages)
    private ViewPager mPager;

    private List<NewsCenterData.Data.Children> mChildrenData;


    public NewsPage_NewsCenter(HomeActivity context, List<NewsCenterData.Data.Children> children) {
        super(context);
        this.mChildrenData = children;
        initData();
    }

    @Override
    public void initEvent() {

        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(mContext, "onPageScrolled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mContext.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                } else {
                    mContext.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(mContext, "onPageScrollStateChanged", Toast.LENGTH_SHORT).show();
            }
        });

        super.initEvent();
    }

    @Override
    public View initView() {
        View rootView = View.inflate(mContext, R.layout.newscenter_news, null);
        com.lidroid.xutils.ViewUtils.inject(this, rootView);
        return rootView;
    }

    @Override
    public void initData() {
        MyAdapter mAdapter = new MyAdapter();
        mPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mPager);
        super.initData();
    }


    private class MyAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            NewsTagPageDetail newsTagPageDetail = new NewsTagPageDetail(mContext, mChildrenData.get(position));

            View view = newsTagPageDetail.getRootView();
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return mChildrenData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mChildrenData.get(position).title;
        }
    }
}
