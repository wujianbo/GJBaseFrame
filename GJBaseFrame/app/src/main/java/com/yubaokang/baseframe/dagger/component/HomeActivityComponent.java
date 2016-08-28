package com.yubaokang.baseframe.dagger.component;

import com.yubaokang.baseframe.dagger.module.ActivityModule;
import com.yubaokang.baseframe.dagger.module.HomeActivityModule;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.views.activitys.HomeActivity;

import dagger.Component;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {HomeActivityModule.class, ActivityModule.class})
public interface HomeActivityComponent extends ActivityComponent {
    void inject(HomeActivity homeActivity);
}
