package com.yubaokang.baseframe.http;

import com.yubaokang.baseframe.model.response.BaseRes;
import com.yubaokang.baseframe.model.response.BaseError;
import com.yubaokang.baseframe.utils.L;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by hank on 2015/12/28/13:13:56
 */

public abstract class RCallback2<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Gson gson = new Gson();
//        L.i(">>>>" + gson.toJson(response));
        L.i(">>>>返回" + response.raw().request().url() + ">>>>" + gson.toJson(response.body()));
        BaseRes baseRes = (BaseRes) response.body();
        if (baseRes != null) {
            if (baseRes.getReturnCode().equals("0000")) {
                onSuccess(response.body());
            } else {
                onFailed(new BaseError(baseRes.getMsg()));
            }
        } else {
            onFailed(new BaseError("网络错误"));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailed(new BaseError("网络错误"));
    }

    public abstract void onSuccess(T response);

    public abstract void onFailed(BaseError baseError);

}
