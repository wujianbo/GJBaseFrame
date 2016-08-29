package com.yubaokang.baseframe.base.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Hank on 2016/3/3 17:27.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        providers();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        apiCancel();
    }

    public abstract void providers();

    public abstract int getLayoutId();

    public abstract void init(View view, @Nullable Bundle savedInstanceState);

    public abstract void apiCancel();//销毁界面时，取消所有请求
}
