package com.lll.gitlearning.base;

import android.view.View;

/**
 * basePresenter
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public interface BasePresenter<T> {

    /**
     * on Presenter Destroy
     */
    void onDestroy();

    /**
     * 绑定view
     *
     * @param view
     */
    void onAttachView(T view);

    /**
     * 解绑View
     */
    void onDetachView();

}
