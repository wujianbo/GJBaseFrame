package com.yubaokang.baseframe.dagger.component;

import android.app.Activity;

import com.yubaokang.baseframe.dagger.module.ActivityModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Hank on 2016/6/2.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
