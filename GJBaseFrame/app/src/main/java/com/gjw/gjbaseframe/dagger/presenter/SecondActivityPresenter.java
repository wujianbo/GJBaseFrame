package com.gjw.gjbaseframe.dagger.presenter;

import com.gjw.gjbaseframe.views.activitys.SecondActivity;

/**
 * Created by Hank on 2016/3/3 16:43.
 */
public class SecondActivityPresenter {
    private SecondActivity secondActivity;

    public SecondActivityPresenter(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    public void setName() {
        secondActivity.setTextName();
    }

}
