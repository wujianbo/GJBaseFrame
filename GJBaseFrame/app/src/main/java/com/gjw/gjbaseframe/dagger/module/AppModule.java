package com.gjw.gjbaseframe.dagger.module;

import android.content.Context;

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

    @Provides
    public Context getContext() {
        return context;
    }
}
