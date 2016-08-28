package com.yubaokang.baseframe.dagger.component;

import com.yubaokang.baseframe.dagger.module.HomeFragmentModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.views.fragments.HomeFragment;

import dagger.Subcomponent;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
@Subcomponent(modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
