package com.yubaokang.baseframe.views.login;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.gj.base.lib.utils.MD5Utils;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.model.response.LoginData;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by yubaokang on 2016/8/29.
 */

public class LoginPresenter implements LoginContract.Presenter {
    @NonNull
    private Activity activity;
    private LoginContract.View view;
    private Subscription login;

    public LoginPresenter(Activity activity, LoginContract.View view) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void apiCancel() {
        if (login != null) {
            login.cancel();
        }
    }

    @Override
    public void loadLoginData() {
        App.getComponent().request().login(view.loadPhone(), MD5Utils.getMD5Str(view.loadPwd()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginData>() {

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Subscription s) {
                        login = s;
                    }

                    @Override
                    public void onNext(LoginData loginData) {
                        view.showLoginData(loginData);
                    }
                });
    }
}
