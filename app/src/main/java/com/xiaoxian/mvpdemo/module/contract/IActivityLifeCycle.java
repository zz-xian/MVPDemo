package com.xiaoxian.mvpdemo.module.contract;

/**
 * Created by Administrator on 2016/10/5.
 */
public interface IActivityLifeCycle {
    void onCreate();
    void onRestart();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
