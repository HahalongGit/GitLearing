package com.lll.gitlearning.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Base Activity
 *
 * @author runningDigua
 * @date 2019/10/21
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        addListener();
    }

    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 添加Lstener
     */
    protected void addListener() {

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

}