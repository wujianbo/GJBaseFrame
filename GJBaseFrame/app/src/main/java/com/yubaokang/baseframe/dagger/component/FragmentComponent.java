package com.yubaokang.baseframe.dagger.component;

import android.support.v4.app.Fragment;

import com.yubaokang.baseframe.dagger.module.FragmentModule;
import com.yubaokang.baseframe.dagger.scopes.FragmentScope;

import dagger.Component;

/**
 * Created by yubao on 2016/8/27.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Fragment fragment();
}
