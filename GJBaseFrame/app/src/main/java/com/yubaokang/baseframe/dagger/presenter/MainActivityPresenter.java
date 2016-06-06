package com.yubaokang.baseframe.dagger.presenter;

import com.yubaokang.baseframe.dagger.contract.MainActivityContract;
import com.yubaokang.baseframe.model.response.BaseRes;
import com.yubaokang.baseframe.model.response.HomeWheelDataList;
import com.yubaokang.baseframe.model.response.StyleDataList;
import com.yubaokang.baseframe.utils.L;
import com.yubaokang.baseframe.views.App;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func4;
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
        Observable.zip(
                App.getComponent().request().getStyleList(),
                App.getComponent().request().getHomeWheel(),
                App.getComponent().request().getStyleList(),
                App.getComponent().request().getHomeWheel(),
                new Func4<BaseRes<List<StyleDataList>>, BaseRes<List<HomeWheelDataList>>, BaseRes<List<StyleDataList>>, BaseRes<List<HomeWheelDataList>>, String>() {
                    @Override
                    public String call(BaseRes<List<StyleDataList>> listBaseRes, BaseRes<List<HomeWheelDataList>> listBaseRes2, BaseRes<List<StyleDataList>> listBaseRes3, BaseRes<List<HomeWheelDataList>> listBaseRes4) {
                        return "哈哈哈";
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String str) {
                        L.i("----------->" + str);
                        view.showSuccess();
                    }
                });
    }
}
