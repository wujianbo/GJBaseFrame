package com.yubaokang.baseframe.model.response;

/**
 * 首页轮播页
 * Created by Hank on 2016/4/28.
 */
public class HomeWheelDataList {

    /**
     * imagePath : http://timage.goujiawang.com/store/imagePath
     * urlPath : NAHTMLView/getRecommendationView
     */

    private String imagePath;
    private String urlPath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
