package com.gjw.gjbaseframe.views;

import android.app.Application;

import com.gjw.gjbaseframe.dagger.component.AppApplicationComponent;
import com.gjw.gjbaseframe.dagger.component.DaggerAppApplicationComponent;
import com.gjw.gjbaseframe.dagger.module.AppApplicationModule;
import com.gjw.gjbaseframe.http.RetrofitModule;

/**
 * Created by ybk on 2016/3/1.
 */
public class AppApplication extends Application {
    private AppApplicationComponent appComponent;
    private static AppApplication appApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        appApplication = this;
        appComponent = DaggerAppApplicationComponent.builder()
                .appApplicationModule(new AppApplicationModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public AppApplicationComponent getAppComponent() {
        return appComponent;
    }

    public static AppApplication get() {
        return appApplication;
    }
}
