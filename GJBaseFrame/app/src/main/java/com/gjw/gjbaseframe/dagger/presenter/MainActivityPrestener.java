package com.gjw.gjbaseframe.dagger.presenter;

import com.gjw.gjbaseframe.http.RCallback;
import com.gjw.gjbaseframe.model.response.LoginRes;
import com.gjw.gjbaseframe.utils.L;
import com.gjw.gjbaseframe.views.AppApplication;
import com.gjw.gjbaseframe.views.activitys.MainActivity;

import javax.inject.Singleton;

/**
 * Created by ybk on 2016/3/1.
 */
@Singleton
public class MainActivityPrestener {

    private MainActivity mainActivity;

    public MainActivityPrestener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void login() {
        AppApplication.get().getAppComponent().getService().login("aaaa", "bbbb").enqueue(new RCallback<LoginRes>() {
            @Override
            public void onSuccess(LoginRes response) {

            }
        });
        L.i("---------->>>>>>");
    }

}
