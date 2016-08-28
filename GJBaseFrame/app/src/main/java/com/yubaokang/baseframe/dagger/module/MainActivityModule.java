package com.yubaokang.baseframe.dagger.module;

import com.yubaokang.baseframe.dagger.contract.MainActivityContract;
import com.yubaokang.baseframe.dagger.presenter.MainActivityPresenter;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

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
