package com.xiaoxian.mvpdemo.module.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoxian.mvpdemo.R;
import com.xiaoxian.mvpdemo.module.contract.UserInfoContract;
import com.xiaoxian.mvpdemo.module.presenter.UserInfoFragmentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/5.
 */
public class UserInfoFragment extends Fragment implements UserInfoContract.IUserInfoFragment {

    public final static String PAGE_INDEX="page_index";
    private int pageIndex;
    private UserInfoContract.IUserInfoFragmentPresenter mIFragmentPresenter;
    private boolean isVisibleToUser=false;

    @BindView(R.id.tv_fgm)TextView fgmTv;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pageIndex=(int)getArguments().getSerializable(PAGE_INDEX)+1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main,null);
        ButterKnife.bind(this,view);
        fgmTv.setText("第"+pageIndex+"页");
        if(isVisibleToUser){
            new UserInfoFragmentPresenter(this);
            mIFragmentPresenter.start();
        }
        return view;
    }

    @Override
    public void showData() {
        Toast.makeText(getActivity(),"第"+pageIndex+"页面",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UserInfoContract.IUserInfoFragmentPresenter mIFragmentPresenter) {
        this.mIFragmentPresenter=mIFragmentPresenter;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser=isVisibleToUser;
    }
}
