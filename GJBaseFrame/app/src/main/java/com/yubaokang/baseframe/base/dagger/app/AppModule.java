package com.yubaokang.baseframe.base.dagger.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hank on 2016/3/2 11:10.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context getContext() {
        return context;
    }
}
