package com.yubaokang.baseframe.base.dagger.app;

import android.app.Application;

import com.yubaokang.baseframe.http.RetrofitModule;

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
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

}
