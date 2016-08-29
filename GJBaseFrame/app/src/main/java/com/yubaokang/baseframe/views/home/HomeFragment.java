package com.yubaokang.baseframe.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.adapter.list.recyclerview.OnItemClickListener;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.views.BaseFragment;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.utils.ListUtil;
import com.yubaokang.baseframe.views.webview.BaseWebActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    HomeFragmentPresenter presenter;

    private HomeAdapter adapter;
    private List<WeiXinDataListRes.Result.ListBean> datas;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void providers() {
        if (getActivity() instanceof HomeActivity) {
            DaggerHomeFragmentComponent.builder()
                    .appComponent(App.getComponent())
                    .homeFragmentModule(new HomeFragmentModule(this))
                    .build()
                    .inject(this);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init(View view, @Nullable Bundle savedInstanceState) {
        presenter.start();
        datas = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), datas);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadDatas();
            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener<WeiXinDataListRes.Result.ListBean>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, WeiXinDataListRes.Result.ListBean listBean, int position) {
                Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra(BaseWebActivity.URL, listBean.getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void apiCancel() {
        presenter.apiCancel();
    }

    @Override
    public int loadPageNum() {
        return 1;
    }

    @Override
    public void showDatas(WeiXinDataListRes weiXinDataListRes) {
        swipeRefreshLayout.setRefreshing(false);
        List<WeiXinDataListRes.Result.ListBean> lists = weiXinDataListRes.getResult().getList();
        if (ListUtil.isNotEmpty(lists)) {
            datas.clear();
            datas.addAll(lists);
            adapter.notifyDataSetChanged();
        }
    }
}
