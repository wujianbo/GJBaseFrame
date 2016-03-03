package com.gjw.gjbaseframe.dagger.component;

import com.gjw.gjbaseframe.dagger.injectInterface.ActivityScope;
import com.gjw.gjbaseframe.dagger.module.SecondActivityModule;
import com.gjw.gjbaseframe.dagger.presenter.SecondActivityPresenter;
import com.gjw.gjbaseframe.views.activitys.SecondActivity;

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
