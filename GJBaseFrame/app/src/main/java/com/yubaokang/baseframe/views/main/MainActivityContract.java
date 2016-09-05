package com.yubaokang.baseframe.views.main;

import com.yubaokang.baseframe.base.mvp.BaseView;
import com.yubaokang.baseframe.base.mvp.BasePresenter;

/**
 * Created by Hank on 2016/5/16.
 */
public interface MainActivityContract {
    interface Presenter extends BasePresenter {
        void loadStyleList();
    }

    interface View extends BaseView{
        void showBegin();

        void showSuccess();

        void showFailed();

        void showEnd();
    }
}
