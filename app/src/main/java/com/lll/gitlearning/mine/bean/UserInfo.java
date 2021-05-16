package com.lll.gitlearning.mine.bean;

import android.util.Log;

/**
 * UserInfo
 *
 * @author runningDigua
 * @date 2019/10/24
 */
public class UserInfo {

    private static final String TAG = "UserInfo";

    private String userName;

    private int age;

    public UserInfo() {
    }

    private UserInfo(String userName) {
        this.userName = userName;
        Log.e(TAG, "userName=" + userName);
    }

    public UserInfo(String userName, int age) {
        this.userName = userName;
        this.age = age;
        Log.e(TAG, "UserInfo-name:" + userName + "--age:" + age);
    }

    public void setUserName(String name) {
        userName = name;
        Log.e(TAG, "setUserName-name:" + userName);
    }

    private void welcomeTo(String place) {
        Log.e(TAG, userName + "--welcomeTo:--" + place);
    }

}
