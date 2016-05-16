package com.gjw.gjbaseframe.dagger.presenter;

import com.gjw.gjbaseframe.dagger.contract.MainActivityContract;
import com.gjw.gjbaseframe.model.response.BaseRes;
import com.gjw.gjbaseframe.model.response.StyleDataList;
import com.gjw.gjbaseframe.views.AppApplication;

import java.util.List;

import javax.inject.Singleton;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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
        loadLogin();
    }

    @Override
    public void loadLogin() {
        AppApplication.get().getAppComponent().getService().getStyleList()
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
