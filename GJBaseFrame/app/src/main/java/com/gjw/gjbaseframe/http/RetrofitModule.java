package com.gjw.gjbaseframe.http;

import com.gjw.gjbaseframe.dagger.injectInterface.StringNamed;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by hank on 2015/12/24/15:15:58
 */
@Module
public class RetrofitModule {
    @StringNamed("1")
    @Provides
    @Singleton
    public IRetrofitRequest getService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("platform", "Android").addHeader("version", "2.2").build();
                return chain.proceed(newRequest);
            }
        };
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(15_000, TimeUnit.SECONDS);
        httpClient.interceptors().add(logging);
        httpClient.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConst.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(IRetrofitRequest.class);
    }

    @StringNamed("2")
    @Provides
    @Singleton
    public IRetrofitRequest getService1() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("platform", "Android").addHeader("version", "2.2").build();
                return chain.proceed(newRequest);
            }
        };
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(15_000, TimeUnit.SECONDS);
        httpClient.interceptors().add(logging);
        httpClient.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConst.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(IRetrofitRequest.class);
    }
}

