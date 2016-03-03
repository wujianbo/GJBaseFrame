package com.gjw.gjbaseframe.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.dagger.component.DaggerMainActivityComponent;
import com.gjw.gjbaseframe.dagger.module.MainActivityModule;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPrestener;
import com.gjw.gjbaseframe.model.natives.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Inject
    User user;
    @Inject
    MainActivityPrestener mainActivityPrestener;

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView2)
    TextView textView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textView.setText(user.getName());
        for (int i = 0; i < 10; i++) {
            mainActivityPrestener.login();
        }
    }

    @Override
    public void providers() {
        DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @OnClick({R.id.textView, R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.textView2:
                break;
        }
    }
}
