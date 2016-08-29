package com.yubaokang.baseframe.views.home;

import android.content.Context;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.adapter.list.ViewHolder;
import com.yubaokang.baseframe.base.adapter.list.recyclerview.CommonAdapter;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import java.util.List;

/**
 * Created by yubaokang on 2016/8/29.
 */

public class HomeAdapter extends CommonAdapter<WeiXinDataListRes.Result.ListBean> {

    public HomeAdapter(Context context, List<WeiXinDataListRes.Result.ListBean> datas) {
        super(context, R.layout.item_home, datas);
    }

    @Override
    public void convert(ViewHolder holder, WeiXinDataListRes.Result.ListBean data) {
        holder.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_from, "来源：" + data.getSource())
                .setImageUrl(R.id.iv_img, data.getFirstImg());
    }
}
