package com.gjw.gjbaseframe.views;

import android.app.Application;

import com.gjw.gjbaseframe.dagger.component.AppApplicationComponent;
import com.gjw.gjbaseframe.dagger.component.DaggerAppApplicationComponent;
import com.gjw.gjbaseframe.dagger.module.AppApplicationModule;

/**
 * Created by ybk on 2016/3/1.
 */
public class App extends Application {
    private static AppApplicationComponent appApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appApplicationComponent = DaggerAppApplicationComponent.builder()
                .appApplicationModule(new AppApplicationModule(this))
                .build();
        appApplicationComponent.inject(this);
    }

    public static AppApplicationComponent getComponent() {
        return appApplicationComponent;
    }
}
