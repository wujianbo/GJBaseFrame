package com.yubaokang.baseframe.views.activitys;

import android.os.Bundle;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.views.fragments.BaseFragmentActivity;
import com.yubaokang.baseframe.views.fragments.Fragment1;

public class FActivity extends BaseFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        getSupportFragmentManager().beginTransaction().add(R.id.layout_container, new Fragment1()).commitAllowingStateLoss();
    }
}
