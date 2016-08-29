package com.yubaokang.baseframe.views.login;

import android.app.Activity;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yubao on 2016/8/29.
 */
@Module
public class LoginModule {
    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    LoginPresenter loginPresenter(Activity activity) {
        return new LoginPresenter(activity, view);
    }
}
