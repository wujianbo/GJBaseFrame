package com.yubaokang.baseframe.base.dagger.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Hank on 2016/3/2 15:34.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface StringNamed {
    String value();
}
