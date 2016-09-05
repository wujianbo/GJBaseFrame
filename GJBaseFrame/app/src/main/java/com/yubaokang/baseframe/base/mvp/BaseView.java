package com.yubaokang.baseframe.base.mvp;

import android.view.View;

/**
 * Created by Hank on 2016/5/16.
 */
public interface BaseView {
    //    void setPresenter(T presenter);
    void showLoading();

    void showNetWork(View.OnClickListener clickListener);

    void showEmpty();

    void restore();
}
