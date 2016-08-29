package com.yubaokang.baseframe.base.dagger.activity;

import android.app.Activity;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by Hank on 2016/6/2.
 */
@ActivityScope
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
