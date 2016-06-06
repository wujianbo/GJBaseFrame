package com.yubaokang.baseframe.http;


import com.yubaokang.baseframe.model.response.BaseRes;
import com.yubaokang.baseframe.model.response.HomeWheelDataList;
import com.yubaokang.baseframe.model.response.StyleDataList;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hank on 2015/12/24/13:13:18
 */
public interface IRetrofitRequest {

    @GET("NAGoodsJson/getIndexStyle.html")
    Observable<BaseRes<List<StyleDataList>>> getStyleList();

    /**
     * 首页轮播页
     *
     * @return
     */
    @GET("NACustomerReservationJsonaaa/getRecommendImageList.html")
    Observable<BaseRes<List<HomeWheelDataList>>> getHomeWheel();
}
