package com.gjw.gjbaseframe.dagger.module;

import com.gjw.gjbaseframe.dagger.injectInterface.ActivityScope;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPrestener;
import com.gjw.gjbaseframe.model.natives.User;
import com.gjw.gjbaseframe.views.activitys.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ybk on 2016/3/1.
 */
@Module//1  注明本类属于Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides//2 注明该方法是用来提供依赖对象的特殊方法
    public User getUser() {
        return new User("余宝康");
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivityPrestener getMainActivityPrestender(MainActivity mainActivity) {
        return new MainActivityPrestener(mainActivity);
    }
}
