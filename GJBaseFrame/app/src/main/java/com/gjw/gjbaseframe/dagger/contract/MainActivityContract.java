package com.gjw.gjbaseframe.dagger.contract;

import com.gjw.gjbaseframe.dagger.presenter.BasePresenter;

/**
 * Created by Hank on 2016/5/16.
 */
public interface MainActivityContract {
    interface Presenter extends BasePresenter {
        void loadLogin();
    }

    interface View extends BaseView<Presenter> {

        void showSuccess();

        void showFailed();
    }
}
