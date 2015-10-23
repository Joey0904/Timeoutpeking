package com.joey.timeoutpeking.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.views.LeftFragment;
import com.joey.timeoutpeking.views.MainFragment;

public class HomeActivity extends SlidingActivity {
    public final String LEFT_FRAGMENT_TAG = "left_fragment_tag";
    public final String MAIN_FRAGMENT_TAG = "main_fragment_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setBehindContentView(R.layout.sliding_menu_activity);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setBehindOffset(350);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        slidingMenu.setMode(SlidingMenu.LEFT);

        initView();

    }

    /**
     * replace
     */
    private void initView() {
        FragmentManager mFragmentManager = getFragmentManager();
        android.app.FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        LeftFragment leftFragment = new LeftFragment();
        mFragmentTransaction.replace(R.id.left_frag, leftFragment, LEFT_FRAGMENT_TAG);
        mFragmentTransaction.commit();

        getFragmentManager().beginTransaction().replace(
                R.id.fl_basepage_content, new MainFragment(), MAIN_FRAGMENT_TAG).commit();


    }

    public LeftFragment getLeftFragment() {
        return (LeftFragment) getFragmentManager().findFragmentByTag(LEFT_FRAGMENT_TAG);
    }

    public MainFragment getMainFragment() {
        return (MainFragment) getFragmentManager().findFragmentByTag(MAIN_FRAGMENT_TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
