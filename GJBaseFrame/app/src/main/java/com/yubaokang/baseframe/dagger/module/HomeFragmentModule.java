package com.yubaokang.baseframe.dagger.module;

import com.yubaokang.baseframe.dagger.contract.HomeFragmentContract;
import com.yubaokang.baseframe.dagger.presenter.HomeFragmentPresenter;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yubao on 2016/8/27.
 */
@Module
public class HomeFragmentModule {
    private HomeFragmentContract.View view;

    public HomeFragmentModule(HomeFragmentContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public HomeFragmentPresenter getPresenter() {
        return new HomeFragmentPresenter(view);
    }
}
