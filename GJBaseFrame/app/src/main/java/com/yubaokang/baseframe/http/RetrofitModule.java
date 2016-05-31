package com.yubaokang.baseframe.http;

import com.yubaokang.baseframe.utils.L;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hank on 2015/12/24/15:15:58
 */
@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public IRetrofitRequest getService() {
        //拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request authorised = request
                        .newBuilder()
                        .header("registeredChannels", "2")//来自1：iOS,2:Android,3:web
                        .build();
                return chain.proceed(authorised);
            }
        };
        //打印拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)//添加拦截器
                .addInterceptor(logging)//添加打印拦截器
                .connectTimeout(30, TimeUnit.SECONDS)//设置请求超时时间
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConst.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        L.i("------------>getService()");
        return retrofit.create(IRetrofitRequest.class);
    }
}

