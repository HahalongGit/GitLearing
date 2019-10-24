package com.lll.gitlearning;

import com.lll.gitlearning.base.BaseActivity;
import com.lll.gitlearning.mine.MineFragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity {

    private FragmentManager mFragmentManager;

    private MineFragment mMineFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mMineFragment = MineFragment.getInstance();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction
                .add(R.id.container, mMineFragment)
                .commit();
    }

    @Override
    protected void initData() {

    }

}
