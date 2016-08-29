package com.yubaokang.baseframe.views.main;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ybk on 2016/3/1.
 */
@Module//1  注明本类属于Module
public class MainActivityModule {
    private MainActivityContract.View view;

    public MainActivityModule(MainActivityContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainActivityPresenter getMainActivityPresenter() {
        return new MainActivityPresenter(view);
    }
}
