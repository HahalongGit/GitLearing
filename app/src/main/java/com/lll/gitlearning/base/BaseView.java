package com.lll.gitlearning.base;

/**
 * BaseView
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public interface BaseView {//BaseActivity 和BaseFragmet 实现BaseView 统一处理Loading 和Error

    /**
     * show加载进度
     */
    void showLoading();

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * setError
     *
     * @param error
     */
    void setError(String error);

}
