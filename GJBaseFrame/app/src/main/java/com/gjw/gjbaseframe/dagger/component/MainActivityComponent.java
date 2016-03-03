package com.gjw.gjbaseframe.dagger.component;

import com.gjw.gjbaseframe.dagger.injectInterface.ActivityScope;
import com.gjw.gjbaseframe.dagger.module.MainActivityModule;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPrestener;
import com.gjw.gjbaseframe.views.activitys.MainActivity;

import dagger.Component;

/**
 * Created by ybk on 2016/3/1.
 */
@ActivityScope
@Component(modules = MainActivityModule.class)//3 指明Component在哪些Module中查找依赖
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);

    MainActivityPrestener presenter();
}
