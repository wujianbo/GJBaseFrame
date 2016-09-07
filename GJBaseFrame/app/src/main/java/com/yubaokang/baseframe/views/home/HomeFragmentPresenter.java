package com.yubaokang.baseframe.views.home;

import com.gj.base.lib.utils.L;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.View view;
    private Subscription subscription;

    public HomeFragmentPresenter(HomeFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        loadDatas();
    }

    @Override
    public void apiCancel() {
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override
    public void loadDatas() {
        App.getComponent().request().getWeiXin(view.loadPageNum() + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeiXinDataListRes>() {
                    @Override
                    public void onComplete() {
                        L.i("哈哈哈");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showEmpty();
                    }

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                    }

                    @Override
                    public void onNext(WeiXinDataListRes weiXinDataListRes) {
                        view.showDatas(weiXinDataListRes);
                    }
                });
    }
}