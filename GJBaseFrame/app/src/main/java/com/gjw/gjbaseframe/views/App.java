package com.gjw.gjbaseframe.views;

import android.app.Application;

import com.gjw.gjbaseframe.dagger.component.AppComponent;
import com.gjw.gjbaseframe.dagger.component.DaggerAppComponent;
import com.gjw.gjbaseframe.dagger.module.AppModule;

/**
 * Created by ybk on 2016/3/1.
 */
public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }
}
