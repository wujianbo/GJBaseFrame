package com.gjw.gjbaseframe.http;

/**
 * Created by hank on 2015/12/28/14:14:30
 */
public class UrlConst {
    //    public final static String URL = "http://phoneapi.goujiawang.com/";//发布地址
    public final static String URL = "http://nphoneapi.goujiawang.com/";//测试地址
    //public final static String URL = "http://192.168.1.92:8091/gjw-app/";//小叶地址
    //预约h5
    public final static String ORDER_URL = URL + "NAHTMLView/getReservationView.html?channels=2&userId=";//channels渠道1 ISO,2:Android,3:web，userId
    public final static String RESERVATION_RULE_URL = URL + "NAHTMLView/getGouJiaQuanRule.html";//构家券规则H5
}
