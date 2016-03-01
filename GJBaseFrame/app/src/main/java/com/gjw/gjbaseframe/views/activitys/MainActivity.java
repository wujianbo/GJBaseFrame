package com.gjw.gjbaseframe.views.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.dagger.component.DaggerMainActivityComponent;
import com.gjw.gjbaseframe.model.natives.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Inject
    User user;

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainActivityComponent.create().injtct(this);
        textView.setText(user.getName());
    }

    @OnClick({R.id.textView, R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.textView2:
                break;
        }
    }
}
