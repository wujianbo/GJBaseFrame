package com.gjw.gjbaseframe.dagger.module;

import android.content.Context;

import com.gjw.gjbaseframe.views.AppApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hank on 2016/3/2 11:10.
 */
@Module
public class AppApplicationModule {
    private AppApplication appApplication;

    public AppApplicationModule(AppApplication appApplication) {
        this.appApplication = appApplication;
    }

    @Provides
    @Singleton
    public AppApplication getApplication() {
        return appApplication;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return appApplication.getBaseContext();
    }
}
