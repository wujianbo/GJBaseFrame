package com.gjw.gjbaseframe.dagger.module;

import com.gjw.gjbaseframe.views.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hank on 2016/3/2 11:10.
 */
@Module
public class AppApplicationModule {
    private App appApplication;

    public AppApplicationModule(App appApplication) {
        this.appApplication = appApplication;
    }

    @Provides
    @Singleton
    public App getAppApplication() {
        return appApplication;
    }
}
