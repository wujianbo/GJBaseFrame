package com.yubaokang.baseframe.http;


import com.yubaokang.baseframe.model.response.NewsDataRes;
import com.yubaokang.baseframe.model.response.WeatherDataRes;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hank on 2015/12/24/13:13:18
 */
public interface IRetrofitRequest {

    /**
     * 天气预报
     *
     * @param cityName
     * @return
     */
    @FormUrlEncoded
    @POST("http://op.juhe.cn/onebox/weather/query?key=dd88019df4220cc4929acbe013af42d5")
    Observable<WeatherDataRes> getWeather(@Field("cityname") String cityName);

    /**
     * 微信精选
     *
     * @param pno
     * @return
     */
    @FormUrlEncoded
    @POST("http://v.juhe.cn/weixin/query?key=b1d95432ce5be3b2d6f6bd64780b592d")
    Observable<WeiXinDataListRes> getWeiXin(@Field("pno") String pno);

    /**
     * 新闻头条
     *
     * @param pno
     * @param typeName 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     * @return
     */
    @FormUrlEncoded
    @POST("http://v.juhe.cn/toutiao/index?key=0c7bb0b02f3750d523e39ab8ad7ab373")
    Observable<NewsDataRes> getNews(@Field("pno") String pno, @Field("type") String typeName);

}
