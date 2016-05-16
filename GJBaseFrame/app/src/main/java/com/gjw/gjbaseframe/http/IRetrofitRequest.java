package com.gjw.gjbaseframe.http;


import com.gjw.gjbaseframe.model.response.BaseRes;
import com.gjw.gjbaseframe.model.response.StyleDataList;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hank on 2015/12/24/13:13:18
 */
public interface IRetrofitRequest {

    /**
     * 获取系列列表-首页-TabLayout
     *
     * @return
     */
    @GET("NAGoodsJson/getIndexStyle.html")
    Observable<BaseRes<List<StyleDataList>>> getStyleList();

}
