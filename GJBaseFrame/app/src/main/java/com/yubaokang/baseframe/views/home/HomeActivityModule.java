package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yubao on 2016/8/27.
 */
@Module
public class HomeActivityModule {
    private HomeActivityContract.View view;

    public HomeActivityModule(HomeActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public HomeActivityPresenter getPresenter() {
        return new HomeActivityPresenter(view);
    }
}
