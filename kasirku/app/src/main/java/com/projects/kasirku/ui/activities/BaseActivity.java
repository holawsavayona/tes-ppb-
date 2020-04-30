package com.projects.kasirku.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.projects.kasirku.utils.ActivityUtils;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

    protected Binding binding;
    abstract protected int attachLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.fullscreenUI(getWindow());binding = DataBindingUtil.setContentView(this, attachLayout());

        initData();
        initLayout();
    }

    protected void initData(){}


    protected void initLayout(){}
}
