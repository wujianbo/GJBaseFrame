package com.yubaokang.baseframe.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.dagger.component.DaggerMainActivityComponent;
import com.yubaokang.baseframe.dagger.component.MainActivityComponent;
import com.yubaokang.baseframe.dagger.contract.MainActivityContract;
import com.yubaokang.baseframe.dagger.module.MainActivityModule;
import com.yubaokang.baseframe.dagger.presenter.MainActivityPresenter;
import com.yubaokang.baseframe.dagger.presenter.SecondActivityPresenter;
import com.yubaokang.baseframe.utils.T;
import com.yubaokang.baseframe.views.App;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainActivityContract.View {
    @Inject
    MainActivityPresenter presenter;
    @Inject
    SecondActivityPresenter secondActivityPresenter;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView2)
    TextView textView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.start();
        secondActivityPresenter.set();
    }

    @Override
    public void providers() {
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .appComponent(App.getComponent())
                .build();
        mainActivityComponent.inject(this);
    }

    @OnClick({R.id.textView, R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.textView2:
                break;
            default:
                break;
        }
    }

    @Override
    public void showSuccess() {
        T.show(this, "成功");
    }

    @Override
    public void showFailed() {
        T.show(this, "失败");
    }

}