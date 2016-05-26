package com.gjw.gjbaseframe.views.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ybk on 2016/3/1.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        providers();
    }

    public abstract void providers();

}
