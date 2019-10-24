package com.lll.gitlearning.homepage;

import android.os.Bundle;

import com.lll.gitlearning.R;
import com.lll.gitlearning.base.BaseFragment;

import androidx.annotation.Nullable;

/**
 * 创建首页
 *
 * @author runningDigua
 * @date 2019/10/21
 */
public class HomeFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected void initView() {

    }
}
