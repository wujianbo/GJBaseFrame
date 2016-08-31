package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.mvp.BaseView;
import com.yubaokang.baseframe.base.mvp.BasePresenter;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

/**
 * Created by yubao on 2016/8/27.
 */

public interface HomeFragmentContract {
    interface Presenter extends BasePresenter {
        void loadDatas();
    }

    interface View extends BaseView<Presenter> {
        int loadPageNum();//获取当前页

        void showDatas(WeiXinDataListRes weiXinDataListRes);

        void showEmpty();
    }
}
