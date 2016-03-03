package com.gjw.gjbaseframe.views.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.dagger.component.DaggerSecondActivityComponent;
import com.gjw.gjbaseframe.dagger.module.SecondActivityModule;
import com.gjw.gjbaseframe.dagger.presenter.SecondActivityPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {

    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.button)
    Button button;
    @Inject
    SecondActivityPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        presenter.setName();
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
