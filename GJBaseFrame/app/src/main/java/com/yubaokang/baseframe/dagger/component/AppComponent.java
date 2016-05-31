package com.yubaokang.baseframe.dagger.component;

import android.content.Context;

import com.yubaokang.baseframe.dagger.module.AppModule;
import com.yubaokang.baseframe.http.IRetrofitRequest;
import com.yubaokang.baseframe.http.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hank on 2016/3/2 11:11.
 */
@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {
    IRetrofitRequest request();

    Context getContext();
}
