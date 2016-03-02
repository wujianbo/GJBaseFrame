package com.gjw.gjbaseframe.http;


import com.gjw.gjbaseframe.model.response.LoginRes;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by hank on 2015/12/24/13:13:18
 */
public interface IRetrofitRequest {

    /**
     * 登录
     *
     * @param userName 用户名
     * @param userPwd  密码
     * @return
     */
    @FormUrlEncoded
    @POST("login.html")
    Call<LoginRes> login(@Field("userName") String userName, @Field("userPwd") String userPwd);

}
