package com.hank.refresh.load.more.adapter.my;

import android.content.Context;

import com.hank.refresh.load.more.adapter.CommonAdapter;
import com.hank.refresh.load.more.adapter.MultiItemTypeAdapter;
import com.hank.refresh.load.more.adapter.base.ViewHolder;
import com.hank.refresh.load.more.adapter.wrapper.LoadMoreWrapper;

import java.util.List;

/**
 * LoadMoreAdapter = CommonAdapter + LoadMoreWrapper ; // 加载更多
 * Created by yubaokang on 2016/8/31.
 */
public abstract class LoadMoreAdapter<T> {
    private Context context;
    private int layoutId;
    private List<T> datas;
    private CommonAdapter<T> adapter;
    private LoadMoreWrapper loadMoreWrapper;

    public LoadMoreAdapter(Context context, int layoutId, List<T> datas) {
        this.context = context;
        this.layoutId = layoutId;
        this.datas = datas;
        adapter = new CommonAdapter<T>(context, layoutId, datas) {
            @Override
            protected void convert(ViewHolder holder, T t, int position) {
                LoadMoreAdapter.this.convert(holder, t, position);
            }
        };
        loadMoreWrapper = new LoadMoreWrapper(adapter);
    }

    public LoadMoreWrapper adapter() {
        return loadMoreWrapper;
    }

    public void setOnItemClickListener(MultiItemTypeAdapter.OnItemClickListener<T> itemClickListener) {
        adapter.setOnItemClickListener(itemClickListener);
    }

    public void setOnItemLongClickListener(MultiItemTypeAdapter.OnItemLongClickListener<T> itemLongClickListener) {
        adapter.setOnItemLongClickListener(itemLongClickListener);
    }

    public void setOnLoadMoreListener(LoadMoreWrapper.OnLoadMoreListener onLoadMoreListener) {
        loadMoreWrapper.setOnLoadMoreListener(onLoadMoreListener);
    }

    public void noMore(boolean isNoMore) {
        loadMoreWrapper.noMore(isNoMore);
    }

    public void notifyDataSetChanged() {
        loadMoreWrapper.notifyDataSetChanged();
    }

    public abstract void convert(ViewHolder holder, T t, int position);
}
