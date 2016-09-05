package com.yubaokang.baseframe.views.login;

import com.yubaokang.baseframe.base.mvp.BaseView;
import com.yubaokang.baseframe.base.mvp.BasePresenter;
import com.yubaokang.baseframe.model.response.LoginData;

/**
 * Created by yubaokang on 2016/8/29.
 */

public interface LoginContract {
    interface Presenter extends BasePresenter {
        void loadLoginData();
    }

    interface View extends BaseView {
        String loadPhone();

        String loadPwd();

        void showLoginData(LoginData loginData);
    }
}
