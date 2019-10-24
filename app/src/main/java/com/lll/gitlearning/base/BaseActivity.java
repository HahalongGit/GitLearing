package com.lll.gitlearning.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Base Activity
 * <p>
 * BaseActivity 通过泛型的方式设置Presenter实现，并且实现BaseView统一处理对应的View方法
 * BaseActivity中 使用泛型Presenter对象来调用attachView(View view);和detachView()
 * 如果项目使用了Dagger2类似的注解工具，可以注解mPresenter 这样注解自动生成mPresenter的实现对象，
 * 不需要在业务的Activity中手动创建mPresenter实例
 *
 * @author runningDigua
 * @date 2019/10/21
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    private static final String TAG = "BaseActivity";

    // Presenter的实例，这里可以添加Dagger2的注解
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initPresenter();
        initData();
        addListener();
    }

    // 初始化Presenter 手动创建Presenter的过程在initView中处理，所以 initPresenter执行顺序在其后。
    private void initPresenter() {
        if (mPresenter != null) {
            mPresenter.onAttachView(this);
            Log.e(TAG, "initPresenter--mPresenter!=null");
        } else {
            Log.e(TAG, "initPresenter--mPresenter==null");
        }
    }

    @Override
    public void showLoading() {
        //在BaseActivty中实现这个方法，让子类根据需要去覆盖
    }

    @Override
    public void hideLoading() {
        //在BaseActivty中实现这个方法，让子类根据需要去覆盖
    }

    @Override
    public void setError(String error) {
        if (!TextUtils.isEmpty(error)) {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 添加Lstener
     */
    protected void addListener() {

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter.onDetachView();
            Log.e(TAG, "onDestroy--mPresenter!=null");
        } else {
            Log.e(TAG, "onDestroy--mPresenter==null");
        }
    }
}