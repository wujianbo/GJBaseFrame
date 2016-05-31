package com.yubaokang.baseframe.dagger.contract;

import com.yubaokang.baseframe.dagger.presenter.BasePresenter;

/**
 * Created by Hank on 2016/5/16.
 */
public interface MainActivityContract {
    interface Presenter extends BasePresenter {
        void loadStyleList();
    }

    interface View extends BaseView<Presenter> {
        void showSuccess();

        void showFailed();
    }
}
