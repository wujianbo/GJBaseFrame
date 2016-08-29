package com.yubaokang.baseframe.base.views;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        apiCancel();
    }

    public abstract void init(Bundle savedInstanceState);//初始化操作

    public abstract int getLayoutId();//获取布局id

    public abstract void providers();//初始化DaggerXXXComponent

    public abstract void apiCancel();//销毁界面时，取消所有请求
}
