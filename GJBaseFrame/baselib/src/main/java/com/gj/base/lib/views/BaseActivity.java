package com.gj.base.lib.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gj.base.lib.loading.VaryViewHelperController;
import com.gj.base.lib.mvp.BaseView;

import butterknife.ButterKnife;


/**
 * Created by ybk on 2016/3/1.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    protected VaryViewHelperController mVaryViewHelperController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        if (getCurrentLayout() == null) {
            throw new NullPointerException("getCurrentLayout() 不能返回 null");
        }
        mVaryViewHelperController = new VaryViewHelperController(getCurrentLayout());
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        apiCancel();
    }

    public abstract void init(Bundle savedInstanceState);//初始化操作

    public abstract int getLayoutId();//获取布局id

    public abstract void apiCancel();//销毁界面时，取消所有请求

    public abstract View getCurrentLayout();

    @Override
    public void showLoading() {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.showLoading();
        }
    }

    @Override
    public void showNetWork(View.OnClickListener clickListener) {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.showNetworkError(clickListener);
        }
    }

    @Override
    public void showEmpty() {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.showEmpty("没有数据");
        }
    }

    @Override
    public void restore() {
        if (mVaryViewHelperController != null) {
            mVaryViewHelperController.restore();
        }
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && v instanceof EditText) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
