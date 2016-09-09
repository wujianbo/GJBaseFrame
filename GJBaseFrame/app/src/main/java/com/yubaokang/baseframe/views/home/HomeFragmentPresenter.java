package com.yubaokang.baseframe.views.home;

import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeatherDataRes;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
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
        Flowable.merge(
                App.getComponent().request().getWeiXin(String.valueOf(view.loadPageNum())),
                App.getComponent().request().getWeiXin("杭州"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeiXinDataListRes>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(WeiXinDataListRes weiXinDataListRes) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        Flowable.zipArray()
        App.getComponent().request().getWeiXin(String.valueOf(view.loadPageNum()))
                .zipWith(App.getComponent().request().getWeather(String.valueOf(view.loadPageNum())), new BiFunction<WeiXinDataListRes, WeatherDataRes, String>() {
                    @Override
                    public String apply(WeiXinDataListRes weiXinDataListRes, WeatherDataRes weatherDataRes) throws Exception {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<String>() {
                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        App.getComponent().request().getWeiXin(String.valueOf(view.loadPageNum()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(new Function<Throwable, Publisher<? extends WeiXinDataListRes>>() {
                    @Override
                    public Publisher<? extends WeiXinDataListRes> apply(Throwable throwable) throws Exception {
                        return null;
                    }
                })
                .flatMap(new Function<WeiXinDataListRes, Publisher<WeiXinDataListRes>>() {
                    @Override
                    public Publisher<WeiXinDataListRes> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
                        if (weiXinDataListRes == null) {
                            return Flowable.error(new NullPointerException("解析错误"));
                        }
                        return Flowable.just(weiXinDataListRes);
                    }
                })
                .concatMap(new Function<WeiXinDataListRes, Publisher<WeiXinDataListRes>>() {
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
                .subscribe(new Subscriber<WeiXinDataListRes>() {
                    @Override
                    public void onComplete() {
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