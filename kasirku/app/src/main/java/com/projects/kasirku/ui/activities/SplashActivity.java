package com.projects.kasirku.ui.activities;

import android.content.Intent;
import android.os.Handler;

import com.projects.kasirku.R;
import com.projects.kasirku.databinding.ActivitySplashBinding;
import com.projects.kasirku.utils.ActivityUtils;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {
    @Override
    protected int attachLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        super.initData();

        ActivityUtils.setLightIconStatusBar(getWindow());
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 3000);
    }
}
