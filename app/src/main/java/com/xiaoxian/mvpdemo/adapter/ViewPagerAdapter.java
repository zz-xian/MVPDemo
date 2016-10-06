package com.xiaoxian.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/5.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> titleList) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titleList=titleList;
    }

    @Override
    public int getCount() {
        return (fragmentList==null)?0:fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titleList.size()>position)?titleList.get(position):"";
    }

    @Override
    public Fragment getItem(int arg0) {
        return (fragmentList==null||fragmentList.size()==0)?null:fragmentList.get(arg0);
    }
}
