package com.yubaokang.baseframe.dagger.module;

import android.support.v4.app.Fragment;

import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yubao on 2016/8/27.
 */
@Module
public class  FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @ActivityScope
    public Fragment fragment() {
        return fragment;
    }
}
