package com.xiaoxian.mvpdemo.module.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoxian.mvpdemo.R;
import com.xiaoxian.mvpdemo.adapter.ViewPagerAdapter;
import com.xiaoxian.mvpdemo.module.contract.IActivityLifeCycle;
import com.xiaoxian.mvpdemo.module.contract.UserInfoContract;
import com.xiaoxian.mvpdemo.module.model.UserInfoModel;
import com.xiaoxian.mvpdemo.module.presenter.UserInfoActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/10/5.
 */
public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.IUserInfoActivity{

    public final static int HOME_INDEX=0;
    public final static int HOT_INDEX=1;
    public final static int ME_INDEX=2;

    private UserInfoContract.IUserInfoActivityPresenter mIActivityPresenter;
    private IActivityLifeCycle mIActivityLifeCycle;
    private UserInfoFragment homeFragment;
    private UserInfoFragment hotFragment;
    private UserInfoFragment meFragment;
    private List<Fragment> fragmentList;
    private List<String> titleList;

    @BindView(R.id.tv_name)TextView nameTv;
    @BindView(R.id.tv_age)TextView ageTv;
    @BindView(R.id.tv_address)TextView addressTv;
    @BindView(R.id.vpg_main)ViewPager mainVpg;
    @BindView(R.id.tv_main_home)TextView mainHomeTv;
    @BindView(R.id.tv_main_hot)TextView mainHotTv;
    @BindView(R.id.tv_main_me)TextView mainMeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initList();
        initFragment();
        new UserInfoActivityPresenter(this);
        mIActivityPresenter.start();
        mIActivityLifeCycle.onCreate();
    }

    public void initList(){
        fragmentList=new ArrayList<>();
        titleList=new ArrayList<>();
    }

    public void initFragment(){
        homeFragment=new UserInfoFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX,HOME_INDEX);
        homeFragment.setArguments(bundle);
        fragmentList.add(homeFragment);

        hotFragment=new UserInfoFragment();
        bundle=new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX,HOT_INDEX);
        hotFragment.setArguments(bundle);
        fragmentList.add(hotFragment);

        meFragment=new UserInfoFragment();
        bundle=new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX,ME_INDEX);
        meFragment.setArguments(bundle);
        fragmentList.add(meFragment);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        mainVpg.setAdapter(adapter);
        mainVpg.setOffscreenPageLimit(3);
        mainVpg.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(positionOffset==0.0){
                    switchTab(position);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mainVpg.setCurrentItem(0);

    }

    public void switchTab(int index){
        switch (index){
            case HOME_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.text_blue));
                mainHotTv.setTextColor(getResources().getColor(R.color.text_gray));
                mainMeTv.setTextColor(getResources().getColor(R.color.text_gray));
                break;
            case HOT_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.text_gray));
                mainHotTv.setTextColor(getResources().getColor(R.color.text_blue));
                mainMeTv.setTextColor(getResources().getColor(R.color.text_gray));
                break;
            case ME_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.text_gray));
                mainHotTv.setTextColor(getResources().getColor(R.color.text_gray));
                mainMeTv.setTextColor(getResources().getColor(R.color.text_blue));
                break;

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mIActivityLifeCycle.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIActivityLifeCycle.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIActivityLifeCycle.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIActivityLifeCycle.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mIActivityLifeCycle.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIActivityLifeCycle.onDestroy();
    }

    @Override
    public void showLoading() {
        Toast.makeText(UserInfoActivity.this, "正在加载", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(UserInfoActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        if(userInfoModel!=null){
            nameTv.setText(userInfoModel.getName());
            ageTv.setText(String.valueOf(userInfoModel.getAge()));//返回int参数的字符串表示形式
            addressTv.setText(userInfoModel.getAddress());
        }
    }

    @Override
    public void setPresenter(UserInfoContract.IUserInfoActivityPresenter mIActivityPresenter) {
        this.mIActivityPresenter=mIActivityPresenter;
    }

    @Override
    public void setLifeCycle(IActivityLifeCycle mIActivityLifeCycle) {
        this.mIActivityLifeCycle=mIActivityLifeCycle;
    }

    @OnClick(R.id.ly_main_home)void homeOnClick(){
        mainVpg.setCurrentItem(HOME_INDEX,false);
    }
    @OnClick(R.id.ly_main_hot)void hotOnClick(){
        mainVpg.setCurrentItem(HOT_INDEX,false);
    }
    @OnClick(R.id.ly_main_me)void meOnClick(){
        mainVpg.setCurrentItem(ME_INDEX,false);
    }
}
