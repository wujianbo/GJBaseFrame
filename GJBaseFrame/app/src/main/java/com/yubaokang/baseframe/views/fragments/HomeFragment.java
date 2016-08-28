package com.yubaokang.baseframe.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.dagger.component.DaggerHomeFragmentComponent;
import com.yubaokang.baseframe.dagger.contract.HomeFragmentContract;
import com.yubaokang.baseframe.dagger.module.FragmentModule;
import com.yubaokang.baseframe.dagger.module.HomeFragmentModule;
import com.yubaokang.baseframe.dagger.presenter.HomeFragmentPresenter;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.utils.T;
import com.yubaokang.baseframe.views.App;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @Inject
    HomeFragmentPresenter presenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void providers() {
        DaggerHomeFragmentComponent.builder()
                .appComponent(App.getComponent())
                .fragmentModule(new FragmentModule(this))
                .homeFragmentModule(new HomeFragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init(View view, @Nullable Bundle savedInstanceState) {
        presenter.start();
    }

    @Override
    public int loadPageNum() {
        return 1;
    }

    @Override
    public void showDatas(WeiXinDataListRes weiXinDataListRes) {
        T.show(getActivity(), weiXinDataListRes.toString());
    }
}
