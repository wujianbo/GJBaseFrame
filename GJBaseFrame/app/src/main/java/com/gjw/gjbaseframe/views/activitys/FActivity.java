package com.gjw.gjbaseframe.views.activitys;

import android.os.Bundle;

import com.gjw.gjbaseframe.R;
import com.gjw.gjbaseframe.views.fragments.BaseFragmentActivity;
import com.gjw.gjbaseframe.views.fragments.Fragment1;

public class FActivity extends BaseFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        getSupportFragmentManager().beginTransaction().add(R.id.layout_container, new Fragment1()).commitAllowingStateLoss();
    }
}
