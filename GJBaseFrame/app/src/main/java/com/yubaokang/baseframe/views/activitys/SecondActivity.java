package com.yubaokang.baseframe.views.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.dagger.component.DaggerSecondActivityComponent;
import com.yubaokang.baseframe.dagger.module.SecondActivityModule;
import com.yubaokang.baseframe.dagger.presenter.SecondActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {

    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.button)
    Button button;
    @Inject
    SecondActivityPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    @Override
    public void providers() {
        DaggerSecondActivityComponent.builder()
                .secondActivityModule(new SecondActivityModule(this))
                .build()
                .inject(this);
    }

    @OnClick({R.id.textView3, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView3:
                break;
            case R.id.button:
                break;
        }
    }

    public void setTextName() {
        textView3.setText("你好啊");
    }
}
