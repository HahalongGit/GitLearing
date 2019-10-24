package com.lll.gitlearning.base;

/**
 * 基础实现Presenter 所有的业务Presenter都要实现这个Presenter
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    /**
     * 我的view
     */
    protected T mView;

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onAttachView(T view) {
        mView = view;
    }

    @Override
    public void onDetachView() {
        mView = null;
    }
}
