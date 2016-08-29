package com.yubaokang.baseframe.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;
import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.adapter.list.MultiItemTypeAdapter;
import com.yubaokang.baseframe.base.adapter.list.wrapper.HeaderAndFooterWrapper;
import com.yubaokang.baseframe.base.adapter.list.wrapper.LoadMoreWrapper;
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
    PullRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    HomeFragmentPresenter presenter;

    private List<WeiXinDataListRes.Result.ListBean> datas;
    private HomeAdapter adapter;
    private HeaderAndFooterWrapper headerAndFooterWrapper;
    private LoadMoreWrapper mLoadMoreWrapper;

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


    private int pageNum = 1;

    @Override
    public void init(View view, @Nullable Bundle savedInstanceState) {
        presenter.start();
        datas = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), R.layout.item_home, datas);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        initHeaderAndFooter();
        mLoadMoreWrapper = new LoadMoreWrapper(headerAndFooterWrapper);
        mLoadMoreWrapper.setLoadMoreView(R.layout.layout_load_more);
        recyclerView.setAdapter(mLoadMoreWrapper);

        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                presenter.loadDatas();
            }
        });
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pageNum++;
                presenter.loadDatas();
            }
        });

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener<WeiXinDataListRes.Result.ListBean>() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, WeiXinDataListRes.Result.ListBean listBean, int position) {
                Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra(BaseWebActivity.URL, listBean.getUrl());
                startActivity(intent);
            }
        });
    }

    private void initHeaderAndFooter() {
        headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        TextView t1 = new TextView(getActivity());
        t1.setText("Header 1");
        TextView t2 = new TextView(getActivity());
        t2.setText("Header 2");
        headerAndFooterWrapper.addHeaderView(t1);
        headerAndFooterWrapper.addHeaderView(t2);
    }

    @Override
    public void apiCancel() {
        presenter.apiCancel();
    }

    @Override
    public int loadPageNum() {
        return pageNum;
    }

    @Override
    public void showDatas(WeiXinDataListRes weiXinDataListRes) {
        swipeRefreshLayout.setRefreshing(false);
        List<WeiXinDataListRes.Result.ListBean> lists = weiXinDataListRes.getResult().getList();
        if (ListUtil.isNotEmpty(lists)) {
            if (pageNum == 1) {
                datas.clear();
                datas.addAll(lists);
                mLoadMoreWrapper.notifyDataSetChanged();
            } else {
                datas.addAll(lists);
                mLoadMoreWrapper.notifyDataSetChanged();
            }
        }
    }
}
