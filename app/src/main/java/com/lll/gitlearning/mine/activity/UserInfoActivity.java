package com.lll.gitlearning.mine.activity;

import com.lll.gitlearning.R;
import com.lll.gitlearning.base.BaseActivity;
import com.lll.gitlearning.mine.bean.UserInfo;
import com.lll.gitlearning.mine.presenter.UserInfoPresenter;
import com.lll.gitlearning.mine.presenter.impl.UserInfoPresenterImpl;
import com.lll.gitlearning.mine.view.UserInfoView;

/**
 * userInfo
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public class UserInfoActivity extends BaseActivity<UserInfoPresenterImpl> implements UserInfoView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_userinfo_layout;
    }

    @Override
    protected void initView() {
        mPresenter = new UserInfoPresenterImpl();
        //没有添加 Dagger2注解 需要手动创建Presenter的实现对象
//        mPresenter.onAttachView(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setUserInfo(UserInfo userInfo) {

    }

}
