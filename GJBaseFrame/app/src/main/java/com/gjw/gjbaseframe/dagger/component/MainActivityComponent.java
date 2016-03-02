package com.gjw.gjbaseframe.dagger.component;

import com.gjw.gjbaseframe.dagger.module.MainActivityModule;
import com.gjw.gjbaseframe.views.activitys.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ybk on 2016/3/1.
 */
@Singleton
@Component(modules = MainActivityModule.class)//3 指明Component在哪些Module中查找依赖
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
