package com.gjw.gjbaseframe.http;


import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hank on 2015/12/28/13:13:56
 */

public abstract class RCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
//      Gson gson = new Gson();
//      L.i(">>>>" + gson.toJson(response));
//      L.i(">>>>返回" + response.raw().request().httpUrl() + ">>>>" + gson.toJson(response.body()));
        onSuccess(response.body());
    }

    @Override
    public void onFailure(Throwable t) {
        Gson gson = new Gson();
        //L.i(">>>>失败" + t.toString());
    }

    public abstract void onSuccess(T response);

}
