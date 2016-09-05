package com.yubaokang.baseframe.views.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.views.BaseFragment;

public class Home2Fragment extends BaseFragment {
//    @BindView(R.id.ptrDefaultFrameLayout)
//    PtrDefaultFrameLayout ptrDefaultFrameLayout;
//    @BindView(R.id.nestedScrollView)
//    NestedScrollView nestedScrollView;
//    @BindView(R.id.appbar)
//    AppBarLayout appbar;

    public static Home2Fragment newInstance() {
        return new Home2Fragment();
    }

    @Override
    public void providers() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_fragments2;
    }

    @Override
    public void init(View view, @Nullable Bundle savedInstanceState) {
//        ptrDefaultFrameLayout.setPtrHandler(new PtrDefaultHandler() {
//            @Override
//            public void onRefreshBegin(PtrFrameLayout frame) {
//
//            }
//
//            @Override
//            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
//                return super.checkCanDoRefresh(frame, nestedScrollView, header);
//            }
//        });
//        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//
//            }
//        });
    }

    @Override
    public void apiCancel() {
    }

    @Override
    public View getCurrentLayout() {
        return null;
    }

}
