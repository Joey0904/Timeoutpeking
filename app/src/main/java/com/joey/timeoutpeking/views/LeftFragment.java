package com.joey.timeoutpeking.views;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.domain.NewsCenterData;
import com.joey.timeoutpeking.pages.BasePage;

import java.util.List;

/**
 * Created by Di on 10/21/15.
 */
public class LeftFragment extends BaseFragment {
    private List<NewsCenterData.Data> mLeftMenuData;
    private ListView mLeftMenu_ListView;
    private MyAdapter mAdapter;
    private int mSelectIndex;
    private OnLeftMenuPageChangedListener mOnLeftMenuPageChangedListener;

    @Override
    public View initView() {
        mLeftMenu_ListView = new ListView(mContext);
        mLeftMenu_ListView.setBackgroundColor(Color.BLACK);
        mLeftMenu_ListView.setDividerHeight(0);

        mLeftMenu_ListView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mLeftMenu_ListView.setPadding(0, 50, 0, 0);

        mAdapter = new MyAdapter();
        mLeftMenu_ListView.setAdapter(mAdapter);
        return mLeftMenu_ListView;
    }

    @Override
    public void initEvent() {
        mLeftMenu_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectIndex = position;

                mAdapter.notifyDataSetChanged();

                if (mOnLeftMenuPageChangedListener != null) {
                    mOnLeftMenuPageChangedListener.selectPage(mSelectIndex);
                } else {
                    BasePage page = mContext.getMainFragment().getSelectPage();
                    page.selectPage(mSelectIndex);
                }
                mContext.getSlidingMenu().toggle();
            }
        });
        super.initEvent();
    }

    public void setOnLeftMenuPageChangedListener(OnLeftMenuPageChangedListener listener) {
        this.mOnLeftMenuPageChangedListener = listener;

    }

    public void setLeftMenuData(List<NewsCenterData.Data> leftMenuData) {
        this.mLeftMenuData = leftMenuData;
        mAdapter.notifyDataSetChanged();
    }

    public interface OnLeftMenuPageChangedListener {
        void selectPage(int selectIndex);
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (mLeftMenuData != null) {
                return mLeftMenuData.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.left_menu_item_lv, null);
            }
            TextView textView = (TextView) convertView;

            String title = mLeftMenuData.get(position).title;
            textView.setText(title);

            if (mSelectIndex == position) {
                textView.setEnabled(true);
            } else {
                textView.setEnabled(false);
            }

            return textView;
        }
    }
}
