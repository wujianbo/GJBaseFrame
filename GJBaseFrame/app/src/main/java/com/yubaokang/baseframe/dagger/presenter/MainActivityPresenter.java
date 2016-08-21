package com.yubaokang.baseframe.dagger.presenter;

import com.yubaokang.baseframe.dagger.contract.MainActivityContract;
import com.yubaokang.baseframe.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.BaseRes;
import com.yubaokang.baseframe.model.response.StyleDataList;
import com.yubaokang.baseframe.views.App;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    public void loadStyleList() {
        App.getComponent().request().getStyleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseRes<List<StyleDataList>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showFailed();
                    }

                    @Override
                    public void onNext(BaseRes<List<StyleDataList>> listBaseRes) {
                        view.showSuccess();
                    }
                });
    }
}
