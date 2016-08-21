package com.yubaokang.baseframe.dagger.module;

import android.app.Activity;

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
    private Activity activity;

    public MainActivityModule(MainActivityContract.View view, Activity activity) {
        this.view = view;
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public MainActivityPresenter getMainActivityPresenter() {
        return new MainActivityPresenter(view);
    }

    @ActivityScope
    @Provides
    public Activity getActivity() {
        return activity;
    }
}
