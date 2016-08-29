package com.yubaokang.baseframe.base.adapter.list.recyclerview;

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}