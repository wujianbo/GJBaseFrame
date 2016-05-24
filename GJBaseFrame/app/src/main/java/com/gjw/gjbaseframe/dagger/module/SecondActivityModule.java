package com.gjw.gjbaseframe.dagger.module;

import com.gjw.gjbaseframe.views.activitys.SecondActivity;
import com.gjw.gjbaseframe.dagger.scopes.ActivityScope;
import com.gjw.gjbaseframe.dagger.presenter.SecondActivityPresenter;

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
        return new SecondActivityPresenter(secondActivity);
    }

}
