package com.xiaoxian.mvpdemo.module.presenter;

import com.xiaoxian.mvpdemo.module.contract.UserInfoContract;

/**
 * Created by Administrator on 2016/10/5.
 */
public class UserInfoFragmentPresenter implements UserInfoContract.IUserInfoFragmentPresenter {

    private UserInfoContract.IUserInfoFragment mIUserInfoFragment;
    public UserInfoFragmentPresenter(UserInfoContract.IUserInfoFragment mIUserInfoFragment){
        this.mIUserInfoFragment=mIUserInfoFragment;
        mIUserInfoFragment.setPresenter(this);
    }

    @Override
    public void loadData() {
        mIUserInfoFragment.showData();
    }

    @Override
    public void start() {
        loadData();
    }
}
