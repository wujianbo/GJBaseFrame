package com.yubaokang.baseframe.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.adapter.fragment.MyFragmentPagerAdapter;
import com.yubaokang.baseframe.base.dagger.activity.ActivityModule;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.views.BaseActivity;
import com.yubaokang.baseframe.views.ScrollingActivity;
import com.yubaokang.baseframe.views.login.LoginActivity;

import java.util.ArrayList;
import java.util.Arrays;
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
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_camera);
        toolbar.setTitle("小宝");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance());
        fragments.add(Home2Fragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, Arrays.asList("AAA", "BBB", "CCC")));
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    private HomeActivityComponent homeActivityComponent;

    @Override
    public void providers() {
        homeActivityComponent = DaggerHomeActivityComponent.builder()
                .appComponent(App.getComponent())
                .activityModule(new ActivityModule(this))
                .homeActivityModule(new HomeActivityModule(this))
                .build();
        homeActivityComponent.inject(this);
    }

    @Override
    public void apiCancel() {
        presenter.apiCancel();
    }

    public HomeActivityComponent getHomeActivityComponent() {
        return homeActivityComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_0:
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
            case R.id.item_1:
                break;
            case R.id.item_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
