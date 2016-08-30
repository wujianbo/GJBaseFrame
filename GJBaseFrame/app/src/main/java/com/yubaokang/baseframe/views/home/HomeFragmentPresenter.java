package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.hank.refresh.load.more.utils.L;
import com.yubaokang.baseframe.base.dagger.app.App;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.View view;
    private Observable<WeiXinDataListRes> call;

    public HomeFragmentPresenter(HomeFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        loadDatas();
    }

    @Override
    public void apiCancel() {
        call.unsubscribeOn(Schedulers.io());
    }

    @Override
    public void loadDatas() {
        call = App.getComponent().request().getWeiXin(view.loadPageNum() + "");
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeiXinDataListRes>() {
                    @Override
                    public void onCompleted() {
                        L.i("哈哈哈");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(WeiXinDataListRes weiXinDataListRes) {
                        view.showDatas(weiXinDataListRes);
                    }
                });
    }
}