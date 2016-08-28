package com.yubaokang.baseframe.dagger.presenter;

import com.yubaokang.baseframe.dagger.contract.HomeActivityContract;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
public class HomeActivityPresenter implements HomeActivityContract.Presenter {

    private HomeActivityContract.View view;

    public HomeActivityPresenter(HomeActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void cancel() {

    }
}
