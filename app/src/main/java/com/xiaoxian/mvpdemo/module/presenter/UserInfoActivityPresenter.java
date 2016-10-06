package com.xiaoxian.mvpdemo.module.presenter;

import android.os.Handler;

import com.xiaoxian.mvpdemo.module.contract.IActivityLifeCycle;
import com.xiaoxian.mvpdemo.module.contract.UserInfoContract;
import com.xiaoxian.mvpdemo.module.model.UserInfoModel;

/**
 * Created by Administrator on 2016/10/5.
 */
public class UserInfoActivityPresenter implements UserInfoContract.IUserInfoActivityPresenter,IActivityLifeCycle{

    private UserInfoContract.IUserInfoActivity mIUserInfoActivity;

    public UserInfoActivityPresenter(UserInfoContract.IUserInfoActivity mIUserInfoActivity){
        this.mIUserInfoActivity=mIUserInfoActivity;
        mIUserInfoActivity.setPresenter(this);
        mIUserInfoActivity.setLifeCycle(this);
    }

    @Override
    public void loadUserInfo() {
        mIUserInfoActivity.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserInfoModel userInfoModel=new UserInfoModel("三无MarBlue",24,"福建");
                mIUserInfoActivity.showUserInfo(userInfoModel);
                mIUserInfoActivity.dismissLoading();
            }
        },3000);
    }

    @Override
    public void start() {
        loadUserInfo();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
