package com.yubaokang.baseframe.views.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.dagger.activity.ActivityModule;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.views.BaseActivity;
import com.hank.refresh.load.more.utils.T;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainActivityContract.View {
    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public void init(Bundle savedInstanceState) {
        presenter.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void providers() {
        DaggerMainActivityComponent.builder()
                .appComponent(App.getComponent())
                .activityModule(new ActivityModule(this))
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void apiCancel() {
        presenter.apiCancel();
    }

    @Override
    public View getCurrentLayout() {
        return null;
    }

    @OnClick({R.id.textView, R.id.textView2})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.textView2:
                break;
            default:
                break;
        }
    }

    @Override
    public void showBegin() {
        textView2.setText("开始...");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEnd() {
        textView2.setText("结束...");
        progressBar.setVisibility(View.GONE);
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