package com.yubaokang.baseframe.views.login;

import android.app.Activity;

import com.yubaokang.baseframe.utils.L;

import javax.inject.Inject;

/**
 * Created by yubao on 2016/8/29.
 */

public class LoginBean {
    private String name;

    @Inject
    public LoginBean(Activity context) {
        this.name = "小宝";
        context.getResources();
        if (context instanceof Activity) {
            L.i("aaaaaaaaaaaaa");
        } else {
            L.i("bbbbbbbbbbbbb");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
