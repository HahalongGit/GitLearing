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
import com.lll.gitlearning.mine.bean.UserInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
        UserInfo userInfo = new UserInfo();
        Class fieldClass = userInfo.getClass();
        
        setFieldValue(fieldClass);
        constructor(userInfo);
    }

    /**
     * 反射给Field设置值
     *
     * @param fieldClass
     */
    private void setFieldValue(Class fieldClass) {
        try {
            Constructor constructor = fieldClass.getDeclaredConstructor(new Class[]{String.class});
            constructor.setAccessible(true);
            Object instance = constructor.newInstance("我叫~~龙");//创建的对象instance
            Field field = fieldClass.getDeclaredField("userName");
            field.setAccessible(true);
            field.set(instance, "反射设置的name是滴滴");//反射给 userName字段 设置值
            Object o = field.get(instance);//获取到字段
            Log.e(TAG, "field-value-o:" + o.toString());
            Log.e(TAG, "field-value:" + field.get(instance).toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造方法获取
     *
     * @param userInfo
     */
    private void constructor(UserInfo userInfo) {
        Class<? extends UserInfo> clazz = userInfo.getClass();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            Log.e(TAG, "constructor-1-" + Modifier.toString(constructor.getModifiers()) + "参数");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                Log.e(TAG, "parameterType:" + parameterType.getName() + "--");
            }
        }

        Class p[] = {String.class, int.class};// 两个参数的构造方法
        try {
            Constructor<? extends UserInfo> constructor = userInfo.getClass().getDeclaredConstructor(p);
            UserInfo instance = constructor.newInstance("地瓜", 22);//调用构造方法创建对象 UserInfo-name:地瓜--age:22
            Log.e(TAG, "constructor--:" + Modifier.toString(constructor.getModifiers()));
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> type : parameterTypes) {
                Log.e(TAG, "constructor--param:" + type.getName() + "--");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Class p1[] = {String.class};// 一个参数的构造方法
        try {
            Constructor<? extends UserInfo> constructor = userInfo.getClass().getDeclaredConstructor(p1);
            constructor.setAccessible(true);//设置可以访问，否则报错
            constructor.newInstance("奔跑的地瓜。。。");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用 普通方法
        try {

            Class<? extends UserInfo> userInfoClass = userInfo.getClass();
            // 调用构造方法
            Constructor<? extends UserInfo> constructor = userInfoClass.getDeclaredConstructor(new Class[]{String.class});
            constructor.setAccessible(true);
            constructor.newInstance("亚妮~~");

            // 调用普通private方法
            Method welcomeTo = userInfoClass.getDeclaredMethod("welcomeTo", p1);
            welcomeTo.setAccessible(true);
            Object obj[] = {"北京市朝阳区广渠门~"};
            welcomeTo.invoke(userInfo, obj);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

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
