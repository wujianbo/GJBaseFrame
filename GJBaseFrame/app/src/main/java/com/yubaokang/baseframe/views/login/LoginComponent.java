package com.yubaokang.baseframe.views.login;

import com.yubaokang.baseframe.base.dagger.app.AppComponent;
import com.yubaokang.baseframe.base.dagger.activity.ActivityModule;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Component;

/**
 * Created by yubao on 2016/8/29.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
