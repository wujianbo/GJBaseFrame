package com.yubaokang.baseframe.views.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ybk on 2016/3/1.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        providers();
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    public abstract void init(Bundle savedInstanceState);

    public abstract int getLayoutId();

    public abstract void providers();
}
