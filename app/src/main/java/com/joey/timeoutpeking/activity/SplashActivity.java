package com.joey.timeoutpeking.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.joey.timeoutpeking.R;
import com.joey.timeoutpeking.Utils.MyConst;
import com.joey.timeoutpeking.Utils.SPUtils;

/**
 * Created by Di on 10/13/15.
 */
public class SplashActivity extends Activity {
    private ImageView mSplashBg;
    private AnimationSet mASet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initAnimation();
        initEvent();
    }

    private void initEvent() {
        mASet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(SplashActivity.this, "Weeeeelcome!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //if the setup is not finished -> enter the setup UI
                boolean isSetupFinished = SPUtils.getBoolean(getApplicationContext(), MyConst.IS_SETUP_FINISH, false);
                if (isSetupFinished) {
                    Intent home = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(home);
                    finish();
                } else {
                    Intent guideActivity = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(guideActivity);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initAnimation() {
        mASet = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(1000);
        rotateAnimation.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.3f, 1, 0.3f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);

        mASet.addAnimation(rotateAnimation);
        mASet.addAnimation(scaleAnimation);
        mASet.addAnimation(alphaAnimation);

        mSplashBg.setAnimation(mASet);
    }

    private void initView() {
        setContentView(R.layout.activity_splash);
        mSplashBg = (ImageView) findViewById(R.id.splash_bg);
    }
}
