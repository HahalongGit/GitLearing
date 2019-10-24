package com.lll.gitlearning.mine.presenter.impl;

import android.nfc.Tag;
import android.util.Log;

import com.lll.gitlearning.base.BasePresenterImpl;
import com.lll.gitlearning.mine.bean.UserInfo;
import com.lll.gitlearning.mine.presenter.UserInfoPresenter;
import com.lll.gitlearning.mine.view.UserInfoView;

/**
 * userInfoPresenter 实现
 * UserInfoPresenterImpl 实现类 集成了基础的Presenter实现类，实现了自己的UserInfoPresenter接口，同事通过泛型的方式添加了View
 * <p>
 * 整个项目有公共的BasePresente 和 BasePresenterImpl实现，BasePresenterImpl来处理基础的泛型 View绑定
 * 每个Activity或者Fragment有自己的View 和Presenter接口 和自己的实现，自己的接口用来定义Activity和Fragment内业务对应的View方法
 * 和业务方法。比如：UserInfoActivity中的UserInfoView 定义setUserInfo();方法，UserInfoPresenter用来定义getUserInfo();业务处理方法
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public class UserInfoPresenterImpl extends BasePresenterImpl<UserInfoView> implements UserInfoPresenter<UserInfoView> {

    private static final String TAG = "UserInfoPresenterImpl";

    @Override
    public void getUserInfo(String userId) {
        if (mView != null) {
            mView.showLoading();
        }

        // TODO: [runningDigua create at 2019/10/24] 获取用户信息业务代码实现
        Log.e(TAG, "getUserInfo:");

        // 实现UserInfo 业务的方法去访问接口等
        if (mView != null) {
            mView.setUserInfo(new UserInfo());
            mView.hideLoading();
            Log.e(TAG, "getUserInfo-mView != null");
        } else {
            Log.e(TAG, "getUserInfo-mView == null");
        }
    }
}
