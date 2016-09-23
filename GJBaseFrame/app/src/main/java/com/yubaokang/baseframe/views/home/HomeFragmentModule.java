package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yubao on 2016/8/27.
 */
@Module
public class HomeFragmentModule {
    private HomeFragmentContract.View view;
    @Inject
    public HomeFragmentModule() {
    }

    public HomeFragmentModule(HomeFragmentContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public HomeFragmentPresenter getPresenter() {
        return new HomeFragmentPresenter(view);
    }
}
