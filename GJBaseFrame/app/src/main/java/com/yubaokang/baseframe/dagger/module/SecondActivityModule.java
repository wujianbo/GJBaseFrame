package com.yubaokang.baseframe.dagger.module;

import com.yubaokang.baseframe.views.activitys.SecondActivity;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.dagger.presenter.SecondActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hank on 2016/3/3 16:44.
 */
@Module
public class SecondActivityModule {
    private SecondActivity secondActivity;

    public SecondActivityModule(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Provides
    @ActivityScope
    SecondActivity secondActivity() {
        return secondActivity;
    }

    @Provides
    @ActivityScope
    SecondActivityPresenter secondActivityPresenter() {
        return new SecondActivityPresenter();
    }
}
