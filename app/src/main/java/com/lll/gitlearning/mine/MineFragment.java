package com.lll.gitlearning.mine;

import android.util.Log;

import com.lll.gitlearning.R;
import com.lll.gitlearning.base.BaseFragment;

/**
 * 我的页面
 *
 * @author runningDigua
 * @date 2019/10/22
 */
public class MineFragment extends BaseFragment {

    private static final String TAG = "MineFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    protected void initView() {
        Log.e(TAG,"");
        Log.e(TAG,"第二次修改");
    }
}
