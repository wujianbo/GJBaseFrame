package com.yubaokang.baseframe.base.dagger.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Hank on 2016/3/3 16:30.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
