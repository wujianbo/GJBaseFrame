package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.app.AppComponent;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
}
