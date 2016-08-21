package com.yubaokang.baseframe.dagger.component;

import android.app.Activity;

import com.yubaokang.baseframe.dagger.module.MainActivityModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.views.activitys.MainActivity;

import dagger.Component;

/**
 * Created by ybk on 2016/3/1.
 */
@ActivityScope
//3 指明Component在哪些Module中查找依赖
@Component(dependencies = AppComponent.class, modules = {MainActivityModule.class})
public interface MainActivityComponent {
    Activity activity();
    void inject(MainActivity mainActivity);
}
