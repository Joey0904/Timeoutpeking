package com.joey.timeoutpeking.tpiPages;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.activity.HomeActivity;
import com.joey.timeoutpeking.domain.NewsCenterData;
import com.joey.timeoutpeking.domain.NewsDetailData;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Di on 10/16/15.
 */
public class NewsTagPageDetail {
    @ViewInject(R.id.vp_tpi_page_detail_showpic)
    private ViewPager mPicPager;
    @ViewInject(R.id.tv_tpi_page_detail_desc)
    private TextView mPicDesc;
    @ViewInject(R.id.ll_tpi_page_detail_points)
    private LinearLayout mPoints;
    @ViewInject(R.id.lv_tpi_page_detail_newsdata)
    private ListView mNewsData;

    private HomeActivity mContext;
    private View mRootView;
    private NewsCenterData.Data.Children mChildren;
    private List<NewsDetailData.Data.TopNews> mTopNews;

    private ViewPagerAdapter mVpAdapter;
    private BitmapUtils mBitmapUtils;


    public NewsTagPageDetail(HomeActivity context, NewsCenterData.Data.Children children) {
        this.mContext = context;
        this.mChildren = children;

        mBitmapUtils = new BitmapUtils(context);
        initView();
        initData();
    }

    private void initView() {
        mRootView = View.inflate(mContext, R.layout.news_indicator_page_detail, null);
        com.lidroid.xutils.ViewUtils.inject(this, mRootView);

    }

    private void initData() {
        String newsDetailUrl = mContext.getResources().getString(
                R.string.baseurl)
                + mChildren.url;
        getDataFromNet(newsDetailUrl);
    }

    private void getDataFromNet(String newsDetailUrl) {
//        HttpUtils httpUtils = new HttpUtils();
//        httpUtils.send(HttpRequest.HttpMethod.GET,
//                newsDetailUrl, new RequestCallBack<String>() {
//                    @Override
//                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                        //get json
//                        String jsonData = responseInfo.result;
//                        //parse Json
//                        NewsDetailData detailData = parseData(jsonData);
//                        processData(detailData);
//                    }
//
//                    @Override
//                    public void onFailure(HttpException e, String s) {
//                        Toast.makeText(mContext, "网络请求数据失败", Toast.LENGTH_LONG).show();
//
//                    }
//                });

        Toast.makeText(mContext, newsDetailUrl, Toast.LENGTH_SHORT).show();
    }

    protected void processData(NewsDetailData detailData) {
        Log.d("zjd", detailData.mData.mTopNews.get(0).title);

        mTopNews = detailData.mData.mTopNews;
        setShowPicData();
    }

    private void setShowPicData() {
        if (mVpAdapter == null) {
            mVpAdapter = new ViewPagerAdapter();

            mPicPager.setAdapter(mVpAdapter);
        } else {
            mVpAdapter.notifyDataSetChanged();
        }
    }

    protected NewsDetailData parseData(String jsonData) {
        //gson
        Gson gson = new Gson();

        NewsDetailData detailData = gson.fromJson(jsonData, NewsDetailData.class);

        return detailData;

    }

    public View getRootView() {
        return mRootView;

    }

    private class ViewPagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            if (mTopNews != null) {
                return mTopNews.size();
            }
            return 0;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            NewsDetailData.Data.TopNews topNews = mTopNews.get(position);
            String picUrl = topNews.topimage;

            mBitmapUtils.display(imageView, picUrl);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
