package com.xiaoxian.mvpdemo.module.contract;

import com.xiaoxian.mvpdemo.module.model.UserInfoModel;

/**
 * Created by Administrator on 2016/10/5.
 */
public class UserInfoContract {

    public interface IUserInfoActivity extends IBaseActivity<IUserInfoActivityPresenter>{
        void showLoading();
        void dismissLoading();
        void showUserInfo(UserInfoModel userInfoModel);
    }

    public interface IUserInfoFragment extends IBaseFragment<IUserInfoFragmentPresenter>{
        void showData();
    }

    public interface IUserInfoActivityPresenter extends IBasePresenter{
        void loadUserInfo();
    }

    public interface IUserInfoFragmentPresenter extends IBasePresenter{
        void loadData();
    }
}
