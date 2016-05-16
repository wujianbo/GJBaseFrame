package com.gjw.gjbaseframe.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.dagger.component.DaggerMainActivityComponent;
import com.gjw.gjbaseframe.dagger.contract.MainActivityContract;
import com.gjw.gjbaseframe.dagger.module.AppApplicationModule;
import com.gjw.gjbaseframe.dagger.module.MainActivityModule;
import com.gjw.gjbaseframe.dagger.presenter.MainActivityPresenter;
import com.gjw.gjbaseframe.utils.T;
import com.gjw.gjbaseframe.views.AppApplication;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainActivityContract.View {
    @Inject
    MainActivityPresenter presenter;

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
    }

    @Override
    public void providers() {
        DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .appApplicationModule(new AppApplicationModule(new AppApplication()))
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
            default:
                break;
        }
    }

    @Override
    public void setPresenter(MainActivityContract.Presenter presenter) {
        this.presenter = (MainActivityPresenter) presenter;
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
