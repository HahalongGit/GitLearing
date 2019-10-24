package com.lll.gitlearning.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lll.gitlearning.R;
import com.lll.gitlearning.base.BaseFragment;
import com.lll.gitlearning.mine.activity.UserInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的页面
 *
 * @author runningDigua
 * @date 2019/10/22
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.rl_userInfo)
    RelativeLayout mRlUserInfo;
    @BindView(R.id.rl_setting)
    RelativeLayout mRlSetting;

    public MineFragment() {
    }

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    private static final String TAG = "MineFragment";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    protected void initView() {
        Log.e(TAG, "");
        Log.e(TAG, "第二次修改");
    }

    @OnClick({R.id.rl_userInfo, R.id.rl_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_userInfo: {
                Intent intent = new Intent(mContext, UserInfoActivity.class);
                mContext.startActivity(intent);
                break;
            }
            case R.id.rl_setting:
                break;
        }
    }
}
