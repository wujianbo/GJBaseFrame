package com.yubaokang.baseframe.views.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.adapter.fragment.MyFragmentPagerAdapter;
import com.yubaokang.baseframe.dagger.component.DaggerHomeActivityComponent;
import com.yubaokang.baseframe.dagger.contract.HomeActivityContract;
import com.yubaokang.baseframe.dagger.module.ActivityModule;
import com.yubaokang.baseframe.dagger.module.HomeActivityModule;
import com.yubaokang.baseframe.dagger.presenter.HomeActivityPresenter;
import com.yubaokang.baseframe.views.App;
import com.yubaokang.baseframe.views.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeActivityContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @Inject
    HomeActivityPresenter presenter;

    @Override
    public void init(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void providers() {
        DaggerHomeActivityComponent.builder().appComponent(App.getComponent())
                .activityModule(new ActivityModule(this))
                .homeActivityModule(new HomeActivityModule(this))
                .build()
                .inject(this);
    }

//    @OnClick({R.id.tabItem0, R.id.tabItem1, R.id.tabItem2})
//    void clickItem0(View view) {
//        switch (view.getId()) {
//            case R.id.tabItem0:
//                viewPager.setCurrentItem(0);
//                break;
//            case R.id.tabItem1:
//                viewPager.setCurrentItem(1);
//                break;
//            case R.id.tabItem2:
//                viewPager.setCurrentItem(2);
//                break;
//            default:
//                break;
//        }
//    }
}
