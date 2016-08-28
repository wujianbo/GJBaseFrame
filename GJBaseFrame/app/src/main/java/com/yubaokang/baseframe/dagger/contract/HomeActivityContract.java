package com.yubaokang.baseframe.dagger.contract;

import com.yubaokang.baseframe.dagger.presenter.BasePresenter;

/**
 * Created by yubao on 2016/8/27.
 */

public interface HomeActivityContract {

    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<MainActivityContract.Presenter> {

    }
}
