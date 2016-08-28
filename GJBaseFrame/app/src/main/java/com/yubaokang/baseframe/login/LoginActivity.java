package com.yubaokang.baseframe.login;

import android.os.Bundle;
import android.widget.TextView;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.views.activitys.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.textView4)
    TextView textView4;

    @Inject
    LoginBean loginBean;

    @Override
    public void init(Bundle savedInstanceState) {
        textView4.setText(loginBean.getName());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void providers() {
        DaggerLoginComponent.builder().build().inject(this);
    }
}