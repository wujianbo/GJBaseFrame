package com.yubaokang.baseframe.dagger.component;

import com.yubaokang.baseframe.views.activitys.SecondActivity;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.dagger.module.SecondActivityModule;
import com.yubaokang.baseframe.dagger.presenter.SecondActivityPresenter;

import dagger.Component;

/**
 * Created by Hank on 2016/3/3 16:48.
 */
@ActivityScope
@Component(modules = {SecondActivityModule.class})
public interface SecondActivityComponent {
    SecondActivityPresenter presenter();

    SecondActivity inject(SecondActivity secondActivity);
}
