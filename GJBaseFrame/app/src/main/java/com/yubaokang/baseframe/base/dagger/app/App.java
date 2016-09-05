package com.yubaokang.baseframe.base.dagger.app;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;
import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.http.RetrofitModule;

/**
 * Created by ybk on 2016/3/1.
 */
public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ViewTarget.setTagId(R.id.glide_tag);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }
}
