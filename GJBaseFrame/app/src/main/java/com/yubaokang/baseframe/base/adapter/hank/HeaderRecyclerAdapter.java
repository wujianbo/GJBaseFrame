package com.yubaokang.baseframe.base.adapter.hank;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.utils.ImageUtils;

import java.util.List;

/**
 * Created by yubao on 2016/8/29.
 */

public class HeaderRecyclerAdapter extends RecyclerView.Adapter {
    public final static int HEADER = 0;
    public final static int ITEM = 1;
    private List<WeiXinDataListRes.Result.ListBean> datas;

    public HeaderRecyclerAdapter(List<WeiXinDataListRes.Result.ListBean> datas) {
        this.datas = datas;
    }

    private boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderHolderView(header);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ItemHolderView(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isHeader(position)) {
            return;
        }
        WeiXinDataListRes.Result.ListBean data = datas.get(position - 1);
        ((ItemHolderView) holder).tv_title.setText(data.getTitle());
        ((ItemHolderView) holder).tv_from.setText(data.getSource());
        ImageUtils.showImage(data.getUrl(), ((ItemHolderView) holder).iv_img);
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? HEADER : ITEM;
    }

    private class HeaderHolderView extends RecyclerView.ViewHolder {
        TextView tv_header;

        HeaderHolderView(View itemView) {
            super(itemView);
            tv_header = (TextView) itemView.findViewById(R.id.tv_header);
        }
    }

    private class ItemHolderView extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_from;
        ImageView iv_img;

        ItemHolderView(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_from = (TextView) itemView.findViewById(R.id.tv_from);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }
}
