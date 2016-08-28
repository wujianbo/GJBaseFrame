package com.yubaokang.baseframe.dagger.component;

import com.yubaokang.baseframe.dagger.module.FragmentModule;
import com.yubaokang.baseframe.dagger.module.HomeFragmentModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.views.fragments.HomeFragment;

import dagger.Component;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
//@Singleton
@Component(dependencies = AppComponent.class, modules = {HomeFragmentModule.class, FragmentModule.class})
public interface HomeFragmentComponent extends FragmentComponent {
    void inject(HomeFragment homeFragment);
}
