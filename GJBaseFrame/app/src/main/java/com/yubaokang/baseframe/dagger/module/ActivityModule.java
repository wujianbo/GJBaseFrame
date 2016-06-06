package com.yubaokang.baseframe.dagger.module;

import android.app.Activity;

import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hank on 2016/6/2.
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity activity() {
        return activity;
    }
}
