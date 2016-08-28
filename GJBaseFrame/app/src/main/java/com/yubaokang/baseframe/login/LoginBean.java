package com.yubaokang.baseframe.login;

import javax.inject.Inject;

/**
 * Created by yubao on 2016/8/29.
 */

public class LoginBean {
    private String name;

    @Inject
    public LoginBean() {
        this.name = "小宝";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
