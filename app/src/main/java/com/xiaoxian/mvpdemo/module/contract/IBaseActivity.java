package com.xiaoxian.mvpdemo.module.contract;

/**
 * Created by Administrator on 2016/10/5.
 */
public interface IBaseActivity<T> {
    void setPresenter(T mIActivityPresenter);
    void setLifeCycle(IActivityLifeCycle mIActivityLifeCycle);
}
