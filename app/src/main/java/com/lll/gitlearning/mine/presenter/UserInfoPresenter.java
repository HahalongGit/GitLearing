package com.lll.gitlearning.mine.presenter;

import com.lll.gitlearning.base.BasePresenter;

/**
 * UserInfoPresenter
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public interface UserInfoPresenter<T> extends BasePresenter<T> {

    /**
     * getUsreInfo
     *
     * @param userId 用户id
     */
    void getUserInfo(String userId);

}
