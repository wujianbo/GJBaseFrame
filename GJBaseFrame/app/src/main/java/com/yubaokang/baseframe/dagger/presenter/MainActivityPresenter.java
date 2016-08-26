package com.yubaokang.baseframe.dagger.presenter;

import com.yubaokang.baseframe.dagger.contract.MainActivityContract;
import com.yubaokang.baseframe.model.response.NewsDataRes;
import com.yubaokang.baseframe.model.response.WeatherDataRes;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;
import com.yubaokang.baseframe.rxjava.TransformerUtils;
import com.yubaokang.baseframe.utils.L;
import com.yubaokang.baseframe.views.App;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

/**
 * Created by ybk on 2016/3/1.
 */
@Singleton
public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        loadStyleList();
    }

    @Override
    public void loadStyleList() {
//        App.getComponent().request().getStyleList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRes<List<StyleDataList>>>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(BaseRes<List<StyleDataList>> listBaseRes) {
//                        view.showSuccess();
//                    }
//                });
        //同时执行
        Observable.zip(
                App.getComponent().request().getWeather("杭州"),
                App.getComponent().request().getNews("1", "top"),
                App.getComponent().request().getWeiXin("1"),
                new Func3<WeatherDataRes, NewsDataRes, WeiXinDataListRes, String>() {
                    @Override
                    public String call(WeatherDataRes weatherDataRes, NewsDataRes newsDataRes, WeiXinDataListRes weiXinDataListRes) {
                        return weatherDataRes.getResult().getData().getRealtime().getCity_name()
                                + "--" + newsDataRes.getResult().getData().get(0).getTitle()
                                + "--" + weiXinDataListRes.getResult().getList().get(0).getTitle();
                    }
                })
                .compose(TransformerUtils.<String>applySchedulers())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        L.i("----------->onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        L.i("----------->onError");
                    }

                    @Override
                    public void onNext(String str) {
                        L.i("----------->" + str);
                        view.showSuccess();
                    }
                });
        List<String> list = Arrays.asList("list1", "list2", "", "list3");
        Observable.from(list).mergeWith(Observable.just("just1", "just2"))
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.just(s);
                    }
                })
                //                .map(new Func1<String, Boolean>() {
                //                    @Override
                //                    public Boolean call(String s) {
                //                        return TextUtils.isEmpty(s);
                //                    }
                //                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.contains("3");
                    }
                })
                .compose(TransformerUtils.<String>applySchedulers())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        L.i("list__" + s);
                    }
                });
        Observable//.just("aaa","ab","ca","d")
                .create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("aaaa");
                        subscriber.onNext("ab");
                        subscriber.onNext("ca");
                        subscriber.onNext("d");
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.contains("a");
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        L.i("-----2>" + s);
                    }
                });
        //顺序执行接口
        App.getComponent().request().getWeiXin("1")
                .doOnNext(new Action1<WeiXinDataListRes>() {
                    @Override
                    public void call(WeiXinDataListRes weiXinDataListRes) {

                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showBegin();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .flatMap(new Func1<WeiXinDataListRes, Observable<WeatherDataRes>>() {
                    @Override
                    public Observable<WeatherDataRes> call(WeiXinDataListRes weiXinDataListRes) {
                        L.i("------------>3-->1" + weiXinDataListRes.toString());
                        return App.getComponent().request().getWeather("杭州");
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Func1<WeatherDataRes, Observable<NewsDataRes>>() {
                    @Override
                    public Observable<NewsDataRes> call(WeatherDataRes weatherDataRes) {
                        L.i("------------>3-->2" + weatherDataRes.toString());
                        return App.getComponent().request().getNews("1", "top");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsDataRes>() {
                    @Override
                    public void call(NewsDataRes newsDataRes) {
                        L.i("------------>3-->3" + newsDataRes.toString());
                        view.showEnd();
                    }
                });
    }
}
