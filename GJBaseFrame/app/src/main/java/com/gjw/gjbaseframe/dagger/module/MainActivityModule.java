package com.gjw.gjbaseframe.dagger.module;

import com.gjw.gjbaseframe.dagger.contract.MainActivityContract;
import com.gjw.gjbaseframe.dagger.injectInterface.ActivityScope;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPresenter;
import com.gjw.gjbaseframe.model.natives.User;

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

    @Provides//2 注明该方法是用来提供依赖对象的特殊方法
    public User getUser() {
        return new User("余宝康");
    }

    @ActivityScope
    @Provides
    MainActivityContract.View provideMainActivity() {
        return view;
    }

    @ActivityScope
    @Provides
    public MainActivityPresenter getMainActivityPresenter(MainActivityContract.View view) {
        return new MainActivityPresenter(view);
    }
}
