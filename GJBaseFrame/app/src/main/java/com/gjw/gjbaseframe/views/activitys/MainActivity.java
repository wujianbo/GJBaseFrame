package com.gjw.gjbaseframe.views.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.dagger.component.DaggerMainActivityComponent;
import com.gjw.gjbaseframe.http.RCallback;
import com.gjw.gjbaseframe.model.natives.User;
import com.gjw.gjbaseframe.model.response.LoginRes;
import com.gjw.gjbaseframe.utils.L;
import com.gjw.gjbaseframe.views.AppApplication;

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
        DaggerMainActivityComponent.create().inject(this);
        textView.setText(user.getName());
        for (int i = 0; i < 10; i++) {
            ((AppApplication) getApplication()).getAppComponent().getService().login("aaaa", "bbbb").enqueue(new RCallback<LoginRes>() {
                @Override
                public void onSuccess(LoginRes response) {

                }
            });
            L.i("-------------->>>>>111111");
        }
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
