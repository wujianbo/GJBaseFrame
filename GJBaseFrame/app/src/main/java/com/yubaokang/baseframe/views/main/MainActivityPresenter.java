package com.yubaokang.baseframe.views.main;

import com.gj.base.lib.utils.L;
import com.yubaokang.baseframe.base.dagger.app.App;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.NewsDataRes;
import com.yubaokang.baseframe.model.response.WeatherDataRes;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by ybk on 2016/3/1.
 */
@ActivityScope
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
    public void apiCancel() {

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
//        new Function3<WeatherDataRes, NewsDataRes, WeiXinDataListRes>() {
//            @Override
//            public String call(WeatherDataRes weatherDataRes, NewsDataRes newsDataRes, WeiXinDataListRes weiXinDataListRes) {
//                return weatherDataRes.getResult().getData().getRealtime().getCity_name()
//                        + "--" + newsDataRes.getResult().getData().get(0).getTitle()
//                        + "--" + weiXinDataListRes.getResult().getList().get(0).getTitle();
//            }
//        }
        Flowable.zip(App.getComponent().request().getWeather("杭州"),
                App.getComponent().request().getNews("1", "top"),
                App.getComponent().request().getWeiXin("1"),
                new Function3<WeatherDataRes, NewsDataRes, WeiXinDataListRes, String>() {
                    @Override
                    public String apply(WeatherDataRes weatherDataRes, NewsDataRes newsDataRes, WeiXinDataListRes weiXinDataListRes) throws Exception {
                        return weatherDataRes.getResult().getData().getRealtime().getCity_name()
                                + "--" + newsDataRes.getResult().getData().get(0).getTitle()
                                + "--" + weiXinDataListRes.getResult().getList().get(0).getTitle();
                    }
                })
//                .compose(TransformerUtils.<String>applySchedulers())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onError(Throwable e) {
                        L.i("----------->onError");
                    }

                    @Override
                    public void onComplete() {
                        L.i("----------->onCompleted");
                    }

                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(String str) {
                        L.i("----------->" + str);
                        view.showSuccess();
                    }
                });
        List<String> list = Arrays.asList("list1", "list2", "", "list3");
        List<String> just = Arrays.asList("just1", "just2");
        Flowable.just(list).mergeWith(Flowable.just(just))
                .flatMap(new Function<List<String>, Publisher<String>>() {
                    @Override
                    public Publisher<String> apply(List<String> strings) throws Exception {
                        return Flowable.fromIterable(strings);
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return false;
                    }
                })
                .map(new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(String s) throws Exception {
                        return false;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<Boolean>() {
                    @Override
                    public void onNext(Boolean aBoolean) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Flowable//.just("aaa","ab","ca","d")
                .create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> e) throws Exception {
                        e.onNext("aaaa");
                        e.onNext("ab");
                        e.onNext("ca");
                        e.onNext("d");
                    }
                }, FlowableEmitter.BackpressureMode.BUFFER)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.contains("a");
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        L.i("-----2>" + s);
                    }
                });
        //顺序执行接口
        App.getComponent().request().getWeiXin("1")
                .doOnNext(new Consumer<WeiXinDataListRes>() {
                    @Override
                    public void accept(WeiXinDataListRes weiXinDataListRes) throws Exception {

                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {
                        view.showBegin();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .flatMap(new Function<WeiXinDataListRes, Publisher<WeatherDataRes>>() {
                    @Override
                    public Publisher<WeatherDataRes> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
                        L.i("------------>3-->1" + weiXinDataListRes.toString());
                        return App.getComponent().request().getWeather("杭州");
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<WeatherDataRes, Publisher<NewsDataRes>>() {
                    @Override
                    public Publisher<NewsDataRes> apply(WeatherDataRes weatherDataRes) throws Exception {
                        L.i("------------>3-->2" + weatherDataRes.toString());
                        return App.getComponent().request().getNews("1", "top");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsDataRes>() {
                    @Override
                    public void accept(NewsDataRes newsDataRes) throws Exception {
                        L.i("------------>3-->3" + newsDataRes.toString());
                        view.showEnd();
                    }
                });
    }
}
