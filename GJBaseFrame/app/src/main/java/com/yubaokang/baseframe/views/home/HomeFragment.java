package com.yubaokang.baseframe.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hank.refresh.load.more.adapter.MultiItemTypeAdapter;
import com.hank.refresh.load.more.adapter.wrapper.LoadMoreWrapper;
import com.hank.refresh.load.more.refresh.PtrDefaultFrameLayout;
import com.hank.refresh.load.more.utils.ImageUtils;
import com.hank.refresh.load.more.utils.ListUtil;
import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.views.BaseFragment;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.views.webview.BaseWebActivity;
import com.yubaokang.baseframe.views.widgets.RecycleEmptyErrorView;
import com.yubaokang.baseframe.views.widgets.autoscrollviewpager.AutoScrollViewPager;
import com.yubaokang.baseframe.views.widgets.autoscrollviewpager.ImagePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {
    @BindView(R.id.ptrDefaultFrameLayout)
    PtrDefaultFrameLayout ptrDefaultFrameLayout;
    @BindView(R.id.recyclerView)
    RecycleEmptyErrorView recyclerView;

    @Inject
    HomeFragmentPresenter presenter;

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
        return R.layout.fragment_home_1;
    }

    private int pageNum = 1;

    private HomeAdapter1 homeAdapter1;

    @Override
    public void init(View view, @Nullable Bundle savedInstanceState) {
        datas = new ArrayList<>();
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter1 = new HomeAdapter1(getActivity(), R.layout.item_home, datas);
        homeAdapter1.addHeaderView(getHeaderView());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(homeAdapter1.adapter());

        presenter.start();

        homeAdapter1.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener<WeiXinDataListRes.Result.ListBean>() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                WeiXinDataListRes.Result.ListBean listBean = datas.get(position - 1);
                Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra(BaseWebActivity.URL, listBean.getUrl());
                startActivity(intent);
            }
        });

        homeAdapter1.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                pageNum++;
                presenter.loadDatas();
            }
        });

        ptrDefaultFrameLayout.setPtrHandler(new PtrDefaultHandler() {

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pageNum = 1;
                presenter.loadDatas();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, recyclerView, header);
            }
        });
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
        ptrDefaultFrameLayout.refreshComplete();
        List<WeiXinDataListRes.Result.ListBean> lists = weiXinDataListRes.getResult().getList();
        if (ListUtil.isNotEmpty(lists)) {
            initWheel(lists);
            if (pageNum == 1) {
                datas.clear();
                datas.addAll(lists);
                homeAdapter1.noMore(false);
                homeAdapter1.notifyDataSetChanged();
            } else {
                datas.addAll(lists);
                if (ListUtil.getCount(datas) > 50) {
                    homeAdapter1.noMore(true);
                }
                homeAdapter1.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showEmpty() {
        homeAdapter1.notifyDataSetChanged();
    }

    private List<WeiXinDataListRes.Result.ListBean> wheels;
    private AutoScrollViewPager viewPager;
    private LinearLayout container;

    public View getHeaderView() {
        View viewHeader = LayoutInflater.from(getActivity()).inflate(R.layout.home_header, null);
        viewPager = (AutoScrollViewPager) viewHeader.findViewById(R.id.viewPager);
        container = (LinearLayout) viewHeader.findViewById(R.id.container);
        return viewHeader;
    }

    public void initWheel(List<WeiXinDataListRes.Result.ListBean> lists) {
        wheels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            wheels.add(lists.get(i));//轮播借用
        }
        viewPager.setAdapter(new ImagePagerAdapter<WeiXinDataListRes.Result.ListBean>(getActivity(), wheels) {
            @Override
            public void setImageView(ImageView imageView, WeiXinDataListRes.Result.ListBean listBean, int position) {
                ImageUtils.showImage(listBean.getFirstImg(), imageView);
            }
        });
        viewPager.setOnPointIndex(5, container);
        viewPager.startAutoScroll();
    }
}
