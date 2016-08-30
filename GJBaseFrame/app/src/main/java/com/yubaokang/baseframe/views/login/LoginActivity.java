package com.yubaokang.baseframe.views.login;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.dagger.activity.ActivityModule;
import com.yubaokang.baseframe.model.response.LoginData;
import com.hank.refresh.load.more.utils.T;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.views.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.edt_phone)
    EditText edt_phone;
    @BindView(R.id.edt_pwd)
    EditText edt_pwd;

    @Inject
    LoginBean loginBean;
    @Inject
    LoginPresenter presenter;

    @Override
    public void init(Bundle savedInstanceState) {
        presenter.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void apiCancel() {
        presenter.apiCancel();
    }

    @Override
    public void providers() {
        DaggerLoginComponent.builder()
                .appComponent(App.getComponent())
                .loginModule(new LoginModule(this))
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.btn_login)
    void click() {
        presenter.loadLoginData();
    }

    @Override
    public String loadPhone() {
        return edt_phone.getText().toString();
    }

    @Override
    public String loadPwd() {
        return edt_pwd.getText().toString();
    }

    @Override
    public void showLoginData(LoginData loginData) {
        T.show(this, "用户id:" + loginData.getData().getUserId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}