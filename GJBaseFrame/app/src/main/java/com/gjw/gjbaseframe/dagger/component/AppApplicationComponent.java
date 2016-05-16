package com.gjw.gjbaseframe.dagger.component;

import android.content.Context;

import com.gjw.gjbaseframe.dagger.module.AppApplicationModule;
import com.gjw.gjbaseframe.http.IRetrofitRequest;
import com.gjw.gjbaseframe.http.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hank on 2016/3/2 11:11.
 */
@Singleton
@Component(modules = {AppApplicationModule.class, RetrofitModule.class})
public interface AppApplicationComponent {
    IRetrofitRequest getService();

    Context getContext();
}
