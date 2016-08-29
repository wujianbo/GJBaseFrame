package com.yubaokang.baseframe.views.main;

import com.yubaokang.baseframe.base.dagger.activity.ActivityComponent;
import com.yubaokang.baseframe.base.dagger.activity.ActivityModule;
import com.yubaokang.baseframe.base.dagger.app.AppComponent;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by ybk on 2016/3/1.
 */
@ActivityScope
//3 指明Component在哪些Module中查找依赖
@Component(dependencies = AppComponent.class, modules = {MainActivityModule.class, ActivityModule.class})
public interface MainActivityComponent extends ActivityComponent {
    void inject(MainActivity mainActivity);
}
