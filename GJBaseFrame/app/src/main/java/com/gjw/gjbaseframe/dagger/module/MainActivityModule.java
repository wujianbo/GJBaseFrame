package com.gjw.gjbaseframe.dagger.module;

import com.gjw.gjbaseframe.dagger.contract.MainActivityContract;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPresenter;
import com.gjw.gjbaseframe.dagger.presenter.SecondActivityPresenter;
import com.gjw.gjbaseframe.dagger.scopes.ActivityScope;

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
    public MainActivityPresenter getMainActivityPresenter() {
        return new MainActivityPresenter(view);
    }

    @Provides
    public SecondActivityPresenter getSecondActivityPresenter() {
        return new SecondActivityPresenter();
    }
}
