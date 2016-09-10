package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;


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
        App.getComponent().request().getWeiXin(String.valueOf(view.loadPageNum()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .flatMap(new Function<WeiXinDataListRes, Publisher<WeiXinDataListRes>>() {
                    @Override
                    public Publisher<WeiXinDataListRes> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
                        if (weiXinDataListRes == null) {
                            return Flowable.error(new NullPointerException("解析错误"));
                        }
                        return Flowable.just(weiXinDataListRes);
                    }
                })
                .timeout(1000, TimeUnit.SECONDS, new Flowable<WeiXinDataListRes>() {
                    @Override
                    protected void subscribeActual(Subscriber<? super WeiXinDataListRes> s) {
                        s.onError(new Throwable());
                    }
                })
                .switchMap(new Function<WeiXinDataListRes, Publisher<?>>() {
                    @Override
                    public Publisher<?> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
                        return null;
                    }
                })
                .subscribe(new DefaultSubscriber<Object>() {
                    @Override
                    public void onNext(Object o) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//                .subscribe(new Subscriber<WeiXinDataListRes>() {
//                    @Override
//                    public void onComplete() {
//                        L.i("哈哈哈");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.showEmpty();
//                    }
//
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        subscription = s;
//                    }
//
//                    @Override
//                    public void onNext(WeiXinDataListRes weiXinDataListRes) {
//                        view.showDatas(weiXinDataListRes);
//                    }
//                });

    }
}