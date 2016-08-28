package com.yubaokang.baseframe.dagger.contract;

import com.yubaokang.baseframe.dagger.presenter.BasePresenter;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

/**
 * Created by yubao on 2016/8/27.
 */

public interface HomeFragmentContract {
    interface Presenter extends BasePresenter {
    }

    interface View extends BaseView<HomeFragmentContract.Presenter> {
        int loadPageNum();//获取当前页

        void showDatas(WeiXinDataListRes weiXinDataListRes);
    }
}
